package com.app.workshop.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.workshop.dao.SubjectDao;
import com.app.workshop.dao.TeacherDao;
import com.app.workshop.model.Subjects;
import com.app.workshop.model.Teacher;


@WebServlet({"/Subject-new","/Subject-list","/Subject-update","/Subject-delete","/Subject-edit","/Subject-insert"})


public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SubjectDao subjectDao;
	private TeacherDao teacherDao;
	
    public SubjectServlet() {
        super();

    }


	public void init(ServletConfig config) throws ServletException {
     subjectDao = new SubjectDao();
     teacherDao = new TeacherDao();
  
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		String action = request.getServletPath();
	 	System.out.println("Action value in Subject Servlet:"+ request.getServletPath());
		
		 try {
	            switch (action) {
	            
	                case "/Subject-new":
	              
	                	showNewForm(request, response);
	                    break;
	                    
	                case "/Subject-insert":

	                	   insertSubject(request, response);
	                   
	                	   break;
	                case "/Subject-delete":
	                	 deleteSubject(request, response);
	                     break;
	                  
	                case "/Subject-edit":
	                	showEditForm(request, response);
	                    break;
	                    
	                case "/Subject-update":
	                	 updateSubject(request, response); 
	                    break;
	                default:

	                    listSubject(request, response);
	                    break;
	            	}
	        	} 
	        catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
		
		
		
		
	}
	


    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	 System.out.println("Inside New Form ");
    	// List <Teacher> teacherList = teacherDao.getAllTeacher();
    	// request.setAttribute("teacherList", teacherList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("subjects-page.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
  
    	//String subjectName = request.getParameter("subjectName");
      	 //List <Teacher> teacherList = teacherDao.getAllTeacher();
    	 //request.setAttribute("teacherList", teacherList);
    	
    	int subjectId =Integer.parseInt(request.getParameter("subjectId"));
        Subjects existingSubject = subjectDao.getSubject(subjectId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("subjects-page.jsp");
        request.setAttribute("subject", existingSubject);
        dispatcher.forward(request, response);

    }

    private void insertSubject(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
    	

    	 System.out.println("Inside Insert: " );

        String subjectName = request.getParameter("subjectName");
       // String teacherAssigned = request.getParameter("Teacher");

       // int teacherId = Integer.parseInt(teacherAssigned);
       // Teacher teacherSelected = teacherDao.getTeachers(teacherId);
        System.out.println("SubjectNAme: "+ subjectName );
       // request.setAttribute("AssignedTeacher", teacherSelected);
       // System.out.println("AssignedTeacher: "+ teacherSelected.getTeacherId() );
        Subjects newSubject = new Subjects(subjectName);
       // newSubject.addTeacher(teacherSelected);

        subjectDao.saveSubject(newSubject);
        response.sendRedirect("Subject-list");

  
    }

    private void updateSubject(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
       
    	int subjectId = Integer.parseInt(request.getParameter("subjectId"));
    	String subjectName = request.getParameter("subjectName");
    	//String teacherAssigned = request.getParameter("Teacher");
    	//int teacherId =Integer.parseInt(teacherAssigned);
    	//Teacher teacherSelected = teacherDao.getTeachers(teacherId);
        Subjects subject = new Subjects(subjectId,subjectName);
        //subject.addTeacher(teacherSelected);
        subjectDao.updateSubject(subject);
        response.sendRedirect("Subject-list");
    }

    private void deleteSubject(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {

    	
    	int subjectId =Integer.parseInt(request.getParameter("subjectId"));
        subjectDao.deleteSubject(subjectId);
        response.sendRedirect("Subject-list");
    }
    
    private void listSubject(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException {
    	    

    	
    	  
    	  		System.out.println("Inside List Subject method");

    	        List <Subjects> listSubject = subjectDao.getAllSubject();
    	        
    	        for(int i=0;i<listSubject.size();i++) {
    	        	Subjects myObj =listSubject.get(i);
    	        }
    	        request.setAttribute("listSubject", listSubject);


    	        RequestDispatcher dispatcher = request.getRequestDispatcher("subject-list.jsp");
    	        dispatcher.forward(request, response);
    	        
    	    }


}
