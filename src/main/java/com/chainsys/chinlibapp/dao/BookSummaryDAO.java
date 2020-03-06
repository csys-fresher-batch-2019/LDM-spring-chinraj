package com.chainsys.chinlibapp.dao;

import java.time.LocalDate;
import java.util.List;

import com.chainsys.chinlibapp.model.BookSummary;

public interface BookSummaryDAO {
	int addBookInfo(BookSummary BS);
	List<BookSummary> onParticularDate (LocalDate borrowedDate);
	 List<BookSummary> viewBookSummary();
}
