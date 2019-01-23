package services;

import java.time.LocalDate;
import java.util.List;

import Utils.HelpMe;
import se.lexicon.simon.school.management.assignment.data_access.CourseDaoList;
import se.lexicon.simon.school.management.assignment.data_access.StudentDaoList;
import se.lexicon.simon.school.management.assignment.models.Course;
import se.lexicon.simon.school.management.assignment.models.Student;

public class SchoolManagement {
	private CourseDaoList courseList;
	private StudentDaoList studentList;
	
	public SchoolManagement() {
		super();
		this.courseList = createCourseListFromDB();
		this.studentList = createStudentListFromDB();
	}

	private CourseDaoList createCourseListFromDB() {
		CourseDaoList theList = new CourseDaoList();
		Course c = new Course(0, "Math", LocalDate.now().plusDays(10), 10);
		theList.saveCourse(c);
		c = new Course(1, "Swedish", LocalDate.now().plusDays(7), 10);
		theList.saveCourse(c);
		return theList;
	}
	private StudentDaoList createStudentListFromDB() {
		StudentDaoList theList = new StudentDaoList();
		Student s = new Student(0, "Lisa", "lisa@home.se", "Hemma");
		theList.saveStudent(s);
		return theList;
	}

	public void findStudent() {
		int menuchoice = printFindStudentMenuAndGetChoice();
		switch (menuchoice) {
		case 1:
			int id = HelpMe.readIntegerfromUser("Enter id of the student:");
			printStudent(studentList.findById(id));
			break;
		case 2:
			String name = HelpMe.readStringfromUser("Enter name of the student:");
			printStudent(studentList.findByName(name));
			break;
		default:
			break;
		}
		
	}
	
	public void findCourse() {
		// TODO Auto-generated method stub
		
	}
	private void printStudent(Student theStudent) {
		System.out.println(theStudent);
		
	}
	private void printStudent(List<Student> theStudents) {
		for (Student s : theStudents) {
			System.out.println(s);
		}
	}
	
	private void printCourse(Course theCourse) {
		System.out.println(theCourse);
		
	}

	private static int printFindStudentMenuAndGetChoice() {

		System.out.println("------------------");
		System.out.println("1 Find by id");
		System.out.println("2 Find by name");
		System.out.println("3 View all students");
		
		return HelpMe.readIntegerfromUser(null,1,3);

	}


	
}
