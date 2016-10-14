package org.midstr.thread.deadlock;

public class DeadLockDemo {
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	static class A implements Runnable {
		public void run() {
			synchronized (lock1) {
				// Thread.sleep(1000);
				System.out.println(this.getClass().getName());
				synchronized (lock2) {
					// Thread.sleep(1000);
					System.out.println(this.getClass().getName());
				}
			}
		}
	}

	static class B implements Runnable {
		public void run() {
			synchronized (lock2) {
				// Thread.sleep(1000);
				System.out.println(this.getClass().getName());
				synchronized (lock1) {
					// Thread.sleep(1000);
					System.out.println(this.getClass().getName());
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Thread a = new Thread(new A());
		Thread b = new Thread(new B());
		a.start();
		b.start();
		a.join();
		b.join();
	}
}
