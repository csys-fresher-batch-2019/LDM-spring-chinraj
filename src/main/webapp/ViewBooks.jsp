<%@page import="com.chainsys.chinlibapp.model.Book"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.chainsys.chinlibapp.dao.imp.BookListDAOImpl"%>
<%@page import="com.chainsys.chinlibapp.dao.BookListDAO"%>
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
	<br />
	<h2>VIEW BOOKS</h2>
	<%
		BookListDAO d = new BookListDAOImpl();

			List<Book> list1 = d.findBooks();
	%>
	<table border="1">
		<thead>
			<tr>
			
				<th>ISBN</th>
				<th>Book Name</th>
				<th>Publication</th>
				<th>Book Status</th>
			</tr>
		</thead>
		<tbody>
			<%-- <%
				int i = 1;
				for (BookList f : list1) {
			%> --%>
			<c:set var="BookList" value="<%=list1%>"></c:set>
			<c:forEach items="${BookList}" var="b">
			<tr>
			<td>${b.ISBN}</td>
			<td>${b.bookName}</td>
			<td>${b.publication}</td>
			<td>${b.bookStatus}</td>
			</tr>
			
			</c:forEach>
			<%-- <tr>
				<td><%=i++%></td>
				<td><%=f.getISBN()%></td>
				<td><%=f.getBookName()%></td>
				<td><%=f.getPublication()%></td>
				<td><%=f.getBookStatus()%></td>
			</tr> --%>

			<%-- <%
				}
			%> --%>
		</tbody>
	</table>

</body>
</html>