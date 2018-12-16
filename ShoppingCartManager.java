import java.util.Scanner;
public class ShoppingCartManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter Customer's Name:");
		String name = scnr.nextLine();
		System.out.println("Enter Today's Date:");
		String date = scnr.nextLine();
		System.out.println();
		System.out.println("Customer Name: " + name +"\nToday's Date: " + date);
		ShoppingCart cart = new ShoppingCart(name, date);
		printMenu();
		System.out.println("Choose an option:");
		String letter= "";
		while (scnr.hasNextLine()) {
			letter = scnr.nextLine();
			if (letter.equalsIgnoreCase("q")){
				break;

			} else if (letter.equalsIgnoreCase("a")) {
				ItemToPurchase item = new ItemToPurchase();
				System.out.println("ADD ITEM TO CART\n" + "Enter the item name:");
				item.setName(scnr.nextLine());
				System.out.println("Enter the item description:");
				item.setDescription(scnr.nextLine());
				System.out.println("Enter the item price:");
				item.setPrice(scnr.nextInt());
				System.out.println("Enter the item quantity:");
				item.setQuantity(scnr.nextInt());
				ShoppingCart.addItem(item);
				printMenu();
				System.out.println("Choose an option:");

			}else if (letter.equalsIgnoreCase("d")) {
				System.out.println("REMOVE ITEM FROM CART\nEnter name of item to remove:");
				String nameOfRemoveItem = scnr.nextLine();
				ShoppingCart.removeItem(nameOfRemoveItem);
				printMenu();
				System.out.println("Choose an option:");

			}else if (letter.equalsIgnoreCase("c")) {
				System.out.println("CHANGE ITEM QUANTITY\n" + "Enter the item name:");
				ItemToPurchase item = new ItemToPurchase();
				String nameOfChangeItem = scnr.nextLine();
				item.setName(nameOfChangeItem);
				System.out.println("Enter the new quantity:");
				int quantityOfChangeItem = scnr.nextInt();
				item.setQuantity(quantityOfChangeItem);
				ShoppingCart.modifyItem(item);
				printMenu();
				System.out.println("Choose an option:");

			}else if (letter.equalsIgnoreCase("i")) {
				System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
				ShoppingCart.printDescriptions();
				printMenu();
				System.out.println("Choose an option:");

			}else if (letter.equalsIgnoreCase("o")) {
				System.out.println("OUTPUT SHOPPING CART");
				ShoppingCart.printTotal();
				printMenu();
				System.out.println("Choose an option:");
			}
			else if(letter.equalsIgnoreCase("f")||letter.equalsIgnoreCase("s")) System.out.println("Choose an option:");
			}

		}
	



	private static void printMenu() {
		// TODO Auto-generated method stub
		System.out.println("\nMENU\n" + 
				"a - Add item to cart\n" + 
				"d - Remove item from cart\n" + 
				"c - Change item quantity\n" + 
				"i - Output items' descriptions\n" + 
				"o - Output shopping cart\n" + 
				"q - Quit\n");

	}
}
