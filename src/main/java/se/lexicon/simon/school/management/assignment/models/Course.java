package se.lexicon.simon.school.management.assignment.models;

import java.time.LocalDate;
import java.util.List;

/**
 * 
 * @author Simon Elbrink
 *
 */
public class Course {
		
		private int id;
		private String courseName;
		private LocalDate startDate;
		private int weekDuration;
		private List<Student> students;
		
		/**
		 * 
		 * @param id
		 * @param courseName
		 * @param startDate
		 * @param weekDuration
		 */
		public Course(int id, String courseName, LocalDate startDate, int weekDuration) {
			super();
			this.id = id;
			this.courseName = courseName;
			this.startDate = startDate;
			this.weekDuration = weekDuration;
			}

		public void register (Student student) {
			//only add students once
			if(!students.contains(student)) students.add(student);
		}
		
		public void unregister( Student student) {
			students.remove(student);
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
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
			return "\nID:" + this.id + " \tCourse: " + this.courseName + " \tStartDate: " + this.startDate + " \tDuration in Week: " + this.weekDuration;
		}
		
		

}
