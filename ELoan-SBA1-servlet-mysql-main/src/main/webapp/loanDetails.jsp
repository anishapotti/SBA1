<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.iiht.evaluation.eloan.model.LoanInfo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DisplayLoan</title>
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
	<!-- write the code to display the loan status information 
	     received from usercontrollers' displaystatus method
	-->
	<jsp:include page="header.jsp"/>
	<div class="navbar">

 <a href="application.jsp" TARGET="_parent">Apply for Loan</a>  
<a href="trackloan.jsp">Track Loan Application</a>
<a href="editloan.jsp">Edit Loan Application</a>
<a href="index.jsp">Logout</a>

</div> 
	<div align="center">
	<table >
		<tr>
			<td><label><%=session.getAttribute("userName") %>,Your Loan Application is in </label></td>
			<td><%=session.getAttribute("status") %> status</td>
		</tr>
		

	</table>
	</div>
<jsp:include page="footer.jsp"/>
</body>
</html>