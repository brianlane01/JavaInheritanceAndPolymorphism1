import java.util.ArrayList; 
import java.util.Arrays;
import java.util.Scanner;
import java.util.Date;
import java.util.InputMismatchException;

public class Bank {
	
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
		
		BankBranch branch1 = new BankBranch("Chicago Branch", "123 Lakeside Drive, Chicago, IL 60601");
		BankBranch branch2 = new BankBranch("Gotham City Branch", "123 Wayne Avenue, Gotham City");
		BankBranch branch3 = new BankBranch("Metropolis Branch", "456 Daily Planet Plaza, Metropolis");
		BankBranch branch4 = new BankBranch("Central City Branch", "4789 Keystone Road, Central City");
		BankBranch branch5 = new BankBranch("Coast City Branch", "654 Lantern Lane, Coast City");
		BankBranch branch6 = new BankBranch("Asgard Branch", "789 Bifrost Boulevard, Asgard");
		BankBranch branch7 = new BankBranch("Latveria Branch", "654 Doom Street, Doomstadt, Latveria");
		
		
		PersonalCustomer customer1 = new PersonalCustomer("Barry Allen", "1234 Fast Lane", "555-345-6789", "555-123-4567", "555-234-5678");
		PersonalCustomer customer2 = new PersonalCustomer("Rachel Roth", "5678 Shadow Lane", "555-456-7890", "555-123-4567", "555-234-5678");
		CommercialCustomer customer3 = new CommercialCustomer("Wayne Enterprises", "1007 Gotham Way", "555-890-1234", 820, "Bruce Wayne", "555-901-2345" );
		CommercialCustomer customer4 = new CommercialCustomer("Stark Industries", "10880 Malibu Point", "555-432-7658", 830, "Tony Stark", "555-901-6765" );
		CommercialCustomer customer5 = new CommercialCustomer("ACME Industries", "100 Arkham Way", "555-213-5467", 620, "Harleen Quinzel", "555-324-6578" );
		PersonalCustomer customer6 = new PersonalCustomer("Clark Kent", "1234 Smallville Road", "555-690-6789", "555-178-4567", "555-909-5678");
		PersonalCustomer customer7 = new PersonalCustomer("Peter Parker", "20 Ingram Street", "555-600-6789", "555-000-4567", "555-000-5678");
		
		CheckingAccount account1 = new CheckingAccount(1573.75, new Date(), customer1, branch4, "Eco-Friendly");
		CheckingAccount account2 = new CheckingAccount(573.75, new Date(), customer2, branch5, "Eco-Friendly");
		CheckingAccount account3 = new CheckingAccount(59559898873.75, new Date(), customer3, branch2, "Fantasy and Sci-Fi");
		CheckingAccount account4 = new CheckingAccount(595899898873.75, new Date(), customer4, branch7, "Inspirational Quotes");
		CheckingAccount account5 = new CheckingAccount(898873.75, new Date(), customer5, branch1, "Nature Inspired");
		CheckingAccount account6 = new CheckingAccount(898873.75, new Date(), customer6, branch3, "Modern Minimalist");
		CheckingAccount account7 = new CheckingAccount(873.75, new Date(), customer7, branch1, "Animal Lovers");
		SavingsAccount account8 = new SavingsAccount(100.00, new Date(), customer1, branch4, 10);
		SavingsAccount account9 = new SavingsAccount(5890.00, new Date(), customer2, branch5, 5.8);
		SavingsAccount account10 = new SavingsAccount(345587757890.00, new Date(), customer3, branch2, 8.3);
		SavingsAccount account11 = new SavingsAccount(577758857890.00, new Date(), customer4, branch7, 3.3);
		SavingsAccount account12 = new SavingsAccount(88890.00, new Date(), customer5, branch1, 10);
		SavingsAccount account13 = new SavingsAccount(17890.00, new Date(), customer6, branch3, 10);
		SavingsAccount account14 = new SavingsAccount(10890.00, new Date(), customer7, branch1, 10);
		
		branch1.addAccount(account14);
		branch1.addAccount(account12);
		branch1.addAccount(account7);
		branch1.addAccount(account5);
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
		
