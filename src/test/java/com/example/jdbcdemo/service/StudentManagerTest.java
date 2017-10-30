package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Test;

import com.example.jdbcdemo.domain.Student;

public class StudentManagerTest {
	
	
	StudentManager studentManager = new StudentManager();
	
	private final static String FIRSTNAME_1 = "Franek";
	private final static String LASTNAME_1 = "Kwiatkowski";
	private final static Date DOB_1 = Date.valueOf("1990-05-26");
	
	@Test
	public void checkConnection(){
		assertNotNull(studentManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		Student student = new Student();
		
		
		studentManager.clearStudents();
		assertEquals(1, studentManager.addStudent(student));
		
		List<Student> listOfStudents = studentManager.getAllStudents();
		Student studentRetrieved = listOfStudents.get(0);
		
		assertEquals(FIRSTNAME_1, studentRetrieved.getFirstname());
		assertEquals(LASTNAME_1, studentRetrieved.getLastname());
		assertEquals(DOB_1, studentRetrieved.getDob());
		
	}

}
