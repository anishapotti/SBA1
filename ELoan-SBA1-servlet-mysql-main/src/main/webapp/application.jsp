<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Random"%>
     <%@page import="com.iiht.evaluation.eloan.model.User"%>
     <%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
<script>
    var today = new Date;
    document.getElementById('date').innerHTML= today.toDateString();
</script>
<body>
<jsp:include page="header.jsp" />

	<div align="center">
		<form action="user?action=placeloan" method="post" onsubmit="myFunction()">

			<table style="width: 80%, height:80%">
			<tr>
			<% 
			String UserName=session.getAttribute("userName").toString();%>
						<td><label>UserName</label></td>
					<td><input type="text" name="UserName"
						value="<%=UserName%>"  /></td>
				</tr>
				<tr>
					<td><label>Loan Name</label></td>
					<td><input type="text" name="purpose" placeholder="Loan purpose" required /></td>
				</tr>
				<tr>
					<%
					 Random random = new Random(System.nanoTime() % 100000);
					  int applno = random.nextInt(1000000000);						
					%>
					<td><label>Loan Application Number</label></td>
					<td><input type="text" name="applno"
						value="<%=applno%>"  Readonly Required /></td>
				</tr>
				
				<tr>
					<td><label>Loan amount requested</label></td>
					<td><input type="number"  name="amtrequest" required /></td>
				</tr>
		
				<tr>
					<td><label for="ApplDate">Loan Application Date</label></td>
				
					<td><input type="date" id="doa" name="doa"  required></td> 
				</tr>
				<tr>
					<td><label for="bstructure">Business Structure</label></td>
					<td><select name="bstructure">
							<option value="Individual">Individual</option>
							<option value="Organization">Organization</option>
					</select></td>
				</tr>
				<tr>
					<td><label for="bindicator">Billing Indicator</label></td>
					<td><select name="bindicator">

							<option value="Salaried">Salaried</option>
							<option value="Non Salaried">Non Salaried</option>
					</select></td>
				</tr>
				<tr>
					<td><label for="TaxIndicator">Tax Indicator</label></td>
					<td><select name="TaxIndicator">

							<option value="TaxPayer">Tax Payer</option>
							<option value="NonTaxPayer">Non Tax Payer</option>
					</select></td>
				</tr>
				<tr>
					<td><label>Mobile Number</label></td>
					<td><input type="text" maxLength="10" pattern="[0-9]{10}$"
						title="Enter only digits" name="mobile" required /></td>
				</tr>
				<tr>
					<td><label>Email Id</label></td>
					<td><input type="email" name="email" required /></td>
				</tr>
				<tr>
					<td><label>Contact Address</label></td>
					<td><input type="text" name="address" required />
				</tr>
				<tr>
					<td><label>Pin Code</label></td>
					<td><input type="text" name="PinCode" pattern="[0-9]{6}"
						title="Five digit zip code" required />
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