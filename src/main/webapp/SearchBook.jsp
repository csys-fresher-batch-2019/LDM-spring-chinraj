<%@page import="com.chainsys.ldm.bookList.BookList"%>
<%@page import="java.util.List"%>
<%@page import="com.chainsys.ldm.bookList.BookListImpl"%>
<%@page import="com.chainsys.ldm.bookList.BookListDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="index.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<form action = "SearchByBook">
	

Enter BookName <input type="text" name="bookname">
<button type="submit">Search</button>


</form>
</body>
</html>