package org.midstr.random;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TestRandom {

	public static void print4Random() {
		int[] aryRandom = new int[4];
		while (aryRandom[0] == 0) {
			aryRandom[0] = (int) (Math.random() * 10);
		}
		int index = 1;
		while (index < 4) {
			int random = (int) (Math.random() * 10);
			boolean inArray = false;
			for (int i = 0; i < index; i++) {
				if (random == aryRandom[i]) {
					inArray = true;
					break;
				}
			}
			if (!inArray) {
				aryRandom[index++] = random;
			}
		}
		for (int i = 0; i < aryRandom.length; i++) {
			System.out.print(aryRandom[i]);
		}

		System.out.println();
	}

	public int random() {
		int number = 999 + (int) (9000 * Math.random());
		return number;
	}

	public boolean quite(int number) {
		boolean flag = false;
		if (number > 1022) {
			String str = String.valueOf(number);
			char c[] = str.toCharArray();
			Set<Character> set = new HashSet<Character>();
			for (int i = 0; i < c.length; i++) {
				set.add(c[i]);
			}
			if (set.size() == 4) {
				flag = true;
				System.out.println(str);
			} else {
				this.quite(random());
			}
		}
		return flag;
	}

	public static void print4Random1() {
		Random r = new Random();
		int[] tag = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		String four = "";
		int temp = 0;
		while (four.length() != 4) {
			temp = r.nextInt(10);// ȡ��0-9������
			if (tag[temp] == 0) {
				four += temp;
				tag[temp] = 1;
			}
		}
		System.out.println(four);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for (int i = 0; i < 1000; i++) {
//			 print4Random();
//		}
//		for (int i = 0; i < 10; i++) {
//			TestRandom tr = new TestRandom();
//			tr.quite(tr.random());
//		}
//		testMathRandom();
//		System.out.println((int)(1.1));
		
	}

	/**
	 * 
	 */
	public static void testMathRandom() {
		int low = 0;
		int high = 0;
		for (int i = 0;i < 1000000; i++) {
			double d = Math.random();
			if (d > 0.5) {
				low++;
			} else {
				high++;
			}
		}
		System.out.println(low);
		System.out.println(high);
	}

}
