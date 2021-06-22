package com.app.workshop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.app.workshop.dao.LoginDao;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
            authenticate(request, response);
        } catch (Exception e) {

            e.printStackTrace();
        }

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	private void authenticate(HttpServletRequest request, HttpServletResponse response)
		    throws Exception {
		        String username = request.getParameter("username");
		        String password = request.getParameter("password");
		        response.setContentType("text/html");
				PrintWriter out = response.getWriter();
		        
		        if (LoginDao.validate(username,password)) {
		        	
		            RequestDispatcher dispatcher = request.getRequestDispatcher("main-page.jsp");
		            dispatcher.forward(request, response);
		        } else {
		        	out.println(("Invalid Username or Passwor!.Please try with Valid credentials"));
		        	RequestDispatcher dispatcher = request.getRequestDispatcher("login-page.jsp");
		            dispatcher.include(request, response);
		        }
		    }
	
	
}
