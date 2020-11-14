<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>Employee Report</h2>
<table border="1" align="center">
	<tr>
	<th> Employee ID</th> <th> Employee Name </th><th>Skill</th><th>ProjectId</th>
	</tr>
    <jstlcore:forEach items="${empList}" var="emp">
		<tr align="center">
		<td align="center"><jstlcore:out value="${emp.employeeId}"></jstlcore:out></td>
		<td align="center"><jstlcore:out value="${emp.employeeName}"></jstlcore:out></td>
		<td align="center"><jstlcore:out value="${emp.skill}"></jstlcore:out></td>
		<td align="center"><jstlcore:out value="${emp.projectId}"></jstlcore:out></td>
		</tr>
	</jstlcore:forEach>
</table>
	<font color="red">${MESSAGE}</font>
 <br> <a href="home.htm"> Home</a> <br> 
</center>
</body>
</html>