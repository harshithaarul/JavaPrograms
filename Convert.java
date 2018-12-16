import java.util.Scanner;
class convert{
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int hour = scnr.nextInt();
		int min = scnr.nextInt();
		int ampm = scnr.nextInt();
		String minute = Integer.toString(min);
		if (min <10) {
			minute = "0" + min;
		}
		if (ampm == 1) {
			if(hour == 12){
				System.out.println("00" +":"+minute);
			}else {
				if(hour <10) {
					System.out.println("0" + hour +":"+minute);
				}else {
					System.out.println(hour +":"+minute);
				}
			}
		} else {
			if(hour == 12){
				System.out.println(hour +":"+minute);
			}else {
			hour+=12;
			System.out.println(hour +":"+minute);
			}
		}


	}
}
		
