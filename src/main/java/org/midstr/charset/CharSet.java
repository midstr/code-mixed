package org.midstr.charset;
import java.io.UnsupportedEncodingException;



public class CharSet {
	
	public static void parse() throws Exception{
//		String sTxtContent = "UEsDBBQAAAAIAMqtXjmiN2NroQAAAMcAAAAKAAAAZGV2NTk3LnRtcF2O3QqCMABG7wXfwaf2XkSYWqJg/o3UynBzabEmpQ9gEETECIIoahdCdL6L7/Icn+9I+UBkdQsBS2RJlmI7GsQrgoayJAD7Pnibqqm6pDhXDoVsiV6oVfC2OaXrymuf+oT1XsqSWU+KENQGzUMQ25mVWbWBeX5hU8w9GA2ILO4Ulvm8O1xZhzmFbqTpwqZ92Rx9MtrHKf/8loiOykGtLH0AUEsBAhQAFAAAAAgAyq1eOaI3Y2uhAAAAxwAAAAoAAAAAAAAAAAAgAAAAAAAAAGRldjU5Ny50bXBQSwUGAAAAAAEAAQA4AAAAyQAAAAAA";
//		String sTxtContent1 = "UEsDBBQAAAAIAMytXjmiN2NroQAAAMcAAAAKAAAAZGV2NUFBLnRtcF2O3QqCMABG7wXfwaf2XkSYWqJg/o3UynBzabEmpQ9gEETECIIoahdCdL6L7/Icn+9I+UBkdQsBS2RJlmI7GsQrgoayJAD7Pnibqqm6pDhXDoVsiV6oVfC2OaXrymuf+oT1XsqSWU+KENQGzUMQ25mVWbWBeX5hU8w9GA2ILO4Ulvm8O1xZhzmFbqTpwqZ92Rx9MtrHKf/8loiOykGtLH0AUEsBAhQAFAAAAAgAzK1eOaI3Y2uhAAAAxwAAAAoAAAAAAAAAAAAgAAAAAAAAAGRldjVBQS50bXBQSwUGAAAAAAEAAQA4AAAAyQAAAAAA";
//		String sTxtContent2 = "UEsDBBQAAAAIAMytXjmiN2NroQAAAMcAAAAKAAAAZGV2NUI1LnRtcF2O3QqCMABG7wXfwaf2XkSYWqJg/o3UynBzabEmpQ9gEETECIIoahdCdL6L7/Icn+9I+UBkdQsBS2RJlmI7GsQrgoayJAD7Pnibqqm6pDhXDoVsiV6oVfC2OaXrymuf+oT1XsqSWU+KENQGzUMQ25mVWbWBeX5hU8w9GA2ILO4Ulvm8O1xZhzmFbqTpwqZ92Rx9MtrHKf/8loiOykGtLH0AUEsBAhQAFAAAAAgAzK1eOaI3Y2uhAAAAxwAAAAoAAAAAAAAAAAAgAAAAAAAAAGRldjVCNS50bXBQSwUGAAAAAAEAAQA4AAAAyQAAAAAA";
		String sTxtContent3 = "UEsDBBQAAAAIAOitXjnFrR48sgAAAO0AAAAKAAAAZGV2NUJCLnRtcGWO2wqCQBRF3wX/wT/xL30XEbyjYF5JrQxHJzWmsdIPMAgiQoJAipoHIWod2Odlw172sIXZA8DVzZVwQFM05ateTz5DqBAOsO5Iu855yZzMmTA9FwYK8RI8QcPkdXWK1oXVjIKGOyvCwayDqSuVIkpcyVdjJVZKMR+SC9bzwQq9HsDFHYVZMm8PV9zmAwpNT9DqPeDrkXR5gWzzHzZHG04u0zG/fFsRp8IADU2xLCn/5xtQSwECFAAUAAAACADorV45xa0ePLIAAADtAAAACgAAAAAAAAAAACAAAAAAAAAAZGV2NUJCLnRtcFBLBQYAAAAAAQABADgAAADaAAAAAAA=";
		// 反Base64编码
		byte[] decodeTxt = new sun.misc.BASE64Decoder()
				.decodeBuffer(new String(sTxtContent3.getBytes()));

		// 解压缩Zip
		byte[] unZippedTxt = new byte[0];
		if (decodeTxt != null && decodeTxt.length > 0) {
			//unZippedTxt = ZipUtils.unZipFile(decodeTxt).toByteArray();
		}
		String rlt = new String(unZippedTxt);
		System.out.println(rlt);
		rlt = rlt.replaceAll("[?]", "");
		System.out.println(rlt);
	}
	
	public static void printArray(byte[] asb){
		for (int i = 0; i < asb.length; i++) {
			System.out.print(asb[i]);
		}
		System.out.println();
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		testCharset();
		parse();
	}

	private static void testCharset() throws UnsupportedEncodingException {
		//msg_Title=%3f%3f%3f%3f&msg_Content=%3f%3f%3f%3f%2c%3f%3f%3f%3f&url_to=viewanswer.jsp%3fid%3d2
		System.out.println(java.net.URLEncoder.encode("李耀岗", "UTF-8"));
		System.out.println(java.net.URLEncoder.encode("李耀岗", "GBK"));
		System.out.println(java.net.URLEncoder.encode("李耀岗", "GB2312"));		
		System.out.println(java.net.URLEncoder.encode("李耀岗", "ISO-8859-1"));
		printArray("李耀岗".getBytes());
		printArray("李耀岗".getBytes("GBK"));
		printArray("李耀岗".getBytes("UTF-8"));
		printArray("李耀岗".getBytes("ISO-8859-1"));
		

		System.out.println(new String("回复成功".getBytes("GBK"), "UTF-8"));
		System.out.println(new String("回复成功".getBytes("GBK"), "ISO-8859-1"));
		String t1 = java.net.URLEncoder.encode(new String("回复成功".getBytes(), "GBK"), "ISO-8859-1");
		System.out.println(t1);
		String test = "li李耀岗";
		String testcode = java.net.URLEncoder.encode(test, "ISO-8859-1");
		System.out.println(testcode);
		System.out.println(java.net.URLDecoder.decode(testcode, "ISO-8859-1"));
		System.out.println(java.net.URLDecoder.decode("%BB%D8%B8%B4%B3%C9%B9%A6", "GBk"));
		System.out.println(new String("%BB%D8%B8%B4%B3%C9%B9%A6".getBytes("ISO-8859-1"), "ISO-8859-1"));
		System.out.println("1".getBytes("UTF-8").length);
		System.out.println("离".getBytes("UTF-8").length);
		//getBytes()
		//%BB%D8%B8%B4%B3%C9%B9%A6
		//System.out.println(java.net.URLEncoder.encode(test));
		//System.out.println(java.net.URLEncoder.encode(test, "UTF-8"));
		//System.out.println(java.net.URLEncoder.encode(test, "GBK"));
		//%BB%D8%B8%B4%B3%C9%B9%A6
		//System.out.println(new String("%3f%3f%3f%3f".getBytes("ISO-8859-1"), "GBK"));
	}

}
