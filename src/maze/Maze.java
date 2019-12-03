package maze;

import mazeUtils.*;

//test
public class Maze{
	
	public Room[][] rooms;
	private int[] playerLoc = {0, 0}; // {r, c}
	private Player player;
	private boolean endReachable = true;
	private QuestionHandler questionHandler = new QuestionHandler();
	private int rows;
	private int columns;
	
	/*
	 * Maze generates an array of Rooms and a single player.
	 * Maze doesn't keep know the state of the Rooms or Player.
	 * EndReachable will keep track whether the player is able 
	 * to reach the exit or not.
	 */
	
	/**
	 * This constructor is a place holder in case we decide
	 * to implement different sizes of Maze. For now a 4x4
	 * maze will be generated on instantiation. 
	 */
	public Maze(int rows, int columns, Player player) {
		this.rows = rows;
		this.columns = columns;
		
		this.player = player;
		setPlayerLoc(0,0);
		
		generateMaze(rows,columns);
	}

	public String getPlayerName() {
		return this.player.name;
	}
	
	public int getRows() {
		return this.rows;
	}
	
	public int getColumns() {
		return this.columns;
	}
	
	public boolean didPlayerWin(){
		if((this.playerLoc[0] == this.rows - 1) && (this.playerLoc[1] == this.columns - 1)) {
			return true;
		}
		return false;
	}
	
	public String getPlayerLoc() {
		
		return "Player Location: R: " + this.playerLoc[0] + " C: " + this.playerLoc[1];
	}
	/**
	 * if door is unlocked in specified direction then movement will be 
	 * allowed and player location is updated.
	 * @param direction trying to move
	 */
	public void movePlayer(char direction) {
		int r = this.playerLoc[0];
		int c = this.playerLoc[1];
		
		String directionString = direction + "";
		
		if(!this.rooms[r][c].getDoor(directionString).getLocked()) {
			if(!(this.rooms[r][c].getDoor(directionString).getQuestionAnswered())) {
				if(this.questionHandler.handleQuestion(rooms[r][c].getDoor(directionString))) {
					System.out.println("-----CORRECT-----");
					System.out.println(PrintMaze.dungeonMasterDisplayUnhappy());
					this.rooms[r][c].getDoor(directionString).setQuestionAnswered(true);
				}
				else {
					System.out.println("-----INCORRECT-----");
					System.out.println(PrintMaze.dungeonMasterDisplaySmug());
					System.out.println("DOOR: LOCKED");
					this.rooms[r][c].getDoor(directionString).setLocked(true);
				}
			}
		}
		else {
			if(this.rooms[r][c].getDoor(directionString).getWall()) {
				System.out.println("You can't walk through walls.");
			}
			else {
				System.out.println("The Door is locked.");
			}
		}
		if(this.rooms[r][c].getDoor(directionString).getQuestionAnswered()) {
			switch(direction) {
			case 'n':
				System.out.println("Moving north.");
				setPlayerLoc(r - 1, c);
				break;
			case 'e':
				System.out.println("Moving East.");
				setPlayerLoc(r, c + 1);
				break;
			case 's':
				System.out.println("Moving South.");
				setPlayerLoc(r + 1, c);
				break;
			case 'w':
				System.out.println("Moving West.");
				setPlayerLoc(r, c - 1);
				break;
			}
		}
		
		System.out.println("Current Location: " + getPlayerLoc());
		System.out.print(PrintMaze.displayRoom(this.rooms, this.playerLoc, getRows(), getColumns()));
	}	
	/**
	 * player location is updated in the maze and in the player
	 * object.
	 */
	private void setPlayerLoc(int r, int c) { // location needs to be varified
		this.playerLoc[0] = r;
		this.playerLoc[1] = c;
		
		this.player.setLocation(r, c);
	}
	
	/**
	 * generateMaze fills each element of Room[][] with a new Room and sets all
	 * room's edge doors to closed. Entrance and exit rooms are set.
	 * @param rows
	 * @param columns
	 */
	private void generateMaze(int rows, int columns) {
		this.rooms = new Room[rows][columns];
		
		for(int searchR = 0; searchR < rows; searchR ++) {
			for(int searchC = 0; searchC < columns; searchC ++) {
				if(searchR == 0 && searchC == 0) {
					this.rooms[searchR][searchC] = new Room(false, true);
					this.rooms[searchR][searchC].setDoor("n", true);					
					this.rooms[searchR][searchC].setWall("n", true);
					this.rooms[searchR][searchC].setDoor("w", true);
					this.rooms[searchR][searchC].setWall("w", true);
				}
				else if(searchR == rows - 1 && searchC == columns - 1) {
					this.rooms[searchR][searchC] = new Room(true, false);
					this.rooms[searchR][searchC].setDoor("s", true);
					this.rooms[searchR][searchC].setWall("s", true);
					this.rooms[searchR][searchC].setDoor("e", true);
					this.rooms[searchR][searchC].setWall("e", true);
				}
				else {
					if(this.rooms[searchR][searchC] == null) {
						this.rooms[searchR][searchC] = new Room();	
					}					
					if(searchR == 0) {
						this.rooms[searchR][searchC].setDoor("n", true);
						this.rooms[searchR][searchC].setWall("n", true);
					}
					if(searchR == rows - 1) {
						this.rooms[searchR][searchC].setDoor("s", true);
						this.rooms[searchR][searchC].setWall("s", true);
					}
					if(searchC == 0) {
						this.rooms[searchR][searchC].setDoor("w", true);
						this.rooms[searchR][searchC].setWall("w", true);
					}
					if(searchC == columns - 1) {
						rooms[searchR][searchC].setDoor("e", true);
						rooms[searchR][searchC].setWall("e", true);
					}
				}
			}
		}
	}
	
