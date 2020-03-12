package com.chainsys.chinlibapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.chinlibapp.dao.StudentInfoDAO;
import com.chainsys.chinlibapp.dao.imp.StudentInfoDAOImpl;
import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.model.StudentInfo;

@Service
public class StudentInfoService {

	StudentInfoDAO s = new StudentInfoDAOImpl();

	public int addStudents(StudentInfo k) throws DbException {
		return s.saveStudent(k);
	}

	public int removeStudent(int id) throws DbException {
		return s.deleteStudent(id);

	}

	public List<StudentInfo> viewStudents() throws DbException {
		return s.viewStudents();

	}

}
