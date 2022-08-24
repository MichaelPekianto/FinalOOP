import java.util.Scanner;

public class Main {

	boolean isOrder = true;
    Scanner scan = new Scanner(System.in);

    private void viewDessert() {
        // TODO Auto-generated method stub

    }

    private void viewMainCourse() {
    	
    }

    private void order() {
        // TODO Auto-generated method stub
    	int input2;
        do {
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
            break;
        case 3:
            System.out.println("Come again!");
            isOrder = false;

        }
    }


    public Main() {

        while(isOrder) {
            menu();
        }
    }






    public static void main(String[] args) {

        // TODO Auto-generated method stub
        new Main();
    }
}
