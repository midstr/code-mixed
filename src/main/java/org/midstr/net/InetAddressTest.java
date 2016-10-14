package org.midstr.net;

import java.net.InetAddress;

public class InetAddressTest {
	public static void main(String[] args) {
		try {
			if (args.length > 0) {
				String host = args[0];
				InetAddress[] addresses = InetAddress.getAllByName(host);
				for (int i = 0; i < addresses.length; i++)
					System.out.println(addresses[i]);
			} else {
				InetAddress localHostAddress = InetAddress.getLocalHost();
				System.out.println(localHostAddress.getHostAddress());
				System.out.println(localHostAddress);
			}
		} catch (Exception e) {
			System.out.println("Error:   " + e);
		}
	}
}
