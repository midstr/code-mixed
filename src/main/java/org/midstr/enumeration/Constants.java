package org.midstr.enumeration;

enum Key {
	A1,
	A2
}

public interface Constants {
	String CLUBS = "clubs";
	String DIAMONDS = "diamonds";
	String HEARTS = "hearts";
	String SPADES = "spades";
}

class Demo {
	public static void testKey() {
		System.out.println(Key.A1);
	}
}
