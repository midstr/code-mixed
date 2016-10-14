package org.midstr.language;

import java.util.HashMap;
import java.util.Map;

/**
 * 法是值传递or指针传递？基本类型是值传递，数组和对象是两者结合
 */
public class ArgumentPassing {
	
	public void testBasic(int i) {
		i++;
	}
	
	public void testArray(int[] array){
		array = new int[5];
	}
	
	public void testObject(Map<String, String> map){
		map.put("2", "2");
		map = new HashMap<String, String>();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArgumentPassing arg = new ArgumentPassing();
		
		int basic = 1;
		arg.testBasic(basic);
		System.out.println(basic);
		
		int[] array = new int[2];
		arg.testArray(array);
		System.out.println(array[0]);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "1");
		arg.testObject(map);
		System.out.println(map.size());
		
	}

}
