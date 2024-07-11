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
        String output = "----------------------------------\n";
        output += "Account Information\n";
        output += "----------------------------------\n";
        output += "Account Number: " + this.accountNumber + "\n";
        output += "Balance: $" + String.format("%.2f", this.balance) + "\n";
        output += "Date Opened: " + this.dateOpened + "\n";
        output += "Branch: " + (branchName != null ? branchName.getBranchName() : "N/A") + "\n";
        output += "Customer: " + (accountOwner != null ? accountOwner.getName() : "N/A") + "\n";
        output += "----------------------------------";
       
        return output;
	}
}
