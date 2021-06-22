package com.app.workshop.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.workshop.dao.StudentDao;
import com.app.workshop.model.Student;

@WebServlet({"/newStudent","/insertStudent","/updateStudent","/deleteStudent","/listStudent","/editStudent"})
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;

    public StudentServlet() {
        super();
System.out.println("Inside Student Servlet");
    }
    public void init() {
        studentDao= new StudentDao();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
  
		String action = request.getServletPath();
		HttpSession session = request.getSession();
		
		System.out.println("Inside student servlet Do get method");
        try {
            switch (action) {
                case "/newStudent":
                	showNewForm(request, response);
                    break;
                
                case "/insertStudent":

                	   insertStudent(request, response);
                   
                    break;
                    
                case "/deleteStudent":
                    deleteStudent(request, response);
                    break;
                 
                case "/editStudent":
     
                	showEditForm(request, response);
                    break;
                    
                    
                case "/updateStudent":
                	 updateStudent(request, response);
                    break;
                    
                default:

                    listStudent(request, response);
                    break;
            	}
        	} 
        catch (SQLException ex) {
            throw new ServletException(ex);
        }

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	    	
	        RequestDispatcher dispatcher = request.getRequestDispatcher("student-page.jsp");
	        dispatcher.forward(request, response);
	    }

	    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, ServletException, IOException {
	    	
	    	
	        int studentId = Integer.parseInt(request.getParameter("studentId"));
	        Student existingstudent = studentDao.getStudent(studentId);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("student-page.jsp");
	        request.setAttribute("student", existingstudent);
	        System.out.println("Inside Show Edit form Student");
	        System.out.println("Student details" + existingstudent );
	        dispatcher.forward(request, response);

	    }

	    private void insertStudent(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException {

	        String studentName = request.getParameter("studentName");
	        System.out.println("StudentName:"+studentName);
	 
	        String email = request.getParameter("email");
   
	        Student newstudent = new Student(studentName,email);

	        studentDao.saveStudent(newstudent);
	        
	        response.sendRedirect("listStudent");

	    }

	    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException {
	        int studentId = Integer.parseInt(request.getParameter("studentId"));
	        String studentName = request.getParameter("studentName");
	   
	        String email = request.getParameter("email");
	      

	        Student student = new Student(studentId,studentName, email);
	        studentDao.updateStudent(student);

	        
	        response.sendRedirect("listStudent");
	    }

	    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException {
	        int studentId = Integer.parseInt(request.getParameter("studentId"));
	        studentDao.deleteStudent(studentId);

	        response.sendRedirect("listStudent");
	    }
	    
	    private void listStudent(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException, ServletException {
	    	System.out.println("Inside List student method");
	    	        List <Student> liststudent = studentDao.getAllStudent();
	    	        request.setAttribute("liststudent", liststudent);
	    	        RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
	    	        dispatcher.forward(request, response);
	    	        
	    	    }
	    	    
	    	    
	}


