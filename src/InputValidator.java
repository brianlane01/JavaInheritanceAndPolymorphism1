import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {
	
	 public static int getValidatedInteger(Scanner scanner, String prompt) {
		 int result = 0;
	     boolean validInput = false;

	     while (!validInput) {
	    	 System.out.println(prompt);
	         try {
	             result = scanner.nextInt();
	             validInput = true; // Input is valid, exit the loop
	         } 
	         catch (InputMismatchException e) {
	        	 System.out.println("Invalid input. Please enter a valid integer.");
	        	 scanner.next(); // Consume the invalid input
	        }
	     }

	     return result;
	 }

	 public static double getValidatedDouble(Scanner scanner, String prompt) {
		 double result = 0.0;
		 boolean validInput = false;

		 while (!validInput) {
			 System.out.println(prompt);
			 try {
				 result = scanner.nextDouble();
				 validInput = true; // Input is valid, exit the loop
			 } 
			 catch (InputMismatchException e) {
				 System.out.println("Invalid input. Please enter a valid double.");
				 scanner.next(); // Consume the invalid input
	      }
	  }

		 return result;
	  }
}
