package com.chainsys.chinlibapp.util;

import com.chainsys.chinlibapp.exception.DbException;

public class SendMail {

	public static void sendMail(String mail, long ISBN) throws DbException {
		String subject = "Book borrowed from ChinLib";
		String bodyContent = "Hi Student you borrowed a book from ChinLib \n Book ISBN  " + ISBN;
		try {
			SendMailUtil.send("librarychinn@gmail.com", "chinrajkishor", mail, subject, bodyContent);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
