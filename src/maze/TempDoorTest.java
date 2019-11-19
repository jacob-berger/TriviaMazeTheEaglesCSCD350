package maze;

import mazeUtils.Question;

public class TempDoorTest {
	public static void main(String[] args) {
		Door myDoor = new Door();
		
		
		Question myQuestion;
		
		myQuestion = myDoor.getQuestion();
		System.out.println(myDoor.getQuestion().getType());
		System.out.println(myDoor.getQuestion().getQuestion());
		System.out.println(myDoor.getQuestion().getAnswer());
		
		System.out.println("Test is working");
	}
}
