package org.test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;

/**
 * @author yaogangli
 * @date 2014-5-15 下午4:25:43
 */
public class BufferTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ByteBuffer bb = ByteBuffer.allocate(10);
		IntBuffer ib = IntBuffer.allocate(100);
		ib.put(10);
		ib.put(10);
		ib.put(10);
		ib.put(200);
		ib.flip();
		ib.get();
		ib.get();
		ib.get();
		ib.get();
		ib.get();
		System.out.println(ib.toString());
	}

}
