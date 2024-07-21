import java.util.ArrayList; 
import java.util.Arrays;
import java.util.Scanner;
import java.util.Date;
import java.util.InputMismatchException;

public class Bank {
	// These variables are constants they cannot be changed 
	// These will modify the color of text and the background for the text in the console when information is printed to it. 
	final String RESET = "\u001B[0m";
    final String RED_TEXT = "\u001B[31m";
    final String GREEN_TEXT = "\u001B[32m";
    final String YELLOW_TEXT = "\u001B[33m";
    final String BLACK_BG = "\u001B[40m";
    final String WHITE_BG = "\u001B[47m";
    final String BLUE_TEXT = "\u001B[34m";
    final String PURPLE_TEXT = "\u001B[35m";
    final String BRIGHTCYAN_TEXT = "\u001B[96m";
	
	ArrayList<Customer> customers = new ArrayList<Customer>();
	ArrayList<BankBranch> bankBranches = new ArrayList<BankBranch>();
	ArrayList<Account> bankAccounts = new ArrayList<Account>();
	
	public void Run() {
		
		/*
		 * This is the customer that can be used for the requirement in the problem prompt. After all the seeding is completed the program will go into a method that 
		 * will go through each of the requirements in the problem prompt. After this it will go to the main menu method and everything can be done by the user if you want...
		 * 				
		 * 						HERE ARE INSTRUCTIONS FOR MANUALLY WALKING THROUGH THE REQUIREMENTS USING THE MENU OPTIONS
		 * 
		 * 	TODO	(You can also choose to follow the Menu options allowing you to create the Customer and account and have the account
		 * 			added to the chicago branch)
		 * 
		 * 	TODO	(Once you have created the customer and account you can then go to Manage Accounts ---> Make A Deposit -->
		 * 			Select to enter the Account Number or Customer Name (Account Number is randomly generated so you will need to display all accounts first and grab the
		 * 			Account Number if you go that way) --> then select the Checking account for the Customer ---> select Make Deposit --> and then enter $100
		 * 			deposit to meet requirement C)
		 * 
		 * 	TODO 	For Requirement D first select Manage Accounts ---> Create New Account ---> From here you can select to create an account for
		 * 			a customer that already exists or you can create a new customer as well --> follow the prompts in the console for the selection
		 * 			you made ---> as part of the process you will be able to enter the initial balance of $100 and the interest rate of 10% --> system will add everything to the proper ArrayList
		 * 			Once the account is created it will display the details to you ---> MAKE SURE TO COPY OR WRITE DOWN THE ACCOUNT NUMBER FOR THE NEXT STEP or save the customer name you chose
		 * 
		 * 	TODO	For requirement E from the main menu select Manage Accounts ---> Search For Account ---> Select search by Account Number or Name (if you saved Account number do that)
		 * 			---> if you entered the Account number it will then display the details for that account...... If you chose to enter the customer's name then the system will pull up the accounts for that 
		 * 			Customer and you will need to select the savings account to display the details.... if there are more than one savings account for the
		 * 			customer you may have to repeat these steps if you do not know the account number.... SAVE THE ACCOUNT NUMBER FOR THE SAVINGS ACCOUNT FOR THE NEXT PART.....
		 * 
		 * 	TODO 	For requirement F go to Manage Accounts ---> Make A Deposit -->
		 * 			Select to enter the Account Number or Customer Name  --> then input either the account number or the customer's name (again it is simpler to use the account number if you 
		 * 			have it) ---> select Make Deposit --> and then enter $100
		 * 
		 * 	TODO    Once you have made the $100 deposit return to the Manage Accounts Menu ---> select Calculate Interest ---> Select to Enter Acc Number or the Customer's name --->
		 * 			then enter the corresponding information ---> the account is selected and the Interest amount will be displayed to you
		 * 
		 * 			
		 * This a commercial customer and will have a checking account at the Chicago Branch of the Bank
		 * branch1 creates the Chicago Branch
		 * Then the Customer is created
		 * The the CheckingAccount is created using the Customer and Branch created above
		 * Then the system will add the created account to the Customer and Branch
		 */
		BankBranch branch1 = new BankBranch("Chicago Branch", "123 Lakeside Drive, Chicago, IL 60601");
		CommercialCustomer customer5 = new CommercialCustomer("ACME Industries", "100 Arkham Way", "555-213-5467", 620, "Harleen Quinzel", "555-324-6578" );
		CheckingAccount account5 = new CheckingAccount(898873.75, new Date(), customer5, branch1, CheckStyle.FANTASTY_AND_SCIFI);
		branch1.addAccount(account5);
		customer5.addAccount(account5);
		
		/*
		 * These are additional pre-seeded branches that can be used in the program once it starts
		 */
		BankBranch branch2 = new BankBranch("Gotham City Branch", "123 Wayne Avenue, Gotham City");
		BankBranch branch3 = new BankBranch("Metropolis Branch", "456 Daily Planet Plaza, Metropolis");
		BankBranch branch4 = new BankBranch("Central City Branch", "4789 Keystone Road, Central City");
		BankBranch branch5 = new BankBranch("Coast City Branch", "654 Lantern Lane, Coast City");
		BankBranch branch6 = new BankBranch("Asgard Branch", "789 Bifrost Boulevard, Asgard");
		BankBranch branch7 = new BankBranch("Latveria Branch", "654 Doom Street, Doomstadt, Latveria");
		
		/*
		 * These are additional Customers that can be used in the program once it starts
		 */
		PersonalCustomer customer1 = new PersonalCustomer("Barry Allen", "1234 Fast Lane", "555-345-6789", "555-123-4567", "555-234-5678");
		PersonalCustomer customer2 = new PersonalCustomer("Rachel Roth", "5678 Shadow Lane", "555-456-7890", "555-123-4567", "555-234-5678");
		CommercialCustomer customer3 = new CommercialCustomer("Wayne Enterprises", "1007 Gotham Way", "555-890-1234", 820, "Bruce Wayne", "555-901-2345" );
		CommercialCustomer customer4 = new CommercialCustomer("Stark Industries", "10880 Malibu Point", "555-432-7658", 830, "Tony Stark", "555-901-6765" );
		PersonalCustomer customer6 = new PersonalCustomer("Clark Kent", "1234 Smallville Road", "555-690-6789", "555-178-4567", "555-909-5678");
		PersonalCustomer customer7 = new PersonalCustomer("Peter Parker", "20 Ingram Street", "555-600-6789", "555-000-4567", "555-000-5678");
		
		/*
		 * These are additional Accounts that can be used in the program once it starts
		 */
		CheckingAccount account1 = new CheckingAccount(1573.75, new Date(), customer1, branch4, CheckStyle.ANIMAL_LOVERS);
		CheckingAccount account2 = new CheckingAccount(573.75, new Date(), customer2, branch5, CheckStyle.ECO_FRIENDDLY);
		CheckingAccount account3 = new CheckingAccount(59559898873.75, new Date(), customer3, branch2, CheckStyle.INSPIRATIONAL_QUOTES);
		CheckingAccount account4 = new CheckingAccount(595899898873.75, new Date(), customer4, branch7, CheckStyle.NATURE_INSPIRED);
		CheckingAccount account6 = new CheckingAccount(898873.75, new Date(), customer6, branch3, CheckStyle.CLASSIC);
		CheckingAccount account7 = new CheckingAccount(873.75, new Date(), customer7, branch1, CheckStyle.MONDERN_MINIMALIST);
		SavingsAccount account8 = new SavingsAccount(100.00, new Date(), customer1, branch4, 10);
		SavingsAccount account9 = new SavingsAccount(5890.00, new Date(), customer2, branch5, 5.8);
		SavingsAccount account10 = new SavingsAccount(345587757890.00, new Date(), customer3, branch2, 8.3);
		SavingsAccount account11 = new SavingsAccount(577758857890.00, new Date(), customer4, branch7, 3.3);
		SavingsAccount account12 = new SavingsAccount(88890.00, new Date(), customer5, branch1, 10);
		SavingsAccount account13 = new SavingsAccount(17890.00, new Date(), customer6, branch3, 10);
		SavingsAccount account14 = new SavingsAccount(10890.00, new Date(), customer7, branch1, 10);
		
		/*
		 * This will add all the accounts to the branch that was selected when the account was created above
		 */
		branch1.addAccount(account14);
		branch1.addAccount(account12);
		branch1.addAccount(account7);
		branch4.addAccount(account1);
		branch4.addAccount(account8);
		branch5.addAccount(account2);
		branch5.addAccount(account9);
		branch2.addAccount(account3);
		branch2.addAccount(account10);
		branch7.addAccount(account4);
		branch7.addAccount(account11);
		branch3.addAccount(account6);
		branch3.addAccount(account13);
		
		/*
		 * This will add the accounts to the customer that was selected as the account owner when the account was created above
		 */
		customer1.addAccount(account1);
		customer1.addAccount(account8);
		customer2.addAccount(account2);
		customer2.addAccount(account9);
		customer3.addAccount(account3);
		customer3.addAccount(account10);
		customer4.addAccount(account4);
		customer4.addAccount(account11);
		customer5.addAccount(account12);
		customer6.addAccount(account6);
		customer6.addAccount(account13);
		customer7.addAccount(account14);
		customer7.addAccount(account7);
		
		// This is adding all the customers with their assigned accounts to the ArrayList customers
		customers.add(customer1);
		customers.add(customer2);
		customers.add(customer3);
		customers.add(customer4);
		customers.add(customer5);
		customers.add(customer6);
		customers.add(customer7);
		
		// This is utilizing built in Java methods to add all of the accounts to the ArrayList bankAccounts at one time
		bankAccounts.addAll(Arrays.asList(account14, account13, account12, account11, account10, account9, account8, 
											account7, account6, account5, account4, account3, account2, account1));
		
		// This is adding all the bank branches created above with their assigned accounts to the ArrayList bankBranches at one time
		bankBranches.addAll(Arrays.asList(branch1, branch2, branch3, branch4, branch5, branch6, branch7));
		
		
		// This will make the UI portion of the program be displayed once all the accounts, customers, and branches are created and added
		// to their ArrayList.
		problemRequirements(customer5, account5, branch1);
	}
	
	public void problemRequirements(Customer customer, CheckingAccount account, BankBranch branch) {
		System.out.println(GREEN_TEXT + BLACK_BG + "Here are the details of the Commercial Cutomer with a Checking Account in the Chicago Branch");
		System.out.println(" ");
		System.out.println(" ");
		pressAnyKey();
		System.out.println(customer);
		pressAnyKey();
		
		System.out.println(GREEN_TEXT + BLACK_BG + "Here are the details of the Checkin account for the above customer before a deposit is made..");
		System.out.println(" ");
		System.out.println(" ");
		
		System.out.println(account);
		System.out.println(" ");
		System.out.println(" ");
		pressAnyKey();
		
		System.out.println(GREEN_TEXT + BLACK_BG + "Making a $100.00 deposit into the checking account of the above customer");
		account.makeDeposit(100.00);
		System.out.println(" ");
		System.out.println(" ");
		pressAnyKey();
		
		System.out.println(GREEN_TEXT + BLACK_BG + "Here is the details of the account after a deposit is made..");
		System.out.println(" ");
		System.out.println(" ");
		
		System.out.println(account);
		System.out.println(" ");
		System.out.println(" ");
		pressAnyKey();
		
		System.out.println(GREEN_TEXT + BLACK_BG + " Creating aSavings account for customer in a branch with an initial balance of $100 and an interest rate of 10%");
		System.out.println(" ");
		System.out.println(" ");
		SavingsAccount savingsAcount = new SavingsAccount(100.00, new Date(), customer, branch, 10);
		
		customer.addAccount(savingsAcount);
		branch.addAccount(savingsAcount);
		bankAccounts.add(savingsAcount);
		pressAnyKey();
		
		System.out.println(savingsAcount);
		System.out.println(" ");
		System.out.println(" ");
		pressAnyKey();
		
		System.out.println(GREEN_TEXT + BLACK_BG + "Making a $100.00 deposit into the savings account just created");
		savingsAcount.makeDeposit(100.00);
		System.out.println(" ");
		System.out.println(" ");
		pressAnyKey();
		
		System.out.println(GREEN_TEXT + BLACK_BG + "Calculating the interest of the savings account just created");
		double interestAmount = savingsAcount.calculateInterest();
		System.out.println(" ");
		System.out.println(" ");
		pressAnyKey();
		
		System.out.println(GREEN_TEXT + BLACK_BG + "Here is the details of the Savings account after a deposit is made..");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(savingsAcount);
		pressAnyKey();
		
		System.out.println("Here is the interest for the account: $" + interestAmount);
		System.out.println(" ");
		System.out.println(" ");
		pressAnyKey();
		
		mainMenu();	
	}
	
