package data_access;

import java.time.LocalDate;
import java.util.List;

import models.Course;

public interface CourseDao {

	Course saveCourse(Course course);
	Course findById(int id);
	List<Course>findByName(String name);
	List<Course>findByDate(LocalDate date);
	List<Course>findAll();
	boolean removeCourse(Course course);
	
	
	
}
