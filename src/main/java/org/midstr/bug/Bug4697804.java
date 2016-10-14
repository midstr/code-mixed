package org.midstr.bug;

import java.util.ArrayList;
import java.util.List;

public class Bug4697804 {
	private static int count = 0;
    public static void main(String[] args) {
        try {
            List<Object> list = (List<Object>)create(2, 1024);
            System.out.println(list.size());
        }
        catch (OutOfMemoryError err) {
        	System.out.println(count);
            System.err.println("OutOfMemoryError - OK");
            err.printStackTrace();
        }
        
    	/*List<Object> list = new ArrayList<Object>();
    	for (int i = 0; i < 100000000; i++) {
    		List<Object> o = new ArrayList<Object>(1024);
    		list.add(o);
    		System.out.println(i);
    	}*/
    }
    private static List<Object> create(int d, int n) {
    	count++;
		List<Object> x = new ArrayList<Object>(n);
		if (d > 0) {
			for (int i = 0; i < n; ++i) {
				x.add(create(d - 1, n));
			}
		}
		return x;
	}
}

