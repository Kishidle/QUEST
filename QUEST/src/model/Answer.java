package model;

import java.io.IOException;



/**
 * Handles the encapsulation and representation of <code>Answer</code> model.
 * 
 * @author Darren Garcia
 */

public class Answer {

	private String answer;
	
	/**
	 * Creates a blank representation for <code>Answer</code> model.
	 */
	public Answer() {
		
	}
	
	public Answer(String answer) {
		this.answer = answer;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
