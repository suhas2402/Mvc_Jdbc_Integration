<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

	<div align="center">
		<h1>list of students</h1>
		<hr />

		<form action="/Mvc_Jdbc_Template_Anotation/showform">
			<input type="submit" value="Add" />



		</form>
		<br />

		<table border="1">
			<thead>
				<tr>
					<td>Id</td>
					<td>Name</td>
					<td>Mobile</td>
					<td>Country</td>
					<td>Action</td>
				</tr>

			</thead>


			<c:forEach items="${Student}" var="student">
				<tbody>
					<tr>
						<td><c:out value="${student.id}" /></td>
						<td><c:out value="${student.name}" /></td>
						<td><c:out value="${student.mobile}" /></td>
						<td><c:out value="${student.country}" /></td>
						<td><a href="/Mvc_Jdbc_Template_Anotation/updatestudent?userId=${student.id}">update</a> <a href="/Mvc_Jdbc_Template_Anotation/deletestudent?userId=${student.id}" onclick="if(!(confirm('Are you Sure you want to delete this student')))return false">delete</a></td>
					</tr>
				</tbody>
			</c:forEach>

		</table>
	</div>
</body>
</html>