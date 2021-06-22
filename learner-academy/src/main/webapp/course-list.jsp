
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
 <title>Learner's Academy Web Application</title>
  <link href="Style1.css" rel="stylesheet" type="text/css">
</head>

<body>

<jsp:include page="main-page.jsp" />  
 <div align="center">
  <h1>Courses</h1>
        <h2>
         <a href="<%=request.getContextPath()%>/Course-new">Add New Course</a>
         &nbsp;&nbsp;&nbsp;
         <a href="<%=request.getContextPath()%>/Course-list">List All Courses</a>  &nbsp;&nbsp;&nbsp;
          <a href="<%=request.getContextPath()%>/Course-subjectlist">Assign Subject To course</a>
        </h2>
 </div>
    <div align="center">
        <table border="1">
        <tr><th>
         <h2>List of Courses</h2>
         </th></tr>
    
                <tr>
                <th>Course Id</th>
                <th>Course Name</th>
            
                <th>Actions</th>
            </tr>
     
  
           <c:forEach var="course" items="${listCourse}">
                <tr>
                	<td><c:out value="${course.courseId}"/></td>
                    <td><c:out value="${course.courseName}" /></td>

                    <td>
                     <a href="<%=request.getContextPath()%>/Course-edit?courseId=<c:out value='${course.courseId}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="<%=request.getContextPath()%>/Course-delete?courseId=<c:out value='${course.courseId}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>