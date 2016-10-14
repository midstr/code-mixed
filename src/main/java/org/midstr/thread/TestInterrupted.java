package org.midstr.thread;

import java.util.concurrent.TimeUnit;


/**
 * 并发编程的两个范畴：可见性、互斥性
 * @author yaogangli
 * @date 2011-10-11 下午02:47:38
 */
public class TestInterrupted {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		SleepThread st = new SleepThread();
		st.start();
		TimeUnit.SECONDS.sleep(2);
		System.out.println("try to stop st....");
		st.interrupt();
	}

	static class SleepThread extends Thread {
		@Override
		public void run() {
			try {
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException e) {
				System.out.println("st was interrupted..");
			}
		}
	}
}
