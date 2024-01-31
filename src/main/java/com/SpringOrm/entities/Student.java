package com.SpringOrm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity // this annotation is used to define that this class is an entity class that means this class represents a table of the database.
@Table(name = "student") // this annotation is used to create a table with the name specified in this annotation , or else by default it uses the class name as the default name to create the table in the database.
public class Student {

	@Id // This annotation is used to make id as the primary key for this table, you can also modify this annotation in order to generate auto increament values of id.
	@Column(name = "id") // this annotation is used in order to modify the column names which will be there in the database. By default it uses property name as the default name to create column in the database.
	private int studentId;
	@Column(name = "name")
	private String studentName;
	@Column(name = "city")
	private String studentCity;
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
	public String getStudentCity() {
		return studentCity;
	}
	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}
	public Student(int studentId, String studentName, String studentCity) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentCity = studentCity;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentCity=" + studentCity
				+ "]";
	}
	
	
}
