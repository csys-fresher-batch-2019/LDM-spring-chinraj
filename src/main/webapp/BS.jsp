
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


	<%
		String infoMessage = (String) request.getAttribute("infoMessage");
		String errorMessage = (String) request.getAttribute("errorMessage");

		if (infoMessage != null)
			out.println(infoMessage);
		if (errorMessage != null)
			out.println(errorMessage);
	%>
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
Enter Due Date: <input type="date" name ="DueDate" min="<%=date1%>" required>


<br/>

<button type = "submit">proceed</button>
</form>
</body>
</html>
