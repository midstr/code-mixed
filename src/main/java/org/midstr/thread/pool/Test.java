package org.midstr.thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yaogangli
 * @date 2013-6-9 上午10:03:05
 */
public class Test {

	/**
	 * @param args
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws Exception {
		//		ExecutorService exec = Executors.newFixedThreadPool(5);
		//		Future<?> runFuture = exec.submit(new RunnableTask());
		//		System.out.println(runFuture.get());
		//
		//		Future<String> future = exec.submit(new CallableTask());
		//		System.out.println(future.get());
		//		exec.shutdown();

		ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 0, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(100), new ThreadPoolExecutor.DiscardPolicy());
		pool = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(1), new RejectedExecutionHandler() {
					
					@Override
					public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
						executor.submit(r);
					}
				});
		
		for (int i = 0; i < 10; i++) {
			pool.submit(new CallableTask());
			int size = pool.getQueue().size();
			System.out.println(size);

		}
		pool.shutdown();
	}

	private static class RunnableTask implements Runnable {
		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			System.out.println("RunnableTask");
		}
	}

	private static class CallableTask implements Callable<String> {
		/* (non-Javadoc)
		 * @see java.util.concurrent.Callable#call()
		 */
		@Override
		public String call() throws Exception {
			TimeUnit.SECONDS.sleep(1);
			System.out.println("CallableTask");
			return "call";
		}
	}

}
