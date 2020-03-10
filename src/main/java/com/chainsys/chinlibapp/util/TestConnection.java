package com.chainsys.chinlibapp.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

import com.chainsys.chinlibapp.exception.DbException;

public class TestConnection {
	public static Connection getConnection()throws  DbException {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String server = "13.235.147.120";
			TimeZone timeZone = TimeZone.getTimeZone("Asia/Kolkata");
			TimeZone.setDefault(timeZone);
		    connection = DriverManager.getConnection("jdbc:oracle:thin:@" + server + ":1521:XE", "chinraj","chinraj");

			//connection = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:XE","system","oracle");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return connection;
	}
	

}

//Class.forName("oracle.jdbc.driver.OracleDriver");
//String server = "13.235.147.120";// "localhost";
//TimeZone timeZone = TimeZone.getTimeZone("Asia/Kolkata");
//TimeZone.setDefault(timeZone);
//Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@" + server + ":1521:XE", "chinraj","chinraj");
//return connection;