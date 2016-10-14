 	package org.midstr.nio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NIOClient {
	static int SIZE = 100;
	static InetSocketAddress ip = new InetSocketAddress("localhost", 12345);
	//static CharsetEncoder encoder = Charset.forName("GB2312").newEncoder();

	static class Download implements Runnable {
		protected int index;
		CharsetEncoder encoder = Charset.forName("GB2312").newEncoder();
		
		public Download(int index) {
			this.index = index;
		}

		public void run() {
			try {
				File file = new File("d:\\temp\\nio\\" + index  + ".txt");
				FileOutputStream fos = new FileOutputStream(file);
				
				long start = System.currentTimeMillis();
				SocketChannel client = SocketChannel.open();
				
				client.configureBlocking(false);
				Selector selector = Selector.open();
				client.register(selector, SelectionKey.OP_CONNECT);
				client.connect(ip);
				ByteBuffer buffer = ByteBuffer.allocate(8 * 1024);
				int total = 0;
				FOR: for (;;) {
					selector.select();
					Iterator<SelectionKey> iter = selector.selectedKeys()
							.iterator();
					while (iter.hasNext()) {
						SelectionKey key = iter.next();
						iter.remove();
						if (key.isConnectable()) {
							SocketChannel channel = (SocketChannel) key
									.channel();
							if (channel.isConnectionPending())
								channel.finishConnect();
							channel.write(encoder.encode(CharBuffer
									.wrap("Hello from " + index)));
							channel.register(selector, SelectionKey.OP_READ);
						} else if (key.isReadable()) {
							SocketChannel channel = (SocketChannel) key
									.channel();
							int count = channel.read(buffer);
							if (count > 0) {
								total += count;
								fos.write(buffer.array());
								fos.flush();
								buffer.clear();
							} else {
								client.close();
								break FOR;
							}
						}
					}
				}
				fos.close();
				double last = (System.currentTimeMillis() - start) * 1.0 / 1000;
				System.out.println("Thread " + index + " downloaded " + total
						+ "bytes in " + last + "s.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// 客户端100个并发下载
		ExecutorService exec = Executors.newFixedThreadPool(SIZE);
		for (int index = 0; index < SIZE; index++) {
			exec.execute(new Download(index));
		}
		exec.shutdown();
	}
}
