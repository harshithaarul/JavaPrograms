import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String input = scnr.next();
		System.out.println(input);

		String back = "";
		System.out.println(back);
		
		for(int i = input.length()-1; i> -1; i--) {
			back+= input.charAt(i);
		}
		System.out.println(back);
	}
}
