package mazeUtils;

public class Room {
	
	private Door n, e, s, w;
	private boolean entrance, exit;
	
	protected Room() {
		n = new Door();
		e = new Door();
		s = new Door();
		w = new Door();
		entrance = false;
		exit = false;
	}
	
	protected Room(Door north, Door east, Door south, Door west, boolean entrance, boolean exit) {
		n = north;
		e = east;
		s = south;
		w = west;
		this.entrance = entrance;
		this.exit = exit;
	}
	
	protected boolean getEntrance() {
		return entrance;
	}
	
	protected boolean getExit() {
		return exit;
	}
	
	//Do we need setters for entrance/exit?
	
	public String toString() {
		String result = "";
		result += "North: " + ((n.getLocked() == true) ? "Locked" : "Unlocked");
		result += "\nEast: " + ((e.getLocked() == true) ? "Locked" : "Unlocked");
		result += "\nSouth: " + ((s.getLocked() == true) ? "Locked" : "Unlocked");
		result += "\nWest: " + ((w.getLocked() == true) ? "Locked" : "Unlocked");
		
		return result;
	}
	
	protected Door getDoor(String direction) {
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
	
	protected void setDoor(String direction, boolean locked) {
		switch (direction) {
		case "n":
			n.setLocked(locked);
		case "e":
			e.setLocked(locked);
		case "s":
			s.setLocked(locked);
		case "w":
			w.setLocked(locked);
		}
	}

}
