
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
<title>Student Details Page</title>
</head>
<link href="Style1.css" rel="stylesheet" type="text/css">
<body>
<jsp:include page="main-page.jsp" />  
<div align="center">
	 <h1>Student Details</h1>
	
	         <a href="<%=request.getContextPath()%>/newStudent">Add New Student</a>
	         &nbsp;&nbsp;&nbsp;
	         
	         <a href="<%=request.getContextPath()%>/listStudent">List All Students</a>
	         &nbsp;&nbsp;&nbsp;

	        </h2>

	  <c:if test="${student != null}">
	   <form action="<%=request.getContextPath()%>/updateStudent" method="post">

	    </c:if>
	    
	   <c:if test="${student == null}">
	   <form action="<%=request.getContextPath()%>/insertStudent" method="post">
	    </c:if>
		
        <table>

              <c:if test="${student != null}">
              <h2>Edit student</h2>
              </c:if>
              <c:if test="${student == null}">
              <h2> Add New student</h2>
              </c:if>
   

          <c:if test="${student != null}">
           <input type="hidden" name="studentId" value="<c:out value='${student.studentId}' />" />
          </c:if>
 
            <tr>
                <th>Student Name</th>
                <td>
                 <input type="text" name="studentName"  value="<c:out value='${student.studentName}' />"/>

                </td>
            </tr>
 
            </tr>
            <tr>
                <th>Email: </th>
                <td>
                 <input type="text" name="email"  value="<c:out value='${student.email}' />"/>
                </td>
            </tr>
            <tr>
            <td><br></td>
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