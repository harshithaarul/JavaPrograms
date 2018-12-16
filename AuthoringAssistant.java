import java.util.Scanner;
public class AuthoringAssistant {
	public static int numOfChars = 0;
	public static int numOfWords = 0;
	public static String replaced = "";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr = new Scanner (System.in);
		System.out.println("Enter a sample text:");
		String input = scnr.nextLine();
		System.out.println();
		System.out.println("You entered: " + input);
		String letter = "";
		printMenu();
		while(scnr.hasNext()) {
			letter = scnr.nextLine();
			if (letter.equals("c")){
				getNumOfNonWSCharacters(input);
				System.out.println("Number of non-whitespace characters: " + numOfChars);
				printMenu();

			} else if (letter.equalsIgnoreCase("w")){
				getNumOfWords(input);
				System.out.println("Number of words: " + numOfWords);
				printMenu();

			} else if (letter.equalsIgnoreCase(("f"))) {
				System.out.println("Enter a word or phrase to be found:");
				//String rand = scnr.nextLine();
				String word = scnr.nextLine();
				System.out.println("\"" + word + "\"" + " instances: " + findText(word, input));
				printMenu();
				
			} else if(letter.equalsIgnoreCase(("r"))){
				replaceExclamation(input);
				System.out.println("Edited text: "+ replaced);
				printMenu();
				
			} else if (letter.equalsIgnoreCase(("s"))) {
			   System.out.println("Edited text: " + shortenSpace(input));
				printMenu();
				
			}else if (letter.equalsIgnoreCase("q")) {
				break;
			}
		}
	}
	static void printMenu() {
		System.out.println();
		System.out.println("MENU\nc - Number of non-whitespace characters\nw - Number of words\nf - Find text\nr - Replace all !'s\ns - Shorten spaces\nq - Quit\n\nChoose an option:");
	}
	static int getNumOfNonWSCharacters(String input) {
		for(int i = 0; i <input.length(); i++) {
			if (!Character.isWhitespace(input.charAt(i)) ) {
				numOfChars++;
			}
		}
		return numOfChars;
	}
	static int getNumOfWords(String input) {
		for (int i=0; i <input.length(); i++) {
			if (Character.isWhitespace(input.charAt(i)) && (Character.isLetter(input.charAt(i+1)))) {
				numOfWords++;
			}
			if (i == input.length()-1) {
				numOfWords++;
			}
		}
		return numOfWords;
	}
	static int findText(String word, String input) {
		int numOfInst = 0;
		String in = "";
		for (int i =0; i <input.length()-word.length(); i++) {
			in = input.substring(i, i+ word.length());
			if (in.equals(word)) {
				numOfInst++;
			}
		}
		return numOfInst;
	}
	static String shortenSpace(String input) {
		
		while(input.indexOf("  ") != -1)
		{
			input = input.replace("  ", " ");
		}
		return input;
	}
	static String replaceExclamation(String input) {
		replaced = input.replace("!", ".");
		return replaced;
	}
}