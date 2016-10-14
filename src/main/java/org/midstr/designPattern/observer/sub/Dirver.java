package org.midstr.designPattern.observer.sub;

/**
 * @author yaogangli
 * @date 2013-7-9 下午3:11:37
 */
public class Dirver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IntegerDataBag bag = new IntegerDataBag();
		new IntegerAdder(bag);
		new IntegerPrinter(bag);
		
		bag.add(7);
		bag.add(2);
		bag.remove(0);
		bag.add(3);
	}

}
