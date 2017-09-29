package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ErrorPolling implements Runnable {

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
	private static final Pattern PATTERN_MISSING_FILE = Pattern.compile("(No such file or directory)");

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

	public void run(String perror) {
		/**
		 * Call API from PDE-C to compile the Program
		 * located in PCompiler.java, under CompileRun
		 * Key variables: String error
		 */

		//obtaining amount of copies of a certain error
		int index = 0;
		int count = 0;
		int length = perror.length();
		while ((index = error.indexOf(perror, index)) != -1 ) {                
			index += length; 
			count++;
		}
	}
	/**
	 * This method converts the error messages created by <code>gcc</code> into the simplified error messages of PDE-C.
	 * The conversion is based on the default regex patterns of PDE-C. If an error message not found in the regex patterns of PDE-C, that error message will be returned as an empty string.
	 * 
	 * @return The simplified error message.
	 */
	public String simplify(){
		String errorDesc = "";
		String line = error;
		Matcher m = PATTERN_PATH.matcher(line);

		if (m.find()) {

			errorDesc = line;
			line = line.substring(0, line.length()-m.group().length());

			Matcher m2 = PATTERN_ERROR.matcher(errorDesc);
			if (m2.find())
			{
				errorDesc = m2.group();
				errorDesc = convert(new ErrorMessage("", errorDesc, m.group()));
				//errorDesc = removeDuplicates(errorDesc);
				//System.out.println(errorDesc);
				return errorDesc;
			}

		}

		m = PATTERN_PATH_MAIN.matcher(line);

		if (m.find()) {
			errorDesc = "";
			//System.out.println(errorDesc);
			return errorDesc;
		}

		return errorDesc;
	}

	/**
	 * Explain the process here.
	 * 
	 * @param errorDesc The Error Message Object
	 * @return The equivalent of the converted message.
	 */
	private String convert(ErrorMessage errorDesc) {
		Matcher m;

		m = PATTERN_NOTE_UNDECLARED_IDENTIFIER.matcher(errorDesc.getMessage());
		if (m.find()) {
			errorDesc.setType(NOTE);
			errorDesc.setMessage(NOTE_UNDECLARED_IDENTIFIER);
			errorDesc.setLine(errorDesc.getLine());
			return errorDesc.getErrorMessage();
		}
		m = PATTERN_NOTE_PROVIDE_STDIOH.matcher(errorDesc.getMessage());
		if (m.find()) {
			errorDesc.setType(NOTE);
			errorDesc.setMessage(NOTE_PROVIDE_STDIOH);
			errorDesc.setLine(errorDesc.getLine());
			return errorDesc.getErrorMessage();
		}
		m = PATTERN_UNDECLARED_VARIABLE.matcher(errorDesc.getMessage());
		if (m.find()) {
			errorDesc.setType(ERROR);
			errorDesc.setMessage(UNDECLARED_VARIABLE);
			errorDesc.setLine(errorDesc.getLine());
			return errorDesc.getErrorMessage();
		}
		m = PATTERN_MISSING_SEMICOLON.matcher(errorDesc.getMessage());
		if (m.find()) {
			errorDesc.setType(ERROR);
			errorDesc.setMessage(MISSING_SEMICOLON);
			errorDesc.setLine(errorDesc.getLine());
			return errorDesc.getErrorMessage();
		}
		m = PATTERN_MISSING_PARENTHESIS_L.matcher(errorDesc.getMessage());
		if (m.find()) {
			errorDesc.setType(ERROR);
			errorDesc.setMessage(MISSING_PARENTHESIS_L);
			errorDesc.setLine(errorDesc.getLine());
			return errorDesc.getErrorMessage();
		}
		m = PATTERN_MISSING_PARENTHESIS_R.matcher(errorDesc.getMessage());
		if (m.find()) {
			errorDesc.setType(ERROR);
			errorDesc.setMessage(MISSING_PARENTHESIS_R);
			errorDesc.setLine(errorDesc.getLine());
			return errorDesc.getErrorMessage();
		}
		m = PATTERN_MISSING_BRACE_L.matcher(errorDesc.getMessage());
		if (m.find()) {
			errorDesc.setType(ERROR);
			errorDesc.setMessage(MISSING_BRACE_L);
			errorDesc.setLine(errorDesc.getLine());
			return errorDesc.getErrorMessage();
		}
		m = PATTERN_MISSING_BRACE_R.matcher(errorDesc.getMessage());
		if (m.find()) {
			errorDesc.setType(ERROR);
			errorDesc.setMessage(MISSING_BRACE_R);
			errorDesc.setLine(errorDesc.getLine());
			return errorDesc.getErrorMessage();
		}
		m = PATTERN_MISSING_INITIALIZE.matcher(errorDesc.getMessage());
		if (m.find()) {
			errorDesc.setType(ERROR);
			errorDesc.setMessage(MISSING_INITIALIZE);
			errorDesc.setLine(errorDesc.getLine());
			return errorDesc.getErrorMessage();
		}
		m = PATTERN_MISSING_EXPRESSION.matcher(errorDesc.getMessage());
		if (m.find()) {
			errorDesc.setType(ERROR);
			errorDesc.setMessage(MISSING_EXPRESSION);
			errorDesc.setLine(errorDesc.getLine());
			return errorDesc.getErrorMessage();
		}
		m = PATTERN_MISSING_STATEMENT.matcher(errorDesc.getMessage());
		if (m.find()) {
			errorDesc.setType(ERROR);
			errorDesc.setMessage(MISSING_STATEMENT);
			errorDesc.setLine(errorDesc.getLine());
			return errorDesc.getErrorMessage();
		}
		m = PATTERN_MISSING_IF_FROM_ELSE.matcher(errorDesc.getMessage());
		if (m.find()) {
			errorDesc.setType(ERROR);
			errorDesc.setMessage(MISSING_IF_FROM_ELSE);
			errorDesc.setLine(errorDesc.getLine());
			return errorDesc.getErrorMessage();
		}
		m = PATTERN_MISSING_TERMINATOR.matcher(errorDesc.getMessage());
		if (m.find()) {
			errorDesc.setType(ERROR);
			errorDesc.setMessage(MISSING_TERMINATOR);
			errorDesc.setLine(errorDesc.getLine());
			return errorDesc.getErrorMessage();
		}
		m = PATTERN_MISSING_INT_MAIN.matcher(errorDesc.getMessage());
		if (m.find()) {
			errorDesc.setType(WARNING);
			errorDesc.setMessage(MISSING_INT_MAIN);
			errorDesc.setLine(errorDesc.getLine());
			return errorDesc.getErrorMessage();
		}
		m = PATTERN_MISSING_INCLUDE.matcher(errorDesc.getMessage());
		if (m.find()) {
			errorDesc.setType(ERROR);
			errorDesc.setMessage(MISSING_INCLUDE);
			errorDesc.setLine(errorDesc.getLine());
			return errorDesc.getErrorMessage();
		}
		m = PATTERN_MISSING_FILE.matcher(errorDesc.getMessage());
		if (m.find()) {
			errorDesc.setType(ERROR);
			errorDesc.setMessage(MISSING_FILE);
			errorDesc.setLine(errorDesc.getLine());
			return errorDesc.getErrorMessage();
		}
		m = PATTERN_INCOMPATIBLE_DECLARATION.matcher(errorDesc.getMessage());
		if (m.find()) {
			errorDesc.setType(WARNING);
			errorDesc.setMessage(INCOMPATIBLE_DECLARATION);
			errorDesc.setLine(errorDesc.getLine());
			return errorDesc.getErrorMessage();
		}
		m = PATTERN_UNKNOWN_TYPE.matcher(errorDesc.getMessage());
		if (m.find()) {
			errorDesc.setType(ERROR);
			errorDesc.setMessage(UNKNOWN_TYPE);
			errorDesc.setLine(errorDesc.getLine());
			return errorDesc.getErrorMessage();
		}
		m = PATTERN_CHARACTER_TOO_LONG.matcher(errorDesc.getMessage());
		if (m.find()) {
			errorDesc.setType(WARNING);
			errorDesc.setMessage(CHARACTER_TOO_LONG);
			errorDesc.setLine(errorDesc.getLine());
			return errorDesc.getErrorMessage();
		}
		m = PATTERN_FEW_PRINTF.matcher(errorDesc.getMessage());
		if (m.find()) {
			errorDesc.setType(ERROR);
			errorDesc.setMessage(FEW_PRINTF);
			errorDesc.setLine(errorDesc.getLine());
			return errorDesc.getErrorMessage();
		}
		m = PATTERN_LEFT_VALUE_NOT_ASSIGNABLE.matcher(errorDesc.getMessage());
		if (m.find()) {
			errorDesc.setType(ERROR);
			errorDesc.setMessage(LEFT_VALUE_NOT_ASSIGNABLE);
			errorDesc.setLine(errorDesc.getLine());
			return errorDesc.getErrorMessage();
		}
		m = PATTERN_INVALID_SUFFIX.matcher(errorDesc.getMessage());
		if (m.find()) {
			errorDesc.setType(ERROR);
			errorDesc.setMessage(INVALID_SUFFIX);
			errorDesc.setLine(errorDesc.getLine());
			return errorDesc.getErrorMessage();
		}
		m = PATTERN_IMPLICIT_FUNCTION.matcher(errorDesc.getMessage());
		if (m.find()) {
			errorDesc.setType(WARNING);
			errorDesc.setMessage(IMPLICIT_FUNCTION);
			errorDesc.setLine(errorDesc.getLine());
			return errorDesc.getErrorMessage();
		}
		m = PATTERN_STRAY_SLASH.matcher(errorDesc.getMessage());
		if (m.find()) {
			errorDesc.setType(ERROR);
			errorDesc.setMessage(STRAY_SLASH);
			errorDesc.setLine(errorDesc.getLine());
			return errorDesc.getErrorMessage();
		}
		//System.out.println(errorDesc);
		return "";
	}

	public void start(){

	}
}
