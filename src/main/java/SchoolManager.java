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
//		case 3:
//			Product prod = theManager.doPurchase();
//			if (prod != null)
//				theManager.doUse(prod);
//			break;
//		case 4:
//			theManager.doExamine();
//			break;
//		case 5:
//			theManager.cashOut();
//			break;
//		case 6:
//			theManager.leave();
//			break;
		default:
			break;
		}
	}
}

private static int printAndGetMenuChoice() {

		System.out.println("------------------");
		System.out.println("1. Find students");
		System.out.println("2. Find Course");
		System.out.println("3. Create new student");
		System.out.println("4. Create new course");
		System.out.println("5. Register students from course");
		System.out.println("6. Unregister students from course");
		System.out.println("7. Edit student");
		System.out.println("8. Edit course");


		return HelpMe.readIntegerfromUser(null,1,6);

}
private static int printFindStudentAndGetChoice() {

	System.out.println("------------------");
	System.out.println("1 Find by id");
	System.out.println("2 Find by name");
	System.out.println("3 View all students");
	
	return HelpMe.readIntegerfromUser(null,1,3);

}
private static int printFindCourseAndGetChoice() {

	System.out.println("------------------");
	System.out.println("1 Find by id");
	System.out.println("2 Find by name");
	System.out.println("3 View all students");
	
	return HelpMe.readIntegerfromUser(null,1,3);

}
}
