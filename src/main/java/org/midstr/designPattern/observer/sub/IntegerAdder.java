package org.midstr.designPattern.observer.sub;

/**
 * @author yaogangli
 * @date 2013-7-9 下午3:11:06
 */
public class IntegerAdder implements Observer {

	private IntegerDataBag bag;

	/**
	 * 
	 */
	public IntegerAdder(IntegerDataBag bag) {
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
			int counter = 0;
			for (Integer integer : bag.getDatas()) {
				counter += integer.intValue();
			}
			System.out.println("The new sum of the integers is: " + counter);
		}
	}

}
