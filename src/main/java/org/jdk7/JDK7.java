package org.jdk7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yaogangli
 * @date 2013-4-24 下午3:53:26
 */
public class JDK7 {

	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws Exception {
		int tag = 0b0010;
		System.out.println(tag);

		int a = 1_000_000_000;
		System.out.println(a);

		String input = "a";
		switch (input) {
		case "a":
			System.out.println("1");
			break;
		case "b":
			System.out.println("2");
			break;
		default:
			System.out.println("err");
		}

		Map<String, List<String>> myMap = new HashMap<>();
		myMap.put("test", Arrays.asList("a", "b"));
		System.out.println(myMap);

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(
				"E:/Dropbox/working/db.txt"), "GBK"))) {
			System.out.println(br.readLine());
		}

		try {
			System.out.println(1);
		} catch (IndexOutOfBoundsException | NullPointerException e) {
			e.printStackTrace();
		}
		
		Path path = Paths.get("E:/Dropbox/working/db.txt");
		path.toFile();
		System.out.println();
	}

	public void call() throws ReflectiveOperationException, IOException {
		try {
			//callWithReflection("");  
		} catch (final Exception e) {
			//logger.trace("Exception in reflection", e);  
			throw e;
		}
	}

}
