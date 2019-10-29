package mazeUtils;
import java.sql.*;

public class DatabaseTest {
  public static void main( String args[] ) {
      Connection c = null;
      Statement statement = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:database/trivia.db");
         System.out.println("Opened database successfully");
         statement = c.createStatement();
         ResultSet rs = statement.executeQuery("select * from TRUE_FALSE");
         
         while (rs.next()) {
        	 int question_number = rs.getInt("question_number");
        	 String question = rs.getString("question");
        	 String answer = rs.getString("answer");
        	 
        	 System.out.println("question_number = " + question_number);
        	 System.out.println("question = " + question);
        	 System.out.println("answer = " + answer);
         }
         
         rs.close();
         statement.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
   }
}