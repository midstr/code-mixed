/**
 * 
 */
package org.test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * @author yaogangli
 * @date 2011-8-29 下午04:27:42
 */
public class ProxyTools {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		System.setProperty("http.proxySet", "true");
		System.setProperty("http.proxyHost", "proxy.tencent.com");
		System.setProperty("http.proxyPort", "8080");
		
		String location = "http://3gimg.qq.com/info/app/astro/images/cancer.png";
		URL url = new URL(location);
		HttpURLConnection uc = null;
		InputStream in = null;
		try {
			uc = (HttpURLConnection) url.openConnection();
			uc.setConnectTimeout(500);
			uc.setReadTimeout(3000);
			String contentType = uc.getContentType();
			int contentLength = uc.getContentLength();
			System.out.println(contentType + ":" + contentLength);
			// QQ头像的contentType是application/octet-stream
			if (contentLength <= 0) {
				throw new IOException("illegal content length: " + contentLength);
			}
			if (!(contentType.startsWith("image/") || contentType.equals("application/octet-stream"))) {
				throw new IllegalStateException("illegal content type: " + contentType);
			}
			in = new BufferedInputStream(uc.getInputStream());
			byte[] data = new byte[contentLength];
			int bytesRead = 0;
			int offset = 0;
			while (offset < contentLength) {
				bytesRead = in.read(data, offset, data.length - offset);
				if (bytesRead == -1)
					break;
				offset += bytesRead;
			}
			if (offset != contentLength) {
				throw new IOException("Only read " + offset + "/" + contentLength + " bytes");
			}
			System.out.println("data:" + data.length);
		} finally {
			if (uc != null) {
				uc.disconnect();
			}
			try {
				if (in != null)
					in.close();
			} catch (Exception e) {
			} finally {
				if (in != null)
					in.close();
			}
		}
		
		
//		URL url = new URL("http://data.gtimg.cn/flashdata/hushen/minute/sh600016.js?maxage=10");
//		//SocketAddress addr = new InetSocketAddress("proxy.tencent.com", 8080);// 是代理地址:192.9.208.16:3128
//		//Proxy typeProxy = new Proxy(Proxy.Type.HTTP, addr);
//		//HttpURLConnection con = (HttpURLConnection) url.openConnection(typeProxy);
//		HttpURLConnection con = (HttpURLConnection)url.openConnection();
//		con.setReadTimeout(45 * 1000);
//		con.setConnectTimeout(15 * 1000);
//		con.connect();
//
//		System.out.println(con.getContentEncoding());
//		System.out.println(con.getContentLength());
//		System.out.println(con.getContentType());
//		System.out.println(con.getResponseCode());
//		System.out.println(con.getResponseMessage());
//
//		InputStream is = con.getInputStream();
//		InputStreamReader isr = new InputStreamReader(is);
//		BufferedReader br = new BufferedReader(isr);
//		StringBuilder sb = new StringBuilder();
//		String line = null;
//		while ((line = br.readLine()) != null) {
//			sb.append(line);
//		}
//		System.out.println(sb.toString());
//		//System.out.println(is.re);
//		// System.out.println(IOUtils.toString(is));
//		System.exit(0);
	}

}
