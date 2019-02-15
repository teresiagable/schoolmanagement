package data_access;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
			if (course.getId() == id)
				return course;
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
		
		Predicate<Course> pEquals = (Course c) -> c.getStartDate().equals(date);
		Predicate<Course> pAfter = (Course c) -> c.getStartDate().isAfter(date);
		Predicate<Course> pBefore = (Course c) -> c.getStartDate().isBefore(date.plusMonths(1));
		Predicate<Course> pBetween	= pAfter.and(pBefore);
	
		//return all courses with startdate = date or that starts within one month	
		//Wow. Lamda did not make this more readable at all  :-D
		return courses.stream()
				.filter((Course c) -> pEquals.or(pBetween).test(c))
				.sorted((Comparator.comparing(Course::getStartDate)))
				.collect(Collectors.toList());
	}

	@Override
	public List<Course> findAll() {
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

	
	public void clear() {
			courses.clear();		
	}
}
