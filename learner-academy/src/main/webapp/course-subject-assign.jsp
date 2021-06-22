<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<body>

<jsp:include page="main-page.jsp" />  
<div align="center">

<h2> Assign Subjects to a Course </h2>

<form action="<%=request.getContextPath()%>/Course-assignsubject" method="post">
<table>
<tbody>
<tr>

<th>
Select a Course Name:
</th>
<td>
    <select name="Course">
        <c:forEach items="${listOfCourse}" var="course">
            <option value="${course.courseId}">${course.courseName}</option>
        </c:forEach>
    </select>
</td>
</tr>
<tr>
<th>
Select the Subjects for the course:
 </th>
 <td>
  <c:forEach items="${listOfSubject}" var="subject">
 <input type="checkbox" name="Subjects" value="${subject.subjectId}">${subject.subjectName}
  &nbsp;
  </c:forEach>
</td>
</tr>
<tr/>
<tr/>
<tr>
<td>
<input type="submit" name = "AddSubjects" value="Assign Subjects"/>
</td>
</tr>
</tbody>
</table>
</form>
</div>

<% if(request.getParameter("AddSubjects")!=null) {
	
	out.print("courseSelected:" + request.getParameter("Course"));
	
}

%>
</body>
</html>