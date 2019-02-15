package school.management.assignment.data_access;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data_access.CourseDaoList;
import models.Course;

public class CourseDaoListTest {

	private CourseDaoList allCourses = new CourseDaoList();
	private Course testCourse;
	public int testCourseId =0;

	@Before
	public void init() {
		allCourses.saveCourse(new Course("C1", LocalDate.parse("2019-01-02", DateTimeFormatter.ofPattern("yyyy-MM-dd")),20));
		allCourses.saveCourse(new Course("C2", LocalDate.parse("2018-09-02", DateTimeFormatter.ofPattern("yyyy-MM-dd")),20));
		allCourses.saveCourse(new Course("C3", LocalDate.parse("2019-03-15", DateTimeFormatter.ofPattern("yyyy-MM-dd")),10));

		testCourse = new Course("CT", LocalDate.parse("2019-04-02", DateTimeFormatter.ofPattern("yyyy-MM-dd")),10);
		allCourses.saveCourse(testCourse);
		testCourseId = testCourse.getId();
	}

	@After
	public void tidyUp() {
		allCourses.clear();
		testCourse = null;
	}

	@Test
	public void addAndRemoveCourse_Test() {
		Course expected = new Course("C1", LocalDate.parse("2019-01-02", DateTimeFormatter.ofPattern("yyyy-MM-dd")),20);		
		assertEquals(expected, allCourses.saveCourse(expected));
		assertTrue(allCourses.removeCourse(expected));
	}

	@Test
	public void findById_Test() {
		assertEquals(testCourse, allCourses.findById(testCourseId));
		assertEquals(null, allCourses.findById(1));  //1 is lower than the sequencer	
	}

	
	@Test
	public void findByName_Test() {
		List<Course> aList = new ArrayList<Course>();
		assertEquals(aList, allCourses.findByName("ZZZZTop"));
		aList.add(testCourse);
		assertEquals(aList, allCourses.findByName("CT"));
	}

	@Test
	public void findByEmail_Test() {
		List<Course> aList = new ArrayList<Course>();
		aList.add(testCourse);
		assertEquals(aList, allCourses.findByDate(LocalDate.parse("2019-04-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
	}
	
	@Test
	public void removeCourse_Test() {
		Course notInList = new Course("Free Course", LocalDate.parse("2019-01-02", DateTimeFormatter.ofPattern("yyyy-MM-dd")),20);
		assertTrue(allCourses.removeCourse(testCourse));
		assertFalse(allCourses.removeCourse(notInList)); 
	}
//18 mars
}
