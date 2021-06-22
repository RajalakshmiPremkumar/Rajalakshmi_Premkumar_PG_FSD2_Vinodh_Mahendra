
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
<title>Teacher Details Page</title>
</head>
<link href="Style1.css" rel="stylesheet" type="text/css">
<body>
<jsp:include page="main-page.jsp" />  
<div align="center">
	 <h1>Teacher Details</h1>
	
	         <a href="<%=request.getContextPath()%>/Teacher-new">Add New Teacher</a>
	         &nbsp;&nbsp;&nbsp;
	         <a href="<%=request.getContextPath()%>/Teacher-list">List All Teachers</a>
	         &nbsp;&nbsp;&nbsp;

	        </h2>

	  <c:if test="${teacher != null}">
	   <form action="<%=request.getContextPath()%>/Teacher-update" method="post">

	    </c:if>
	    
	   <c:if test="${teacher == null}">
	   <form action="<%=request.getContextPath()%>/Teacher-insert" method="post">
	    </c:if>
		
        <table>

              <c:if test="${teacher != null}">
              <h2>Edit teacher</h2>
              </c:if>
              <c:if test="${teacher == null}">
              <h2> Add New teacher</h2>
              </c:if>
   

          <c:if test="${teacher != null}">
           <input type="hidden" name="teacherId" value="<c:out value='${teacher.teacherId}' />" />
          </c:if>
 
            <tr>
                <th>Teacher Name: </th>
                <td>
                 <input type="text" name="teacherName"  value="<c:out value='${teacher.teacherName}' />"/>

                </td>
            </tr>

               <tr>
                <th>Email </th>
                <td>
                 <input type="text" name="email" value="<c:out value='${teacher.email}' />"/>

                </td>
            </tr>

            <tr>
<th> Assign Subject</th>
           <td>
			<select name="Subject">
		        <c:forEach items="${SubjectList}" var="subject">
		            <option value="${subject.subjectId}">${subject.subjectName}</option>
		        </c:forEach>
		    </select>
			</td>
			</tr>
		<tr>
   <td><br></td>	
          <td>
              <input type="submit" value="Save" />
             </td>
            </tr>
        </table>
</div>
</body>
</html>