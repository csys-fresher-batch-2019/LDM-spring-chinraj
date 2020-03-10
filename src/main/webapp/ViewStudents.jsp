<!DOCTYPE html>
<%@page import="com.chainsys.chinlibapp.model.StudentInfo"%>
<%@page import="java.util.List"%>
<%@page import="com.chainsys.chinlibapp.dao.imp.StudentInfoDAOImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<body style="background-color: DarkKhaki">
</head>
<body>
	<jsp:include page="index.jsp"></jsp:include>
	<br />
	<h2>VIEW STUDENTS</h2>

	<%
		StudentInfoDAOImpl dao = new StudentInfoDAOImpl();

			List<StudentInfo> list1 = dao.viewStudents();
	%>
	<table border="1">
		<thead>
			<tr>
			
				<th>Student Id</th>
				<th>Student Name</th>
				<th>Department Name</th>
				<th>Mail Id</th>
			</tr>
		</thead>
		<tbody>
						<c:set var="BookList" value="<%=list1%>"></c:set>
			<c:forEach items="${BookList}" var="b">
			<tr>
		
			<td>${b.studentId}</td>
			<td>${b.studentName}</td>
			<td>${b.deptName}</td>
			<td>${b.mailId}</td>
			
			</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>