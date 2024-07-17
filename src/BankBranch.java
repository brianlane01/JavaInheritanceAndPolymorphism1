import java.util.ArrayList; 

public class BankBranch {
	
	private String branchName;
	
	private String branchAddress; 
	
	private ArrayList<Account> branchAccounts;  
	
	public BankBranch(String branchName, String branchAddress) {
        this.branchName = branchName;
        this.branchAddress = branchAddress;
        this.branchAccounts = new ArrayList<>();  // Initialize the accounts list
    }
	
	public void addAccount(Account account) {
        branchAccounts.add(account);
        account.setBranchName(this);
    }

	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @return the branchAddress
	 */
	public String getBranchAddress() {
		return branchAddress;
	}

	/**
	 * @return the branchAccounts
	 */
	public ArrayList<Account> getBranchAccounts() {
		return branchAccounts;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * @param branchAddress the branchAddress to set
	 */
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	/**
	 * @param branchAccounts the branchAccounts to set
	 */
	public void setBranchAccounts(ArrayList<Account> branchAccounts) {
		this.branchAccounts = branchAccounts;
	}
	
	@Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("----------------------------------\n");
        output.append("Branch Information\n");
        output.append("----------------------------------\n");
        output.append("Branch Name: ").append(this.branchName).append("\n");
        output.append("Branch Address: ").append(this.branchAddress).append("\n");
        output.append("Accounts:\n");

        for (Account account : branchAccounts) {
            output.append(account.toString()).append("\n");
        }

        output.append("----------------------------------");
        return output.toString();
    }
	
}

