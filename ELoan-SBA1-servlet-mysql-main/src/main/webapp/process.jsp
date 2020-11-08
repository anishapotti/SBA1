<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<!-- write the code to read application number, and send it to admincontrollers
	     callemi method to calculate the emi and other details also provide links
	     to logout and admin home page
	-->
	<jsp:include page="header.jsp"/>
<div class="navbar">
 <a href="adminhome1.jsp">HomePage</a>
  <a href="process.jsp">Process Loan</a>
<a href="index.jsp">Logout</a>


</div> 
	<form action="admin?action=process" method="post" >
<div align="center">
				<div>
					<div>
						<label for="applno">Enter Application Number to process</label>
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