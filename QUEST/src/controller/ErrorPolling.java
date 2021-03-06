package controller;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import model.Test;
import model.User;

public class ErrorPolling {

	private static String ERROR = " ERROR  :";
	private static String WARNING = " WARNING:";
	private static String NOTE = " NOTE   :";
	
	private static String NOTE_UNDECLARED_IDENTIFIER = "Undeclared variables are reported once for every function in line ";
	private static String NOTE_PROVIDE_STDIOH = "Include <stdio.h> in order to use the function in line ";
	private static String MISSING_SEMICOLON = "There is a missing semicolon (';') before line ";
	private static String MISSING_PARENTHESIS_L = "There is a missing parenthesis ('(') in line ";
	private static String MISSING_PARENTHESIS_R = "There is a missing parenthesis (')') in line ";
	private static String MISSING_BRACE_L = "There is a missing brace ('{') in line ";
	private static String MISSING_BRACE_R = "There is a missing brace ('}') in line ";
	private static String MISSING_INITIALIZE = "There is a missing assignment operation ('=') in line ";
	private static String MISSING_EXPRESSION = "There are missing expressions (values, constants, variables or operators) in line ";
	private static String MISSING_STATEMENT = "There is a missing statement in line ";
	private static String MISSING_IF_FROM_ELSE = "There is a missing 'if' statement for 'else' in line ";
	private static String MISSING_TERMINATOR = "There is a missing terminating character in line ";
	private static String MISSING_INT_MAIN = "There is a missing 'int' at main in line ";
	private static String MISSING_INCLUDE = "There is no filename inside #include in line ";
	private static String MISSING_FILE = "There is no such file or directory exists in line ";

	private static String INCOMPATIBLE_DECLARATION = "There is an incompatible declaration for built-in function in line ";

	private static String UNKNOWN_TYPE = "There is an unknown data type in line ";
	private static String CHARACTER_TOO_LONG = "The value for the data type is too long in line ";
	private static String UNDECLARED_VARIABLE = "There is an undeclared variable in line ";
	private static String IMPLICIT_FUNCTION = "There is an undeclared function in line ";
	private static String STRAY_SLASH = "There is a stray '\\' in line ";

	private static String FEW_PRINTF = "The function 'printf' is incomplete in line ";
	private static String LEFT_VALUE_NOT_ASSIGNABLE = "You cannot assign the leftmost value in line ";
	private static String INVALID_SUFFIX = "There is an invalid suffix for a data type in line ";

	private static final Pattern PATTERN_NOTE_UNDECLARED_IDENTIFIER = Pattern.compile("(note: each undeclared identifier is reported only once for each function it appears in)");
	private static final Pattern PATTERN_NOTE_PROVIDE_STDIOH = Pattern.compile("(note: include '<stdio.h>')");

	private static final Pattern PATTERN_MISSING_SEMICOLON = Pattern.compile("(error: expected ';')|(error: expected ',' or ';')");
	private static final Pattern PATTERN_MISSING_PARENTHESIS_L = Pattern.compile("(error: expected identifier or '\\(' before)|(error: expected '\\(')");
	private static final Pattern PATTERN_MISSING_PARENTHESIS_R = Pattern.compile("(error: expected '\\)' before)");
	private static final Pattern PATTERN_MISSING_BRACE_L = Pattern.compile("(error: expected '\\{' at end of input)|(error: expected declaration specifiers before '\\}' token)");
	private static final Pattern PATTERN_MISSING_BRACE_R = Pattern.compile("(error: expected declaration or statement at end of input)");
	private static final Pattern PATTERN_MISSING_INITIALIZE = Pattern.compile("(error: expected '=')");
	private static final Pattern PATTERN_MISSING_EXPRESSION = Pattern.compile("(error: expected expression before)");
	private static final Pattern PATTERN_MISSING_STATEMENT = Pattern.compile("(error: expected statement before)");
	private static final Pattern PATTERN_MISSING_IF_FROM_ELSE = Pattern.compile("(error: 'else' without a previous 'if')");
	private static final Pattern PATTERN_MISSING_TERMINATOR = Pattern.compile("(error: missing terminating)");
	private static final Pattern PATTERN_MISSING_INT_MAIN = Pattern.compile("(warning: return type defaults to 'int')");
	private static final Pattern PATTERN_MISSING_INCLUDE = Pattern.compile("(error: empty filename in #include)");
	private static final Pattern PATTERN_MISSING_FILE2 = Pattern.compile("(No such file or directory)");

