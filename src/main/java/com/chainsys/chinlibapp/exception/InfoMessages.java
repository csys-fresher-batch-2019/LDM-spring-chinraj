package com.chainsys.chinlibapp.exception;

public class InfoMessages {

	private InfoMessages() {
		throw new IllegalStateException("Utility class");

	}

	public static final String FAILED_TO_CHECK_BOOKSTATUS = "unable to check book status";
	public static final String FAILED_TO_UPDATE_BOOKSTATUS = "unable to update book status";
	public static final String BORROW_INSERT_FAILED = "unable to insert borrow detail";
	public static final String FAILED_TO_SELECT_BORROWDATE = "unable to select borrowdate";
	public static final String FAILED_TO_SELECT_BOOKSUMMARY = "unable to view book summary";
	public static final String FAILED_TO_SENDMAIL = "unable to send mail";
	public static final String FAILED_TO_SELECT_BOOKNAME = "unable to select book name";
	public static final String FAILED_TO_DELETE_ISBN = "unable to delete book";
	public static final String FAILED_TO_SELECT_BOOKLIST = "unable to view booklist";
	public static final String FAILED_TO_ADD_BOOK = " unable to add book";
	public static final String FAILED_TO_ADD_FINE_INFO = "unable to add fine info";
	public static final String FAILED_TO_UPDATE_FINE_INFO = "unable to update fine info";
	public static final String FAILED_TO_UPDATE_FINE_AMOUNT = "unable to update fine amount";
	public static final String FAILED_TO_UPDATE_TOTAL_FINE_AMOUNT = "unable to update total fine amount";
	public static final String FAILED_TO_SELECT_FINE = "unable to select fine";
	public static final String FAILED_TO_DELETE_FINE_AMOUNT = "unable to select fine amount";
	public static final String FAILED_TO_UPDATE_BOOK_STATUS = "unable to update book status";
	public static final String FAILED_TO_UPDATE_BOOK_SUMMARY = "unable to update book summary";
	public static final String FAILED_TO_RETURN_BOOK = "unable to return book";
	public static final String FALED_TO_GET_BOOK_PRICE = "unable to get book price";
	public static final String FAILED_TO_UPDATE_LOST_PENALITY = "unable to update lost penality";
	public static final String FALIED_TO_UPDATE_RENEWAL_COUNT = "unable to update renewal count";
	public static final String FAILED_TO_RENEWAL = "unable to renewal book";
	public static final String FAILED_TO_SELECT_RENEWAL_COUNT = "unable to select renewal count";
	public static final String FAILED_TO_CALL_LIB_WALLET_PROC = "unable to call lib wall procedure";
	public static final String FAILED_TO_UPDATE_AMOUNT_IN_ID = "unable to update amount in id";
	public static final String FAILED_TO_UPDATE_FINE_STATUS = "unable to update fine status";
	public static final String FAILED_TO_UPDATE_AFTER_FINE_PAY = "unable to update after fine pay";
	public static final String FAILED_TO_UPDATE_MONEY = "unable to update money";
	public static final String FAILED_TO_ADD_MONEY = "unable to add money";
	public static final String FAILED_TO_SELECT_STUDENT = "unable to view students";
	public static final String FAILED_TO_DELETE_STUDENT = "unable to delete student";
	public static final String FAILED_TO_ADD_STUDENTS = "unable to add students";

}