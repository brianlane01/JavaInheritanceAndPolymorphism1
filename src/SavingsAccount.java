import java.util.Date;

public class SavingsAccount extends Account {
	
	private String typeOfAccount; 
	private double interestRate;
	
	public SavingsAccount() {
		super(); 
		this.typeOfAccount = "SAVINGS";
		this.interestRate = 0.0d;
	}

	/**
	 * @param balance
	 * @param dateOpened
	 * @param accountOwner
	 * @param branchName
	 */
	public SavingsAccount(double balance, Date dateOpened, Customer accountOwner, BankBranch branchName, double interestRate) {
		super(balance, dateOpened, accountOwner, branchName);
		this.typeOfAccount = "SAVINGS";
		this.interestRate = interestRate;
	}

	/**
	 * @return the typeOfAccount
	 */
	public String getTypeOfAccount() {
		return typeOfAccount;
	}

	/**
	 * @return the interestRate
	 */
	public double getInterestRate() {
		return interestRate;
	}
	
	/**
	 * @param typeOfAccount the typeOfAccount to set
	 */
	public void setTypeOfAccount(String typeOfAccount) {
		this.typeOfAccount = typeOfAccount;
	}

	/**
	 * @param interestRate the interestRate to set
	 */
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public double calculateInterest () {
		return getBalance() * (interestRate / 100); 
	}
	
	/*
	 * 
	 
	public String toString() {
        String output = super.toString();
        output += "\nType of Account: " + this.typeOfAccount;
        output += "\nInterest Rate for " + this.typeOfAccount + "Account is: "+ String.format("%.2f%%", interestRate * 100);
        output += "\n-------------------------------------------------";
        return output;
    }
    */
	
}
