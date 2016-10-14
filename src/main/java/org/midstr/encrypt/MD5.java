package org.midstr.encrypt;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class MD5 {
	
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		 MessageDigest md5 = MessageDigest.getInstance("MD5");
		 String source = "李耀岗";
		 System.out.println(URLEncoder.encode(source, "UTF-8"));
		 md5.update(URLEncoder.encode(source, "UTF-8").getBytes("UTF-8"));
		 byte[] b = md5.digest();
		 System.out.println(Hex.encodeHex(b));
		 //%E6%9D%8E%E8%80%80%E5%B2%97
	}
	
}
