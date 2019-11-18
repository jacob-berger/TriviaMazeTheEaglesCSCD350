package maze;

public class Player {
	
	protected int[] location;
	protected String name;
	
	public Player() {
		this("Default", new int[] {0,0});
	}
	
	public Player(String name) {
		this(name, new int[] {0,0});
	}
	
	public Player(int[] location) {
		this("Default", location);
	}
	
	public Player(String name, int[] location) {
		this.name = name;
		this.location = location;
	}
	
	public void setLocation(int r, int c) {
		location[0] = r;
		location[1] = c;
	}
	
	public String getName() {
		return this.name;
	}
	
	protected int getR() {
		return location[0];
	}
	
	protected int getC() {
		return location[1];
	}
	
	protected boolean canMove(Room room, String direction) {
		//if the door in this direction is unlocked, movement is possible;
		return (room.getDoor(direction) == null) ? false : !room.getDoor(direction).getLocked();
	}
	
	protected void move(String direction) throws IllegalArgumentException {
		switch (direction) {
		case "n":
			this.setLocation(this.getR() - 1, this.getC());
			break;
		case "e": 
			this.setLocation(this.getR(), this.getC() + 1);
			break;
		case "s": 
			this.setLocation(this.getR() + 1, this.getC());
			break;
		case "w":
			this.setLocation(this.getR(), this.getC() - 1);
			break;
		default:
			throw new IllegalArgumentException("Invalid direction specified");	
		}
	}

}