	/**
	 * Description: This method will begin the UI element of the program
	 *				It will display a menu and then allow the user to select a response by
	 *				entering a corresponding integer that the switch statement will then use to 
	 *				Navigate the user to additional methods and functionality.
	 *				This method does not take in any parameters. 
	 */
	public void mainMenu() {
		
		// This bool will be used for the below while loop to keep the menu displayed until a correct option is selected
		boolean finished = false;
		
		//this will be used to pass what integer the user enters into the console back into the switch statement
		int userChoice = 0;
		
		Scanner scanner = new Scanner(System.in); 
		
		// Welcome message
		System.out.println("");
		System.out.println(PURPLE_TEXT + BLACK_BG + "                                                            ");
		System.out.println(PURPLE_TEXT + BLACK_BG + "                                                            ");
		System.out.println(PURPLE_TEXT + BLACK_BG + "    Welcome to the Quantum Realms Bank Management System    ");
		System.out.println(PURPLE_TEXT + BLACK_BG + "                                                            ");
		System.out.println(PURPLE_TEXT + BLACK_BG + "                                                            ");
		System.out.println("");
		System.out.println("");
		
		// used to keep the menu displayed until moving to a new method or Exit is selected
        while (finished == false) {
        	
        	// Display a menu for the user to select from 
        	System.out.println(PURPLE_TEXT + BLACK_BG + "|=========================================|");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|          Bank Mangement Menu            |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|=========================================|");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|    Please Make a Selection (1-4):       |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "| 1. Manage Customers                     |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "| 2. Manage Accounts                      |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "| 3. Manage Bank Branches                 |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "| 4. Exit                                 |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|=========================================|");
			System.out.println("" + RESET);
			
			// Loop until a valid choice is entered
			// the loop will handle if the user was to enter anything other than a integer such as b/, so that it does not break the program and cause you to start over
			boolean validChoice = false;
									
			while (!validChoice) {
				String userInput = scanner.nextLine();
				if (userInput.matches("[1-4]")) {
					userChoice = Integer.parseInt(userInput);
					validChoice = true;
				} 
				else {
					System.out.println("Invalid Input. Please enter a number between 1 and 4.");
				}
			}
			
			switch (userChoice) {
        		case 1:
        			manageCustomers();
        			break;
        		case 2: 
        			manageAccounts();
        			break; 
        		case 3: 
        			manageBankBranches();
        			pressAnyKey();
        			break;
        		case 4:
        			System.out.println("Exiting Quantum Realms Bank Management System. Goodbye!");
        			System.exit(0);  // Exit the program
        			break;
        		default:
        			System.out.println("Invalid choice. Please select a valid option.");
        			break;
			}
        }
	}
	
	/**
     * Description: This method manages the customer operations.
     * 				It displays a menu and allows the user to select a response by entering a corresponding integer.
     * 				The switch statement then navigates the user to additional methods and functionality.
     * 				This method does not take in any parameters.
     * 				and does not have a return 
     */
	public void manageCustomers() {
		
		boolean finished = false;
		int userChoice = 0;
		
		Scanner scanner = new Scanner(System.in); 
		
        while (finished == false) {
        	
        	// Display a menu for the user to select from 
        	System.out.println(PURPLE_TEXT + BLACK_BG + "|=========================================|");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|      Bank Customer Mangement Menu       |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|=========================================|");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|    Please Make a Selection (1-4):       |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "| 1. Create New Customer                  |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "| 2. Display All Customers                |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "| 3. Search For Customer                  |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "| 4. Return to Main Menu                  |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|=========================================|");
			System.out.println("" + RESET);
			
			// Loop until a valid choice is entered
			// the loop will handle if the user was to enter anything other than a integer such as b/, so that it does not break the program and cause you to start over
			boolean validChoice = false;
									
			while (!validChoice) {
				String userInput = scanner.nextLine();
				if (userInput.matches("[1-4]")) {
					userChoice = Integer.parseInt(userInput);
					validChoice = true;
				} 
				else {
					System.out.println("Invalid Input. Please enter a number between 1 and 4.");
				}
			}
			
			switch (userChoice) {
        		case 1:
        			createNewCustomer();
        			break;
        		case 2: 
        			displayCustomers();
        			pressAnyKey();
        			break; 
        		case 3: 
        			customerToSearchBy();
        			pressAnyKey();
        			break;
        		case 4:
        			pressAnyKey();
        			mainMenu();
        			break;
        		default:
        			System.out.println("Invalid choice. Please select a valid option.");
        			break;
			}
        }
	}
	
	/**
	 * Description: This method creates a new customer.
	 * 				It displays a menu and allows the user to select a response by entering a corresponding integer.
     * 				The switch statement then navigates the user to additional methods and functionality.
     * 				This method does not take in any parameters.			 
	 */
	public void createNewCustomer() {
		
		boolean finished = false;
		int userChoice = 0;
		
		Scanner scanner = new Scanner(System.in); 
		
        while (finished == false) {
        	
        	// Display a menu for the user to select from 
        	System.out.println("");
        	System.out.println(YELLOW_TEXT + BLACK_BG + "|=========================================|");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|                                         |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|      Customer Creation Menu             |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|                                         |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|=========================================|");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|                                         |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|  Do you need to create a Personal       |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|  or a Commercial Customer               |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|                                         |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "| 1. Create Personal Customer             |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "| 2. Create Commercial Customer           |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "| 3. Return to Customer Main Menu         |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|                                         |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|=========================================|");
			System.out.println("" + RESET);
			
			// Loop until a valid choice is entered
			// the loop will handle if the user was to enter anything other than a integer such as b/, so that it does not break the program and cause you to start over
			boolean validChoice = false;
									
			while (!validChoice) {
				String userInput = scanner.nextLine();
				if (userInput.matches("[1-3]")) {
					userChoice = Integer.parseInt(userInput);
					validChoice = true;
				} 
				else {
					System.out.println("Invalid Input. Please enter a number between 1 and 3.");
				}
			}
			
			switch (userChoice) {
        		case 1:
        			createPersonalCustomer();
        			pressAnyKey();
        			manageCustomers();
        			break;
        		case 2: 
        			createCommercialCustomer();
        			pressAnyKey();
        			manageCustomers();
        			break; 
        		case 3: 
        			pressAnyKey();
        			manageCustomers();
        			break;
        		default:
        			System.out.println("Invalid choice. Please select a valid option.");
        			break;
			}
        }
	}
	
	/**
	 * Description: This method creates a new personal customer.
	 * 				It prompts the user for personal customer details and creates a new PersonalCustomer object.
	 * 				This method does not take in any parameters.
	 * 
	 * @return the created PersonalCustomer object
	 */
	public PersonalCustomer createPersonalCustomer() {
		Scanner sc = new Scanner(System.in); 
		
		// Prompt for customer name
		System.out.println("");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|=========================================|");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                         |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Enter the name of the customer: |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                         |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|=========================================|");
		System.out.println("" + RESET);
		String name = sc.nextLine();
		
		// Prompt for customer address
		System.out.println("");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|===============================================|");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                               |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Enter the address for the customer:   |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                               |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|===============================================|");
		System.out.println("" + RESET);
		String address = sc.nextLine();
		
		// Prompt for customer phone number
		System.out.println("");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Enter the primary phone number for the customer:   |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("" + RESET);
		String phone = sc.nextLine();
		
		// Prompt for customer home phone number
		System.out.println("");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Enter the home phone number for the customer:      |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("" + RESET);
		String homePhone = sc.nextLine();
		
		// Prompt for customer work phone number
		System.out.println("");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Enter the work phone number for the customer:      |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("" + RESET);
		String workPhone = sc.nextLine();
		
		// Create a new PersonalCustomer object
		PersonalCustomer customer = new PersonalCustomer(name, address, phone, homePhone, workPhone);
		
		// Prompt to create an account for the customer
		needAccountForCustomer(customer);
	    customers.add(customer); // Add the new customer to the ArrayList
	    
	    // Confirmation message
	    System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|               Customer Created successfully                |");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("" + RESET);
		
		// Display customer information
		System.out.println(customer);
	    
		return customer;
	}
	
	/**
	 * Description: This method creates a new commercial customer.
	 * 				It prompts the user for commercial customer details and creates a new CommercialCustomer object.
	 * 				This method does not take in any parameters.
	 * 
	 * @return the created CommercialCustomer object
	 */
	public CommercialCustomer createCommercialCustomer() {
		Scanner sc = new Scanner(System.in); 
		
		// Prompt for customer name
		System.out.println(YELLOW_TEXT + BLACK_BG + "|=========================================|");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                         |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Enter the name of the customer: |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                         |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|=========================================|");
		System.out.println("" + RESET);
		String name = sc.nextLine();
		
		// Prompt for customer address
		System.out.println(YELLOW_TEXT + BLACK_BG + "|===============================================|");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                               |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Enter the address for the customer:   |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                               |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|===============================================|");
		System.out.println("" + RESET);
		String address = sc.nextLine();
		
		// Prompt for customer phone number
		System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Enter the primary phone number for the customer:   |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("" + RESET);
		String phone = sc.nextLine();
		
		// Prompt for customer credit rating
		// The prompt will be sent over to the InputValidator class's method to ensure the user enters a valid integer and not other characters
		// This will help prevent the exception error from occurring causing the program to end abruptly...
		String prompt = YELLOW_TEXT + BLACK_BG + "|============================================================|\n" +
                "|                                                            |\n" +
                "|  Please Enter the Credit Rating for the customer:          |\n" +
                "|                                                            |\n" +
                "|============================================================|\n" +
                "" + RESET;
	    int creditRating = InputValidator.getValidatedInteger(sc, prompt); // calling the method to make sure integers were entered and not characters
	    sc.nextLine(); // Consume the newline character 
		
	    // Prompt for contact person name
		System.out.println(YELLOW_TEXT + BLACK_BG + "|===============================================================|");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                               |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Enter the Contact Person for the Commercial Customer  |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                               |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|===============================================================|");
		System.out.println("" + RESET);
		String contactPerson = sc.nextLine();
		
		// Prompt for contact person phone number
		System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Enter the Contact Person's Phone                   |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|  for the Commercial Customer                               |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("" + RESET);
		String contactPersoPhone = sc.nextLine();
		
		// Create a new CommercialCustomer object
		CommercialCustomer customer = new CommercialCustomer(name, address, phone, creditRating, contactPerson, contactPersoPhone);
		
		// Prompt to create an account for the customer
		needAccountForCustomer(customer);
		customers.add(customer); // Add the new customer to the ArrayList
		
		// Confirmation message
		System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|               Customer Created successfully                |");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("" + RESET);
		
		// Display customer information
		System.out.println(customer);
		
		return customer;
	}
	
	/**
	 * Description: This method prompts the user to create an account for a customer that was just created or to not create one at this time.
	 * 				the customer object that was created in another method 
	 * 				(createPersonalCustomer() or createCommercialCustomer()) is passes into this method from those methods.
	 * 				It displays a menu and allows the user to select a response by entering a corresponding integer.
	 * 				The switch statement then navigates the user to additional methods and functionality passing the customer object on to the next method.
	 * 
	 * @param customer the customer for whom the account needs to be created
	 */
	public void needAccountForCustomer(Customer customer) {
		
		boolean finished = false;
		int userChoice = 0;
		
		Scanner scanner = new Scanner(System.in); 
		
        while (finished == false) {
        	
        	// Display a menu for the user to select from 
        	System.out.println(YELLOW_TEXT + BLACK_BG + "|=========================================|");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|                                         |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|      Customer Creation Menu             |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|                                         |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|=========================================|");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|                                         |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|  Do you need to create a bank account   |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|  for the Customer?                      |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|                                         |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "| 1. Create Account for Customer          |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "| 2. Skip Account Creation                |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|                                         |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|=========================================|");
			System.out.println("" + RESET);
			
			// Loop until a valid choice is entered
			// the loop will handle if the user was to enter anything other than a integer such as b/, so that it does not break the program and cause you to start over
			boolean validChoice = false;
									
			while (!validChoice) {
				String userInput = scanner.nextLine();
				if (userInput.matches("[1-2]")) {
					userChoice = Integer.parseInt(userInput);
					validChoice = true;
				} 
				else {
					System.out.println("Invalid Input. Please enter a number between 1 and 3.");
				}
			}
			
			switch (userChoice) {
        		case 1:
        			createNewAccount(customer);
        			finished = true; // Ensure it returns after creating the account
                    break;
        		case 2: 
        			finished = true; // Exit the loop goes back to either createPersonalCustomer() or createCommercialCustomer() and finishes the customer creation with no accounts
                    break;
        		default:
        			System.out.println("Invalid choice. Please select a valid option.");
        			break;
			}
        }
	}
	
	/**
	 * Description: This method allows the user to decide what kind of new account to create for a customer.
	 * 				It displays a menu and allows the user to select a response by entering a corresponding integer.
	 * 				The switch statement then navigates the user to additional methods to create the chosen account. 
	 * 				It will then pass the customer object that was passed into this method on to the next method. 
	 * 				This method takes in a Customer object as a parameter.
	 * 
	 * @param customer the customer for whom the account needs to be created
	 */
	public void createNewAccount(Customer customer) {
		
		boolean finished = false;
		int userChoice = 0;
		
		Scanner scanner = new Scanner(System.in); 
		
		while (finished == false) {
			
			// Display a menu for the user to select from 
			System.out.println("");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|=========================================|");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|                                         |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|      Account Creation Menu              |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|                                         |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|=========================================|");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|                                         |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|  Do you need to create a Checking       |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|  or a Savings Account?                  |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|                                         |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "| 1. Create Checking Account              |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "| 2. Create Savings Account               |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|                                         |");
			System.out.println(YELLOW_TEXT + BLACK_BG + "|=========================================|");
			System.out.println("" + RESET);
			
			// Loop until a valid choice is entered
			// the loop will handle if the user was to enter anything other than a integer such as b/, so that it does not break the program and cause you to start over
			boolean validChoice = false;
			
			while (!validChoice) {
				String userInput = scanner.nextLine();
				if (userInput.matches("[1-3]")) {
					userChoice = Integer.parseInt(userInput);
					validChoice = true;
				} 
				else {
					System.out.println("Invalid Input. Please enter a number between 1 and 3.");
				}
			}
			
			switch (userChoice) {
			case 1:
				createCheckingAccount(customer); //passes the customer object created in createPersonalCustomer() or createCommercialCustomer() 
				finished = true; // Ensure it returns after creating the account
                break;
			case 2: 
				createSavingsAccount(customer); //passes the customer object created in createPersonalCustomer() or createCommercialCustomer()
				finished = true; // Ensure it returns after creating the account
				break; 
			case 3: 
				pressAnyKey();
				manageCustomers();
				break;
			default:
				System.out.println("Invalid choice. Please select a valid option.");
				break;
			}
		}
	}
	
	/**
	 * Description: This method creates a new checking account for a customer.
	 *				It prompts the user for account details and creates a new CheckingAccount object. It will then pass back a CheckingAccount object that will be added to a customer 
	 *				through a series of returns back to either the createPersonalCustomer() or createCommercialCustomer() method depending on which 
	 *				method ultimately called this method. 
	 * 				This method takes in a Customer object as a parameter that has been passed down from createPersonalCustomer() or createCommercialCustomer().
	 * 
	 * @param customer the customer for whom the checking account needs to be created
	 * @return the created CheckingAccount object
	 */
	public CheckingAccount createCheckingAccount(Customer customer) {
		Scanner sc = new Scanner(System.in);
		
		// Create a new CheckingAccount object to access minimum balance requirements
		CheckingAccount newCheckingAccount = new CheckingAccount();
		double inputedBalance = 0.0;
		
		System.out.println("");
		
		/*
		 *  This while loop will ensure that the initial balance for the checking account is greater than or equal to the minimum balance
		 *  that is required for a checking account. 
		 */
		while (inputedBalance < newCheckingAccount.getMinimumBalance()) {
			
			// Prompt for user to enter the initial balance of the account
			// The prompt will be sent over to the InputValidator class's method to ensure the user enters a valid double and not other characters
			// This will help prevent the exception error from occurring causing the program to end abruptly...
			String prompt = YELLOW_TEXT + BLACK_BG + "|====================================================|\n" +
	                "|                                                    |\n" +
	                "|  Please Enter the initial balance of the account   |\n" +
	                "|                                                    |\n" +
	                "|====================================================|\n" +
	                "" + RESET;
			inputedBalance = InputValidator.getValidatedDouble(sc, prompt); //calling the method in the InputValidator class to make sure a double value was entered and not characters
			
			//This check will see if the value that the user entered is less than the minimumBalance....
			// If so it displays an error message letting then user know and then goes back through the while loop to allow the user to enter a value...
			if (inputedBalance < newCheckingAccount.getMinimumBalance()) {
		    	System.out.println(RED_TEXT + BLACK_BG + "|====================================================|");
			    System.out.println(RED_TEXT + BLACK_BG + "|                                                    |");
			    System.out.println(RED_TEXT + BLACK_BG + "|  A Checking Account requires a minimum balance     |");
			    System.out.println(formatLine(RED_TEXT + BLACK_BG + "|           of:   $" + newCheckingAccount.getMinimumBalance() + " "));
			    System.out.println(RED_TEXT + BLACK_BG + "|                                                    |");
			    System.out.println(RED_TEXT + BLACK_BG + "|====================================================|");
			    System.out.println("" + RESET);
			    
			    pressAnyKey();
		    }
		}
	    double balance = inputedBalance; // sets the value the user entered that has been checked for a double value equal to the balance that will be passed through
	    								//  for the creation of the CheckingAccount object.... 
	    sc.nextLine(); // Consume the newline character

	    Date date = new Date(); // sets the date the account was opened to the current date and time of the users system.....
	    
	    // prompts the user to enter what branch this bank account belongs to.... 
	    System.out.println("");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Select the bank branch this account        |");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|  belongs to:                                       |");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|====================================================|");
	    
	    /*
	     *  Loop through the list of bank branches and display their names with an option number for selection
	     *  It takes the current size of the ArrayList for bankBranches and current elements to do this.. .
	     */
	    for (int i = 0; i < bankBranches.size(); i++) {
	    	
	    	// Print the branch name with an option number (starting from 1) for the user to select
	        // The formatLine method is used to format the output to fit within a specified width
	    	System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                    |");
	        System.out.println(formatLine(YELLOW_TEXT + BLACK_BG + "| " + (i + 1) + ". " + bankBranches.get(i).getBranchName() + " "));
	        System.out.println(formatLine(YELLOW_TEXT + BLACK_BG + "|"));
	        System.out.println(YELLOW_TEXT + BLACK_BG + "|====================================================|");
	    }
	    
	    // Prompt the user to enter a number corresponding to their branch choice
	    // The number entered should be between 1 and the size of the bankBranches list
	    int branchChoice = sc.nextInt();
	    sc.nextLine(); // Consume the newline character left over by nextInt() to avoid input issues
	    
	    /*
	     *  Retrieve the selected branch from the bankBranches list using the user's choice
	     *   Subtract 1 from branchChoice because the list index is zero-based while the displayed options are one-based
	     */
	    BankBranch selectedBranch = bankBranches.get(branchChoice - 1);
	    
	    System.out.println("");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Select the check style for the account:    |");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                    |");
	    
	    // Loop through each check style available in the CheckStyle enum
	    for (CheckStyle style : CheckStyle.values()) {
	    	
	    	// Print each check style option with a number for selection
	        // The formatLine method is used to format the output to fit within a specified width
	        System.out.println(formatLine(YELLOW_TEXT + BLACK_BG + "|  " + (style.ordinal() + 1) + ". " + style + " "));
	        System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                    |");
	    }
	    
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|====================================================|");
	    
	    // Prompt the user to enter a number corresponding to their check style choice
	    int checkStyleChoice = sc.nextInt();
	    sc.nextLine(); // Consume the newline character left over by nextInt() to avoid input issues
	    
	    // Retrieve the selected check style from the CheckStyle enum using the user's choice
	    // Subtract 1 from checkStyleChoice because the enum ordinal values are zero-based 
	    CheckStyle selectedCheckStyle = CheckStyle.values()[checkStyleChoice - 1];
	    
	    // Create a new CheckingAccount object with the provided balance, date, customer, selected branch, and selected check style
	    CheckingAccount newAccount = new CheckingAccount(balance, date, customer, selectedBranch, selectedCheckStyle);

	    // Add the new account to the selected branch
	    selectedBranch.addAccount(newAccount);
	    
	    // Add the new account to the customer's list of accounts
	    customer.addAccount(newAccount);
	    
	    // Add the new account to the bank's list of accounts
	    bankAccounts.add(newAccount);
	    
	    // Print a success message indicating that the account was created successfully
	    System.out.println("");
	    System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|               Account Created successfully                 |");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("");
		System.out.println("");
		
		pressAnyKey();
		
		System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|          Here is the information for the new account       |");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("");
		
		pressAnyKey();
		
		// Print the details of the newly created account
	    System.out.println(newAccount);
	    
	    pressAnyKey();

	    // Return the newly created account object
	    return newAccount;
	}
	
	/**
	 * Description: This method creates a new SavingsAccount for a given customer.
	 * 				It prompts the user for the initial balance, selects the bank branch, and sets the interest rate.
	 * 				The method adds the new account to the customer, the selected branch, and the bank's list of accounts.
	 * 				It will then pass back a SavingsAccount object that will be added to a customer 
	 *				through a series of returns back to either the createPersonalCustomer() or createCommercialCustomer() method depending on which 
	 *				method ultimately called this method. 
	 * 				This method takes in a Customer object as a parameter that has been passed down from createPersonalCustomer() or createCommercial
	 * 
	 * @param customer The customer for whom the savings account is being created.
	 * @return The newly created SavingsAccount object.
	 */
	public SavingsAccount createSavingsAccount(Customer customer) {
		Scanner sc = new Scanner(System.in);
		
		// Prompt for user to enter the initial balance of the account
		// The prompt will be sent over to the InputValidator class's method to ensure the user enters a valid double and not other characters
		// This will help prevent the exception error from occurring causing the program to end abruptly...
		String prompt = YELLOW_TEXT + BLACK_BG + "|====================================================|\n" +
                "|                                                    |\n" +
                "|  Please Enter the initail balance of the account   |\n" +
                "|                                                    |\n" +
                "|====================================================|\n" +
                "" + RESET;
	    double balance = InputValidator.getValidatedDouble(sc, prompt); //calling the method in the InputValidator class to make sure a double value was entered and not characters
	    sc.nextLine(); // Consume the newline character
	    
	    // Get the current date to set as the account creation date
		Date date = new Date();
		
		// Display the prompt to select the bank branch for the new account
		System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|  Please Select the bank branch this account        |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|  belongs to:                                       |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    
	    /*
	     *  Loop through the list of bank branches and display their names with an option number for selection
	     *  It takes the current size of the ArrayList for bankBranches and current elements to do this.. .
	     */
	    for (int i = 0; i < bankBranches.size(); i++) {
	    	
	    	// Print the branch name with an option number (starting from 1) for the user to select
	        // The formatLine method is used to format the output to fit within a specified width
	    	System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	        System.out.println(formatLine(BLUE_TEXT + BLACK_BG + "| " + (i + 1) + ". " + bankBranches.get(i).getBranchName() + " "));
	        System.out.println(formatLine(BLUE_TEXT + BLACK_BG + "|"));
	        System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    }
	    
	    // Read the user's choice of branch and select the corresponding branch object
	    int branchChoice = sc.nextInt();
	    sc.nextLine(); // Consume the newline character
	    BankBranch selectedBranch = bankBranches.get(branchChoice - 1);
		
	    // Prompt the user to enter the interest rate for the savings account
	    // The prompt will be sent over to the InputValidator class's method to ensure the user enters a valid double and not other characters
		// This will help prevent the exception error from occurring causing the program to end abruptly...
		String prompt2 = YELLOW_TEXT + BLACK_BG + "|====================================================|\n" +
                "|                                                    |\n" +
                "|  Please Enter the interest rate for the account    |\n" +
                "|                                                    |\n" +
                "|====================================================|\n" +
                "" + RESET;
	    double interestRate = InputValidator.getValidatedDouble(sc, prompt2); //calling the method in the InputValidator class to make sure a double value 
	    sc.nextLine(); // Consume the newline character
		
	    // Create a new SavingsAccount object with the provided details
		SavingsAccount newAccount = new SavingsAccount(balance, date, customer, selectedBranch, interestRate);
		
		// Add the new account to the selected branch, customer, and bank's list of accounts
		selectedBranch.addAccount(newAccount);
		customer.addAccount(newAccount);
		bankAccounts.add(newAccount);
		
		System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|               Account Created successfully                 |");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("");
		
		pressAnyKey();
		
		System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|          Here is the information for the new account       |");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("");
		
		pressAnyKey();
		
		// Print the details of the new account
	    System.out.println(newAccount);
	    
	    pressAnyKey();
		
		return newAccount;
	}
	
	/**
	 * Description: This method prompts the user to enter a customer name to search for.
	 * 				It reads the user's input and calls the searchForCustomer method with the entered name.
	 * 				The method will then pass the name enter on to the method that will search for the customer 
	 * 				with the entered name.
	 * This method does not take any parameters.
	 * This method has no return type.
	 */
	public void customerToSearchBy() {
		Scanner sc = new Scanner(System.in);
		
		// Display prompt for user to enter the customer name
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|  Please Enter the Customer Name to Search By       |");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println("" + RESET);
	    
	    // Read the user's input for the customer name
	    String name = sc.nextLine();
	    
	    // Call the searchForCustomer method with the entered name
	    searchForCustomer(name);
	    
	}
	
	/**
	 * Description: This method searches for a customer by name in the ArrayList customers.
	 * 				If a customer with the specified name is found, their information is displayed.
	 * 				If no customer is found, an appropriate message is displayed.
	 * 
	 * @param name The name of the customer to search for.
	 */
	public void searchForCustomer(String name) {
		
		// Iterate through the ArrayList of customers to find a match
		for (Customer customer : customers) {
			if (customer.getName().equalsIgnoreCase(name)) { //searches for names while ignore capitalization 
				// If a match is found, display a message indicating the customer was found
				System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
			    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|                                                    |");
			    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|                  Customer was Found                |");
			    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|                                                    |");
			    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
			    System.out.println("" + RESET);
			    System.out.println("");
			    
			    // Display the found customer's information
			    System.out.println(customer);
			    return; //returns the user to the customer management menu manageCustomer()
			}
		}
		
		// If no match is found, display a message indicating the customer was not found
		System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|              Customer was not Found                |");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println("" + RESET);
	}
	
	/**
	 * Description: This method displays the Bank Account Management Menu and allows the user to choose various account-related actions.
	 * 				The user can create a new account, display all accounts, search for an account, make a deposit or withdrawal, calculate interest for savings, or return to the main menu.
	 * 
	 * There are no parameters for this method
	 * There is no return type for this method
	 */
	public void manageAccounts() {
		
		// Initialize a boolean to keep the menu displayed until the user chooses to return to the main menu
		boolean finished = false;
		int userChoice = 0;
		
		Scanner scanner = new Scanner(System.in); 
		
		// Continue displaying the menu until finished is true
        while (finished == false) {
        	
        	// Display a menu for the user to select from 
        	System.out.println(BLUE_TEXT + BLACK_BG + "|=========================================|");
			System.out.println(BLUE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|       Bank Account Mangement Menu       |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|=========================================|");
			System.out.println(BLUE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|    Please Make a Selection (1-7):       |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "| 1. Create New Account                   |");
			System.out.println(BLUE_TEXT + BLACK_BG + "| 2. Display All Accounts                 |");
			System.out.println(BLUE_TEXT + BLACK_BG + "| 3. Search For Account                   |");
			System.out.println(BLUE_TEXT + BLACK_BG + "| 4. Make A Deposit or Withdrawal         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "| 5. Calculate Interest For Savings       |");
			System.out.println(BLUE_TEXT + BLACK_BG + "| 6. Return to Main Menu                  |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|=========================================|");
			System.out.println("" + RESET);
			
			// Loop until a valid choice is entered
			// the loop will handle if the user was to enter anything other than a integer such as b/, so that it does not break the program and cause you to start over
			boolean validChoice = false;
									
			while (!validChoice) {
				String userInput = scanner.nextLine();
				if (userInput.matches("[1-6]")) {
					userChoice = Integer.parseInt(userInput);
					validChoice = true;
				} 
				else {
					System.out.println("Invalid Input. Please enter a number between 1 and 6.");
				}
			}
			
			switch (userChoice) {
        		case 1:
        			needCustomerForAccount();
        			break;
        		case 2: 
        			displayAccounts();
        			pressAnyKey();
        			break; 
        		case 3: 
        			searchForAccount();
        			pressAnyKey();
        			break;
        		case 4:
        			searchForAccountForDep();
        			pressAnyKey();
        			break;
        		case 5:
        			manageInterestCalculation();
        			mainMenu();
        			break;
        		case 6:
        			pressAnyKey();
        			mainMenu();
        			break;
        		default:
        			System.out.println("Invalid choice. Please select a valid option.");
        			break;
			}
        }
	}
	
	/**
	 * Description: This method prompts the user to create a customer for a new account if necessary.
	 * 				It displays options for creating a new customer or using an existing customer.
	 * 
	 * No parameters
	 * No Returns
	 */
	public void needCustomerForAccount() {
		
		boolean finished = false;
		int userChoice = 0;
		
		Scanner scanner = new Scanner(System.in); 
		
        while (finished == false) {
        	
        	// Display a menu for the user to select from 
        	System.out.println(BLUE_TEXT + BLACK_BG + "|=========================================|");
			System.out.println(BLUE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|      Account Creation Menu              |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|=========================================|");
			System.out.println(BLUE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|  Do you need to create a Customer to    |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|  go with the account?                   |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "| 1. Create Customer for Account          |");
			System.out.println(BLUE_TEXT + BLACK_BG + "| 2. Customer Already Exists              |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|=========================================|");
			System.out.println("" + RESET);
			
			// Loop until a valid choice is entered
			// the loop will handle if the user was to enter anything other than a integer such as b/, so that it does not break the program and cause you to start over
			boolean validChoice = false;
									
			while (!validChoice) {
				String userInput = scanner.nextLine();
				if (userInput.matches("[1-2]")) {
					userChoice = Integer.parseInt(userInput);
					validChoice = true;
				} 
				else {
					System.out.println("Invalid Input. Please enter a number between 1 and 3.");
				}
			}
			
			switch (userChoice) {
        		case 1:
        			createNewCustomer();
                    break;
        		case 2: 
        			createNewAccount(); // Exit the loop
                    break;
        		default:
        			System.out.println("Invalid choice. Please select a valid option.");
        			break;
			}
        }
	}
	
	/**
	 * Description: This method prompts the user to create a new account.
	 * 				It displays options for creating a checking account or a savings account.
	 * 
	 * No Parameters
	 * No Returns 
	 */
	public void createNewAccount() {
		
		boolean finished = false;
		int userChoice = 0;
		
		Scanner scanner = new Scanner(System.in); 
		
		while (finished == false) {
			
			// Display a menu for the user to select from 
			System.out.println(BLUE_TEXT + BLACK_BG + "|=========================================|");
			System.out.println(BLUE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|      Account Creation Menu              |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|=========================================|");
			System.out.println(BLUE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|  Do you need to create a Checking       |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|  or a Savings Account?                  |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "| 1. Create Checking Account              |");
			System.out.println(BLUE_TEXT + BLACK_BG + "| 2. Create Savings Account               |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|=========================================|");
			System.out.println("" + RESET);
			
			// Loop until a valid choice is entered
			// the loop will handle if the user was to enter anything other than a integer such as b/, so that it does not break the program and cause you to start over
			boolean validChoice = false;
			
			while (!validChoice) {
				String userInput = scanner.nextLine();
				if (userInput.matches("[1-3]")) {
					userChoice = Integer.parseInt(userInput);
					validChoice = true;
				} 
				else {
					System.out.println("Invalid Input. Please enter a number between 1 and 3.");
				}
			}
			
			switch (userChoice) {
			case 1:
				createCheckingAccount();
				manageAccounts(); 
                break;
			case 2: 
				createSavingsAccount();
				manageAccounts(); 
				break; 
			case 3: 
				pressAnyKey();
				manageCustomers();
				break;
			default:
				System.out.println("Invalid choice. Please select a valid option.");
				break;
			}
		}
	}
	
	/**
	 * Description: This method creates a new SavingsAccount. This method unlike the one above does not take in a parameter of a Customer object
	 * 				It prompts the user for the initial balance, bank branch, customer, and interest rate.
	 * 				The method adds the new account to the customer, the selected branch, and the bank's list of accounts.
	 * 				It will then display the account information for the newly created account....
	 * No Parameters
	 * @return The newly created SavingsAccount object.
	 */
	public SavingsAccount createSavingsAccount() {
		Scanner sc = new Scanner(System.in);
		
		// Prompt for user to enter the initial balance of the account
		// The prompt will be sent over to the InputValidator class's method to ensure the user enters a valid double and not other characters
		// This will help prevent the exception error from occurring causing the program to end abruptly...
		String prompt = BLUE_TEXT + BLACK_BG + "|====================================================|\n" +
                "|                                                    |\n" +
                "|  Please Enter the initail balance of the account   |\n" +
                "|                                                    |\n" +
                "|====================================================|\n" +
                "" + RESET;
	    double balance = InputValidator.getValidatedDouble(sc, prompt); //calling the method in the InputValidator class to make sure a double value 
	    sc.nextLine(); // Consume the newline character
		
	    // Get the current date to set as the account creation date
		Date date = new Date();
		
		System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|  Please Select the bank branch this account        |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|  belongs to:                                       |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    
	    /*
	     *  Loop through the list of bank branches and display their names with an option number for selection
	     *  It takes the current size of the ArrayList for bankBranches and current elements to do this.. .
	     */
	    for (int i = 0; i < bankBranches.size(); i++) {
	    	// Print the branch name with an option number (starting from 1) for the user to select
	        // The formatLine method is used to format the output to fit within a specified width
	    	System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	        System.out.println(formatLine(BLUE_TEXT + BLACK_BG + "| " + (i + 1) + ". " + bankBranches.get(i).getBranchName() + " "));
	        System.out.println(formatLine(BLUE_TEXT + BLACK_BG + "|"));
	        System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    }
	    
		// Read the user's choice of branch and select the corresponding branch object
	    int branchChoice = sc.nextInt();
	    sc.nextLine(); // Consume the newline character
	    
	    /*
	     *  Retrieve the selected branch from the bankBranches list using the user's choice
	     *   Subtract 1 from branchChoice because the list index is zero-based while the displayed options are one-based
	     */
	    BankBranch selectedBranch = bankBranches.get(branchChoice - 1);
	    
	    // Display the prompt to select the customer for the new account
	    System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|  Please Select the customer for this account:      |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    
	    /*
	     *  Loop through the ArrayList of customers and display their names with an option number for selection
	     *  It takes the current size of the ArrayList for customers and current elements to do this.. .
	     */
	    for (int i = 0; i < customers.size(); i++) {
	    	
	    	// Print the customer name with an option number (starting from 1) for the user to select
	        // The formatLine method is used to format the output to fit within a specified width
	    	System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	        System.out.println(formatLine(BLUE_TEXT + BLACK_BG + "| " + (i + 1) + ". " + customers.get(i).getName() + " "));
	        System.out.println(formatLine(BLUE_TEXT + BLACK_BG + "|"));
	        System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    }
	    
	    // Read the user's choice of customer and select the corresponding customer object
	    int customerChoice = sc.nextInt();
	    sc.nextLine(); // Consume the newline character
	    System.out.println("" + RESET);
	    
	    /*
	     *  Retrieve the selected customer from the customers ArrayList using the user's choice
	     *  Subtract 1 from customerChoices because the list index is zero-based while the displayed options are one-based
	     */
	    Customer selectedCustomer = customers.get(customerChoice - 1);
		
	    // Prompt the user to enter the interest rate for the savings account
	    // The prompt will be sent over to the InputValidator class's method to ensure the user enters a valid double and not other characters
		// This will help prevent the exception error from occurring causing the program to end abruptly...
	    String prompt2 = BLUE_TEXT + BLACK_BG + "|====================================================|\n" +
                "|                                                    |\n" +
                "|  Please Enter the interest rate for the account    |\n" +
                "|                                                    |\n" +
                "|====================================================|\n" +
                "" + RESET;
	    double interestRate = InputValidator.getValidatedDouble(sc, prompt2); //calling the method in the InputValidator class to make sure a double value
	    sc.nextLine(); // Consume the newline character
		
	    // Create a new SavingsAccount object with the provided details
		SavingsAccount newAccount = new SavingsAccount(balance, date, selectedCustomer, selectedBranch, interestRate);
		
		// Add the new account to the selected branch, customer, and bank's list of accounts
		selectedBranch.addAccount(newAccount);
		selectedCustomer.addAccount(newAccount);
		bankAccounts.add(newAccount);
		
		System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|               Account Created successfully                 |");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		pressAnyKey();
		
		System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|          Here is the information for the new account       |");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("");
		
		pressAnyKey();
		
		// Print the details of the new account
		System.out.println(newAccount);
		
		pressAnyKey();
		
		// Return the newly created SavingsAccount object
		return newAccount;
	}
	
	/**
	 * Description: This method creates a new CheckingAccount. This method unlike the one above does not take in a parameter of a Customer object.
	 * 				It prompts the user for the initial balance, bank branch, customer, and check style.
	 * 				The method adds the new account to the customer, the selected branch, and the bank's list of accounts.
	 * 				It will then display the account information for the newly created account....
	 * 
	 * No Parameters
	 * @return The newly created CheckingAccount object.
	 */
	public CheckingAccount createCheckingAccount() {
		Scanner sc = new Scanner(System.in);
		
		// Create a new CheckingAccount object to access minimum balance requirements
		CheckingAccount newCheckingAccount = new CheckingAccount();
		double inputedBalance = 0.0;
		
		System.out.println("");
		
		// Loop until the user inputs a valid initial balance that meets the minimum balance requirement
		while (inputedBalance < newCheckingAccount.getMinimumBalance()) {
			
			// Prompt for user to enter the initial balance of the account
			// The prompt will be sent over to the InputValidator class's method to ensure the user enters a valid double and not other characters
			// This will help prevent the exception error from occurring causing the program to end abruptly...
			String prompt = BLUE_TEXT + BLACK_BG + "|====================================================|\n" +
	                "|                                                    |\n" +
	                "|  Please Enter the initial balance of the account   |\n" +
	                "|                                                    |\n" +
	                "|====================================================|\n" +
	                "" + RESET;
			inputedBalance = InputValidator.getValidatedDouble(sc, prompt); //calling the method in the InputValidator class to make sure a double value was entered
			
			// Check if the entered balance is below the minimum required balance
			if (inputedBalance < newCheckingAccount.getMinimumBalance()) {
				System.out.println("");
		    	System.out.println(RED_TEXT + BLACK_BG + "|====================================================|");
			    System.out.println(RED_TEXT + BLACK_BG + "|                                                    |");
			    System.out.println(RED_TEXT + BLACK_BG + "|  A Checking Account requires a minimum balance     |");
			    System.out.println(formatLine(RED_TEXT + BLACK_BG + "|           of:   $" + newCheckingAccount.getMinimumBalance() + " "));
			    System.out.println(RED_TEXT + BLACK_BG + "|                                                    |");
			    System.out.println(RED_TEXT + BLACK_BG + "|====================================================|");
			    System.out.println("" + RESET);
			    
			    pressAnyKey();
		    }
		}
	    double balance = inputedBalance;
	    sc.nextLine(); // Consume the newline character
	    
	    // Get the current date to set as the account creation date
	    Date date = new Date();
	    
	    System.out.println("");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|  Please Select the bank branch this account        |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|  belongs to:                                       |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    
	    // Iterate over the list of bank branches and display each one with an index
	    for (int i = 0; i < bankBranches.size(); i++) {
	    	System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	        System.out.println(formatLine(BLUE_TEXT + BLACK_BG + "| " + (i + 1) + ". " + bankBranches.get(i).getBranchName() + " "));
	        System.out.println(formatLine(BLUE_TEXT + BLACK_BG + "|"));
	        System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    }
	    
	    System.out.println("");
	    
	    // Read the user's choice of branch and select the corresponding branch object
	    int branchChoice = sc.nextInt();
	    sc.nextLine(); // Consume the newline character
	    BankBranch selectedBranch = bankBranches.get(branchChoice - 1);
	    
	    System.out.println("");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|  Please Select the customer for this account:      |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    
	    // Iterate over the list of customers and display each one with an index
	    for (int i = 0; i < customers.size(); i++) {
	    	System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	        System.out.println(formatLine(BLUE_TEXT + BLACK_BG + "| " + (i + 1) + ". " + customers.get(i).getName() + " "));
	        System.out.println(formatLine(BLUE_TEXT + BLACK_BG + "|"));
	        System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    }
	    
	    System.out.println("");
	    
	    // Read the user's choice of customer and select the corresponding customer object
	    int customerChoice = sc.nextInt();
	    sc.nextLine(); // Consume the newline character
	    Customer selectedCustomer = customers.get(customerChoice - 1);
	    
	    System.out.println("");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|  Please Enter the check style for the account:     |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    
	    // Iterate over the list of check styles and display each one with an index
	    for (CheckStyle style : CheckStyle.values()) {
	        System.out.println(formatLine(BLUE_TEXT + BLACK_BG + "|  " + (style.ordinal() + 1) + ". " + style + " "));
	        System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    }
	    
	    System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    
	    // Read the user's choice of check style and select the corresponding check style object
	    int checkStyleChoice = sc.nextInt();
	    sc.nextLine(); // Consume the newline character
	    CheckStyle selectedCheckStyle = CheckStyle.values()[checkStyleChoice - 1];
	    
	    // Create a new CheckingAccount object with the provided details
	    CheckingAccount newAccount = new CheckingAccount(balance, date, selectedCustomer, selectedBranch, selectedCheckStyle);
	    
		// Add the new account to the selected branch, customer, and bank's list of accounts
	    selectedBranch.addAccount(newAccount);
	    selectedCustomer.addAccount(newAccount);
	    bankAccounts.add(newAccount);
	    
		// Print success message indicating the account was created
	    System.out.println("");
	    System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|               Account Created successfully                 |");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("");
		System.out.println("");
		
		pressAnyKey();
		
		// Print message indicating account information will be displayed
		System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|          Here is the information for the new account       |");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("");
		
		pressAnyKey();
		
		// Print the details of the new account
	    System.out.println(newAccount);
	    
	    pressAnyKey();
	    
	    // Return the newly created CheckingAccount object
	    return newAccount;
	}
	
	/**
	 * Description: This method displays a menu for searching for an account.
	 * 				The user can search by account number or customer name.
	 * 				After performing a search, the method returns to the main account management menu.
	 * 
	 * No parameters
	 * No returns
	 */
	public void searchForAccount() {
		boolean finished = false;
		int userChoice = 0;
		
		Scanner scanner = new Scanner(System.in); 
		
		// Continue displaying the menu until finished is true
		while (finished == false) {
			
			// Display a menu for the user to select from 
			System.out.println(BLUE_TEXT + BLACK_BG + "|=========================================|");
			System.out.println(BLUE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|          Account Search Menu            |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|=========================================|");
			System.out.println(BLUE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|  Do you want to search by customer      |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|  name or account number?                |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "| 1. Search by Account Number             |");
			System.out.println(BLUE_TEXT + BLACK_BG + "| 2. Search by Customer Name              |");
			System.out.println(BLUE_TEXT + BLACK_BG + "| 3. Return to Account Main Menu          |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|=========================================|");
			System.out.println("" + RESET);
			
			// Loop until a valid choice is entered
			// the loop will handle if the user was to enter anything other than a integer such as b/, so that it does not break the program and cause you to start over
			boolean validChoice = false;
			
			while (!validChoice) {
				String userInput = scanner.nextLine();
				if (userInput.matches("[1-3]")) {
					userChoice = Integer.parseInt(userInput);
					validChoice = true;
				} 
				else {
					System.out.println("Invalid Input. Please enter a number between 1 and 3.");
				}
			}
			
			// Perform the action based on the user's choice
			switch (userChoice) {
			case 1:
				accNumberToSearchAccountBy();
				pressAnyKey();
				manageAccounts(); 
                break;
			case 2: 
				customerToSearchAccountBy();
				pressAnyKey();
				manageAccounts(); 
				break; 
			case 3: 
				pressAnyKey();
				manageAccounts();
				break;
			default:
				System.out.println("Invalid choice. Please select a valid option.");
				break;
			}
		}
	}
	
	/**
	 * Description: This method prompts the user to enter a customer name to search by.	
	 * 				It calls the method to search for accounts by the customer name.
	 * 
	 * No Parameters 
	 * No Returns
	 */
	public void customerToSearchAccountBy() {
		Scanner sc = new Scanner(System.in);

	    System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(PURPLE_TEXT + BLACK_BG + "|  Please Enter the Customer Name to Search By       |");
	    System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println("" + RESET);
	    
	    // Read the user input and search for accounts by the customer name
	    String name = sc.nextLine();
	    searchForAccountByCustomer(name);
	    
	}
	
	/**
	 * Description: This method prompts the user to enter an account number to search by. 
	 * 				It calls the method to search for accounts by the account number.
	 * 
	 * No Parameters
	 * No Returns
	 */
	public void accNumberToSearchAccountBy() {
		Scanner sc = new Scanner(System.in);
		
		// Prompt for user to enter the initial balance of the account
		// The prompt will be sent over to the InputValidator class's method to ensure the user enters a valid integer and not other characters
		// This will help prevent the exception error from occurring causing the program to end abruptly...
		String prompt = BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|\n" +
                "|                                                    |\n" +
                "|  Please Enter the Account number to Search By      |\n" +
                "|                                                    |\n" +
                "|====================================================|\n" +
                "" + RESET;
		
		int accNumber = InputValidator.getValidatedInteger(sc, prompt); //calling the method in the InputValidator class to make sure a integer value was entered.. 
		searchForAccountByAccNumber(accNumber); //Calls the method to search for the account using the entered account number by passing the accNumber to the method.	
	}
	
	/**
	 * Description: This method searches for accounts by customer name. The name of the customer will be passed in to this method as a parameter.
	 * 				It prints all accounts belonging to the customer if found, otherwise, it prints a not found message.
	 *
	 * @param name The name of the customer to search for.
	 * No Returns
	 */
	public void searchForAccountByCustomer(String name) {
		boolean found = false;
	    
		// Iterate through all bank accounts
	    for (Account account : bankAccounts) {
	    	
	    	// Check if the account owner's name matches the provided name (case insensitive)
	        if (account.getAccountOwner().getName().equalsIgnoreCase(name)) {
	            if (!found) {
	                // Print header only once when the first account is found
	                System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
	                System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
	                System.out.println(PURPLE_TEXT + BLACK_BG + "|         Customer Accounts Found                    |");
	                System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
	                System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
	                System.out.println("" + RESET);
	                System.out.println("");
	                found = true;
	            }
	            // Print account information
	            System.out.println(account);
	        }
	    }
	    
	    if (!found) {
	        System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
	        System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
	        System.out.println(PURPLE_TEXT + BLACK_BG + "|         No Accounts Found for Customer             |");
	        System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
	        System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
	        System.out.println("" + RESET);
	        System.out.println("");
	    }
	}
	
	/**
	 * Description: This method searches for an account by account number. It takes in the account number as a parameter from a previous method. 
	 * 				It prints the account information if found, otherwise, it prints a not found message.
	 *
	 * @param accNumber The account number to search for.
	 * No Returns
	 */
	public void searchForAccountByAccNumber(int accNumber) {
		
		// Iterate through all bank accounts
		for (Account account : bankAccounts) {
			// Check if the account number matches the provided account number
			if (account.getAccountNumber() == accNumber) {
				System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
				System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
				System.out.println(PURPLE_TEXT + BLACK_BG + "|         	Customer Account was Found                |");
				System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
				System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
				System.out.println("" + RESET);
				System.out.println("");
				
				// Print the account information
				System.out.println(account);
				return; //assists in taking the user back to the manageAccounst()
			}
		}
		
		// If no account was found, print a not found message
		System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(PURPLE_TEXT + BLACK_BG + "|      Customer Account was not Found                |");
	    System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println("" + RESET);
	    
	    pressAnyKey();
	    searchForAccount();
	}
	
	/**
	 * Description: This method displays a menu for searching for an account for deposit or withdrawal.
	 * 				The user can search by account number or customer name.
	 * 				After performing a search, the method returns to the main account management menu.
	 * 
	 * No Parameters
	 * No Returns
	 */
	public void searchForAccountForDep() {
		boolean finished = false;
		int userChoice = 0;
		
		Scanner scanner = new Scanner(System.in); 
		
		while (finished == false) {
			
			// Display a menu for the user to select from 
			System.out.println(BLUE_TEXT + BLACK_BG + "|=========================================|");
			System.out.println(BLUE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|    Account Deposit & Withdrawal Menu    |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|=========================================|");
			System.out.println(BLUE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|  Do you have an account number or       |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|  customer name to access the account?   |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "| 1. Enter the Account Number             |");
			System.out.println(BLUE_TEXT + BLACK_BG + "| 2. Enter the Customer Name              |");
			System.out.println(BLUE_TEXT + BLACK_BG + "| 3. Return to Account Main Menu          |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|=========================================|");
			System.out.println("" + RESET);
			
			// Loop until a valid choice is entered
			// the loop will handle if the user was to enter anything other than a integer such as b/, so that it does not break the program and cause you to start over
			boolean validChoice = false;
			
			while (!validChoice) {
				String userInput = scanner.nextLine();
				if (userInput.matches("[1-3]")) {
					userChoice = Integer.parseInt(userInput);
					validChoice = true;
				} 
				else {
					System.out.println("Invalid Input. Please enter a number between 1 and 3.");
				}
			}
			
			switch (userChoice) {
			case 1:
				accNumberToSearchAccountByForDepOrWith();
				pressAnyKey();
				manageAccounts(); 
                break;
			case 2: 
				customerToSearchAccountByForDepOrWith();
				pressAnyKey();
				manageAccounts(); 
				break; 
			case 3: 
				pressAnyKey();
				manageAccounts();
				break;
			default:
				System.out.println("Invalid choice. Please select a valid option.");
				break;
			}
		}
	}
	
	/**
	 * Description: This method prompts the user to enter a customer name and then searches for accounts by that name.
	 * 				It will then take the name entered and pass it into the method call to search for accounts that match the name entered
	 * 				to find an account to make a deposit or withdrawal..
	 * 
	 * No Parameters
	 * No Returns
	 */
	public void customerToSearchAccountByForDepOrWith() {
		Scanner sc = new Scanner(System.in);

	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|  Please Enter the Customer Name to Search By       |");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println("" + RESET);
	    
	    // Read the customer name input
	    String name = sc.nextLine();
	    accNumberToMakeDepositOrWith(name); //method call to search for the account
	    
	}
	
	/**
	 * Description: This method prompts the user to enter an account number and then searches for the account.
	 * 				It will the pass the entered account number in to the method that will search for the account 
	 * 				so that a deposit or withdrawal can be made...
	 * 
	 * No Parameters
	 * No Returns
	 */
	public void accNumberToSearchAccountByForDepOrWith() {
		Scanner sc = new Scanner(System.in);
		
		// Prompt for user to enter the initial balance of the account
		// The prompt will be sent over to the InputValidator class's method to ensure the user enters a valid integer and not other characters
		// This will help prevent the exception error from occurring causing the program to end abruptly...
		String prompt = BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|\n" +
                "|                                                    |\n" +
                "|  Please Enter the Account number to Search By      |\n" +
                "|                                                    |\n" +
                "|====================================================|\n" +
                "" + RESET;
		int accNumber = InputValidator.getValidatedInteger(sc, prompt);
		
		accNumberToMakeDepositOrWith(accNumber); // method call passing the entered account number to the method that will perform the search
		
	}
	
	/**
	 * Description: This method handles selecting to make a deposit or withdrawal for an account identified by account number.
	 * 				The account number is passed into the method as a parameter. If the account number is found the user can
	 * 				then select if they want to make a deposit or withdrawal or go back to the main menu. If an account is found with the account number, 
	 * 				The method will the pass an Account object that on to the makeADeposit() or makeAWithdrawal.
	 * 				 
	 * @param accNumber The account number to search for.
	 * No Returns
	 */
	public void accNumberToMakeDepositOrWith(int accNumber) {
		// Iterate through all bank accounts
		for (Account account : bankAccounts) {
			// Check if an account number in the ArrayList bankAccounts matches the provided account number
			if (account.getAccountNumber() == accNumber) {
				System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
				System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
				System.out.println(PURPLE_TEXT + BLACK_BG + "|             Customer Account was Found             |");
				System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
				System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
				System.out.println("" + RESET);
				System.out.println("");
				
				boolean finished = false;
				int userChoice = 0;
				
				Scanner scanner = new Scanner(System.in); 
				
				while (finished == false) {
					
					// Display a menu for the user to select from 
					System.out.println(PURPLE_TEXT + BLACK_BG + "|=========================================|");
					System.out.println(PURPLE_TEXT + BLACK_BG + "|                                         |");
					System.out.println(PURPLE_TEXT + BLACK_BG + "|    Account Deposit & Withdrawal Menu    |");
					System.out.println(PURPLE_TEXT + BLACK_BG + "|                                         |");
					System.out.println(PURPLE_TEXT + BLACK_BG + "|=========================================|");
					System.out.println(PURPLE_TEXT + BLACK_BG + "|                                         |");
					System.out.println(PURPLE_TEXT + BLACK_BG + "|  Are You needing to make a Deposit      |");
					System.out.println(PURPLE_TEXT + BLACK_BG + "|  or Withdrawal for the account?         |");
					System.out.println(PURPLE_TEXT + BLACK_BG + "|                                         |");
					System.out.println(PURPLE_TEXT + BLACK_BG + "| 1. Make A Deposit                       |");
					System.out.println(PURPLE_TEXT + BLACK_BG + "| 2. Make A Withdrawal                    |");
					System.out.println(PURPLE_TEXT + BLACK_BG + "| 3. Return to Account Main Menu          |");
					System.out.println(PURPLE_TEXT + BLACK_BG + "|                                         |");
					System.out.println(PURPLE_TEXT + BLACK_BG + "|=========================================|");
					System.out.println("" + RESET);
					
					// Loop until a valid choice is entered
					// the loop will handle if the user was to enter anything other than a integer such as b/, so that it does not break the program and cause you to start over
					boolean validChoice = false;
					
					while (!validChoice) {
						String userInput = scanner.nextLine();
						if (userInput.matches("[1-3]")) {
							userChoice = Integer.parseInt(userInput);
							validChoice = true;
						} 
						else {
							System.out.println("Invalid Input. Please enter a number between 1 and 3.");
						}
					}
					
					switch (userChoice) {
					case 1:
						makeADeposit(account);
						pressAnyKey();
						manageAccounts(); 
		                break;
					case 2: 
						makeAWithdrawal(account);
						pressAnyKey();
						manageAccounts(); 
						break; 
					case 3: 
						pressAnyKey();
						manageAccounts();
						break;
					default:
						System.out.println("Invalid choice. Please select a valid option.");
						break;
					}
				}
			}
		}
		
		// If no account was found, display a not found message
		System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|              Customer was not Found                |");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println("" + RESET);
	}
	
	/**
	 * Description: This method starts by searching the ArrayList for accounts that match the customer name that is passed into the method as a Parameter.
	 * 				If a name match is in the ArrayList bankAccounts it will then add all accounts with the entered name to a new ArrayList customerAccounts.
	 * 				The Method will then display these accounts to the user allowing them to select the one to use to make a deposit or withdrawal. 
	 * 				Once an account is selected an Account object is created and passed on to the next method in the deposit and withdrawal process.
	 *
	 * @param name The name of the customer to search for.
	 * No Returns
	 */
	public void accNumberToMakeDepositOrWith(String name) {
	    boolean customerFound = false; 
	    
	    // new ArrayList to store any accounts that belong to a customer with name passed in as a parameter
	    ArrayList<Account> customerAccounts = new ArrayList<>();
	    
	    // Iterate through all bank accounts
	    for (Account account : bankAccounts) {
	        
	        // Check if the account owner's name matches the provided name (case insensitive)
	        if (account.getAccountOwner().getName().equalsIgnoreCase(name)) {
	            //when an account is found it is added to the customerAccounts ArrayList
	            customerAccounts.add(account);
	            //sets customerFound to true to display the appropriate prompts to the user
	            customerFound = true;
	        }
	    }

	    if (customerFound) {
	        // Display message indicating customer accounts were found
	        System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
	        System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
	        System.out.println(PURPLE_TEXT + BLACK_BG + "|             Customer Account was Found             |");
	        System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
	        System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
	        System.out.println("" + RESET);
	        System.out.println("");
	        
	        boolean finished = false;
	        Scanner scanner = new Scanner(System.in); 
	        
	        while (!finished) {
	            // Display account selection menu
	            System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
	            System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
	            System.out.println(PURPLE_TEXT + BLACK_BG + "|          Select the account for the deposit        |");
	            System.out.println(PURPLE_TEXT + BLACK_BG + "|          or Withdrawal                             |");
	            System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
	            System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
	            System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
	            
	            // Display all accounts for the customer
	            for (int i = 0; i < customerAccounts.size(); i++) {
	                System.out.println(formatLine(PURPLE_TEXT + BLACK_BG + "| " + (i + 1) + ". Account Number: " + customerAccounts.get(i).getAccountNumber() + " "));
	            }
	            System.out.println(formatLine(PURPLE_TEXT + BLACK_BG + "| " + (customerAccounts.size() + 1) + ". Return to Account Main Menu        "));
	            System.out.println(formatLine(PURPLE_TEXT + BLACK_BG + "|"));
	            System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
	            System.out.println("" + RESET);
	            
	            int accountChoice = -1;
	            boolean validChoice = false;

	            while (!validChoice) {
	                String userInput = scanner.nextLine();
	                if (userInput.matches("[1-" + (customerAccounts.size() + 1) + "]")) {
	                    accountChoice = Integer.parseInt(userInput) - 1;
	                    validChoice = true;
	                } else {
	                    System.out.println("Invalid Input. Please enter a number between 1 and " + (customerAccounts.size() + 1) + ".");
	                }
	            }

	            if (accountChoice == customerAccounts.size()) {
	                finished = true;
	                manageAccounts();
	                break;
	            }

	            // Get the selected account and display its information
	            Account selectedAccount = customerAccounts.get(accountChoice);
	            System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
	            System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
	            System.out.println(PURPLE_TEXT + BLACK_BG + "|     Selected Account Number: " + selectedAccount.getAccountNumber() + "             |");
	            System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
	            System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
	            System.out.println("" + RESET);
	            pressAnyKey();

	            // passes the selected account object on to the next method in the deposit and withdrawal process
	            accountToMakeDepositOrWith(selectedAccount);
	        }
	    } 
	    else {
	        // If no customer was found, display a not found message
	        System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
	        System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|                                                    |");
	        System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|              Customer was not Found                |");
	        System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|                                                    |");
	        System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
	        System.out.println("" + RESET);
	    }
	}		
	
	/**
	 * Description: This method handles selecting to make a deposit or withdrawal for a given account.
	 * 				The account object for the deposit or withdrawal will be passed into this method as a parameter.
	 * 				Once a selection is made the method will pass the account object on to makeADeposit() or makeAWithdrawal()
	 *
	 * @param account The account to deposit or withdraw funds.
	 * No Returns
	 */
	public void accountToMakeDepositOrWith(Account account) {
				
		boolean finished = false;
		int userChoice = 0;
				
		Scanner scanner = new Scanner(System.in); 
				
		while (finished == false) {
					
			// Display a menu for the user to select from 
			System.out.println(PURPLE_TEXT + BLACK_BG + "|=========================================|");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|    Account Deposit & Withdrawal Menu    |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|=========================================|");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|  Are You needing to make a Deposit      |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|  or Withdrawal for the account?         |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "| 1. Make A Deposit                       |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "| 2. Make A Withdrawal                    |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "| 3. Return to Account Main Menu          |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|=========================================|");
			System.out.println("" + RESET);
					
			// Loop until a valid choice is entered
			// the loop will handle if the user was to enter anything other than a integer such as b/, so that it does not break the program and cause you to start over
			boolean validChoice = false;
					
			while (!validChoice) {
				String userInput = scanner.nextLine();
				if (userInput.matches("[1-3]")) {
					userChoice = Integer.parseInt(userInput);
					validChoice = true;
				} 
				else {
					System.out.println("Invalid Input. Please enter a number between 1 and 3.");
				}
			}
					
			switch (userChoice) {
			case 1:
				makeADeposit(account);
				pressAnyKey();
				manageAccounts(); 
		              break;
			case 2: 
				makeAWithdrawal(account);
				manageAccounts(); 
				break; 
			case 3: 
				pressAnyKey();
				manageAccounts();
				break;
			default:
				System.out.println("Invalid choice. Please select a valid option.");
				break;
			}
		}
	}

	/**
	 * Description: This method prompts the user to enter a deposit amount and updates the account balance.
	 *
	 * @param account The account to deposit funds.
	 * No Return
	 */
	public void makeADeposit(Account account) {
		Scanner sc = new Scanner(System.in);
		
		// Prompt for user to enter the initial balance of the account
		// The prompt will be sent over to the InputValidator class's method to ensure the user enters a valid double and not other characters
		// This will help prevent the exception error from occurring causing the program to end abruptly...
		String prompt = BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|\n" +
                "|                                                    |\n" +
                "|  Please Enter the amount of the deposit for the    |\n" +
                "|  account:                                          |\n" +
                "|                                                    |\n" +
                "|====================================================|\n" +
                "" + RESET;
	    double deposit = InputValidator.getValidatedDouble(sc, prompt); //calling the method in the InputValidator class to make sure a double value was entered
	    sc.nextLine(); // Consume the newline character
		
	    //calls the method in the Account class to make a deposit by passing the deposit amount into the method
		account.makeDeposit(deposit);
		
		// displays the new balance after the deposit has been made 
		System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
		System.out.println(formatLine(BRIGHTCYAN_TEXT + BLACK_BG + "|"));
		System.out.println(formatLine(BRIGHTCYAN_TEXT + BLACK_BG + "| New Balance for the account: $" + account.getBalance()));
		System.out.println(formatLine(BRIGHTCYAN_TEXT + BLACK_BG + "|"));
		System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
		System.out.println("" + RESET);
		
		return; // helps in the return process to manageAccounts();
		
	}
	
	/**
	 * Description: This method prompts the user to enter a withdrawal amount and updates the account balance.
	 * 				It takes in an account object as a parameter to ensure the withdrawal is made from the correct account
	 *
	 * @param account The account to withdraw funds.
	 */
	public void makeAWithdrawal(Account account) {
		Scanner sc = new Scanner(System.in);
		
		// Prompt for user to enter the initial balance of the account
		// The prompt will be sent over to the InputValidator class's method to ensure the user enters a valid double and not other characters
		// This will help prevent the exception error from occurring causing the program to end abruptly...
		String prompt = BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|\n" +
                "|                                                    |\n" +
                "|  Please Enter the amount of the withdrawal for     |\n" +
                "|  the account:                                      |\n" +
                "|                                                    |\n" +
                "|====================================================|\n" +
                "" + RESET;
	    double withdrawal = InputValidator.getValidatedDouble(sc, prompt);
	    sc.nextLine(); // Consume the newline character
		
	    // variable to use to ensure the withdrawal was successful
		double initialBalance = account.getBalance();
		
		// Make the withdrawal
		account.makeWithdrawal(withdrawal);
		
		// Check if withdrawal was successful
		if (account.getBalance() < initialBalance) {
			System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
			System.out.println(formatLine(BRIGHTCYAN_TEXT + BLACK_BG + "|"));
			System.out.println(formatLine(BRIGHTCYAN_TEXT + BLACK_BG + "| New Balance for the account: $" + account.getBalance()));
			System.out.println(formatLine(BRIGHTCYAN_TEXT + BLACK_BG + "|"));
			System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
			System.out.println("" + RESET);
			
		}
		// if the user tries to withdrawal more than the balance of the account the withdrawal will not go through and the user is prompted to try again
		else {
			pressAnyKey();
			accountToMakeDepositOrWith(account);
		}
		
		return;
		
	}
	
	/*
	 * Description: This is a menu to start the Calculate Interest process. 
	 * 				The user is able to search for an account to calculate interest on either
	 * 				by entering the account number or customer name. The users selection will navigate them
	 * 				through the remaining methods in the CalculateInterest process. 
	 * No Parameters
	 * No Returns
	 */
	public void manageInterestCalculation() {
		boolean finished = false;
		int userChoice = 0;
		
		Scanner scanner = new Scanner(System.in); 
		
		while (finished == false) {
			
			// Display a menu for the user to select from 
			System.out.println("");
			System.out.println(BLUE_TEXT + WHITE_BG + "|=========================================|");
			System.out.println(BLUE_TEXT + WHITE_BG + "|                                         |");
			System.out.println(BLUE_TEXT + WHITE_BG + "|    Account Interest Calculation Menu    |");
			System.out.println(BLUE_TEXT + WHITE_BG + "|                                         |");
			System.out.println(BLUE_TEXT + WHITE_BG + "|=========================================|");
			System.out.println(BLUE_TEXT + WHITE_BG + "|                                         |");
			System.out.println(BLUE_TEXT + WHITE_BG + "|  Do you have an account number or       |");
			System.out.println(BLUE_TEXT + WHITE_BG + "|  customer name to access the account?   |");
			System.out.println(BLUE_TEXT + WHITE_BG + "|                                         |");
			System.out.println(BLUE_TEXT + WHITE_BG + "| 1. Enter the Account Number             |");
			System.out.println(BLUE_TEXT + WHITE_BG + "| 2. Enter the Customer Name              |");
			System.out.println(BLUE_TEXT + WHITE_BG + "| 3. Return to Account Main Menu          |");
			System.out.println(BLUE_TEXT + WHITE_BG + "|                                         |");
			System.out.println(BLUE_TEXT + WHITE_BG + "|=========================================|");
			System.out.println("" + RESET);
			
			// Loop until a valid choice is entered
			// the loop will handle if the user was to enter anything other than a integer such as b/, so that it does not break the program and cause you to start over
			boolean validChoice = false;
			
			while (!validChoice) {
				String userInput = scanner.nextLine();
				if (userInput.matches("[1-3]")) {
					userChoice = Integer.parseInt(userInput);
					validChoice = true;
				} 
				else {
					System.out.println("Invalid Input. Please enter a number between 1 and 3.");
				}
			}
			
			switch (userChoice) {
			case 1:
				accNumberForInteresr();
				pressAnyKey();
				manageAccounts(); 
                break;
			case 2: 
				nameforInterestCalcualtion();
				pressAnyKey();
				manageAccounts(); 
				break; 
			case 3: 
				pressAnyKey();
				manageAccounts();
				break;
			default:
				System.out.println("Invalid choice. Please select a valid option.");
				break;
			}
		}
	}
	
	/**
	 * Description: This method prompts the user to enter an account number to search for a Savings Account to 
	 * 				Calculate the interest on. The account number is then passed on in the method call interestCalculation();
	 * 
	 * No Parameters
	 * No Returns
	 */
	public void accNumberForInteresr() {
		Scanner sc = new Scanner(System.in);
		
		// Display prompt to enter account number
		String prompt = BLUE_TEXT + WHITE_BG + "|====================================================|\n" +
                							   "|                                                    |\n" +
                							   "|  Please Enter the Account number to Search By      |\n" +
                							   "|                                                    |\n" +
                							   "|====================================================|\n" +
                							   "" + RESET;
		// Get and validate account number input
		int accNumber = InputValidator.getValidatedInteger(sc, prompt);
		
		// Proceed with interest calculation for the entered account number
		interestCalculation(accNumber);
	}
	
	/**
	 * Description: Calculates and displays the interest for a given account number.
	 *
	 * @param accountNumber The account number to calculate interest for.
	 */
	public void interestCalculation(int accountNumber) {
		
		boolean accountFound = false;
		double interestAmount = 0.0;
		
		// Search for the account by account number
		for (Account account : bankAccounts) {
			if (account.getAccountNumber() == accountNumber) {
				accountFound = true; 
				System.out.println(BLUE_TEXT + WHITE_BG + "|====================================================|");
				System.out.println(BLUE_TEXT + WHITE_BG + "|                                                    |");
				System.out.println(BLUE_TEXT + WHITE_BG + "|              Customer Account was Found            |");
				System.out.println(BLUE_TEXT + WHITE_BG + "|                                                    |");
				System.out.println(BLUE_TEXT + WHITE_BG + "|====================================================|");
				System.out.println("" + RESET);
				System.out.println("");
				
				// If the account is a savings account, calculate and display the interest
				if (account instanceof SavingsAccount) {
					SavingsAccount savingsAccount = (SavingsAccount) account;
					interestAmount = savingsAccount.calculateInterest(); 
					
					System.out.println(BLUE_TEXT + WHITE_BG + "|====================================================|");
			        System.out.println(BLUE_TEXT + WHITE_BG + "|                                                    |");
			        System.out.println(formatLine(BLUE_TEXT + WHITE_BG + "|  For the Account Number: " + savingsAccount.getAccountNumber() + " "));
			        System.out.println(formatLine(BLUE_TEXT + WHITE_BG + "|  Belonging to " + savingsAccount.getAccountOwner().getName() +  " "));
			        System.out.println(formatLine(BLUE_TEXT + WHITE_BG + "|  With a current Balanance of: $" + savingsAccount.getBalance() +  " "));
			        System.out.println(formatLine(BLUE_TEXT + WHITE_BG + "|  The Interest Amount earned would be: "));
			        System.out.println(formatLine(BLUE_TEXT + WHITE_BG + "|               $" + String.format("%.2f", interestAmount) + " "));
			        System.out.println(BLUE_TEXT + WHITE_BG + "|                                                    |");
			        System.out.println(BLUE_TEXT + WHITE_BG + "|====================================================|");
			        System.out.println("" + RESET);
			        System.out.println("");
			      
			        return; 
				}
				// If the account is not a savings account, display an error message
				else {
	                System.out.println(RED_TEXT + WHITE_BG + "|====================================================|");
	                System.out.println(RED_TEXT + WHITE_BG + "|                                                    |");
	                System.out.println(RED_TEXT + WHITE_BG + "|     The account is not a Savings Account.          |");
	                System.out.println(RED_TEXT + WHITE_BG + "|                                                    |");
	                System.out.println(RED_TEXT + WHITE_BG + "|====================================================|");
	                System.out.println("" + RESET);
	                
	                pressAnyKey();
	                manageInterestCalculation();
	                return;
	            }
			}
			
		}
		// If the account was not found, display an error message
		if (!accountFound) {
	        System.out.println(RED_TEXT + WHITE_BG + "|====================================================|");
	        System.out.println(RED_TEXT + WHITE_BG + "|                                                    |");
	        System.out.println(RED_TEXT + WHITE_BG + "|          Customer Account was Not Found            |");
	        System.out.println(RED_TEXT + WHITE_BG + "|                                                    |");
	        System.out.println(RED_TEXT + WHITE_BG + "|====================================================|");
	        System.out.println("" + RESET);
	        
	        pressAnyKey();
	        manageInterestCalculation(); 
		} 
	}
	
	/**
	 * Description: Prompts the user to enter a customer name to find an account for interest calculation.
	 * 
	 * No parameters
	 * No returns
	 */
	public void nameforInterestCalcualtion() {
		Scanner sc = new Scanner(System.in);

	    System.out.println(BLUE_TEXT + WHITE_BG + "|====================================================|");
	    System.out.println(BLUE_TEXT + WHITE_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + WHITE_BG + "|  Please Enter the Customer Name to Search By       |");
	    System.out.println(BLUE_TEXT + WHITE_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + WHITE_BG + "|====================================================|");
	    System.out.println("" + RESET);
	    
	    String name = sc.nextLine();
	    
	    // Proceed to find accounts for the entered customer name
	    findAccountsForInterest(name);
	}
	
	/**
	 * Description: Finds accounts for a given customer name for interest calculation.
	 * 				If accounts are found matching the entered name then it will add those to 
	 * 				a new ArrayList accountsForInterest. It will display a message letting the 
	 * 				user known that accounts were found before passing the ArrayList on to the selectionOfAccount().
	 *
	 * @param name The name of the customer to search for.
	 */
	public void findAccountsForInterest(String name) {
		boolean customerFound = false; 
		
		// new ArrayList to store any accounts that have the customer name passed in as a parameter 
		ArrayList<Account> accountsForInterest = new ArrayList<>();
		
		// Search for accounts belonging to the customer
		for (Account account : bankAccounts) {
			if (account.getAccountOwner().getName().equalsIgnoreCase(name)) {
				customerFound = true;
				accountsForInterest.add(account);
			}
		}
	    
	    if (customerFound) {
	        System.out.println(BLUE_TEXT + WHITE_BG + "|====================================================|");
	        System.out.println(BLUE_TEXT + WHITE_BG + "|                                                    |");
	        System.out.println(BLUE_TEXT + WHITE_BG + "|             Customer Account(s) Found              |");
	        System.out.println(BLUE_TEXT + WHITE_BG + "|                                                    |");
	        System.out.println(BLUE_TEXT + WHITE_BG + "|====================================================|");
	        System.out.println("" + RESET);
	        System.out.println(""); 
	        
	        pressAnyKey();
	        selectionOfAccount(accountsForInterest);
	    } 
	    else {
	        System.out.println(BLUE_TEXT + WHITE_BG + "|====================================================|");
	        System.out.println(BLUE_TEXT + WHITE_BG + "|                                                    |");
	        System.out.println(BLUE_TEXT + WHITE_BG + "|              Customer was not Found                |");
	        System.out.println(BLUE_TEXT + WHITE_BG + "|                                                    |");
	        System.out.println(BLUE_TEXT + WHITE_BG + "|====================================================|");
	        System.out.println("" + RESET);
	        
	        pressAnyKey();
	        manageInterestCalculation();
	    }
	}
	
	/**
	 * Description: Allows the user to select an account from the list of accounts passed in as a parameter for interest calculation.
	 * 				The method will first check to see if the accounts in the ArrayList accountsForInterest are an instanceOf a SavingsAccount.
	 * 				Only SavingsAccounts can have interest.. If any of the accounts in the ArrayList are an instanceof SavingsAccount the program will 
	 * 				add those SavingsAccounts to the new ArrayList savingsAccountsForInterest. If there are any SavingsAccount in the ArrayList savingsAccountsForInterest
	 * 				the program will prompt the user to select the savings account to calculate the interest on. Once the account is selected it is then
	 * 				passed on the next method to perform the actual interest calculation. If there are no savings accounts in the ArrayList that was passed in
	 * 				as a parameter then it will display a message and return to the main menu.
	 *
	 * @param accountsForInterest The ArrayList of accounts for the customer.
	 * No Returns
	 */
	public void selectionOfAccount(ArrayList<Account> accountsForInterest) {
		
		// creates a new ArrayList to store any instanceof SavingsAccount in the ArrayList accountsForInterest
		ArrayList<SavingsAccount> savingsAccountsForInterest = new ArrayList<>();
		
		boolean finished = false;
		
		Scanner scanner = new Scanner(System.in); 
		
		// loops through the list of accounts passed in as a parameter looking for instanceof SavingsAccount
		// if any are found they are added to the ArrayList savingsAccountsForInterest
		for (Account account : accountsForInterest) {
			if (account instanceof SavingsAccount) {
				SavingsAccount savingsAccount = (SavingsAccount) account; 
				savingsAccountsForInterest.add(savingsAccount);	
			}		
		} 
		
		// message for instance when there are not any savings accounts in the ArrayList accountsForInterest
		if (savingsAccountsForInterest.isEmpty()) {
	        System.out.println(BLUE_TEXT + WHITE_BG + "|====================================================|");
	        System.out.println(BLUE_TEXT + WHITE_BG + "|                                                    |");
	        System.out.println(BLUE_TEXT + WHITE_BG + "|       No Savings Accounts found for the customer   |");
	        System.out.println(BLUE_TEXT + WHITE_BG + "|                                                    |");
	        System.out.println(BLUE_TEXT + WHITE_BG + "|====================================================|");
	        System.out.println("" + RESET);
	        pressAnyKey();
	        return;
	    }
		
		// menu to allow the user to select the Savings Account to calculate interest on 
		while (!finished) {
			System.out.println(BLUE_TEXT + WHITE_BG + "|====================================================|");
			System.out.println(BLUE_TEXT + WHITE_BG + "|                                                    |");
			System.out.println(BLUE_TEXT + WHITE_BG + "|          Select the savings account to calculate   |");
			System.out.println(BLUE_TEXT + WHITE_BG + "|          interest for:                             |");
			System.out.println(BLUE_TEXT + WHITE_BG + "|                                                    |");
			System.out.println(BLUE_TEXT + WHITE_BG + "|====================================================|");
			System.out.println(BLUE_TEXT + WHITE_BG + "|                                                    |");
			
			for (int i = 0; i < savingsAccountsForInterest.size(); i++) {
                System.out.println(formatLine(BLUE_TEXT + WHITE_BG + "| " + (i + 1) + ". Account Number: " + savingsAccountsForInterest.get(i).getAccountNumber() + " "));
            }
            System.out.println(formatLine(BLUE_TEXT + WHITE_BG + "| " + (savingsAccountsForInterest.size() + 1) + ". Return to Account Main Menu        "));
            System.out.println(formatLine(BLUE_TEXT + WHITE_BG + "|"));
            System.out.println(BLUE_TEXT + WHITE_BG + "|====================================================|");
            System.out.println("" + RESET);
            
            int accountChoice = -1;
            boolean validChoice = false;
            
            while (!validChoice) {
                String userInput = scanner.nextLine();
                if (userInput.matches("[1-" + (savingsAccountsForInterest.size() + 1) + "]")) {
                    accountChoice = Integer.parseInt(userInput) - 1;
                    validChoice = true;
                } else {
                    System.out.println("Invalid Input. Please enter a number between 1 and " + (savingsAccountsForInterest.size() + 1) + ".");
                }
            }
            
         // If the user chooses to return to the main menu, break the loop
            if (accountChoice == savingsAccountsForInterest.size()) {
                finished = true;
                manageAccounts();
                break;
            }
            
            // uses the user's choice to create new SavingsAccount object to pass on to the interest calculation. 
            SavingsAccount selectedAccount = savingsAccountsForInterest.get(accountChoice);
            
            calculationOfInterest(selectedAccount);
		}
	}
	
	/**
	 * Description: Calculates and displays the interest for a given savings account.
	 *
	 * @param account The savings account to calculate interest for.
	 */
	public void calculationOfInterest(SavingsAccount account) {
		
		// performs the interest calculation
		double interestAmount = account.calculateInterest();
		
		// Display the interest calculation details
		System.out.println(BLUE_TEXT + WHITE_BG + "|====================================================|");
        System.out.println(BLUE_TEXT + WHITE_BG + "|                                                    |");
        System.out.println(formatLine(BLUE_TEXT + WHITE_BG + "|  For the Account Number: " + account.getAccountNumber() + " "));
        System.out.println(formatLine(BLUE_TEXT + WHITE_BG + "|  Belonging to " + account.getAccountOwner().getName() +  " "));
        System.out.println(formatLine(BLUE_TEXT + WHITE_BG + "|  With a current Balanance of: $" + account.getBalance() +  " "));
        System.out.println(formatLine(BLUE_TEXT + WHITE_BG + "|  The Interest Amount earned would be: "));
        System.out.println(formatLine(BLUE_TEXT + WHITE_BG + "|               $" + String.format("%.2f", interestAmount) + " "));
        System.out.println(BLUE_TEXT + WHITE_BG + "|                                                    |");
        System.out.println(BLUE_TEXT + WHITE_BG + "|====================================================|");
        System.out.println("" + RESET);
        System.out.println("");
        
        pressAnyKey(); 
        manageAccounts(); 
	}
	
	/**
	 * Description: Manages the bank branches, providing options to create, display, and search for branches.
	 * 
	 * No Parameters
	 * No Return
	 * 
	 */
	public void manageBankBranches() {
		
		boolean finished = false;
		int userChoice = 0;
		
		Scanner scanner = new Scanner(System.in); 
		
        while (finished == false) {
        	
        	// Display a menu for the user to select from 
        	System.out.println(RED_TEXT + WHITE_BG + "|=========================================|");
			System.out.println(RED_TEXT + WHITE_BG + "|                                         |");
			System.out.println(RED_TEXT + WHITE_BG + "|       Bank Branch Mangement Menu        |");
			System.out.println(RED_TEXT + WHITE_BG + "|                                         |");
			System.out.println(RED_TEXT + WHITE_BG + "|=========================================|");
			System.out.println(RED_TEXT + WHITE_BG + "|                                         |");
			System.out.println(RED_TEXT + WHITE_BG + "|    Please Make a Selection (1-4):       |");
			System.out.println(RED_TEXT + WHITE_BG + "|                                         |");
			System.out.println(RED_TEXT + WHITE_BG + "| 1. Create New Branch                    |");
			System.out.println(RED_TEXT + WHITE_BG + "| 2. Display All Branches                 |");
			System.out.println(RED_TEXT + WHITE_BG + "| 3. Search For A Branch                  |");
			System.out.println(RED_TEXT + WHITE_BG + "| 4. Return to Main Menu                  |");
			System.out.println(RED_TEXT + WHITE_BG + "|                                         |");
			System.out.println(RED_TEXT + WHITE_BG + "|=========================================|");
			System.out.println("" + RESET);
			
			// Loop until a valid choice is entered
			// the loop will handle if the user was to enter anything other than a integer such as b/, so that it does not break the program and cause you to start over
			boolean validChoice = false;
									
			while (!validChoice) {
				String userInput = scanner.nextLine();
				if (userInput.matches("[1-4]")) {
					userChoice = Integer.parseInt(userInput);
					validChoice = true;
				} 
				else {
					System.out.println("Invalid Input. Please enter a number between 1 and 4.");
				}
			}
			
			switch (userChoice) {
        		case 1:
        			createNewBankBranch();
        			break;
        		case 2: 
        			displayBankBranches();
        			pressAnyKey();
        			break; 
        		case 3: 
        			enterNameForBranch();
        			pressAnyKey();
        			break;
        		case 4:
        			pressAnyKey();
        			mainMenu();
        			break;
        		default:
        			System.out.println("Invalid choice. Please select a valid option.");
        			break;
			}
        }
	}
	
	/**
	 * Description: This method Creates a new BankBranch object by prompting the user for branch name and address.
	 * 				It will then add the newly created Branch to the ArrayList bankBranches...
	 *
	 * No Returns
	 * @return The created BankBranch object.
	 */
	public BankBranch createNewBankBranch() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("");
		System.out.println(RED_TEXT + WHITE_BG + "|====================================================|");
        System.out.println(RED_TEXT + WHITE_BG + "|                                                    |");
        System.out.println(RED_TEXT + WHITE_BG + "|   Congratulations on the opening of a new Quantum  |");
        System.out.println(RED_TEXT + WHITE_BG + "|   Realms Bank Branch                               |");
        System.out.println(RED_TEXT + WHITE_BG + "|                                                    |");
        System.out.println(RED_TEXT + WHITE_BG + "|====================================================|");
        System.out.println("" + RESET);
        
        // Prompt for branch name
        System.out.println("");
        System.out.println(RED_TEXT + WHITE_BG + "|====================================================|");
        System.out.println(RED_TEXT + WHITE_BG + "|                                                    |");
        System.out.println(RED_TEXT + WHITE_BG + "|   Please Enter the Name of the new Branch          |");
        System.out.println(RED_TEXT + WHITE_BG + "|                                                    |");
        System.out.println(RED_TEXT + WHITE_BG + "|====================================================|");
        System.out.println("");
        
        String branchName = sc.nextLine();
        
        // Prompt for branch address
        System.out.println("");
        System.out.println(RED_TEXT + WHITE_BG + "|====================================================|");
        System.out.println(RED_TEXT + WHITE_BG + "|                                                    |");
        System.out.println(RED_TEXT + WHITE_BG + "|   Please Enter the address for the new Branch      |");
        System.out.println(RED_TEXT + WHITE_BG + "|                                                    |");
        System.out.println(RED_TEXT + WHITE_BG + "|====================================================|");
        System.out.println("");
        
        String address = sc.nextLine();
        
        // Create new branch and adds it to the ArrayList
        BankBranch newBranch = new BankBranch(branchName, address); 
        bankBranches.add(newBranch);
        
        System.out.println("");
	    System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|           Bank Branch Created successfully                 |");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("");
		System.out.println("");
		
		pressAnyKey();
		
		// Display new branch information
		System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|          Here is the information for the new Branch        |");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("");
		
		pressAnyKey();
		
	    System.out.println(newBranch);
	    
	    pressAnyKey();
	    
	    return newBranch;       
	}
	
	/**
	 * Description: Prompts the user to enter the name of a branch to search for.
	 * 
	 * No Parameter
	 * No Return 
	 */
	public void enterNameForBranch() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("");
        System.out.println(RED_TEXT + WHITE_BG + "|====================================================|");
        System.out.println(RED_TEXT + WHITE_BG + "|                                                    |");
        System.out.println(RED_TEXT + WHITE_BG + "|   Please Enter the Name for the Branch             |");
        System.out.println(RED_TEXT + WHITE_BG + "|                                                    |");
        System.out.println(RED_TEXT + WHITE_BG + "|====================================================|");
        System.out.println("");
        
        String name = sc.nextLine();
        
        findBranch(name);
	}
	
	/**
	 * Description: Searches for a branch by name and displays its information if found.
	 *
	 * @param name The name of the branch to search for.
	 * No Returns
	 */
	public void findBranch(String name) {
		for (BankBranch branch : bankBranches) {
			if (branch.getBranchName().equalsIgnoreCase(name)) {
				System.out.println("");
				System.out.println(RED_TEXT + WHITE_BG + "|====================================================|");
			    System.out.println(RED_TEXT + WHITE_BG + "|                                                    |");
			    System.out.println(RED_TEXT + WHITE_BG + "|            The Bank Branch was Found               |");
			    System.out.println(RED_TEXT + WHITE_BG + "|                                                    |");
			    System.out.println(RED_TEXT + WHITE_BG + "|====================================================|");
			    System.out.println("" + RESET);
			    System.out.println("");
			    
			    pressAnyKey();
				
				System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
				System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
				System.out.println(RED_TEXT + BLACK_BG + "|          Here is the information for the Branch            |");
				System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
				System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
				System.out.println("");
				
				pressAnyKey();
				
			    System.out.println(branch);
			    
			    return;
			}
		}
		System.out.println(RED_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(RED_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(RED_TEXT + BLACK_BG + "|              Branch was not Found                  |");
	    System.out.println(RED_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(RED_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println("" + RESET);
	}
	
	/**
	 * Description: This method displays all the customers currently in the ArrayList customers, one at a time.
	 * 
	 * No Parameters
	 * No Return
	 */
	public void displayCustomers() {
		System.out.println(GREEN_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(GREEN_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(GREEN_TEXT + BLACK_BG + "| These are the current Customers at Quantum         |");
	    System.out.println(GREEN_TEXT + BLACK_BG + "| Realms Bank.                                       |");
	    System.out.println(GREEN_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(GREEN_TEXT + BLACK_BG + "| The System will display one customer at a time.    |");
	    System.out.println(GREEN_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(GREEN_TEXT + BLACK_BG + "| Press the Enter Key to display the next Customer.  |");
	    System.out.println(GREEN_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(GREEN_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println("");
	    
	    pressAnyKey();
	    
        for (Customer customer : customers) {
            System.out.println(customer);
            pressAnyKey();
        }
        
        System.out.println(RED_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(RED_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(RED_TEXT + BLACK_BG + "| There are no more customers for Quantum Realms     |");
	    System.out.println(RED_TEXT + BLACK_BG + "| Bank                                               |");
	    System.out.println(RED_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(RED_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println("" + RESET);
	}
    
	/**
	 * Description: This method displays all the Accounts currently in the ArrayList bankAccounts, one at a time.
	 * 
	 * No Parameters
	 * No Return
	 */
    public void displayAccounts() {
    	System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "| These are the current Accounts at Quantum          |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "| Realms Bank.                                       |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "| The System will display one account at a time.     |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "| Press the Enter Key to display the next Account.   |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println("");
	    
	    pressAnyKey();
	    
        for (Account account : bankAccounts) {
        	System.out.println(account);
        	pressAnyKey();
        }
        
        System.out.println(RED_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(RED_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(RED_TEXT + BLACK_BG + "| There are no more accounts for Quantum Realms      |");
	    System.out.println(RED_TEXT + BLACK_BG + "| Bank                                               |");
	    System.out.println(RED_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(RED_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println("" + RESET);
    }
    
    /**
	 * Description: This method displays all the bank branches currently in the ArrayList bankBranches, one at a time.
	 * 
	 * No Parameters
	 * No Return
	 */
    public void displayBankBranches() {
    	System.out.println(RED_TEXT + WHITE_BG + "|====================================================|");
	    System.out.println(RED_TEXT + WHITE_BG + "|                                                    |");
	    System.out.println(RED_TEXT + WHITE_BG + "| These are the current Branches for Quantum         |");
	    System.out.println(RED_TEXT + WHITE_BG + "| Realms Bank.                                       |");
	    System.out.println(RED_TEXT + WHITE_BG + "|                                                    |");
	    System.out.println(RED_TEXT + WHITE_BG + "| The System will display one branch at a time.      |");
	    System.out.println(RED_TEXT + WHITE_BG + "|                                                    |");
	    System.out.println(RED_TEXT + WHITE_BG + "| Press the Enter Key to display the next Branch.    |");
	    System.out.println(RED_TEXT + WHITE_BG + "|                                                    |");
	    System.out.println(RED_TEXT + WHITE_BG + "|====================================================|");
	    System.out.println("");
	    
	    pressAnyKey();
	    
    	for (BankBranch branch : bankBranches) {
    		System.out.println(branch);
    		pressAnyKey();
    	}
    	
    	System.out.println(RED_TEXT + WHITE_BG + "|====================================================|");
	    System.out.println(RED_TEXT + WHITE_BG + "|                                                    |");
	    System.out.println(RED_TEXT + WHITE_BG + "| There are no more Branches for Quantum Realms      |");
	    System.out.println(RED_TEXT + WHITE_BG + "| Bank                                               |");
	    System.out.println(RED_TEXT + WHITE_BG + "|                                                    |");
	    System.out.println(RED_TEXT + WHITE_BG + "|====================================================|");
	    System.out.println("" + RESET);
    	
    }
    
    /**
     * Description: This method Prompts the user to press the Enter key to continue.
     * 				This is a simple method to help manage how information is displayed in the console.
     * 				This method adds readability elements and stops the program from moving past certain elements. 
     */
    public void pressAnyKey() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please Press the Enter key to continue");
		sc.nextLine();
		
	}
    
    /**
     * Description: Formats a string to fit within a specified width, adding padding and a trailing '|'.
     *
     * @param content The string content to format.
     * @return The formatted string.
     */
    private String formatLine(String content) {
	    int LINE_WIDTH = 62; // Adjust the width as needed
	    return String.format("%-" + LINE_WIDTH + "s |", content);
	}
}
