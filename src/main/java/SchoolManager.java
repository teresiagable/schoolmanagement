import Utils.HelpMe;
import services.SchoolManagement;

public class SchoolManager {

	public static void main(String[] args) {
		SchoolManagement theManager = new SchoolManagement();

		System.out.println("Welcome to the School management system");

		while (true) {

			int menuChoice = printAndGetMenuChoice();

			switch (menuChoice) {
			case 1:
				theManager.findStudent();
				break;
			case 2:
				theManager.findCourse();
				break;
			case 3:
				theManager.createStudent();
				break;
			case 4:
				theManager.createCourse();
				break;
			case 5:
				theManager.registerStudent();
				break;
			case 6:
				theManager.unregisterStudent();
				break;
			default:
				break;
			}
		}
	}

	private static int printAndGetMenuChoice() {

		System.out.println("------------------");
		System.out.println("1. Find students");
		System.out.println("2. Find course");
		System.out.println("3. Create new student");
		System.out.println("4. Create new course");
		System.out.println("5. Register students to course");
		System.out.println("6. Unregister students from course");

		return HelpMe.readIntegerfromUser(null, 1, 6);

	}
}
