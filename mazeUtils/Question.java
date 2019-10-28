package mazeUtils;

	public class Question {
	
	private String type;
	private String question;
	private String answer;

	protected Question(String type, String question, String answer) {
		this.type = type;
		this.question = question;
		this.answer = answer;
	}
	
	protected Question(String type) {
		this.type = type;
		this.question = "DEFAULT QUESTION";
		this.answer = "DEFAULT ANSWER";
	}
	
	protected String getType() {
		return this.type;
	}
	
	private void setType(String type) {
		this.type = type;
	}
	
	protected String getQuestion() {
		return this.question;
	}
	
	private void setQuestion(String question) {
		this.question = question;
	}
	
	protected String getAnswer() {
		return this.answer;
	}
	
	private void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
