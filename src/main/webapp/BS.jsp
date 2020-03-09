<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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


		<c:if test = "${not empty infoMessage}">
			<b>${infoMessage}</b>
		</c:if>
			<c:if test = "${not empty errorMessage}">
			<b>${errorMessage}</b>
		</c:if>
<form action="BsServlet">
<br/>
Enter Student Id : <input type="number" name ="StudentId" min ="1" required>
<br/>
Enter ISBN : <input type="number" name ="ISBN" min="1"required>
<br/>

<%
LocalDate date = LocalDate.now();
%>
Enter Borrowed Date: <input type = "date" name ="BorrowedDate" min ="<%=date%>" max="<%=date%>"required>
<br/>
<%LocalDate date1 = LocalDate.now();
%>
Enter Due Date: <input type="date" name ="DueDate"  required>


<br/>

<button type = "submit">proceed</button>
</form>
</body>
</html>
