package org.midstr.collections;

import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;

public class TestMaps {
	
	public static final int length = 5;
	
	public static void initMap(Map<String, String> map) {
		Date start = new Date();
		for (int i = 0; i < length; i++) {
			map.put(String.valueOf(i), String.valueOf(i));
		}
		Date end = new Date();
		System.out.println("init " + map.getClass().getSimpleName() + ": "
				+ (end.getTime() - start.getTime()));
	}
	
	public static void printMap(Map<String, String> map){
		System.out.println(map.getClass().getSimpleName() + ":");
		for (String key : map.keySet()) {
			System.out.print(key + " ");
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * HashTable      同步的 (由于历史原因，还实现了陈旧的Dictionary接口)
		 * HashMap        不同步的(可以将null作为key或value)
		 * LinkedHashMap  不同步的 (具有可预知的迭代顺序)
		 * TreeMap        不同步的 (基于红黑树的实现，按照升序顺序排列关键字，log(n)时间开销)
		 * WeakHashMap    不同步的 (弱键 )
		 * 
		 * HashMap是基于数组+链表实现的;Collections和Arrays为工具类
		 * */
		// HashMap:最普通的HashMap (Hashtable，同步版的hashmap)
		// LinkedHashMap:是Map 接口的哈希表和链接列表实现，具有可预知的迭代顺序
		// WeakHashMap:当某个键不再正常使用时，将自动移除其条目
		// TreeMap:此类保证了映射按照升序顺序排列关键字，根据使用的构造方法不同，可能会按照键的类的自然顺序进行排序（参见 Comparable），或者按照创建时所提供的比较器进行排序
		
		Map<String, String> hashtable = new Hashtable<String, String>();
		Map<String, String> hashmap = new HashMap<String, String>();
		Map<String, String> linkedhashmap = new LinkedHashMap<String, String>();
		Map<String, String> treemap = new TreeMap<String, String>();
		Map<String, String> weakhashmap = new WeakHashMap<String, String>();
		
		initMap(hashtable);
		initMap(hashmap);
		initMap(linkedhashmap);
		initMap(treemap);
		initMap(weakhashmap);
		
		printMap(hashtable);
		printMap(hashmap);
		printMap(linkedhashmap);
		printMap(treemap);
		printMap(weakhashmap);
		
	}

}
