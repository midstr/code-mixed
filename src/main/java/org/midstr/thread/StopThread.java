package org.midstr.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author yaogangli
 * @date 2011-10-11 下午03:16:50
 */
public class StopThread{
	
	private static boolean stop;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		Thread t = new Thread(new Runnable() {
			
			public void run() {
				int i = 0;
				while (!stop) {
					i++;
				}
			}
		});
		t.start();
		TimeUnit.SECONDS.sleep(2);
		stop = true;
		//t.stopThread();
	}

}
