package maze;

import java.io.Serializable;

public class Player implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3644493377540918896L;
	protected int[] location;
	protected String name;
	private boolean cheating;
	
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
	
	public void setCheating(boolean state) {
		this.cheating = state;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean isCheating() {
		return this.cheating;
	}
	
	public int getR() {
		return location[0];
	}
	
	public int getC() {
		return location[1];
	}
	
	public boolean canMove(Room room, String direction) {
		//if the door in this direction is unlocked, movement is possible;
		return (room.getDoor(direction) == null) ? false : !room.getDoor(direction).getLocked();
	}
	
	public void move(String direction) {
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
