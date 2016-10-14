package org.midstr.designPattern.observer;

import java.util.Observer;

/**
 * @author yaogangli
 * @date 2013-7-9 下午2:41:37
 */
public class MyApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// create an event source - reads from stdin
		final EventSource eventSource = new EventSource();

		// create an observer
		final Observer responseHandler = new ResponseHandler();

		// subscribe the observer to the event source
		eventSource.addObserver(responseHandler);

		// starts the event thread
		Thread thread = new Thread(eventSource);
		thread.start();
	}

}
