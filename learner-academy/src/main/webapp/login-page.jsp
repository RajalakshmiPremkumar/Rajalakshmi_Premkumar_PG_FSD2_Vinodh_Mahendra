
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
 <link href="Style1.css" rel="stylesheet" type="text/css">
<body>

 <div align="center">
  <h1>Admin Login</h1>
  
  <form action="<%=request.getContextPath()%>/login" method="post">
  

<table div align="center"; font="7"; color="blue">
<tbody>
	<tr>
	<th>UserName</th>
	<td><input type="text" name="username"></td>
	</tr>
	<tr>
	<th>Password</th>
	<td><input type="password" name="password"></td>
	</tr>
 <tr>
 <td>&nbsp;</td>
   <td>
   <input type="submit" value="Login">
   </td>
   </tr><tbody>
   </tbody>
   </table>
  </form>
  </div>
</body>
</html>