package org.midstr.classloader;

import java.net.URL;

public class TestClassLoader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Bootstrap ClassLoader:   启动类加载器 主要负责jdk_home/lib目录下的核心 api 或-Xbootclasspath 选项指定的jar包装入工作。 
		 *   Extension ClassLoader:   扩展类加载器主要负责jdk_home/lib/ext目录下的jar包或 -Djava.ext.dirs 指定目录下的jar包装入工作。
		 *     SystemClassLoader:       系统类加载器 主要负责java -classpath/-Djava.class.path所指的目录下的类与jar包装入工作。 
		 *       User Custom ClassLoader: 用户自定义类加载器(java.lang.ClassLoader的子类) 在程序运行期间, 通过java.lang.ClassLoader的子类动态加载class文件, 体现java动态实时类装入特性
		 *   
		 * BootstrapClassLoader->ExtClassLoader->AppClassLoader
		 * 
		 * 类加载器的特性：
		 *   1、每个ClassLoader都维护了一份自己的名称空间， 同一个名称空间里不能出现两个同名的类。
		 *   2、为了实现java安全沙箱模型顶层的类加载器安全机制, java默认采用了 ” 双亲委派的加载链 ” 结构
		 *   
		 * java动态载入class的两种方式：
		 *     implicit隐式,即利用实例化才载入的特性来动态载入class
		 *     explicit显式方式,又分两种方式:
		 *       java.lang.Class的forName()方法
		 *       java.lang.ClassLoader的loadClass()方法
		 *       
		 * Class.forName加载：使用的是被调用者的类加载器来加载类的
		 * 线程上下文类加载器 ：java默认的线程上下文类加载器是 系统类加载器(AppClassLoader).
		 *       
		 * static块在什么时候执行
		 *     当调用forName(String)载入class时执行,如果调用ClassLoader.loadClass并不会执行.forName(String,false,ClassLoader)时也不会执行.
		 *     如果载入Class时没有执行static块则在第一次实例化时执行.比如new ,Class.newInstance()操作static块仅执行一次
		 * 
		 */

		ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
		System.out.println(systemClassLoader == TestClassLoader.class
				.getClassLoader());
		System.out.println(systemClassLoader == Thread.currentThread()
				.getContextClassLoader());
		
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for (int i = 0; i < urls.length; i++) {
			System.out.println(urls[i].toExternalForm());
		}
		
	}

}
