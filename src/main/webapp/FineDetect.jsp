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

<body>
<h1> FINE DETECTION </h1>

<jsp:include page="index.jsp"></jsp:include>


<img src="images/banks-rob-depositors.jpg"
 width="700" height="250"
 alt="library"/>
 <body style = "background-color:powderblue">
 
 <br/>
<br/>
<form action="FineDetect">
Enter Student Id : <input type="number" name ="Student Id"value ="<%=studentId %>" >
<br/>
Enter ISBN : <input type="number" name ="ISBN" value ="<%=isbn %>" >
<br/>

<button type = "submit">Proceed</button>

</body>
</html>