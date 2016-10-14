package org.midstr.clazz;

public class ClazzLoader {

	public static void main(String[] args) throws ClassNotFoundException {
		Class clazz1 = ClassLoader.getSystemClassLoader().loadClass(
				"org.midstr.clazz.ClazzLoader");
		System.out.println(clazz1.getSimpleName());
		Class clazz2 = Class.forName("org.midstr.clazz.ClazzLoader");
		System.out.println(clazz2.getSimpleName());
	}
}
