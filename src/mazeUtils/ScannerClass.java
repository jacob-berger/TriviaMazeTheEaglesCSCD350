package mazeUtils;

import java.io.Serializable;
import java.util.Scanner;

public class ScannerClass implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 647266378663692657L;
	private transient Scanner fin = null;
	
	private void initScanner() {
		if(this.fin == null) {
			this.fin = new Scanner(System.in);
		}
	}
	
	/**
	 * readString() ensures fin isn't null.
	 * if condition ensures input ins't empty.
	 * @return
	 */
	public String readString() {
		initScanner();
		
		String tempString = this.fin.nextLine();
		
		if(tempString.isEmpty()) {
			System.out.println("Empty value");
			readString();
		}
		
		return tempString;
	}
	
	/**
	 * readNewLine() is intended to allow 'enter' as input
	 * all other values will be grabbed and remain unused.
	 */
	public void readNewLine() {
		initScanner();
	
		this.fin.nextLine();
	}
	
	/**
	 * readChar() reads in value as string first, iterates
	 * past any white space then returns the char at the 
	 * beginning of the String.
	 * @return
	 */
	public char readChar() {
		String tempString = readString();
		char tempChar = '\0';
		for(int search = 0; search < tempString.length(); search ++) {
			if(!(tempString.charAt(search) == ' ')) {
				tempChar = tempString.charAt(0);
			}
		}
		return tempChar;
	}
	
	/**
	 * readInt() reads in value as a String first, then
	 * verifies value can be parsed into an int. If not
	 * prints error message and calls class again.
	 * @return
	 */
	public int readInt() {
		String tempString = readString();
		int tempInt = 0;
		
		try {
			tempInt = Integer.parseInt(tempString);
			return tempInt;
		}
		catch(NumberFormatException e) {
			System.out.println("Please enter an integer:");
			tempInt = readInt();
		}
		catch(Exception e) {
			System.out.println("Please enter an integer:");
			tempInt = readInt();
		}
		return tempInt;
	}
}
