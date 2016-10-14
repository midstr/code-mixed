/*
 * filename: Test.java
 * date    : May 9, 2008
 * author  : liyg
 * version : 1.0
 */
package org.midstr.prop;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class PropUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//old();
		testSplit();
	}
	
	
	
	public static void testSplit () throws IOException {
		//ResourceBundle rb = PropertyResourceBundle.getBundle("org.midstr.prop.file");
		//System.out.println(rb.getStringArray("name0.name"));
		Properties p = new Properties();
		p.load(PropUtils.class.getResourceAsStream("file.properties"));
		System.out.println(p.getProperty("birthday"));
	}

	/**
	 * @throws IOException
	 */
	public static void old() throws IOException {
		System.out.println("" + File.separatorChar + "WEB-INF"
				+ File.separatorChar + "classes" + File.separatorChar
				+ "props");
		// 绗竴绉嶆柟娉曪細鐩存帴浣跨敤ResourceBundle鐨勬瀯閫犳柟娉曞拰InputStream娴佺粦瀹�
		ResourceBundle rb1 = new PropertyResourceBundle(
				PropUtils.class.getResourceAsStream("file.properties"));
		System.out.println(rb1.getString("name"));
		
		// 涓嬮潰鐨勪唬鐮侊紝鍏跺疄灏辨槸PropertyResourceBundle鏋勯�犳柟娉曠殑瀹炵幇鏂瑰紡
		Properties p = new Properties();
		p.load(PropUtils.class.getResourceAsStream("file.properties"));
		System.out.println(p.getProperty("name"));
		
		System.out.println(PropUtils.class.getResource("file.properties").getFile());
		//Properties sys = System.getProperties();
		/*for (int i = 0; i < sys.size(); i++){
			//System.out.println();
		}
		Iterator it = sys.values().iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}*/
		
		// 绗簩绉嶆柟娉曪細浣跨敤PropertyResourceBundle鐨刧etBundle鏂规硶锛屽垏蹇屼笉鑳藉甫鍚庣紑
		//           骞朵笖鍦ㄨ繖閲岋紝鈥�.鈥濄�佲�淺鈥濅篃鍙互鏇挎崲涓�"/"锛屽疄璐ㄤ笂鏄▼搴忚嚜宸卞皢瀹冧滑杞崲涓衡��/鈥�
		ResourceBundle rb2 = PropertyResourceBundle.getBundle("org.midstr.prop.file");
		System.out.println(PropUtils.class.getPackage().getName() + ".file");
		System.out.println(rb2.getString("name"));
		
		ResourceBundle rb3 = PropertyResourceBundle.getBundle("log4j");
		System.out.println(rb3.getString("log4j.rootLogger"));
		
		PropUtils t = new PropUtils();
		System.out.println(t.getRes());
		t.loadPro();
		/*System.out.println(TestJndi.class.getName());
		ResourceBundle rb4 = ResourceBundle.getBundle(TestJndi.class.getName()+".class");*/
		
		System.out.println(System.identityHashCode(PropUtils.class));
	}
	
	public String getRes(){
		System.out.println(System.class.getResourceAsStream("/./././log4j.properties"));
		return this.getClass().getProtectionDomain().getCodeSource().getLocation().getFile();
	}
	
	public void loadPro(){
		File file = new File("src/log4j.properties");
		System.out.println(file.exists());
		System.out.println(file.getAbsolutePath());
		try {
			ResourceBundle rb = new PropertyResourceBundle(
					this.getClass().getResourceAsStream("/./././log4j.properties"));
			System.out.println(rb.getString("log4j.rootLogger"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
