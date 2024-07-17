
public class PersonalCustomer extends Customer{
	
	private String homePhone;
	private String workPhone; 
	
	public PersonalCustomer ( ) {
		super();
		this.homePhone = "";
		this.workPhone = "";
		
	}

	/**
	 * @param name
	 * @param address
	 * @param phone
	 * @param homepPhone
	 * @param workPhone
	 */
	public PersonalCustomer(String name, String address, String phone, String homePhone, String workPhone) {
		super(name, address, phone);
		this.homePhone = homePhone;
		this.workPhone = workPhone;
	}

	/**
	 * @return the homePhone
	 */
	public String getHomePhone() {
		return homePhone;
	}

	/**
	 * @return the workPhone
	 */
	public String getWorkPhone() {
		return workPhone;
	}

	/**
	 * @param homePhone the homePhone to set
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	/**
	 * @param workPhone the workPhone to set
	 */
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	
	@Override
    public String toString() {
        StringBuilder output = new StringBuilder(super.toString());
        output.append("\nHome Phone: ").append(this.homePhone);
        output.append("\nWork Phone: ").append(this.workPhone);
        output.append("\n----------------------------------\n");
        output.append("Accounts for ").append(super.getName()).append(": \n");

        for (Account account : super.getCustomerAccounts()) {
        	output.append(account.toString()).append("\n");
        }
        
        output.append("\n\n");

        return output.toString();
    }
}
