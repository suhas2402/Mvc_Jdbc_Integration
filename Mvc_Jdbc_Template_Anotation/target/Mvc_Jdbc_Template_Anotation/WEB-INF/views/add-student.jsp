<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<div align="center">
	
		<h1>Add Student</h1>
		<hr />
		<form:form action="/Mvc_Jdbc_Template_Anotation/savestudent" modelAttribute="students" method="Get">
		<table></table>
<form:hidden  path="id"/>
Name:<form:input path="name" />
			<br /><br />
Mobile:<form:input path="mobile" />
			<br /><br />
Country:<form:input path="country" />
			<br /><br />
			<input type="submit" value="submit" />

		</form:form>
	</div>
</body>
</html>