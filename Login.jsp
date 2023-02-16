<%@page import="com.ty.student_app_jsp.dao.StudentDataBaseOperation"%>
<%@page import="com.ty.student_app_jsp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

	<%
	String email = request.getParameter("emailid");
	String pwd = request.getParameter("password");

	StudentDataBaseOperation operation = new StudentDataBaseOperation();
	application.setAttribute("dbop", operation);

	Student login = operation.loginValidate(email, pwd);

	if (login != null) {
	%>

	<jsp:include page="/dashboard.html"></jsp:include>

	<h1>
		Welcome
		<%=login.getSname()%></h1>




	<% 
	session = request.getSession(true);
	session.setAttribute("loggedInStudent", login);
	}
	else{
	%>



	<jsp:include page="/login-user"></jsp:include>
	<h2>Sorry Invalid user</h2>


	<%
}
%>
</body>
</html>