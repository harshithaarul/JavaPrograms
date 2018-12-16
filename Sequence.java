import java.util.Scanner;
class Sequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr = new Scanner (System.in);
		int input1 = scnr.nextInt();
		int input2 = scnr.nextInt();
		int input3 = scnr.nextInt();
		int total = scnr.nextInt();
		int diff1 = input2-input1;
		int diff2 = input3-input2;
		int[] array = new int[total];
		array[0] = input1;
		array[1] = input2;
		array[2] = input3;

		for (int i = 3; i <total; i++) {
			if (i%2 ==1) {
				array[i] = (array[i-1]+diff1);
			} else {
				array[i] = (array[i-1]+diff2);
			}
		}
		//print output
		for (int i = 0; i <total; i++) {
			if (i == total-1) {
				System.out.print(array[i]);
			}else {
				System.out.print(array[i] + " ");
			}
		}
	}
}
