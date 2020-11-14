<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>
function validate(){
	empName=document.getElementById("emp_id").value;
	if(empName==""  || empName==null){
		alert("Employee Id is mandatory")
		return false;
	}
	return true;
}
</script>

</head>
<body>
<center>
<h2>Deallocate Employee</h2>
<form name="empForm2"  action="deAllocateEmployee.htm" method="GET" >
	

	<table  border="0">
		<tr>
			<td>Employee Id</td>
			<td><input type="text" name="empId" id="emp_id"></td>
		</tr>
			
		 <tr>
			<td colspan="2" align="center">
			<input type="submit" value="Deallocate Employee" onClick="return validate()"></td>
		 </tr>	
		 <tr>
				<td colspan="2" align="center"><font color="red">${MESSAGE}</font></td>
			</tr>
		</table>
		 <br> <a href="home.htm"> Home</a> <br>

</form>
</center>
</body>
</html>