package maze;

import mazeUtils.Question;

public class Door {
	
	private boolean locked;
	private Question question;
	private boolean cheatable;
	
	protected Door() {
		this.locked = false; // should be initialized as false.
		question = new Question(); //commented out for testing purposes (Question not working with database issue)
		cheatable = true;
	}
	
	protected boolean isCheatable() {
		return cheatable;
	}

	protected void setCheatable(boolean cheatable) {
		this.cheatable = cheatable;
	}

	protected boolean getLocked() {
		return this.locked;
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
