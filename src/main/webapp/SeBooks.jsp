<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.ldm.bookList.BookList"%>
<%@page import="java.util.List"%>
<%@page import="com.chainsys.ldm.bookList.BookListImpl"%>
<%@page import="com.chainsys.ldm.bookList.BookListDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="index.jsp"></jsp:include>
<h2>VIEW BOOKS</h2>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<body style="background-color: DarkKhaki">
</head>
<body>
	<form action="SearchByBook">
		<%
			ArrayList<BookList> list = (ArrayList<BookList>) request.getAttribute("searchlist");
		%>
		<div></div>
		<table border="1">
			<thead>
				<tr>
					<th>S.no</th>
					<th>ISBN</th>
					<th>Book Name</th>
					<th>Publication</th>
					<th>Book Status</th>
					<th>category</th>
				</tr>
			</thead>
			<tbody>
				<%
					int i = 1;
					for (BookList f : list) {
				%>
				<tr>
					<td><%=i++%></td>
					<td><%=f.getISBN()%></td>
					<td><%=f.getBookName()%></td>
					<td><%=f.getPublication()%></td>
					<td><%=f.getBookStatus()%></td>
					<td><%=f.getCategory()%></td>
				</tr>

				<%
					}
				%>
			</tbody>
		</table>
	</form>
</body>
</html>