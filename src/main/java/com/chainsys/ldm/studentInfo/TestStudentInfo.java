package com.chainsys.ldm.studentInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.chainsys.chinlibapp.dao.imp.StudentInfoDAOImpl;
import com.chainsys.chinlibapp.logger.Logger;
import com.chainsys.chinlibapp.model.StudentInfo;

public class TestStudentInfo {
	

	
	public static void main (String [] args) throws Exception{
		
		Scanner s = new Scanner(System.in);
		StudentInfo SI = new StudentInfo();
		StudentInfoDAOImpl d = new StudentInfoDAOImpl();
		Logger logger = Logger.getInstance();
		
		System.out.println("\n 1.Add students/n 2.delete Student");
		int n = s.nextInt();
		switch (n) {
		case 1: 
		{
		 logger.info("Enter studentId :");
		SI.setStudentId(s.nextInt());
		 logger.info("Enter studentName :");
		SI.setStudentName(s.next());
		 logger.info("Enter deptName :");
		SI.setDepartmentName(s.next());
		logger.info("Enter mail :");
		SI.setMailId(s.next());
		d.saveStudent(SI);
		
	}
		case 2:{
			 logger.info("Enter studentId :");
				SI.setStudentId(s.nextInt());
				d.deleteStudent(SI.getStudentId());
		}
		
		case 3:{
			
			StudentInfoDAOImpl obj = new StudentInfoDAOImpl();
				System.out.println(" StudentList  :");
				List<StudentInfo> li = new ArrayList<StudentInfo>();
			   li = obj.viewStudents();
			   for(Object object:li)
				   System.out.println(object);
			 
			}s.close();
		}
	}}
		
		
