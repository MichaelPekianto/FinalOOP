
public abstract class Food {
	private String foodName,foodType;
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	private int foodQty,foodId,foodPrice;
	public Food(int foodId,String foodName, int foodPrice, int foodQty,String foodType) {
		// TODO Auto-generated constructor stub
		this.foodName = foodName;
		this.foodId = foodId;
		this.foodPrice = foodPrice;
		this.foodQty = foodQty;
		this.foodType = foodType;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getFoodQty() {
		return foodQty;
	}
	public void setFoodQty(int foodQty) {
		this.foodQty = foodQty;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public int getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}

}
