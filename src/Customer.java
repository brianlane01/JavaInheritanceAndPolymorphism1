import java.util.ArrayList;

public class Customer {
	
	//Instance variables or attributes
	private String name;
	private String address;
	private String phone;
	private ArrayList<Account> customerAccounts; 
	
	
	String GREEN_TEXT = "\u001B[32m";
	String BLACK_BG = "\u001B[40m";
	String RESET = "\u001B[0m";
	
	//default constructor
	public Customer () {
		this.name = "";
		this.address = "";
		this.phone = "";
		this.setCustomerAccounts(null); 
	}
	
	public Customer(String name, String address, String phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.setCustomerAccounts(new ArrayList<>());
	}

	public void addAccount(Account account) {
        getCustomerAccounts().add(account);
        account.setAccountOwner(this);
    }
	
	public ArrayList<Account> getCustomerAccounts() {
		return customerAccounts;
	}

	public void setCustomerAccounts(ArrayList<Account> customerAccounts) {
		this.customerAccounts = customerAccounts;
	}
	
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	} 
	
	@Override
	public String toString() {
	    StringBuilder output = new StringBuilder();
	    
	    output.append(GREEN_TEXT).append(BLACK_BG);
	    
	    output.append("|-----------------------------------------------|");
	    output.append("\n");
	    output.append(formatLine("|                                          "));
	    output.append("\n");
	    output.append(formatLine("|             Customer Information"));
	    output.append("\n");
	    output.append(formatLine("|                                          "));
	    output.append("\n");
	    
	    if (this instanceof PersonalCustomer) {
	        PersonalCustomer personalCustomer = (PersonalCustomer) this;
	        output.append(formatLine("|         This is a " + personalCustomer.getTypeOfCustomer() + " Customer"));
	        output.append("\n");
	    } else if (this instanceof CommercialCustomer) {
	        CommercialCustomer commercialCustomer = (CommercialCustomer) this;
	        output.append(formatLine("|         This is a " + commercialCustomer.getTypeOfCustomer() + " Customer"));
	        output.append("\n");
	    }
	    
	    output.append(formatLine("|                                          "));
	    output.append("\n");
	    output.append("|-----------------------------------------------|");
	    output.append("\n");
	    output.append(formatLine("|                                          "));
	    output.append("\n");
	    output.append(formatLine("|   Name: " + this.name));
	    output.append("\n");
	    output.append(formatLine("|   Address: " + this.address));
	    output.append("\n");
	    output.append(formatLine("|   Phone: " + this.phone));
	    output.append("\n");

	    if (this instanceof PersonalCustomer) {
	        PersonalCustomer personalCustomer = (PersonalCustomer) this;
	        output.append(formatLine("|   Home Phone: " + personalCustomer.getHomePhone()));
	        output.append("\n");
	        output.append(formatLine("|   Work Phone: " + personalCustomer.getWorkPhone()));
	        output.append("\n");
	    } else if (this instanceof CommercialCustomer) {
	        CommercialCustomer commercialCustomer = (CommercialCustomer) this;
	        output.append(formatLine("|   Credit Rating: " + commercialCustomer.getCreditRating()));
	        output.append("\n");
	        output.append(formatLine("|   Contact Person: " + commercialCustomer.getContactPerson()));
	        output.append("\n");
	        output.append(formatLine("|   Contact Person Phone: " + commercialCustomer.getContactPersonPhone()));
	        output.append("\n");
	    }

	    output.append("|                                               |");
	    output.append("\n");
	    output.append("|-----------------------------------------------|");
	    output.append("\n");
	    output.append("|                                               |");
	    output.append("\n");
	    output.append(formatLine("|        Accounts for " + this.getName()));
	    output.append("\n");
	    output.append("|                                               |");
	    output.append("\n");
	    output.append("|-----------------------------------------------|");
	    output.append("\n");
	    
	    for (Account account : customerAccounts) {
	    	output.append("|                                               |");
		    output.append("\n");
	        output.append(formatLine("|    Account Number: " + account.getAccountNumber()));
	        output.append("\n");
	        output.append(formatLine("|    Balance: $" + String.format("%.2f", account.getBalance())));
	        output.append("\n");
	        output.append(formatLine("|    Date Opened: " + account.getDateOpened()));
	        output.append("\n");
	        output.append(formatLine("|    Branch: " + (account.getBranchName() != null ? account.getBranchName().getBranchName() : "N/A")));
	        output.append("\n");

	        if (account instanceof SavingsAccount) {
	            SavingsAccount savings = (SavingsAccount) account;
	            output.append(formatLine("|    Type of Account: " + savings.getTypeOfAccount()));
	            output.append("\n");
	            output.append(formatLine("|    Interest Rate: " + String.format("%.2f%%", savings.getInterestRate())));
	            output.append("\n");
	        } else if (account instanceof CheckingAccount) {
	            CheckingAccount checking = (CheckingAccount) account;
	            output.append(formatLine("|    Type of Account: " + checking.getTypeOfAccount()));
	            output.append("\n");
	            output.append(formatLine("|    Check Style: " + checking.getCheckStyle()));
	            output.append("\n");
	            output.append(formatLine("|    Minimum Balance: $" + String.format("%.2f", (double) checking.getMinimumBalance())));
	            output.append("\n");
	            
	        }
	        output.append(formatLine("|                                              "));
	        output.append("\n");
	        output.append("|-----------------------------------------------|");
	        output.append("\n");
	    }
	    
	    output.append(RESET); // Reset to default formatting
	    
	    return output.toString();
	}

	private String formatLine(String content) {
	    int LINE_WIDTH = 47; // Adjust the width as needed
	    return String.format("%-" + LINE_WIDTH + "s |", content);
	}
	
}
