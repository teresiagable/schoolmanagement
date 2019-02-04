package services;

import java.time.LocalDate;
import java.util.List;

import Utils.HelpMe;
import data_access.CourseList;
import data_access.StudentList;
import models.Course;
import models.Student;

public class SchoolManagement {
	private CourseList courseList;
	private StudentList studentList;

	public SchoolManagement() {
		super();
		this.courseList = createCourseListFromDB();
		this.studentList = createStudentListFromDB();
	}

	private CourseList createCourseListFromDB() {
		CourseList theList = new CourseList();
		Course c = new Course("Math", LocalDate.now().plusDays(10), 10);
		theList.saveCourse(c);
		c = new Course("Swedish", LocalDate.now().plusDays(7), 10);
		theList.saveCourse(c);
		return theList;
	}

	private StudentList createStudentListFromDB() {
		StudentList theList = new StudentList();
		Student s = new Student(0, "Lisa", "lisa@home.se", "Hemma");
		theList.saveStudent(s);
		s = new Student(1, "Stina", "stina@home.se", "Borta");
		theList.saveStudent(s);
		s = new Student(2, "Kalle", "kalle@home.se", "Ute");
		theList.saveStudent(s);
		return theList;
	}

	public void findStudent() {
		int menuchoice = printFindStudentMenuAndGetChoice();
		switch (menuchoice) {
		case 1:
			int id = HelpMe.readIntegerfromUser("Enter id of the student: ");
			printStudent(studentList.findById(id));
			break;
		case 2:
			String name = HelpMe.readStringfromUser("Enter name of the student: ");
			printStudent(studentList.findByName(name));
			break;
		default:
			printStudent(studentList.findAll());
			break;
		}

	}

	public void findCourse() {
		int menuchoice = printFindCourseMenuAndGetChoice();
		switch (menuchoice) {
		case 1:
			String name = HelpMe.readStringfromUser("Enter name of the course: ");
			printCourse(courseList.findByName(name));
			break;
		case 2:
			//String date = HelpMe.readStringfromUser("Enter startdate: ");
			//printStudent(courseList.findByDate(date));
			break;
		default:
			printCourse(courseList.findAll());
			break;
		}
	}

	private void printStudent(Student theStudent) {
		System.out.println(theStudent);

	}

	private void printStudent(List<Student> theStudents) {
		for (Student s : theStudents) {
			System.out.println(s);
		}
	}

	private void printCourse(List<Course> theCourses) {
		for (Course course : theCourses) {
			System.out.println(course);
		}
	}

	private static int printFindStudentMenuAndGetChoice() {

		System.out.println("------------------");
		System.out.println("1 Find by id");
		System.out.println("2 Find by name");
		System.out.println("3 View all students");

		return HelpMe.readIntegerfromUser(null, 1, 3);

	}

	private static int printFindCourseMenuAndGetChoice() {

		System.out.println("------------------");
		System.out.println("1 Find by name");
		System.out.println("2 Find by startdate");
		System.out.println("3 View all courses");

		return HelpMe.readIntegerfromUser(null, 1, 3);

	}

	public void createStudent() {
		Student theStudent = new Student(0, HelpMe.readStringfromUser("Enter the students name: "),
				HelpMe.readStringfromUser("Email: "), HelpMe.readStringfromUser("Address: "));

	}

	public void createCourse() {
		Course theCourse = new Course(HelpMe.readStringfromUser("Enter the course name: "),
				HelpMe.readDatefromUser("Enter the startdate: "), HelpMe.readIntegerfromUser("Number of weeks: "));
	}

	public void registerStudent() {
		// TODO Auto-generated method stub

	}

	public void unregisterStudent() {
		// TODO Auto-generated method stub

	}

	public void editStudent() {
		// TODO Auto-generated method stub

	}

	public void editCourse() {
		// TODO Auto-generated method stub

	}

}
