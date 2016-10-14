package org.midstr.encrypt;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;



/**
 * <p>Title:</p>
 * <p>Description:
 * 从各种替换法运算的特点看，异或运算最适合用于简易加解密运算，这种方法的原理是:当一个数A和另一个数B进行异
 * 或运算会生成另一个数C，如果再将C和B进行异或运算则C又会还原为A。
 * 相对于其他的简易加密算法，XOR算法的优点如下。
 * (1)算法简单，对于高级语言很容易能实现。
 * (2)速度快，可以在任何时候、任何地方使用。
 * (3)对任何字符都是有效的，不像有些简易加密算法，只对西文字符有效，对中文加密后再解密无法还原为原来的字符
 * </p>
 * <p>Company:北京紫光华宇软件股份有限公司</p>
 * @author liyg
 * @version 1.0
 * @date Jul 9, 2009 7:50:08 PM
 */
public class TestXOR {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		//String value = "肉、蔬菜和水果";   
        // String key = "蔬菜和水果";   
        String value = "http://blog.csdn.net/froole/archive/2009/05/13/4176111.aspx";   
        String key = "liyg";   
           
        // 加密前输出   
        print("加密前", value);   
        // 加密处理   
        byte[] byteEncodeArray = encode(value.getBytes(), key);   
        value = new String(byteEncodeArray);   
           
        // 加密后输出   
        print("加密后", value);   
           
        // URL转换处理   
        String encode = URLEncoder.encode(value, "UTF-8");   
        print("转换URL", encode);   
        String dencode = URLDecoder.decode(encode, "UTF-8");   
        print("从URL恢复", dencode);   
        value = dencode;   
           
        // 解密   
        byte[] byteDecodeArray = decode(value.getBytes(), key);   
        value = new String(byteDecodeArray);   
           
        // 解密后输出   
        print("解密后", value);   
        
        printBytes("abc".getBytes());
        
        byte a = (byte)129;
        System.out.println(a + "--" +Integer.toBinaryString(a));
        System.out.println(Byte.SIZE + ":" + Byte.MAX_VALUE + ":" + Byte.MIN_VALUE);
        System.out.println(Short.SIZE + ":" + Short.MAX_VALUE + ":" + Short.MIN_VALUE );
	}
	/**  
     * 加密处理  
     * @param src  
     * @param key  
     * @return  
     */  
    private static byte[] encode(byte[] src, String key) {   
        byte[] byteKeyArray = new byte[0];   
        byte[] byteEncArray = new byte[src.length];   
           
        // 转换加密钥匙的循环处理   
        while(byteKeyArray.length < src.length) {   
            byteKeyArray = (new String(byteKeyArray) + key).getBytes();   
        }   
        //System.out.println("debug:" + new String(byteKeyArray));   
        // 转换   
        for (int i = 0; i < src.length; i++) {   
            byteEncArray[i] = (byte)(src[i]^byteKeyArray[i]);   
        }   
        return byteEncArray;   
    }   
       
    /**  
     * 解密  
     * @param src  
     * @param key  
     * @return  
     */  
    private static byte[] decode(byte[] src, String key) {   
        return encode(src, key);   
    }   
       
    /**  
     * 转换成16进制文字  
     * @param value  
     * @return  
     */  
    private static String getDump16(byte[] value) {   
        StringBuffer buf = new StringBuffer();   
        for (int i = 0; i < value.length; i++) {   
        	// why?
        	System.out.println(((int)value[i]) + "---" + ((int)value[i] & 255));
            String hex = Integer.toHexString((int)value[i] & 255);   
               
            // 添补前4位   
            hex = "0000" + hex;   
            hex = hex.substring(hex.length() - 4, hex.length());   
               
            // 添加空白并且每10位变行(空白区切り、10桁ずつ改行)   
            buf.append(hex + (i % 10 == 9?System.getProperty("line.separator"):" "));   
        }   
        return buf.toString().trim();   
    }   
    
    private static void print(String title, String value) {   
        System.out.println("【 " + title + " 】");   
        System.out.println("-----------------------------");   
        System.out.println(value);   
        System.out.println(getDump16(value.getBytes()));   
        System.out.println();   
        System.out.println();   
    }   
    
    private static void printBytes(byte[] input) {
    	for (int i = 0; i < input.length; i++) {
    		System.out.print(input[i]);
    	}
    	System.out.println();
    }

}
