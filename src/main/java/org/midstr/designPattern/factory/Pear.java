package org.midstr.designPattern.factory;

public class Pear implements IFruit {
	
	private String name = Pear.class.getSimpleName();

	public void printName() {
		System.out.println(name);
	}

}
