package com.app.workshop.dao;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import com.app.workshop.model.Courses;
import com.app.workshop.model.Subjects;
import com.app.workshop.util.HibernateUtils;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;


public class CourseDao {

	    public void saveCourse(Courses Course) {

	        Transaction transaction = null;
	        try(Session session = HibernateUtils.getSessionFactory().openSession()) {
	        	
	            // start a transaction
	            transaction = session.beginTransaction();
	  
	            session.save(Course);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }

	    }

	    public void updateCourse(Courses course) {
	    	System.out.println("Inside Update Student");
	        Transaction transaction = null;
	        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();

	            session.update(course);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }
	    public void deleteCourse(int courseId) {

	    	System.out.println("Inside Update Student");
	        Transaction transaction = null;
	        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();

	            Courses course = session.get(Courses.class,courseId );
	            if (course != null) {
	                session.delete(course);
	                System.out.println("Course is deleted");
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


	    public Courses getCourse(int courseId) {

	        Transaction transaction = null;
	        Courses course = null;
	        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();

	            course = session.get(Courses.class, courseId);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return course;
	    }
	    public List <Courses> getAllCourse() {

	        Transaction transaction = null;
	        List < Courses > listOfCourse = null;
	
	        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	

	            listOfCourse = session.createQuery("from Courses").getResultList();

	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return listOfCourse;
	    }
	    
	    
	   public void updateCourseWithSubjects(String courseId, String[] subjectId) {
		   
			
		   
			  Transaction transaction = null;
			  SubjectDao subjectDao = new SubjectDao();
			  
			  boolean isCoursePresent;
			  try (Session session = HibernateUtils.getSessionFactory().openSession()) { // start a transaction
			  
				  transaction = session.beginTransaction();
					
				  Set<Subjects> assignSubject = new HashSet<>();
				  Set<Courses> assignCourse = new HashSet<>();
				  Courses courseEntity = getCourse(Integer.parseInt(courseId));

				  System.out.println("Courseselected:"+ courseEntity.getCourseName());

					 isCoursePresent = getSubjectCourseDetails(Integer.parseInt(courseId));

				  for(int i=0;i<subjectId.length;i++) {
				  
				  Subjects subjectEntity =	subjectDao.getSubject(Integer.parseInt(subjectId[i]));
				  System.out.println("Subjectselected:"+ subjectEntity.getSubjectName());
				 
				  assignSubject.add(subjectEntity);

				  }
			
				  courseEntity.setSubjects(assignSubject);

				  session.saveOrUpdate(courseEntity);
				  
				  
				  
				  System.out.println("Seleced Subjects added to a Set");
		
				  System.out.println("subjects have been added to the course ");
				 

				  
				  System.out.println("After Saving the course ");

		            // commit transaction
		            transaction.commit();
		            System.out.println("Sucessfully updated" );	  
			  }
			catch (Exception e) { 
				if (transaction != null) 
			{ 
					transaction.rollback(); 
			}
			  e.printStackTrace(); 
			  }
			 
		   
	   }	   
	   
	   
	   
	   
	   public boolean getSubjectCourseDetails(int courseId) {
		   
	        Transaction transaction = null;
	        Courses course = null;
	        boolean avl= false;
	        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            
	          String sql = "select * from subject_courses sc where sc.courseId= :courseId";
	          
	          Query query = session.createSQLQuery(sql);
	          query.setParameter("courseId", courseId);
	          
	          
	          List results = query.list();
	          
	         if(results!=null) {
	        	 avl = true;
	         }

	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return avl;
		   
	   }
	   
	   

}

	   
