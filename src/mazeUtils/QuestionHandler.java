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
		
		System.out.println(this.questionString);
		String answer = "";
		
		switch(this.questionType) {
		case MULTIPLE_CHOICE:
			answer = this.scan.readChar() + "";  // check against regex ***********************
			if(answer.equals(this.questionAnswer)) {
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
