package org.midstr.thread.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

	private ReadWriteLock locks = new ReentrantReadWriteLock();

	// 读锁
	private Lock readLock = locks.readLock();

	// 写锁
	private Lock writeLock = locks.writeLock();

	// 互斥锁
	private ReentrantLock lock = new ReentrantLock();

	// 数据
	private List<String> testData = new ArrayList<String>();

	/**
	 * 如果不加同步或者锁，则多线程运行可能报错
	 */
	public void readData() {
		readLock.lock();
		for (String data : testData) {
			System.out.println(Thread.currentThread().getName()
					+ " read data : " + data);
		}
		readLock.unlock();
	}

	public void writeData() {
		writeLock.lock();
		Random r = new Random();
		String value = String.valueOf(r.nextInt());
		testData.add(value);
		System.out.println(Thread.currentThread().getName() + " write data : "
				+ value);
		writeLock.unlock();
	}

	public static void main(String[] args) {

		final ReadWriteLockTest test = new ReadWriteLockTest();
		for (int i = 0; i < 10; i++) {
			test.writeData();
		}

		Thread readThread = new Thread(new Runnable() {
			public void run() {
				test.readData();
			}
		});

		Thread writeThread = new Thread(new Runnable() {
			public void run() {
				test.writeData();
			}
		});
		Thread t1 = new Thread(readThread, "read1");
		Thread t2 = new Thread(readThread, "read2");
		Thread t3 = new Thread(writeThread, "write1");
		Thread t4 = new Thread(writeThread, "write2");

		t1.start();
		t3.start();
		t2.start();
		t4.start();
	}

}
