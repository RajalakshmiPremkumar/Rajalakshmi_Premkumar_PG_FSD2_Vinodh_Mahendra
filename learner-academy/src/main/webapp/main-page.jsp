<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Learner's Academy-Online Course Management</title>
 <link href="Style1.css" rel="stylesheet" type="text/css">
</head>


<body>
<div align="center" >
<h1>Learners Acadmey</h1>

<form action="<%=request.getContextPath()%>/main-page" method="Post">
<table >
<tbody>
<tr>
	<th><input type="submit"  name="buttonpressed" value= "Manage Student Details"/></th>
	<th><input type="submit"  name="buttonpressed" value= "Manage Course Details"/></th>
	<th><input type="submit"  name="buttonpressed" value= "Manage Subject Details"/></th>
	<th><input type="submit"  name="buttonpressed" value= "Manage Teacher Details"/></th>
	<th><input type="submit"  name="buttonpressed" value= "Manage Class Report"/></th>
</tr>

</tbody>
</table>
</form>
</div>
</body>
</body>
</html>