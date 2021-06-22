
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
 <title>Learner Academy Web Application</title>
 
 <link href="Style1.css" rel="stylesheet" type="text/css">
</head>



<body>
<jsp:include page="main-page.jsp" />  
 <div align="center">
  <h1>Teacher Management</h1>
    
<table>
       <tr><td> <a href="<%=request.getContextPath()%>/Teacher-new"">Add New Teacher</a></td>
        <td> &nbsp;&nbsp;&nbsp;</td>
       
<td>  <a href="<%=request.getContextPath()%>/Teacher-list">List All Teachers</a></td>
</tr>

       </table>
 </div>
    <div align="center">
        <table border="1">
         <h2>List of Teachers</h2>
            <tr>
                <th>Teacher Id</th>
                <th>Teacher Name</th>

                <th>Email</th>
                <th>Assigned Subject</th>

                <th>Actions</th>
            </tr>
            <c:forEach var="teacher" items="${listteacher}">
                <tr>
                    <td><c:out value="${teacher.teacherId}" /></td>
                    <td><c:out value="${teacher.teacherName}" /></td>

                    <td><c:out value="${teacher.email}" /></td>
                   // <td><c:out value="${teacher.subjectId}"/></td>

                    <td>
                     <a href="<%=request.getContextPath()%>/Teacher-edit?teacherId=<c:out value='${teacher.teacherId}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;/
                     <a href="<%=request.getContextPath()%>/Teacher-delete?teacherId=<c:out value='${teacher.teacherId}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>