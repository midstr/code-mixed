package org.midstr.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String input = "0.89%";
		System.out.println(input.matches("([0-9]+%)|([0-9]+\\.[0-9]+%)"));
		// TODO Auto-generated method stub
		// appendTest();
		//groupTest();
		justTest();
		//emailTest("www_#(#$*@#");
		//myTest();
		//mytest2();
		//mytest3();
		/*String test = "　　";
		String test2 = "";
		byte[] b = test.getBytes();
		System.out.println(test.getBytes());
		for (int i = 0; i < b.length; i++) {
			System.out.println(Integer.toHexString(b[i]));
		}*/
		//System.out.println(test.replaceAll("[ \r\n]*", "ttt"));
	}
	
	public static void myTest() {
		//$0 $1 
		String input = "\r\n\r\n大兴法院\r\n公告\r\n\r\n大跨度\r\n\r\n今天是个好日子\r\n\r\n";
		StringBuffer sb = new StringBuffer();
		Matcher m = Pattern.compile("(\r\n)+").matcher(input);
		boolean result = m.find();
		int i = 0;
		// 先去掉头和尾的空行
		while (result) {
			/*if (i == 0) {
				m.appendReplacement(sb, "");
			}
			if (m.hitEnd()) {
				m.appendReplacement(sb, "");
			}*/
			i++;
			result = m.find();
		}
		System.out.println(sb.toString());
		// 再去掉多余的文字
		m = Pattern.compile("大兴法院(\r\n)*公告(\r\n)*").matcher(sb.toString());
		String rs = "";
		if (m.find()) {
			rs = m.replaceFirst("");
		}
		System.out.println(rs);
		//String output = m.replaceFirst("");
		//m.
		//System.out.println(output);
	}
	
	public static void mytest2() {
		String input = "\r\n\r\n大兴法院\r\n公告\r\n\r\n\r\n大跨度\r\n\r\n今天是个好日子\r\n\r\n";
		input = input.replaceFirst("(\r\n)*大兴法院(\r\n)*公告(\r\n)*", "");
		StringBuffer sbRlt = new StringBuffer();
		Matcher m = Pattern.compile("(\r\n)+").matcher(input);
		boolean find = m.find();
		while (find) {
			/*if (m.hitEnd()) {
				m.appendReplacement(sbRlt, "");
			} else {
				m.appendReplacement(sbRlt, "\r\n");
			}*/
			find = m.find();
		}
		System.out.println(sbRlt.toString());
	}
	
	public static void mytest3() {
		String input = "\r\n\r\n大兴法院\r\n公告\r\n\r\n大跨度\r\n  \r\n  今天是个好日子\r\n  \r\n\r\n\r\n哈哈";
		input = input.replaceFirst("(\r\n)*\\s*(\r\n)*大兴法院(\r\n)*\\s*(\r\n)*公告(\r\n)*\\s*(\r\n)*", "");
		//input = input.replaceAll("( *\r\n *)+", "\n");
		//input = input.replaceAll("(\\s+\n)+", "\n");
		input = input.replaceAll("(\r\n)+\\p{Blank}(\r\n)+", "\r\n");
		System.out.println(input);
		input = input.replaceAll("(\r\n)*\\s*(\r\n)*\\z", "");
		System.out.println(input);
		/*Matcher m = Pattern.compile("(\r\n)+\\s*(\r\n)+").matcher(input);
		boolean find = m.find();
		while (find) {
			m.appendReplacement(sb, "\r\n");
			find = m.find();
		}
		m.appendTail(sb);
		m = Pattern.compile("(\r\n)*\\s*(\r\n)*\\z").matcher(sb);
		System.out.println(m.find());
		input = m.replaceAll("");
		System.out.println(input);*/
	}

	public static void appendTest() {
		String s = "liyg is a big liyg abc";
		Pattern p = Pattern.compile("liyg");
		Matcher m = p.matcher(s);
		StringBuffer sb = new StringBuffer();
		int i = 0;
		boolean result = m.find();
		while (result) {
			i++;
			m.appendReplacement(sb, "zhangyx");
			System.out.println("第" + i + "次匹配后sb的内容是：" + sb);
			result = m.find();
		}
		m.appendTail(sb);
		System.out.println("调用m.appendTail(sb)后sb的最终内容是:" + sb.toString());
	}

	public static void groupTest() {
		Pattern p = Pattern.compile("(ca)|(t)");
		Matcher m = p.matcher("one cat,two cats in the yard");
		m.find();
		System.out.println("该次查找获得匹配组的数量为：" + m.groupCount());
		for (int i = 1; i <= m.groupCount(); i++) {
			System.out.println("第" + i + "组的子串内容为： " + m.group(i));
		}
		System.out.println(m.replaceAll("china"));
		// System.out.println(m.quoteReplacement("李耀岗"));
	}

	public static void emailTest(String input) {
		//String input = "liyg@thunisoft.com";
		// 检测输入的EMAIL地址是否以 非法符号"."或"@"作为起始字符
		Pattern p = Pattern.compile("^\\.|^\\@");
		Matcher m = p.matcher(input);
		if (m.find()) {
			System.err.println("EMAIL地址不能以'.'或'@'作为起始字符");
		}
		// 检测是否以"www."为起始
		p = Pattern.compile("^www\\.");
		m = p.matcher(input);
		if (m.find()) {
			System.out.println("EMAIL地址不能以'www.'起始");
		}
		// 检测是否包含非法字符
		p = Pattern.compile("(^A-Za-z0-9\\.\\@_\\-~#)+");
		m = p.matcher(input);
		StringBuffer sb = new StringBuffer();
		boolean result = m.find();
		boolean deletedIllegalChars = false;
		while (result) {
			// 如果找到了非法字符那么就设下标记
			deletedIllegalChars = true;
			// 如果里面包含非法字符如冒号双引号等，那么就把他们消去，加到SB里面
			m.appendReplacement(sb, "");
			result = m.find();
		}
		m.appendTail(sb);
		input = sb.toString();
		if (deletedIllegalChars) {
			System.out.println("输入的EMAIL地址里包含有冒号、逗号等非法字符，请修改");
			// System.out.println("您现在的输入为: "+args(0));
			System.out.println("修改后合法的地址应类似: " + input);
		}
	}
	
	public static void justTest() {
		//String input = "liyg@thunisoft.com";
		// 检测输入的EMAIL地址是否以 非法符号"."或"@"作为起始字符
		String input = "2-NYs[1.length]/(NMs[1.length] * NXs[1] - 9.2) * 1.003 / NGs[1]";
		input = input.replaceAll("\\s", "");
		
		System.out.println(input);
		Pattern p = Pattern.compile("[0-9.]*[()/*+-]+[0-9.]*");
		StringBuffer sb = new StringBuffer();
		Matcher m = p.matcher(input);
		boolean result = m.find();
		while (result) {
			m.appendReplacement(sb, ";");
			result = m.find();
		}
		m.appendTail(sb);
		String out = sb.toString();
		out = out.replaceAll(";+", ";");
		String[] ary = out.split(";");
		for (int i = 0; i < ary.length; i++) {
			System.out.println(ary[i]);
		}
		
		input = "(NMs[i]<NMs[i+1]) ||((NMs[i]＝NMs[i+1] && (NXs[i]>NXs[i+1]))";
		System.out.println(input);
		input = input.replaceAll("\\[.+?\\]", "");
		input = input.replaceAll("[()/*+-=＝><\\s\\|\\&]+", ";");
		System.out.println(input);
		//NYs[1.length]/(NMs[1.length] * NXs[1]) × 100
		//String test = "NYs[1.length]/(NMs[1.length] * NXs[1])";
		//System.out.println(test.replaceAll("[\\s]", ""));
		
		/*输入：NYs[1.length]/(NMs[1.length] * NXs[1])
		输出：NYs[1.length]
		      NMs[1.length]
		      NXs[1]*/
		
		/*(NMs[i]<NMs[i+1]) ||((NMs[i]＝NMs[i+1] && (NXs[i]>NXs[i+1]))

				想得到 NMs NXs 怎么写？*/

	}
}
