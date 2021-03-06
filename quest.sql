-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 05, 2017 at 08:08 AM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quest`
--

-- --------------------------------------------------------

--
-- Table structure for table `achievements`
--

CREATE TABLE `achievements` (
  `A_Num` int(11) NOT NULL,
  `A_Ttl` varchar(64) NOT NULL,
  `A_Msg` text NOT NULL,
  `A_Bdg` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `achievements`
--

INSERT INTO `achievements` (`A_Num`, `A_Ttl`, `A_Msg`, `A_Bdg`) VALUES
(0, 'None', 'This is a null achievement! Great job getting this (somehow)!', 3),
(1, 'Integer master', 'You’ve cleared the variable declaration test for integers!', 1),
(2, 'Player user', 'You’ve cleared the variable declaration test for characters!', 1),
(3, 'Floatation device', 'You’ve cleared the variable declaration test for floating points!', 1),
(4, 'Light strike arrays', 'You’ve cleared the variable declaration test for arrays!', 2),
(5, 'Input world', 'You’ve cleared the input statement test! Input statements are a very needed function in coding, to allow for user interaction.', 1),
(6, 'Output hello world', 'You’ve cleared the output statement test! Output statements are a good indication the code is working properly!', 1),
(7, 'else case', 'You’ve cleared the else statement test! When all else fails, we go to else!', 2),
(8, 'A light switch', 'You’ve cleared the switch statement test! A simple way to use condition statements, but with the added function of it being able to waterfall down and activate the other switches as well!', 2),
(9, 'for loops only', 'You’ve cleared the for loops test! You should be more familiar with them now.', 2),
(10, 'while true', 'You’ve cleared the while loops test! A good programmer should know how to make use of both loops!', 2),
(11, 'Semi-colons', 'You’ve cleared the semicolons test! There is no semicolon escaping your sight now.', 1),
(12, 'Brace yourself winter is coming', 'You’ve cleared the braces closing test! You are prepared for winter. A brace is an essential part of the program, which won''t run if there''s one missing!', 1),
(13, '(()) is not a palindrome, but ())( is', 'You’ve cleared the parenthesis closing test! You’ve seen where this parenthesis ends.', 1),
(14, 'Function calling', 'You’ve cleared the function calling test! Functions are a basic part of programs, so make sure to make full use of them!', 3),
(15, 'Function naming', 'You’ve cleared the function naming/creation test! Functions need to have good name to let the programmer know what exactly it does, as well as have proper variable syntax for its arguments.', 3),
(16, 'Returning to home', 'You’ve cleared the return statement test! Without a return statement, the function will not be able to pass anything back (with the exception of pointers), so make sure to add a return statement to them!', 3),
(17, 'if only', 'You’ve cleared the if statement test! If statements are definitely one of a programmer’s best friends.', 2),
(18, 'else if branching', 'You’ve cleared the else if statement test! When you need more than two choices, you bring in the big guns.', 2),
(19, 'First quest!', 'You’ve done your first quest, whether it was a simple one or not, you have achieved something!', 1),
(20, 'Five quests!', 'You’ve done five quests; you are doing a lot more now!', 1),
(21, 'Ten ten ten', 'Ten quests! Really flooring the quests now!', 2),
(22, 'Twenty quests', 'Did you think we wouldn’t give you a quest at the twenty mark?', 2),
(23, 'Fifty quests', 'You have gone so far! Are you really not abusing the system?', 2),
(24, 'And that makes a hundred', 'You must have spent a lot of time in this! Thank you!', 3),
(25, 'Five unique quests', 'You’ve done five unique quests!', 0),
(26, 'Ten is rare\r\n', 'You’ve done ten unique quests! At least you’re finding the quests instead of spamming the others!', 0);

-- --------------------------------------------------------

--
-- Table structure for table `quests`
--

CREATE TABLE `quests` (
  `Q_Num` int(11) NOT NULL,
  `Q_Ttl` varchar(64) NOT NULL,
  `Q_Msg` text NOT NULL,
  `Q_Pts` int(11) NOT NULL DEFAULT '20',
  `A_Num` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `quests`
--

INSERT INTO `quests` (`Q_Num`, `Q_Ttl`, `Q_Msg`, `Q_Pts`, `A_Num`) VALUES
(1, 'Undeclared identifiers', 'Undeclared identifiers (names of variables) have been found! They might have been misspelled, so double check to make sure they are there!', 20, 0),
(2, 'Package handling', 'A function without the proper include has been found! In order to make use of a function found in the program, include <stdio.h> (standard input/output library)!', 20, 0),
(3, 'A missing end', 'A line reported to not having a semicolon before it! Make sure to have semicolons present in lines where it is needed, such as math operations, print statements etc.', 20, 0),
(4, 'Parenthesis: Part 1', 'There may be a missing left (‘(‘) parenthesis present within the program!', 20, 0),
(5, 'Parenthesis: Part 2', 'There may be a missing right (‘)’) parenthesis present within the program!', 20, 0),
(6, 'Brace: Part 1', 'There may be a missing left (‘{‘) brace present within the program!', 20, 0),
(7, 'Brace: Part 2', 'There may be a missing right (‘}’) brace present within the program!', 20, 0),
(8, 'Missing assignment', 'There may be a missing assignment operation (one that may transfer a value into a variable) found within the program!', 20, 0),
(9, 'Missing expressions', 'There are missing expressions found within the program! Expressions can take the form of values (a number), constants (predefined variables), variables or operators (+, -, /, %, *).', 20, 0),
(10, 'A quiet line', 'There seems to be a missing statement somewhere within the program!', 20, 0),
(11, 'No initial condition', 'There seems to have been an ‘else’ statement missing an ‘if’ statement within the program! ‘else’ statements can only function when there is an accompanying ‘if’ statement before it!', 20, 0),
(12, 'Won’t be back', 'There seems to be a missing terminating character found! Terminating characters can take on many different ways, such as a closing quotation (‘“‘), to end a printf string sequence.', 20, 0),
(13, 'void main?', 'There is a missing ‘int’ in front of ‘main’! It is a characteristic of c to have int in front of main.', 20, 0),
(14, 'Exclude', 'There is an include found that is not referencing any files! Do not leave it hanging, either include a file, or delete it to run smoothly.', 20, 0),
(15, 'Non-existent file', 'A file or directory seems to not exist! Are you sure you have the correct file or directory? Double check its spelling and its directory to make sure!', 20, 0),
(16, 'Incompatible functions', 'There seems to be an incompatibility issue for a built-in function in the program! Incompatibility issues stem from using a function improperly, such as trying to force a character function to accept float values.', 20, 0),
(17, 'Fear of the unknown', 'An unknown data type has been found in one of the lines! The unknown data type error is usually found when a constant has not been declared, or a simple misspelling of a common data type such as typing ‘char’ as ‘chsr’.', 20, 0),
(18, 'Overlimit', 'The data type for one or more of data types is too long! For characters, this is 255, for integers, this is 2147483647, and for float this is 3.4028234664e+38.', 20, 0),
(19, 'Variability missing', 'There is an undeclared variable found in one of the lines! It may be misspelled or not declared at all, make sure to check!', 20, 0),
(20, '‘print’ as output function', 'The ‘printf’ function is incomplete in one of the lines! Make sure it has everything it needs, here’s an example: printf(“This is printing an int: %d\\n”, i);', 20, 0),
(21, 'Small fix', 'There is an invalid suffix for a present data type within the program! This may happen when trying to evaluate expressions, where an operator is forgotten and a number ends up as ‘8x’ instead of ‘8 + x’.', 20, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tests`
--

