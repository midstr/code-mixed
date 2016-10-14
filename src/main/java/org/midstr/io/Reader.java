package org.midstr.io;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {
	public static void main(String args[]) {

		// String[] s = new String[10];
		List<String> list = new ArrayList<String>();
		// int i = 0 ;
		Scanner reader = new Scanner(System.in);
		while (reader.hasNextLine()) {
			String input = reader.nextLine();
			if (input.equals("")) {
				break;
			}
			list.add(input);
		}
		for (String input : list) {
			System.out.println(input);
		}
		/*for (int i = 0; i < list.size(); i++) {
			String input = list.get(i);
			System.out.println(input);
		}*/
		
	}

}
