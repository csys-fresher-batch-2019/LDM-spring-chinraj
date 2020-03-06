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


	<%
		String infoMessage = (String) request.getAttribute("infoMessage");
		String errorMessage = (String) request.getAttribute("errorMessage");

		if (infoMessage != null)
			out.println(infoMessage);
		if (errorMessage != null)
			out.println(errorMessage);
	%>
</br>	
	
	Enter Student Id : <input type="number" name ="Student Id"value ="<%=studentId %>" required>
<br/>
Enter ISBN : <input type="number" name ="ISBN" value ="<%=isbn %>" required>
<br/>

<button type = "submit">Proceed</button>
</form>

</body>
</html>