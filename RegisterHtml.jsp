<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Student</title>
<link rel="stylesheet" href="./style.css">
</head>
<body>


	<h2>Register form</h2><br>   
     

	<form method="post" action="Register" id="reg">
	<table border="0">
	 <tr>
	<td><label>Name</label></td>
	<td><input type="text" name="name" id="name"  required/></td>
	</tr>
	
	
	<tr>
	<td><label>EmailId</label>	</td>
	<td><input type="text" name="email" id="email"  required/></td>
	</tr>
	
	<tr>
	<td><label>Password</label></td>
	<td><input type="password" name="pswd" id="pswd"  required/></td>
	</tr>
	
	<tr>
	<td><label>MobileNumber</label></td>
	<td><input type="number" name="mblno" id="mblno"  required/></td>
	</tr>
	
	
	
	<tr>
	<td><label>ID</label></td>
	<td><input type="number" name="sid" id="sid"  required/></td>
	</tr>
	</table>
	<br><br>
	<button >submit</button>
	<br><br>
	
	
	</form>


</body>
</html>