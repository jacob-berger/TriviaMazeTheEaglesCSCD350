package main;
import mazeUtils.*;

public class GameManager {
	
	public static void main(String[] args) {
		ScannerClass fin = new ScannerClass();
		int choice;
		
		System.out.println("		------------------MOVIE TRIVIA MAZE--------------------\n");
		
		do {

			gameStartMenu();
			choice = fin.readInt();
			
			startSwitch(choice, fin);
		}while(choice <= 3);

	}
	
	public static void gameStartMenu() {
		System.out.println("1) Play Game");
		System.out.println("2) Load Game");
		System.out.println("3) Instructions");
		System.out.println("4) Add a question to the database");
		System.out.println("5) Quit");
	}
	
	public static void startSwitch(int choice, ScannerClass fin) {
		switch(choice) {
		case 1:
			System.out.println(PrintMaze.dungeonMasterDisplay());
			System.out.println("I am the Movie Master, and this is...");
			System.out.println("	...Movie Trivia Maze!");
			System.out.println("The game where you walk through a maze answering movie questions...");
			System.out.println("...with almost no consequences!\n\n");
			
			System.out.println("Press Enter:\n\n"); // run against regex ****************************
			fin.readNewLine();
			
			new runProgram(false);
			
			break;
		case 2:
			System.out.println("Loading game...");
			new runProgram(true);
			break;
		case 3:
			System.out.println("\n		------------------INSTRUCTIONS--------------------\n");
			System.out.println("* Make your way through the maze one room at a time until you reach the exit.");
			System.out.println("* You will be faced with a movie question for each door you attempt to open.\n");
			System.out.println("		Questions come in the forms:");
			System.out.println("	True \\ False || Short Answer || Multiple Choice\n");		
			System.out.println("* If you answer correctly the door will open.");
			System.out.println("* IF you answer incorrectly the door will be locked.");
			System.out.println("* Locking enough doors to block your access to the exit will result in a GAME OVER.");
			System.out.println("\n		------------------CHEATING--------------------\n");
			System.out.println("* If you're really bad at trivia try using the name: 'Cheats' to always win.\n\n");
			break;
		case 4:
			Question.createQuestion();
			break;
		default:
			
			System.out.println("		---------QUITTING--------\n");
			System.out.println(PrintMaze.dungeonMasterDisplayBack());
			break;
		}
	}
}
