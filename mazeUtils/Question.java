package mazeUtils;
import java.sql.*;
import java.util.ArrayList;

public class Question {

	private QuestionType type;
	private String question;
	private String answer;
	private String response1;
	private String response2;
	private String response3;
	private Connection database;

	protected Question() throws NullPointerException, IllegalArgumentException {
		double random = Math.random();
		random = random * 3 + 1;
		int choice = (int) random;
		switch (choice) {
		case 1:
			type = QuestionType.TRUE_FALSE;
			break;
		case 2:
			type = QuestionType.MULTIPLE_CHOICE;
			break;
		case 3:
			type = QuestionType.SHORT_ANSWER;
			break;
		}

		ArrayList<String> results = this.retrieveQuestion(type);
		this.question = results.get(0);
		this.answer = results.get(1);
		if (type == QuestionType.MULTIPLE_CHOICE) {
			this.response1 = results.get(2);
			this.response2 = results.get(3);
			this.response3 = results.get(4);
		}
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

	private ArrayList<String> retrieveQuestion(QuestionType type) {
		ArrayList<String> results = new ArrayList<String>();

		try {
			Class.forName("org.sqlite.JDBC");
			database = DriverManager.getConnection("jdbc:sqlite:database/trivia.db");
			Statement statement = database.createStatement();

			//Get total number of questions in table
			ResultSet resultSet = statement.executeQuery("select count(*) from " + type.toString());
			int totalQuestions = resultSet.getInt("count(*)");
			System.out.println("Total questions " + totalQuestions);

			//Get random question
			double randomDouble = Math.random();
			randomDouble = randomDouble * totalQuestions + 1;
			int question_number = (int) randomDouble;
			System.out.println("Question number " + question_number);
			System.out.println();
			resultSet = statement.executeQuery("select * from " + type.toString() + " where question_number = " + question_number);
			results.add(resultSet.getString("question"));
			results.add(resultSet.getString("answer"));

			if (this.type == QuestionType.MULTIPLE_CHOICE) {
				results.add(resultSet.getString("response1"));
				results.add(resultSet.getString("response2"));
				results.add(resultSet.getString("response3"));
			}

			statement.close();
			database.close();
		} catch (Exception e) {
			System.out.println("There was an error with the database connection");
		}

		return results;
	}

	public String toString() {
		String result = "";
		result += "Type: " + this.getType() + "\n";
		result += "Question: " + this.getQuestion() + "\n";

		switch (this.type.toString()) {
		case "TRUE_FALSE":
			result += "True or false?\n";
			break;

		case "MULTIPLE_CHOICE":
			//Prints in same order every run
			result += this.response1 + "\n";
			result += this.response2 + "\n";
			result += this.response3 + "\n";
			result += this.answer + "\n";
			result += "Type your response\n";
			break;

		case "SHORT_ANSWER":
			result += "Type your response\n";
		}

		return result;
	}

	public static void main(String[] args) {
		Question question = new Question();
		System.out.println(question.toString());
		System.out.println();
		question = new Question();
		System.out.println(question.toString());
		System.out.println();
//		question = new Question();
		System.out.println(question.toString());
		System.out.println();
		question = new Question();
		System.out.println(question.toString());
		System.out.println();
		question = new Question();
		System.out.println(question.toString());
		System.out.println();
		question = new Question();
		System.out.println(question.toString());
		System.out.println();
		question = new Question();
		System.out.println(question.toString());
		System.out.println();
	}

}
