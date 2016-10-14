package org.midstr.thread.sync;

import java.util.HashMap;
import java.util.Map;

public class SynMethod {
	
	private Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
	
	public synchronized void getFirstSun() {
		for (int i = 0; i < 100; i++) {
			System.out.println("first making " + i);
			cache.put(i, i);
		}
	}
	
	public synchronized void getSecondSun() {
		for (int i = 0; i < 100; i++) {
			System.out.println("second making " + (i + 1000));
			cache.put(i + 1000, i + 1000);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testMore();
//		testOne();
	}

	/**
	 * 
	 */
	public static void testMore() {
		final SynMethod syn = new SynMethod();
		Thread t1 = new Thread() {
			public void run() {
				syn.getFirstSun();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				syn.getSecondSun();
			}
		};
		t1.start();
		t2.start();
	}
	
	public static void testOne() {
		final SynMethod syn = new SynMethod();
		Thread t1 = new Thread() {
			public void run() {
				syn.getFirstSun();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				syn.getFirstSun();
			}
		};
		t1.start();
		t2.start();
	}

}
