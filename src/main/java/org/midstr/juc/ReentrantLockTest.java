package org.midstr.juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yaogangli
 * @date 2013-6-27 下午3:47:29
 */
public class ReentrantLockTest {

	private int number = 0;

	private ReentrantLock lock = new ReentrantLock();

	public void add() {
		try {
			lock.lock();
			number++;
		} finally {
			lock.unlock();
		}
	}

	public int get() {
		try {
			lock.lock();
			return number;
		} finally {
			lock.unlock();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReentrantLockTest test = new ReentrantLockTest();
		test.add();
		test.get();
	}

}
