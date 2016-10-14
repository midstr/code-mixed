package org.midstr.enumeration;

/*
 * 1、从抽象类java.lang.Enum继承(使用enum关键字声明即意味着隐式继承)
 * 2、除了不能继承其它类(java是单继承，已经继承了java.lang.Enum)和被继承之外，和普通类差异不大
 *   可以参考 java.util.concurrent.TimeUnit
 */
public enum SuitEnum {

	CLUBS, DIAMONDS, HEARTS, SPADES;

	// private int index;

	SuitEnum() {
		// this.index = index;
	}

	public static final String name = "liyg";

	public void print() {
		System.out.println(name);
	}

	public static void main(String[] args) {
		for (SuitEnum suit : SuitEnum.values()) {
			System.out.println(suit.toString() + " = " + suit.ordinal());
		}
		Color.values();
		Color.valueOf("");
		// SuitEnum.CLUBS.printName();
		// SuitEnum.go(SuitEnum.CLUBS);
		// SuitEnum.gogo(SuitEnum.CLUBS);

	}
}

enum Color {
	RED("red"), 
	BLUE("blue.."), 
	BLACK("black");

	private String id;

	private Color(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
}