import java.util.ArrayList; 
import java.util.Arrays;
import java.util.Scanner;
import java.util.Date;

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
        			displayBankBranches();
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
        			break;
        		case 2: 
        			createCommercialCustomer();
        			pressAnyKey();
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
		
		System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Enter the home phone number for the customer:      |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("" + RESET);
		String homePhone = sc.nextLine();
		
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
		
		pressAnyKey();
	    
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
		
		System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Enter the Credit Rating for the customer:          |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("" + RESET);
		int creditRating = sc.nextInt();
		sc.nextLine();
		
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
		
		pressAnyKey();
		
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

	    System.out.println(YELLOW_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Enter the initial balance of the account:  |");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println("" + RESET);
	    double balance = sc.nextDouble();
	    sc.nextLine(); // Consume the newline character

	    Date date = new Date();

	    System.out.println(YELLOW_TEXT + BLACK_BG + "|==========================================================|");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                          |");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Select the bank branch this account belongs to:  |");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                          |");
	    System.out.println(YELLOW_TEXT + BLACK_BG + "|==========================================================|");
	    System.out.println("" + RESET);

	    for (int i = 0; i < bankBranches.size(); i++) {
	        System.out.println(YELLOW_TEXT + BLACK_BG + (i + 1) + ". " + bankBranches.get(i).getBranchName() + RESET);
	    }
	    int branchChoice = sc.nextInt();
	    sc.nextLine(); // Consume the newline character
	    BankBranch selectedBranch = bankBranches.get(branchChoice - 1);

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

	    System.out.println(GREEN_TEXT + "New checking account created successfully!" + RESET);
	    System.out.println(newAccount);

	    return newAccount;
	}
	
	public SavingsAccount createSavingsAccount(Customer customer) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(YELLOW_TEXT + BLACK_BG + "|====================================================|");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                    |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Enter the initial balance of the account:  |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                    |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|====================================================|");
		System.out.println("" + RESET);
		double balance = sc.nextDouble();
		sc.nextLine(); // Consume the newline character
		
		Date date = new Date();
		
		System.out.println(YELLOW_TEXT + BLACK_BG + "|==========================================================|");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                          |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Select the bank branch this account belongs to:  |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                          |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|==========================================================|");
		System.out.println("" + RESET);
		
		for (int i = 0; i < bankBranches.size(); i++) {
			System.out.println(YELLOW_TEXT + BLACK_BG + (i + 1) + ". " + bankBranches.get(i).getBranchName() + RESET);
		}
		int branchChoice = sc.nextInt();
		sc.nextLine(); // Consume the newline character
		BankBranch selectedBranch = bankBranches.get(branchChoice - 1);
		
		System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|  Please Enter the interest rate for the account:           |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(YELLOW_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("" + RESET);
		double interestRate = sc.nextDouble();
		sc.nextLine();
		
		SavingsAccount newAccount = new SavingsAccount(balance, date, customer, selectedBranch, interestRate);
		
		selectedBranch.addAccount(newAccount);
		customer.addAccount(newAccount);
		bankAccounts.add(newAccount);
		
		System.out.println(GREEN_TEXT + "New checking account created successfully!" + RESET);
		System.out.println(newAccount);
		
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
			System.out.println(BLUE_TEXT + BLACK_BG + "|    Please Make a Selection (1-4):       |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "| 1. Create New Account                   |");
			System.out.println(BLUE_TEXT + BLACK_BG + "| 2. Display All Accounts                 |");
			System.out.println(BLUE_TEXT + BLACK_BG + "| 3. Search For Customer                  |");
			System.out.println(BLUE_TEXT + BLACK_BG + "| 4. Return to Main Menu                  |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|                                         |");
			System.out.println(BLUE_TEXT + BLACK_BG + "|=========================================|");
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
        			needCustomerForAccount();
        			break;
        		case 2: 
        			displayAccounts();
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
		
		System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
		System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
		System.out.println(BLUE_TEXT + BLACK_BG + "|  Please Enter the initial balance of the account:  |");
		System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
		System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
		System.out.println("" + RESET);
		double balance = sc.nextDouble();
		sc.nextLine(); // Consume the newline character
		
		Date date = new Date();
		
		System.out.println(BLUE_TEXT + BLACK_BG + "|==========================================================|");
		System.out.println(BLUE_TEXT + BLACK_BG + "|                                                          |");
		System.out.println(BLUE_TEXT + BLACK_BG + "|  Please Select the bank branch this account belongs to:  |");
		System.out.println(BLUE_TEXT + BLACK_BG + "|                                                          |");
		System.out.println(BLUE_TEXT + BLACK_BG + "|==========================================================|");
		System.out.println("" + RESET);
		
		for (int i = 0; i < bankBranches.size(); i++) {
			System.out.println(BLUE_TEXT + BLACK_BG + (i + 1) + ". " + bankBranches.get(i).getBranchName() + RESET);
		}
		int branchChoice = sc.nextInt();
		sc.nextLine(); // Consume the newline character
		BankBranch selectedBranch = bankBranches.get(branchChoice - 1);
		
		System.out.println(BLUE_TEXT + BLACK_BG + "|============================================================|");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                            |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|  Please Select the customer for this account:              |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                            |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|============================================================|");
	    System.out.println("" + RESET);

	    for (int i = 0; i < customers.size(); i++) {
	        System.out.println(BLUE_TEXT + BLACK_BG + (i + 1) + ". " + customers.get(i).getName() + RESET);
	    }
	    int customerChoice = sc.nextInt();
	    sc.nextLine(); // Consume the newline character
	    Customer selectedCustomer = customers.get(customerChoice - 1);
		
		System.out.println(BLUE_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(BLUE_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(BLUE_TEXT + BLACK_BG + "|  Please Enter the interest rate for the account:           |");
		System.out.println(BLUE_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(BLUE_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("" + RESET);
		double interestRate = sc.nextDouble();
		sc.nextLine();
		
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
		
		System.out.println(newAccount);
		
		return newAccount;
	}
	
	public CheckingAccount createCheckingAccount() {
		Scanner sc = new Scanner(System.in);

	    System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|  Please Enter the initial balance of the account:  |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                    |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|====================================================|");
	    System.out.println("" + RESET);
	    double balance = sc.nextDouble();
	    sc.nextLine(); // Consume the newline character

	    Date date = new Date();

	    System.out.println(BLUE_TEXT + BLACK_BG + "|==========================================================|");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                          |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|  Please Select the bank branch this account belongs to:  |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                          |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|==========================================================|");
	    System.out.println("" + RESET);

	    for (int i = 0; i < bankBranches.size(); i++) {
	        System.out.println(BLUE_TEXT + BLACK_BG + (i + 1) + ". " + bankBranches.get(i).getBranchName() + RESET);
	    }
	    int branchChoice = sc.nextInt();
	    sc.nextLine(); // Consume the newline character
	    BankBranch selectedBranch = bankBranches.get(branchChoice - 1);
	    
	    System.out.println(BLUE_TEXT + BLACK_BG + "|============================================================|");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                            |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|  Please Select the customer for this account:              |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|                                                            |");
	    System.out.println(BLUE_TEXT + BLACK_BG + "|============================================================|");
	    System.out.println("" + RESET);

	    for (int i = 0; i < customers.size(); i++) {
	        System.out.println(BLUE_TEXT + BLACK_BG + (i + 1) + ". " + customers.get(i).getName() + RESET);
	    }
	    int customerChoice = sc.nextInt();
	    sc.nextLine(); // Consume the newline character
	    Customer selectedCustomer = customers.get(customerChoice - 1);

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

	    System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|               Account Created successfully                 |");
		System.out.println(RED_TEXT + BLACK_BG + "|                                                            |");
		System.out.println(RED_TEXT + BLACK_BG + "|============================================================|");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	    System.out.println(newAccount);

	    return newAccount;
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
}
