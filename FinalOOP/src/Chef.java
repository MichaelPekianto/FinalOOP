
public class Chef implements ChefModifier{
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

}
