package org.midstr.event;

/**
 * 事件广播器，提供事件监听器的注册
 */
public interface AppEventMulticaster {
	
	void addAppListener(AppListener appListener);
	
	void removeAppListener(AppListener appListener);
	
	void removeAllLinsteners();
	
	// notifyEvent
	void multicastEvent(AppEvent appEvent);

}
