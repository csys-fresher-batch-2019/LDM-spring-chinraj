package com.chainsys.ldm.studentInfo;

import java.util.List;

public interface StudentInfoDAO {
	
	public int addStudents(StudentInfo SS) ;
	public int removeStudent(int id);
	public List<StudentInfo> viewStudents();
	
}
