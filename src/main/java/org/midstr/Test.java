package org.midstr;

import java.text.DecimalFormat;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double d = 122.d;
		//System.out.println(d);
		DecimalFormat df = new DecimalFormat("0.00");
//		Math
		System.out.println(df.format(d));
		double test = 2.1d;
		double test2 = 2.12d;
		if ((test2-test) > 0) {
			System.out.println(test);
		}
	}

}
