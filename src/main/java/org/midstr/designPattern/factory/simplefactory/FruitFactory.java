package org.midstr.designPattern.factory.simplefactory;

import org.midstr.designPattern.factory.Apple;
import org.midstr.designPattern.factory.Banana;
import org.midstr.designPattern.factory.IFruit;
import org.midstr.designPattern.factory.Pear;

/**
 * 简单工厂类，只有两个简单的创建IFruit的静态方法，适合于IFruit实现比较简单的情况
 * 具有一定的“开-闭”原则，可以参考XmlReaderFactory的实现
 * 另外也可以结合单列模式，将FruitFactory设计为全局唯一实例(意义不大)
 */
public class FruitFactory {
	
	private FruitFactory() {
		// 拒绝初始化
	}

	public static IFruit create() {
		return create("Apple");
	}
	
	public static IFruit create(String key) {
		if ("Apple".equals(key)) {
			return new Apple();
		} else if ("Banana".equals(key)) {
			return new Banana();
		} else if ("Pear".equals(key)) {
			return new Pear();
		} else {
			return null;
			//throw new IllegalArgumentException();
		}
	}
}
