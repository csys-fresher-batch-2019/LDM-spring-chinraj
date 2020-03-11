package com.chainsys.chinlibapp.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.chinlibapp.dao.StudentInfoDAO;
import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.exception.InfoMessages;
import com.chainsys.chinlibapp.logger.Logger;
import com.chainsys.chinlibapp.model.StudentInfo;
import com.chainsys.chinlibapp.util.TestConnection;

@Repository
public class StudentInfoDAOImpl implements StudentInfoDAO {
	Logger logger = Logger.getInstance();

	public int saveStudent(StudentInfo SS) throws DbException {
		int rows = 0;
		String sqlinsert = "insert into student(student_id,student_name,dept_name,mail_id) values(?,?,?,?)";
		logger.info(sqlinsert);
		try (Connection con = TestConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sqlinsert);) {
			stmt.setInt(1, SS.getStudentId());
			stmt.setString(2, SS.getStudentName());
			stmt.setString(3, SS.getDepartmentName());
			stmt.setString(4, SS.getMailId());
			rows = stmt.executeUpdate();
			logger.info(rows);

			if (rows == 1) {
				logger.info("Student added");

			} else {
				logger.info("Student already exists");

			}

		} catch (SQLException e) {
			logger.error(e);
			throw new DbException(InfoMessages.FAILED_TO_ADD_STUDENTS, e);

		}
		return rows;
	}

	public int deleteStudent(int id) throws DbException {
		int row1 = 0;
		String sql = "Delete student where student_id= ?";

		try (Connection con = TestConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setInt(1, id);
			row1 = stmt.executeUpdate();
			if (row1 == 1) {
				logger.info("Student deleted");
			} else {
				logger.info("StudentId not exist exists");
			}

		} catch (SQLException e) {
			logger.debug(e.getMessage());
			throw new DbException(InfoMessages.FAILED_TO_DELETE_STUDENT, e);

		}
		return row1;
	}

	public List<StudentInfo> viewStudents() throws DbException {
		List<StudentInfo> list = new ArrayList<StudentInfo>();
		String sql = "Select * from student";

		try (Connection con = TestConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				StudentInfo b = new StudentInfo();
				b.setStudentId(rs.getInt("student_id"));
				b.setStudentName(rs.getString("student_name"));
				b.setDepartmentName(rs.getString("dept_name"));
				b.setMailId(rs.getString("mail_id"));
				list.add(b);

			}
		} catch (SQLException e) {
			logger.error(e);
			throw new DbException(InfoMessages.FAILED_TO_SELECT_STUDENT, e);

		}
		return list;
	}
}
