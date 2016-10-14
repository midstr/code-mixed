package org.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author yaogangli
 * @date 2014-5-14 下午4:16:38
 */
public class CyclicBarrierDemo {

	private CyclicBarrier barrier;
	private int max;

	/**
	 * 
	 */
	public CyclicBarrierDemo(int max) {
		this.max = max;
		this.barrier = new CyclicBarrier(max, new Runnable() {

			@Override
			public void run() {
				System.out.println("all end!");
			}
		});
	}

	public void invoke() {
		for (int i = 0; i < max; i++) {
			new Thread(new Worker(i)).start();
		}
		//System.out.println("end of invoke");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CyclicBarrierDemo cbd = new CyclicBarrierDemo(5);
		cbd.invoke();
	}

	class Worker implements Runnable {
		private final int id;

		/**
		 * 
		 */
		public Worker(int id) {
			this.id = id;
		}

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			long r = Math.round(Math.random() * 1000000);
			System.out.println(id + " start..." + r);
			for (int i = 0; i < r; i++) {
			}
			System.out.println(id + " end...");
			try {
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}
}
