/*
 * filename: HrefMatch.java
 * date    : Jan 8, 2008
 * author  : Administrator
 * version : 1.0
 */
package org.midstr.regex;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * function of this class
 * 
 * @author Administrator
 */
public class HrefMatch {

	//private static Log log = LogFactory.getLog("tt");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// get URL string from command line or use default
			String urlString;
			if (args.length > 0)
				urlString = args[0];
			else
				urlString = "http://www.sina.com";

			// open reader for URL
			InputStreamReader in = new InputStreamReader(new URL(urlString)
					.openStream());

			// read contents into string builder
			StringBuilder input = new StringBuilder();
			int ch;
			while ((ch = in.read()) != -1)
				input.append((char) ch);

			// search for all occurrences of pattern
			String patternString = "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>])\\s*>";
			Pattern pattern = Pattern.compile(patternString,
					Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(input);
			int nCount = 0;
			while (matcher.find()) {
				String match = input.substring(matcher.start(), matcher.end());
				System.out.println(match);
				nCount++;
			}
			System.out.println(nCount);
			if (matcher.matches()) {
				System.out.println("match it:");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PatternSyntaxException e) {
			e.printStackTrace();
		}

	}
}
