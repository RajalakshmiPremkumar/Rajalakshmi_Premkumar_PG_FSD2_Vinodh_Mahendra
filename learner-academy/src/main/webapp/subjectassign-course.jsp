
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
        <table border="1">
        <tr><th>
         <h2>Assign Subjects to Courses</h2>
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

                   
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>