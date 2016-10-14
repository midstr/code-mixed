package org.midstr.thread.sync;


public class SynObject {

	// 有时候这里就是我们经常用到的Map，注意需要在所有访问的地方（包括读写）加上锁，否认还是会出现不同步的情况
	// 比如下面两个方法去掉任意一个synchronized，还是会出错

	Object lock = new Object();

	public void getFirstSun() {
		synchronized (lock) {
			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() +  " making first sun...");
			}
		}
	}

	public void getSecondSun() {
		synchronized (lock) {
			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() +  " making second sun...");
			}
		}
	}

	public static void main(String[] args) {
		// 不同线程访问不同方法
		//testMore(); 
		// 不同线程访问同一方法
		testOne();
	}

	/**
	 * 
	 */
	public static void testMore() {
		final SynObject oLock = new SynObject();
		Thread t1 = new Thread() {
			public void run() {
				oLock.getFirstSun();
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				oLock.getSecondSun();
			}
		};
		t1.start();
		t2.start();
	}
	
	public static void testOne() {
		final SynObject oLock = new SynObject();
		Thread t1 = new Thread() {
			public void run() {
				oLock.getFirstSun();
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				oLock.getFirstSun();
			}
		};
		t1.start();
		t2.start();
	}

}
