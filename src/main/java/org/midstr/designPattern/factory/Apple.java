package org.midstr.designPattern.factory;

public class Apple implements IFruit {
	
	private String name = Apple.class.getSimpleName();

	public void printName() {
		System.out.println(name);
	}

}
