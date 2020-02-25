<%@page import="java.time.LocalDate"%>
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
<form action = "OnParticularDate">


		<%
			LocalDate date = LocalDate.now();
		%>
		Enter date(YYYY-MM-DD) : <input type="date" name="BorrowedDate" max="<%=date%>">
			<button type="submit">search</button>
</form>
</body>
</html>