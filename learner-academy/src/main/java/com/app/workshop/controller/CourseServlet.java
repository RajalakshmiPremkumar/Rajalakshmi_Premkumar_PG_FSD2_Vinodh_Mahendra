package com.app.workshop.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.workshop.dao.CourseDao;

import com.app.workshop.model.Courses;

import com.app.workshop.dao.SubjectDao;

import com.app.workshop.model.Subjects;

@WebServlet({"/Course-new","/Course-list","/Course-update","/Course-delete","/Course-edit","/Course-insert","/Course-subjectlist","/Course-assignsubject"})


public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CourseDao courseDao;
	private SubjectDao subjectDao;
	//private Courses course;
	
    public CourseServlet() {
        super();

    }

	public void init(ServletConfig config) throws ServletException {
     courseDao = new CourseDao();
     subjectDao = new SubjectDao();
     //course = new Courses();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession session=request.getSession();
		String action = request.getServletPath();
	 	System.out.println("Action value in Course Servlet:"+ request.getServletPath());
		
		 try {
	            switch (action) {
	                case "/Course-new":
	                	showNewForm(request, response);
	                    break;
	                case "/Course-insert":
	                	insertCourse(request, response);
	                   
	                    break;
	                    
	                case "/Course-delete":
	                	 deleteCourse(request, response);
	                     break;
	                case "/Course-edit":
	                	showEditForm(request, response);
	                	break;
	                case "/Course-update":
	                	updateCourse(request, response); 
	                    break;
	                case "/Course-subjectlist":
	                	listCourseSubject(request,response);
	                    break;
	                    
	                case "/Course-assignsubject":
	                	
	                	assignSubjectsToCourse(request,response);
	                	
	                	break;
	                default:
	                	listCourse(request, response);
	                	break;
	            	}
	        	} 
	        catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
		
		}

	 private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			    	
			        RequestDispatcher dispatcher = request.getRequestDispatcher("course-page.jsp");
			        dispatcher.forward(request, response);
			    }

			    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, ServletException, IOException {
			  
			    	//String courseName = request.getParameter("courseName");
			    	
			    	int courseId =Integer.parseInt(request.getParameter("courseId"));
			        Courses existingCourse = courseDao.getCourse(courseId);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("course-page.jsp");
			        request.setAttribute("course", existingCourse);
			        //session.setAttribute("course", existingCourse);
			        dispatcher.forward(request, response);

			    }

			    private void insertCourse(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			    	


			        String courseName = request.getParameter("courseName");
			    
			        Courses newCourse = new Courses(courseName);

			        courseDao.saveCourse(newCourse);
			        response.sendRedirect("Course-list");

			  
			    }

			    private void updateCourse(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			       
			    	int courseId = Integer.parseInt(request.getParameter("courseId"));
			    	String courseName = request.getParameter("courseName");
			        Courses course = new Courses(courseId,courseName);
			        courseDao.updateCourse(course);
			        response.sendRedirect("Course-list");
			    }

			    private void deleteCourse(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			    	
			    	int courseId =Integer.parseInt(request.getParameter("courseId"));
			        courseDao.deleteCourse(courseId);
			        response.sendRedirect("Course-list");
			    }
			    
			    private void listCourse(HttpServletRequest request, HttpServletResponse response)
			    	    throws SQLException, IOException, ServletException {
			    	
			    	System.out.println("Inside List Course method");
			    	        List <Courses> listCourse = courseDao.getAllCourse();
			    	        request.setAttribute("listCourse", listCourse);
			    	        RequestDispatcher dispatcher = request.getRequestDispatcher("course-list.jsp");
			    	        dispatcher.forward(request, response);
			    	        
			    	    }
			    
			    
			    private void listCourseSubject(HttpServletRequest request, HttpServletResponse response)
			    	    throws SQLException, IOException, ServletException {
			    	
			       	System.out.println("Inside course servlet Assign Subject and Course");
                	List <Courses> listOfCourse = courseDao.getAllCourse();
                	List <Subjects> listOfSubject = subjectDao.getAllSubject();
                	request.setAttribute("listOfCourse", listOfCourse);
                	request.setAttribute("listOfSubject", listOfSubject);
                	listOfCourse.forEach(tmp -> System.out.println("Course"+tmp.getCourseId()));
                	RequestDispatcher rd3 = request.getRequestDispatcher("course-subject-assign.jsp");
	    	        rd3.forward(request, response);
	    	        
			   
			    	    }
			    
			    
			    
			    private void assignSubjectsToCourse(HttpServletRequest request, HttpServletResponse response)
			    	    throws SQLException, IOException, ServletException {
			
			    	
			    	System.out.println("CourseServlet Assign Subjects to a course");
			    	
			    	System.out.println("Inside Assign Subjects to Course");
			    	String[] subjectAssigned = request.getParameterValues("Subjects");
			    	String  courseIdSelected = request.getParameter("Course");
					
			    	
			    	courseDao.updateCourseWithSubjects(courseIdSelected,subjectAssigned);
		
					 //request.setAttribute("courseNameAssigned", courseSelected.getCourseName());
					 //request.setAttribute("subjectsAssigned", assignSubject);
					  
			  }
			    	
	

			}



