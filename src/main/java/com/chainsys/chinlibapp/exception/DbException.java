package com.chainsys.chinlibapp.exception;

import java.sql.SQLException;

public class DbException extends Exception {

	public DbException(String msg, SQLException e) {
		super(msg, e);
	}

}
