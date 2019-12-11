package mazeUtils;

import java.util.regex.Pattern;

public class Regex{
	
	/* 
	 * Class for scrubbing data
	 * These private variables hold the regex specifications
	 */
	private String limitLen15 = "^.{1,15}$";
	private String multChoice = "[abcd]{1}"; // a - d


	private String direction = "[nsewNSEW]{1}"; // n,s,e,w
	private String menuChoice = "[1-9]"; // 1-9
	private String trueFalse = "True|False"; // t / f
	private String shortAnswer = "[a-zA-Z1-9\\s]{1,20}"; // no more than 20 (chars &| spaces)
	private String yesNo = "\\b(yes|no|y|n)\\b"; // yes, no, y, n
	private String menuChoice5 = "[1-5]"; // 1-5
	private String menuChoice4 = "[1-4]"; // 1-4
	private String menuChoice3 = "[1-3]"; // 1-3
	
	/*
	 * Each proceeding method takes a String that holds the 
	 * user input and compares it against the appropriate regex
	 * to verify proper input.
	 */
	
	public boolean limitLength15(String answer) {
		return Pattern.matches(this.limitLen15,  answer);
	}
	
	public boolean multChoice(String choice) {
		return Pattern.matches(this.multChoice, choice);
	}
	
	public boolean trueFalse(String choice) {
		return Pattern.matches(this.trueFalse, choice);
	}
	
	public boolean shortAnswer(String answer) {
		return Pattern.matches(this.shortAnswer, answer);
	}
	
	public boolean direction(String dirChoice) {
		return Pattern.matches(this.direction, dirChoice);
	}
	
	public boolean yesNo(String choice) {
		return Pattern.matches(this.yesNo, choice);
	}
	
	public boolean menuChoice5(String choice) {
		return Pattern.matches(this.menuChoice5, choice);
	}
	
	public boolean menuChoice4(String choice) {
		return Pattern.matches(this.menuChoice4, choice);
	}
	
	public boolean menuChoice3(String choice) {
		return Pattern.matches(this.menuChoice3, choice);
	}
	
	
			
	
}
