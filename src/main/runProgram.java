package main;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import maze.*;
import mazeUtils.*;

public class runProgram {

	/**
	 * 
	 */
	private Maze myMaze;
	private ScannerClass scan = new ScannerClass();
	private boolean load = false;
	private boolean loadFailed = false;
	
	public void setLoad(boolean condition) {
		this.load = condition;
	}
	
	public runProgram(boolean load) {
		this.setLoad(load);
		
		if (!load) {
			
			Player player = new Player(promptName()); // run against regex ************************************		
			
			if(player.getName().equals("Cheats")) {
				System.out.println("		---------CHEATS ENABLED---------\n");
				System.out.println(PrintMaze.dungeonMasterDisplayCheater());
				System.out.println("Press Enter:\n\n"); // run against regex ****************************
				this.scan.readNewLine();
			}
			
			myMaze = new Maze(4, 4, player);
			int[] loc = { 0, 0 };
			System.out.println("");
			System.out.println(player.getName() + " entered the maze...");
			System.out.println("");
			System.out.println(PrintMaze.displayRoom(myMaze.rooms, loc, myMaze.getRows(), myMaze.getColumns()));
		}
		run();
	}
	
	public void run() {
		int choice = 0;
		boolean quit = false;
		

		if (load) {
			
			//Loading
			try {
				FileInputStream file = new FileInputStream("savegame");
				ObjectInputStream in = new ObjectInputStream(file);
				
				//Method
				Maze loadedMaze = null;
				loadedMaze = (Maze)in.readObject();
				
				in.close();
				file.close();
				myMaze = loadedMaze;
				
				System.out.println("Your previous adventure has been loaded.");
				System.out.println("Good luck...");
			} catch (IOException e) {
				System.out.println("Could not find a saved game.");
				this.load = false;
				this.loadFailed = true;
			} catch (Exception e) {
				System.out.println(PrintMaze.dungeonMasterDisplayBack());
				System.out.println("Some other exception has occurred. Sorry =(");
			}
		}
		
		if (!loadFailed) {
			do {
				System.out.println("Press Enter:");
				this.scan.readNewLine();// run against regex **********************************
				menu();
				choice = this.scan.readInt(); // run against regex ********************************
				quit = menuSwitch(choice);

			} while (!quit && this.myMaze.getEndReachable() && !this.myMaze.didPlayerWin());
			if (this.myMaze.didPlayerWin()) {
				won();
			} else if (!this.myMaze.getEndReachable()) {
				System.out.println(PrintMaze.dungeonMasterDisplayDeath());
				System.out.println("Oh no! It appears you can no longer reach the end...\n");
				System.out.println("..." + myMaze.getPlayerName() + "'s fate...");
				System.out.println(PrintMaze.deathDisplay());
				System.out.println("\n-----------GAME OVER.-----------\n");
			} 
		}
	}

	private String promptName() {
		System.out.println(PrintMaze.dungeonMasterDisplayName());
		System.out.println("Name: ");
		return this.scan.readString();// run against regex ***************************
	}
	/**
	 * menu() displays initial player choices
	 */
	private void menu() { // add numbers associated with choices
		System.out.println("            ---------WHAT WOULD YOU LIKE TO DO?---------");
		System.out.println("1) Move");
		System.out.println("2) Save");
		System.out.println("3) Quit");
		
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
			save(myMaze);
			break;
		case 3:
			System.out.println("Quitting...");
			return true;
		}
		return false;
	}
	private void save(Maze myMaze2) {

		// Serialization  
        try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream("savegame"); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(myMaze2); 
              
            out.close(); 
            file.close(); 
              
            System.out.println("Object should have been serialized (fingers crossed)"); 
  
        } 
          
        catch(Exception e) 
        { 
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
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
		if(this.myMaze.getPlayerName().equals("Cheats")) {
			System.out.println(PrintMaze.dungeonMasterDisplayCheaterWon());
		}
		else {
			System.out.println(PrintMaze.dungeonMasterDisplayWon());
			System.out.println(PrintMaze.dungeonMasterDisplayBack());
		}

	}	
}
