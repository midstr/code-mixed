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
 * @date 2012-5-21 ����04:05:19
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
		// 1��(?:X) X����Ϊ�ǲ�����
		// �벶���� ( ) ����˼һ��Ҳ�ǽ�����Ϊһ����д����벶������������ڲ�����ƥ����ı���
		// ������Ϊ���顣
		// ���磺Ҫƥ�� 123123 ������Ϳ���дΪ (123)\1 ʹ�÷������ã���ʱֻ���ò����飬��ƥ��
		// 123 ��ᱣ�����ڴ��У����ڷ������ã��� (?:123) ��ƥ������򲻻ᱣ������������ڴˡ�

		Pattern p = Pattern.compile("abc(?:def)");
		Matcher m = p.matcher("xxxabcdefxxx");
		while (m.find()) {
			System.out.println(m.group() + ", start=" + m.start() + ", end=" + m.end());
			// m.group(1);
		}
		System.out.println();

		// 2��(?idmsux-idmsux) Nothing�����ǽ�ƥ���־i d m s u x on - off
		// ���ڱ�־ƥ�䣬���磺���ʽ (?i)abc(?-i)def ��ʱ��(?i) �򿪲����ִ�Сд���أ�abc ƥ��
		// �����ִ�С�ؽ���ƥ�䣬(?-i) �رձ�־���ָ������ִ�Сд����ʱ�� def ֻ��ƥ�� def

		p = Pattern.compile("(?i)abc(?-i)def");
		m = p.matcher("xxxABcdefxxx");
		while (m.find()) {
			System.out.println(m.group() + ", start=" + m.start() + ", end=" + m.end());
		}
		System.out.println();
		//
		// 3��(?idmsux-idmsux:X) X����Ϊ���и�����־ i d m s u x on - off
		// ����������ƣ�����ı��ʽ�����Ը�д��Ϊ��(?i:abc)def������ (?i)abc(?-i:def)
		p = Pattern.compile("(?i:abc)def");
		m = p.matcher("xxxABcdefxxx");
		while (m.find()) {
			System.out.println(m.group() + ", start=" + m.start() + ", end=" + m.end());
		}
		System.out.println();
		//
		// 4��(?=X) X��ͨ�����ȵ��� lookahead
		// (?=X) ��ʾ��ǰλ�ã����ַ��ķ�϶������������ֵ��ַ������磺��ʾʽ a(?=b)�����ַ���Ϊ
		// ab ʱ������ƥ�� a������� (?=b) ��ʾ��a ����ķ�϶�����Կ��������ȡ�
		p = Pattern.compile("a(?=b)");
		m = p.matcher("abacabadabb");
		while (m.find()) {
			System.out.println(m.group() + ", start=" + m.start() + ", end=" + m.end());
		}
		System.out.println();

		// 5��(?!X) X��ͨ�����ȵĸ� lookahead
		// (?!X) ��ʾ��ǰλ�ú��治������ֵ��ַ�
		p = Pattern.compile("a(?!b)");
		m = p.matcher("abacabadabb");
		while (m.find()) {
			System.out.println(m.group() + ", start=" + m.start() + ", end=" + m.end());
		}
		System.out.println();
		//
		// 6��(? <=X) X��ͨ�����ȵ��� lookbehind
		// 7��(? <!X) X��ͨ�����ȵĸ� lookbehind
		// �������������������ƣ�������������󿴣��������ǰ��
		//
		// 8��(?>X) X����Ϊ�����ķǲ�����
		// ƥ��ɹ������л��ݣ�����Ƚϸ��ӣ�Ҳ��ռ���ʡ�+������ͨ�ã����磺\d++ ����дΪ (?>\d+)��
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
		// "<item Date='20120507' flag='1' KeyWord='ȯ��&����<&amp;�涨>���&lt;���&gt;' />";

		String txt = "<item Date='20120507' flag='1' KeyWord='��<��<<<&lt;����&amp;' />";
		System.out.println(txt);
		// &([^;]+(?!(?:\\w|;)))
		// ��"&"����ת��
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
