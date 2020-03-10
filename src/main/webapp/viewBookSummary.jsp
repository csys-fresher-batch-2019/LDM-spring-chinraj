<%@page import="com.chainsys.chinlibapp.dao.imp.BookSummaryDAOImpl"%>
<%@page import="com.chainsys.chinlibapp.model.BookSummary"%>
<%@page import="com.chainsys.chinlibapp.model.BookList"%>
<%@page import="java.util.List"%>
<%@page import="com.chainsys.chinlibapp.dao.imp.BookListDAOImpl"%>
<%@page import="com.chainsys.chinlibapp.dao.BookListDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<body style="background-color: DarkKhaki">
</head>
<body>


	<jsp:include page="index.jsp"></jsp:include>
	<%
		BookSummaryDAOImpl dao = new BookSummaryDAOImpl();

			List<BookSummary> list1 = dao.viewBookSummary();
	%>

	<h2>VIEW BOOKSUMMARY</h2>
	<table border="1">
		<thead>
			<tr>
				<th>Student Id</th>
				<th>ISBN</th>
				<th>Borrowed Date</th>
				<th>Renewal Count</th>
				<th>Due date</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
						<c:set var="BookList" value="<%=list1%>"></c:set>
			<c:forEach items="${BookList}" var="b">
			<tr>
		
			<td>${b.studentId}</td>
			<td>${b.ISBN}</td>
			<td>${b.borrowedDate}</td>
			<td>${b.renewalCount}</td>
			<td>${b.dueDate}</td>
	    	<td>${b.status}</td>
			
			</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>