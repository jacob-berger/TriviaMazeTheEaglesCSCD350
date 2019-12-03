package main;
import maze.*;
import mazeUtils.*;

public class runProgram {

	private Maze myMaze;
	private ScannerClass scan = new ScannerClass();
	
	public runProgram() {
		/*
		System.out.println(PrintMaze.dungeonMasterDisplay());
		System.out.println(PrintMaze.dungeonMasterDisplaySmile());
		System.out.println(PrintMaze.dungeonMasterDisplaySmug());
		System.out.println(PrintMaze.dungeonMasterDisplayUnhappy());
		System.out.println(PrintMaze.dungeonMasterDisplayWon());
		System.out.println(PrintMaze.dungeonMasterDisplayDeath());
		System.out.println(PrintMaze.deathDisplay());
		System.out.println(PrintMaze.dungeonMasterDisplayBack());*/
		
		Player player = new Player(promptName()); // run against regex ************************************
		myMaze = new Maze(4,4, player);
		int[] loc = {0,0};
		
		System.out.println("");
		System.out.println(player.getName() + " entered the maze...");
		System.out.println("");
		
		System.out.println(PrintMaze.displayRoom(myMaze.rooms, loc, myMaze.getRows(), myMaze.getColumns()));
		
		run();
	}
	
	public void run() {
		int choice = 0;
		boolean quit = false;
		
		do {
				System.out.println("Press Enter:");
				this.scan.readNewLine();// run against regex **********************************
				menu();
				choice = this.scan.readInt(); // run against regex ********************************
				quit = menuSwitch(choice);
			
		}while(!quit && this.myMaze.getEndReachable() && !this.myMaze.didPlayerWin());
		
		if(this.myMaze.didPlayerWin()) {
			won();
		}
		else if(!this.myMaze.getEndReachable()) {
			System.out.println(PrintMaze.dungeonMasterDisplayDeath());
			System.out.println("Oh no! It appears you can no longer reach the end...");
			System.out.println(myMaze.getPlayerName() + "'s fate...");
			System.out.println(PrintMaze.deathDisplay());
			System.out.println("\n-----------GAME OVER.-----------\n");
		}
	}
	
	private String promptName() {
		System.out.println("What is your name?: ");
		return this.scan.readString();
	}
	/**
	 * menu() displays initial player choices
	 */
	private void menu() { // add numbers associated with choices
		System.out.println("            ---------WHAT WOULD YOU LIKE TO DO?---------");
		System.out.println("1) Move");
		System.out.println("2) Use Item");
		System.out.println("3) Quit");
		System.out.println("9) Cheat");
		
	}
	/**
	 * menu2() displays player choices after deciding to move to
	 * another room (choice 1 from menu())
	 */
	private void menu2() { // add numbers associated with choices
		System.out.println("            ---------WHICH ROOM?---------");
		System.out.println("1) Move to North room.");
		System.out.println("2) Move to East room.");
		System.out.println("3) Move to South room.");
		System.out.println("4) Move to West room.");
	}

	/**
	 * menuSwitch() is switch statements associated with players
	 * initial choices. It is called after menu() is called and 
	 * the player enters a choice. 
	 * @param choice
	 * @return
	 */
	private boolean menuSwitch(int choice) {
				
		switch(choice) {
		case 1:
			menu2();
			choice = this.scan.readInt(); // run against regex **********************************
			menu2Switch(choice);
			
			break;
		case 2:
			break;
		case 3:
			System.out.println("Quitting...");
			return true;
		case 4:
			break;
		case 5:
			break;
		}
		return false;
	}
	/**
	 * menu2Switch() is the switch associated with menu2(), meaning it is called
	 * after menu2() is displayed and the player enters a choice.
	 * @param choice is the direction player wishes to travel in
	 */
	private void menu2Switch(int choice) {
		switch(choice) {
		case 1:
			this.myMaze.movePlayer('n');
			break;
		case 2:
			this.myMaze.movePlayer('e');
			break;
		case 3:
			this.myMaze.movePlayer('s');
			break;
		case 4:
			this.myMaze.movePlayer('w');
			break;
		}
	}
	
	private void won() {
		System.out.println(PrintMaze.dungeonMasterDisplayWon());
		System.out.println(PrintMaze.dungeonMasterDisplayBack());
	}	
}
