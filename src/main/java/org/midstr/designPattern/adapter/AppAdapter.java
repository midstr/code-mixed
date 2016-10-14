package org.midstr.designPattern.adapter;

import org.midstr.event.AppEvent;
import org.midstr.event.AppListener;

/**
 * 在AppListener有多个方法处理时，为了避免处理不必要的方法，需要一个adapter
 * java.awt.event.WindowAdapter
 */
public class AppAdapter implements AppListener {

	public void onAppEvent(AppEvent appEvent) {
	}

}
