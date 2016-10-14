package org.midstr.designPattern.factory;

public class Banana implements IFruit {
	
	private String name = Banana.class.getSimpleName();

	public void printName() {
		System.out.println(name);
	}

}
