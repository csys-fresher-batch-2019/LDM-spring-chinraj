package com.chainsys.chinlibapp.dao;

import java.util.List;

import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.model.StudentInfo;

public interface StudentInfoDAO {
	
	public int addStudents(StudentInfo SS) throws DbException ;
	public int removeStudent(int id) throws DbException;
	public List<StudentInfo> viewStudents() throws DbException;
	
}
