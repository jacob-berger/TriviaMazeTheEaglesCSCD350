package mazeUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question {

	private QuestionType type;
	private String question;
	private String answer;
	private String response1;
	private String response2;
	private String response3;
	private String response4 = this.answer;// there needs to be another response
	private List<String> responseList;
	private Connection database;

	public Question() throws NullPointerException, IllegalArgumentException {
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

	public QuestionType getType() {
		return this.type;
	}
	
	public String getResponse1() {
		return this.response1;
	}
	
	public String getResponse2() {
		return this.response2;
	}
	
	public String getResponse3() {
		return this.response3;
	}

	private void setType(QuestionType type) {
		this.type = type;
	}

	public String getQuestion() {
		return this.question;
	}

	private void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return this.answer;
	}

	private void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public List<String> getResponseList() {
		return this.responseList;
	}

	private ArrayList<String> retrieveQuestion(QuestionType type) {
		ArrayList<String> results = new ArrayList<String>();

		try {
			Class.forName("org.sqlite.JDBC");
			database = DriverManager.getConnection("jdbc:sqlite:src/database/trivia.db");
			Statement statement = database.createStatement();

			//Get total number of questions in table
			ResultSet resultSet = statement.executeQuery("select count(*) from " + type.toString());
			int totalQuestions = resultSet.getInt("count(*)");

			//Get random question
			double randomDouble = Math.random();
			randomDouble = randomDouble * totalQuestions + 1;
			int question_number = (int) randomDouble;
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
		String result = "\n";
		//result += "Type: " + this.getType() + "\n";
		result += "QUESTION: " + this.getQuestion() + "\n";

		switch (this.type.toString()) {
		case "TRUE_FALSE":
			result += "\nTrue or False?\n";
			break;

		case "MULTIPLE_CHOICE":
			
			String[] responses = {response1, response2, response3, answer};
			this.responseList = Arrays.asList(responses);
			Collections.shuffle(responseList);
			
			result += "\n";
			result += "a) " + responseList.get(0) + "\n";
			result += "b) " + responseList.get(1) + "\n";
			result += "c) " + responseList.get(2) + "\n";
			result += "d) " + responseList.get(3) + "\n";
			break;
		
		case "SHORT_ANSWER":
			
			break;
		}

		result += "\nType your response: \n";
		return result;
	}

//	public static void main(String[] args) {
//		Question question = new Question();
//		System.out.println(question.toString());
//		System.out.println();
//		question = new Question();
//		System.out.println(question.toString());
//		System.out.println();
//		question = new Question();
//		System.out.println(question.toString());
//		System.out.println();
//		question = new Question();
//		System.out.println(question.toString());
//		System.out.println();
//		question = new Question();
//		System.out.println(question.toString());
//		System.out.println();
//		question = new Question();
//		System.out.println(question.toString());
//		System.out.println();
//		question = new Question();
//		System.out.println(question.toString());
//		System.out.println();
//	}

}
