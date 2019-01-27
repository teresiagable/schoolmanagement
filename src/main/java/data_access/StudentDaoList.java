package data_access;

import java.util.ArrayList;
import java.util.List;

import models.Student;


public class StudentDaoList implements StudentDao {

	private static List<Student> students;

	@Override
	public Student saveStudent(Student student) {
		students.add(student);
		return null;
	}

	@Override
	public Student findByEmail(String email) {
		for (Student student : students) {
			if(student.getEmail().equalsIgnoreCase(email)) return student;
		}
		return null;
	}

	@Override
	public List<Student> findByName(String name) {
		List<Student> returnList = new ArrayList<>();

		for (Student s : students) {
			if (s.getName().toLowerCase().contains(name.toLowerCase()))
				returnList.add(s);
		}
		return returnList;
	}

	@Override
	public Student findById(int id) {
		for (Student student : students) {
			if (student.getId()==id)
				return student;
		}
		return null;
	}

	@Override
	public List<Student> findAll() {
		return students;
	}

	@Override
	public boolean deleteStudent(Student student) {
		students.remove(student);
		return false;
	}
}
