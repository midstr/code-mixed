package org.midstr.encrypt;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;



/**
 * <p>Title:</p>
 * <p>Description:
 * �Ӹ����滻��������ص㿴������������ʺ����ڼ��׼ӽ������㣬���ַ�����ԭ����:��һ����A����һ����B������
 * �������������һ����C������ٽ�C��B�������������C�ֻỹԭΪA��
 * ����������ļ��׼����㷨��XOR�㷨���ŵ����¡�
 * (1)�㷨�򵥣����ڸ߼����Ժ�������ʵ�֡�
 * (2)�ٶȿ죬�������κ�ʱ���κεط�ʹ�á�
 * (3)���κ��ַ�������Ч�ģ�������Щ���׼����㷨��ֻ�������ַ���Ч�������ļ��ܺ��ٽ����޷���ԭΪԭ�����ַ�
 * </p>
 * <p>Company:�����Ϲ⻪������ɷ����޹�˾</p>
 * @author liyg
 * @version 1.0
 * @date Jul 9, 2009 7:50:08 PM
 */
public class TestXOR {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		//String value = "�⡢�߲˺�ˮ��";   
        // String key = "�߲˺�ˮ��";   
        String value = "http://blog.csdn.net/froole/archive/2009/05/13/4176111.aspx";   
        String key = "liyg";   
           
        // ����ǰ���   
        print("����ǰ", value);   
        // ���ܴ���   
        byte[] byteEncodeArray = encode(value.getBytes(), key);   
        value = new String(byteEncodeArray);   
           
        // ���ܺ����   
        print("���ܺ�", value);   
           
        // URLת������   
        String encode = URLEncoder.encode(value, "UTF-8");   
        print("ת��URL", encode);   
        String dencode = URLDecoder.decode(encode, "UTF-8");   
        print("��URL�ָ�", dencode);   
        value = dencode;   
           
        // ����   
        byte[] byteDecodeArray = decode(value.getBytes(), key);   
        value = new String(byteDecodeArray);   
           
        // ���ܺ����   
        print("���ܺ�", value);   
        
        printBytes("abc".getBytes());
        
        byte a = (byte)129;
        System.out.println(a + "--" +Integer.toBinaryString(a));
        System.out.println(Byte.SIZE + ":" + Byte.MAX_VALUE + ":" + Byte.MIN_VALUE);
        System.out.println(Short.SIZE + ":" + Short.MAX_VALUE + ":" + Short.MIN_VALUE );
	}
	/**  
     * ���ܴ���  
     * @param src  
     * @param key  
     * @return  
     */  
    private static byte[] encode(byte[] src, String key) {   
        byte[] byteKeyArray = new byte[0];   
        byte[] byteEncArray = new byte[src.length];   
           
        // ת������Կ�׵�ѭ������   
        while(byteKeyArray.length < src.length) {   
            byteKeyArray = (new String(byteKeyArray) + key).getBytes();   
        }   
        //System.out.println("debug:" + new String(byteKeyArray));   
        // ת��   
        for (int i = 0; i < src.length; i++) {   
            byteEncArray[i] = (byte)(src[i]^byteKeyArray[i]);   
        }   
        return byteEncArray;   
    }   
       
    /**  
     * ����  
     * @param src  
     * @param key  
     * @return  
     */  
    private static byte[] decode(byte[] src, String key) {   
        return encode(src, key);   
    }   
       
    /**  
     * ת����16��������  
     * @param value  
     * @return  
     */  
    private static String getDump16(byte[] value) {   
        StringBuffer buf = new StringBuffer();   
        for (int i = 0; i < value.length; i++) {   
        	// why?
        	System.out.println(((int)value[i]) + "---" + ((int)value[i] & 255));
            String hex = Integer.toHexString((int)value[i] & 255);   
               
            // ��ǰ4λ   
            hex = "0000" + hex;   
            hex = hex.substring(hex.length() - 4, hex.length());   
               
            // ��ӿհײ���ÿ10λ����(�հ����Фꡢ10�줺�ĸ���)   
            buf.append(hex + (i % 10 == 9?System.getProperty("line.separator"):" "));   
        }   
        return buf.toString().trim();   
    }   
    
    private static void print(String title, String value) {   
        System.out.println("�� " + title + " ��");   
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
