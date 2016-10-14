package org.midstr.designPattern.factory;

import org.midstr.designPattern.factory.simplefactory.FruitFactory;

public class TestFactory{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IFruit fruit = FruitFactory.create();
		fruit.printName();
		fruit = FruitFactory.create("Banana");
		fruit.printName();
	}

}
