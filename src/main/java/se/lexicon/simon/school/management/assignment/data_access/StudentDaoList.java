package se.lexicon.simon.school.management.assignment.data_access;

import java.util.ArrayList;
import java.util.List;

import se.lexicon.simon.school.management.assignment.models.Student;

/**
 * 
 * @author Mattias Hansson
 *
 */

public class StudentDaoList implements StudentDao {

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
		List<Student> returnList = new ArrayList<>();

		for (Student s : student) {
			if (s.getName().toLowerCase().contains(name.toLowerCase()))
				returnList.add(s);
		}
		return returnList;
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
