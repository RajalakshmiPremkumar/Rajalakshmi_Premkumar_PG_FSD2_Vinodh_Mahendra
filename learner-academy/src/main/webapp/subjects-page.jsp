<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="UTF-8">
<title>Subject Details</title>
<link href="Style1.css" rel="stylesheet" type="text/css">
</head>

<body>

<jsp:include page="main-page.jsp" />  
	<div align="center">
		 <h1>Subject Name</h1>
		        <h2>
		         <a href="<%=request.getContextPath()%>/Subject-new">Add New Subject</a>
		         &nbsp;&nbsp;&nbsp;
		         <a href="<%=request.getContextPath()%>/Subject-list">List All Subject</a>
		         &nbsp;&nbsp;&nbsp;
	
		        </h2>
	
		  <c:if test="${subject != null}">
		   <form action="<%=request.getContextPath()%>/Subject-update" method="post">
		    </c:if>
		    
		   <c:if test="${subject == null}">
		   <form action="<%=request.getContextPath()%>/Subject-insert" method="post">
		    </c:if>


	        <table border="1">
	
	              <c:if test="${subject != null}">
	              <h2>Edit Subject</h2>
	              </c:if>
	              <c:if test="${subject == null}">
	              <h2> Add New Subject</h2>
	              </c:if>
	   
          <c:if test="${subject != null}">
           <input type="hidden" name="subjectId" value="<c:out value='${subject.subjectId}' />" />
          </c:if>
          
	            <tr>
	                <th>Subject Name </th>
	                <td>
	                 <input type="text" name="subjectName"  value="<c:out value='${subject.subjectName}' />"/>
	
	                </td>
	          
	                <!-- 
	             <select name="Teacher">
		        <c:forEach items="${teacherList}" var="teacher">
		            <option value="${teacher.teacherId}">${teacher.firstName}</option>
		        </c:forEach>
		    </select> -->
	            </tr>
	            
				<tr>
			   		<td><br></td>	
			          <td>
			              <input type="submit" name ="addSubject" value="Add" />
			           </td>
			     </tr>
	        </table>
		</div>

</body>
</html>