package com.chainsys.chinlibapp.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.model.BookSummary;

public interface BookSummaryDAO {
	public boolean checkBookStatus(long fg) throws DbException, SQLException;

	int saveBorrowInfo(BookSummary b) throws DbException;

	List<BookSummary> onParticularDate(LocalDate borrowedDate) throws DbException;

	List<BookSummary> findBookSummary() throws DbException;

	public int updateBookStatus(BookSummary b) throws DbException;

	public int sendMail(BookSummary b) throws DbException;

}
