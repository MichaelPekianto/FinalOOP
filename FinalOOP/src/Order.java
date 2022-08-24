
public class Order {
	private int orderId,customerId;
	private boolean isPaid;
	public Order(int orderId,int customerId,boolean isPaid) {
		// TODO Auto-generated constructor stub
	this.customerId =customerId;
	this.orderId = orderId;
	this.isPaid = isPaid;
	}

	public boolean getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(boolean isPaid) {
		this.isPaid = isPaid;
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
