package org.midstr.regex;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * @author yaogangli
 * @date 2012-5-21 下午04:05:19
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		test1();

		test2();

	}

	private static void test1() throws Exception {
		// 1、(?:X) X，作为非捕获组
		// 与捕获组 ( ) 的意思一样也是将其作为一组进行处理，与捕获组的区别在于不捕获匹配的文本，
		// 仅仅作为分组。
		// 比如：要匹配 123123 这个，就可以写为 (123)\1 使用反向引用，这时只能用捕获组，在匹配
		// 123 后会保留在内存中，便于反向引用，而 (?:123) 在匹配完后则不会保留，区别仅在于此。

		Pattern p = Pattern.compile("abc(?:def)");
		Matcher m = p.matcher("xxxabcdefxxx");
		while (m.find()) {
			System.out.println(m.group() + ", start=" + m.start() + ", end=" + m.end());
			// m.group(1);
		}
		System.out.println();

		// 2、(?idmsux-idmsux) Nothing，但是将匹配标志i d m s u x on - off
		// 用于标志匹配，比如：表达式 (?i)abc(?-i)def 这时，(?i) 打开不区分大小写开关，abc 匹配
		// 不区分大小地进行匹配，(?-i) 关闭标志，恢复不区分大小写，这时的 def 只能匹配 def

		p = Pattern.compile("(?i)abc(?-i)def");
		m = p.matcher("xxxABcdefxxx");
		while (m.find()) {
			System.out.println(m.group() + ", start=" + m.start() + ", end=" + m.end());
		}
		System.out.println();
		//
		// 3、(?idmsux-idmsux:X) X，作为带有给定标志 i d m s u x on - off
		// 与上面的类似，上面的表达式，可以改写成为：(?i:abc)def，或者 (?i)abc(?-i:def)
		p = Pattern.compile("(?i:abc)def");
		m = p.matcher("xxxABcdefxxx");
		while (m.find()) {
			System.out.println(m.group() + ", start=" + m.start() + ", end=" + m.end());
		}
		System.out.println();
		//
		// 4、(?=X) X，通过零宽度的正 lookahead
		// (?=X) 表示当前位置（即字符的缝隙）后面允许出现的字符，比如：表示式 a(?=b)，在字符串为
		// ab 时，可能匹配 a，后面的 (?=b) 表示，a 后面的缝隙，可以看作是零宽度。
		p = Pattern.compile("a(?=b)");
		m = p.matcher("abacabadabb");
		while (m.find()) {
			System.out.println(m.group() + ", start=" + m.start() + ", end=" + m.end());
		}
		System.out.println();

		// 5、(?!X) X，通过零宽度的负 lookahead
		// (?!X) 表示当前位置后面不允许出现的字符
		p = Pattern.compile("a(?!b)");
		m = p.matcher("abacabadabb");
		while (m.find()) {
			System.out.println(m.group() + ", start=" + m.start() + ", end=" + m.end());
		}
		System.out.println();
		//
		// 6、(? <=X) X，通过零宽度的正 lookbehind
		// 7、(? <!X) X，通过零宽度的负 lookbehind
		// 这两个与上面两个类似，上面两个是向后看，这个是向前看
		//
		// 8、(?>X) X，作为独立的非捕获组
		// 匹配成功不进行回溯，这个比较复杂，也侵占量词“+”可以通用，比如：\d++ 可以写为 (?>\d+)。
	}

	/**
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	private static void test2() throws Exception {
		// TODO Auto-generated method stub
		// String txt =
		// "<item Date='20120507' flag='1' KeyWord='券商&创新<&amp;规定>大会&lt;你好&gt;' />";

		String txt = "<item Date='20120507' flag='1' KeyWord='你<好<<<&lt;单独&amp;' />";
		System.out.println(txt);
		// &([^;]+(?!(?:\\w|;)))
		// 对"&"进行转义
		txt = txt.replaceAll("&((?!((amp)|(lt)|(gt)|(quot)|(apos)|(nbsp));))", "&amp;$1");
		Pattern p = Pattern.compile("='(?:.*?)' ");
		Matcher m = p.matcher(txt);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			String group = m.group();
			group = group.replaceAll("<", "&lt;");
			group = group.replaceAll(">", "&gt;");
			m.appendReplacement(sb, group);
		}
		m.appendTail(sb);
		System.out.println(sb);

		txt = sb.toString();
		// txt = txt.replaceAll("(='.*?)<(.*?')", "$1&lt;$2");
		// System.out.println(txt);
		// txt = txt.replaceAll("(='.*?)>(.*?')", "$1&gt;$2");
		// System.out.println(txt);
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

		Document doc = docBuilder.parse(new ByteArrayInputStream(txt.getBytes("UTF-8")));
	}


}
