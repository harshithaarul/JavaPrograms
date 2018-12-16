import java.util.Scanner;
class Narges {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String input = scnr.nextLine();
		boolean output = false;
		for (int i = 0; i <input.length()-1; i++) {
			if (input.contains("n")) {
				input = input.substring ((input.indexOf("n")+1));
				if (input.contains("a")) {
					input = input.substring ((input.indexOf("a")+1));
					if (input.contains("r")) {
						input = input.substring ((input.indexOf("r")+1));
						if (input.contains("g")) {
							input = input.substring ((input.indexOf("g")+1));
							if (input.contains("e")) {
								input = input.substring ((input.indexOf("e")+1));
								if (input.contains("s")) {
									output = true;
								}
							}
						}
					}
				}
			}
		}
		System.out.println(output);
	}
}
