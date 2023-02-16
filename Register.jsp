<%@page import="com.ty.student_app_jsp.dao.StudentDataBaseOperation"%>
<%@page import="com.ty.student_app_jsp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>

	<%
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	long mblno = Long.parseLong(request.getParameter("mblno"));
	String pswd = request.getParameter("pswd");
	int sid = Integer.parseInt(request.getParameter("sid"));
	Student s = new Student();
	%>

	<%
	s.setSname(name);
	s.setMailid(email);
	s.setMobnum(mblno);

	s.setPswd(pswd);
	s.setSid(sid);

	/* StudentDataBaseOperation op = (StudentDataBaseOperation) application.getAttribute("dbop"); */
	StudentDataBaseOperation op = new StudentDataBaseOperation();
	boolean isInserted = op.insertStudent(s);

	if (isInserted) {
	%>
	<h2>Student Registered Successfully!!!</h2>
	<jsp:include page="/login-user"></jsp:include>

	<%
	} else {
	%>
	<h2>Student not Registered!!!</h2>
	<jsp:include page="/Register-user"></jsp:include>
	<%
	}
	%>


</body>
</html>