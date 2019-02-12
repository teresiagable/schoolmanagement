package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Simon Elbrink
 *
 */
public class Course {

	private static int sequencer = 1000;
	private int id;
	private String courseName;
	private LocalDate startDate;
	private int weekDuration;
	private List<Student> students = new ArrayList<Student>();

	/**
	 * 
	 * @param id
	 * @param courseName
	 * @param startDate
	 * @param weekDuration
	 */
	public Course(String courseName, LocalDate startDate, int weekDuration) {
		this.id = ++sequencer;
		this.courseName = courseName;
		this.startDate = startDate;
		this.weekDuration = weekDuration;
	}

	public void register(Student student) {
		// only add students once
		if (!students.contains(student)) {
			boolean added = students.add(student);

		if(added) System.out.println(student.getName() +" has been registered to "+ this.getCourseName());
		}
		else System.out.println("Student "+ student.getName()+" not found");
	}

	public void unregister(Student student) {
		boolean removed = students.remove(student);	
	
		if(removed) System.out.println(student.getName() +" has been unregistered from "+ this.getCourseName());
		else System.out.println(student.getName() +" was not registered to "+ this.getCourseName());
	}

	public int getId() {
		return id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public int getWeekDuration() {
		return weekDuration;
	}

	public void setWeekDuration(int weekDuration) {
		this.weekDuration = weekDuration;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "\nID:" + this.id + " \tCourse: " + this.courseName + " \tStartDate: " + this.startDate
				+ " \tDuration in Week: " + this.weekDuration;
	}

}
