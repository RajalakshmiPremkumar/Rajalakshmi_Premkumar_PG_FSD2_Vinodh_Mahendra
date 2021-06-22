package com.app.workshop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
	
	private int studentId;
	private String studentName;
	
	private String email;
	
	
	
	

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Student(String studentName, String email) {
		super();
		this.studentName = studentName;
		this.email = email;
	}



	public Student(int studentId, String studentName, String email) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.email = email;
	}



	public int getStudentId() {
		return studentId;
	}

	
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	



}
