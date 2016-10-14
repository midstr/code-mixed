package org.midstr.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

public class AES {

	public static String asHex(byte buf[]) {
		StringBuffer strbuf = new StringBuffer(buf.length * 2);
		int i;

		for (i = 0; i < buf.length; i++) {
			if (((int) buf[i] & 0xff) < 0x10)
				strbuf.append("0");
			//因为byte的取值范围是 -128～127，而Char是0～65535 
			//所以需要& 0xFF 使得byte原来的负值变成正的
			//与 0xff 做 & 运算会将 byte 值变成 int 类型的值，也将 -128～0 间的负值都转成正值了。
			strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
		}
		return strbuf.toString();
	}
	
	public static byte[] asByte(String hex) {
		if (hex.length() % 2 != 0) {
			return new byte[0];
		}
		byte[] b = new byte[hex.length() / 2];
		char[] c = hex.toCharArray();
		for (int i = 0; i < c.length; i = i + 2) {
			String s = c[i] + "" + c[i+1];
			b[i/2] = (byte)Integer.parseInt(s, 16);
		}
		return b;
	}

	/**
	 * @param args
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws UnsupportedEncodingException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException,
			UnsupportedEncodingException, IllegalBlockSizeException,
			BadPaddingException {
		
		// 密钥即可以通过KeyGenerator生成，也可以自己生成
		// 可以将加密解密通过WebService进行发布，由不同的客户端进行调用（asp/asp.net/java/php）
		
		// // 获取密匙生成器
		// KeyGenerator kg = KeyGenerator.getInstance("AES");
		// kg.init(128); // 初始化
		// // AES算法可以是128、192、256位
		// SecretKey key = kg.generateKey(); // 生成密匙，可用多种方法来保存密匙
		//882FE1A414AE7CC8B7E37CCC49E0E1D7
		//4c305da013d1658641c880683f8f7717
		String sKey = "1234567812345678";
		String str = "liyg";
		System.out.println(Hex.encodeHex(str.getBytes()));
		SecretKeySpec skeySpec = new SecretKeySpec(sKey.getBytes(), "AES");
		Cipher cp = Cipher.getInstance("AES"); // 创建密码器
		cp.init(Cipher.ENCRYPT_MODE, skeySpec); // 初始化
		// 加密
		byte[] ctext = cp.doFinal(str.getBytes());
		System.out.println(asHex(ctext));
		System.out.println(Hex.encodeHex(ctext));
		
		cp = Cipher.getInstance("AES"); // 创建密码器
		cp.init(Cipher.DECRYPT_MODE, skeySpec); // 初始化
		// 解密
		byte[] ptext = cp.doFinal(ctext); 
		System.out.println(Hex.encodeHex(ptext));
		str = new String(ptext, "UTF-8"); // 重新显示明文
		System.out.println("bin = " + str);
		
	}

}
