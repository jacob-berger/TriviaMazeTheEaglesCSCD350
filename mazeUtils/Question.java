package mazeUtils;

	public class Question {
	
	private QuestionType type;
	private String question;
	private String answer;
	private String database;

	protected Question(QuestionType type, String question, String answer) throws NullPointerException, IllegalArgumentException {
		if (type == null) {
			throw new NullPointerException("The type is null");
		} else if (question == null) {
			throw new NullPointerException("The question is null");
		} else if (question.length() == 0) {
			throw new IllegalArgumentException("The question is empty");
		} else if (answer == null) {
			throw new NullPointerException("The answer is null");
		} else if (answer.length() == 0) {
			throw new IllegalArgumentException("The answer is empty");
		}
		this.type = type;
		this.question = question;
		this.answer = answer;
	}
	
	protected Question(QuestionType type) {
		new Question(type, "DEFAULT QUESTION", "DEFAULT ANSWER");
	}
	
	protected QuestionType getType() {
		return this.type;
	}
	
	private void setType(QuestionType type) {
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
