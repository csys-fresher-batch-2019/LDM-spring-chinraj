package com.chainsys.chinlibapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.chinlibapp.dao.BookSummaryDAO;
import com.chainsys.chinlibapp.dao.imp.BookSummaryDAOImpl;
import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.model.BookSummary;

@Service
public class BookSumService {

	BookSummaryDAO bs = new BookSummaryDAOImpl();

	public int addBookInfo(BookSummary BS) throws DbException {
		int rows = 0;
		bs.saveBorrowInfo(BS);
		rows = bs.sendMail(BS);
		return rows;
	}

	public List<BookSummary> onParticularDate(LocalDate borrowedDate) throws DbException {
		return bs.onParticularDate(borrowedDate);

	}

	List<BookSummary> viewBookSummary() throws DbException {
		return bs.findBookSummary();
	}

}
