package school.management.assignment.data_access;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.Period;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data_access.StudentDaoList;
import models.Student;

public class StudenDaoListTest {

	private StudentDaoList allStudents = new StudentDaoList();
	private Student testStudent = null;

	@Before
	public void init() {
		allStudents.saveStudent(new Student("A", "a@a.se", "Atown"));
		Student bStudent = new Student("B", "b@b.se", "Btown"));
		allStudents.saveStudent(bStudent);
		int expectedId = bStudent.getId();
		allStudents.saveStudent(new Student("C", "c@c.se", "Ctown"));
		testStudent = new Student("T", "t@t.se", "Ttown");
	}

	@After
	public void tidyUp() {
		allStudents.clear();
		testStudent = null;
	}

	@Test
	public void addStudent_Test() {
		Student expected = new Student("T2", "t2@t.se", "T2town");		
		assertEquals(expected, allStudents.saveStudent(expected));
	}

	@Test
	public void findById_Test() {
		Student expected = new Student("T3", "t3@t.se", "T3town");
		allStudents.saveStudent(expected);
		
		//assert(expected, allStudents.saveStudent(expected));

	}

	
	@Test
	public void findByName_Test() {

	}

	@Test
	public void findByEmail_Test() {

	}
//18 mars
}
