package school.management.assignment.data_access;

import java.util.ArrayList;
import java.util.List;

import se.lexicon.simon.school.management.assignment.models.Course;

public class CourseDaoListTest {

	private static final List<Course> allCourses;
	private static final Course testCourse;
	
	static {
		testCourse = new Course(1, "SVE3",null, 10);
		
		allCourses = new ArrayList<>();
		allCourses.add(new Course(2,"ENG6",null, 10));
		allCourses.add(new Course(3,"ENG6",null, 10));
		
	}


}
