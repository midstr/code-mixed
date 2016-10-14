package org.midstr.designPattern.observer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;

/**
 * @author yaogangli
 * @date 2013-7-9 下午2:37:01
 */
public class EventSource extends Observable implements Runnable {

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			final InputStreamReader isr = new InputStreamReader(System.in);
			final BufferedReader br = new BufferedReader(isr);
			for (;;) {
				String response = br.readLine();
				setChanged();
				notifyObservers(response);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
