package org.midstr.net;

/*
 * Ping.java
 *
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * 
 * @author Li-Qiang
 */
public class ExePing {

	/** Creates a new instance of Ping */
	public ExePing() {
	}

	public static void main(String args[]) throws IOException {
		String msg = "连上网了.....";
		//ping();
		//continuedPing();
//		alert(msg);
		show(msg);
	}
	
	public static void continuedPing() throws IOException {
		for (;;) {
			Process process = Runtime.getRuntime().exec("ping www.baidu.com");
			BufferedReader buf = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = buf.readLine()) != null) {
				sb.append(line);
			}
			if (sb.toString().indexOf("Ping request could not find host") != -1) {
				System.out.println(sb.toString());
				
				//JF
				break;
			}
		}
	}
	
	public static void show(String msg) {
//		JFrame frame = new JFrame();
//		frame.setTitle(msg);
//		frame.setAlwaysOnTop(true);
//		frame.setSize(400, 300);
//		frame.setVisible(true);
		
		JOptionPane.showMessageDialog(null, msg);
//		JOptionPane.showConfirmDialog(null, msg);
	}
	
	public static void alert(String msg) {
		JDialog dialog = new JDialog();
		dialog.setTitle(msg);
		dialog.setAlwaysOnTop(true);
		dialog.setSize(200, 200);
		dialog.setVisible(true);
		//JOptionPane.showMessageDialog(parentComponent, message)
	}

	/**
	 * 
	 */
	private static void ping() {
		String[] addrs = { "www.sina.com.cn", "www.sohu.com", "www.baidu.com" };
		if (addrs.length < 1) {
			System.out.println("syntax Error!");
		} else {

			for (int i = 0; i < addrs.length; i++) {
				String line = null;
				try {
					Process pro = Runtime.getRuntime().exec("ping " + addrs[i]);
					BufferedReader buf = new BufferedReader(
							new InputStreamReader(pro.getInputStream()));
					while ((line = buf.readLine()) != null)
						System.out.println(line);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
