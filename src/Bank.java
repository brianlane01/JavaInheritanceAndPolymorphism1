import java.util.ArrayList; 
import java.util.Scanner;
import java.util.Date;

public class Bank {
	public void Run() {
		System.out.println("Running the Program.");
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		ArrayList<BankBranch> bankBranches = new ArrayList<BankBranch>();
		ArrayList<Account> bankAccounts = new ArrayList<Account>();
		
		BankBranch branch1 = new BankBranch("Chicago Branch", "123 Lakeside Drive, Chicago, IL 60601");
		BankBranch branch2 = new BankBranch("Gotham City Branch", "123 Wayne Avenue, Gotham City");
		BankBranch branch3 = new BankBranch("Metropolis Branch", "456 Daily Planet Plaza, Metropolis");
		BankBranch branch4 = new BankBranch("Central City Branch", "4789 Keystone Road, Central City");
		BankBranch branch5 = new BankBranch("Coast City Branch", "654 Lantern Lane, Coast City");
		BankBranch branch6 = new BankBranch("Asgard Branch", "789 Bifrost Boulevard, Asgard");
		BankBranch branch7 = new BankBranch("Latveria Branch", "654 Doom Street, Doomstadt, Latveria");
		
		
		PersonalCustomer customer1 = new PersonalCustomer("Barry Allen", "1234 Fast Lane", "555-345-6789", "555-123-4567", "555-234-5678");
		Customer customer2 = new Customer("Rachel Roth", "5678 Shadow Lane", "555-456-7890");
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
		SavingsAccount account8 = new SavingsAccount(7890.00, new Date(), customer1, branch4, 6.3);
		SavingsAccount account9 = new SavingsAccount(5890.00, new Date(), customer2, branch5, 5.8);
		SavingsAccount account10 = new SavingsAccount(345587757890.00, new Date(), customer3, branch2, 8.3);
		SavingsAccount account11 = new SavingsAccount(577758857890.00, new Date(), customer4, branch7, 3.3);
		SavingsAccount account12 = new SavingsAccount(88890.00, new Date(), customer5, branch1, 6.3);
		SavingsAccount account13 = new SavingsAccount(17890.00, new Date(), customer6, branch3, 6.3);
		SavingsAccount account14 = new SavingsAccount(10890.00, new Date(), customer7, branch1, 6.3);
		
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
		
		System.out.println(customer1);
		System.out.println(customer6);
		
		System.out.println(branch1);
		
	}
}
