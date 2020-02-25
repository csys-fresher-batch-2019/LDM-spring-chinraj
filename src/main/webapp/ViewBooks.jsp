<%@page import="com.chainsys.ldm.bookList.BookList"%>
<%@page import="java.util.List"%>
<%@page import="com.chainsys.ldm.bookList.BookListImpl"%>
<%@page import="com.chainsys.ldm.bookList.BookListDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<body style = "background-color:DarkKhaki">
</head>
<body>

<jsp:include page="index.jsp"></jsp:include>
<br/>
<h2> VIEW BOOKS</h2>
<%
BookListDAO dao = new BookListImpl();

List<BookList> list1 =dao.viewBooks();
%>
<table border="1">
<thead><tr><th>S.no</th> <th> ISBN </th><th>Book Name</th><th>Publication</th><th>Book Status</th></tr></thead>
<tbody>
<%
int i= 1;
for(BookList f : list1){
%>
<tr><td> <%= i++  %></td><td><%=f.getISBN()  %></td><td><%= f.getBookName()  %></td><td><%= f.getPublication() %></td><td><%= f.getBookStatus() %></td></tr>

<%} %>
</tbody>
</table>

</body>
</html>