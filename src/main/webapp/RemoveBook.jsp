<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>


 <body style = "background-color:bisque">

<jsp:include page="index.jsp"></jsp:include>



</head>
<body>
<h1>REMOVE BOOKS</h1>

<form action ="RemoveBooks">
<br/>
Enter ISBN <input type="number" name ="ISBN">
<br/>
<button type = "submit">delete</button>
</form>
</body>
</html>