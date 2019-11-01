package mazeUtils;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DoorTest {

	@Test
	void testDoor() {
		Door door = new Door();
		
		assertTrue(door.getLocked());
		assertTrue(door.getQuestion().getClass() == Question.class);
	}

	@Test
	void testGetLocked() {
		Door door = new Door();
		
		assertTrue(door.getLocked());
	}

	@Test
	void testSetLocked() {
		Door door = new Door();
		
		door.setLocked(false);
		
		assertFalse(door.getLocked());
	}

	@Test
	void testGetQuestion() {
		Door door = new Door();
		
		assertTrue(door.getQuestion().getClass() == Question.class);
		assertTrue(door.getQuestion() != null);
	}
}
