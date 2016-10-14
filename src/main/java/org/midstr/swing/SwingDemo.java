package org.midstr.swing;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class SwingDemo extends JFrame {
	
	private static final long serialVersionUID = -4419132959436874509L;
	
	JLabel label;

	public SwingDemo() {
		super("Hello World!");
		label = new JLabel("A label");
		add(label);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 100);
		setVisible(true);
	}
	
	static SwingDemo swingDemo;

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				swingDemo = new SwingDemo();
			}
		});
		TimeUnit.SECONDS.sleep(2);
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				swingDemo.label.setText("I'm changing.....");
			}
		});
	}

}
