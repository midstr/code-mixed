package org.midstr.designPattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author yaogangli
 * @date 2013-7-9 下午2:40:27
 */
public class ResponseHandler implements Observer {
	private String resp;

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof String) {
			resp = (String) arg;
			System.out.println("\nReceived Response: " + resp);
		}
	}

}
