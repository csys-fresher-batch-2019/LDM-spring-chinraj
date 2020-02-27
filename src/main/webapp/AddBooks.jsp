<%@page import="com.chainsys.ldm.bookList.BookListImpl"%>
<%@page import="java.time.LocalDate"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


</head>



<body>
	<jsp:include page="index.jsp"></jsp:include>
	<br />
<body style="background-color: lightblue">
	<h1>ADD BOOKS</h1>
	<br />
	<%
		String infoMessage = (String) request.getAttribute("infoMessage");
		String errorMessage = (String) request.getAttribute("errorMessage");

		if (infoMessage != null)
			out.println(infoMessage);
		if (errorMessage != null)
			out.println(errorMessage);
	%>

	<form action="BookRegister">
		<br /> Enter ISBN<input type="text" name="ISBN" pattern="[0-9]{1,14}" title="Please enter valid ISBN number(less than or equal to 14 digits)"  required >
		<br /> Enter BookName <input type="text" name="book_name"> <br />
		Enter noOfPages <input type="number" name="pages" min="1" title ="Value must greater than or equal to 1"> <br />
		Enter AuthorName<input type="text" name="author_name"> <br />
		Enter Publication <input type="text" name="publication"> <br />
		<%
			LocalDate date = LocalDate.now();
		%>
		Enter Released date(YYYY-MM-DD) : <input type="date"
			name="released_date" max="<%=date%>"> <br />
			 Enter price of book :<input type="number" name="price" min="0"> <br />
		 Enter Rack no : <input type="number" name="rack_no" min="1"> <br />
		Enter Category:<input type="text" name="category"> <br />

		<button type="submit">save</button>

	</form>
</body>
</html>