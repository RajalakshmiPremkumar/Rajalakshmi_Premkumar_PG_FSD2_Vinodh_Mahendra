package com.app.workshop.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.workshop.model.Login;
import com.app.workshop.util.HibernateUtils;


public class LoginDao {

	public static boolean validate(String username, String password) {
		
	     Transaction transaction = null;
	        Login login = null;
	        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            login = (Login) session.createQuery("FROM Login").uniqueResult();

	            if (login != null && login.getPassword().equals(password) && login.getUsername().equalsIgnoreCase(username)) {
	                return true;
	            }
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return false;
	    }
		
	}
	

