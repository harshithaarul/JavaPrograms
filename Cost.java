import java.util.*;

class Cost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double miles = 0.0;
		double mpg = 0.0;
		double cost = 0.0;
		double totalCost = 0.0;
		Scanner scnr = new Scanner(System.in);
		miles = scnr.nextDouble(); 
		mpg = scnr.nextDouble();
		cost = scnr.nextDouble();
		totalCost = (miles/mpg)*cost;
		System.out.printf("%.2f",totalCost);
		
	}

}
