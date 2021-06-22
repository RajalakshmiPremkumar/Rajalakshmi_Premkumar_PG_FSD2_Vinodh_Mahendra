<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
 <title>Learners Academy Website</title>
<link href="Style1.css" rel="stylesheet" type="text/css">
</head>

<body>

<jsp:include page="main-page.jsp" />  
 
 <div align="center">
  <h1>Subjects</h1>


 </div>
    <div align="center">
    <Form action="<%=request.getContextPath()%>/Teacher-assignsubject" method="post">
        <table>
        <tr><th>
         <h2>Assign Teacher to Subject</h2>
         </th></tr>
    
                <tr>
                <th>Subject Id</th>
                <th>Subject Name</th>
            
                <th>Actions</th>
            </tr>
     
            <c:forEach var="subject" items="${listSubject}">
                <tr>
               
                	<td> <c:out value="${subject.subjectId}"/></td>
                    <td><c:out value="${subject.subjectName}" /></td>
					<td>
			<select name="Teacher">
		        <c:forEach items="${TeacherList}" var="teacher">
		            <option value="${teacher.teacherId}">${teacher.firstName}</option>
		        </c:forEach>
		    </select>
			</td>
			<td>
	
            </tr>
            </c:forEach>
        </table>
    </div> 
    </Form>
</body>
</html>