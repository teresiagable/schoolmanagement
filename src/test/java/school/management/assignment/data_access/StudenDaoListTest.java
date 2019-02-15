package school.management.assignment.data_access;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data_access.StudentDaoList;
import models.Student;

public class StudenDaoListTest {

	private StudentDaoList allStudents = new StudentDaoList();
	private Student testStudent;
	public int testStudentId =0;

	@Before
	public void init() {
		allStudents.saveStudent(new Student("A", "a@a.se", "Atown"));
		allStudents.saveStudent(new Student("B", "b@b.se", "Btown"));
		allStudents.saveStudent(new Student("C", "c@c.se", "Ctown"));

		testStudent = new Student("T", "t@t.se", "Ttown");
		allStudents.saveStudent(testStudent);
		testStudentId = testStudent.getId();
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
		//testStudent = new Student("T", "t@t.se", "Ttown");
		//testStudentId = testStudent.getId();
		assertEquals(testStudent, allStudents.findById(testStudentId));
		assertEquals(null, allStudents.findById(1));  //1 is lower than the sequencer
		
	}

	
	@Test
	public void findByName_Test() {
		List<Student> aList = new ArrayList<Student>();
		assertEquals(aList, allStudents.findByName("ZZZZTop"));
		aList.add(testStudent);
		assertEquals(aList, allStudents.findByName("T"));
	}

	@Test
	public void findByEmail_Test() {
		assertEquals(testStudent, allStudents.findByEmail("t@t.se"));
		assertEquals(null, allStudents.findByEmail("heja@sveja.se"));
	}
	
	@Test
	public void idExists_Test() {
		assertTrue(allStudents.idExists(testStudentId));
		assertFalse(allStudents.idExists(1));  //id 1 is lower  than sequencer
	}
//18 mars
}