	/**
	 * getEndReachable updates endReachable variable by calling updateEndReachable passing
	 * it the players current position. 
	 * 
	 * @return boolean endReachable
	 */
	
	public boolean getEndReachable() {

		boolean[][] path = new boolean[this.rows][this.columns];
		
		this.endReachable = updateEndReachable(false, path, this.playerLoc[0], this.playerLoc[1]);
		
		return this.endReachable;
	}
	/**
	 * 
	 * @param path is a 2d array keeping track of rooms visited while trying to find path
	 * to the exit. 
	 * @param r players position in rows
	 * @param c players position in columns
	 * @return boolean telling if the end is reachable from players position
	 */
	private boolean updateEndReachable(boolean gotEnd, boolean[][] path, int r, int c) {
		path[r][c] = true; // set room to unavailable (visited)
		if(r == getRows() -1 && c == getColumns() - 1) {
			gotEnd = true;
			return true;
		}
		if((!gotEnd && !rooms[r][c].getDoor("n").getLocked()) && !path[r - 1][c]) {
			gotEnd = updateEndReachable(gotEnd, path, r - 1, c);
		}
		if((!gotEnd && !rooms[r][c].getDoor("e").getLocked()) && !path[r][c + 1]) {
			gotEnd = updateEndReachable(gotEnd, path, r, c + 1);
		}
		if((!gotEnd && !rooms[r][c].getDoor("s").getLocked()) && !path[r + 1][c]) {
			gotEnd = updateEndReachable(gotEnd, path, r + 1, c);
		}
		if((!gotEnd && !rooms[r][c].getDoor("w").getLocked()) && !path[r][c - 1]) {
			gotEnd = updateEndReachable(gotEnd, path, r, c - 1);
		}
		path[r][c] = false; // set room available (unvisited)
		
		if(gotEnd) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	
	
/*
	private String displayRoom(int row, int col, int[] loc, Room[][] rooms) {
		String roomString = "";		
		Room room = rooms[row][col];
		
		Door nD = room.getDoor("n");
		Door eD = room.getDoor("e");
		Door sD = room.getDoor("s");
		Door wD = room.getDoor("w");

		
		if(nD.getWall()) {
			roomString += "  __________\n";
			roomString += " |          |\n";
		}
		else if(nD.getLocked()) {
			roomString += "  ___/__\\___\n";
			roomString += " |     X    |\n";
		}
		else if(nD.getQuestionAnswered()) {
			roomString += "  ___\\  /___\n";
			roomString += " |          |\n";
		}
		else {
			roomString += "  ___\\  /___\n";
			roomString += " |          |\n";
		}
		
		
		
		if(wD.getWall()) {
			roomString += " |          ";
			roomString += eastWall(1, eD);
			
			if(row == loc[0] && col == loc[1]) {
				roomString += " |     P    ";
				roomString += eastWall(2, eD);
			}
			else {
				roomString += " |          ";
				roomString += eastWall(2, eD);
			}
			roomString += " |          ";
			roomString += eastWall(3, eD);
		}		
		else if(wD.getLocked()) {
			roomString += " /|          ";
			roomString += eastWall(1, eD);
			
			if(row == loc[0] && col == loc[1]) {
				roomString += " X     P    ";
				roomString += eastWall(2, eD);
			}
			else {
				roomString += " X          ";
				roomString += eastWall(2, eD);
			}
			roomString += "\\|          ";
			roomString += eastWall(3, eD);
		}	
		else if(wD.getQuestionAnswered()) {
			roomString += "\\|          ";
			roomString += eastWall(1, eD);
			
			if(row == loc[0] && col == loc[1]) {
				roomString += "       P    ";
				roomString += eastWall(2, eD);
			}
			else {
				roomString += "            ";
				roomString += eastWall(2, eD);
			}
			roomString += "/|          ";
			roomString += eastWall(3, eD);
		}
		else {
			roomString += "\\|          ";
			roomString += eastWall(1, eD);
			
			if(row == loc[0] && col == loc[1]) {
				roomString += " |     P    ";
				roomString += eastWall(2, eD);
			}
			else {
				roomString += " |          ";
				roomString += eastWall(2, eD);
			}
			roomString += "/|          ";
			roomString += eastWall(3, eD);
		}
		
		if(sD.getWall()) {
			roomString += " |__________|";
		}
		else if(sD.getLocked()) {
			roomString += " |_____X____|\n";
			roomString += "     \\ /";
		}
		else if(sD.getQuestionAnswered()) {
			roomString += " |____  ____|\n";
			roomString += "     /  \\";
			
		}
		else {
			roomString += " |__________|\n";
			roomString += "     /  \\";
		}
		
		return roomString;
	}
	
	private String eastWall(int wallNum, Door eD) {
		String room = "";
		
		if(eD.getWall()) {
			room += "|\n";
		}
		else if(eD.getLocked()) {
			switch(wallNum) {
			case 1:
				room += "|\\\n";
				break;
			case 2:
				room += "X\n";
				break;
			case 3:
				room += "|/\n";
				break;
			}
		}
		else if(eD.getQuestionAnswered()) {
			switch(wallNum) {
			case 1:
				room += "|/\n";
				break;
			case 2:
				room += "\n";
				break;
			case 3:
				room += "|\\\n";
				break;
			}
		}
		else {
			switch(wallNum) {
			case 1:
				room += "|/\n";
				break;
			case 2:
				room += "|\n";
				break;
			case 3:
				room += "|\\\n";
				break;
			}
		}
	
		return room;
	}	*/	
}
