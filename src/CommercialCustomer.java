
public class CommercialCustomer extends Customer {
	
	private int creditRating;
	
	private String contactPerson; 
	
	private String contactPersonPhone;
	
	//The default constructor 
	public CommercialCustomer () {
		super();
		this.creditRating = 0; 
		this.contactPerson = "";
		this.contactPersonPhone = "";
		
	}
	
	public CommercialCustomer(String name, String address, String phone, int creditRating, String contactPerson, String contactPersonPhone) {
		super(name, address, phone);
		this.creditRating = creditRating; 
		this.contactPerson = contactPerson; 
		this.contactPersonPhone = contactPersonPhone; 
	}

	/**
	 * @return the creditRating
	 */
	public int getCreditRating() {
		return creditRating;
	}

	/**
	 * @return the contactPerson
	 */
	public String getContactPerson() {
		return contactPerson;
	}

	/**
	 * @return the contactPersonPhone
	 */
	public String getContactPersonPhone() {
		return contactPersonPhone;
	}

	/**
	 * @param creditRating the creditRating to set
	 */
	public void setCreditRating(int creditRating) {
		this.creditRating = creditRating;
	}

	/**
	 * @param contactPerson the contactPerson to set
	 */
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	/**
	 * @param contactPersonPhone the contactPersonPhone to set
	 */
	public void setContactPersonPhone(String contactPersonPhone) {
		this.contactPersonPhone = contactPersonPhone;
	}
	
	@Override
	public String toString() {
	    StringBuilder output = new StringBuilder(super.toString());
	    output.append("\nCredit Rating: ").append(this.creditRating);
	    output.append("\nContact Person: ").append(this.contactPerson);
	    output.append("\nContact Person Phone: ").append(this.contactPersonPhone);
	    output.append("\n----------------------------------\n");
	    for (Account account : super.getCustomerAccounts()) {
        	output.append(account.toString()).append("\n");
        }
        
        output.append("\n\n");
	    return output.toString();
	}
}
