<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Eloan-EditLoan</title>
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
<script>
	function myFunction() {
		alert("Updated Loandetails Successful");
	}
</script>
<body>
	<jsp:include page="header.jsp"/>
	<div class="navbar">
 <a href="application.jsp" TARGET="_parent">Apply for Loan</a>  
<a href="trackloan.jsp">Track Loan Application</a>
<a href="editloan.jsp">Edit Loan Application</a>
<a href="index.jsp">Logout</a>

</div> 
	<div align="center">
		<form action="user?action=editLoanProcess" method="post" onsubmit="myFunction()">

			<table style="width: 80%, height:80%">
				<tr>
					<td><label>Application Number</label></td>
					<td><input type="text" name="applno"  value="<%=session.getAttribute("applno")%>" required readonly/></td>
				</tr>
				<tr>
					<td><label>Loan Name</label></td>
					<td><input type="text" name="purpose" placeholder="Loan purpose" value="<%=session.getAttribute("purpose")%>" required /></td>
				</tr>
							
				<tr>
					<td><label>Loan amount requested</label></td>
					<td><input type="number"  name="amtrequest" value="<%=session.getAttribute("amtrequest")%>" required /></td>
				</tr>
				<tr>
					<td><label for="ApplDate">Loan Application Date</label></td>
					<td><input type="date" id="doa" name="doa" value="<%=session.getAttribute("doa")%>" required></td>
				</tr>
				<tr>
					<td><label for="bstructure">Business Structure</label></td>
					<td><select name="bstructure">
							<option value="<%=session.getAttribute("bstructure")%>"><%=session.getAttribute("bstructure")%></option>
							<% String bs=(String)session.getAttribute("bstructure");
							 if ( bs.equals("Organization")){%>
							<option value="Individual">Individual</option>
							<%}else{ %>

							<option value="Organization">Organization</option>
							<%} %>
							
							
					</select></td>
				</tr>
				<tr>
					<td><label for="bindicator">Billing Indicator</label></td>
					<td><select name="bindicator">
							<option value="<%=session.getAttribute("bindicator")%>"><%=session.getAttribute("bindicator")%></option>
							<% String bi=(String)session.getAttribute("bindicator");
							 if ( bi.equals("Non Salaried")){%>
							<option value="Salaried">Salaried</option>
							<%}else{ %>
							<option value="Non Salaried">Non Salaried</option>
							<%} %>
					</select></td>
				</tr>
				<tr>
					<td><label for="TaxIndicator">Tax Indicator</label></td>
					<td><select name="TaxIndicator">
							<option value="<%=session.getAttribute("TaxIndicator")%>"><%=session.getAttribute("TaxIndicator")%></option>
							<% String Ti=(String)session.getAttribute("TaxIndicator");
							 if ( Ti.equals("TaxPayer")){%>
							 <option value="NonTaxPayer">NonTaxPayer</option>
							
							<%}else{ %>

							<option value="TaxPayer">TaxPayer</option>
							<%} %>
					</select></td>
				</tr>
				<tr>
					<td><label>Mobile Number</label></td>
					<td><input type="text" maxLength="10" pattern="[0-9]{10}$"
						title="Enter only digits" name="mobile" value="<%=session.getAttribute("mobile")%>" required /></td>
				</tr>
				<tr>
					<td><label>Email Id</label></td>
					<td><input type="email" name="email" value="<%=session.getAttribute("email")%>" required /></td>
				</tr>
				<tr>
					<td><label>Contact Address</label></td>
					<td><input type="text" name="address" value="<%=session.getAttribute("address")%>" required />
				</tr>
				<tr>
					<td><label>Pin Code</label></td>
					<td><input type="text" name="PinCode" pattern="[0-9]{6}"
						title="Five digit zip code" value="<%=session.getAttribute("PinCode")%>" required />
				</tr>
				<tr>
					<td><input type="submit" value="Submit" /></td>
				</tr>

			</table>

			
		</form>
	</div>
<jsp:include page="footer.jsp"/>
</body>
</html>