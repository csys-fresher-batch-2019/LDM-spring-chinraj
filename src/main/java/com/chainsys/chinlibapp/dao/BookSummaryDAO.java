package com.chainsys.chinlibapp.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.model.BookSummary;

public interface BookSummaryDAO {
	public boolean checkBookStatus(long fg) throws DbException, SQLException;
	int addBookInfo(BookSummary BS) throws DbException;
	List<BookSummary> onParticularDate (LocalDate borrowedDate) throws DbException;
	 List<BookSummary> viewBookSummary() throws DbException;
	 public int updateBookStatus(BookSummary BS) throws DbException;
	 public void sendMail(BookSummary BS) throws DbException ;
					
}
