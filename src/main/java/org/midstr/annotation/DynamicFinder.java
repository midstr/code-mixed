package org.midstr.annotation;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.util.ArrayList;

/**
 * @author yaogangli
 * @date 2013-4-22 下午5:23:57
 */
public class DynamicFinder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		URL url = ClassLoader.getSystemResource("com.qq.info.finance.data.json".replace(".", "/"));
		File file = new File(url.getFile());
		File[] files = file.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				if (name.endsWith(".class")) {
					return true;
				}
				return false;
			}
		});
		java.util.List<String> list = new ArrayList<String>();
		for (File tmpFile : files) {
			try {
				Class<?> cls = Class.forName("com.qq.info.finance.data.json." + tmpFile.getName().substring(0, tmpFile.getName().length() - 6));
				DataAction da = cls.getAnnotation(DataAction.class);
				if (da != null) {
					list.add(da.name());
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		System.out.println(list.toString());
	}

}
