
public class Order {
	private int orderId,customerId;
	
	public Order(int orderId,int customerId) {
		// TODO Auto-generated constructor stub
	this.customerId =customerId;
	this.orderId = orderId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	

}
