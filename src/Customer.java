import java.util.ArrayList;
public class Customer {
	
	//Instance variables or attributes
	private String name;
	private String address;
	private String phone;
	private ArrayList<Account> customerAccount; 
	
	//default constructor
	public Customer () {
		this.name = "";
		this.address = "";
		this.phone = "";
		this.customerAccount = null; 
	}
	
	public Customer(String name, String address, String phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
	}



	public String getName() {
		return name;
	}



	public String getAddress() {
		return address;
	}



	public String getPhone() {
		return phone;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	} 
	
	
	
}
