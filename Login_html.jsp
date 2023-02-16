<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="./style.css">
</head>
<body>
	<h2>Student App</h2>
	<br>
	<form action="login" method="post" id="login">
		<center>
			<h3 style=color:'blue'>Login Page</h3>
		</center>
		<label>Username</label> <br> <input type="text" name="emailid"
			id="emailid" required /> <br> <br> <label>Password
		</label> <br> <input type="Password" name="password" id="password"
			required /> <br> <br>
		<button>Log In</button>
		<br> <br> <span> <a href="./Register-user">NewUserRegisterHere</a>
			<label>|</label>
		</span> <span> <a href="./Forget-user">ForgetPassword</a>
		</span>



	</form>

</body>
</html>