import java.util.Date;

public class CheckingAccount extends Account {
	
	private String typeOfAccount; 
	
	private String checkStyle;
	
	private int minimumBalance; 
	
	public CheckingAccount() {
		super();
		this.typeOfAccount = "CHECKING";
		this.checkStyle = "";
		this.minimumBalance = 500;
	}

	/**
	 * @param balance
	 * @param dateOpened
	 * @param accountOwner
	 * @param branchName
	 */
	public CheckingAccount(double balance, Date dateOpened, Customer accountOwner, BankBranch branchName, String checkStyle) {
		super(balance, dateOpened, accountOwner, branchName);
		this.typeOfAccount = "CHECKING";
		this.checkStyle = checkStyle;
		this.minimumBalance = 500; 
	}

	/**
	 * @return the typeOfAccount
	 */
	public String getTypeOfAccount() {
		return typeOfAccount;
	}

	/**
	 * @return the checkStyle
	 */
	public String getCheckStyle() {
		return checkStyle;
	}

	/**
	 * @return the minimumBalance
	 */
	public int getMinimumBalance() {
		return minimumBalance;
	}

	/**
	 * @param typeOfAccount the typeOfAccount to set
	 */
	public void setTypeOfAccount(String typeOfAccount) {
		this.typeOfAccount = typeOfAccount;
	}

	/**
	 * @param checkStyle the checkStyle to set
	 */
	public void setCheckStyle(String checkStyle) {
		this.checkStyle = checkStyle;
	}

	/**
	 * @param minimumBalance the minimumBalance to set
	 */
	public void setMinimumBalance(int minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	
	@Override
	public String toString() {
        String output = super.toString();
        output += "\nType of Account: " + this.typeOfAccount;
        output += "\nCheck Style: " + this.checkStyle;
        output += "\nA " + this.typeOfAccount + " Account requires you to have a minimum balance";
        output += "\n Currently the Minimum Balance is: $" + String.format("%.2f", (double)this.minimumBalance);
        output += "\n----------------------------------------------------";
        return output;
    }
	
}
