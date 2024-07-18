import java.util.Date;
import java.util.Random;

public class Account {
	
	//Instance Variables: Represent the properties of the object
	//Private data fields- Accessibility modifiers limit what can see what 
	private int accountNumber;
	    
	// Account balance
	private double balance;
	
	// Date when the account was created
	private Date dateOpened;
	
	private Customer accountOwner;
	
	private BankBranch branchName;
	
	String BLUE_TEXT = "\u001B[34m";
	String BLACK_BG = "\u001B[40m";
	String RESET = "\u001B[0m";
	
	public Account( ) {
		this.accountNumber = 0; 
		this.balance = 0.0d;
		this.dateOpened = new Date();
		this.accountOwner = null; 
		this.branchName = null;
	}
	
	public Account(double balance, Date dateOpened, Customer accountOwner, BankBranch branchName) {
		
		this.accountNumber = generateAccountNumber();
		this.balance = balance; 
		this.dateOpened = new Date(); 
		this.accountOwner = accountOwner;
		this.branchName = branchName; 
	}
	
	public int generateAccountNumber() {
		Random random = new Random();
		
		int accountNumber;
		
		do {
			accountNumber = random.nextInt(1000000000);
		}
		while (String.valueOf(accountNumber).length() > 10);
		
		return accountNumber; 
		
	}

	/**
	 * @return the accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @return the dateOpened
	 */
	public Date getDateOpened() {
		return dateOpened;
	}

	/**
	 * @return the accountOwner
	 */
	public Customer getAccountOwner() {
		return accountOwner;
	}

	/**
	 * @return the branchName
	 */
	public BankBranch getBranchName() {
		return branchName;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @param dateOpened the dateOpened to set
	 */
	public void setDateOpened(Date dateOpened) {
		this.dateOpened = dateOpened;
	}

	/**
	 * @param accountOwner the accountOwner to set
	 */
	public void setAccountOwner(Customer accountOwner) {
		this.accountOwner = accountOwner;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(BankBranch branchName) {
		this.branchName = branchName;
	}
	
	public void makeDeposit(double amount) {
		 balance += amount; 
	}
	
	public void makeWithdrawal(double amount ) {
		if(balance >= amount) {
			balance -= amount; 
		}
		else {
			System.out.println("Insufficient funds to meet withdrawal amount of $" + amount);
		}
	}
	
	@Override
    public String toString() {
		StringBuilder output = new StringBuilder();
		
		output.append(BLUE_TEXT).append(BLACK_BG);
		
        output.append("|-----------------------------------------------|\n");
        output.append(formatLine("|                                          "));
	    output.append("\n");
	    output.append(formatLine("|           Account Information"));
	    output.append("\n");
	    output.append(formatLine("|                                          "));
	    output.append("\n");
	    if (this instanceof SavingsAccount) {
            SavingsAccount savings = (SavingsAccount) this;
            output.append(formatLine("|        Type of Account: " + savings.getTypeOfAccount()));
            output.append("\n");
        } else if (this instanceof CheckingAccount) {
            CheckingAccount checking = (CheckingAccount) this;
            output.append(formatLine("|        Type of Account: " + checking.getTypeOfAccount()));
            output.append("\n");   
        }
	    
	    output.append(formatLine("|                                          "));
	    output.append("\n");
	    output.append("|-----------------------------------------------|");
	    output.append("\n");
	    output.append(formatLine("|                                          "));
	    output.append("\n");
	    output.append(formatLine("|    Account Owner: " + (this.getAccountOwner() != null ? this.getAccountOwner().getName() : "N/A")));
        output.append("\n");
        
	    output.append(formatLine("|    Account Number: " + this.getAccountNumber()));
        output.append("\n");
        output.append(formatLine("|    Balance: $" + String.format("%.2f", this.getBalance())));
        output.append("\n");
        output.append(formatLine("|    Date Opened: " + this.getDateOpened()));
        output.append("\n");
        output.append(formatLine("|    Branch: " + (this.getBranchName() != null ? this.getBranchName().getBranchName() : "N/A")));
        output.append("\n");
	    
        if (this instanceof SavingsAccount) {
            SavingsAccount savings = (SavingsAccount) this;
            output.append(formatLine("|    Interest Rate: " + String.format("%.2f%%", savings.getInterestRate())));
            output.append("\n");
            output.append(formatLine("|                                          "));
    	    output.append("\n");
    	    output.append("|-----------------------------------------------|");
    	    output.append("\n");
        } else if (this instanceof CheckingAccount) {
            CheckingAccount checking = (CheckingAccount) this;
            output.append(formatLine("|    Check Style: " + checking.getCheckStyle()));
            output.append("\n");
            output.append(formatLine("|    Minimum Balance: $" + String.format("%.2f", (double) checking.getMinimumBalance())));
            output.append("\n"); 
            output.append(formatLine("|                                          "));
    	    output.append("\n");
    	    output.append("|-----------------------------------------------|");
    	    output.append("\n");
        }
       
        output.append(RESET);
        
        return output.toString();
	}
	
	private String formatLine(String content) {
	    int LINE_WIDTH = 47; // Adjust the width as needed
	    return String.format("%-" + LINE_WIDTH + "s |", content);
	}
}
