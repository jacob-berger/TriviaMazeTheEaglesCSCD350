package maze;

public class MazeTester {
	
	public static void main(String[] args) {
		System.out.println("This is a test of the Maze class.");
		
		Maze myMaze = new Maze(4,4);
		
		System.out.println("Maze Generated.");
		System.out.println("----------------------------------------");
		
		String printDoor = "";
		
		for(int searchR = 0; searchR < myMaze.getRows(); searchR ++) {
			for(int searchC = 0; searchC < myMaze.getColumns(); searchC ++) {
				if(searchR == 0 && searchC == 0) {
					System.out.println("ENTRANCE");
					printDoor = myMaze.rooms[searchR][searchC].toString();
					System.out.println(printDoor);
					System.out.println();
				}
				else if(searchR == myMaze.getRows() -1 && searchC == myMaze.getColumns() -1) {
					System.out.println("EXIT");
					printDoor = myMaze.rooms[searchR][searchC].toString();
					System.out.println(printDoor);
					System.out.println();
				}
				else {
					System.out.println("Row: " + searchR + " " + "Column: " + searchC);
					printDoor = myMaze.rooms[searchR][searchC].toString();
					System.out.println(printDoor);
					System.out.println();
				}				
			}
		}
		
		Player myPlayer = new Player("Mr. Tester");
		
		myMaze.setPlayer(myPlayer);
		
		System.out.println("A new player has been created: " + myPlayer.getName());
		System.out.println("Player location: location: " + "R: " + myPlayer.getR() + " C: " + myPlayer.getC());
		System.out.println("Moving east: ");
		myMaze.movePlayer('e');
		System.out.println("Player location: " + "R: " + myPlayer.getR() + " C: " + myPlayer.getC());
		System.out.println("Is end reachable?" + myMaze.getEndReachable());
		
		System.out.println("Player location: " + "R: " + myPlayer.getR() + " C: " + myPlayer.getC());
		System.out.println("locking current path of doors from both sides:");
		myMaze.rooms[0][1].setDoor("s", true);
		myMaze.rooms[0][2].setDoor("s", true);
		myMaze.rooms[1][3].setDoor("w", true);
		myMaze.rooms[2][3].setDoor("w", true);
		myMaze.rooms[2][3].setDoor("s", true);
		myMaze.rooms[1][1].setDoor("n", true);
		myMaze.rooms[1][2].setDoor("n", true);
		myMaze.rooms[1][2].setDoor("e", true);
		myMaze.rooms[2][2].setDoor("e", true);
		System.out.println("Is end reachable?" + myMaze.getEndReachable());
		
	}
}
