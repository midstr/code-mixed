package org.midstr.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author yaogangli
 * @date 2013-6-26 下午2:48:38
 */
public class FileChannelTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		RandomAccessFile aFile = new RandomAccessFile("d:/test.txt", "rw");
		FileChannel inChannel = aFile.getChannel();
		ByteBuffer buf = ByteBuffer.allocate(3);
		
		int bytesRead = inChannel.read(buf);
		while (bytesRead != -1) {

			System.out.print("Read " + bytesRead + ":");
			buf.flip();

			while (buf.hasRemaining()) {
				System.out.print((char) buf.get());
			}
			System.out.println();

			buf.clear();
			bytesRead = inChannel.read(buf);
		}
		aFile.close();
	}
}
