//import java.util.*;
//class Flip {
//		   public static void main(String[] args) {
//			      Scanner scnr = new Scanner(System.in);
//			      int arrowBaseHeight;
//			      int arrowBaseWidth;
//			      int arrowHeadWidth;
//			      
//			      
//			      System.out.println("Enter arrow base height:");
//			      arrowBaseHeight = scnr.nextInt();
//			      
//			      System.out.println("Enter arrow base width:");
//			      arrowBaseWidth = scnr.nextInt();
//			      
//			      System.out.println("Enter arrow head width:");
//			      arrowHeadWidth = scnr.nextInt();
//			      
//			      
//			      while (arrowHeadWidth<=arrowBaseWidth){
//			         System.out.println("Enter arrow head width:");
//			         arrowHeadWidth = scnr.nextInt();
//			      }
//			      int arrowHeadWidth1 = arrowHeadWidth;
//			      System.out.println("");
//
//			      for (int i = 0; i <arrowBaseHeight; i++){
//			         for (int j = 0; j <arrowBaseWidth; j++){
//			            System.out.print("*");
//			         }
//			         System.out.println();
//			      }
//
//			      for (int h = 0; h < arrowHeadWidth; h++){
//			         for (int j = arrowHeadWidth1; j >0; j--){
//			            System.out.print("*");
//			         }
//			         System.out.println();
//			         arrowHeadWidth1--;
//			      }
//			   }
//}
////		Scanner scnr = new Scanner(System.in);
////		int input = scnr.nextInt();
////		int ones = 0;
////		int tens = 0;
////		int hundreds = 0;
////		if (input < 10) {
////			hundreds = input%10;
////			tens = (input%100)/10;
////			ones = input/100;
////			System.out.println(hundreds + ""+ tens + ""+ ones );
////		} else if(input%100==0){
////			System.out.println(input);
////		}
////		else if (input%10 ==0) {
////			ones = (input%10);
////			tens = input/100;
////			hundreds = (input/10)%10;
////			System.out.println(hundreds + ""+ tens + ""+ ones );
////		}
////		else if (input < 100) {
////			hundreds = input%10;
////			tens = input/10;
////			System.out.println(hundreds + ""+ tens + ""+ ones);
////		} else {
////			hundreds = input%10;
////			tens = (input%100)/10;
////			ones = input/100;
////			System.out.println(hundreds + ""+ tens + ""+ ones );
////		}
////		
////		
//   	
//
//
//
//

import java.util.Scanner;
class Flip {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr = new Scanner(System.in);
		int[][] roster = new int[5][2];
		// store input
		for (int i = 0; i<5; i++) {
			for (int j = 0; j<2; j++) {
				roster[i][j] = scnr.nextInt();
			}
		}
		String menu = scnr.next();
		if (menu.equalsIgnoreCase("u")) {
			System.out.println("Enter a jersey number:");
			System.out.println("Enter a new rating for player: ");
			int jNum = scnr.nextInt();
			int nRate = scnr.nextInt();
			for (int i = 0; i <5; i++) {
				for (int j = 0; j <1; j++) {
					if (roster[i][j] == jNum) {
						roster[i][j+1] = nRate;
					}
				}
			}
			
		}
		
		menu = scnr.next();
		if (menu.equalsIgnoreCase("a")) {
			System.out.println("Enter a rating:");
			int compRate = scnr.nextInt();
			System.out.println("ABOVE " + compRate);
			for (int i = 0; i <5; i++) {
				for (int j = 0; j <1; j++) {
					if (roster[i][j+1] > compRate) {
						int  k = i +1;
						System.out.println("Player " + k + " -- Jersey number: " + roster[i][j] + ", Rating: " + roster[i][j+1]);
					}
				}
			}
		}
		
		menu = scnr.next();
		if (menu.equalsIgnoreCase("r")) {
			System.out.println("Enter a jersey number:\nEnter a new jersey number:\nEnter a rating for the new player:");
			int jNum = scnr.nextInt();
			int jNumNew = scnr.nextInt();
			int nRate = scnr.nextInt();
			for (int i = 0; i <5; i++) {
				for (int j = 0; j <1; j++) {
					if (roster[i][j] == jNum) {
						roster[i][j] = jNumNew;
						roster[i][j+1] = nRate;
					}
				}
			}
		}
		
		menu = scnr.next();
		if (menu.equalsIgnoreCase("o")) {
			System.out.println("ROSTER");
			for (int i = 0; i<5; i++) {
				for (int j = 0; j<1; j++) {
					System.out.println("Player " + (i+1) + " -- Jersey number: " + roster[i][j] + ", Rating: " + roster[i][j+1]);
				}
			}	
		}
		

		System.out.println();
		System.out.println("MENU\nu - Update player rating\na - Output players above a rating\nr - Replace player\no - Output roster\nq - Quit\n\nChoose an option:");
		
	}
}	