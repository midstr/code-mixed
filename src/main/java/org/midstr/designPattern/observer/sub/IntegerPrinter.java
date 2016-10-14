package org.midstr.designPattern.observer.sub;

import java.util.Arrays;

/**
 * @author yaogangli
 * @date 2013-7-9 下午3:11:18
 */
public class IntegerPrinter implements Observer {

	private IntegerDataBag bag;

	/**
	 * 
	 */
	public IntegerPrinter(IntegerDataBag bag) {
		this.bag = bag;
		bag.addObserver(this);
	}

	/* (non-Javadoc)
	 * @see org.midstr.designPattern.observer.sub.Observer#update(org.midstr.designPattern.observer.sub.Subject)
	 */
	@Override
	public void update(Subject o) {
		if (o == bag) {
			System.out.println("The contents of the IntegerDataBag have changed.");
			System.out.println("The new contents of the IntegerDataBag contains:");
			System.out.println(Arrays.toString(bag.getDatas().toArray()));
		}
	}

}
