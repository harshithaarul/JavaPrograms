import java.util.Scanner;
class Minesweeper {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int row = scnr.nextInt();
		int col = scnr.nextInt();
		String [][] array = new String[row][col];
		int[][] locArray = new int[row][col];
		
		//setting all values of array to empty rather than null
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				array[i][j] = " ";
				locArray[i][j] = 0;
			}
		}
		
		int numOfBombs = scnr.nextInt();
		
		bombs (scnr, array, locArray, numOfBombs, row, col);
		
		count (locArray, row, col);
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (!array[i][j].equals("*")) {
					array[i][j] = String.valueOf(locArray[i][j]);
				}
			}
		}
		
		// print array
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (j == col-1) {
					System.out.print(array[i][j]);
				}else {
					System.out.print(array[i][j]+ " ");
				}
			}
			System.out.println();
		}
	}
	
	// setting the bombs in the right place
	static String[][] bombs (Scanner scnr, String[][] array, int[][] locArray, int numOfBombs, int row, int col){
		int row1 = 0;
		int col1 = 0;
		
		for (int h = 0; h <numOfBombs; h++) {
			row1 = scnr.nextInt();
			col1 = scnr.nextInt();
			
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (i == row1 && j == col1) {
						array[i][j] = "*";
						locArray[i][j] = 9;
					}
				}
			}
		}
		return array;
	}
	
	// counting bombs
	static int[][] count (int[][] locArray, int row, int col){
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i > 0 && j >0 && i <row-1 && j <col-1) {
					// middle
					if (locArray[i][j] >= 9) {
						locArray[i-1][j]++;
						locArray[i+1][j]++;
						locArray[i][j-1]++;
						locArray[i][j+1]++;
						locArray[i+1][j+1]++;
						locArray[i-1][j-1]++;
						locArray[i+1][j-1]++;
						locArray[i-1][j+1]++;
					}
					//middle of the top
				}else if (i == 0 && j > 0 && j < col-1) {
					if (locArray[i][j] >= 9) { 
						locArray[i+1][j]++;
						locArray[i][j-1]++;
						locArray[i][j+1]++;
						locArray[i+1][j+1]++;
						locArray[i+1][j-1]++;
					}
					// top right
				} else if (i == 0 && j == 0) {
					if (locArray[i][j] >= 9) {
						locArray[i+1][j]++;
						locArray[i][j+1]++;
						locArray[i+1][j+1]++;
					}
					// top left
				}else if (i == 0 && j == col-1) {
					if (locArray[i][j] >= 9) {
						locArray[i+1][j]++;
						locArray[i][j-1]++;
						locArray[i+1][j-1]++;
					}
				// bottom middle
				}else if (i == row-1 && j > 0 && j < col-1) {
					if (locArray[i][j] >= 9) { 
						locArray[i][j-1]++;
						locArray[i][j+1]++;
						locArray[i-1][j]++;
						locArray[i-1][j-1]++;
						locArray[i-1][j+1]++;
					}
					// bottom left
				}else if (i == row-1 && j == 0) {
					if (locArray[i][j] >= 9) {
						locArray[i-1][j]++;
						locArray[i][j+1]++;
						locArray[i-1][j+1]++;
					}
					// bottom right
				}else if (i == row-1 && j == col-1) {
					if (locArray[i][j] >= 9) {
						locArray[i-1][j]++;
						locArray[i][j-1]++;
						locArray[i-1][j-1]++;
					}
					
				} else if (j == 0 && i >0 && i < row-1) {
					if (locArray[i][j] >= 9) {
						locArray[i-1][j]++;
						locArray[i+1][j]++;
						locArray[i][j+1]++;
						locArray[i-1][j+1]++;
						locArray[i+1][j+1]++;
					}
					
				}else if (j == col-1 && i >0 && i < row-1) {
					if (locArray[i][j] >= 9) {
						locArray[i-1][j]++;
						locArray[i+1][j]++;
						locArray[i][j-1]++;
						locArray[i-1][j-1]++;
						locArray[i+1][j-1]++;
					}
				}
			}
		}
		return locArray;
	}
}

