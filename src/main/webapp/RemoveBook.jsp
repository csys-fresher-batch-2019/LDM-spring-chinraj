<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>


 <body style = "background-color:bisque">

</head>
<body>
<jsp:include page="index.jsp"></jsp:include>
<h1>REMOVE BOOKS</h1>

<%
		String infoMessage = (String) request.getAttribute("infoMessage");
		String errorMessage = (String) request.getAttribute("errorMessage");

		if (infoMessage != null)
			out.println(infoMessage);
		if (errorMessage != null)
			out.println(errorMessage);
	%>
<form action ="RemoveBooks">

Enter ISBN <input type="number" name ="ISBN" required>
<br/>
<br/>
<button type = "save">Delete</button>