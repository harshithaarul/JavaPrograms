// READ ME
// Copy and paste all of your code into here.
// PLEASE REMOVE THE PUBLIC DECLARATION BEFORE SUBMITTING
// ie public class Game -> class Game
//
// 
// Make sure that you remove the reference to the eclipse package
// that you are in.
// ie 
//    package Assignment4 <-- delete this whole line
// Also be sure to remove any import statements we will import
// any libraries required for the assignment
class Game {
	Board board;
	Player[] playerArr = null;
	private int playerCount = 0;
	private boolean isWinner;
	private boolean gameOver;
	private int currentPlayer;
	public Game(Board board, Player[] players) {
		if(board!=null && players!=null) {
			this.board = board;
			playerArr = new Player[4];
			for(int i=0; i<4; i++) playerArr[i] = null;
			if(players.length<4) playerCount = players.length;
			else playerCount = 4;
			Cell[] cells = board.getCells();
			for(int i = 0; i<playerCount; i++) {
				playerArr[i] = players[i];
				playerArr[i].setPosition(0);
				cells[0].setOccupied(true);
			}
		}
		else if(board!=null) {
			this.board = board;
			playerArr = new Player[4];
			for(int i=0; i<4; i++) playerArr[i] = null;
			playerCount = 0;
		}
		currentPlayer = 0;
		isWinner = false;
		gameOver = false;
	}
	public Game(Player[] players) {
		this(new Board(10), players);
	}
	public Player currentPlayer() {
		if(playerArr != null) return playerArr[currentPlayer];
		return null;
	}
	public void addPlayer(Player p) {
		if(playerCount<4 && p!=null && playerArr!=null) {
			Cell[] cells = board.getCells();
			if(cells!=null) {
				playerArr[playerCount] = p;
				playerArr[playerCount].setPosition(0);
				cells[0].setOccupied(true);
				playerCount++;
			}
		}
	}
	public boolean winner() {
		return isWinner;
	}
	public void movePlayer (int n) {//check to see if head if snake, bottom of ladder, is the cell null;
		int lastCell = board.lastCell();
		Cell[] cells = board.getCells();
		if(cells == null || n==0) return;
		int previousPos = this.currentPlayer().getPosition();
		int targetPos = previousPos+n;
		if(targetPos > lastCell) targetPos = 0;
		for(int i = 0 ; i<= lastCell; i++) {

			if(cells[i].getSnake()!=null) {
				int tempPos = cells[i].getSnake().getHead();
				if(tempPos == targetPos) {
					targetPos = cells[i].getSnake().getTail();
					//System.out.println(currentPlayer().getName()+" found snake head at "+tempPos);
					break;
				}
			}
			if(cells[i].getLadder()!=null) {
				int tempPos = cells[i].getLadder().getEnd();
				if(tempPos == targetPos) {
					targetPos = cells[i].getLadder().getTop();
					//System.out.println(currentPlayer().getName()+" found ladder bottom at "+tempPos);
					break;
				}
			}
		}
		if(targetPos == lastCell) {
			isWinner = true;
			cells[targetPos].setOccupied(true);
			cells[previousPos].setOccupied(false);
			//System.out.println("Winner: "+playerArr[currentPlayer]);
			return;
		}
		else if(targetPos > lastCell || cells[targetPos].isOccupied()) targetPos = 0;
		//		System.out.println(this.currentPlayer().getName()+": "+previousPos + "->" + targetPos);
		this.currentPlayer().setPosition(targetPos);
		if(targetPos!=previousPos) {
			cells[targetPos].setOccupied(true);
			cells[previousPos].setOccupied(false);
		}
		currentPlayer = (currentPlayer+1)%playerCount;
	}
	public boolean play(int moveCount) {
		if(board!=null && this.playerArr!=null && board.cells!= null) {
			if(moveCount>0 && moveCount<7) {
				this.movePlayer(moveCount);
				if (this.winner()) gameOver = true;
				return gameOver;
			}
			else return true;
		}
		
		return true;

	}
	public Board getBoard() {
		return board;
	}
}

class Board {
	private int dimension = 0;
	private Ladder[] ladderArr = null;
	private int lCount = 0;
	private Snake[] snakeArr= null;
	private int sCount  = 0;
	Cell[] cells = null;
	public Board (int n) {
		if(n > 0) {
			ladderArr = new Ladder[100];
			snakeArr= new Snake[100];
			dimension = n*n;
			cells = new Cell[dimension];
			for(int i = 0; i<dimension;i++) {
				cells[i] = new Cell(i);
			}
			for(int i = 0; i<100;i++) {
				ladderArr[i] = new Ladder(100,100);
				snakeArr[i] = new Snake(100,100);
			}
		}
	}
	public void setCellToLadder (int startPosition, int endPosition) {
		if(endPosition>=dimension || endPosition==0 || startPosition > endPosition) return;
		Ladder l = new Ladder(startPosition, endPosition);
		ladderArr[lCount] = l;
		lCount++;
		cells[startPosition].setLadder(l);
	}

	public void setCellToSnake (int headPosition, int tailPosition) {
		if(headPosition>=dimension-1 || headPosition==0 || headPosition < tailPosition) return;
		Snake s = new Snake (headPosition, tailPosition);
		snakeArr[sCount] = s;
		sCount++;
		cells[headPosition].setSnake(s);
	}
	public Cell[] getCells() {
		return cells;
	}
	public int lastCell() {
		return dimension-1;
	}
}

class Player {
	private String playerName;
	private int pos;
	public Player (String name) {
		playerName = name;
		pos = 0;
	}
	public void setPosition (int position) {
		pos = position;
	}
	public int getPosition() {
		return pos;
	}
	public String getName() {
		return playerName;
	}
	public String toString() {
		return playerName + " @ " + pos;
	}
}
class Cell {
	private int cellNum = 0;
	Ladder l;
	Snake s;
	int playersInCell = 0;
	
	public Cell(int number) {
		cellNum = number;
		l = null;
		s = null;
		playersInCell = 0;
	}
	
	public void setOccupied (boolean occupied) { 
		if(occupied) playersInCell++;
		else if (playersInCell >0) playersInCell--;
		else playersInCell= 0;
	}
	public boolean isOccupied() { 
		return (playersInCell>0);
	}
	public Ladder getLadder() {
		return l; 

	}
	public Snake getSnake() {
		return s; 
	}
	public void setLadder(Ladder ladder) {
		if(ladder!=null) {
			l = ladder;
			ladder.setEnd(cellNum);
		}
	}
	public void setSnake(Snake snake) {
		if(snake!=null) {
			s = snake;
			snake.setHead(cellNum);
		}
	}
	public int getNumber() {
		return cellNum;
	}
}

class Ladder {
	private int bottom;
	private int top;

	public Ladder (int startPosition, int endPosition) {
		bottom = startPosition;
		top = endPosition;
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	public int getEnd() {
		return bottom;
	}
	public void setEnd(int bottom) {
		this.bottom= bottom;
	}
	public String toString() {
		return (bottom+" - "+top);
	}
}

class Snake {
	private int head;
	private int tail;

	public Snake (int headPosition, int tailPosition) {
		head = headPosition;
		tail = tailPosition;
	}

	public int getTail() {
		return tail;
	}
	public int getHead() {
		return head;
	}
	public void setHead(int top) {
		head = top;
	}
	public String toString() {
		return (head+" - "+tail);
	}
}