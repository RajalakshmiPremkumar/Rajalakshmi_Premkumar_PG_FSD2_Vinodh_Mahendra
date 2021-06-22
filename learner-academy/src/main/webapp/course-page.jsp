<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
<meta charset="UTF-8">
<title>Course Details</title>
 <link href="Style1.css" rel="stylesheet" type="text/css">
</head>

<body>
<jsp:include page="main-page.jsp" />  
	<div align="center">
		 <h1>Course Name</h1>
		        <h2>
		         <a href="<%=request.getContextPath()%>/Course-new">Add New Course</a>
		         &nbsp;&nbsp;&nbsp;
		         <a href="<%=request.getContextPath()%>/Course-list">List All Course</a>
		         &nbsp;&nbsp;&nbsp;

		  <c:if test="${course != null}">
		   <form action="<%=request.getContextPath()%>/Course-update" method="post">
		    </c:if>
		    
		   <c:if test="${course == null}">
		   <form action="<%=request.getContextPath()%>/Course-insert" method="post">
		    </c:if>


	        <table border="1">
	
	              <c:if test="${course != null}">
	              <h2>Edit Course</h2>
	              </c:if>
	              <c:if test="${course == null}">
	              <h2> Add New Course</h2>
	              </c:if>
	   
          <c:if test="${course != null}">
           <input type="hidden" name="courseId" value="<c:out value='${course.courseId}' />" />
          </c:if>
          
	            <tr>
	                <th>Course Name </th>
	                <td>
	                 <input type="text" name="courseName"  value="<c:out value='${course.courseName}' />"/>
	
	                </td>
	            </tr>
	            
				<tr>
			   		<td><br></td>	
			          <td>
			              <input type="submit" name ="addCourse" value="Add" />
			           </td>
			     </tr>
	        </table>
		</div>

 

</body>
</html>