<%@page import="com.ty.student_app_jsp.dto.Student"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
<% 
session= request.getSession(false);
if(session!=null) {
	
	Student s=(Student) session.getAttribute("loggedInStudent");

%>
<h2><%=s.getSname()%>Logged out successfully</h2>
<%
		application.removeAttribute("dbop");
			session.removeAttribute("loggedInStudent");
			session.invalidate();
			%>
			
	<%} %>
	
	<jsp:include page="/login-user"></jsp:include>
</body>
</html>