	private static final Pattern PATTERN_INCOMPATIBLE_DECLARATION = Pattern.compile("(warning: incompatible implicit declaration of built-in function)");

	private static final Pattern PATTERN_UNDECLARED_VARIABLE = Pattern.compile("(undeclared \\(first use in this function\\))");
	private static final Pattern PATTERN_UNKNOWN_TYPE = Pattern.compile("(error: unknown type name)");
	private static final Pattern PATTERN_CHARACTER_TOO_LONG = Pattern.compile("(warning: character constant too long for its type)|(warning: multi-character character constant)|(warning: overflow in implicit constant conversion)");
	private static final Pattern PATTERN_FEW_PRINTF = Pattern.compile("(error: too few arguments to function 'printf')");
	private static final Pattern PATTERN_LEFT_VALUE_NOT_ASSIGNABLE = Pattern.compile("(error: lvalue required as left operand of assignment)");
	private static final Pattern PATTERN_INVALID_SUFFIX = Pattern.compile("(error: invalid suffix)");
	private static final Pattern PATTERN_IMPLICIT_FUNCTION = Pattern.compile("(warning: implicit declaration of function)");
	private static final Pattern PATTERN_STRAY_SLASH = Pattern.compile("(error: stray '\\\\')");

	private static final Pattern PATTERN_PATH_MAIN = Pattern.compile("(?!.c: In function 'main':)");
	private static final Pattern PATTERN_PATH = Pattern.compile("((?!.c:)[0-9]+(?=:\\d))"); //pattern for path
	private static final Pattern PATTERN_ERROR = Pattern.compile("((error:)|(warning:)|(note:)) (.*)"); //pattern for error/note/warning

	public void run(String perror, User user, String filePath) {
		/**
		 * Call API from PDE-C to compile the Program
		 * located in PCompiler.java, under CompileRun
		 * Key variables: String error
		 */

		//obtaining amount of copies of a certain error
		int index = 0;
		int count = 0;
		int length = perror.length();
		while ((index = ERROR.indexOf(perror, index)) != -1) {                
			index += length; 
			count++;
		}
		
		String[] errorArr = { NOTE_UNDECLARED_IDENTIFIER, NOTE_PROVIDE_STDIOH, MISSING_SEMICOLON, MISSING_PARENTHESIS_L, MISSING_PARENTHESIS_R, MISSING_BRACE_L, MISSING_BRACE_R,
				               MISSING_INITIALIZE, MISSING_EXPRESSION, MISSING_STATEMENT, MISSING_IF_FROM_ELSE, MISSING_TERMINATOR, MISSING_INT_MAIN, MISSING_INCLUDE, MISSING_FILE,
				               INCOMPATIBLE_DECLARATION, UNKNOWN_TYPE, CHARACTER_TOO_LONG, UNDECLARED_VARIABLE, IMPLICIT_FUNCTION, STRAY_SLASH, FEW_PRINTF, LEFT_VALUE_NOT_ASSIGNABLE,
				               INVALID_SUFFIX};
		
		int[] errorTyp = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 0, 0, 20, 0, 21};
		
		int[] questNum = {0, 0, 0, 0, 0};
		int[] questTyp = {0, 0, 0, 0, 0};
		boolean[] questClr = {false, false, false, false, false};
		
		/** 
		 * gets data from the db regarding the state of quests the current program has
		 * for checking if a quest is completed
		 */
		
