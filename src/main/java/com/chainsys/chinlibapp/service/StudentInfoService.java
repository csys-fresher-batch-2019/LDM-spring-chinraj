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
	
	public int addStudents(StudentInfo SS) throws DbException {
		return s.addStudents(SS);
	}
	public int removeStudent(int id) throws DbException {
		return s.removeStudent(id);
		
	}
	public List<StudentInfo> viewStudents() throws DbException{
		return s.viewStudents();
		
	}
	
	
	
}
