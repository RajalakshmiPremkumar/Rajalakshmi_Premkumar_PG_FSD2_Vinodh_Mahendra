package com.app.workshop.model;


import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

public class Courses implements Serializable {

	private int courseId;
	private String courseName;
	
	//private Student student;
	
	private Set<Subjects> subjects = new HashSet<Subjects>(0);



	public Courses() {
		super();
		
	}


	public Courses(String courseName) {
		super();

		this.courseName = courseName;

	}

	

	public Courses(int courseId, String courseName) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
	}


	
	  public Set<Subjects> getSubjects() { 
		  
		  return subjects; 
		  }
	  
	  
	  public void setSubjects(Set<Subjects> subjects) 
	  { 
		  this.subjects = subjects; 
		  }
	 


	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	

	  

	

}
