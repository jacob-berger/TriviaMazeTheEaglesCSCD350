package mazeUtils;

import maze.Door;
import maze.Room;

public class PrintMaze {
	

	public static String dungeonMasterDisplay() {
		String master = "";
		
		master += "           __   _ \n";
		master += "          | //// |       __________\n";
		master += "          |/    \\|      |          |\n";    
		master += "         '[0]--[0]'    <  Welcome! |\n";
		master += "         (  /..\\  )     |__________|\n";
		master += "          |(IIII)|\n";
		master += "           \\(__)/\n";		
		master += "      _____|>()<|_____\n";
		master += "     / |   \\    /   | \\\n";
		
		return master;
	}
	
	public static String dungeonMasterDisplay2() {
		String master = "";
		
		master += "           __   _ \n";
		master += "          | //// |  \n";
		master += "          |/    \\|  \n";    
		master += "         '[0]--[0]'   \n";
		master += "         (  /..\\  )  \n";
		master += "          |(IIII)|\n";
		master += "           \\(__)/\n";		
		master += "      _____|>()<|_____\n";
		master += "     / |   \\    /   | \\\n";
		
		return master;
	}
	
	public static String dungeonMasterDisplaySmile() {
		String master = "";
		master += "           ?     \n";
		master += "           __   _ \n";
		master += "   ?      | //// |  ?\n";
		master += "          |/    \\| \n";
		master += "         '[^]--[^]'  ?\n";
		master += "      ?  (  /..\\  )\n";
		master += "          |(IIII)|\n";
		master += "           \\(__)/\n";		
		master += "      _____|>()<|_____\n";
		master += "     / |   \\    /   | \\\n";
		
		return master;
	}
	
	public static String dungeonMasterDisplayName() {
		String master = "";
		master += "             ??   \n";
		master += "           __   _ \n";
		master += "          | //// |       ___________\n";
		master += "          |/    \\|      |           |\n";    
		master += "         '[^]--[^]'    <  What is   |\n";
		master += "         ( -/..\\- )     |Your name? |\n";
		master += "          |(IIII)|      |___________|\n";
		master += "           \\(__)/\n";		
		master += "      _____|>()<|_____\n";
		master += "     / |   \\    /   | \\\n";
		
		return master;
	}
	
	public static String dungeonMasterDisplayUnhappy() {
		String master = "";
		master += "             !!    \n";
		master += "           ___  _   *\n";
		master += "    *     | //// |       ___________\n";
		master += "          |/ )( \\|      |           |\n";    
		master += "         '[.]--[.]'    <  correct...|\n";
		master += "      *  ( -/..\\- )     | good job. |\n";
		master += "          |(-vv-)|      |___________|\n";
		master += "           \\(__)/\n";		
		master += "      _____|>()<|_____\n";
		master += "     / |   \\    /   | \\\n";
		
		return master;
	}
	
	public static String dungeonMasterDisplayWon() {
		String master = "";
		master += "            ...\n";
		master += "           ___  _   *\n";
		master += "    *     | //// |       _______________\n";
		master += "          |/ || \\|      |               |\n";    
		master += "         '[,]--[,]'    <   oh you won.  |\n";
		master += "      *  ( -/..\\- )     | good for you. |\n";
		master += "          |( -- )|      |_______________|\n";
		master += "           \\(__)/\n";		
		master += "      _____|>()<|_____\n";
		master += "     / |   \\    /   | \\\n";
		
		return master;
	}
	
	public static String dungeonMasterDisplayCheater() {
		String master = "";
		master += "             !!    \n";
		master += "           ___  _   *\n";
		master += "    *     | //// |       ___________________\n";
		master += "          |/ )( \\|      |                   |\n";    
		master += "         '[O]--[O]'    <       WHAT!?       |\n";
		master += "      *  ( -/..\\- )     | You're CHEATING?! |\n";
		master += "          |/vvvv\\|      |___________________| \n";
		master += "          ||^^^^||      \n";
		master += "           \\(__)/\n";		
		master += "      _____|>()<|_____\n";
		master += "     / |   \\    /   | \\\n";
		
		return master;
	}
	
	public static String dungeonMasterDisplayCheater2() {
		String master = "";
		master += "             ...    \n";
		master += "           ___  _   *\n";
		master += "    *     | //// |       _________________\n";
		master += "          |/ )( \\|      |                 |\n";    
		master += "         '[e]--[e]'    <  Still cheating? |\n";
		master += "      *  ( - .. - )     |It isn't fair... |\n";
		master += "          | /__\\ |      |_________________|\n";
		master += "           \\(__)/\n";		
		master += "      _____|>()<|_____\n";
		master += "     / |   \\    /   | \\\n";
		
		return master;
	}
	
