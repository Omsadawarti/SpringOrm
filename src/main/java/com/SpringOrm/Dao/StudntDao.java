package com.SpringOrm.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.SpringOrm.entities.Student;

@Component("studentDao")
public class StudntDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional // by default the db is in read mode only that means you can only fetch the data but not be able to insert or wrtie in the data base,  this annotation is used above the method which performs write operations such as insert  , update etc, and to activate this annotation , you have to edit schema location in xml file and add the tag "<tx:annotation-driven/>"
	
	public int insert(Student student) {
		// this method will insert the object of studnt class in the database.
		
		int i = Integer.parseInt(this.hibernateTemplate.save(student).toString());
		return i;
		
	}
	
	public Student getStudentDetail(int studentId) {
		// this method is use to fetch the record of only one student , specified by the student id which is the primary key of student table.
		// you can also use load() method to perform the same task
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	
	public List<Student> getAllStudentDetails(){
		// this method is use to fetch the record of all the student
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
	@Transactional
	public void update(Student student) {
		// this method is use to update a student record in the database, 
		this.hibernateTemplate.update(student);
	}
	
	@Transactional
	public void delete(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);// first get the object of the studennt whose record is to be deleted.
		this.hibernateTemplate.delete(student); // provide that record to this method to delete that perticular object of that student from the database.
	}
}
