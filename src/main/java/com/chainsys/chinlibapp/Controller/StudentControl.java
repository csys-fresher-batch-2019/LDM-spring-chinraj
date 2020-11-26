package com.chainsys.chinlibapp.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.chinlibapp.dao.imp.StudentInfoDAOImpl;
import com.chainsys.chinlibapp.dto.Message;
import com.chainsys.chinlibapp.exception.DbException;
import com.chainsys.chinlibapp.model.StudentInfo;

@RestController
@RequestMapping("api")
public class StudentControl {
	StudentInfoDAOImpl m = new StudentInfoDAOImpl();

	@PostMapping("/addStudents")
	public ResponseEntity<Message> addStudents(

			@RequestParam("student_id") Integer studentId, @RequestParam("student_name") String studentName,
			@RequestParam("dept_name") String deptName, @RequestParam("mail_id") String mailId) throws DbException {

		StudentInfo n = new StudentInfo();

		n.setStudentId(studentId);
		n.setStudentName(studentName);
		n.setMailId(mailId);
		n.setDepartmentName(deptName);

		
		try {
			
			m.saveStudent(n);
				return new ResponseEntity<Message>(HttpStatus.OK);
			}
				
				
				catch (Exception e) {
				e.printStackTrace();
				Message msg = new Message();

				msg.setErrorMessage(e.getMessage());
			
				return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
			}
		}	
	

	@GetMapping("/viewStudents")
	public List<StudentInfo> viewStudents() throws DbException {
		return m.viewStudents();
	}

	@PostMapping("/removeStudent")
	public void removeStudent(@RequestParam int id) throws DbException {

		m.deleteStudent(id);
	}

}
