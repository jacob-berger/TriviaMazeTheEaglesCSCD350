package mazeUtils;

public class Room {
	
	private Door n, e, s, w;
	private boolean entrance, exit;
	
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
		result += "North: " + n.getLocked();
		result += "\nEast: " + e.getLocked();
		result += "\nSouth: " + s.getLocked();
		result += "\nWest: " + w.getLocked();
		
		return result;
	}

}
