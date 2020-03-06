package com.chainsys.chinlibapp.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.chinlibapp.dao.imp.StudentInfoImpl;
import com.chainsys.chinlibapp.model.StudentInfo;

@RestController
@RequestMapping("api")
public class StudentControl {
	StudentInfoImpl m = new StudentInfoImpl();

	@PostMapping("/addStudents")
	public void addStudents(

			@RequestParam("student_id") Integer studentId, @RequestParam("student_name") String studentName,
			@RequestParam("dept_name") String deptName, @RequestParam("mail_id") String mailId) {

		StudentInfo n = new StudentInfo();

		n.setStudentId(studentId);
		n.setStudentName(studentName);
		n.setMailId(mailId);
		n.setDeptName(deptName);

		m.addStudents(n);

	}

	@GetMapping("/viewStudents")
	public List<StudentInfo> viewStudents() {
		return m.viewStudents();
	}

	@PostMapping("/removeStudent")
	public void removeStudent(@RequestParam int id) {

		m.removeStudent(id);
	}

}
