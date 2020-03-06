<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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


	<%
		String infoMessage = (String) request.getAttribute("infoMessage");
		String errorMessage = (String) request.getAttribute("errorMessage");

		if (infoMessage != null)
			out.println(infoMessage);
		if (errorMessage != null)
			out.println(errorMessage);
	%>



Enter Student id <input type ="number" name ="Student Id" min ="1"required>
<br/>
Enter Money to add <input type="number" name="Amount In Id"  min="10" required>
<br/>
<button type="submit">Search</button>

 </form>
</body>
</html> 