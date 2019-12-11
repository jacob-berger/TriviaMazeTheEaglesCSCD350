package mazeUtils;

import java.io.Serializable;

import maze.Door;

public class QuestionHandler implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7472735019465552886L;

	private ScannerClass scan = new ScannerClass();
	private Regex regex = new Regex();
	
	private Question question;
	private QuestionType questionType;
	
	private String questionString = "";
	private String questionAnswer = "";
	
	public boolean handleQuestion(Door door) {
		
		this.question = door.getQuestion();
		
		this.questionString = this.question.getQuestion();
		this.questionAnswer = this.question.getAnswer();
		this.questionType = this.question.getType();
		
		
		return askQuestionVarify();
	}
	
	private boolean askQuestionVarify() {
		String answer = "";
		boolean varified = false;
		
		System.out.println("\n\n" + PrintMaze.dungeonMasterDisplaySmile());
		System.out.println("------MOVIE MASTER:------\n");
		System.out.println(this.question.toString());

		switch(this.questionType) {
		case MULTIPLE_CHOICE:
			System.out.println("Enter 'a','b','c', or 'd':");
			String tempAnswer = "";
			
			char correctChoice;
			char charAnswer = 'e';
			
			while(!varified) {
				
				charAnswer = this.scan.readChar(); 
				tempAnswer = charAnswer + "";
				
				varified = regex.multChoice(tempAnswer);
				
				if(!varified) {
					System.out.println("Enter 'a','b','c', or 'd':");
				}
			}

			varified = false;
			
			
			if(questionAnswer.equals(question.getResponseList().get(0))){
				correctChoice = 'a';
			}
			else if(questionAnswer.equals(question.getResponseList().get(1))){
				correctChoice = 'b';
			}
			else if(questionAnswer.equals(question.getResponseList().get(2))){
				correctChoice = 'c';
			}
			else{
				correctChoice = 'd';
			}
		
		
			if(charAnswer == correctChoice) {
				return true;
			}
			break;
		case TRUE_FALSE:
			System.out.println("Enter 'True' or 'False':");
			while(!varified) {
				answer = this.scan.readString() + "";
				
				varified = regex.trueFalse(answer);
				
				if(!varified) {
					System.out.println("Enter'True' or 'False':");
				}
			}
				
			varified = false;
			
			if(answer.equals(this.questionAnswer)) {
				return true;
			}
			break;
		case SHORT_ANSWER:
			System.out.println("Enter a short answer:");
			System.out.println("	-It may be a number, word, or series of words.");
			System.out.println("	-First word must be capitalized.");
			System.out.println("	-Names follow expected convention. (ie. Tim Smith)");
			
			while(!varified) {
				answer = this.scan.readString(); // check against regex **************************************$$$$$$$$$$$$$
				
				varified = regex.shortAnswer(answer);
				
				if(!varified) {
					System.out.println("Enter a short answer. It may be a number, word, or series of words.");
					System.out.println("The first word in your answer must be capitalized.");
				}
			}
			
			varified = false;
			
			if(answer.equals(this.questionAnswer)) {
				return true;
			}
			
			break;
		}
		
		return false;
	}
	
	
}
