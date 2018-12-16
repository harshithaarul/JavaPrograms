
public class ShoppingCart {
	static String customerName;
	static String currentDate;
	static ItemToPurchase[] cartItems;
	static int count = 0;
	ShoppingCart(){
		customerName = "none";
		currentDate = "January 1, 2016";
		count = 0;
		cartItems = new ItemToPurchase[100];
		for(int i=0;i<100;i++) cartItems[i]=null;
	}
	ShoppingCart(String name, String date){
		customerName = name;
		currentDate = date;
		count = 0;
		cartItems = new ItemToPurchase[100];
		for(int i=0;i<100;i++) cartItems[i]=null;
	}
	public String getCustomerName() {
		return customerName;
	}
	public String getDate() {
		return currentDate;
	}
	public static void addItem(ItemToPurchase item){
		cartItems[count] = item;
		count++;
	}
	public static void removeItem(String name){
		
		boolean bNameFound = false;
		for(int i=0;i<count;i++) {
			if(cartItems[i].getName().equalsIgnoreCase(name)) bNameFound = true;
			if(bNameFound) {
				cartItems[i]=cartItems[i+1];
				count--;
			}
		}
		if(!bNameFound) System.out.println("Item not found in cart. Nothing removed.");
	}
	public static void modifyItem(ItemToPurchase item) {
		boolean bItemFound = false;
		for (int i = 0; i <count; i++) {
			if (cartItems[i].getName().equalsIgnoreCase(item.getName())) {
				bItemFound = true;
				//if (item.getPrice()!=0 && item.getQuantity()!=0 && !item.getDescription().equals("none")) {
				cartItems[i].setQuantity(item.getQuantity());
				//}
			}
		}
		if (!bItemFound) System.out.println("Item not found in cart. Nothing modified.");
	}
	public static int getNumItemsInCart() {
		int totalCount = 0;
	for (int i = 0; i <count; i++){
		totalCount +=cartItems[i].getQuantity();
	}
		return totalCount;
	}
	public static int getCostOfCart() {
		int tot = 0;
		for (int i = 0; i<count; i++) {
			tot +=cartItems[i].getPrice()*cartItems[i].getQuantity();
		}
		return tot;
	}
	public static void printTotal() {
		int cost = 0;
		if (count==0) {
			System.out.println(customerName + "'s Shopping Cart - "+ currentDate);
			System.out.println("Number of Items: " + count);
			System.out.println();
			System.out.println("SHOPPING CART IS EMPTY");
		}else {
			System.out.println(customerName + "'s Shopping Cart - "+ currentDate);
			System.out.println("Number of Items: " + getNumItemsInCart());
			System.out.println();
			for (int i = 0; i <count;i++) {
				cost = cartItems[i].getPrice()*cartItems[i].getQuantity();
				System.out.println(cartItems[i].getName()+ " "+ cartItems[i].getQuantity()+" @ $" + cartItems[i].getPrice()+" = $" + cost);
			}
			
		}
		System.out.println("\nTotal: $" + getCostOfCart());
	}
	public static void printDescriptions() {
		System.out.println(customerName + "'s Shopping Cart - "+ currentDate);
		System.out.println();
		System.out.println("Item Descriptions");
		for (int i = 0; i <count;i++) {
		System.out.println(cartItems[i].getName()+": " +cartItems[i].getDescription());
		}
	}
}
