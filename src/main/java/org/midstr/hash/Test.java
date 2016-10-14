package org.midstr.hash;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author yaogangli
 * @date 2013-6-18 下午3:11:24
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	Collection<Node> nodes = new ArrayList<Node>();
		for (int i = 0; i < 5; i++) {
			nodes.add(new Node("127.0.0." + (i + 1)));
		}
		System.out.println(nodes);
		System.out.println();
		
		ConsistentHash<Node> chash = new ConsistentHash<Node>(new SimpleHashFunction(), 2, nodes);
		for (int i = 1000; i < 5000; i+=1000) {
			System.out.println(i + " = " + chash.get(i));
		}
		
		chash.add(new Node("127.0.0.6"));
		System.out.println();
		for (int i = 1000; i < 5000; i+=1000) {
			System.out.println(i + " = " + chash.get(i));
		}
		
		chash.remove(new Node("127.0.0.2"));
		System.out.println();
		for (int i = 1000; i < 5000; i+=1000) {
			System.out.println(i + " = " + chash.get(i));
		}
		
		
	}
	
}
