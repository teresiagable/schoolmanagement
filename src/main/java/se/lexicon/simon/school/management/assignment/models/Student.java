package se.lexicon.simon.school.management.assignment.models;

/**
 * 
 * @author Mattias Hansson
 *
 */
public class Student {
	
		
		 private int id;
		 private String name;
		 private String email;
		 private String addres;
		 
		 Student(int id, String name, String email, String addres){
			 this.id = id;
			 this.name = name;
			 this.email = email;
			 this.addres = addres;
		 }

		 
		 public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAddres() {
			return addres;
		}
		public void setAddres(String addres) {
			this.addres = addres;
		}
		 
		
		
	

}
