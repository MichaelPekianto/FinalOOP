
public class MainCourse extends Food{
	private String serving;
	private int spiciness;
	public MainCourse(int foodId, String foodName, int foodPrice, int foodQty,String foodType,String serving,int spiciness) {
		super(foodId, foodName, foodPrice, foodQty,foodType);
		// TODO Auto-generated constructor stub
		this.serving = serving;
		this.spiciness = spiciness;
	}
	
	

	

}
