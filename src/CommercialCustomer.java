
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
}
