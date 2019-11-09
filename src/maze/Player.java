package maze;

public class Player {
	
	protected int[] location;
	protected String name;
	protected Maze maze;
	
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
	
	private void setLocation(int x, int y) {
		location[0] = x;
		location[1] = y;
	}
	
	protected int getX() {
		return location[0];
	}
	
	protected int getY() {
		return location[1];
	}
	
	protected boolean canMove(Room room, String direction) {
		//if the door in this direction is unlocked, movement is possible;
		return (room.getDoor(direction) == null) ? false : !room.getDoor(direction).getLocked();
	}
	
	protected void move(String direction) {
		switch (direction) {
		case "North":
			this.setLocation(this.getX() - 1, this.getY());
			break;
		case "East": 
			this.setLocation(this.getX(), this.getY() + 1);
			break;
		case "South": 
			this.setLocation(this.getX() + 1, this.getY());
			break;
		case "West":
			this.setLocation(this.getX(), this.getY() - 1);
		}
	}

}
