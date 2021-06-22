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

import com.app.workshop.dao.SubjectDao;
import com.app.workshop.dao.TeacherDao;
import com.app.workshop.model.Courses;
import com.app.workshop.model.Subjects;
import com.app.workshop.model.Teacher;


@WebServlet({"/Teacher-new","/Teacher-list","/Teacher-update","/Teacher-delete","/Teacher-edit","/Teacher-insert","/Teacher-subjectlist","/Teacher-assignsubject"})
public class TeacherServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private TeacherDao teacherDao;
	private SubjectDao subjectDao;

    public TeacherServlet() {
        super();

    }
    
    public void init() {
        teacherDao= new TeacherDao();
        subjectDao= new SubjectDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String action = request.getServletPath();
		HttpSession session = request.getSession();
		
		System.out.println("Inside teacher servlet Do get method");
        try {
            switch (action) {
            
                case "/Teacher-new":
                	showNewForm(request, response);
                    break;
                case "/Teacher-insert":
                	insertTeacher(request, response);
                   
                    break;
          
                case "/Teacher-delete":
                	 deleteTeacher(request, response);
                     break;
                case "/Teacher-edit":
                	showEditForm(request, response);
                    
                    break;
                case "/Teacher-update":
                	 updateTeacher(request, response); 
	                
                    break;
                    
                case "/Teacher-subjectlist":
                	listTeacherSubject(request, response); 
                   break;
                   
                case "Teacher-assignsubject":
                	assignSubjecTeacher(request, response); 
                   break;
                default:
                	listTeacher(request, response);
                	break;
            	}
        	} 
        catch (Exception ex) {
            throw new ServletException(ex);
        }
	}
	

	

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	List <Subjects> SubjectList = subjectDao.getAllSubject();
    	request.setAttribute("SubjectList", SubjectList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("teacher-page.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
    	List <Subjects> SubjectList = subjectDao.getAllSubject();
    	request.setAttribute("SubjectList", SubjectList);
        int teacherId = Integer.parseInt(request.getParameter("teacherId"));
        Teacher existingteacher = teacherDao.getTeachers(teacherId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("teacher-page.jsp");
        request.setAttribute("teacher", existingteacher);
        System.out.println("Inside Show Edit form Teacher");
        System.out.println("Teacher details" + existingteacher );
        dispatcher.forward(request, response);

    }

    private void insertTeacher(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
    	
        System.out.println("INSIDETEACHER"); 
        String teacherName = request.getParameter("teacherName");
        System.out.println(teacherName);

        String email = request.getParameter("email");	
        System.out.println(email);
        
        String selectedSubject = request.getParameter("Subject");
        
        
        System.out.println(selectedSubject);
        Subjects subjectSelected = getSubjectForTeacher(selectedSubject);
      
        System.out.println("Subject Fetched using SubjectId"+ subjectSelected.getSubjectId());
       
        Teacher newteacher = new Teacher(teacherName,email);
        subjectSelected.getTeacher().add(newteacher);
        System.out.println("Teacher 2 Method Invoked");
        teacherDao.saveTeacher(newteacher);
        
        response.sendRedirect("Teacher-list");

    }

    private void updateTeacher(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
    	
        int teacherId = Integer.parseInt(request.getParameter("teacherId"));
        String teacherName = request.getParameter("teacherName");
     
        String email = request.getParameter("email");
        
        String selectedSubject = request.getParameter("Subject");
        
        Subjects subjectSelected = getSubjectForTeacher(selectedSubject);
        

        Teacher teacher = new Teacher(teacherId,teacherName, email);
        subjectSelected.addTeacher(teacher);
        
        teacherDao.updateTeacher(teacher);

        
        response.sendRedirect("Teacher-list");
    }

    private void deleteTeacher(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
    	
        int teacherId = Integer.parseInt(request.getParameter("teacherId"));
        teacherDao.deleteTeacher(teacherId);

        response.sendRedirect("Teacher-list");
    }
    
    private void listTeacher(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException {
    	System.out.println("Inside List teacher method");
    	        List <Teacher> listteacher = teacherDao.getAllTeacher();
    	        request.setAttribute("listteacher", listteacher);
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("teacher-list.jsp");
    	        dispatcher.forward(request, response);
    	        
    	    }
    
    
    private void listTeacherSubject(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException {
    	
       	System.out.println("Inside teacher servlet Assign Subject and Course");
    	List <Teacher> listTeacher = teacherDao.getAllTeacher();
    	List <Subjects> listOfSubject = subjectDao.getAllSubject();
    	int cntSubject = listOfSubject.size();
    	request.setAttribute("TeacherList", listTeacher);
    	request.setAttribute("SubjectList", listOfSubject);
    	request.setAttribute("cntSubject", cntSubject);

    	RequestDispatcher rd3 = request.getRequestDispatcher("teacher-subject-assign.jsp");
        rd3.forward(request, response);

    	    }
    
    public void assignSubjecTeacher(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException {
    	
    	System.out.println("Teacher Servlet Assign Teacher to a subject");
    	
    	System.out.println("Inside Assign Teacher to Subject");
 

    	
    }
    
    
    public Subjects getSubjectForTeacher(String selectedSubject) {
    	
        Subjects selectSubject = subjectDao.getSubject(Integer.parseInt(selectedSubject));
  
    	return selectSubject;
    }

}
