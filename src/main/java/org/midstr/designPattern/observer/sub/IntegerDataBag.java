package org.midstr.designPattern.observer.sub;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yaogangli
 * @date 2013-7-9 下午3:04:31
 */
public class IntegerDataBag implements Subject {

	private List<Integer> datas = new ArrayList<>();

	private List<Observer> observers = new ArrayList<>();

	public void add(Integer i) {
		datas.add(i);
		notifyObservers();

	}

	public Integer remove(int index) {
		if (index < datas.size()) {
			Integer i = (Integer) datas.remove(index);
			notifyObservers();
			return i;
		}
		return null;
	}

	public List<Integer> getDatas() {
		return datas;
	}

	/* (non-Javadoc)
	 * @see org.midstr.designPattern.observer.sub.Subject#addObserver(org.midstr.designPattern.observer.sub.Observer)
	 */
	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	/* (non-Javadoc)
	 * @see org.midstr.designPattern.observer.sub.Subject#removeObserver(org.midstr.designPattern.observer.sub.Observer)
	 */
	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	private void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}

}
