package maze;

//test
public class Maze {
	
	private Room[][] rooms;
	private Player player;
	private boolean EndReachable = true;
	
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
	public Maze() {
		
		generateMaze(4,4);
		player = new Player();
		
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
					rooms[searchR][searchC] = new Room(false, true);
					rooms[searchR][searchC].setDoor("n", true);
					rooms[searchR][searchC].setDoor("w", true);
				}
				else if(searchR == rows - 1 && searchC == columns - 1) {
					rooms[searchR][searchC] = new Room(true, false);
					rooms[searchR][searchC].setDoor("s", true);
					rooms[searchR][searchC].setDoor("e", true);
				}
				else {
					if(rooms[searchR][searchC] == null) {
						rooms[searchR][searchC] = new Room();	
					}					
					if(searchR == 0) {
						rooms[searchR][searchC].setDoor("n", true);
					}
					else if(searchR == rows - 1) {
						rooms[searchR][searchC].setDoor("s", true);
					}
					else if(searchC == 0) {
						rooms[searchR][searchC].setDoor("s", true);
					}
					else if(searchC == columns - 1) {
						rooms[searchR][searchC].setDoor("e", true);
					}
				}
			}
		}
	}
	
	
	
	
/*	
	
	public Maze(int rows, int columns) {
		this.rooms = new Room[rows][columns];
		
		//Creating first row, null for non-existent doors
		this.rooms[0][0] = new Room(null, new Door(), new Door(), null, true, false);
		for (int ix = 1; ix < columns - 1; ix++) {
			this.rooms[0][ix] = new Room(null, new Door(), new Door(), new Door(), false, false);
		}
		this.rooms[0][columns] = new Room(null, null, new Door(), new Door(), false, false);
		
		//need to add first and last rooms of each row
		for (int ix = 1; ix < rows - 1; ix++) {
			for (int iy = 1; iy < columns - 1; iy++) {
				this.rooms[ix][iy] = new Room(new Door(), new Door(), new Door(), new Door(), false, false);
			}
		} 
	}
*/
	
	
}
