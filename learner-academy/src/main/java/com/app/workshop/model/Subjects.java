package com.app.workshop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Subjects implements Serializable{




	private int subjectId;
	private String subjectName;

	private List<Teacher> teacher= new ArrayList<Teacher>();
	
	private Set<Courses> courses = new HashSet<Courses>();




public Subjects() {
		super();

	}


public Subjects(String subjectName) {
	super();
	this.subjectName = subjectName;
}


public Subjects(String subjectName, List<Teacher> teacher) {
	super();
	this.subjectName = subjectName;
	this.teacher = teacher;
}



public Subjects(int subjectId, String subjectName) {
	super();
	this.subjectId = subjectId;
	this.subjectName = subjectName;
}





public Subjects(int subjectId, List<Teacher> teacher) {
	super();
	this.subjectId = subjectId;
	this.teacher = teacher;
}





public Subjects(int subjectId, String subjectName, List<Teacher> teacher, Set<Courses> courses) {
	super();
	this.subjectId = subjectId;
	this.subjectName = subjectName;
	this.teacher = teacher;
	this.courses = courses;
}


public int getSubjectId() {
	return subjectId;
}





public void setSubjectId(int subjectId) {
	this.subjectId = subjectId;
}





public String getSubjectName() {
	return subjectName;
}





public void setSubjectName(String subjectName) {
	this.subjectName = subjectName;
}





public List<Teacher> getTeacher() {
	return teacher;
}






public void setTeacher(List<Teacher> teacher) {
	this.teacher = teacher;
}





public Set<Courses> getCourses() {
	return courses;
}





public void setCourses(Set<Courses> courses) {
	this.courses = courses;
}






public void addTeacher(Teacher tmpTeacher) {
	
	System.out.println("Add Teacher Method Invoked");
	tmpTeacher.setSubject(this);
	System.out.println("SubjectSet");
	teacher.add(tmpTeacher);
	System.out.println("Value of teacher Added");
	
	
}


}
