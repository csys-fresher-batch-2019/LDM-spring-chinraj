package com.chainsys.chinlibapp.connectionutil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.TimeZone;
public class ConnectionUtil {

	
	
		public static Connection connect() throws Exception {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String server = "13.235.147.120";// "localhost";
			TimeZone timeZone = TimeZone.getTimeZone("Asia/Kolkata");
				TimeZone.setDefault(timeZone);
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@" + server + ":1521:XE", "chinraj",
					"chinraj");
			return connection;
		}
	}

