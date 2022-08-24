import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	boolean isOrder = true;
    Scanner scan = new Scanner(System.in);
    public static Vector<Food> FoodList = new Vector<>();
    public static Vector<Order> OrderList = new Vector<>();
    public static Vector<OrderDetail> OrderDetailList = new Vector<>();
    public static Vector<Customer> CustomerList = new Vector<>();
    public static Vector<Chef> ChefList = new Vector<>();
    public Customer currentUser= new Customer(0,"","");
    
    private void Login() {
    	String userName,password;
    	int choose=0;
    	do {
    		cls();
    		System.out.println("Hello before you enter the restaurant you must Login First!");
	    	System.out.println("1. Login");
	    	System.out.println("2. Register");
	    	System.out.println("3. Exit");
	    	System.out.print("Chose>> ");
	    	choose = scan.nextInt();
	    	if(choose==1) {
		    	int isRegistered=0,isCorrect=0;
		    	String currpw = null;
		    	do {
		    	System.out.print("User: ");
		    	userName = scan.next();
		    	scan.nextLine();
		    	
		    	System.out.print("Password: ");
		    	password = scan.nextLine();
		    	for (Customer customer : CustomerList) {
		    		System.out.println(""+customer.getCustomerName());
					if(customer.getCustomerName().equals(userName)) {
						isRegistered=1;
						currpw = customer.getCustomerPassword();
						break;
					}
				}
		    	if(isRegistered==1) {
		    		if(password.equals(currpw)) {
		    			isCorrect=1;
		    		}
		    	}
		    	if(isRegistered==0) {
		    		System.out.println("Your User Name Doesn't Exist in our Database. Please Register");
		    		Register();
		    	}
		    	if(isCorrect==0) {
		    		System.out.println("Incorrect Password");
		    	}
		    	}while(isRegistered==0||isCorrect==0);
		    	System.out.println("Success Login");
		    	
		    	while(isOrder) {
		            menu();
		        }
	    	}else if(choose==2) {
	    		scan.nextLine();
	    		Register();
	    	}
    	}while(choose!=3);
    	
    	
    }
    private void cls() {
		// TODO Auto-generated method stub
		for(int a=0;a<10;a++) {
			System.out.println("");
		}
	}
	private void Register() {
		// TODO Auto-generated method stub
		String userName;
		cls();
    	do {
			System.out.print("Enter User Name[8-16 characters]:");
			userName =scan.nextLine();
		}while(userName.length()<8||userName.length()>16);
    	String password;
    	do {
    		System.out.println("Enter Password[8-16 characters]:");
    		password= scan.nextLine();
    	}while(password.length()>16||password.length()<8);
    	System.out.println("Success Register your User Name");
    	if(CustomerList.isEmpty()) {
    		currentUser.setCustomerId(1);
    	}else {
    		currentUser.setCustomerId(CustomerList.size()+1);
    	}
    	
    	currentUser.setCustomerName(userName);
    	currentUser.setCustomerPassword(password);
    	CustomerList.add(currentUser);
    	while(isOrder) {
            menu();
        }
    }
	private void viewDessert() {
        // TODO Auto-generated method stub
    	int dessertCount=0;
    	boolean isEmpty=false;
    	for (Food food : FoodList) {
		if(food.getFoodType().equals("Dessert") && food.getFoodQty()!=0) {
			dessertCount+=1;
		}
		}
    	if(dessertCount==0) {
    		System.out.println("Sorry,We Are Running Out of Desserts please come back later");
    		scan.nextLine();
    	}else {
    		String isMore="N";
    		do {
    			cls();
	    		ArrayList<Food> tempList = new ArrayList<>();
	    		
	    		int chooseFood=0;
	    		int idx=0;
	    		dessertCount=0;
	    		for (Food food : FoodList) {
					if(food.getFoodType().equals("Dessert") && food.getFoodQty()!=0) {
						idx+=1;
						dessertCount+=1;
						System.out.println(""+idx+". "+food.getFoodName());
						System.out.println("Rp. "+food.getFoodPrice()+".00");
						System.out.println("Quantity: "+food.getFoodQty());
						System.out.println("=============================");
						System.out.println("");
						tempList.add(food);
					}
				}
	    		
	    		if(tempList.isEmpty()) {
	    			System.out.println("Sorry,We Are Running Out of Desserts please come back later");
	    			scan.nextLine();
	    			isEmpty=true;
	    			
	    		}else {
	    		
		    		do {
		    		System.out.print("Choose Food[1-"+dessertCount+"] >> ");
		    		chooseFood = scan.nextInt();
		    		}while(chooseFood==0||chooseFood>dessertCount);
		    		
		    		int qty =0;
		    		do {
		    			System.out.print("How Much you want to Order[1-"+tempList.get(chooseFood-1).getFoodQty()+"]: ");
		    		qty = scan.nextInt();
		    		}while(qty==0||qty>tempList.get(chooseFood-1).getFoodQty());
		    		scan.nextLine();
		    		do {
		    		System.out.print("Do you Want To Order More?[Y/N Case Sensitive]: ");
		    		isMore= scan.nextLine();
		    		}while(!isMore.equals("Y")&& !isMore.equals("N"));
		    		
		    		OrderDetailList.add(new OrderDetail(OrderList.size()+1,tempList.get(chooseFood-1).getFoodId(),tempList.get(chooseFood-1).getFoodQty()));
		    		FoodList.get(tempList.get(chooseFood-1).getFoodId()-1).setFoodQty(FoodList.get(tempList.get(chooseFood-1).getFoodId()-1).getFoodQty()-qty);
	    		}
    		}while(isMore.equals("Y") && isEmpty==false);
    		//System.out.println("Order Success");
    		scan.nextLine();
    		if(OrderList.isEmpty()) {
    			
    			OrderList.add(new Order(1,currentUser.getCustomerId(),false));
    		}else {
    			OrderList.add(new Order(OrderList.size()+1,currentUser.getCustomerId(),false));
    		}
    			
    	}
    }

    private void viewMainCourse() {
    	int mainCount=0;
    	boolean isEmpty =false;
    	for (Food food : FoodList) {
		if(food.getFoodType().equals("MainCourse") && food.getFoodQty()!=0) {
			mainCount+=1;
		}
		}
    	if(mainCount==0) {
    		System.out.println("Sorry,We Are Running Out of MainCourse please come back later");
    		scan.nextLine();
    	}else {
    		String isMore="N";
    		do {
    			cls();
    			mainCount=0;
	    		ArrayList<Food> tempList = new ArrayList<>(); 
	    		int chooseFood=0;
	    		int idx=0;
	    		for (Food food : FoodList) {
					if(food.getFoodType().equals("MainCourse") && food.getFoodQty()!=0) {
						idx+=1;
						mainCount+=1;
						System.out.println(""+idx+". "+food.getFoodName());
						System.out.println("Rp. "+food.getFoodPrice()+".00");
						System.out.println("Qty: "+food.getFoodQty());
						System.out.println("=============================");
						System.out.println();
						tempList.add(food);
					}
				}
	    		if(tempList.isEmpty()) {
	    			System.out.println("Sorry,We Are Running Out of MainCourse please come back later");
	    			isEmpty=true;
	        		scan.nextLine();
	    		}else {
	    			do {
	    	    		System.out.print("Choose Food[1-"+mainCount+"] >> ");
	    	    		chooseFood = scan.nextInt();
	    	    		}while(chooseFood==0||chooseFood>mainCount);
	    	    		
	    	    		int qty =0;
	    	    		do {
	    	    			System.out.print("How Much you want to Order[1-"+tempList.get(chooseFood-1).getFoodQty()+"]: ");
	    	    		qty = scan.nextInt();
	    	    		}while(qty==0||qty>tempList.get(chooseFood-1).getFoodQty());
	    	    		scan.nextLine();
	    	    		do {
	    		    		System.out.print("Do you Want To Order More?[Y/N Case Sensitive]: ");
	    		    		isMore= scan.nextLine();
	    		    		}while(!isMore.equals("Y")&& !isMore.equals("N"));

	    	    		OrderDetailList.add(new OrderDetail(OrderList.size()+1,tempList.get(chooseFood-1).getFoodId(),tempList.get(chooseFood-1).getFoodQty()));
	    	    		FoodList.get(tempList.get(chooseFood-1).getFoodId()-1).setFoodQty(FoodList.get(tempList.get(chooseFood-1).getFoodId()-1).getFoodQty()-qty);
	    		}
	    		
    		}while(isMore.equals("Y") && isEmpty==false);
    		//System.out.println("Order Success");
    		scan.nextLine();
    		if(OrderList.isEmpty()) {
    			
    			OrderList.add(new Order(1,currentUser.getCustomerId(),false));
    		}else {
    			OrderList.add(new Order(OrderList.size()+1,currentUser.getCustomerId(),false));
    		}
    	}
    }

    private void order() {
        // TODO Auto-generated method stub
    	int input2;
        do {
        	cls();
    	System.out.println("1. Main Course");
        System.out.println("2. Dessert");
        System.out.println("3. Back");
        System.out.print(">>");
        input2 = scan.nextInt();
        if(input2 == 1) {
            viewMainCourse();
        }else if(input2 == 2) {
            viewDessert();
        }else if(input2 == 3) {
            menu();
        }
        }while(input2!=3);
    }

    private void menu() {

        // TODO Auto-generated method stub
    	
        cls();
        for (Chef chef : ChefList) {
        	Thread TempChef = new Thread(chef);
        	TempChef.start();
		}
        System.out.println("Welcome to Budi Restaurant!!!!"+"\n\nPlease order your food!");
        System.out.println("==========================");
        System.out.println("1. Add Order");
        System.out.println("2. Pay Bill");
        System.out.println("3. Exit");
        System.out.print(">> ");
        int input = scan.nextInt();

        switch (input) {
        case 1:
            order();
        case 2:
        	payBill();
            break;
        case 3:
            System.out.println("Come again!");
            isOrder = false;

        }
    }


    private void payBill() {
		// TODO Auto-generated method stub
		cls();
		System.out.println("Your Order: ");
		int idx =0;
		boolean haveOrdered=false;
		if(!OrderList.isEmpty()) {
			for (Order order : OrderList) {
				if(order.getCustomerId()==currentUser.getCustomerId() && order.getIsPaid()==false) {
					haveOrdered=true;
					int Total=0;
					System.out.println("Order Number: "+order.getOrderId());
					System.out.println("<======================>");
					System.out.println("Order Details");
					for(OrderDetail oDtl : OrderDetailList) {
						idx+=1;
						System.out.println("=====================");
						System.out.println(""+idx+". "+FoodList.get(oDtl.getFoodId()-1).getFoodName());
						System.out.println("Rp. "+FoodList.get(oDtl.getFoodId()-1).getFoodPrice());
						System.out.println("Qty: "+oDtl.getOrderQty());
						System.out.println("SubTotal: Rp."+oDtl.getOrderQty()*FoodList.get(oDtl.getFoodId()-1).getFoodPrice()+".00");
						System.out.println("");
						Total+= oDtl.getOrderQty()*FoodList.get(oDtl.getFoodId()-1).getFoodPrice();
					}
					System.out.println("===========================");
					System.out.println("Grand Total: Rp."+Total+".00");
				}
			}
			
			if(haveOrdered==false) {
				System.out.println("You haven't ordered any food yet!");
				scan.nextLine();
			}
		}else {
			System.out.println("You haven't ordered any food yet!");
			scan.nextLine();
		}
	}
	public Main() {
    	FoodList.add(new Dessert(1,"ChocolateIceCream",25000,0,"Dessert","Sweet",3));
    	FoodList.add(new Dessert(2,"VanillaIceCream",20000,0,"Dessert","Sweet",5));
        FoodList.add(new Dessert(3,"MatchaIceCream",40000,0,"Dessert","Bitter",5));
        FoodList.add(new Dessert(4,"MapleIceCream",35000,0,"Dessert","Sour",5));
        FoodList.add(new Dessert(5,"BananaIceCream",15000,0,"Dessert","Sweet",5));
        FoodList.add(new MainCourse(6, "AyamGeprek", 15000, 0,"MainCourse", "Medium", 5));
        FoodList.add(new MainCourse(7, "NasiGoreng", 25000, 0,"MainCourse", "Large", 3));
        FoodList.add(new MainCourse(8, "MieGoreng", 15000, 0,"MainCourse", "Medium", 2));
        FoodList.add(new MainCourse(9, "Kebab", 20000, 0,"MainCourse", "Small", 1));
        FoodList.add(new MainCourse(10, "Samyang", 30000, 0,"MainCourse", "Medium", 5));
        ChefList.add(new Chef(1, "Marco Pierre White", "Executive"));
        ChefList.add(new Chef(2, "Gordon Ramsay", "Personal"));
        ChefList.add(new Chef(3, "Uncle Roger", "Souser"));
        CustomerList.add(new Customer(1,"Budi","1"));
    	Login();
        
    }






    public static void main(String[] args) {

        // TODO Auto-generated method stub
        new Main();
    }
}
