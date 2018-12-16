import java.util.Scanner;
class Increment {
	// check number of increasing values 
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);	
		String s = "";
		String num1= "";
		int first = 0;
		int checkNum1 = 0;
		int checkNum2 = 0;
		String newS = "";
		for (int i = 0; ;i++) {
			if (i == 0) {
				checkNum1 = scnr.nextInt();
				checkNum2 = scnr.nextInt();
				s = s + checkNum1 + " ";
				if (checkNum1 <= checkNum2) {
					s = s + checkNum2 + " ";
				} else {
					s = s + checkNum2 + " ";
					break;
				}
			} 
			if (i > 0) {
				checkNum1 = checkNum2;
				checkNum2 = scnr.nextInt();
				if (checkNum1 <= checkNum2) {
					s = s + checkNum2 + " ";
				}else {
					s = s + checkNum2 + " ";
					break;
				}
			}
		}
		//Number of numbers to add in the array
		int totalNums = 0;
		for (int i = 0; i <s.length()-1; i++) {
			if (s.substring(i, i+1).equals(" ")){
				totalNums++;
			}
		}
		totalNums++;
		int[] array = new int [totalNums];
		for (int i = 0; i <s.length(); i++) {
			num1 = s.substring(0, s.indexOf(" "));
			first = Integer.parseInt(num1);
			array[i] = first;
			s = s.substring ((s.indexOf(" ")+1));
		}
		int divide = 0;
		int diff = 0; 
		double totalDiff= 0.0;
		for (int i = 0; i < totalNums-1; i++) {
			if (i == 0 && array[i+1] < array[i]) {
				System.out.println("0.00");
				break;
			}
			if (array[i+1]>= array[i]) {
				diff = Math.abs(array[i+1] -array[i]);
				totalDiff += diff;
				divide++;
				System.out.println("diff= " + diff);
				System.out.println("totalDiff= " + totalDiff);
				System.out.println("divide= " + divide);
				if (divide == totalNums - 2) {
					System.out.printf("%.2f", Math.abs(totalDiff/divide));
				}
			}
		}
	}
}
