<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="index.jsp"></jsp:include>

<img src="images/return-audible-book-670x335.jpg"
 width="670" height="335"
 alt="library"/>
 <br/>
<head>
 <body style = "background-color:lightblue">
 <br/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body style = "background-color:Silver">
<body>
<br/>
<h1>RETURN </h1>


<form action="Return">
	<c:if test = "${not empty infoMessage}">
			<b>${infoMessage}</b>
		</c:if>
			<c:if test = "${not empty errorMessage}">
			<b>${errorMessage}</b>
		</c:if>
 
	</br>
	
	

Enter Student Id :<input type="number" name = "student_Id"required>
Enter ISBN : <input type="number" name ="ISBN"  required>
<br/>

<br/>
<button type = "submit">Renewal
</button>


</form>
</body>
</html>