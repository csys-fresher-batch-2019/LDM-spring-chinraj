<%@page import="com.chainsys.chinlibapp.model.Book"%>
<%@page import="java.util.List"%>
<%@page import="com.chainsys.chinlibapp.dao.imp.BookListDAOImpl"%>
<%@page import="com.chainsys.chinlibapp.dao.BookListDAO"%>
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
	<h2>Search BookName</h2>

Enter BookName <input type="text" name="bookname" required>
<button type="submit">Search</button>


</form>
</body>
</html>