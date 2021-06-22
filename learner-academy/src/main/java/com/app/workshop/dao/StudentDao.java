package com.app.workshop.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.workshop.model.Student;
import com.app.workshop.util.HibernateUtils;


public class StudentDao {

	    public void saveStudent(Student student) {
	    	System.out.println("Inside Save Student");
	        Transaction transaction = null;
	        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            session.save(student);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }

	    /**
	     * Update User
	     * @param user
	     */
	    public void updateStudent(Student student) {
	    	System.out.println("Inside Update Student");
	        Transaction transaction = null;
	        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            session.update(student);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }


	    public void deleteStudent(int id) {

	    	System.out.println("Inside Update Student");
	        Transaction transaction = null;
	        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();

	            // Delete a user object
	            Student student = session.get(Student.class, id);
	            if (student != null) {
	                session.delete(student);
	                System.out.println("Student is deleted");
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

	    /**
	     * Get User By ID
	     * @param id
	     * @return
	     */
	    public Student getStudent(int id) {

	        Transaction transaction = null;
	        Student student = null;
	        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            student = session.get(Student.class, id);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return student;
	    }

	    /**
	     * Get all Users
	     * @return
	     */

	    public List <Student> getAllStudent() {

	        Transaction transaction = null;
	        List < Student > listOfStudent = null;
	    	System.out.println("Inside StudnetDao list All student");
	        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object

	            listOfStudent = session.createQuery("from Student").getResultList();

	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return listOfStudent;
	    }

}
