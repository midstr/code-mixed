/*
 * filename: RegexDemo.java
 * date    : Jan 8, 2008
 * author  : Administrator
 * version : 1.0
 */
package org.midstr.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

	// ̰��ģʽ(Greedy )��Ĭ�ϣ�
	// ��ǿģʽ(Reluctant)
	// ռ��ģʽ(Possessive)
	// Greedy�ı��ʽ��һֱƥ����ȥ��ֱ��ƥ�䲻��ȥΪֹ��(����㷢�ֱ��ʽƥ��Ľ����Ԥ�ڵĲ���)���ǳ��п�������Ϊ������Ϊ���ʽ��ֻƥ��ǰ�漸���ַ�����ʵ��������greedy�ģ���˻�һֱƥ����ȥ��
	// Reluctant �ı��ʽֻƥ�����ٵ��ַ���Ҳ��Ϊlazy, minimal matching, non-greedy, ��ungreedy��
	// Possessive��
	// Ŀǰֻ��Java֧��(�������Զ���֧��)����������ʽƥ���ַ�����ʱ�������ǳ����м�״̬(һ���ƥ������ᱣ�������м�״̬)������ƥ��ʧ�ܵ�ʱ�����ԭ·���ء�ռ���͵ı��ʽ�����������м�״̬�����Ҳ�Ͳ����ͷ�����ˡ�
	// ���ܷ�ֹ������ʽ��ʧ�أ�ͬʱҲ��������е�Ч��

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		in.close();
		// String regex = "[+-]?[0-9]+|0[Xx][0-9A-Fa-f]+";
		String input = "adf0Xhas20xa234f";

		String regEx = ".+\\(.+)$";
		String str = "c:\\dir1\\dir2\\name.txt";
		Pattern pattern = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			System.out.println("find it");
			// matcher.
			System.out.println(input.substring(matcher.start(), matcher.end()));
			for (int i = 1; i <= matcher.groupCount(); i++) {
				System.out.println(matcher.group(i));
			}
		}
		if (matcher.matches()) {
			System.out.println("True");
		}

	}
}
