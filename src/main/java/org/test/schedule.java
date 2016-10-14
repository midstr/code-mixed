package org.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yaogangli
 * @date 2011-10-24 上午10:27:29
 */
public class schedule {

	public static final ScheduledExecutorService ASYNC_SED_TASK_EXEC = Executors.newScheduledThreadPool(1);

	public static final AtomicInteger count = new AtomicInteger(0);

	public static boolean refresh(String id) {
		String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
		System.out.println(id + " " + time + " = " + count.incrementAndGet());
		if (count.get() < 15) {
			return false;
		}
		if (count.get() > 15 && count.get() < 23) {
			return true;
		}
		if (count.get() > 26 && count.get() < 40) {
			return false;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ASYNC_SED_TASK_EXEC.scheduleAtFixedRate(new Runnable() {

			private ScheduledFuture<?> future = null;

			@Override
			public void run() {
				if (!refresh("main")) {
					if (future == null || future.isCancelled()) {
						future = ASYNC_SED_TASK_EXEC.scheduleAtFixedRate(new Runnable() {
							@Override
							public void run() {
								if (refresh("sub")) {
									if (future != null && !future.isCancelled()) {
										System.out.println("future = " + future.hashCode() + " be canceled");
										future.cancel(true);
										future = null;
									}
								}
							}
						}, 0, 1, TimeUnit.SECONDS);
						System.out.println("future = " + future.hashCode() + " be started");
					}
				}
			}
		}, 0, 10, TimeUnit.SECONDS);
	}

}
