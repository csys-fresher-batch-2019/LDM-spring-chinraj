<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
  box-sizing: border-box;
}
body {
  margin: 0;
}
/* Style the header */
.header {
  background-color: #f1f1f1;
  padding: 20px;
  text-align: center;
}
/* Style the top navigation bar */
.topnav {
  overflow: hidden;
  background-color: #333;
}
/* Style the topnav links */
.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}
/* Change color on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}
/* Create three equal columns that floats next to each other */
.column {
  float: left;
  width: 33.33%;
  padding: 15px;
}
/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
/* Responsive layout - makes the three columns stack on top of each other instead of next to each other */
@media screen and (max-width:600px) {
  .column {
    width: 100%;
  }
}
<style>
.button {
  background-color: black;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
.right
{
float:right
}
</style>
<body style = "background-color:Orange">
</head>
<body>

<div class="header">
 <a href="AdminLogin.jsp"   class="button right"><h1>Logout</span></h1></a>
  <h1>WELCOME TO CHINLIB !!!</h1>
  
</div>

<div class="topnav">
 <a href="AddBooks.jsp"   class="button">Add Books</a>
 <a href="ViewBooks.jsp"  class="button">View Books</a> 
 <a href="RemoveBook.jsp"  class="button">Remove Books</a> 
 <a href="AddStudents.jsp" class="button">Add Student</a> 
  <a href="ViewStudents.jsp"   class="button">View Students</a>
 <a href="RemoveStudents.jsp" class="button">Remove Student</a> 
 <a href="BS.jsp" class="button">Borrow Book</a> 
  <a href="viewBookSummary.jsp" class="button">View BookSummary</a> 
 <a href="BorrowOnDate.jsp" class="button">On Particular Date</a> 
 <a href="Return.jsp" class="button">Return</a>
  <a href="Renewal.jsp" class="button">Renewal</a>
 <a href="AddAmount.jsp" class="button">Add Amount</a> 
  <a href="UpdateMoney.jsp" class="button">Update Money</a> 
  <a href="SearchBook.jsp" class="button" >Search Book</a> 
 <a href="Penality.jsp"class="button">Book Loss</a> 
 <a href="AmountInWallet.jsp" class="button">Lib Wallet</a>
</div>


</body>
</html>