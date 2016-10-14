package org.midstr.net;

/*
 * Ping.java
 *
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import java.applet.AudioClip;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 */
public class ContinuePing extends JFrame implements Ping{
	
	private static final String DEFAULT_MSG = "上网喽";
	private static final String BAIDU = "www.baidu.com";
	private static final String HTTP = "http://";

	private final class DefaultWindowAdapter extends WindowAdapter {
		@Override
		public void windowActivated(WindowEvent e) {
			activatedMsg();
		}

		@Override
		public void windowIconified(WindowEvent e) {
			hasShow = false;
			stopPlay();
		}
	}

	private static final long serialVersionUID = 1L;
	public String msg = DEFAULT_MSG;
	private String host;
	private int port = 80;
	private boolean hasShow = false;;
	private boolean connected = false;

	private AudioClip ac;

	/** Creates a new instance of Ping */
	public ContinuePing(String host) {
		this.setHost(host);
		init();
		URL audio = ContinuePing.class.getResource("Audio.wav");

		// File file = new
		// File("D:\\workspace\\ContinuePing\\sound\\Audio.wav");
		// URL audio = null;
		// try {
		// audio = file.toURL();
		// } catch (MalformedURLException e) {
		// e.printStackTrace();
		// }

		if (audio != null) {
			ac = JApplet.newAudioClip(audio);
		}
	}

	public static void main(String[] args) throws IOException,
			InterruptedException {
		String host = BAIDU;
		// String host = "localhost";
		if (args.length > 0) {
			host = args[0];
		}
		ContinuePing ping = new ContinuePing(host);
		ping.startURL();
		// ping.startSocket();
		// ping.startWindows();
	}
	
	public void startURL() throws MalformedURLException {
		URL url = new URL(HTTP + getHost());
		while (!connected) {
			try {
				System.out.print("try to connecting......");
				URLConnection conn = url.openConnection();
				conn.connect();
				BufferedReader in = new BufferedReader(new InputStreamReader(
						conn.getInputStream()));
				System.out.println(in.readLine());
				afterConnected();
				System.out.println("connected!!!");
			} catch (IOException e) {
				System.out.println("but time out");
				delay();
			}
		}
	}

	public void startSocket() {
		while (!connected) {
			try {
				System.out.print("try to connecting......");
				InetSocketAddress address = new InetSocketAddress(InetAddress
						.getByName(getHost()), port);
				new Socket(address.getAddress(), address.getPort());
				afterConnected();
				System.out.println("connected!!!");
			} catch (IOException e) {
				System.out.println("but time out");
				delay();
			}
		}
	}

	private void delay() {
		// 延时10秒
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e1) {
		}
	}

	public void startNioChannels() {
		throw new UnsupportedOperationException("unsuport startNioChannels");
	}

	public void startWindows() throws IOException, InterruptedException {
		while (!connected) {
			Process process = Runtime.getRuntime().exec("ping " + getHost());
			BufferedReader buf = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = buf.readLine()) != null) {
				sb.append(line);
			}
			System.out.println(sb.toString());
			delay();
			if (sb.toString().indexOf("Ping request could not find host") == -1
					|| sb.toString().indexOf("unreachable") == -1) {
				afterConnected();
			}
		}
	}

	protected void afterConnected() {
		connected = true;
		loopPlay();
		setVisible(true);
	}

	private void loopPlay() {
		if (ac != null) {
			ac.loop();
		}
	}

	private void stopPlay() {
		if (ac != null) {
			ac.stop();
		}
	}

	protected void init() {
		setTitle(msg);
		setAlwaysOnTop(true);
		setSize(400, 300);
		setFocusable(true);
		setLocationRelativeTo(null);

		addWindowListener(new DefaultWindowAdapter());
	}

	protected void activatedMsg() {
		loopPlay();
		if (!hasShow) {
			int result = JOptionPane.showConfirmDialog(this, msg, "",
					JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				close();
			} else {
				setExtendedState(ICONIFIED);
			}
			hasShow = true;
		}
	}

	protected void close() {
		dispose();
		System.exit(0);
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}
