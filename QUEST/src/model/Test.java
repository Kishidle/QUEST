package  model;

import java.io.IOException;



/**
 * Handles the encapsulation and representation of <code>Test</code> model.
 * 
 * @author Darren Garcia
 */

public class Test {

	private int number;
	private String title;
	private String description;
	private String code;
	private String answer;
	private String fanswer;
	private int points;
	private String correct;
	private String incorrect;
	
	/**
	 * Creates a blank representation for <code>Test</code> model.
	 */
	public Test() {
		
	}

	public Test(int number, String title, String description, String code, String answer, String fanswer, int points, String correct, String incorrect) {
		this.number = number;
		this.title = title;
		this.description = description;
		this.code = code;
		this.answer = answer;
		this.fanswer = fanswer;
		this.points = points;
		this.correct = correct;
		this.incorrect = incorrect;
	}

	public int getNumber() {
		return number;
	}

	public void setUsername(int number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String getFullAnswer() {
		return fanswer;
	}
	
	public void setFullAnswer(String fanswer) {
		this.fanswer = fanswer;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public String getCorrect() {
		return correct;
	}
	
	public void setCorrect(String correct) {
		this.correct = correct;
	}
	
	public String getIncorrect() {
		return incorrect;
	}
	
	public void setIncorrect(String incorrect) {
		this.incorrect = incorrect;
	}
}
