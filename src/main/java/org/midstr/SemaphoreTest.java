package org.midstr;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author yaogangli
 * @date 2013-6-18 下午12:18:47
 */
public class SemaphoreTest {
	
	private final static Semaphore semaphore = new Semaphore(2);
	
	
	public void send() {
		try {
			semaphore.acquire();
			System.out.println("succ");
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService exe = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			exe.execute(new Runnable() {
				
				@Override
				public void run() {
					SemaphoreTest test = new SemaphoreTest();
					test.send();
				}
			});
		}
		exe.shutdown();
	}

}
