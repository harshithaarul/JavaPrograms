import java.util.Scanner;

public class ShoppingCartPrinter{
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	//instantiate two objects of ItemToPurchase
	ItemToPurchase item1 = new ItemToPurchase();
	ItemToPurchase item2 = new ItemToPurchase();
	System.out.println("Item 1");
	System.out.println("Enter the item name:");
	item1.setName(sc.nextLine());
	System.out.println("Enter the item price:");
	item1.setPrice(sc.nextInt());
	System.out.println("Enter the item quantity:");
	item1.setQuantity(sc.nextInt());
	System.out.println();
	sc.nextLine();
	System.out.println("Item 2");
	System.out.println("Enter the item name:");
	item2.setName(sc.nextLine());
	System.out.println("Enter the item price:");
	item2.setPrice(sc.nextInt());
	System.out.println("Enter the item quantity:");
	item2.setQuantity(sc.nextInt());
	System.out.println();
	//print properties of the objects in the specified format
	int item1Cost = (item1.getPrice()*item1.getQuantity());
	int item2Cost = (item2.getPrice()*item2.getQuantity());
	int totalCost = item1Cost + item2Cost;
	System.out.println("TOTAL COST");
	System.out.println(item1.getName()+ " "+ item1.getQuantity()+" @ $" + item1.getPrice()+" = $" + item1Cost);
	System.out.println(item2.getName()+ " "+ item2.getQuantity()+" @ $" + item2.getPrice()+" = $" + item2Cost);
	
	//printing total cost of and list of items
	System.out.println("\nTotal: $" + totalCost);
	}
}