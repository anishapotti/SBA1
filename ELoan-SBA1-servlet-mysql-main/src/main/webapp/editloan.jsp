<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Loan Application</title>
</head>
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
}

.navbar {
  overflow: hidden;
  background-color: #333;
}

.navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}


.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}


.dropdown-content a:hover {
  background-color: #ddd;
}

</style>
<body>
<!-- read the application number to edit from user and send to 
	     user controller to edit info
	-->
	<jsp:include page="header.jsp"/>
	<div class="navbar">
 <a href="application.jsp" TARGET="_parent">Apply for Loan</a>  
<a href="trackloan.jsp">Track Loan Application</a>
<a href="editloan.jsp">Edit Loan Application</a>
<a href="index.jsp">Logout</a>

</div> 
	<form action="user?action=editloan" method="post">
<div align="center">
				<div>
					<div>
						<label for="applno">Enter Application Number to Edit</label>
					</div>
					<div>
						<input type="text" id="applno" name="applno">
					</div>
				</div>
				<div>
					<div>
						<input type="submit" value="submit">
					</div>
				</div>
				</div>
			</form>
<jsp:include page="footer.jsp"/>
</body>

</html>