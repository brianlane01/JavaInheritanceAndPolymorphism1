import java.util.ArrayList; 

public class BankBranch {
	
	private String branchName;
	
	private String branchAddress; 
	
	private ArrayList<Account> branchAccounts;  
	
	String RED_TEXT = "\u001B[31m";
	String BLACK_BG = "\u001B[40m";
	String RESET = "\u001B[0m";
	
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
        
        output.append(RED_TEXT).append(BLACK_BG);
        
        output.append("|--------------------------------------------------------------------|\n");
        output.append(formatLine("|                                          "));
	    output.append("\n");
	    output.append(formatLine("|           Branch Information"));
	    output.append("\n");
	    output.append(formatLine("|                                          "));
	    output.append("\n");
	    output.append("|--------------------------------------------------------------------|");
	    output.append("\n");
	    output.append(formatLine("|                                          "));
	    output.append("\n");
	    output.append(formatLine("|    Branch Name: " + this.getBranchName()));
        output.append("\n");
	    output.append(formatLine("|    Account Number: " + this.getBranchAddress()));
        output.append("\n");
        output.append(formatLine("|                                          "));
	    output.append("\n");
	    output.append("|--------------------------------------------------------------------|\n");
	    output.append("\n");

        for (Account account : branchAccounts) {
            output.append(account.toString()).append("\n");
        }

        output.append(RESET);
        return output.toString();
    }
	
	private String formatLine(String content) {
	    int LINE_WIDTH = 68; // Adjust the width as needed
	    return String.format("%-" + LINE_WIDTH + "s |", content);
	}
}

