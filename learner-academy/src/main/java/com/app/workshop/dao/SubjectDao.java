package com.app.workshop.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.app.workshop.model.Subjects;
import com.app.workshop.util.HibernateUtils;


public class SubjectDao {

	    public void saveSubject(Subjects subject) {
	    	System.out.println("Inside Save Subject");
	        Transaction transaction = null;
	        try(Session session = HibernateUtils.getSessionFactory().openSession()) {
	        	
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the SubjectS object
	        	System.out.println("Subject Name:"+subject);
	            session.save(subject);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }

	    }

	    public void updateSubject(Subjects subject) {
	    	System.out.println("Inside Update Student");
	        Transaction transaction = null;
	        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            session.update(subject);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }
	    public void deleteSubject(int subjectId) {

	    	System.out.println("Inside Update Student");
	        Transaction transaction = null;
	        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();

	            // Delete a user object
	            Subjects subject = session.get(Subjects.class,subjectId );
	            if (subject != null) {
	                session.delete(subject);
	                System.out.println("Subject is deleted");
	            }

	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }


	    public Subjects getSubject(int subjectId) {

	        Transaction transaction = null;
	        Subjects subject = null;
	        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            subject = session.get(Subjects.class, subjectId);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return subject;
	    }
	    public List <Subjects> getAllSubject() {

	        Transaction transaction = null;
	        List < Subjects > listOfSubject = null;
	
	        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	

	            listOfSubject = session.createQuery("from Subjects").getResultList();

	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return listOfSubject;
	    }

}
