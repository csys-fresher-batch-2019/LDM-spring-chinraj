<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<jsp:include page="index.jsp"></jsp:include>
<h1>ADD AMOUNT IN ID</h1>
<br/>
<img src="images/Capture66.PNG"
 width="700" height="250"
 alt="library"/>"
 
 <body style = "background-color:bisque">
 
 	<%
		String infoMessage = (String) request.getAttribute("infoMessage");
		String errorMessage = (String) request.getAttribute("errorMessage");

		if (infoMessage != null)
			out.println(infoMessage);
		if (errorMessage != null)
			out.println(errorMessage);
	%>
<form action="IdServlet">
<br/>
Enter Student Id: <input type="number" name ="Student Id" minlength ="0" required>

<br/>
Enter Amount in ID :  <input type="number" name ="Amount In Id" minlength ="10" maxlength="1000" required >

<br/>
<button type = "submit">Add</button>


</form>
</body>
</html>