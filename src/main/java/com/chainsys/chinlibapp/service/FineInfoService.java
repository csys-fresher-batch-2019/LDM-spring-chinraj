package com.chainsys.chinlibapp.service;

import org.springframework.stereotype.Service;

import com.chainsys.chinlibapp.dao.imp.FineInfoDAOImpl;
import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.model.FinesInfo;

@Service
public class FineInfoService {

	private FineInfoDAOImpl fineInfoDAO = new FineInfoDAOImpl();

	public void addFineInfo(FinesInfo f) throws DbException {
		fineInfoDAO.addFineInfo(f);
	}

	public void updateFineInfo(FinesInfo i) throws DbException {
		fineInfoDAO.updateFineInfo(i);
	}

	public int updateFineAmount(FinesInfo t) throws DbException {

		int rows = fineInfoDAO.updateFineAmount(t);
		return rows;

	}

	public int finePerStudent(int studentId, long isbn) throws Exception {

		return fineInfoDAO.finePerStudent(studentId, isbn);

	}

	public int bookreturned(int studentId, long isbn) throws DbException {

		return fineInfoDAO.bookReturn(studentId, isbn);

	}

	public int renewal(int studentId, Long isbn) throws DbException {
		return fineInfoDAO.renewal(studentId, isbn);

	}

	public int penalityForBookLost(int studentId, long isbn) throws DbException {

		return fineInfoDAO.penalityForBookLost(studentId, isbn);

	}

	public int renewalCount(int studentId, long isbn) throws DbException {
		return fineInfoDAO.renewalCount(studentId, isbn);
	}
}