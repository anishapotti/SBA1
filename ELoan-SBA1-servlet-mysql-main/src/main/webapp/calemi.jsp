<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*,java.lang.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Processing Loan</title>
</head>
<script>
	function myFunction() {
		alert("Updated Loandetails Successful");
	}
</script>
<body>
	<!--
     Read the values from the admin servlet and cal emi and other details and send to
     to the same admin servlet to update the values in the database 
  -->
	<jsp:include page="header.jsp" />
	<div class="navbar">
		<a href="adminhome1.jsp">HomePage</a> <a href="process.jsp">Process
			Loan</a> <a href="index.jsp">Logout</a>

	</div>
	<div align="center">
		<form action="admin?action=callemi" method="post" onsubmit="myFunction()">

			<table style="width: 80%, height:80%">
				<tr>
					<td><label>Application Number</label></td>
					<td><input type="text" name="applno"
						value="<%=session.getAttribute("applno")%>" required readonly /></td>
				</tr>
				<tr>
					<td><label>Loan Name</label></td>
					<td><input type="text" name="purpose"
						placeholder="Loan purpose"
						value="<%=session.getAttribute("purpose")%>" required /></td>
				</tr>

				<tr>
					<td><label>Loan amount requested</label></td>
					<td><input type="number" name="amtrequest"
						value="<%=session.getAttribute("amtrequest")%>" required /></td>
				</tr>
				<tr>
					<td><label for="ApplDate">Loan Application Date</label></td>
					<td><input type="date" id="doa" name="doa"
						value="<%=session.getAttribute("doa")%>" required></td>
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
					<td><label>Amount Sanctioned</label></td>
					<td><input type="number"  name="amotsanctioned"
						 required /></td>
				</tr>
		<tr>
					<td><label>Loan Term(in months)</label></td>
					<td><input type="number" name="loanterm"
						 required /></td>
				</tr>
				
				<tr>
					<td><label>Payment Start date</label></td>
					<td><input type="date" name="psd" required /></td>
				</tr>
				
				<%
			/*	
         Date date = new Date();
         //out.print( "<h2 align = \"center\">" +date.toString()+"</h2>");
     
			int loanterm=Integer.parseInt(request.getParameter("loanterm"));
				String psd=request.getParameter("psd");
			    
				
				calendar.getTime();
			     // System.out.println("Current Date = " + calendar.getTime());
			      // Add 8 months to current date
			      Calendar calendar = Calendar.getInstance();
			      calendar.add(Calendar.MONTH, loanterm);
			      Date closuredate= calendar.getTime();
			      */
			       %>
			       
				<tr>
					<td><label>Loan Closure Date</label></td>
					<td><input type="date"  name="lcd"  
						required /></td>
				</tr>
				<tr>
					<td><label>Interest Rate</label></td>
					<td><input type="number" name="interestRate"
						required /></td>
				</tr>
				
			<!--
				<tr>
					<td><label>Term Payment amount</label></td>
					<td><input type="text"  name="termpaymentamount" 
						 required /></td>
				</tr>
				
				<tr>
					<td><label>EMI</label></td>
					<td><input type="number" name="emi" 
						required /></td>
				-->
		
				<tr>
					<td><label>Mobile Number</label></td>
					<td><input type="text" maxLength="10" pattern="[0-9]{10}$"
						title="Enter only digits" name="mobile"
						value="<%=session.getAttribute("mobile")%>" required /></td>
				</tr>
				<tr>
					<td><label>Email Id</label></td>
					<td><input type="email" name="email"
						value="<%=session.getAttribute("email")%>" required /></td>
				</tr>
				<tr>
					<td><label>Contact Address</label></td>
					<td><input type="text" name="address"
						value="<%=session.getAttribute("address")%>" required />
				</tr>
				<tr>
					<td><label>Pin Code</label></td>
					<td><input type="text" name="PinCode" pattern="[0-9]{6}"
						title="Five digit zip code"
						value="<%=session.getAttribute("PinCode")%>" required />
				</tr>
				<tr>
					<td><label for="status">Status</label></td>
					<td><select name="status">
							<option value="<%=session.getAttribute("status")%>"><%=session.getAttribute("status")%></option>
							<% String status=(String)session.getAttribute("status");
							 if ( status.equals("Pending")){%>
							 
							<option value="Approved">Approved</option>
							<option value="OnHold">OnHold</option>
							<%}else if ( status.equals("Approved")){ %>

							<option value="Pending">Pending</option>
							<option value="OnHold">OnHold</option>
							<%}else if ( status.equals("OnHold")){   %>
							<option value="Pending">Pending</option>
							<option value="Approved">Approved</option>
							<%} %>
					</select></td>
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