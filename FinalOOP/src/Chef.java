import java.util.Random;

public class Chef implements ChefModifier,Runnable{
	private int chefId;
	private String chefType,chefName;
	public Chef(int chefId,String chefName,String chefType) {
		// TODO Auto-generated constructor stub
			this.chefId = chefId;
			this.chefType= chefType;
			this.chefName = chefName;
	}
	public int getChefId() {
		return chefId;
	}
	public void setChefId(int chefId) {
		this.chefId = chefId;
	}
	public String getChefType() {
		return chefType;
	}
	public void setChefType(String chefType) {
		this.chefType = chefType;
	}
	public String getChefName() {
		return chefName;
	}
	public void setChefName(String chefName) {
		this.chefName = chefName;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int randomNum = rand.nextInt(10);
		try {
			int currqty = Main.FoodList.get(randomNum).getFoodQty();
			switch (getChefType()) {
			case "Executive":
				Thread.sleep(ChefModifier.ExecutiveSpeed);
				Main.FoodList.get(randomNum).setFoodQty(currqty+ChefModifier.ExecutiveCreateFood);
				break;

			case "Personal":
				Thread.sleep(ChefModifier.PersonalSpeed);
				Main.FoodList.get(randomNum).setFoodQty(currqty+ChefModifier.PersonalCreateFood);
				break;
			case "Souser":
				Thread.sleep(ChefModifier.SouserSpeed);
				Main.FoodList.get(randomNum).setFoodQty(currqty+ChefModifier.SouserCreateFood);
				break;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			 System.out.println("Exception is caught");
			e.printStackTrace();
		}
	}

}
