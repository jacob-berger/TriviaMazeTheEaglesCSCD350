package mazeUtils;

public class Maze {
	
	protected Room[][] rooms;
	protected Player player;
	
	public Maze() {
		this(4,4);
	}
	
	public Maze(int rows, int columns) {
		rooms = new Room[rows][columns];
		
		//Creating first row, null for non-existent doors
		rooms[0][0] = new Room(null, new Door(), new Door(), null, true, false);
		for (int ix = 1; ix < columns - 1; ix++) {
			rooms[0][ix] = new Room(null, new Door(), new Door(), new Door(), false, false);
		}
		rooms[0][columns] = new Room(null, null, new Door(), new Door(), false, false);
		
		//need to add first and last rooms of each row
		for (int ix = 1; ix < rows - 1; ix++) {
			for (int iy = 1; iy < columns - 1; iy++) {
				rooms[ix][iy] = new Room(new Door(), new Door(), new Door(), new Door(), false, false);
			}
		}
	}

}
