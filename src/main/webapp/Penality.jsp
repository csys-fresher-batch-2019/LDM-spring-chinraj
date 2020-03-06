<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<jsp:include page="index.jsp"></jsp:include>
<form action = "PenalityServlet">
<h2>PENALITY FOR BOOK LOSS</h2>
<br/>
	<%
		String infoMessage = (String) request.getAttribute("infoMessage");
		String errorMessage = (String) request.getAttribute("errorMessage");

		if (infoMessage != null)
			out.println(infoMessage);
		if (errorMessage != null)
			out.println(errorMessage);
	%>
	</br>
Enter Student Id <input type="number" name ="StudentId" min="1" required>
<br/>

Enter ISBN <input type="number" name ="ISBN" min="1" required>
<br/>

<button type = "submit">Proceed</button>

</form>
</body>
</html>