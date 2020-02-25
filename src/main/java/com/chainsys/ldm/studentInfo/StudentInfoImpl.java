package com.chainsys.ldm.studentInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.ldm.bookSummary.TestConnection;

import logger.Logger;

public class StudentInfoImpl implements StudentInfoDAO {
	Logger logger = Logger.getInstance();
	
	public int addStudents(StudentInfo SS) {
		int rows=0;
		String sqlinsert = "insert into student(student_id,student_name,dept_name,mail_id) values(?,?,?,?)";
		logger.info(sqlinsert);
		try (Connection con = TestConnection.getConnection();) {
			try (PreparedStatement stmt = con.prepareStatement(sqlinsert);) {
				stmt.setInt(1, SS.getStudentId());
				stmt.setString(2, SS.getStudentName());
				stmt.setString(3, SS.getDeptName());
				stmt.setString(4, SS.getMailId());
				 rows = stmt.executeUpdate();
				logger.info(rows);
		
				if(rows==1) {
					logger.info("Student added");
					
				}
				else {
					logger.info("Student already exists");
				}}}
				 catch (Exception e) {
						logger.error(e);	
				 }
		return rows;		 }


	public int removeStudent(StudentInfo SS) {
		int row1=0;
	 String sql = "Delete student where student_id= ?";
		
		try (Connection con = TestConnection.getConnection();) {
			try (PreparedStatement stmt = con.prepareStatement(sql);) {
				stmt.setInt(1, SS.getStudentId());
				 row1=stmt.executeUpdate();
				logger.info(row1);
				if(row1==1) {
					logger.info("Student deleted");
				}
				else {
					logger.info("StudentId not exist exists");
				}}}
				 catch (Exception e) {
						logger.error(e);	
				 }
		return row1;
	}							
	
	
	public List<StudentInfo> viewStudents()  {
		List<StudentInfo> list= new ArrayList<StudentInfo>();
	 String sql = "Select * from student";
	 
		
		try(Connection con = TestConnection.getConnection();){
		try(PreparedStatement stmt = con.prepareStatement(sql);){
		try(ResultSet rs = stmt.executeQuery();) {
			
		
			while (rs.next()) {
				StudentInfo b = new StudentInfo();	
				b.setStudentId(rs.getInt("student_id"));
				b.setStudentName(rs.getString("student_name"));
				b.setDeptName(rs.getString("dept_name"));
				b.setMailId(rs.getString("mail_id"));
				list.add(b);
				
			}
	}
		}
} catch (Exception e) {
logger.error(e);
}
return list;
}}


		