// READ ME
// YOUR SHOULD ONLY SUBMIT YOUR CODE IN Bingo.java, BUT NOT BingoTest.java
//
// PLEASE REMOVE THE PUBLIC DECLARATION BEFORE SUBMITTING
// ie: public class Clock -> class Clock
// 
// Make sure that you remove the reference to the eclipse package that you are in.
// ie: package Assignment3 <-- delete this whole line

class Clock {
	private int currentTime;
	public Clock() {
		currentTime = 0;
	}
	public Clock(int h) {
		currentTime = h*60;
	}
	public Clock(int h, int m) {
		currentTime = h*60 + m;
	}
	public int getHour() {
		return currentTime/60;
	}
	public int getMinute() {
		return currentTime%60;
	}
	public void incrementTimer() {
		if(currentTime<1439) currentTime++;
		else currentTime = 0;
	}
	public void incrementTimer (int x) {
		if((currentTime+x)<1439) currentTime+=x;
		else currentTime = (currentTime+x)%1440;

	}
	public void setTime(int h, int m) {
		if (h < 23 && m < 60) {
			currentTime = h*60 + m;
		} else {
			System.out.println("Invalid Input");
		}

	}
	// 12 P.M
	public String toString() {
		int hr24 = 0;
		int hr12 = 0;
		int min = 0;
		int ampm = 0;
		String []ampmStr = new String[2];
		ampmStr[0] = "AM";
		ampmStr[1] = "PM";
		hr24 = currentTime/60;// 12
//		if(hr24!=0) hr12 = hr24%12; // error is happening here
//		else hr12 = 12;
		if (hr24 == 0) {
			hr12 = 12;
		}else if (hr24 == 12) {
			hr12 = 12;
		}else {
			hr12 = hr24%12;
		}
		ampm = hr24/12;
		min = currentTime%60;
		String hr12fmt = String.format("%02d", hr12);
		String minfmt = String.format("%02d", min);
		String outputTime = hr12fmt+":"+minfmt+" "+ampmStr[ampm];
		return outputTime;
		
		
	}
}
