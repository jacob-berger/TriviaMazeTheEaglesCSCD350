package maze;

import mazeUtils.Question;

public class Door {
	
	private boolean locked;
	private Question question;
	
	protected Door() {
		locked = true;
		question = new Question();
	}
	
	protected boolean getLocked() {
		return locked;
	}
	
	protected void setLocked(boolean state) {
		this.locked = state;
	}
	
	protected Question getQuestion() {
		return this.question;
	}
	@Override
	public String toString() {
		return "Question: " + this.getQuestion() + "\n" + "Answer: " + "\n" + "Locked?" + this.getLocked();
	}
	
	//Do we need a setter for the Question? Should really only need to be changed when Door is created.

}
