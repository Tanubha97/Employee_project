<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>
function validate(){
	empName=document.getElementById("empName").value;
	if(empName==""  || empName==null){
		alert("Employee name is mandatory")
		return false;
	}
	skill=document.getElementById("skill").value;
	if(skill.equals=="" || skill==null){
		alert("Employee name is mandatory")
		return false;
	}
	return true;
}
</script>

</head>
<body>
<center>
<h2>Add Employee to Project</h2>
<form:form name="empForm1"  action="addEmployee.htm" modelAttribute="employee" method="GET" >
	

	<table    border="0">
		<tr>
			<td>Employee Name</td>
			<td><form:input path="employeeName" id="empName"/></td>
		</tr>
		
		<tr>
			<td>Gender</td>
			<td><form:radiobutton path="gender" value="M"/>Male
				<form:radiobutton path="gender" value="F"/>Female
			</td>
			
		</tr>
		
		<tr>
			<td>Skill</td>
			<td><form:input path="skill" id="skill"/></td>
		</tr>	
		
		<tr>
			<td>ProjectId</td>
			<td>
			<form:select path="projectId">
			<form:options items="${projectList}" />
			</form:select></td>
		</tr>	
		
				 
		 <tr>
			<td colspan="2" align="center">
			<input type="submit" value="Add Employee" onClick="return validate()"></td>
		 </tr>	
		 
		 <tr>
				<td colspan="2" align="center"><font color="red">${MESSAGE}</font></td>
			</tr>
		
		
		 
		</table>
		
		 <br> <a href="home.htm"> Home</a> <br> 

</form:form>
</center>

</body>
</html>