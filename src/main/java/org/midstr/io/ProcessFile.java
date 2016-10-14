package org.midstr.io;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:金航数码科技有限责任公司
 * </p>
 * 
 * @author liyg
 * @version 1.0
 * @date 2009-10-19 下午09:47:50
 */
public class ProcessFile {

	private String path = "result_BH.txt";
	
	private String begin = "-----------";
	
	private String end = "Table";
	
	public ProcessFile() {
		
	}

	public ProcessFile(String path) {
		this.path = path;
	}

	/**
	 * 将文件读取到内存，使用字符串正则表达式替换
	 */
	public void process() {
		long start = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		// 换行 ('\n')、回车 ('\r')
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String content = br.readLine();
			while (content != null) {
				sb.append(content);
				content = br.readLine();
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		String result = sb.toString().replaceAll(begin + ".*?" + end, "");
		//result = result.replaceAll("##########", "\n");
		File file = new File(path + ".bak");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(result);
			bw.flush();
			bw.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		System.out.println("total time is : "
				+ (System.currentTimeMillis() - start) + "ms");
		System.out.println("bak file path is : " + file.getAbsolutePath());
	}
	
	/**
	 * 读文件，读到特使标记的话则跳过
	 * 时间换内存
	 */
	public void processByRead() {
		long start = System.currentTimeMillis();
		try {
			File in = new File(path);
			File out = new File(path + ".bak");
			BufferedWriter bw = new BufferedWriter(new FileWriter(out));
			BufferedReader br = new BufferedReader(new FileReader(in), 8192 * 10);
			int bIndex = 0, eIndex = 0;
			char ch = (char) -1;
			int count = 0;
			while ((ch = (char) br.read()) != (char)-1) {
				if (bIndex < begin.length()) {
					if (begin.charAt(bIndex) == ch) {
						bIndex++;
					} else {
						bIndex = 0;
					}
					bw.write(ch);
				} else if (eIndex < end.length()) {
					if (end.charAt(eIndex) == ch) {
						eIndex++;
					} else {
						eIndex = 0;
					}
				} else {
					bIndex = 0;
					eIndex = 0;
					bw.write(end);
					bw.write(ch);
				}
				System.out.println(++count);
			}
			br.close();
			bw.flush();
			bw.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		System.out.println("total time is : "
				+ (System.currentTimeMillis() - start) + "ms");
	}

	public String getPath() {
		return path;
	}

	public String getBegin() {
		return begin;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "result_BH.txt";
		if (args != null && args.length > 0) {
			path = args[0];
		}
		ProcessFile pf = new ProcessFile(path);
		pf.process();
		//pf.processByRead();
		
	}

}
