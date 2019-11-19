package maze;

import mazeUtils.Question;

public class Door {
	
	private boolean wall;
	private boolean locked;
	private Question question;
	private boolean questionAnswered = false;
	
	public Door() {
		this.locked = false; 
		question = new Question();
	}
	
	public boolean getLocked() {
		return this.locked;
	}
	
	public boolean getWall() {
		return this.wall;
	}
	
	public boolean getQuestionAnswered() {
		return this.questionAnswered;
	}
	
	public void setQuestionAnswered(boolean state) {
		this.questionAnswered = state;
	}
	
	public void setWall(boolean state) {
		this.wall = state;
	}
	
	public void setLocked(boolean state) {
		this.locked = state;
	}
	
	public Question getQuestion() {
		return this.question;
	}
	@Override
	public String toString() {
		return "Question: " + this.getQuestion() + "\n" + "Answer: " + "\n" + "Locked?" + this.getLocked();
	}
	
	//Do we need a setter for the Question? Should really only need to be changed when Door is created.

	public static void main(String[] args) {
		Door door = new Door();
		System.out.println(door);
	}
} 
