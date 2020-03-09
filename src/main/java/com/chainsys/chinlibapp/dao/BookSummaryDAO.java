package com.chainsys.chinlibapp.dao;

import java.time.LocalDate;
import java.util.List;

import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.model.BookSummary;

public interface BookSummaryDAO {
	int addBookInfo(BookSummary BS) throws DbException;
	List<BookSummary> onParticularDate (LocalDate borrowedDate) throws DbException;
	 List<BookSummary> viewBookSummary() throws DbException;
}
