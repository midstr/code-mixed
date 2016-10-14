/*
 * filename: Convert.java
 * date    : May 13, 2007
 * author  : Administrator
 * version : 1.0
 */
package org.midstr.charset;

public class Convert {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		System.out.println(Unicode2Ascii("李耀岗liyg043"));
		System.out.println((char) (new Integer(0x674e)).intValue());

		System.out.println(byte2Hex("啊".getBytes()));
		System.out.println(byteToHex("啊".getBytes()));

		System.out.println(byteToHex("　".getBytes()));
		System.out.println(Unicode2Ascii("　"));
		System.out.println(Integer.toHexString("　".charAt(0)));

		// String[] tags = name.split("[\\s\u3000]+");

		System.out.println("\u65e0\u6b64\u7528\u6237");
		String uu = "\\u65e0\\u6b64\\u7528\\u6237";
		String ss = Unicode2Ascii("李耀岗liyg043大师傅");
		System.out.println(ss);
		System.out.println(Ascill2Unicode(ss));
	}

	/**
	 * @param unicode
	 * @return
	 */
	public static String Unicode2Ascii(String unicode) {
		if (unicode == null)
			return null;
		String prefix = "\\u";
		int c;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < unicode.length(); i++) {
			c = unicode.charAt(i);
			if ((c & 0xff00) == 0) {
				sb.append((char) c);
			} else {
				sb.append(prefix).append(Integer.toHexString(c));
			}
		}
		return sb.toString();
	}

	public static String Ascill2Unicode(String ascii) throws Exception {
		return Ascii2Unicode(ascii, "\\u");
	}

	public static String Ascii2Unicode(String str, String pix) throws Exception {
		// StringBuffer unicode = new StringBuffer(ascii);
		// int code;
		//
		// for (int i = 0; i < ascii.length(); i++) {
		// code = (int) ascii.charAt(i);
		// if ((0xA1 <= code) && (code <= 0xFB)) {
		// unicode.setCharAt(i, (char) (code + 0xD60));
		// }
		// }
		//
		// return unicode.toString();
		StringBuffer unicodeString = new StringBuffer();
		int i = 0;
		while ((i = str.indexOf(pix, 0)) != -1) {
			unicodeString.append(str.substring(0, i));
			try {
				// UNICODE character
				char c = (char) Integer.parseInt(str.substring(i + 2, i + 6), 16);
				unicodeString.append(String.valueOf(c));
				str = str.substring(i + 6, str.length());
			} catch (Exception e) {
				e.printStackTrace();
				return str;
			}
		}
		unicodeString.append(str);
		return unicodeString.toString();
	}

	/**
	 * Convert a byte array to a String of hexadecimal digits and return it.
	 * 
	 * @param buffer
	 *            The byte array to be converted
	 */
	public static String byte2Hex(byte[] buffer) {
		if (buffer == null)
			return null;
		StringBuffer sb = new StringBuffer(buffer.length * 2);
		for (int i = 0; i < buffer.length; i++) {
			sb.append(Character.forDigit((buffer[i] & 0xf0) >> 4, 16));
			sb.append(Character.forDigit(buffer[i] & 0x0f, 16));
		}
		return sb.toString();
	}

	/**
	 * 将字符数组转换成十六进制的字符串
	 * 
	 * @param bytes
	 *            byte[] 字符数组
	 * 
	 * @return String 十六进制的字符串
	 */
	public static String byteToHex(byte[] buffer) {
		if (buffer == null)
			return null;
		String sTemp;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buffer.length; i++) {
			sTemp = Integer.toHexString(buffer[i] & 0xff);
			if (1 == sTemp.length()) {
				sb.append('0').append(sTemp);
			} else {
				sb.append(sTemp);
			}
		}
		return sb.toString();
	}

}
