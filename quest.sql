-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 01, 2017 at 03:01 PM
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
  `A_Msg` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `achievements`
--

INSERT INTO `achievements` (`A_Num`, `A_Ttl`, `A_Msg`) VALUES
(0, 'None', 'This is a null achievement! Great job getting this (somehow)!'),
(1, 'Integer master', 'You’ve cleared the variable declaration test for integers!'),
(2, 'Player user', 'You’ve cleared the variable declaration test for characters!'),
(3, 'Floatation device', 'You’ve cleared the variable declaration test for floating points!'),
(4, 'Light strike arrays', 'You’ve cleared the variable declaration test for arrays!'),
(5, 'Input world', 'You’ve cleared the input statement test! Input statements are a very needed function in coding, to allow for user interaction.'),
(6, 'Output hello world', 'You’ve cleared the output statement test! Output statements are a good indication the code is working properly!'),
(7, 'else case', 'You’ve cleared the else statement test! When all else fails, we go to else!'),
(8, 'A light switch', 'You’ve cleared the switch statement test! A simple way to use condition statements, but with the added function of it being able to waterfall down and activate the other switches as well!'),
(9, 'for loops only', 'You’ve cleared the for loops test! You should be more familiar with them now.'),
(10, 'while true', 'You’ve cleared the while loops test! A good programmer should know how to make use of both loops!'),
(11, 'Semi-colons', 'You’ve cleared the semicolons test! There is no semicolon escaping your sight now.'),
(12, 'Brace yourself winter is coming', 'You’ve cleared the braces closing test! You are prepared for winter. A brace is an essential part of the program, which won''t run if there''s one missing!'),
(13, '(()) is not a palindrome, but ())( is', 'You’ve cleared the parenthesis closing test! You’ve seen where this parenthesis ends.'),
(14, 'Function calling', 'You’ve cleared the function calling test! Functions are a basic part of programs, so make sure to make full use of them!'),
(15, 'Function naming', 'You’ve cleared the function naming/creation test! Functions need to have good name to let the programmer know what exactly it does, as well as have proper variable syntax for its arguments.'),
(16, 'Returning to home', 'You’ve cleared the return statement test! Without a return statement, the function will not be able to pass anything back (with the exception of pointers), so make sure to add a return statement to them!'),
(17, 'if only', 'You’ve cleared the if statement test! If statements are definitely one of a programmer’s best friends.'),
(18, 'else if branching', 'You’ve cleared the else if statement test! When you need more than two choices, you bring in the big guns.'),
(19, 'First quest!', 'You’ve done your first quest, whether it was a simple one or not, you have achieved something!'),
(20, 'Five quests!', 'You’ve done five quests; you are doing a lot more now!'),
(21, 'Ten ten ten', 'Ten quests! Really flooring the quests now!'),
(22, 'Twenty quests', 'Did you think we wouldn’t give you a quest at the twenty mark?'),
(23, 'Fifty quests', 'You have gone so far! Are you really not abusing the system?'),
(24, 'And that makes a hundred', 'You must have spent a lot of time in this! Thank you!');

-- --------------------------------------------------------

--
-- Table structure for table `errors`
--

