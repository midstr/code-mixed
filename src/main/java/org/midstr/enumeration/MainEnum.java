package org.midstr.enumeration;


public class MainEnum {
	
	// 使用接口组织枚举
	interface OS {
		enum MobileOS implements OS{
			IPHONE, ANDROID;
		}
		
		enum ComputerOS implements OS{
			WINDOWS, LINUX;
		}
	}
	
	// 枚举的枚举
	enum Course {
		MOBILEOS(OS.MobileOS.class),
		COMPUTEROS(OS.ComputerOS.class);
		private OS[] values;
		private Course(Class<? extends OS> kind) {
			values = kind.getEnumConstants();
		}
		
		public OS random() {
			return Enums.random(values);
		}
	}
	
	//枚举嵌套枚举
	enum OSCategory {
		Mob_OS(OS1.MobileOS.class), Com_OS(OS1.ComputerOS.class);
		private OS1[] values;
		private OSCategory(Class<? extends OS1> clazz) {
			values = clazz.getEnumConstants();
		}
		interface OS1{
			enum MobileOS implements OS1{IPHONE, ANDROID};
			enum ComputerOS implements OS1{WINDOWS, LINUX};
		}
		
		public OS1 randomSelection() {
			return Enums.random(values);
		}
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SuitEnum suit = Enum.valueOf(SuitEnum.class, "CLUBS");
		Enum<SuitEnum> e = suit;
		System.out.println(e);
		
		// enum switch
		switch (suit) {
		case CLUBS:
			System.out.println(1);
			break;
		case DIAMONDS:
			System.out.println(2);
			break;
		}
		
		//OS os1 = OS.MobileOS.IPHONE;
		//OS os2 = OS.ComputerOS.WINDOWS;
		System.out.println(Course.MOBILEOS.random());
	}
	

}
