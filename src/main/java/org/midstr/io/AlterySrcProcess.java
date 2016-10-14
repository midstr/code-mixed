package org.midstr.io;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class AlterySrcProcess {
	
	private String root;
	private String suffix;
	
	Logger logger = Logger.getLogger(getClass().getName());
	
	/**
	 * 
	 */
	public AlterySrcProcess() {
	}

	/**
	 * @param path
	 * @param suffix
	 */
	public AlterySrcProcess(String path, String suffix) {
		this.root = path;
		this.suffix = suffix;
	}

	public void setPath(String path) {
		this.root = path;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		AlterySrcProcess asp = new AlterySrcProcess();
		asp.setPath("D:\\工作备份\\Artery_backup_1");
		asp.setSuffix(",v");
		asp.processFile();
		
	}
	
	/**
	 * @throws IOException
	 */
	public void processFile() throws IOException {
		File rootFile = new File(root);
		if (rootFile.isFile()) {
			rename(rootFile);
			return;
		}
		File[] files = rootFile.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				if (file.getName().equals("CVS")) {
					delteCVSDirectory(file);
				} else {
					root = file.getPath();
					processFile();
				}
			} else {
				rename(file);
			}
		}
	}
	
	public void delteCVSDirectory(File file) {
		File[] aryFile = file.listFiles();
		for (File tmpFile : aryFile) {
			tmpFile.delete();
		}
		file.delete();
		logger.info("delete CVS " + file.getPath() + "★" + file.delete() + "★");
	}
	
	
	/**
	 * @param file
	 * @param suffix
	 * @throws IOException 
	 */
	public void rename(File file) throws IOException {
		String filename = file.getPath();
		if (filename.endsWith(suffix)) {
			File dest = new File(filename.substring(0, filename.length()
					- suffix.length()));
			logger.info("delete CVS " + filename + "★" + file.renameTo(dest) + "★");
		}
	}
	
}
