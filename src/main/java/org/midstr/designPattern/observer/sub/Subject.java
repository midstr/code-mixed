package org.midstr.designPattern.observer.sub;

/**
 * @author yaogangli
 * @date 2013-7-9 下午3:02:46
 */
public interface Subject {
	void addObserver(Observer o);

	void removeObserver(Observer o);
}
