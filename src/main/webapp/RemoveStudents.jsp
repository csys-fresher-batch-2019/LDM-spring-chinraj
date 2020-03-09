<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="index.jsp"></jsp:include>

<h1>REMOVE STUDENTS</h1>
<img src="images/Remove-female-user.png"
 width="500" height="250"
 alt="library"/>
 <body style = "background-color:pink">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>

<body>
<form action ="RemoveStudents">
<br/>

		<c:if test = "${not empty infoMessage}">
			<b>${infoMessage}</b>
		</c:if>
			<c:if test = "${not empty errorMessage}">
			<b>${errorMessage}</b>
		</c:if>
	</br>
Enter Student Id <input type="number" name ="Student Id" required>
<br/>
<br/>
<button type = "save">Delete</button>
</form>
</body>
</html>