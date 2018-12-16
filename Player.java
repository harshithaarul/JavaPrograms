
class Player {
	private String myName;
	private Card[] myCards;
	private boolean isWinner = false;
	
	public Player (String name, Card[] cards) {
		myName = name;
		myCards = new Card[cards.length];
		for (int i = 0; i <cards.length; i++) {
			myCards[i] = cards[i];
		}
	}
	public String getName() {
		return myName;
	}
	public Card[] getCards() {
		return myCards;
	}
	public boolean isWinner() {
		return isWinner;
	}
	public void markNumber(int number) {
		for (int i = 0; i <myCards.length; i++) {
			myCards[i].markNumber(number);
			isWinner = isCardBingo(myCards[i]);
			if(isWinner) break;
		}
		
	}
	private boolean isCardBingo (Card card) {
		int matchCount = 0;
		boolean isBingo = false;
		for (int j = 0; j <5; j++) {
			for (int k = 0; k <5; k++) {
				if(card.isMarked(j, k)) matchCount++;
			}
			if (matchCount==5) {
				isBingo = true;
				break;
			}
			matchCount = 0;
		}
		return isBingo;
	}
}

