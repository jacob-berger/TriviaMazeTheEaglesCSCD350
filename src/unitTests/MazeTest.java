package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import maze.Maze;
import maze.Player;

class MazeTest {
	
	public Player player = new Player("Ian") ; 
	public Maze maze = new Maze(4,4,player) ; 
	
	

	@Test
	void testMaze() {
		assertNotNull(maze) ; 
	}

	@Test
	void testGetPlayerName() {
		assertEquals(maze.getPlayerName(), "Ian") ; 
		assertFalse(maze.getPlayerName().contentEquals("Bill")) ; 
	}

	@Test
	void testGetRows() {
		assertNotNull(maze.getRows()) ; 
		assertEquals(maze.getRows(), 4) ; 
	}

	@Test
	void testGetColumns() {
		assertNotNull(maze.getColumns()) ; 
		assertEquals(maze.getColumns(), 4) ; 
	}

	@Test
	void testDidPlayerWin() {
		assertFalse(maze.didPlayerWin()) ; 
		maze.setPlayerLoc(3, 3);
		assertTrue(maze.didPlayerWin()) ; 
	}

	@Test
	void testGetPlayerLoc() {
		String loc = "Player Location: R: 0 C: 0"  ;  
		assertTrue(maze.getPlayerLoc().equals(loc)) ; 
		maze.setPlayerLoc(3, 3);
		String loc2 = "Player Location: R: 3 C: 3"  ; 
		assertTrue(maze.getPlayerLoc().equals(loc2)) ; 


	}


	@Test
	void testGetEndReachable() {
		assertTrue(maze.getEndReachable()) ; 
		maze.setPlayerLoc(3, 3);
		assertTrue(maze.getEndReachable()) ;

	}

}
