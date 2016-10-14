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

	// 贪婪模式(Greedy )（默认）
	// 勉强模式(Reluctant)
	// 占有模式(Possessive)
	// Greedy的表达式会一直匹配下去，直到匹配不下去为止。(如果你发现表达式匹配的结果和预期的不符)，非常有可能是因为，你以为表达式会只匹配前面几个字符，而实际上他是greedy的，因此会一直匹配下去。
	// Reluctant 的表达式只匹配最少的字符。也称为lazy, minimal matching, non-greedy, 或ungreedy。
	// Possessive：
	// 目前只有Java支持(其他语言都不支持)。用正则表达式匹配字符串的时候会产生非常多中间状态(一般的匹配引擎会保存这种中间状态)，这样匹配失败的时候就能原路返回。占有型的表达式不保存这种中间状态，因此也就不会回头重来了。
	// 他能防止正则表达式的失控，同时也能提高运行的效率

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
