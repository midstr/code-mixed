package org.midstr.assertion;

public class AssertDemo {

	public void print(String input) {
		assert input != null;
		System.out.println("print " + input);
	}

	public void talk(String input) {
		assert input != null : "input can not be null";
		System.out.println("talk " + input);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// from jdk1.4
		// -ea 开启断言 -da 关闭断言(默认关闭)
		
		// -ea[:<packagename>...|:<classname>]
		// -enableassertions[:<packagename>...|:<classname>]
		// 		enable assertions
		// -da[:<packagename>...|:<classname>]
		// -disableassertions[:<packagename>...|:<classname>]
		// 		disable assertions
		
		// assert expression1
		// assert expression1 : expression2
		
		AssertDemo ass = new AssertDemo();
//		ass.print("china");
//		System.out.println();
//		ass.print(null);
		
		ass.talk("old story");
		System.out.println();
		ass.talk(null);
		
	}

}
