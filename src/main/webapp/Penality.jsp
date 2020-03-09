<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<jsp:include page="index.jsp"></jsp:include>
<form action = "PenalityServlet">
<h2>PENALITY FOR BOOK LOSS</h2>
<br/>
	
		<c:if test = "${not empty infoMessage}">
			<b>${infoMessage}</b>
		</c:if>
			<c:if test = "${not empty errorMessage}">
			<b>${errorMessage}</b>
		</c:if>
	</br>
Enter Student Id <input type="number" name ="StudentId" min="1" required>
<br/>

Enter ISBN <input type="number" name ="ISBN" min="1" required>
<br/>

<button type = "submit">Proceed</button>

</form>
</body>
</html>