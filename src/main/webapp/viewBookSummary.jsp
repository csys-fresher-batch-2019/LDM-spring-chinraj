<%@page import="com.chainsys.chinlibapp.dao.imp.BookSummaryImpl"%>
<%@page import="com.chainsys.chinlibapp.model.BookSummary"%>
<%@page import="com.chainsys.chinlibapp.model.BookList"%>
<%@page import="java.util.List"%>
<%@page import="com.chainsys.chinlibapp.dao.imp.BookListImpl"%>
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
	<%
		BookSummaryImpl dao = new BookSummaryImpl();

		List<BookSummary> list1 = dao.viewBookSummary();
	%>

	<h2>VIEW BOOKSUMMARY</h2>
	<table border="1">
		<thead>
			<tr>
				<th>S.no</th>
				<th>Student Id</th>
				<th>ISBN</th>
				<th>Borrowed Date</th>
				<th>Renewal Count</th>
				<th>Due date</th>
				<th>Status
			</tr>
		</thead>
		<tbody>
			<%
				int i = 1;
				for (BookSummary f : list1) {
			%>
			<tr>
				<td><%=i++%></td>
				<td><%=f.getStudentId()%></td>
				<td><%=f.getISBN()%></td>
				<td><%=f.getBorrowedDate()%></td>
				<td><%=f.getRenewalCount()%></td>
				<td><%=f.getDueDate()%></td>
				<td><%=f.getStatus()%></td>
			</tr>

			<%
				}
			%>
		</tbody>
	</table>

</body>
</html>