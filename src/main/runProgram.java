package main;
import maze.*;
import mazeUtils.*;

public class runProgram {

	private Maze myMaze;
	private ScannerClass scan = new ScannerClass();
	
	public runProgram() {

		Player player = new Player(promptName()); // run against regex ************************************
		myMaze = new Maze(4,4, player);
		run();
	}
	
	public void run() {
		int choice = 0;
		boolean quit = false;
		
		do {
				menu();
				choice = this.scan.readInt(); // run against regex ********************************
				quit = menuSwitch(choice);
			
		}while(!quit && this.myMaze.getEndReachable() && !this.myMaze.didPlayerWin());
		
		if(this.myMaze.didPlayerWin()) {
			won();
		}
		else if(!this.myMaze.getEndReachable()) {
			System.out.println("YOU CAN NO LONGER REACH THE END.");
			System.out.println("GAME OVER.");
		}
	}
	
	private String promptName() {
		System.out.println("NAME: ");
		return this.scan.readString();
	}
	
	private void menu() { // add numbers associated with choices
		System.out.println("            ---------WHAT WOULD YOU LIKE TO DO?---------");
		System.out.println("1) Move to another room.");
		System.out.println("2) Use Item.");
		System.out.println("3) Quit.");
		System.out.println("9) CHEAT");
		
	}
	
	private void menu2() { // add numbers associated with choices
		System.out.println("            ---------WHICH ROOM?---------");
		System.out.println("1) Move to North room.");
		System.out.println("2) Move to East room.");
		System.out.println("3) Move to South room.");
		System.out.println("4) Move to West room.");
	}
	
	private void won() {
		System.out.println("YOU'VE WON THE GAME.");
	}
	
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
	
}
