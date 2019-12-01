package maze;

public class Room {
	
	private Door n, e, s, w;
	private boolean entrance, exit;
	
	public Room() {
		n = new Door();
		e = new Door();
		s = new Door();
		w = new Door();
		entrance = false;
		exit = false;
	}
	
	public Room(Door north, Door east, Door south, Door west, boolean entrance, boolean exit) {
		n = north;
		e = east;
		s = south;
		w = west;
		this.entrance = entrance;
		this.exit = exit;
	}
	/**
	 * I'm adding this constructor for now because I think adding the Door obj's as parameters isn't
	 * necessary. 
	 * @param entrance
	 * @param exit
	 */
	public Room(boolean entrance, boolean exit) {
		this.n = new Door();
		this.e = new Door();
		this.s = new Door();
		this.w = new Door();
		this.entrance = entrance;
		this.exit = exit;
	}
	
	public boolean getEntrance() {
		return entrance;
	}
	
	public boolean getExit() {
		return exit;
	}
	
	//Do we need setters for entrance/exit?
	//Steven: I like that it's done in the constructor call.
	
	
	public String toString() {
		String result = "";
		result += "North: " + ((n.getLocked() == true) ? "Locked" : "Unlocked");
		result += "\nEast: " + ((e.getLocked() == true) ? "Locked" : "Unlocked");
		result += "\nSouth: " + ((s.getLocked() == true) ? "Locked" : "Unlocked");
		result += "\nWest: " + ((w.getLocked() == true) ? "Locked" : "Unlocked");		
		
		return result;
	}
	
	public Door getDoor(String direction) {
		switch (direction) {
		case "n":
			return n;
		case "e":
			return e;
		case "s":
			return s;
		case "w":
			return w;
		}
		
		return n;
	}
	/**
	 * sets a door specified by direction, to be a wall or not
	 * @param direction
	 * @param wall 
	 */
	public void setWall(String direction, boolean wall) {
		switch(direction) {
			case "n":
				n.setWall(wall);
				break;
			case "e":
				e.setWall(wall);
				break;
			case "s":
				s.setWall(wall);
				break;
			case "w":
				w.setWall(wall);
				break;
		}
	}
	
	/**
	 * sets a door specified by direction, locked or unlocked
	 * @param direction
	 * @param locked
	 */
	public void setDoor(String direction, boolean locked) { // maybe change direction to char to be consistent with regex
		switch (direction) {
		case "n":
			n.setLocked(locked);
			break;
		case "e":
			e.setLocked(locked);
			break;
		case "s":
			s.setLocked(locked);
			break;
		case "w":
			w.setLocked(locked);
			break;
		}
	}

}
