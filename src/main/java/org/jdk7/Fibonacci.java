package org.jdk7;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author yaogangli
 * @date 2013-4-24 下午4:40:40
 */
public class Fibonacci extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 1L;
	private final int n;

	/**
	 * 
	 */
	public Fibonacci(int n) {
		this.n = n;
	}

	/* (non-Javadoc)
	 * @see java.util.concurrent.RecursiveTask#compute()
	 */
	@Override
	protected Integer compute() {
		if (n <= 1)
			return n;
		Fibonacci f1 = new Fibonacci(n - 1);
		f1.fork();
		Fibonacci f2 = new Fibonacci(n - 2);
//		f2.fork();
		return f2.compute() + f1.join();
//		return f1.join() + f2.join();
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		long time = System.currentTimeMillis();
		Fibonacci f = new Fibonacci(20);
		ForkJoinPool pool = new ForkJoinPool();
		pool.execute(f);
		for(;;) {
			System.out.println(pool);
			if (f.isDone()) {
				System.out.println(System.currentTimeMillis() - time);
				System.out.println(f.get());
				break;
			}
		}
		//System.out.println(f.get());
	}
}