CREATE TABLE `errors` (
  `Er_Num` int(11) NOT NULL,
  `Er_Typ` int(11) NOT NULL DEFAULT '0',
  `Er_Msg` text NOT NULL,
  `Q_Num` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `quests`
--

CREATE TABLE `quests` (
  `Q_Num` int(11) NOT NULL,
  `Q_Ttl` varchar(64) NOT NULL,
  `Q_Msg` text NOT NULL,
  `Q_Pts` int(11) NOT NULL,
  `Er_Num` int(11) NOT NULL,
  `A_Num` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tests`
--

CREATE TABLE `tests` (
  `T_Num` int(11) NOT NULL,
  `T_Ttl` varchar(64) NOT NULL,
  `T_Msg` text NOT NULL,
  `T_Cod` text NOT NULL,
  `T_Pts` int(11) NOT NULL DEFAULT '50',
  `A_Num` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tests`
--

INSERT INTO `tests` (`T_Num`, `T_Ttl`, `T_Msg`, `T_Cod`, `T_Pts`, `A_Num`) VALUES
(1, 'Variable Declaration (Integer)', 'Create an integer variable named "number" that outputs 14 when 5 is added.', 'main ()\r\n{\r\n  /** insert here **/\r\n  number = number + 5;\r\n  printf("%d", number);\r\n}', 50, 1),
(2, 'Variable Declaration (Character)', 'Create a character variable named "answer" that will store the character ''y'' when inputted.', 'main () \r\n{\r\n  /** insert here **/\r\n  scanf("%c", &answer);\r\n  printf("Your answer is: %c", answer);\r\n}\r\n', 50, 2),
(3, 'Variable Declaration (Float)', 'Create a float variable named "gpa" that will store the output of the program.', 'main () \r\n{\r\n  /** insert here **/\r\n  printf("Your grades for each subject this term: 4.0, 3.5, 3.0, 2.5, 3.5");\r\n  gpa = 4.0 + 3.5 + 3.0 + 2.5 + 3.5;\r\n  gpa = gpa / 5;\r\n}\r\n', 50, 3),
(4, 'Arrays', 'Make a 10 element array named “numbers” to contain 10 integers.', 'main () \r\n{\r\n  /** insert here **/\r\n  int i = 0; \r\n  for (i = 0; i < 10; i++) \r\n  {\r\n    Numbers[i] = i;\r\n  }\r\n}\r\n', 50, 4),
(5, 'Input statements', 'Make an input statement that obtains a number for printing.', 'main () \r\n{\r\n  int i = 0; \r\n  /** insert here **/\r\n  printf(“%d”, i);\r\n}\r\n', 50, 5),
(6, 'Output statements', 'Make an output statement that prints i.', 'main () \r\n{\r\n  int i = 0; \r\n  scanf(“%d”, &i);\r\n  /** insert here **/\r\n}\r\n', 50, 6),
(7, 'Else Statements', 'Fill in the else statement to be able to let the word “no” print.', 'main () \r\n{\r\n  char i = ‘y’;\r\n  if (i == ‘n’) \r\n  {\r\n    printf("%c", i);\r\n  }\r\n  /** insert here **/\r\n  {\r\n    printf("no");\r\n  }\r\n}\r\n', 50, 7),
(8, 'Switch Statements', 'Fill in the switch statement to be able to let the word “no” print.', 'main () \r\n{\r\n  char i = ‘y’;\r\n  switch ( /** insert here **/ ) \r\n  {\r\n    case ‘y’: \r\n      printf("%c", i); \r\n      break;\r\n    case ‘n’:\r\n      printf(“no”);\r\n      break;\r\n  }\r\n}\r\n', 50, 8),
(9, 'For Loops', 'Description: Fill in the for loop properly to be able to output numbers from 0 - 10.', 'main () \r\n{\r\n  int i = 0;\r\n  for ( /** insert here **/ ; /** insert here **/ ; /** insert here **/ ) \r\n  {\r\n    printf("%d \\n", i);\r\n  }\r\n}\r\n', 50, 9),
(10, 'While Loops', 'Fill in the while loop to be able to output numbers from 10 - 20.', 'main () \r\n{\r\n  int i = 10;\r\n  while ( /** insert here **/ ) \r\n  {	 \r\n    printf("%d \\n", i);\r\n  }\r\n}\r\n', 50, 10),
(11, 'Semi-colons', 'Find the missing semicolon.', 'main () \r\n{\r\n  float pburger = 10;\r\n  float pfries = 8;\r\n  float pchicken = 15;\r\n  float pnuggets = 15\r\n  float pspaghetti = 10;\r\n  float pdrink = 5;\r\n\r\n  // calculations here\r\n}\r\n', 50, 11),
(12, 'Braces', 'Find the missing braces, it could be an opening braces, or a closing one.', 'main () \r\n{\r\n  int i = 0;\r\n  for (i = 0; i <= 10; i++) \r\n  {\r\n    printf("print this! \\n");\r\n  }\r\n', 50, 12),
(13, 'Parenthesis', 'Find the missing parenthesis, it could be an opening parenthesis, or a closing one.', 'main () \r\n{\r\n  int i = 0;\r\n  for i = 0; i <= 20; i++) \r\n  {\r\n    printf("print this! \\n");\r\n  }	\r\n}\r\n', 50, 13),
(14, 'Calling functions', 'Fill in the call function statement to be able to let the variable total print the addition.', 'int add (int a, int b)\r\n{\r\n  return a + b;\r\n}\r\n\r\nmain () \r\n{\r\n  int a = 5;\r\n  int b = 10;\r\n  int total = 0;\r\n  total = /** insert here **/ \r\n  printf(“%d”, total); \r\n}\r\n', 50, 14),
(15, 'Creating functions', 'Fill in the add function statement to be able to let the variable total print the addition.', '/** insert here **/\r\n{\r\n  return a + b;\r\n}\r\n\r\nmain () \r\n{\r\n  int a = 5;\r\n  int b = 10;\r\n  int total = 0;\r\n  total = add(a, b);\r\n  printf(“%d”, total); \r\n}\r\n', 50, 15),
(16, 'Return statements', 'Fill in the return statement of the add function statement to be able to let the variable total print the addition.', 'int add (int a, int b)\r\n{\r\n  /** insert here **/\r\n}\r\n\r\nmain () \r\n{\r\n  int a = 5;\r\n  int b = 10;\r\n  int total = 0;\r\n  total = add(a, b);\r\n  printf(“%d”, total); \r\n}\r\n', 50, 16),
(17, 'Looking for a certain end', 'Find the line of the error!', 'int add (int a, int b)\r\n{\r\n  return a + b\r\n}\r\n\r\nmain () \r\n{\r\n  int a = 5;\r\n  int b = 10;\r\n  int total = 0;\r\n  total = add(a, b);\r\n  printf(“%d”, total); \r\n}\r\n', 50, 0),
(18, 'Forever more', 'Find the line of the error!', 'int add (int a, int b)\r\n{\r\n  return a + b;\r\n}\r\n\r\nmain () \r\n{\r\n  int i = 0;\r\n  int a = 5;\r\n  int b = 10;\r\n  int total = 0;\r\n  for (i = 0; i < 9; i+) \r\n  {\r\n    total = add(a, b);\r\n    printf(“%d”, total);\r\n  } \r\n}\r\n', 50, 0),
(19, 'Elsie is there', 'Find the line of the error!', 'main () \r\n{\r\n  int i = 9;\r\n  if (i == 8)\r\n  {\r\n    printf(“%d”, i);\r\n  }\r\n  else (i == 9)\r\n  {\r\n    printf(“else”);\r\n  } \r\n}\r\n', 50, 0),
(20, 'A printing error', 'Find the line of the error!', 'main () \r\n{\r\n  int i = 9;\r\n  if (i == 8)\r\n  {\r\n    print(“%d”, i);\r\n  }\r\n  else\r\n  {\r\n    printf(“else”);\r\n  } \r\n}\r\n', 50, 0),
(21, 'If Statements', 'Fill in the if statement to be able to let the character print.', 'main () \r\n{\r\n  char i = ‘y’;\r\n  if ( /** insert here **/ ) \r\n  {\r\n    printf("%c", i);\r\n  }\r\n}\r\n', 50, 17),
(22, 'Else If Statements', 'Fill in the else if statement to be able to let the word “no” print.', 'main () \r\n{\r\n  char i = ‘y’;\r\n  if (i == ‘n’) \r\n  {\r\n    printf("%c", i);\r\n  }\r\n  else if ( /** insert here **/ )\r\n  {\r\n    printf("no");\r\n  }\r\n}\r\n', 50, 18);

-- --------------------------------------------------------

--
-- Table structure for table `usererrors`
--

CREATE TABLE `usererrors` (
  `Ue_Cnt` int(11) NOT NULL DEFAULT '0',
  `Er_Num` int(11) NOT NULL,
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
  `U_Usn` text NOT NULL,
  `U_Pas` text NOT NULL,
  `U_Pts` int(11) NOT NULL,
  `U_Ach` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `achievements`
--
ALTER TABLE `achievements`
  ADD PRIMARY KEY (`A_Num`);

--
-- Indexes for table `errors`
--
ALTER TABLE `errors`
  ADD PRIMARY KEY (`Er_Num`);

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
  MODIFY `A_Num` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `errors`
--
ALTER TABLE `errors`
  MODIFY `Er_Num` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `quests`
--
ALTER TABLE `quests`
  MODIFY `Q_Num` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tests`
--
ALTER TABLE `tests`
  MODIFY `T_Num` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `U_Num` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
