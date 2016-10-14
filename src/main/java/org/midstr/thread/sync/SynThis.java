package org.midstr.thread.sync;

import java.util.HashMap;
import java.util.Map;

public class SynThis {
	private Map<Integer, Integer> cache = new HashMap<Integer, Integer>();

	public void getFirstSun() {
		System.out.println("begin to getFirstSun");
		synchronized (this) {
			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() + " first making " + i);
				cache.put(i, i);
			}
		}
		System.out.println("end to getFirstSun");
	}

	public void getSecondSun() {
		System.out.println("begin to getSecondSun");
		synchronized (this) {
			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() + " second making " + i);
				cache.put(i, i);
			}
		}
		System.out.println("end to getSecondSun");
	}
	
	public synchronized void getThirdSun() {
		System.out.println("begin to getThirdSun");
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()
					+ " third making " + i);
			cache.put(i, i);
		}
		System.out.println("end to getThirdSun");
	}
	
	public void getFourthSun() {
		System.out.println("begin to getFourthSun");
		synchronized (cache) {
			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName()
						+ " third making " + i);
				cache.put(i, i);
			}
		}
		System.out.println("end to getFourthSun");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SynThis syn = new SynThis();
		
//		Thread t1 = new Thread(syn.new FirstSun());
//		Thread t2 = new Thread(syn.new SecondSun());
//		t1.start();
//		t2.start();
		
//		Thread t1 = new Thread(syn.new FirstSun());
//		Thread t2 = new Thread(syn.new FirstSun());
//		t1.start();
//		t2.start();
		
		Thread t1 = new Thread(syn.new FirstSun());
		Thread t2 = new Thread(syn.new ThirdSun());
		Thread t3 = new Thread(syn.new FourthSun());
		t1.start();
		t2.start();
		t3.start();
		
		
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
