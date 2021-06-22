package com.app.workshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.workshop.model.Teacher;
import com.app.workshop.util.HibernateUtils;

public class TeacherDao {

	
	 public void saveTeacher(Teacher teacher) {

		 
	     System.out.println("Inside SaveTEacher Method"); 

	        Transaction transaction = null;
	        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the teacher object
	            session.save(teacher);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }

	    public void updateTeacher(Teacher teacher) {

	        Transaction transaction = null;
	        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	 
	            session.update(teacher);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }


	    public void deleteTeacher(int teacherId) {

	    	System.out.println("Inside delete Teacher");
	        Transaction transaction = null;
	        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();

	            // Delete a user object
	            Teacher student = session.get(Teacher.class, teacherId);
	            if (student != null) {
	                session.delete(student);
	                System.out.println("Teacher is deleted");
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


	    public Teacher getTeachers(int teacherId) {

	        Transaction transaction = null;
	        Teacher teacher = null;
	        
	        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();

	            teacher = session.get(Teacher.class, teacherId);
	            
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return teacher;
	    }



	    public List <Teacher> getAllTeacher() {

	        Transaction transaction = null;
	        List < Teacher > listOfTeacher = null;

	        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	     
	            transaction = session.beginTransaction();
	

	            listOfTeacher = session.createQuery("from Teacher").getResultList();

	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return listOfTeacher;
	    }

}
