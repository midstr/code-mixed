package org.midstr.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Oracle {
	public Oracle() {
	}

	public static void main(String args[]) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@219.242.255.214:1521:DBHR", "system",
					"liyg1226");
			Statement stmt = conn.createStatement();
			String sql = "select * from  help";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println("Username:" + rs.getString(1));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}