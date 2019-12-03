package main;
import mazeUtils.*;

public class GameManager {
	
	public static void main(String[] args) {
		ScannerClass fin = new ScannerClass();
		int choice;
		
		System.out.println("------------------MOVIE TRIVIA MAZE--------------------\n");
		
		do {

			gameStartMenu();
			choice = fin.readInt();
			
			startSwitch(choice);
		}while(choice <= 3);

	}
	
	public static void gameStartMenu() {
		System.out.println("1) Play Game");
		System.out.println("2) Load Game");
		System.out.println("3) Game Instructions");
		System.out.println("4) Quit");
	}
	
	public static void startSwitch(int choice) {
		switch(choice) {
		case 1:
			System.out.println(PrintMaze.dungeonMasterDisplay());
			System.out.println("I am the Movie Master, and this is..");
			System.out.println("Movie Trivia Maze!");
			System.out.println("The game where you walk through a maze answering movie questions...");
			System.out.println("...with almost no consequences!");
			System.out.println("GOOOOD LUCK!!");
			System.out.println("");
			
			runProgram game = new runProgram();
			
			break;
		case 2:
			System.out.println("Insert functionality to load game here:");
			break;
		case 3:
			System.out.println("\n------------------INSTRUCTIONS--------------------");
			System.out.println("Insert game directions here:");
			System.out.println("");
			break;
		default:
			
			System.out.println("---------QUITTING--------\n");
			System.out.println(PrintMaze.dungeonMasterDisplayBack());
			break;
		}
	}
}
