<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


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
<h1>RETURN & RENEWAL</h1>

<form action="ReturnRenewal">
Enter Student Id :<input type="number" name = "student_Id">
Enter ISBN : <input type="number" name ="ISBN">
<br/>
<input type= "radio"name="Name" value="Return">Return
<input type= "radio"name="Name" value="Renewal">Renewal
<br/>
<button type = "submit">Submit</button>
</form>
</body>
</html>