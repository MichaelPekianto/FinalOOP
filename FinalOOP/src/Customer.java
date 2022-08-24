
public class Customer {
	private int customerId;
	private String customerName,customerPassword;
	public Customer(int customerId,String customerName,String customerPassword) {
		// TODO Auto-generated constructor stub
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

}
