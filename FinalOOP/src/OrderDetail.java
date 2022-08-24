
public class OrderDetail {
	private int orderId,foodId,orderQty;
	public OrderDetail(int orderId,int foodId,int orderQty) {
		// TODO Auto-generated constructor stub
	this.orderId = orderId;
	this.foodId = foodId;
	this.orderQty= orderQty;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	
}
