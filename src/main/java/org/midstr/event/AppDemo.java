package org.midstr.event;

import java.util.ArrayList;
import java.util.List;

public class AppDemo {

	private AppEventMulticaster appEventMulticaster = new SimpleAppEventMulticaster();

	private List<AppListener> appListeners = new ArrayList<AppListener>();

	public void publishEvent(AppEvent event) {
		getAppEventMulticaster().multicastEvent(event);
	}

	public void addAppListener(AppListener appListener) {
		appListeners.add(appListener);
	}

	public void registerListeners() {
		for (AppListener appListener : appListeners) {
			getAppEventMulticaster().addAppListener(appListener);
		}
	}

	private AppEventMulticaster getAppEventMulticaster() {
		if (appEventMulticaster == null) {
			throw new IllegalStateException("");
		}
		return appEventMulticaster;
	}

	public List<AppListener> getAppListeners() {
		return appListeners;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		AppDemo demo = new AppDemo();
		demo.addAppListener(new SimpleAppListener());
		demo.addAppListener(new AppListener() {
			public void onAppEvent(AppEvent appEvent) {
				System.out.println(appEvent.getTimestamp()
						+ " anonymous AppListener..." + appEvent.getSource());
			}
		});
		demo.addAppListener(new SimpleAppListener());
		demo.registerListeners();
		demo.publishEvent(new AppEvent(demo));
	}
}
