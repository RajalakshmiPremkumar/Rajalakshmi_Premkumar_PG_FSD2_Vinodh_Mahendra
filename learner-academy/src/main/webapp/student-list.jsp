
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
 <title>Learner Academy</title>
 <link href="Style1.css" rel="stylesheet" type="text/css">
</head>

<body>
 <div align="center">
 
 <jsp:include page="main-page.jsp" />  
  <h1>Student Management</h1>
<a href="<%=request.getContextPath()%>/newStudent"">Add New Student</a>
         &nbsp;&nbsp;&nbsp;
<a href="<%=request.getContextPath()%>/listStudent">List All Students</a>

 </div>
    <div align="center">
        <table border="1">
         <h2>List of Students</h2>
            <tr>
                <th>StudentId</th>
                <th>Student Name</th>
         
                <th>Email</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="student" items="${liststudent}">
                <tr>
                    <td><c:out value="${student.studentId}" /></td>
                    <td><c:out value="${student.studentName}" /></td>
                 
                    <td><c:out value="${student.email}" /></td>
                    <td>
                     <a href="<%=request.getContextPath()%>/editStudent?studentId=<c:out value='${student.studentId}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;/
                     <a href="<%=request.getContextPath()%>/deleteStudent?studentId=<c:out value='${student.studentId}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>