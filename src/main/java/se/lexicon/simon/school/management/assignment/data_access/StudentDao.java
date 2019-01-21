package se.lexicon.simon.school.management.assignment.data_access;

import java.util.List;


import se.lexicon.simon.school.management.assignment.models.Student;
/**
 * 
 * @author Mattias Hansson
 *
 */

public interface StudentDao {
	
	Student saveStudent(Student student);
	Student findByEmail(String email);
	List<Student>findByName(String name);
	Student findById(int id);
	List<Student>findAll();
	boolean deleteStudent(Student student);

}
