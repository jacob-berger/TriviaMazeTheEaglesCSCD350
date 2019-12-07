package mazeUtils;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8918590939245895065L;
	private QuestionType type;
	private String question;
	private String answer;
	private String response1;
	private String response2;
	private String response3;
	private String response4 = this.answer;// there needs to be another response
	private List<String> responseList;
	private static Connection database;

	public Question() {
		double random = Math.random();
		random = random * 4;
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
	
	public Question(QuestionType type, String question, String answer) {
		this.setType(type);
		this.setQuestion(question);
		this.setAnswer(answer);
	}
	
	public Question(QuestionType type, String question, String answer, String response1, String response2, String response3) {
		this.setType(type);
		this.setQuestion(question);
		this.setAnswer(answer);
		this.setResponse1(response1);
		this.setResponse2(response2);
		this.setResponse3(response3);
	}

	public QuestionType getType() {
		return this.type;
	}
	
	private void setResponse1(String response) {
		this.response1 = response;
	}
	
	public String getResponse1() {
		return this.response1;
	}
	
	private void setResponse2(String response) {
		this.response2 = response;
	}
	
	public String getResponse2() {
		return this.response2;
	}
	
	private void setResponse3(String response) {
		this.response3 = response;
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
	
	public static void createQuestion() {
		QuestionType type = QuestionType.TRUE_FALSE;
		String question = "";
		String answer = "";
		String response1 = "";
		String response2 = "";
		String response3 = "";
		int success = -1;
		ScannerClass in = new ScannerClass();
		
		System.out.println("Select a type of question:");
		System.out.println("1) True/False\n2) Multiple Choice\n3) Short Answer\n");
		
		try {
			int choice = in.readInt();
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

			System.out.println("Please enter the question: ");
			question = in.readString();
			System.out.println("Please enter the answer: ");
			answer = in.readString();
			if (type == QuestionType.MULTIPLE_CHOICE) {
				System.out.println("Please enter three incorrect responses (one per line): ");
				response1 = in.readString();
				response2 = in.readString();
				response3 = in.readString();
			}
			
			try {
				Class.forName("org.sqlite.JDBC");
				database = DriverManager.getConnection("jdbc:sqlite:src/database/trivia.db");
				PreparedStatement statement;
				if (type == QuestionType.MULTIPLE_CHOICE) {
					String query = "insert into MULTIPLE_CHOICE(question, answer, response1, response2, response3) values(?,?,?,?,?);";
					statement = database.prepareStatement(query);
					statement.setString(1, question);
					statement.setString(2, answer);
					statement.setString(3, response1);
					statement.setString(4, response2);
					statement.setString(5, response3);
				} else {
					String query = "insert into " + type.toString() + "(question, answer) values(?,?);";
					statement = database.prepareStatement(query);
					statement.setString(1, question);
					statement.setString(2, answer);
				}
				
				success = statement.executeUpdate();
				
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		} catch (Exception e) {
			System.out.println("Invalid format. Question was not added.");
		}
		
		if (success == -1) {
			System.out.println("Question was not added.");
		} else {
			System.out.println("Your question was successfully added to the database!");
		}
	}

}
