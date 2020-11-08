<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Random"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<script>
	function myFunction() {
		alert("Registration Successful");
	}
</script>

<body>
	<jsp:include page="header.jsp" />
	<div align="center">
		<form action="user?action=registernewuser" name="form" method="post"
			onsubmit="myFunction()">
			<table style="width: 80%, height:80%">
				<%
					Random random = new Random(System.nanoTime());
				int Id = random.nextInt(100);
				%>
				<tr>
					<td><label>First Name</label></td>
					<td><input type="text" name="Firstname" required /></td>
				</tr>
				<tr>
					<td><label>Last Name</label></td>
					<td><input type="text" name="Lastname" id="Lastname"
						onblur="
if(document.form.username.value=='' && document.form.Firstname.value!='' && document.form.Lastname.value!='') {
     var username = document.form.Firstname.value.substr(0,45) +      document.form.Lastname.value.substr(0,49);
     username = username.replace(/\s+/g, '');
     username = username.replace(/\'+/g, '');
     username = username.replace(/-+/g, '');
     username = username.toLowerCase();
     document.form.username.value = username;
}" />
					</td>
				</tr>
				<tr>


					<td><label>UserName</label></td>
					<td><input type="text" name="username" id="username" readonly /></td>
				</tr>
				<tr>
					<td><label for="birthday">Date Of Birth</label></td>
					<td><input type="date" id="birthday" name="birthday" required
						min="1920-01-01" max="2002-01-01"
						title="Enter date between 1920-01-01 and 2002-01-01 "></td>
				</tr>
				<tr>
					<td><label>Mobile Number</label></td>
					<td><input type="text" maxLength="10" pattern="[0-9]{10}$"
						title="Enter only digits" name="MobileNumber" required /></td>
				</tr>
				<tr>
					<td><label>Email Id</label></td>
					<td><input type="email" name="Email" required /></td>
				</tr>
				<tr>
					<td><label>Password</label></td>
					<td><input type="password" name="password" required /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit" /></td>

				</tr>
			</table>
		</form>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>