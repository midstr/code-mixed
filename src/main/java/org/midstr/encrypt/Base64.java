package org.midstr.encrypt;

import sun.misc.BASE64Encoder;

public class Base64 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BASE64Encoder base = new BASE64Encoder();
		base.encode("aaa".getBytes());
		System.out.println(base);
	}

}
