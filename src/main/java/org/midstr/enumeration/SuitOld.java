package org.midstr.enumeration;

/**
 * typesafe enum
 */
public class SuitOld {
	private final String name;

	private SuitOld(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public static final SuitOld CLUBS = new SuitOld("clubs");
	public static final SuitOld DIAMONDS = new SuitOld("diamonds");
	public static final SuitOld HEARTS = new SuitOld("hearts");
	public static final SuitOld SPADES = new SuitOld("spades");
	
	public static final SuitOld[] ARRAY = {CLUBS, DIAMONDS, HEARTS, SPADES};

	public static void main(String[] args) {
		System.out.println(SuitOld.CLUBS);
		System.out.println(SuitOld.ARRAY.length);
		for (SuitEnum suit : SuitEnum.values()) {
			System.out.println(suit.toString() + " = " + suit.ordinal());
		}
		SuitEnum.CLUBS.print();
	}
	
}
