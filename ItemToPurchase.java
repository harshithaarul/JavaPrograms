class ItemToPurchase{
	//private fields such as itemName, itemPrice, and itemQuantity
	String itemName; 
	int itemPrice;
	int itemQuantity;
	String itemDescription;


	//default constructor
	ItemToPurchase(){
		itemName = "none";
		itemPrice = 0;
		itemQuantity = 0;
		itemDescription = "none";
	}
	ItemToPurchase(String name, String description, int price, int quantity){
		itemName = name;
		itemDescription = description;
		itemPrice = price;
		itemQuantity = quantity;
		
	}
	//setName method
	public void setName(String name){
		this.itemName = name;
	}

	//getName method
	public String getName(){
		return itemName;
	}

	//setPrice method
	public void setPrice(int price){
		this.itemPrice = price;
	}
	//getPrice method
	public int getPrice(){
		return itemPrice;
	}

	//setQuantity method
	public void setQuantity(int quantity){
		this.itemQuantity = quantity;
	}
	//getQuantity method
	public int getQuantity(){
		return itemQuantity;
	}
	//getItemDescription method
	public String getDescription() {
		return itemDescription;
	}
	//setItemDescription method
	public void setDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	//printItemCost method
	public void printItemCost(ItemToPurchase item) {
		int tot = this.getPrice()*this.getQuantity();
		System.out.println(this.getName()+" "+this.getQuantity()+" @ $"+this.getPrice()+" = $"+ tot);
	}
	//printItemDescription method
	public void printItemDescription() {
		System.out.println(this.getName()+": " +this.getDescription());
	}

}