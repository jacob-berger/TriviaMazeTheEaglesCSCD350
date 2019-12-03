package mazeUtils;

import maze.Door;

public class QuestionHandler {
	private ScannerClass scan = new ScannerClass();
	
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
		
		System.out.println("\n\n" + PrintMaze.dungeonMasterDisplaySmile());
		System.out.println("------MOVIE MASTER:------\n");
		System.out.println(this.question.toString());
		//String answer = "**********************This is for testing purposes: ANSWER: " + this.questionAnswer;****************
		//System.out.println(answer);
		switch(this.questionType) {
		case MULTIPLE_CHOICE:
			char correctChoice;
			char charAnswer = this.scan.readChar();  // check against regex ***********************
			
			if(questionAnswer.equals(question.getResponse1())){
				correctChoice = 'a';
			}
			else if(questionAnswer.equals(question.getResponse2())){
				correctChoice = 'b';
			}
			else if(questionAnswer.equals(question.getResponse3())){
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
			answer = this.scan.readString() + ""; // check against regex ************************
			if(answer.equals(this.questionAnswer)) {
				return true;
			}
			break;
		case SHORT_ANSWER:
			answer = this.scan.readString(); // check against regex ************************
			if(answer.equals(this.questionAnswer)) {
				return true;
			}
			break;
		}
		
		return false;
	}
	
	
}
