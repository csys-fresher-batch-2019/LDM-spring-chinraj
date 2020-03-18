<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<jsp:include page="index.jsp"></jsp:include>
<h1>ADD STUDENTS</h1>

<img src="images/lib.jpg"
 width="1000" height="300"
 alt="library"/>
 
<h2>LIBRARY APP!!!</h2>


<body style = "background-color:Orange">

<form action="RegisterServlet">

        <c:choose>
		<c:when test = "${not empty infoMessage}">
			<b>${infoMessage}</b>
		</c:when>
			<c:otherwise>
			<b>${errorMessage}</b>
		</c:otherwise>
		</c:choose>
	</br>
Enter Name :<input type="text"name = "name"
placeholder= "Enter Name" required autofocus/>
<br/>
Select DeptName:
<input type= "radio"name="Department Name" value="CSE">CSE
<input type= "radio"name="Department Name" value="MECH">MECH
<input type= "radio"name="Department Name" value="EEE">EEE
<input type= "radio"name="Department Name" value="ECE">ECE
<input type= "radio"name="Department Name" value="CIVIL">CIVIL
<br/>
Enter Student Id : <input type="number" name ="Student Id"required min ="1">
<br/>
Enter Mail Id :  <input type="email" name ="mail_id"required>
<br/>
Select Gender:
<input type= "radio"name="gender" value="Male">male

<input type= "radio"name="gender" value="Female">female


<button type = "submit" class="button">Register</button>
</form>
 <br/> 
 
 
</body>
</html>