		customer1.addAccount(account1);
		customer1.addAccount(account8);
		customer2.addAccount(account2);
		customer2.addAccount(account9);
		customer3.addAccount(account3);
		customer3.addAccount(account10);
		customer4.addAccount(account4);
		customer4.addAccount(account11);
		customer5.addAccount(account5);
		customer5.addAccount(account12);
		customer6.addAccount(account6);
		customer6.addAccount(account13);
		customer7.addAccount(account14);
		customer7.addAccount(account7);
		
		customers.add(customer1);
		customers.add(customer2);
		customers.add(customer3);
		customers.add(customer4);
		customers.add(customer5);
		customers.add(customer6);
		customers.add(customer7);
		
		bankAccounts.addAll(Arrays.asList(account14, account13, account12, account11, account10, account9, account8, 
											account7, account6, account5, account4, account3, account2, account1));
		
		bankBranches.addAll(Arrays.asList(branch1, branch2, branch3, branch4, branch5, branch6, branch7));
		
		mainMenu();
	}
	
	public void mainMenu() {
		
		boolean finished = false;
		int userChoice = 0;
		
		Scanner scanner = new Scanner(System.in); 
		
		System.out.println("");
		System.out.println(PURPLE_TEXT + BLACK_BG + "                                                            ");
		System.out.println(PURPLE_TEXT + BLACK_BG + "                                                            ");
		System.out.println(PURPLE_TEXT + BLACK_BG + "    Welcome to the Quantum Realms Bank Management System    ");
		System.out.println(PURPLE_TEXT + BLACK_BG + "                                                            ");
		System.out.println(PURPLE_TEXT + BLACK_BG + "                                                            ");
		System.out.println("");
		System.out.println("");
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
        			System.out.println("Exiting the program. Goodbye!");
        			System.exit(0);  // Exit the program
        			break;
        		default:
        			System.out.println("Invalid choice. Please select a valid option.");
        			break;
			}
        }
	}
	
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
	
	public PersonalCustomer createPersonalCustomer() {
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|=========================================|");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                         |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Enter the name of the customer: |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                         |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|=========================================|");
		System.out.println("" + RESET);
		String name = sc.nextLine();
		
		System.out.println("");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|===============================================|");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                               |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Enter the address for the customer:   |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                               |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|===============================================|");
		System.out.println("" + RESET);
		String address = sc.nextLine();
		
		System.out.println("");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Enter the primary phone number for the customer:   |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("" + RESET);
		String phone = sc.nextLine();
		
		System.out.println("");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Enter the home phone number for the customer:      |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("" + RESET);
		String homePhone = sc.nextLine();
		
		System.out.println("");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Enter the work phone number for the customer:      |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("" + RESET);
		String workPhone = sc.nextLine();
		
		PersonalCustomer customer = new PersonalCustomer(name, address, phone, homePhone, workPhone);
		
		needAccountForCustomer(customer);
	    customers.add(customer); // Add the new customer to the ArrayList
	    
	    System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|               Customer Created successfully                |");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("" + RESET);
		
		System.out.println(customer);
	    
		return customer;
	}
	
	public CommercialCustomer createCommercialCustomer() {
		Scanner sc = new Scanner(System.in); 
		
		System.out.println(YELLOW_TEXT + BLACK_BG + "|=========================================|");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                         |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Enter the name of the customer: |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                         |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|=========================================|");
		System.out.println("" + RESET);
		String name = sc.nextLine();
		
		System.out.println(YELLOW_TEXT + BLACK_BG + "|===============================================|");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                               |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Enter the address for the customer:   |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                               |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|===============================================|");
		System.out.println("" + RESET);
		String address = sc.nextLine();
		
		System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Enter the primary phone number for the customer:   |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("" + RESET);
		String phone = sc.nextLine();
		
		String prompt = YELLOW_TEXT + BLACK_BG + "|============================================================|\n" +
                "|                                                            |\n" +
                "|  Please Enter the Credit Rating for the customer:          |\n" +
                "|                                                            |\n" +
                "|============================================================|\n" +
                "" + RESET;
	    int creditRating = InputValidator.getValidatedInteger(sc, prompt);
	    sc.nextLine(); // Consume the newline character
		
		System.out.println(YELLOW_TEXT + BLACK_BG + "|===============================================================|");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                               |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Enter the Contact Person for the Commercial Customer  |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                               |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|===============================================================|");
		System.out.println("" + RESET);
		String contactPerson = sc.nextLine();
		
		System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Enter the Contact Person's Phone                   |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|  for the Commercial Customer                               |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("" + RESET);
		String contactPersoPhone = sc.nextLine();
		
		CommercialCustomer customer = new CommercialCustomer(name, address, phone, creditRating, contactPerson, contactPersoPhone);
		
		needAccountForCustomer(customer);
		customers.add(customer); // Add the new customer to the ArrayList
		
		System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|               Customer Created successfully                |");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("" + RESET);
		
		System.out.println(customer);
		
		return customer;
	}
	
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
        			finished = true; // Exit the loop
                    break;
        		default:
        			System.out.println("Invalid choice. Please select a valid option.");
        			break;
			}
        }
	}
	
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
				createCheckingAccount(customer);
				finished = true; // Ensure it returns after creating the account
                break;
			case 2: 
				createSavingsAccount(customer);
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
	
	public CheckingAccount createCheckingAccount(Customer customer) {
		Scanner sc = new Scanner(System.in);
		CheckingAccount newCheckingAccount = new CheckingAccount();
		double inputedBalance = 0.0;
		
		System.out.println("");
		
		while (inputedBalance < newCheckingAccount.getMinimumBalance()) {
			String prompt = YELLOW_TEXT + BLACK_BG + "|====================================================|\n" +
	                "|                                                    |\n" +
	                "|  Please Enter the initial balance of the account   |\n" +
	                "|                                                    |\n" +
	                "|====================================================|\n" +
	                "" + RESET;
			inputedBalance = InputValidator.getValidatedDouble(sc, prompt);
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
	    double balance = inputedBalance;
	    sc.nextLine(); // Consume the newline character

	    Date date = new Date();
	    
	    System.out.println("");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Select the bank branch this account        |");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|  belongs to:                                       |");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|====================================================|");
	    

	    for (int i = 0; i < bankBranches.size(); i++) {
	    	System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                    |");
	        System.out.println(formatLine(YELLOW_TEXT + BLACK_BG + "| " + (i + 1) + ". " + bankBranches.get(i).getBranchName() + " "));
	        System.out.println(formatLine(YELLOW_TEXT + BLACK_BG + "|"));
	        System.out.println(YELLOW_TEXT + BLACK_BG + "|====================================================|");
	        System.out.println("");
	    }
	    int branchChoice = sc.nextInt();
	    sc.nextLine(); // Consume the newline character
	    BankBranch selectedBranch = bankBranches.get(branchChoice - 1);
	    
	    System.out.println("");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Enter the check style for the account:             |");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
	    System.out.println("" + RESET);
	    String checkStyle = sc.nextLine();

	    CheckingAccount newAccount = new CheckingAccount(balance, date, customer, selectedBranch, checkStyle);

	    selectedBranch.addAccount(newAccount);
	    customer.addAccount(newAccount);
	    bankAccounts.add(newAccount);
	    
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
		
	    System.out.println(newAccount);
	    
	    pressAnyKey();

	    return newAccount;
	}
	
	public SavingsAccount createSavingsAccount(Customer customer) {
		Scanner sc = new Scanner(System.in);
		
		String prompt = YELLOW_TEXT + BLACK_BG + "|====================================================|\n" +
                "|                                                    |\n" +
                "|  Please Enter the initail balance of the account   |\n" +
                "|                                                    |\n" +
                "|====================================================|\n" +
                "" + RESET;
	    double balance = InputValidator.getValidatedDouble(sc, prompt);
	    sc.nextLine(); // Consume the newline character
		
		Date date = new Date();
		
		System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|  Please Select the bank branch this account        |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|  belongs to:                                       |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    

	    for (int i = 0; i < bankBranches.size(); i++) {
	    	System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	        System.out.println(formatLine(BLUE_TEXT + BLACK_BG + "| " + (i + 1) + ". " + bankBranches.get(i).getBranchName() + " "));
	        System.out.println(formatLine(BLUE_TEXT + BLACK_BG + "|"));
	        System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    }
	    int branchChoice = sc.nextInt();
	    sc.nextLine(); // Consume the newline character
	    BankBranch selectedBranch = bankBranches.get(branchChoice - 1);
		
		String prompt2 = YELLOW_TEXT + BLACK_BG + "|====================================================|\n" +
                "|                                                    |\n" +
                "|  Please Enter the interest rate for the account    |\n" +
                "|                                                    |\n" +
                "|====================================================|\n" +
                "" + RESET;
	    double interestRate = InputValidator.getValidatedDouble(sc, prompt2);
	    sc.nextLine(); // Consume the newline character
		
		SavingsAccount newAccount = new SavingsAccount(balance, date, customer, selectedBranch, interestRate);
		
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
		
	    System.out.println(newAccount);
	    
	    pressAnyKey();
		
		return newAccount;
	}
	
	public void customerToSearchBy() {
		Scanner sc = new Scanner(System.in);

	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|  Please Enter the Customer Name to Search By       |");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println("" + RESET);
	    
	    String name = sc.nextLine();
	    searchForCustomer(name);
	    
	}
	
	public void searchForCustomer(String name) {
		for (Customer customer : customers) {
			if (customer.getName().equalsIgnoreCase(name)) {
				System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
			    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|                                                    |");
			    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|                  Customer was Found                |");
			    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|                                                    |");
			    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
			    System.out.println("" + RESET);
			    System.out.println("");
			    
			    System.out.println(customer);
			    return;
			}
		}
		
		System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|              Customer was not Found                |");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println("" + RESET);
	}
	
	public void manageAccounts() {
		
		boolean finished = false;
		int userChoice = 0;
		
		Scanner scanner = new Scanner(System.in); 
		
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
	
	public SavingsAccount createSavingsAccount() {
		Scanner sc = new Scanner(System.in);
		
		String prompt = BLUE_TEXT + BLACK_BG + "|====================================================|\n" +
                "|                                                    |\n" +
                "|  Please Enter the initail balance of the account   |\n" +
                "|                                                    |\n" +
                "|====================================================|\n" +
                "" + RESET;
	    double balance = InputValidator.getValidatedDouble(sc, prompt);
	    sc.nextLine(); // Consume the newline character
		
		Date date = new Date();
		
		System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|  Please Select the bank branch this account        |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|  belongs to:                                       |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    

	    for (int i = 0; i < bankBranches.size(); i++) {
	    	System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	        System.out.println(formatLine(BLUE_TEXT + BLACK_BG + "| " + (i + 1) + ". " + bankBranches.get(i).getBranchName() + " "));
	        System.out.println(formatLine(BLUE_TEXT + BLACK_BG + "|"));
	        System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    }
	    int branchChoice = sc.nextInt();
	    sc.nextLine(); // Consume the newline character
	    BankBranch selectedBranch = bankBranches.get(branchChoice - 1);
	    
	    System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|  Please Select the customer for this account:      |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    

	    for (int i = 0; i < customers.size(); i++) {
	    	System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	        System.out.println(formatLine(BLUE_TEXT + BLACK_BG + "| " + (i + 1) + ". " + customers.get(i).getName() + " "));
	        System.out.println(formatLine(BLUE_TEXT + BLACK_BG + "|"));
	        System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    }
	    
	    int customerChoice = sc.nextInt();
	    sc.nextLine(); // Consume the newline character
	    System.out.println("" + RESET);
	    
	    Customer selectedCustomer = customers.get(customerChoice - 1);
		
	    String prompt2 = BLUE_TEXT + BLACK_BG + "|====================================================|\n" +
                "|                                                    |\n" +
                "|  Please Enter the interest rate for the account    |\n" +
                "|                                                    |\n" +
                "|====================================================|\n" +
                "" + RESET;
	    double interestRate = InputValidator.getValidatedDouble(sc, prompt2);
	    sc.nextLine(); // Consume the newline character
		
		SavingsAccount newAccount = new SavingsAccount(balance, date, selectedCustomer, selectedBranch, interestRate);
		
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
		
		System.out.println(newAccount);
		
		pressAnyKey();
		
		return newAccount;
	}
	
	public CheckingAccount createCheckingAccount() {
		Scanner sc = new Scanner(System.in);
		CheckingAccount newCheckingAccount = new CheckingAccount();
		double inputedBalance = 0.0;
		
		System.out.println("");
		
		while (inputedBalance < newCheckingAccount.getMinimumBalance()) {
			String prompt = BLUE_TEXT + BLACK_BG + "|====================================================|\n" +
	                "|                                                    |\n" +
	                "|  Please Enter the initial balance of the account   |\n" +
	                "|                                                    |\n" +
	                "|====================================================|\n" +
	                "" + RESET;
			inputedBalance = InputValidator.getValidatedDouble(sc, prompt);
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

	    Date date = new Date();
	    
	    System.out.println("");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|  Please Select the bank branch this account        |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|  belongs to:                                       |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    

	    for (int i = 0; i < bankBranches.size(); i++) {
	    	System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	        System.out.println(formatLine(BLUE_TEXT + BLACK_BG + "| " + (i + 1) + ". " + bankBranches.get(i).getBranchName() + " "));
	        System.out.println(formatLine(BLUE_TEXT + BLACK_BG + "|"));
	        System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    }
	    
	    System.out.println("");
	    int branchChoice = sc.nextInt();
	    sc.nextLine(); // Consume the newline character
	    BankBranch selectedBranch = bankBranches.get(branchChoice - 1);
	    
	    System.out.println("");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|  Please Select the customer for this account:      |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    

	    for (int i = 0; i < customers.size(); i++) {
	    	System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	        System.out.println(formatLine(BLUE_TEXT + BLACK_BG + "| " + (i + 1) + ". " + customers.get(i).getName() + " "));
	        System.out.println(formatLine(BLUE_TEXT + BLACK_BG + "|"));
	        System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    }
	    
	    System.out.println("");
	    int customerChoice = sc.nextInt();
	    sc.nextLine(); // Consume the newline character
	    Customer selectedCustomer = customers.get(customerChoice - 1);
	    
	    System.out.println("");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|============================================================|");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                            |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|  Please Enter the check style for the account:             |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                            |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|============================================================|");
	    System.out.println("" + RESET);
	    String checkStyle = sc.nextLine();

	    CheckingAccount newAccount = new CheckingAccount(balance, date, selectedCustomer, selectedBranch, checkStyle);

	    selectedBranch.addAccount(newAccount);
	    selectedCustomer.addAccount(newAccount);
	    bankAccounts.add(newAccount);
	    
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
		
	    System.out.println(newAccount);
	    
	    pressAnyKey();

	    return newAccount;
	}
	
	public void searchForAccount() {
		boolean finished = false;
		int userChoice = 0;
		
		Scanner scanner = new Scanner(System.in); 
		
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
	
	public void customerToSearchAccountBy() {
		Scanner sc = new Scanner(System.in);

	    System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(PURPLE_TEXT + BLACK_BG + "|  Please Enter the Customer Name to Search By       |");
	    System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println("" + RESET);
	    
	    String name = sc.nextLine();
	    searchForAccountByCustomer(name);
	    
	}
	
	public void accNumberToSearchAccountBy() {
		Scanner sc = new Scanner(System.in);
		
		String prompt = BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|\n" +
                "|                                                    |\n" +
                "|  Please Enter the Account number to Search By      |\n" +
                "|                                                    |\n" +
                "|====================================================|\n" +
                "" + RESET;
		
		int accNumber = InputValidator.getValidatedInteger(sc, prompt);
		searchForAccountByAccNumber(accNumber);
		
	}
	
	public void searchForAccountByCustomer(String name) {
		boolean found = false;
	    
	    for (Account account : bankAccounts) {
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
		
	public void searchForAccountByAccNumber(int accNumber) {
		for (Account account : bankAccounts) {
			if (account.getAccountNumber() == accNumber) {
				System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
				System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
				System.out.println(PURPLE_TEXT + BLACK_BG + "|         	Customer Account was Found                |");
				System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
				System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
				System.out.println("" + RESET);
				System.out.println("");
					
				System.out.println(account);
				return;
			}
		}
		
		System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(PURPLE_TEXT + BLACK_BG + "|      Customer Account was not Found                |");
	    System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println("" + RESET);
	    
	    pressAnyKey();
	    searchForAccount();
	}
	
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
	
	public void customerToSearchAccountByForDepOrWith() {
		Scanner sc = new Scanner(System.in);

	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|  Please Enter the Customer Name to Search By       |");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println("" + RESET);
	    
	    String name = sc.nextLine();
	    AccNumberToMakeDepositOrWith(name);
	    
	}
	
	public void accNumberToSearchAccountByForDepOrWith() {
		Scanner sc = new Scanner(System.in);
		
		
		
		String prompt = BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|\n" +
                "|                                                    |\n" +
                "|  Please Enter the Account number to Search By      |\n" +
                "|                                                    |\n" +
                "|====================================================|\n" +
                "" + RESET;
		int accNumber = InputValidator.getValidatedInteger(sc, prompt);
		
		accNumberToMakeDepositOrWith(accNumber);
		
	}
	
	public void accNumberToMakeDepositOrWith(int accNumber) {
		for (Account account : bankAccounts) {
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
		
		System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|              Customer was not Found                |");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println("" + RESET);
	}
	
	public void AccNumberToMakeDepositOrWith(String name) {
		boolean customerFound = false; 
		ArrayList<Account> customerAccounts = new ArrayList<>();
		
		for (Account account : bankAccounts) {
			if (account.getAccountOwner().getName().equalsIgnoreCase(name)) {
				customerAccounts.add(account);
				customerFound = true;
			}
		}
		if (customerFound) {
			System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|             Customer Account was Found             |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
			System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
			System.out.println("" + RESET);
			System.out.println("");
			
			boolean finished = false;
			
			Scanner scanner = new Scanner(System.in); 
			
			while (finished == false) {
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
	            
	            Account selectedAccount = customerAccounts.get(accountChoice);
	            System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
	            System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
	            System.out.println(PURPLE_TEXT + BLACK_BG + "|     Selected Account Number: " + selectedAccount.getAccountNumber() + "             |");
	            System.out.println(PURPLE_TEXT + BLACK_BG + "|                                                    |");
	            System.out.println(PURPLE_TEXT + BLACK_BG + "|====================================================|");
	            System.out.println("" + RESET);
	            
	            accountToMakeDepositOrWith(selectedAccount);

			}
		}
		
		System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|              Customer was not Found                |");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println("" + RESET);
	}
	
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

	
	public void makeADeposit(Account account) {
		Scanner sc = new Scanner(System.in);
		
		String prompt = BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|\n" +
                "|                                                    |\n" +
                "|  Please Enter the amount of the deposit for the    |\n" +
                "|  account:                                          |\n" +
                "|                                                    |\n" +
                "|====================================================|\n" +
                "" + RESET;
	    double deposit = InputValidator.getValidatedDouble(sc, prompt);
	    sc.nextLine(); // Consume the newline character
		
		account.makeDeposit(deposit);
		
		System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
		System.out.println(formatLine(BRIGHTCYAN_TEXT + BLACK_BG + "|"));
		System.out.println(formatLine(BRIGHTCYAN_TEXT + BLACK_BG + "| New Balance for the account: $" + account.getBalance()));
		System.out.println(formatLine(BRIGHTCYAN_TEXT + BLACK_BG + "|"));
		System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
		System.out.println("" + RESET);
		
		return;
		
	}
	
	public void makeAWithdrawal(Account account) {
		Scanner sc = new Scanner(System.in);
		
		String prompt = BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|\n" +
                "|                                                    |\n" +
                "|  Please Enter the amount of the withdrawal for     |\n" +
                "|  the account:                                      |\n" +
                "|                                                    |\n" +
                "|====================================================|\n" +
                "" + RESET;
	    double withdrawal = InputValidator.getValidatedDouble(sc, prompt);
	    sc.nextLine(); // Consume the newline character
		
		double initialBalance = account.getBalance();
		
		account.makeWithdrawal(withdrawal);
	
		if (account.getBalance() < initialBalance) {
			System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
			System.out.println(formatLine(BRIGHTCYAN_TEXT + BLACK_BG + "|"));
			System.out.println(formatLine(BRIGHTCYAN_TEXT + BLACK_BG + "| New Balance for the account: $" + account.getBalance()));
			System.out.println(formatLine(BRIGHTCYAN_TEXT + BLACK_BG + "|"));
			System.out.println(BRIGHTCYAN_TEXT + BLACK_BG + "|====================================================|");
			System.out.println("" + RESET);
			
		}
		else {
			pressAnyKey();
			accountToMakeDepositOrWith(account);
		}
		
		return;
		
	}
	
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
	
	public void accNumberForInteresr() {
		Scanner sc = new Scanner(System.in);
		
		String prompt = BLUE_TEXT + WHITE_BG + "|====================================================|\n" +
                							   "|                                                    |\n" +
                							   "|  Please Enter the Account number to Search By      |\n" +
                							   "|                                                    |\n" +
                							   "|====================================================|\n" +
                							   "" + RESET;
		
		int accNumber = InputValidator.getValidatedInteger(sc, prompt);
		
		interestCalculation(accNumber);
	}
	
	public void interestCalculation(int accountNumber) {
		
		boolean accountFound = false;
		double interestAmount = 0.0;
		
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
	
	public void nameforInterestCalcualtion() {
		Scanner sc = new Scanner(System.in);

	    System.out.println(BLUE_TEXT + WHITE_BG + "|====================================================|");
	    System.out.println(BLUE_TEXT + WHITE_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + WHITE_BG + "|  Please Enter the Customer Name to Search By       |");
	    System.out.println(BLUE_TEXT + WHITE_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + WHITE_BG + "|====================================================|");
	    System.out.println("" + RESET);
	    
	    String name = sc.nextLine();
	    
	    findAccountsForInterest(name);
	    sc.close();
	}
	
	public void findAccountsForInterest(String name) {
		boolean customerFound = false; 
		ArrayList<Account> accountsForInterest = new ArrayList<>();
		
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
	
	public void selectionOfAccount(ArrayList<Account> accountsForInterest) {
		
		ArrayList<SavingsAccount> savingsAccountsForInterest = new ArrayList<>();
		
		boolean finished = false;
		
		Scanner scanner = new Scanner(System.in); 
		
		for (Account account : accountsForInterest) {
			if (account instanceof SavingsAccount) {
				SavingsAccount savingsAccount = (SavingsAccount) account; 
				savingsAccountsForInterest.add(savingsAccount);	
			}		
		} 
		
		if (savingsAccountsForInterest.isEmpty()) {
	        System.out.println(BLUE_TEXT + WHITE_BG + "|====================================================|");
	        System.out.println(BLUE_TEXT + WHITE_BG + "|                                                    |");
	        System.out.println(BLUE_TEXT + WHITE_BG + "|       No Savings Accounts found for the customer   |");
	        System.out.println(BLUE_TEXT + WHITE_BG + "|                                                    |");
	        System.out.println(BLUE_TEXT + WHITE_BG + "|====================================================|");
	        System.out.println("" + RESET);
	        scanner.close();
	        return;
	    }
			
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
            
            if (accountChoice == savingsAccountsForInterest.size()) {
                finished = true;
                manageAccounts();
                break;
            }
            SavingsAccount selectedAccount = savingsAccountsForInterest.get(accountChoice);
            
            calculationOfInterest(selectedAccount);
		}
		scanner.close();
	}
	
	public void calculationOfInterest(SavingsAccount account) {
		
		double interestAmount = account.calculateInterest();
		
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
        
        System.out.println("");
        System.out.println(RED_TEXT + WHITE_BG + "|====================================================|");
        System.out.println(RED_TEXT + WHITE_BG + "|                                                    |");
        System.out.println(RED_TEXT + WHITE_BG + "|   Please Enter the Name of the new Branch          |");
        System.out.println(RED_TEXT + WHITE_BG + "|                                                    |");
        System.out.println(RED_TEXT + WHITE_BG + "|====================================================|");
        System.out.println("");
        
        String branchName = sc.nextLine();
        
        System.out.println("");
        System.out.println(RED_TEXT + WHITE_BG + "|====================================================|");
        System.out.println(RED_TEXT + WHITE_BG + "|                                                    |");
        System.out.println(RED_TEXT + WHITE_BG + "|   Please Enter the address for the new Branch      |");
        System.out.println(RED_TEXT + WHITE_BG + "|                                                    |");
        System.out.println(RED_TEXT + WHITE_BG + "|====================================================|");
        System.out.println("");
        
        String address = sc.nextLine();
        
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
	
	public void displayCustomers() {
		System.out.println("\nDisplaying All Customers:");
        System.out.println("====================\n");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
	}
        
    public void displayAccounts() {
        	System.out.println("\nDisplaying All Accounts:");
        	System.out.println("====================\n");
        	for (Account account : bankAccounts) {
        		System.out.println(account);
        	}
    }
    public void displayBankBranches() {
    	System.out.println("\nDisplaying All Banks:");
    	System.out.println("====================\n");
    	for (BankBranch branch : bankBranches) {
    		System.out.println(branch);
    	}
    }
    
    public void pressAnyKey() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please Press any key to continue");
		sc.nextLine();
	}
    
    private String formatLine(String content) {
	    int LINE_WIDTH = 62; // Adjust the width as needed
	    return String.format("%-" + LINE_WIDTH + "s |", content);
	}
}
