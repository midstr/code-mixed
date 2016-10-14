package org.midstr.thread.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskDemo {

	public static void main(String[] args) {
		Timer timer = new Timer("my timer");
		System.out.println(new Date());
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()
						+ " === " + new Date());
//				try {
//					TimeUnit.SECONDS.sleep(10);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
			}
		}, 1000, 5000);
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()
						+ " *** " + new Date());
			}
		}, 2000, 5000);
		// timer.schedule(task, time)
	}
}
