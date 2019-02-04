package school.management.assignment.data_access;

import java.util.ArrayList;
import java.util.List;

import models.Course;

public class CourseDaoListTest {

	private static final List<Course> allCourses;
	private static final Course testCourse;
	
	static {
		testCourse = new Course( "SVE3",null, 10);
		
		allCourses = new ArrayList<>();
		allCourses.add(new Course("ENG6",null, 10));
		allCourses.add(new Course("ENG6",null, 10));
		
	}


}
