package maze;

import mazeUtils.QuestionHandler;

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
	
	private void setPlayer(Player newPlayer) { // may not need this
		this.player = newPlayer;
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

		switch(direction) {
		case 'n':
			if(!rooms[r][c].getDoor(directionString).getLocked()) {
				if(this.questionHandler.handleQuestion(rooms[r][c].getDoor(directionString))) {
					System.out.println("CORRECT");
					System.out.println("Moving north.");
					setPlayerLoc(r - 1, c);
				}
				else {
					System.out.println("INCORRECT");
					System.out.println("DOOR: LOCKED");
					rooms[r][c].getDoor(directionString).setLocked(true);
				}
			}
			else {
				System.out.println("Door is locked.");
			}
			break;
		case 'e':
			if(!rooms[r][c].getDoor(directionString).getLocked()) {
				if(this.questionHandler.handleQuestion(rooms[r][c].getDoor(directionString))) {
					System.out.println("CORRECT");
					System.out.println("Moving East.");
					setPlayerLoc(r, c + 1);
				}
				else {
					System.out.println("INCORRECT");
					System.out.println("DOOR: LOCKED");
					rooms[r][c].getDoor(directionString).setLocked(true);
				}

			}
			else {
				System.out.println("Door is locked.");
			}
			break;
		case 's':
			if(!rooms[r][c].getDoor(directionString).getLocked()) {
				if(this.questionHandler.handleQuestion(rooms[r][c].getDoor(directionString))) {
					System.out.println("CORRECT");
					System.out.println("Moving South.");
					setPlayerLoc(r + 1, c);
				}
				else {
					System.out.println("INCORRECT");
					System.out.println("DOOR: LOCKED");
					rooms[r][c].getDoor(directionString).setLocked(true);
				}

			}
			else {
				System.out.println("Door is locked.");
			}
			break;
		case 'w':
			if(!rooms[r][c].getDoor(directionString).getLocked()) {
				if(this.questionHandler.handleQuestion(rooms[r][c].getDoor(directionString))) {
					System.out.println("CORRECT");
					System.out.println("Moving West.");
					setPlayerLoc(r, c - 1);
				}
				else {
					System.out.println("INCORRECT");
					System.out.println("DOOR: LOCKED");
					rooms[r][c].getDoor(directionString).setLocked(true);
				}

			}
			else {
				System.out.println("Door is locked.");
			}
			break;
		}
		System.out.println(getPlayerLoc());
		System.out.println();
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
}
