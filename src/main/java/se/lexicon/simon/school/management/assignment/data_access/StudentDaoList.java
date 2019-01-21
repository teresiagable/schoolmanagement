package se.lexicon.simon.school.management.assignment.data_access;

import java.util.List;

import se.lexicon.simon.school.management.assignment.models.Student;

/**
 * 
 * @author Mattias Hansson
 *
 */

public class StudentDaoList implements StudentDao{

	private static List<Student> student;

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}
}
