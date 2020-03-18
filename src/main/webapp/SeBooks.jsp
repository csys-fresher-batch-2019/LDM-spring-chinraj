<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.chinlibapp.model.Book"%>
<%@page import="java.util.List"%>
<%@page import="com.chainsys.chinlibapp.dao.imp.BookListDAOImpl"%>
<%@page import="com.chainsys.chinlibapp.dao.BookListDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="index.jsp"></jsp:include>
<h2>Book List</h2>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<body style="background-color: DarkKhaki">
</head>
<body>
	<form action="SearchByBook">
		<%
			ArrayList<Book> list = (ArrayList<Book>) request.getAttribute("searchlist");
				if (list.isEmpty() || list==null) {
			out.println("No records found");
				}
				else{
		%>
		<div></div>
		<table border="1">
			<thead>
				<tr>
				
					<th>ISBN</th>
					<th>Book Name</th>
					<th>Publication</th>
					<th>Book Status</th>
					<th>category</th>
				</tr>
			</thead>
			<tbody>
						<c:set var="BookList" value="<%=list%>"></c:set>
			<c:forEach items="${BookList}" var="b">
			<tr>
			<td>${b.ISBN}</td>
			<td>${b.bookName}</td>
			<td>${b.publication}</td>
			<td>${b.bookStatus}</td>
			<td>${b.category}</td>
			
			</tr>
			</c:forEach>


				<%
					}
			
				%>
			
			</tbody>
		</table>
	</form>
</body>
</html>