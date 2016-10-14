package org.midstr.event;

import java.util.EventObject;

/**
 * 系统事件
 */
public class AppEvent extends EventObject {

	private static final long serialVersionUID = 7845367815110836943L;
	
	private final long timestamp;

	public AppEvent(Object source) {
		super(source);
		this.timestamp = System.currentTimeMillis();
	}

	public final long getTimestamp() {
		return timestamp;
	}
}
