package mazeUtils;

import java.util.regex.Pattern;

public class Regex {
	
	/* 
	 * Class for scrubbing data
	 * These private variables hold the regex specifications
	 */
	private String multChoice = "[abcd]{1}"; // a - d
	private String trueFalse = "[t|f|T|F]{1}"; // t / f
	private String shortAnswer = "[a-zA-Z ]{3,15}"; // no more than 15 (chars &| spaces)
	private String direction = "[nsew]{1}"; // n,s,e,w
	private String yesNo = "\\b(yes|no|y|n)\\b"; // yes, no, y, n
	private String menuChoice = "[1-9]"; // 1-9
	
	/*
	 * Each proceeding method takes a String that holds the 
	 * user input and compares it against the appropriate regex
	 * to verify proper input.
	 */
	
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
	
	public boolean menuChoice(String choice) {
		return Pattern.matches(this.menuChoice, choice);
	}
	
	
			
	
}
