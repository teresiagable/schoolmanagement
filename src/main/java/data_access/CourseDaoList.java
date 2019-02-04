package data_access;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import models.Course;

public class CourseDaoList implements CourseDao {

	private static List<Course> courses = new ArrayList<>();

	@Override
	public Course saveCourse(Course course) {

		if (!courses.contains(course)) {
			courses.add(course);
		} else {
			System.out.println(course + " Already Exists");
		}
		return course;
	}

	@Override
	public Course findById(int id) {
		for (Course course : courses) {
			if(course.getId()==id) return course;
		}
		return null;
	}

	@Override
	public List<Course> findByName(String name) {
		List<Course> theCourses = new ArrayList<>();
		for (Course course : courses) {
			if (course.getCourseName().contains(name))
				theCourses.add(course);
		}
		return theCourses;
	}

	@Override
	public List<Course> findByDate(LocalDate date) {
		List<Course> theCourses = new ArrayList<>();
		for (Course course : courses) {
			if (course.getStartDate().compareTo(date)==0)
				theCourses.add(course);
		}
		return theCourses;
	}

	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return courses;
	}

	@Override
	public boolean removeCourse(Course course) {
		if (courses.contains(course)) {
			return courses.remove(course);
		} else {
			return false;
		}
	}
}
