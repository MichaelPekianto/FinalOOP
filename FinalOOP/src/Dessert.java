
public class Dessert extends Food {
	private String flavour;
	private int sugarLevel;
	public Dessert(int foodId, String foodName, int foodPrice, int foodQty,String foodType,String flavour, int sugarLevel) {
		super(foodId, foodName, foodPrice, foodQty,foodType);
		// TODO Auto-generated constructor stub
		this.flavour =flavour;
		this.sugarLevel = sugarLevel;
	}
	public String getFlavour() {
		return flavour;
	}
	public void setFlavour(String flavour) {
		this.flavour = flavour;
	}
	public int getSugarLevel() {
		return sugarLevel;
	}
	public void setSugarLevel(int sugarLevel) {
		this.sugarLevel = sugarLevel;
	}

}
