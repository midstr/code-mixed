package org.midstr.thread.sync;

import java.util.HashMap;
import java.util.Map;

public class SynClass {
	private Map<Integer, Integer> cache = new HashMap<Integer, Integer>();

	public void getFirstSun() {
		synchronized (SynClass.class) {
			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName()
						+ " first making " + i);
				cache.put(i, i);
			}
		}
	}
	
	public void getSecondSun() {
		synchronized (this) {
			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName()
						+ " second making " + i);
				cache.put(i, i);
			}
		}
	}
	
	public synchronized void getThirdSun() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()
					+ " third making " + i);
			cache.put(i, i);
		}
	}

	public void getFourthSun() {
			synchronized (cache) {
				for (int i = 0; i < 100; i++) {
					System.out.println(Thread.currentThread().getName() + " fourth making " + i);
					cache.put(i, i);
				}
			}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//synchronized (SynClass.class) 类锁，针对该类的所有实例对象(和static类似)
//		SynClass syn = new SynClass();
//		Thread t1 = new Thread(syn.new FirstSun(), "t1");
//		SynClass syn2 = new SynClass();
//		Thread t11 = new Thread(syn2.new FirstSun(), "t11");
//		t1.start();
//		t11.start();
		
		// synchronized (this) 和 synchronized(object)对象锁，针对本对象
		// 如果后者的object是一个全局的static，就是一个全局对象锁
//		SynClass syn = new SynClass();
//		Thread t1 = new Thread(syn.new SecondSun(), "t1");
//		SynClass syn2 = new SynClass();
//		Thread t11 = new Thread(syn2.new SecondSun(), "t11");
//		t1.start();
//		t11.start();
		
		// synchronized method 方法锁，针对本对象
//		SynClass syn = new SynClass();
//		Thread t1 = new Thread(syn.new ThirdSun(), "t1");
//		SynClass syn2 = new SynClass();
//		Thread t11 = new Thread(syn2.new ThirdSun(), "t11");
//		t1.start();
//		t11.start();
		
		// 另外注意：synchronized method等价于synchronized(this)
		// 其实就两者synchronized：synchronized方法和synchronized代码块
		// 并且这两者之间是不会互斥，只有同类型的锁才互斥
		
	}

	private class FirstSun implements Runnable {
		public void run() {
			getFirstSun();
		}
	}

	private class SecondSun implements Runnable {
		public void run() {
			getSecondSun();
		}
	}

	private class ThirdSun implements Runnable {
		public void run() {
			getThirdSun();
		}
	}

	private class FourthSun implements Runnable {
		public void run() {
			getFourthSun();
		}
	}

}
