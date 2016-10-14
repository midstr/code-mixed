package org.midstr.language;

public class BitOperation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 2^n & (2^n-1) = 0
		int x = 9999;  
		int countx = 0;  
		while(x>0){  
			System.out.println(x);
		    countx++;  
		    x=x&(x-1); 
		}  
		//System.out.println(countx);
	}

}
