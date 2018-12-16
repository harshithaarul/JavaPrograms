
class Card {
	private int[][] numArr = new int[5][5];
	private boolean[][] mrkArr = new boolean[5][5];
	public Card(int[][] numbers) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <5; j++) {
				numArr[i][j] = numbers[i][j];
				mrkArr[i][j]= false;
			}
		}
	}
	
	public int getNumber(int Row, int Column) {
		return numArr[Row][Column];
	}

	public boolean isMarked(int row, int column) {
		return mrkArr[row][column];
	}

	public void markNumber(int number) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <5; j++) {
				if (!mrkArr[i][j])
					mrkArr[i][j]= (number == numArr[i][j]);
			}
		}
	}
}
