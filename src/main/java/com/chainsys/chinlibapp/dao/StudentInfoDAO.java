package com.chainsys.chinlibapp.dao;

import java.util.List;

import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.model.StudentInfo;

public interface StudentInfoDAO {

	public int saveStudent(StudentInfo SS) throws DbException;

	public int deleteStudent(int id) throws DbException;

	public List<StudentInfo> viewStudents() throws DbException;

}
