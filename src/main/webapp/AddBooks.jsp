<%@page import="java.time.LocalDate"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


</head>



<body>
	<jsp:include page="index.jsp"></jsp:include>
	<br />
<body style="background-color: lightblue">
	<h1>ADD BOOKS</h1>
	<img src="images/Capture.PNG" width="700" height="350" alt="library" />
	<form action="BookRegister">
		<br /> Enter ISBN<input type="number" name="ISBN" required min="1">
		<br /> Enter BookName <input type="text" name="book_name"> <br />
		Enter noOfPages <input type="number" name="pages" min="1"> <br />
		Enter AuthorName<input type="text" name="author_name"> <br />
		Enter Publication <input type="text" name="publication"> <br />
		<%
			LocalDate date = LocalDate.now();
		%>
		Enter Released date(YYYY-MM-DD) : <input type="date" name="released_date" max="<%=date%>">
		 <br />
		  Enter price of book :<input type="number" name="price" min="0"> 
		  <br />
		   Enter Rack no : <input type="number" name="rack_no" min="1"> <br />
		<br />
		<button type="submit">save</button>
	</form>
</body>
</html>