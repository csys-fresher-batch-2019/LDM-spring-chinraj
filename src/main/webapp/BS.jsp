
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>


<jsp:include page="index.jsp"></jsp:include>
<img src="images/books-birds-eye-view.jpg"
 width="700" height="250"
 alt="library"/>
 
 <body style = "background-color:powderblue">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<br/>
<h1>BORROW BOOK</h1>

<form action="BsServlet">
<br/>
Enter Student Id : <input type="number" name ="StudentId" min ="1">
<br/>
Enter ISBN : <input type="number" name ="ISBN" min="1">
<br/>

<%
LocalDate date = LocalDate.now();
%>
Enter Borrowed Date: <input type = "date" name ="BorrowedDate" min ="<%=date%>" max="<%=date%>">
<br/>
<%LocalDate date1 = LocalDate.now();
%>
Enter Due Date: <input type="date" name ="DueDate" min="<%=date1%>">


<br/>

<button type = "submit">save</button>
</form>
</body>
</html>
