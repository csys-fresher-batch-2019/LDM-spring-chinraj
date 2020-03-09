package com.chainsys.chinlibapp.exception;

public class InfoMessages {


	private InfoMessages() {
	throw new IllegalStateException("Utility class");
			
		}
		
		public static final String INVALID_CONNECTION = "connection not establish";
		public static final String INVALID_INSERT = "insertion not establish";
		public static final String INVALID_UPDATE = "update not establish";
		public static final String INVALID_DELETE = "delete not establish";
		public static final String INVALID_SELECT = "select not establish";
		public static final String INVALID_PROCEDURE = "procedure not establish";
		

	}