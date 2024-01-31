package com.SpringOrm;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.SpringOrm.Dao.StudntDao;

import com.SpringOrm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    		ApplicationContext context = new ClassPathXmlApplicationContext("com/SpringOrm/config.xml");
    		
    		StudntDao studntDao = context.getBean("studentDao",StudntDao.class);
    		
    		Student student = new Student();
    		student.setStudentId(2);
    		student.setStudentName("Roshan Dalal");
    		student.setStudentCity("Amrawati");
    		studntDao.insert(student);
    		System.out.println("Inserted");
    		
    		List<Student> students = studntDao.getAllStudentDetails();
    		students.forEach(System.out::println);
    		
    		
    }
}
