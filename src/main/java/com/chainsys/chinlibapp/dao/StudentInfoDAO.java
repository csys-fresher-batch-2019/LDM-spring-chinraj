package com.chainsys.chinlibapp.dao;

import java.util.List;

import com.chainsys.chinlibapp.model.StudentInfo;

public interface StudentInfoDAO {
	
	public int addStudents(StudentInfo SS) ;
	public int removeStudent(int id);
	public List<StudentInfo> viewStudents();
	
}
