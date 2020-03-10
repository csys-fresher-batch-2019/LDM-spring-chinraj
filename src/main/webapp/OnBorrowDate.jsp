<%@page import="com.chainsys.chinlibapp.model.BookSummary"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.chinlibapp.model.BookList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.chainsys.chinlibapp.dao.imp.BookListDAOImpl"%>
<%@page import="com.chainsys.chinlibapp.dao.BookListDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="index.jsp"></jsp:include>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<body style="background-color: DarkKhaki">
</head>
<body>
<h2>On Particular Date</h2>
	<form action="OnParticularDate">
		<%
			ArrayList<BookSummary> list = (ArrayList<BookSummary>) request.getAttribute("searchlist");
			if (list.isEmpty()) {
				out.println("No records found");
			} else {
		%>


		<table border="1">
			<thead>
				<tr>
				
					<th>ISBN</th>
					<th>Student Id</th>

				</tr>
			</thead>
			<tbody>
			<c:set var="BookSummary" value="<%=list%>"></c:set>
			<c:forEach items="${BookSummary}" var="b">
			<tr>
			<td>${b.ISBN}</td>
			<td>${b.studentId}</td>
			
			</tr></c:forEach>

				<%
					}
				%>
			</tbody>
		</table>
		
	</form>
</body>
</html>