		try {
			Connection conn = null;
			Statement stmt = null;

			try {
				Class.forName("com.mysql.jdbc.Driver");	        

				conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/quest", "root", "");	
				stmt = (Statement) conn.createStatement();

				String check = "SELECT UQ_Num, Q_Num FROM userquests " +
							   "WHERE U_Num = " + user.getUserNumber() + " AND UQ_Pth = " + filePath + " AND UQ_Clr == 0";
			
				ResultSet res = stmt.executeQuery(check);
				
				int counter = 0;
				
				if (res.next()) {
					int rows = res.getInt(1);
					questNum[counter] = res.getInt("UQ_Num");
					questTyp[counter] = res.getInt("Q_Num");
					counter++;
				}	
			} 
			catch(Exception a) {
				System.out.println(a.getMessage());	    	
				JOptionPane.showMessageDialog(null, "A database error occured.");
			}	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		/**
		 * finds if the error log has the corresponding quest's errors still, if it does
		 * then the quest is not marked as completed. if it doesn't, then the quest is
		 * marked as completed. after this the completion is reflected on the database.
		 */
		
		for(int i = 0; i < errorArr.length; i++){
			if(perror.contains(errorArr[i]) && errorTyp[i] != 0){
				//do nothing
			}
			else if (errorTyp[i] != 0) {
				//proceed to check if this error is present in any of the quests
				int j = 0;
				while (questTyp[j] != 0) {
					if (questTyp[j] == errorTyp[i]) {
						questClr[j] = true;
						try {
							Connection conn = null;
							Statement stmt = null;

							try {
								Class.forName("com.mysql.jdbc.Driver");	        

								conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/quest", "root", "");	
								stmt = (Statement) conn.createStatement();

								String solve = "UPDATE userquests" +
											   "SET U_Clr = 1" +
											   "WHERE U_Num = " + user.getUserNumber() + " AND UQ_Pth = " + filePath + " AND UQ_Num = " + questNum[j];
							
								stmt.executeQuery(solve);
								
								String userup = "UPDATE users " +
										   	    "SET U_Pts = U_Pts + " + 20 + " " +
								                "WHERE U_Num = " + user.getUserNumber() + " ";

								stmt.executeUpdate(userup);

							} 
							catch(Exception a) {
								System.out.println(a.getMessage());	    	
								JOptionPane.showMessageDialog(null, "A database error occured.");
							}	
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
					j++;
				}
			}
		}
		
		/**
		 * finds first error description in the errorArray, then proceeds to generate a quest 
		 * based on it
		 */
		
		for(int i = 0; i < errorArr.length; i++){
			if(perror.contains(errorArr[i]) && errorTyp[i] != 0){
				
				try {
					Connection conn = null;
					Statement stmt = null;

					try {
						Class.forName("com.mysql.jdbc.Driver");	        

						conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/quest", "root", "");	
						stmt = (Statement) conn.createStatement();

						/**
						 * obtains the number of quests already generated for the user for a specific program
						 * if it's equal to 5, no more quests are generated and the loop is broken
						 */
						
						int rows = 0;
						
						String query = "SELECT count(U_Num) FROM userquests " +
									   "WHERE U_Num = " + user.getUserNumber() + " AND  UQ_Path = " + filePath + " ";
						
						ResultSet rs = stmt.executeQuery(query);
						
						if (rs.next()) {
							rows = rs.getInt(1);
						}
						
						if (rows >= 5) {
							break;
						}
						
						/**
						 * if the amount of quests are less than 5, we generate one quest, but first we access
						 * the quest db for the corresponding error
						 */
						
						query = "SELECT * FROM quests " +
								"WHERE Q_Num = " + errorTyp[i] + " ";
					
						rs = stmt.executeQuery(query);
						
						int num = 0;
						String ttl = "";
						String msg = "";
						int pts = 0;
						int ach = 0;
						
						if (rs.next()) {
							rows = rs.getInt(1);
							num = rs.getInt("Q_Num");
							ttl = rs.getString("Q_Ttl");
							msg = rs.getString("Q_Msg");
							pts = rs.getInt("Q_Pts");
							ach = rs.getInt("A_Num");
						}
						
						/**
						 * after obtaining the corresponding quest, we generate the quest itself and insert
						 * it into the db
						 */
						
						query = "INSERT INTO userquests (UQ_Qnm, UQ_Pnm, UQ_Pts, UQ_Pth, Q_Num, U_Num) " +
								"VALUES ('" + ttl + "', '" + msg + "', '" + pts + "', '" + filePath + "', '" + num + "', '" + user.getUserNumber() + "')";
						
						stmt.executeUpdate(query);
						
					} 
					catch(Exception a) {
						System.out.println(a.getMessage());	    	
						JOptionPane.showMessageDialog(null, "A database error occured.");
					}	
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
				break;
			}
		}
	}
	
	
	public ErrorPolling(String perror, User user, String filePath) {
		run(perror, user, filePath);
	}
}
