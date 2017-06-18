package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import model.Answer;
import model.Test;
import model.User;

import javax.swing.JButton;

public class AddingTestMenu {

	private JFrame frame;
	private JTextField textField;
	private JTextField pointField;
	public String des;
	private JTextField correctField;
	private JTextField incorrectField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//TestMenu window = new TestMenu();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * @wbp.parser.entryPoint
	 * 
	 * 
	 */

	
	
	public AddingTestMenu(User user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * 
	 */
	public void initialize(User user) {
		String cod = "";
		int pts = 0;
		Test test = new Test();
				
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setTitle("Adding a new test...");
		frame.setVisible(true);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblAnswer = new JLabel("Title: ");
		lblAnswer.setBounds(10, 24, 67, 14);
		panel.add(lblAnswer);
		
		textField = new JTextField();
		textField.setBounds(87, 24, 337, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description: ");
		lblDescription.setBounds(10, 84, 89, 14);
		panel.add(lblDescription);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 175, 414, 168);
		panel.add(scrollPane);
		
		JTextArea txtrCodeArea = new JTextArea();
		txtrCodeArea.setText(cod);
		txtrCodeArea.setEditable(true);
		scrollPane.setViewportView(txtrCodeArea);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 49, 414, 59);
		panel.add(scrollPane_1);
		
		JTextArea txtrDescriptionArea = new JTextArea();
		txtrDescriptionArea.setText("Description here...");
		txtrDescriptionArea.setLineWrap(true);
		txtrDescriptionArea.setWrapStyleWord(true);
		txtrDescriptionArea.setEditable(false);
		scrollPane_1.setViewportView(txtrDescriptionArea);
		
		JLabel lblTitle = new JLabel("Title: ");
		lblTitle.setBounds(10, 379, 67, 14);
		panel.add(lblTitle);
		
		textField = new JTextField();
		textField.setBounds(87, 376, 337, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPoints = new JLabel("Points: ");
		lblPoints.setBounds(10, 420, 67, 14);
		panel.add(lblPoints);
		
		pointField = new JTextField();
		pointField.setBounds(87, 426, 337, 20);
		panel.add(pointField);
		pointField.setColumns(10);
		
		JLabel lblCorrect = new JLabel("Correct Message: ");
		lblCorrect.setBounds(10, 420, 67, 14);
		panel.add(lblCorrect);
		
		correctField = new JTextField();
		correctField.setBounds(87, 466, 337, 20);
		panel.add(correctField);
		correctField.setColumns(10);
		
		JLabel lblIncorrect = new JLabel("Incorrect Message: ");
		lblIncorrect.setBounds(10, 420, 67, 14);
		panel.add(lblIncorrect);
		
		incorrectField = new JTextField();
		incorrectField.setBounds(87, 506, 337, 20);
		panel.add(incorrectField);
		incorrectField.setColumns(10);
		
		final Test ptest = test;
		final int pt = pts;
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() { 
						//Add into database
						try {
							Connection conn = null;
							Statement stmt = null;

							try {
								Class.forName("com.mysql.jdbc.Driver");	        

								conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/quest", "root", "");	
								stmt = (Statement) conn.createStatement();

								String query = "INSERT INTO tests " +
											   "VALUES ('', " + textField.getText() + ", " + txtrDescriptionArea.getText() + ", " + txtrCodeArea.getText() + ", " + pointField.getText() + ", " + correctField.getText() + ", " + incorrectField.getText() + "0)";

								ResultSet rs = stmt.executeQuery(query);
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
				});
			}
		});
		btnSubmit.setBounds(335, 548, 89, 23);
		panel.add(btnSubmit);
	}
}
