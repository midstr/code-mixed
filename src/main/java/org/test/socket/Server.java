package org.test.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yaogangli
 * @date 2013-5-16 下午3:15:37
 */
public class Server {
	private ServerSocket ss;

	public void start() {
		try {
			ss = new ServerSocket(10000);
			System.out.println("server start.....");
			while (true) {
				final Socket socket = ss.accept();
				new Thread(new Runnable() {

					@Override
					public void run() {
						try {
							BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
							PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
							// 接受数据
							String line = in.readLine();
							System.out.println("receive:" + line);
							// 处理并返回处理过的数据
							out.println("you input is :" + line);
							out.close();
							in.close();
							socket.close();
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				}).start();

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Server().start();
	}
}
