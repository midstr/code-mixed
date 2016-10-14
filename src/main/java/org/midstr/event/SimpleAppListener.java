package org.midstr.event;

public class SimpleAppListener implements AppListener {

	public void onAppEvent(AppEvent appEvent) {
		System.out.println(appEvent.getTimestamp()
				+ " onAppEvent, the source is" + appEvent.getSource());
	}

}
