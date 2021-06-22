package com.app.workshop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;





public class Teacher implements Serializable{

	private int teacherId;
	private String teacherName;

	private String email;

	private Subjects subject;
	
	public Teacher() {
		super();

	}
	
	

	public Teacher(String teacherName, String email) {
		super();
		this.teacherName = teacherName;
		this.email = email;
	}



	public Teacher(int teacherId, String teacherName, String email) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.email = email;
	}

	public Teacher(int teacherId, String teacherName, String email, Subjects subject) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.email = email;
		this.subject = subject;
	}

	
	public Teacher( String teacherName, String email, Subjects subject) {
		super();
	
		this.teacherName = teacherName;
		this.email = email;
		this.subject = subject;
	}


	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	


	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public Subjects getSubject() {
		return subject;
	}

	public void setSubject(Subjects subject) {
		this.subject = subject;
	}
	
}