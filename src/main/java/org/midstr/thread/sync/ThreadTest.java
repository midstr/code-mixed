package org.midstr.thread.sync;

public class ThreadTest {
	public static void main(String[] args) {
		//noSync();
		
		syncThis();
	}

	public static void noSync() {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println(Thread.currentThread().getName()
							+ " synchronized loop " + i);
				}
			}
		});
		Thread ta = new Thread(t1, "A");
		Thread tb = new Thread(t1, "B");
		ta.start();
		tb.start();
	}
	
	public static void syncThis() {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				//synchronized (ThreadTest.class) {
				synchronized (this) {
					for (int i = 0; i < 5; i++) {
						System.out.println(Thread.currentThread().getName()
								+ " synchronized loop " + i);
					}
				}
			}
		});
		Thread ta = new Thread(t1, "A");
		Thread tb = new Thread(t1, "B");
		ta.start();
		tb.start();
	}
}
