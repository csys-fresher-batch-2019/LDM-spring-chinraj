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
<br/>
<form action ="UpdateAmount">
<br/>
Enter Student id <input type ="number" name ="Student Id"required min =""1>
<br/>
Enter Money to add <input type="number" name="Amount In Id" required min="10">
<br/>
<button type="submit">Search</button>

 </form>
</body>
</html> 