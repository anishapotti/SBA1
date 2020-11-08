<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page import= "com.iiht.evaluation.eloan.model.LoanInfo"%>
  <%@page import= "java.util.ArrayList"%>
  <%@page import= "com.iiht.evaluation.eloan.controller.AdminController"%>

 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display All Loans</title>
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
	<!-- write code to display all the loan details 
             which are received from the admin controllers' listall method
	--> 
<jsp:include page="header.jsp" />
<div class="navbar">
 <a href="adminhome1.jsp">HomePage</a>
  <a href="process.jsp">Process Loan</a>
<a href="index.jsp">Logout</a>

</div> 

<table border="1">
<tr style="font-weight:bold">
<td>User Name</td>
<td>Application Number</td>
<td>Purpose</td>
<td>Amount Requested</td>
<td>Date Of Application</td>
<td>Business Structure</td>
<td>Billing Indicator</td>
<td>Tax Indicator</td>
<td>Address</td>
<td>Pin Code</td>
<td>Email Id</td>
<td>Mobile</td>
<td>Status</td>



</tr>
<%                           
        ArrayList<LoanInfo> list=(ArrayList<LoanInfo>)request.getAttribute("ListLoan");
        for (int i = 0; i < list.size(); i++) { %>
        	<tr>
            <td> <%   out.println(list.get(i).getUserName()); %></td>
            <td> <%   out.println(list.get(i).getApplno()); %></td>
            <td> <%   out.println(list.get(i).getPurpose()); %></td>
            <td> <%   out.println(list.get(i).getAmtrequest()); %></td>
            <td> <%   out.println(list.get(i).getDoa()); %></td>
            <td> <%   out.println(list.get(i).getBstructure()); %></td>
            <td> <%   out.println(list.get(i).getBindicator()); %></td>
            <td> <%   out.println(list.get(i).getTaxIndicator()); %></td>
            <td> <%   out.println(list.get(i).getAddress()); %></td>
            <td> <%   out.println(list.get(i).getPinCode()); %></td>
            <td> <%   out.println(list.get(i).getEmail()); %></td>
            <td> <%   out.println(list.get(i).getMobile()); %></td>
            <td> <%   out.println(list.get(i).getStatus()); %></td>
                </tr>
           <% }
        %>
</table>
<jsp:include page="footer.jsp" />
</body>
</html>