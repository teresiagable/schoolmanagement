package services;

import java.time.LocalDate;
import java.util.List;

import Utils.HelpMe;
import data_access.CourseDaoList;
import data_access.StudentDaoList;
import models.Course;
import models.Student;

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
		theList.saveCourse(new Course("Math", LocalDate.now().plusDays(10), 10));
		theList.saveCourse(new Course("Swedish", LocalDate.now().plusDays(7), 10));
		return theList;
	}

	private StudentDaoList createStudentListFromDB() {
		StudentDaoList theList = new StudentDaoList();
		theList.saveStudent(new Student("Lisa", "lisa@home.se", "Hemma"));
		theList.saveStudent(new Student("Stina", "stina@home.se", "Borta"));
		theList.saveStudent(new Student("Kalle", "kalle@home.se", "Ute"));
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
			LocalDate date = HelpMe.readDatefromUser("Enter startdate: ");
			printCourse(courseList.findByDate(date));
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
		Student theStudent = new Student(HelpMe.readStringfromUser("Enter the students name: "),
				HelpMe.readStringfromUser("Email: "), HelpMe.readStringfromUser("Address: "));
		studentList.saveStudent(theStudent);

	}

	public void createCourse() {
		Course theCourse = new Course(HelpMe.readStringfromUser("Enter the course name: "),
				HelpMe.readDatefromUser("Enter the startdate: "), HelpMe.readIntegerfromUser("Number of weeks: "));
		courseList.saveCourse(theCourse);
	}

	public void registerStudent() {
		int course_id = HelpMe.readIntegerfromUser("Enter the id of the course: ");
		Course theCourse = courseList.findById(course_id);
		System.out.println(theCourse);
		int student_id = HelpMe.readIntegerfromUser("Enter the id of the student: ");
		Student theStudent = studentList.findById(student_id);
		System.out.println(theStudent);
		
		theCourse.register(theStudent);
	}

	public void unregisterStudent() {
		int course_id = HelpMe.readIntegerfromUser("Enter the id of the course: ");
		Course theCourse = courseList.findById(course_id);
		System.out.println(theCourse);
		int student_id = HelpMe.readIntegerfromUser("Enter the id of the student: ");
		Student theStudent = studentList.findById(student_id);
		System.out.println(theStudent);
		
		theCourse.unregister(theStudent);
	}

}
