package com.app.workshop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.workshop.model.Subjects;
import com.app.workshop.model.Teacher;
import com.app.workshop.dao.*;


@WebServlet("/main-page")
public class MainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDao teacherDao;
	private SubjectDao subjectDao;
    public MainPageServlet() {
        super();

    }


	public void init(ServletConfig config) throws ServletException {
 
     teacherDao = new TeacherDao();
     subjectDao = new SubjectDao();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String reqContextPath =request.getContextPath();
	
	
		String reqParam = request.getParameter("buttonpressed");
	    response.setContentType("text/html");
	    
		PrintWriter out = response.getWriter();

		
		try {
            switch (reqParam) {
                case "Manage Student Details":
    		        RequestDispatcher dispatcher = request.getRequestDispatcher("student-page.jsp");
    		        dispatcher.forward(request, response);

                    break;
                case "Manage Course Details":
    		        RequestDispatcher rd = request.getRequestDispatcher("course-page.jsp");
    		        rd.forward(request, response);;
                    break;
                case "Manage Teacher Details":
                	List <Subjects> SubjectList = subjectDao.getAllSubject();
                	request.setAttribute("SubjectList", SubjectList);
    		        RequestDispatcher rd1 = request.getRequestDispatcher("teacher-page.jsp");
    		        rd1.forward(request, response);
                    break;
                case "Manage Subject Details":
                	// List <Teacher> teacherList = teacherDao.getAllTeacher();
                	 //request.setAttribute("teacherList", teacherList);
    		        RequestDispatcher rd2 = request.getRequestDispatcher("subjects-page.jsp");
    		        rd2.forward(request, response);
                    break;
                case "Manage Class Report":
    		        RequestDispatcher rd3 = request.getRequestDispatcher("class-report.jsp");
    		        rd3.forward(request, response);
                    break;
                default:
    		        RequestDispatcher rd4 = request.getRequestDispatcher("main-page.jsp");
    		        rd4.forward(request, response);
                    break;
            	}
        	} 
        catch (Exception ex) {
            throw new ServletException(ex);
        }
	

	}


}
