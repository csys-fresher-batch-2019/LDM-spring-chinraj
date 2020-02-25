<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>
<h1>ADD AMOUNT IN ID</h1>
<br/>
<img src="images/Capture66.PNG"
 width="700" height="250"
 alt="library"/>"
 
 <body style = "background-color:bisque">
<form action="IdServlet">
<br/>
Enter Student Id: <input type="number" name ="Student Id"required min ="0">

<br/>
Enter Amount in ID :  <input type="number" name ="Amount In Id" required min ="10" max="1000">

<br/>
<button type = "submit">save</button>


</form>
</body>
</html>