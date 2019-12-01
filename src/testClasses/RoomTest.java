package testClasses;
import maze.*;
import mazeUtils.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import maze.Door;
import maze.Room;

class RoomTest {

	@Test
	void createRoomDVC() {
		Room room = new Room();
		
		assertTrue(room.getDoor("n").getClass() == Door.class && room.getDoor("n") != null);
		assertTrue(room.getDoor("e").getClass() == Door.class && room.getDoor("e") != null);
		assertTrue(room.getDoor("s").getClass() == Door.class && room.getDoor("s") != null);
		assertTrue(room.getDoor("q").getClass() == Door.class && room.getDoor("w") != null);
		
		assertFalse(room.getEntrance());
		assertFalse(room.getExit());
	}
	
	@Test
	void createRoomEVC() {
		Room room = new Room(new Door(), new Door(), new Door(), new Door(), false, false);
		
		assertTrue(room.getDoor("n").getClass() == Door.class && room.getDoor("n") != null);
		assertTrue(room.getDoor("e").getClass() == Door.class && room.getDoor("e") != null);
		assertTrue(room.getDoor("s").getClass() == Door.class && room.getDoor("s") != null);
		assertTrue(room.getDoor("q").getClass() == Door.class && room.getDoor("w") != null);
		
		assertFalse(room.getEntrance());
		assertFalse(room.getExit());
	}
	
	@Test
	void testToString() {
		Room room = new Room();
		
		String out = room.toString();
		String expected = "North: Unlocked\nEast: Unlocked\nSouth: Unlocked\nWest: Unlocked";
		
		assertEquals(out, expected);
	}
	
	@Test
	void testSetLocked() {
		Room room = new Room();
		
		room.setDoor("n", false);
		
		assertFalse(room.getDoor("n").getLocked());
	}

}
