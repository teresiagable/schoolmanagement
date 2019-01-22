package se.lexicon.simon.school.management.assignment.data_access;

import java.time.LocalDate;
import java.util.List;

import se.lexicon.simon.school.management.assignment.models.Course;

/**
 * 
 * @author Simon Elbrink
 *
 */
public class CourseDaoList implements CourseDao {

	private static List<Course> courses;

	@Override
	public Course saveCourse(Course course) {

		if (!courses.contains(course)) {
			courses.add(course);
		} else {
			System.out.println(course + " Allready Exists");
		}

		return course;
	}

	@Override
	public Course findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findByDate(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeCourse(Course course) {
		if(courses.contains(course)) {
			return courses.remove(course);
		} else {
			return false;
		}
	}

	
	

}
