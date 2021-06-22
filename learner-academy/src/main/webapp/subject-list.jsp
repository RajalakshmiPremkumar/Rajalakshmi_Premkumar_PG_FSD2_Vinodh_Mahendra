
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
 <title>Learners Acadmey Application</title>
<link href="Style1.css" rel="stylesheet" type="text/css">
</head>

<body>

<jsp:include page="main-page.jsp" />  
 
 <div align="center">
  <h1>Subjects</h1>
     

     <a href="<%=request.getContextPath()%>/Subject-new">Add New Subject</a>
         &nbsp;&nbsp;&nbsp;
    <a href="<%=request.getContextPath()%>/Subject-list">List All Subjects</a>   &nbsp;&nbsp;&nbsp;

 </div>
    <div align="center">
        <table>
        <tr><th>
         <h2>List of Subjects</h2>
         </th></tr>
    
                <tr>
                <th>Subject Id</th>
                <th>Subject Name</th>
                <!--  <th>Teacher Assigned</th>-->
            
                <th>Actions</th>
                
            </tr>

            <c:forEach var="subject" items="${listSubject}">
                <tr>
                	<td><c:out value="${subject.subjectId}"/></td>
                    <td><c:out value="${subject.subjectName}" /></td>
                    <!--<td><c:out value="${AssignedTeacher.teacherId}"></c:out>  -->

                    <td>
                     <a href="<%=request.getContextPath()%>/Subject-edit?subjectId=<c:out value='${subject.subjectId}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="<%=request.getContextPath()%>/Subject-delete?subjectId=<c:out value='${subject.subjectId}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
 
</body>
</html>