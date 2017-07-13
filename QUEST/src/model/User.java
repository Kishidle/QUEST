package  model;

import java.io.IOException;



/**
 * Handles the encapsulation and representation of <code>User</code> model.
 * 
 * @author Darren Garcia
 */

public class User {

	private int usernumber;
	private String username;
	private String password;
	private int achievements;
	private int points;
	
	/**
	 * Creates a blank representation for <code>User</code> model.
	 */
	public User() {
		
	}

	/**
	 * Creates a representation that contains the information for <code>User</code> model.
	 * @param username User Username
	 * @param password User Password
	 * @param achievements User Achievements 
	 * @param points User Points 
	 */
	public User(int usernumber, String username, String password, int achievements, int points) {
		this.usernumber = usernumber;
		this.username = username;
		this.password = password;
		this.achievements = achievements;
		this.points = points;
	}

	public int getUserNumber() {
		return usernumber;
	}

	public void setUserNumber(int usernumber) {
		this.usernumber = usernumber;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAchievements() {
		return achievements;
	}

	public void setAchievements(int achievements) {
		this.achievements = achievements;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}
