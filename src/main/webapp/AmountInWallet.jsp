<%@page import="com.chainsys.chinlibapp.dao.imp.IdDetailsImpl"%>
<%@page import="com.chainsys.chinlibapp.dao.IdDetailsDAO"%>
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
<%
	IdDetailsImpl j =  new IdDetailsImpl();
int amount=j.libraryWallet();
%>
<h2>TOTAL AMOUNT IN LIB WALLET</h2>
<center><h1><%out.println( "Rs " +amount);%></h1></center>
</body>
</html>