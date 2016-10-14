package org.midstr.event;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * 
 */
public class SimpleAppEventMulticaster implements AppEventMulticaster {
	
	// 不同步的，如果考虑同步，可参考spring的实现：copy-on-write
	private Collection<AppListener> appListeners = new LinkedHashSet<AppListener>();

	public void addAppListener(AppListener appListener) {
		appListeners.add(appListener);
	}

	public void removeAllLinsteners() {
		appListeners.clear();
	}

	public void removeAppListener(AppListener appListener) {
		appListeners.remove(appListener);
	}

	public void multicastEvent(AppEvent appEvent) {
		for (AppListener appListener : appListeners) {
			appListener.onAppEvent(appEvent);
		}
	}
	
	protected Collection<AppListener> getAppListeners() {
		return appListeners;
	}

}