CREATE TABLE `tests` (
  `T_Num` int(11) NOT NULL,
  `T_Ttl` varchar(64) NOT NULL,
  `T_Msg` text NOT NULL,
  `T_Cod` text NOT NULL,
  `T_Ans` text NOT NULL,
  `T_Fan` text NOT NULL,
  `T_Pts` int(11) NOT NULL DEFAULT '50',
  `T_Cor` text NOT NULL,
  `T_Inc` text NOT NULL,
  `A_Num` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tests`
--

INSERT INTO `tests` (`T_Num`, `T_Ttl`, `T_Msg`, `T_Cod`, `T_Ans`, `T_Fan`, `T_Pts`, `T_Cor`, `T_Inc`, `A_Num`) VALUES
(1, 'Variable Declaration (Integer)', 'Create an integer variable named "number" that outputs 14 when 5 is added.', 'int main ()\n{\n  /** insert here **/\n  number = number + 5;\n  printf("%d", number);\n}', 'int number = 9;', 'int main ()\n{\n  int number = 9;\n  number = number + 5;\n  printf("%d", number);\n}', 50, 'Correct! You''ve done a great job!', 'The answer was: int number = 9;\n\nFor reference, the way to declare variables is "[type] [name];". "[=] [value]" comes after if you want to put something in the variable. For example, you could declare int number; or int number = 9. Both are correct.', 1),
(2, 'Variable Declaration (Character)', 'Create a character variable named "answer" that will store the character ''y'' when inputted.', 'int main () \n{\n  /** insert here **/\n  scanf("%c", &answer);\n  printf("Your answer is: %c", answer);\n}\n', 'char answer;', 'int main () \n{\n  char answer;\n  scanf("%c", &answer);\n  printf("Your answer is: %c", answer);\n}\n', 50, 'Correct! You''ve done a great job!', 'The answer was: char answer;\n\nFor reference, the way to declare variables is "[type] [name];". "[=] [value]" comes after if you want to put something in the variable. For example, you could declare char answer; or char answer = ''y''. Both are correct.', 2),
(3, 'Variable Declaration (Float)', 'Create a float variable named "gpa" that will store the output of the program.', 'int main () \n{\n  /** insert here **/\n  printf("Your grades for each subject this term: 4.0, 3.5, 3.0, 2.5, 3.5");\n  gpa = 4.0 + 3.5 + 3.0 + 2.5 + 3.5;\n  gpa = gpa / 5;\n}\n', 'float gpa;', 'int main () \n{\n  float gpa;\n  printf("Your grades for each subject this term: 4.0, 3.5, 3.0, 2.5, 3.5");\n  gpa = 4.0 + 3.5 + 3.0 + 2.5 + 3.5;\n  gpa = gpa / 5;\n}\n', 50, 'Correct! You''ve done a great job!', 'The answer was: float gpa;\n\nFor reference, the way to declare variables is "[type] [name];". "[=] [value]" comes after if you want to put something in the variable. For example, you could declare float number; or float number = 9. Both are correct.', 3),
(4, 'Arrays', 'Make a 10 element array named “numbers” to contain 10 integers.', 'int main () \n{\n  /** insert here **/\n  int i = 0; \n  for (i = 0; i < 10; i++) \n  {\n    Numbers[i] = i;\n  }\n}\n', 'int numbers[10];', 'int main () \n{\n  int numbers[10];\n  int i = 0; \n  for (i = 0; i < 10; i++) \n  {\n    numbers[i] = i;\n  }\n}\n', 50, 'Correct! You''ve done a great job!', 'The answer was: int numbers[10];\n\nFor reference, the way arrays are declared are in the same way variables are declared, except they have a number enclosed. This indicates the size of the array.', 4),
(5, 'Input statements', 'Make an input statement that obtains a number for printing.', 'int main () \n{\n  int i = 0; \n  /** insert here **/\n  printf(“%d”, i);\n}\n', 'scanf("%d", &i);', 'int main () \n{\n  int i = 0; \n  scanf("%d", &i);\n  printf(“%d”, i);\n}\n', 50, 'Correct! You''ve done a great job!', 'The answer was: scanf("%d", &i);\n\nThe number enclosed in quotations signifies the type of variable it is, for example: ''%d'' signifies an integer value. ''&i'' signifies that we are inserting a value into the variable i.', 5),
(6, 'Output statements', 'Make an output statement that prints i.', 'int main () \n{\n  int i = 0; \n  scanf(“%d”, &i);\n  /** insert here **/\n}\n', 'printf("%d", i);', 'int main () \n{\n  int i = 0; \n  scanf(“%d”, &i);\n  scanf("%d", i);\n}\n', 50, 'Correct! You''ve done a great job!', 'The answer was: printf"%d", i);\n\nThe number enclosed within the quotations signifies the type of variable it is, for example: ''%d'' signifies an integer value. ''i'' signifies that we are obtaining the value of i.', 6),
(7, 'Else Statements', 'Fill in the else statement to be able to let the word “no” print.', 'int main () \n{\n  char i = ‘y’;\n  if (i == ‘n’) \n  {\n    printf("%c", i);\n  }\n  /** insert here **/\n  {\n    printf("no");\n  }\n}\n', 'else', 'int main () \n{\n  char i = ‘y’;\n  if (i == ‘n’) \n  {\n    printf("%c", i);\n  }\n  else\n  {\n    printf("no");\n  }\n}\n', 50, 'Correct! You''ve done a great job!', 'The answer was: else\n\nFor else statements, there is no need to include a condition.', 7),
(8, 'Switch Statements', 'Fill in the switch statement to be able to let the word “no” print.', 'int main () \n{\n  char i = ‘y’;\n  switch ( /** insert here **/ ) \n  {\n    case ‘y’: \n      printf("%c", i); \n      break;\n    case ‘n’:\n      printf(“no”);\n      break;\n  }\n}\n', 'i', 'int main () \n{\n  char i = ‘y’;\n  switch (i) \n  {\n    case ‘y’: \n      printf("%c", i); \n      break;\n    case ‘n’:\n      printf(“no”);\n      break;\n  }\n}\n', 50, 'Correct! You''ve done a great job!', 'The answer was: i\n\nIn switch statements, the statement needed in parenthesis is a value to check for. In this case, we are checking for the value of ''i''.', 8),
(9, 'For Loops', 'Description: Fill in the for loop properly to be able to output numbers from 0 - 10 using a less than or equal to comparison.', 'int main () \n{\n  int i = 0;\n  for ( /** insert here **/ ; /** insert here **/ ; /** insert here **/ ) \n  {\n    printf("%d \\n", i);\n  }\n}\n', 'i = 0; i <= 9; i++', 'int main () \n{\n  int i = 0;\n  for (i = 0; i <= 9; i++) \n  {\n    printf("%d \\n", i);\n  }\n}\n', 50, 'Correct! You''ve done a great job!', 'The answer was: i = 0; i <= 9; i++\n\nIn for loops, there are three sets of statements needed. The first one is to initialize the value of the iteration (the value to increase) variable, the second is the end to find out when the loop stops, and the last one is the statement that occurs every time the loop repeats.', 9),
(10, 'While Loops', 'Fill in the while loop to be able to output numbers from 10 - 20 using a less than comparison.', 'int main () \n{\n  int i = 10;\n  while ( /** insert here **/ ) \n  {	 \n    printf("%d \\n", i);\n  }\n}\n', 'i < 20', 'int main () \n{\n  int i = 10;\n  while (i < 20) \n  {	 \n    printf("%d \\n", i);\n  }\n}\n', 50, 'Correct! You''ve done a great job!', 'The answer was: i < 20\n\nUnlike for loops, while loops only need a conditional statement in between the parenthesis, in this case it is ''i < 20''. However, it still needs a way to exit the loop, which is done within the while loop.', 10),
(11, 'Semi-colons', 'Find the missing semicolon. Enter the line number!', 'int main () \n{\n  float pburger = 10;\n  float pfries = 8;\n  float pchicken = 15;\n  float pnuggets = 15\n  float pspaghetti = 10;\n  float pdrink = 5;\n\n  // calculations here\n}\n', '5', 'int main () \n{\n  float pburger = 10;\n  float pfries = 8;\n  float pchicken = 15;\n  float pnuggets = 15;\n  float pspaghetti = 10;\n  float pdrink = 5;\n\n  // calculations here\n}\n', 50, 'Correct! You''ve done a great job!', 'Incorrect!\n\nThe line the missing semicolon was in was line 5!', 11),
(12, 'Braces', 'Find the missing braces, it could be an opening braces, or a closing one. Enter the line number!', 'int main () \n{\n  int i = 0;\n  for (i = 0; i <= 10; i++) \n  {\n    printf("print this! \\n");\n  }\n', '8', 'int main () \n{\n  int i = 0;\n  for (i = 0; i <= 10; i++) \n  {\n    printf("print this! \\n");\n  }\n}', 50, 'Correct! You''ve done a great job!', 'Incorrect!\n\nThe line the missing braces was in was line 8!', 12),
(13, 'Parenthesis', 'Find the missing parenthesis, it could be an opening parenthesis, or a closing one. Enter the line number!', 'int main () \n{\n  int i = 0;\n  for i = 0; i <= 20; i++) \n  {\n    printf("print this! \\n");\n  }	\n}\n', '4', 'int main () \n{\n  int i = 0;\n  for (i = 0; i <= 20; i++) \n  {\n    printf("print this! \\n");\n  }	\n}\n', 50, 'Correct! You''ve done a great job!', 'Incorrect!\n\nThe line the missing parenthesis was in was line 5!', 13),
(14, 'Calling functions', 'Fill in the call function statement to be able to let the variable total print the addition.', 'int add (int a, int b)\n{\n  return a + b;\n}\n\nmain () \n{\n  int a = 5;\n  int b = 10;\n  int total = 0;\n  total = /** insert here **/ \n  printf(“%d”, total); \n}\n', 'add(a, b);', 'int add (int a, int b)\n{\n  return a + b;\n}\n\nmain () \n{\n  int a = 5;\n  int b = 10;\n  int total = 0;\n  total = add(a, b);\n  printf(“%d”, total); \n}\n', 50, 'Correct! You''ve done a great job!', 'The answer was: add(a, b);\n\nWhen it comes to functions, all you need to call is the name and parenthesis. Within it are variables you wish to pass to the function. Like in this case, you want to pass a and b to the function add, so the function call is ''add(a, b);'' ', 14),
(15, 'Creating functions', 'Fill in the add function statement to be able to let the variable total print the addition.', '/** insert here **/\n{\n  return a + b;\n}\n\nint main () \n{\n  int a = 5;\n  int b = 10;\n  int total = 0;\n  total = add(a, b);\n  printf(“%d”, total); \n}\n', 'int add (int a, int b)', 'int add (int a, int b)\n{\n  return a + b;\n}\n\nint main () \n{\n  int a = 5;\n  int b = 10;\n  int total = 0;\n  total = add(a, b);\n  printf(“%d”, total); \n}\n', 50, 'Correct! You''ve done a great job!', 'The answer was: int add (int a, int b);\n\nWhen it comes to creating functions, one would need to declare the name of the function, with a set of parenthesis. Before it also comes the type of return it has. Within the parenthesis are variables that are declared there and receive values from the function call. In this example, add returns an integer value, hence int add. Inside the parenthesis are ''int a, int b'', to be used within the function and are obtained from the function call to int add.', 15),
(16, 'Return statements', 'Fill in the return statement of the add function statement to be able to let the variable total print the addition.', 'int add (int a, int b)\n{\n  /** insert here **/\n}\n\nint main () \n{\n  int a = 5;\n  int b = 10;\n  int total = 0;\n  total = add(a, b);\n  printf(“%d”, total); \n}\n', 'return a + b;', 'int add (int a, int b)\n{\n  return a + b;\n}\n\nint main () \n{\n  int a = 5;\n  int b = 10;\n  int total = 0;\n  total = add(a, b);\n  printf(“%d”, total); \n}\n', 50, 'Correct! You''ve done a great job!', 'The answer was: return a + b;\n\nWhen it comes to return statements, they are very much like inserting a value into a variable. In this case, we are adding a and b, and returning that value.', 16),
(17, 'Looking for a certain end', 'Find the line of the error!', 'int add (int a, int b)\n{\n  return a + b\n}\n\nint main () \n{\n  int a = 5;\n  int b = 10;\n  int total = 0;\n  total = add(a, b);\n  printf(“%d”, total); \n}\n', '3', 'int add (int a, int b)\n{\n  return a + b;\n}\n\nint main () \n{\n  int a = 5;\n  int b = 10;\n  int total = 0;\n  total = add(a, b);\n  printf(“%d”, total); \n}\n', 50, 'Correct! You''ve done a great job!', 'Incorrect!\n\nThe answer was in line 3!', 0),
(18, 'Forever more', 'Find the line of the error!', 'int add (int a, int b)\n{\n  return a + b;\n}\n\nint main () \n{\n  int i = 0;\n  int a = 5;\n  int b = 10;\n  int total = 0;\n  for (i = 0; i < 9; i+) \n  {\n    total = add(a, b);\n    printf(“%d”, total);\n  } \n}\n', '12', 'int add (int a, int b)\n{\n  return a + b;\n}\n\nint main () \n{\n  int i = 0;\n  int a = 5;\n  int b = 10;\n  int total = 0;\n  for (i = 0; i < 9; i++) \n  {\n    total = add(a, b);\n    printf(“%d”, total);\n  } \n}\n', 50, 'Correct! You''ve done a great job!', 'Incorrect!\n\nThe answer was in line 12!', 0),
(19, 'Elsie is there', 'Find the line of the error!', 'int main () \n{\n  int i = 9;\n  if (i == 8)\n  {\n    printf(“%d”, i);\n  }\n  else (i == 9)\n  {\n    printf(“else”);\n  } \n}\n', '8', 'int main () \n{\n  int i = 9;\n  if (i == 8)\n  {\n    printf(“%d”, i);\n  }\n  else if (i == 9)\n  {\n    printf(“else”);\n  } \n}\n', 50, 'Correct! You''ve done a great job!', 'Incorrect!\n\nThe answer was in line 8!', 0),
(20, 'A printing error', 'Find the line of the error!', 'int main () \n{\n  int i = 9;\n  if (i == 8)\n  {\n    print(“%d”, i);\n  }\n  else\n  {\n    printf(“else”);\n  } \n}\n', '6', 'int main () \n{\n  int i = 9;\n  if (i == 8)\n  {\n    printf(“%d”, i);\n  }\n  else\n  {\n    printf(“else”);\n  } \n}\n', 50, 'Correct! You''ve done a great job!', 'Incorrect!\n\nThe answer was in line 6!', 0),
(21, 'If Statements', 'Fill in the if statement to be able to let the character print using an equal to (==) comparison.', 'main () \n{\n  char i = ‘y’;\n  if ( /** insert here **/ ) \n  {\n    printf("%c", i);\n  }\n}\n', 'i == ''y''', 'main () \n{\n  char i = ‘y’;\n  if (i == ''y'') \n  {\n    printf("%c", i);\n  }\n}\n', 50, 'Correct! You''ve done a great job!', 'The answer was: i == ''y''\n\nIn if statements, when it comes to comparison, it has to be in the form of value/variable (comparison) value/variable. In this example, we are comparing i with the character y, to see if they are equal. This gives us i == ''y'', where ''=='' is for comparison.', 17),
(22, 'Else If Statements', 'Fill in the else if statement to be able to let the word “no” print using an equal to (==) comparison.', 'main () \n{\n  char i = ‘y’;\n  if (i == ‘n’) \n  {\n    printf("%c", i);\n  }\n  else if ( /** insert here **/ )\n  {\n    printf("no");\n  }\n}\n', 'i == ''y''', 'main () \n{\n  char i = ‘y’;\n  if (i == ‘n’) \n  {\n    printf("%c", i);\n  }\n  else if (i == ''y'')\n  {\n    printf("no");\n  }\n}\n', 50, 'Correct! You''ve done a great job!', 'The answer was: i == ''y''\n\nWith else if statements, they are the same with normal if statements, except that they need to be right after an if statement, and are written as else if instead of a normal if.', 18),
(23, 'test', 'test', 'test', 'tes', 'test', 50, 'test', 'test', 0);

-- --------------------------------------------------------

--
-- Table structure for table `userachievements`
--

CREATE TABLE `userachievements` (
  `A_Clr` int(11) NOT NULL DEFAULT '0',
  `U_Num` int(11) NOT NULL,
  `A_Num` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userachievements`
--

INSERT INTO `userachievements` (`A_Clr`, `U_Num`, `A_Num`) VALUES
(1, 2, 1),
(1, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `usererrors`
--

CREATE TABLE `usererrors` (
  `Ue_Cnt` int(11) NOT NULL DEFAULT '0',
  `Q_Num` int(11) NOT NULL,
  `U_Num` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `userquests`
--

CREATE TABLE `userquests` (
  `UQ_Clr` int(11) NOT NULL DEFAULT '0',
  `UQ_Cnt` int(11) NOT NULL,
  `UQ_Max` int(11) NOT NULL,
  `Q_Num` int(11) NOT NULL,
  `U_Num` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `U_Num` int(11) NOT NULL,
  `U_Usn` varchar(8) NOT NULL,
  `U_Pas` text NOT NULL,
  `U_Pts` int(11) NOT NULL DEFAULT '0',
  `U_Ach` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`U_Num`, `U_Usn`, `U_Pas`, `U_Pts`, `U_Ach`) VALUES
(1, '11331364', 'admin', 0, 0),
(2, '11331232', 'ayylmao', 100, 2),
(3, '11729832', 'newuser', 200, 0),
(4, '11702832', 'newuser', 300, 0),
(5, '11621325', 'newuser', 400, 0),
(6, '11464878', 'newuser', 500, 0),
(7, '1175252', 'newuser', 600, 0),
(8, '11799992', 'newuser', 700, 0),
(9, '11782632', 'newuser', 800, 0),
(10, '11572636', 'newuser', 900, 0),
(11, '11062523', 'newuser', 1000, 0),
(12, '11213232', 'newuser', 1100, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `achievements`
--
ALTER TABLE `achievements`
  ADD PRIMARY KEY (`A_Num`);

--
-- Indexes for table `quests`
--
ALTER TABLE `quests`
  ADD PRIMARY KEY (`Q_Num`);

--
-- Indexes for table `tests`
--
ALTER TABLE `tests`
  ADD PRIMARY KEY (`T_Num`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`U_Num`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `achievements`
--
ALTER TABLE `achievements`
  MODIFY `A_Num` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT for table `quests`
--
ALTER TABLE `quests`
  MODIFY `Q_Num` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `tests`
--
ALTER TABLE `tests`
  MODIFY `T_Num` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `U_Num` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
