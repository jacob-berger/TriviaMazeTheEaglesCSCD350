package maze;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	void testPlayerDVC() {
		Player player = new Player();
		
		assertNotNull(player);
		assertEquals(player.getName(), "Default");
		assertTrue(player.getR() == 0);
		assertTrue(player.getC() == 0);
	}
	
	@Test
	void testPlayerNameConstructor() {
		Player player = new Player("Mr. Tester");
		
		assertEquals(player.getName(), "Mr. Tester");
		assertTrue(player.getR() == 0);
		assertTrue(player.getC() == 0);
	}
	
	@Test
	void testPlayerLocationConstructor() {
		Player player = new Player(new int[] {1,2});
		
		assertEquals(player.getName(), "Default");
		assertTrue(player.getR() == 1);
		assertTrue(player.getC() == 2);
	}

	@Test
	void testPlayerStringLocationConstructor() {
		Player player = new Player("Mr. Tester", new int[] {1,2});
		
		assertEquals(player.getName(), "Mr. Tester");
		assertTrue(player.getR() == 1);
		assertTrue(player.getC() == 2);
	}

	@Test
	void testSetLocation() {
		Player player = new Player();
		player.setLocation(1, 2);
		
		assertTrue(player.getR() == 1);
		assertTrue(player.getC() == 2);
	}

	@Test
	void testGetName() {
		Player player = new Player();
		
		assertEquals(player.getName(), "Default");
	}

	@Test
	void testGetR() {
		Player player = new Player(new int[] {2,3});
		
		assertTrue(player.getR() == 2);
	}

	@Test
	void testGetC() {
		Player player = new Player(new int[] {2,3});
		
		assertTrue(player.getC() == 3);
	}

	@Test
	void testCanMove() {
		Player player = new Player();
		Room room = new Room(null, new Door(), new Door(), null, false, false);
		
		assertFalse(player.canMove(room, "n"));
		assertTrue(player.canMove(room, "e"));
		assertTrue(player.canMove(room, "s"));
		assertFalse(player.canMove(room, "w"));
	}

	@Test
	void testMove() {
		Player player = new Player();
		Room room = new Room(new Door(), new Door(), new Door(), new Door(), false, false);
		
		player.move("e");
		assertTrue(player.getR() == 0);
		assertTrue(player.getC() == 1);
		
		player.move("s");
		assertTrue(player.getR() == 1);
		assertTrue(player.getC() == 1);
		
		player.move("w");
		assertTrue(player.getR() == 1);
		assertTrue(player.getC() == 0);
		
		player.move("n");
		assertTrue(player.getR() == 0);
		assertTrue(player.getC() == 0);
		
		assertThrows(IllegalArgumentException.class, () -> {player.move("r");});
	}

}