	public static String dungeonMasterDisplayCheaterWon() {
		String master = "";
		master += "             !!    \n";
		master += "           ___  _   *\n";
		master += "    *     | //// |       ___________________\n";
		master += "          |/ )( \\|      |                   |\n";    
		master += "         '[0]--[0]'     |  YOU ONLY WON     |\n";
		master += "      *  ( -/..\\- )    <   BECAUSE YOU      |\n";
		master += "          |/vvvv\\|      |  CHEATED!         | \n";
		master += "          ||____||      |___________________|\n";
		master += "           \\(__)/\n";		
		master += "      _____|>()<|_____\n";
		master += "     / |   \\    /   | \\\n";
		
		return master;
	}
	
	public static String dungeonMasterDisplaySmug() {
		String master = "";

		master += "           __   _ \n";
		master += "          | //// |       ___________\n";
		master += "          |/    \\|      |           |\n";    
		master += "         '[v]--[v]'    <  Too Bad!  |\n";
		master += "         ( -/..\\- )     | Try Again.|\n";
		master += "          |(IIII)|      |___________|\n";
		master += "           \\(__)/\n";		
		master += "      _____|>()<|_____\n";
		master += "     / |   \\    /   | \\\n";
		
		return master;
	}
	
	public static String dungeonMasterDisplayBack() {
		String master = "";

		master += "        /|        |\\ \n";
		master += "        \\\\____ ___// \n";
		master += "         \\| //// |/      ___________\n";
		master += "    *     |/ \\/ \\|  *   |           |\n";    
		master += "         '[0]--[0]'    <  Come back |\n";		
		master += "         ( -/..\\- )     | soon...   |\n";
		master += "       *  |(----)|      |___________|\n";
		master += "           \\(__)/         *\n";		
		master += "   *  _____|>()<|_____\n";
		master += "     / |   \\    /   | \\\n";
		
		return master;
	}
	
	public static String dungeonMasterDisplayDeath() {
		String master = "";
		
		master += "        /|        |\\    *\n";
		master += "   *    \\\\___   __// *\n";
		master += "         \\| //// |/         ___________ \n";
		master += "      *   |/ )( \\|         |           |\n";
		master += "         '[,]--[,]'       <  Hehehe... |\n";
		master += "  *      ( -/..\\- )        |___________|\n";
		master += "          |(vvvv)|     *\n";
		master += "        *  \\(__)/\n";		
		master += "      _____|>()<|_____\n";
		master += "     / |   \\    /   | \\\n";
		
		return master;
	}
	
	public static String deathDisplay() {
		String skull = "";
		
		skull += "           ____    \n";
		skull += "         /\\    /\\ \n";
		skull += "         |/_||_\\|  \n";
		skull += "         \\{x}{x}/ \n";
		skull += "          <_**_> \n";
		skull += "          |HHHH| \n";
		skull += "           \\__/ \n";
		skull += "         __/||\\__ \n";
		skull += "      ()){--{}--}())\n";
		skull += "      // {--{}--} \\\\\n";
		skull += "     //  {__/\\__}  \\\\\n";
		skull += "            {}         \n";
		
		
		return skull;
	}
	
	/**
	 * The current state of the maze is printed to the console. This 
	 * includes the player location and the state of each door in 
	 * the maze. Each room is iterated through and printed line by line.
	 * @param rooms
	 * @param loc
	 * @param rLength
	 * @param cLength
	 * @return
	 */
	public static String displayRoom(Room[][] rooms, int[] loc, int rLength, int cLength) {
		System.out.println("\n		----------MAZE----------");
		String maze = "";
		String spaces = "";
		Room room;
		Door nD;
		Door eD;
		Door sD;
		Door wD;
		
		for(int row = 0; row < rLength; row ++ ) {
			for(int countN = 1; countN <= 2; countN ++) {
				spaces = "";
				for(int col = 0; col < cLength; col ++){
					room = rooms[row][col];
					nD = room.getDoor("n");
					maze += " " + northWall(countN, nD, spaces);
					//spaces += " ";
				}
				maze += "\n";
			}
			for(int countWE = 1; countWE <= 3; countWE ++) {
				for(int col2 = 0; col2 < cLength; col2 ++) {
					room = rooms[row][col2];
					wD = room.getDoor("w");
					eD = room.getDoor("e");
					maze +=  " " + westWall(countWE, loc, row, col2, wD, eD, spaces);		
				}
				maze += "\n";
			}
			spaces = "";
			for(int countS = 1; countS <= 2; countS ++) {
				for(int col3 = 0; col3 < cLength; col3 ++) {
					room = rooms[row][col3];
					sD = room.getDoor("s");
					maze +=  " " + southWall(countS, sD, spaces);
				}
				maze += "\n";
			}
		}
		return maze;
	}

