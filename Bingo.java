
class Bingo {
	private Player[] myPlayers;
	private String winnersList = "";
	private int winnersCount = 0;
	public Bingo (Player[] players) {
		myPlayers = new Player[players.length];
		for (int i = 0; i <players.length; i++) {
			myPlayers[i] = players[i];
		}
		winnersList = "";
		winnersCount = 0;
	}
	public String play (int number) {
		for (int i = 0; i <myPlayers.length; i++) {
			myPlayers[i].markNumber(number);
			if (myPlayers[i].isWinner()) {
				winnersList += myPlayers[i].getName() + " ";
				winnersCount++;
			}
		}
		if (winnersCount > 0)
		{
			winnersList = winnersList.substring(0, winnersList.length()-1);
		}
		return winnersList;
	}


}
