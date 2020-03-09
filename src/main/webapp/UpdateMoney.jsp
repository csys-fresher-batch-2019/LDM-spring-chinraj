<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>
<br/>
<form action ="UpdateAmount">
<h1>Update Money</h1>
<br/>


	<c:if test = "${not empty infoMessage}">
			<b>${infoMessage}</b>
		</c:if>
			<c:if test = "${not empty errorMessage}">
			<b>${errorMessage}</b>
		</c:if>



Enter Student id <input type ="number" name ="Student Id" min ="1"required>
<br/>
Enter Money to add <input type="number" name="Amount In Id"  min="10" required>
<br/>
<button type="submit">Search</button>

 </form>
</body>
</html> 