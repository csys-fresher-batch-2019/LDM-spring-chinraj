package com.chainsys.chinlibapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

import com.chainsys.chinlibapp.exception.DbException;

public class ConnectionUtil {
	public static Connection getConnection() throws DbException {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String server = "13.235.147.120";// "localhost";
			TimeZone timeZone = TimeZone.getTimeZone("Asia/Kolkata");
			TimeZone.setDefault(timeZone);

			connection = DriverManager.getConnection("jdbc:oracle:thin:@" + server + ":1521:XE", "chinraj", "chinraj");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
// String server = "13.235.147.120";// "localhost";
// TimeZone timeZone = TimeZone.getTimeZone("Asia/Kolkata");
// TimeZone.setDefault(timeZone);
// connection = DriverManager.getConnection("jdbc:oracle:thin:@" + server +
// ":1521:XE", "chinraj","chinraj");