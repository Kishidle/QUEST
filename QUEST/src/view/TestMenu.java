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

public class TestMenu {

	private JFrame frame;
	private JTextField textField;
	public String des;
	
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

	
	
	public TestMenu(User user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * 
	 */
	public void initialize(User user) {
		String ttl = "";
		String cod = "";
		int pts = 0;
		int nach = 0;
		Test test = new Test();
				
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			Connection conn = null;
			Statement stmt = null;

			try {
				Class.forName("com.mysql.jdbc.Driver");	        

				conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/quest", "root", "");	
				stmt = (Statement) conn.createStatement();

				String query = "SELECT * FROM tests " +
							   "WHERE A_Num !='0' " +
						       "ORDER BY RAND() " +
						       "LIMIT 1";
				
				ResultSet rs = stmt.executeQuery(query);
				
				if (rs.next()) {
					int rows = rs.getInt(1);
					int num = rs.getInt("T_Num");
					ttl = rs.getString("T_Ttl");
					des = rs.getString("T_Msg");
					cod = rs.getString("T_Cod");
					String ans = rs.getString("T_Ans");
					String fan = rs.getString("T_Fan");
					pts = rs.getInt("T_Pts");
					String cor = rs.getString("T_Cor");
					String inc = rs.getString("T_Inc");
					nach = rs.getInt("A_Num");
					
					test = new Test(num, ttl, des, cod, ans, fan, pts, cor, inc, nach);
				} 
				else {
					JOptionPane.showMessageDialog(null, "Nothing found!");
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

		
		frame.setTitle(ttl + " / Points: " + pts);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblDescription = new JLabel("Description: ");
		lblDescription.setBounds(10, 24, 89, 14);
		panel.add(lblDescription);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 115, 414, 168);
		panel.add(scrollPane);
		
		JTextArea txtrCodeArea = new JTextArea();
		txtrCodeArea.setText(cod);
		txtrCodeArea.setEditable(false);
		scrollPane.setViewportView(txtrCodeArea);
		
		JLabel lblAnswer = new JLabel("Answer: ");
		lblAnswer.setBounds(10, 309, 67, 14);
		panel.add(lblAnswer);
		
		textField = new JTextField();
		textField.setBounds(87, 306, 337, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		final Test ptest = test;
		final int pt = pts;
		final int ach = nach;
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() { 
						try {
							Answer man = new Answer(textField.getText());
							//moving windows
							ResultMenu rm = new ResultMenu(user, ptest, man, des, pt, ach);
							//rm.initialize(user, ptest, man);
							frame.dispose();
						} 
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnSubmit.setBounds(335, 368, 89, 23);
		panel.add(btnSubmit);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 49, 414, 59);
		panel.add(scrollPane_1);
		
		JTextArea txtrDescriptionArea = new JTextArea();
		txtrDescriptionArea.setText(des);
		txtrDescriptionArea.setLineWrap(true);
		txtrDescriptionArea.setWrapStyleWord(true);
		txtrDescriptionArea.setEditable(false);
		scrollPane_1.setViewportView(txtrDescriptionArea);
	}
}
