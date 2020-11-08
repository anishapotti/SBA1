<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial;}

/* Style the tab */
.tab {
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
}

/* Style the close button */
.topright {
  float: right;
  cursor: pointer;
  font-size: 28px;
}

.topright:hover {color: red;}
</style>
</head>
<body>
<jsp:include page="header.jsp" />
 <div align="center">

<div class="tab" >
  <button class="tablinks" onclick="openCity(event, 'User')" id="defaultOpen">User</button>
  <button class="tablinks" onclick="openCity(event, 'Admin')">Admin</button>
 
</div>

<div id="User" class="tabcontent">
  <span onclick="this.parentElement.style.display='none'" class="topright">&times</span>
  
 
		<div>
			<h2>eLoan Login</h2>
		
			<div>
			<form action="user?action=validate" name="UserForm" method="post" >
				<div>
					<div>
						<label for="loginid">Enter username</label>
					</div>
					<div>
						<input type="text" id="username" name="username">
					</div>
				</div>
				<div>
					<div>
						<label for="password">Enter password</label>
					</div>
					<div>
						<input type="password" id="password" name="password">
					</div>
				</div>
				<div>
					<div>
						<input type="submit" value="Login">
					</div>
				</div>
				<a href="register.jsp">New User? register here</a>
			</form>
		</div>
		</div>
	</div>
</div>

<div id="Admin" class="tabcontent">
  <span onclick="this.parentElement.style.display='none'" class="topright">&times</span>
  <div align="center">
  
			<h2>eLoan Admin Login</h2>
		
			<div>
			<form action="adminhome1.jsp" name="AdminForm" method="post" >
				<div>
					<div>
						<label for="loginid">Enter user name</label>
					</div>
					<div>
						<input type="text" id="Adminusername" name="username">
					</div>
				</div>
				<div>
					<div>
						<label for="password">Enter password</label>
					</div>
					<div>
						<input type="password" id="Adminpassword" name="password">
					</div>
				</div>
				<div>
					<div>
						<input type="submit" value="Login"  >
					</div>
				</div>
			</form>
		</div>
		</div>
</div>


<script>

function openCity(evt, cityName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " active";
}

// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();


/*

function myFunctionuser() {
	var username=document.forms["UserForm"].["username"].value;  
	var password=document.forms["UserForm"].["password"].value;  
	  
	if (username==null || username=="" || password== null || password==""){  
	  alert("username/ Password can't be blank");  
	  return false;  
	  else 
	  return true; 
	}
}
function myFunctionAdmin() {
	var username=document.forms["AdminForm"].["username"].value;  
	var password=document.forms["AdminForm"].["password"].value;  
	  
	if (username==null || username=="" || password== null || password==""){  
	  alert("username/ Password can't be blank");  
	  return false;  
	}else if(username=="admin" && password== "admin" ){  
	  alert("Logged in as Admin");  
	  return true; 
	  else
		 return false;
	}
	  */


</script>
   <jsp:include page="footer.jsp"/>
</body>
</html> 