	private static String northWall(int wallRowNum, Door nD, String spaces) {
		String room = "";
		
		if(nD.getWall()) {
			switch(wallRowNum) {
			case 1:
				room += spaces + "  __________  ";
				break;
			case 2:
				room += spaces + " |          | ";
				break;
			}
		}
		else if(nD.getLocked()) {
			switch(wallRowNum) {
			case 1:
				room += spaces + "  ___/__\\___  ";
				break;
			case 2:
				room += spaces + " |     X    | ";
				break;
			}
		}
		else if(nD.getQuestionAnswered()) {
			switch(wallRowNum) {
			case 1:
				room += spaces + "  ___\\  /___  ";
				break;
			case 2:
				room += spaces + " |          | ";
				break;
			}
		}
		else {
			switch(wallRowNum) {
			case 1:
				room += spaces + "  ___\\__/___  ";
				break;
			case 2:
				room += spaces + " |          | ";
				break;
			}
		}
		
		return room;
	}

	private static String westWall(int wallRowNum, int[] loc, int row, int col, Door wD, Door eD, String spaces) {
		String room = "";
		
		
		if(wD.getWall()) {
			switch(wallRowNum) {
			case 1:
				room += " |          ";
				room += eastWall(1, eD);
				break;
			case 2:
				if(row == loc[0] && col == loc[1]) {
					room += " |     P    ";
					room += eastWall(2, eD);
				}
				else {
					room += " |          ";
					room += eastWall(2, eD);
				}
				break;
			case 3:
				room += " |          ";
				room += eastWall(3, eD);
				break;
			}
		}	
			
		else if(wD.getLocked()) {
			switch(wallRowNum) {
			case 1:
				room += "/|          ";
				room += eastWall(1, eD);
				break;
			case 2:
				if(row == loc[0] && col == loc[1]) {
					room += " X     P    ";
					room += eastWall(2, eD);
				}
				else {
					room += " X          ";
					room += eastWall(2, eD);
				}
				break;
			case 3:
				room += "\\|          ";
				room += eastWall(3, eD);
				break;
			}
		}	
		
		else if(wD.getQuestionAnswered()) {
			switch(wallRowNum) {
			case 1:
				room += "\\|          ";
				room += eastWall(1, eD);
				break;
			case 2:
				if(row == loc[0] && col == loc[1]) {
					room += "       P    ";
					room += eastWall(2, eD);
				}
				else {
					room += "            ";
					room += eastWall(2, eD);
				}
				break;
			case 3:
				room += "/|          ";
				room += eastWall(3, eD);
				break;
			}
		}
		
		else {
			switch(wallRowNum) {
			case 1:
				room += "\\|          ";
				room += eastWall(1, eD);
				break;
			case 2:
				if(row == loc[0] && col == loc[1]) {
					room += " |     P    ";
					room += eastWall(2, eD);
				}
				else {
					room += " |          ";
					room += eastWall(2, eD);
				}
				break;
			case 3:
				room += "/|          ";
				room += eastWall(3, eD);
				break;
			}
		}
		
		return room;
	}
	
	
	private static String eastWall(int wallRowNum, Door eD) {
		String room = "";
		
		if(eD.getWall()) {
			room += "| ";
		}
		else if(eD.getLocked()) {
			switch(wallRowNum) {
			case 1:
				room += "|\\";
				break;
			case 2:
				room += "X ";
				break;
			case 3:
				room += "|/";
				break;
			}
		}
		else if(eD.getQuestionAnswered()) {
			switch(wallRowNum) {
			case 1:
				room += "|/";
				break;
			case 2:
				room += "  ";
				break;
			case 3:
				room += "|\\";
				break;
			}
		}
		else {
			switch(wallRowNum) {
			case 1:
				room += "|/";
				break;
			case 2:
				room += "| ";
				break;
			case 3:
				room += "|\\";
				break;
			}
		}

		return room;
	}
	
	private static String southWall(int wallRowNum, Door sD, String spaces) {
		
		String room = "";
		
		if(sD.getWall()) {
			switch(wallRowNum) {
			case 1:
				room += " |__________| ";
				break;
			case 2:
				room += "               ";
				break;
			}
		}
		else if(sD.getLocked()) {
			switch(wallRowNum) {
			case 1:
				room += " |____X_____| ";
				break;
			case 2:
				room += "     \\  /     ";
				break;
			}			
		}
		else if(sD.getQuestionAnswered()) {
			switch(wallRowNum) {
			case 1:
				room += " |____  ____| ";
				break;
			case 2:
				room += "     /  \\     ";
				break;
			}
		}
		else {
			switch(wallRowNum) {
			case 1:
				room += " |__________| ";
				break;
			case 2:
				room += "     /  \\     ";
				break;
			}
		}
		
		return room;
	}
}
