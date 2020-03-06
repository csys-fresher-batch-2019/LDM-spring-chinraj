<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
int studentId = (int)session.getAttribute("id");
long isbn =(long)session.getAttribute("ISBN");
%>
<jsp:include page="index.jsp"></jsp:include>
<h1>FINE PER STUDENT</h1>
<img src="images/unnamed.jpg"
 width="700" height="250"
 alt="library"/>
 <br/>
<body>

<br/>
<body style = "background-color:powderblue">
<form action="FinesServlet">
Enter Student Id : <input type="number" name ="Student Id"value ="<%=studentId %>"required >
<br/>
Enter ISBN : <input type="number" name ="ISBN" value ="<%=isbn %>" required>
<br/>
Enter Fine per day : <input type="number" name ="Fine per day"required>
<br/>
<button type = "submit">Proceed</button>
</form>
</body>
</html>