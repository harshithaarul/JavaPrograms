import java.util.Scanner;
public class PlayerRoster {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr = new Scanner(System.in);
		int[][] roster = new int[5][2];

		// print Input
		for (int i = 0; i < 5; i++) {
			System.out.println("Enter player " + (i + 1) + "'s jersey number:");
			System.out.println("Enter player " + (i + 1) + "'s rating:");
			System.out.println();
		}

		// store input
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 2; j++) {
				roster[i][j] = scnr.nextInt();
			}
		}

		// print Roster
		System.out.println("ROSTER");
		for (int j = 0; j < 5; j++) {
			System.out.println("Player " + (j + 1) + " -- Jersey number: " + roster[j][0] + ", Rating: " + roster[j][1]);
		}
		System.out.println();
		System.out.println("MENU\nu - Update player rating\na - Output players above a rating\nr - Replace player\no - Output roster\nq - Quit\n\nChoose an option:");
		String menu; 
		for (int i = 0;  i< 10; i++) {
			menu = scnr.next();
			if (menu.equalsIgnoreCase("u")){
				u(scnr, roster);

			}else if (menu.equalsIgnoreCase("a")) {
				a(scnr, roster);

			}else if (menu.equalsIgnoreCase("o")) {
				System.out.println("ROSTER");
				for (int j = 0; j < 5; j++) {
					System.out.println("Player " + (j + 1) + " -- Jersey number: " + roster[j][0] + ", Rating: " + roster[j][1]);
				}

			}else if (menu.equalsIgnoreCase("r")) {
				r(scnr, roster);

			}else if(menu.equalsIgnoreCase("q")) {
				break;
			}
		}

		// print menu
		System.out.println();
		System.out.println("MENU\nu - Update player rating\na - Output players above a rating\nr - Replace player\no - Output roster\nq - Quit\n\nChoose an option:");
	}

	static int[][] u (Scanner scnr, int[][] roster) {
		System.out.println("Enter a jersey number:");
		int jNum = scnr.nextInt();
		System.out.println("Enter a new rating for player: ");
		int nRate = scnr.nextInt();
		for (int i = 0; i <5; i++) {

			if (roster[i][0] == jNum) {
				roster[i][1] = nRate;
			}

		}
		return roster;
	}
	static void a (Scanner scnr, int[][] roster) {
		System.out.println("Enter a rating:");
		System.out.println();
		int compRate = scnr.nextInt();
		System.out.println("ABOVE " + compRate);
		for (int i = 0; i <5; i++) {
			if (roster[i][1] > compRate) {
				System.out.println("Player " + (i + 1) + " -- Jersey number: " + roster[i][0] + ", Rating: " + roster[i][1]);
			}
		}		
	}
	static int[][] r (Scanner scnr, int[][] roster) {
		System.out.println();
		System.out.println("MENU\nu - Update player rating\na - Output players above a rating\nr - Replace player\no - Output roster\nq - Quit\n\nChoose an option:");
		System.out.println("Enter a jersey number:");

		int jNum = scnr.nextInt();
		for (int i = 0; i <5; i++) {
			if (roster[i][0] == jNum) {
				System.out.println("Enter a new jersey number:");
				System.out.println("Enter a rating for the new player:");
				System.out.println();
				int jNumNew = scnr.nextInt();
				int nRate = scnr.nextInt();
				roster[i][0] = jNumNew;
				roster[i][1] = nRate;
				System.out.println("MENU\nu - Update player rating\na - Output players above a rating\nr - Replace player\no - Output roster\nq - Quit\n\nChoose an option:");
			}else if (roster[i][0] != jNum && i==4) {
				return roster;
			}
		}
		System.out.println("MENU\nu - Update player rating\na - Output players above a rating\nr - Replace player\no - Output roster\nq - Quit\n\nChoose an option:");
		return roster;
	}

}
