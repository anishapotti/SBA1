<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.iiht.evaluation.eloan.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user home</title>
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
</head>
<body>

	<!-- write the html code to display hyperlinks for user functionalities -->
<jsp:include page="header.jsp"/>
<h4>User Dash Board</h4>

<div class="navbar">
<!--  <iframe name="frame" src="application.jsp">Apply for Loan</iframe>-->
 <a href="application.jsp" TARGET="_parent">Apply for Loan</a>  
<a href="trackloan.jsp">Track Loan Application</a>
<a href="editloan.jsp">Edit Loan Application</a>
<a href="index.jsp">Logout</a>

</div> 

<h5>Welcome <%=session.getAttribute("userName") %></h5> 
<jsp:include page="footer.jsp"/>
</body>
</html>