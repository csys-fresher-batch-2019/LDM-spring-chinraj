<!DOCTYPE html>
<%@page import="com.chainsys.ldm.studentInfo.StudentInfo"%>
<%@page import="java.util.List"%>
<%@page import="com.chainsys.ldm.studentInfo.StudentInfoImpl"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<body style = "background-color:DarkKhaki">
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>
<br/>
<h2>VIEW STUDENTS</h2>

<%
StudentInfoImpl dao = new StudentInfoImpl();

List<StudentInfo> list1 = dao.viewStudents();
%>
<table border="1">
<thead><tr><th>S.no</th> <th> Student Id </th><th>Student Name</th><th>Department Name</th><th>Mail Id</th></tr></thead>
<tbody>
<%
int i= 1;
for(StudentInfo f : list1){
%>
<tr><td> <%= i++  %></td><td><%=f.getStudentId() %></td><td><%= f.getStudentName()  %></td><td><%= f.getDeptName() %></td><td><%= f.getMailId() %></td></tr>

<%} %>
</tbody>
</table>

</body>
</html>