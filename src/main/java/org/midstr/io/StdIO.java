package org.midstr.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StdIO {
	
    /* 加载文件(xml等)，有以下几种基本的方式：
     * 1、如果是properties文件，则最好通过ResourceBundle.getBundle()方式
     *    当然个人认为可以进行区分，即属性配置文件的话，通过Properties.load()，
     *    如果是国际化的资源文件，这通过前述方法    
     * 2、通过本地java.io下面的包(需要区分相对路径和绝对路径)
     * 3、通过Class.getResourceAsStream()获取类路径范围内的文件(尤其适合jar包中的文件)
     * 4、如果是web项目，可以通过ServletContext.getResourceAsStream()方法
     * 
     * 可以参考spring的AbstractResource设计，考虑了各种情况的加载
	 */
	public static void main(String[] args) throws IOException {
		//testOld();
		//ResourceBundle.getBundle(baseName)
		//Properties.load()
		InputStream is = new FileInputStream("d:\\temp\\data\\changelog3.txt");
		InputStreamReader reader = new InputStreamReader(is);
		BufferedReader buffReader = new BufferedReader(reader);
		StringBuilder sb = new StringBuilder(is.available());
		String content = buffReader.readLine();
		while (content != null) {
			sb.append(content);
			content = buffReader.readLine();
		}
		buffReader.close();
	}

	/**
	 * 
	 */
	private static void testOld() {
		System.out.println("Please input a string: ");
		byte buffer[] = new byte[512];
		int count = 0;
		try {
			count = System.in.read(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("OutPut your string: ");
		for (int i = 0; i < count - 2; i++) {
			System.out.print((char) buffer[i]);
		}
		System.out.println();
		System.out.println("Count: " + (count - 2));
	}
}
