package testClasses;

import mazeUtils.Regex;
import mazeUtils.ScannerClass;

public class RegexScannerTester {
	/**REGEX AND SCANNERCLASS TESTER
	 * Run from this class to put all the regex to the test
	 * dynamically with your input. 
	 */
	public static Regex regex = new Regex();
	public static ScannerClass scan = new ScannerClass();
	
	public static void main(String[] args) {
		boolean done = false;

		int choice = 0;
		

		
		while(!done) {
			System.out.println("Which type are you going to test?");
			menu();
			choice = scan.readInt();
			
			switchMethod(choice);
			System.out.println();
		}
	}
	
	public static void menu() {
		System.out.println("1) Multiple choice (a, b, c, d,)");
		System.out.println("2) Short answer (3-15 characters and spaces)");
		System.out.println("3) True or False (T, F, t, f)");
		System.out.println("4) Direction (n, s, e, w)");
		System.out.println("5) Yes or No (yes, no, n, y)");
		System.out.println("6) Menu Choice (int 1-9)");
	}
	
	public static void switchMethod(int choice) {
		int numberValue = 0;
		String stringValue = "";
		char charValue = '\0';
		boolean passed = false;
		
		String tempString = "";
		
		switch(choice) {
		case 1:
			System.out.println("Enter a character from a-d:");
			charValue = scan.readChar();
			
			tempString = charValue + "";
			passed = regex.multChoice(tempString);
			
			System.out.println("Your entry PASSED: " + passed);
			
			break;
		case 2:
			System.out.println("Enter a short answer:");
			stringValue = scan.readString();
			
			passed = regex.shortAnswer(stringValue);
			
			System.out.println("Your entry PASSED: " + passed);
			break;
		case 3:
			System.out.println("Enter T, F, t, or f: ");
			charValue = scan.readChar();
			
			tempString = charValue + "";
			passed = regex.trueFalse(tempString);
			
			System.out.println("Your entry PASSED: " + passed);
			break;
		case 4:
			System.out.println("Enter n, s, e, w:");
			charValue = scan.readChar();
			
			tempString = charValue + "";
			passed = regex.direction(tempString);
			
			System.out.println("Your entry PASSED: " + passed);
			break;
		case 5:
			System.out.println("Enter yes, no, y, n:");
			stringValue = scan.readString();
			
			passed = regex.yesNo(stringValue);
			
			System.out.println("Your entry PASSED: " + passed);
			break;
		case 6:
			System.out.println("Enter 1-9:");
			numberValue = scan.readInt();
			tempString = Integer.toString(numberValue);
			
			passed = regex.menuChoice(tempString);
			
			System.out.println("Your entry PASSED: " + passed);
			break;
		default:
			System.out.println("If you seeing this you've entered a number greater than 6.");
			System.out.println("This tests regex for menu options 1-9");
			System.out.println("These numbers can be altered easily as our menu options change.");
			break;
		}
	}
}
