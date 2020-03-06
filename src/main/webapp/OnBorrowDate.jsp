<%@page import="com.chainsys.chinlibapp.model.BookSummary"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.chinlibapp.model.BookList"%>
<%@page import="java.util.List"%>
<%@page import="com.chainsys.chinlibapp.dao.imp.BookListImpl"%>
<%@page import="com.chainsys.chinlibapp.dao.BookListDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="index.jsp"></jsp:include>
<h2>On Particular Date</h2>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<body style="background-color: DarkKhaki">
</head>
<body>
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
					<th>S.no</th>
					<th>ISBN</th>
					<th>Student Id</th>

				</tr>
			</thead>
			<tbody>
				<%
					int i = 1;
						for (BookSummary f : list) {
				%>
				<tr>
					<td><%=i++%></td>
					<td><%=f.getISBN()%></td>
					<td><%=f.getStudentId()%></td>

				</tr>

				<%
					}
				%>
			</tbody>
		</table>
		<%
			}
		%>
	</form>
</body>
</html>