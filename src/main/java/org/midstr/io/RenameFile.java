package org.midstr.io;

import java.io.File;

public class RenameFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dir = "F:\\hp\\黄埔派出所_files\\images";
		File file = new File(dir);
		File[] files = file.listFiles();
		for (File tmp : files) {
			tmp.renameTo(new File(tmp.getPath().replaceAll("\\[1\\]", "")));
		}
	}

}
