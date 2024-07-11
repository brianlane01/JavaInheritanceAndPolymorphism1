
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
	
	

}
