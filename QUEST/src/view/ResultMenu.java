package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import model.Answer;
import model.Test;
import model.User;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class ResultMenu {

	private JFrame frame;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//ResultMenu window = new ResultMenu();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * @wbp.parser.entryPoint
	 */
	public ResultMenu(User user, Test test, Answer answer, String des, int pts, int ach) {
		initialize(user, test, answer, des, pts, ach);
	}


	@SuppressWarnings("null")
	public void initialize(User user, Test test, Answer answer, String des, int pts, int ach) {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 554);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle(test.getTitle());
		frame.setVisible(true);

		JLabel lblDescription = new JLabel("Description: ");
		lblDescription.setBounds(10, 11, 126, 14);
		frame.getContentPane().add(lblDescription);

		JLabel lblVerdict = new JLabel("Verdict");
		lblVerdict.setBounds(10, 309, 46, 14);
		frame.getContentPane().add(lblVerdict);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							//moving windows
							MainMenu mm = new MainMenu(user);
							mm.setVisible(true);
							frame.dispose();
						} 
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnConfirm.setBounds(335, 481, 89, 23);
		frame.getContentPane().add(btnConfirm);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 141, 414, 157);
		frame.getContentPane().add(scrollPane);

		JTextArea txtrCodeArea = new JTextArea();
		txtrCodeArea.setText(test.getFullAnswer());
		txtrCodeArea.setEditable(false);
		scrollPane.setViewportView(txtrCodeArea);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 334, 414, 120);
		frame.getContentPane().add(scrollPane_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 36, 414, 94);
		frame.getContentPane().add(scrollPane_2);
		
		JTextArea txtrDescriptionArea = new JTextArea();
		txtrDescriptionArea.setText(test.getDescription());
		txtrDescriptionArea.setLineWrap(true);
		txtrDescriptionArea.setWrapStyleWord(true);
		txtrDescriptionArea.setEditable(false);
		scrollPane_2.setViewportView(txtrDescriptionArea);
		System.out.println(answer.getAnswer());
		System.out.println(test.getAnswer());
		
		if (answer.getAnswer().equals(test.getAnswer())) {
			JTextArea txtrVerdictArea = new JTextArea();
			txtrVerdictArea.setText(test.getCorrect());
			txtrVerdictArea.setLineWrap(true);
			txtrVerdictArea.setWrapStyleWord(true);
			txtrVerdictArea.setEditable(false);
			scrollPane_1.setViewportView(txtrVerdictArea);
			
			//inserting into database
			try {
				Connection conn = null;
				Statement stmt = null;

				try {
					Class.forName("com.mysql.jdbc.Driver");	        

					conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/quest", "root", "");	
					stmt = (Statement) conn.createStatement();

					String query = "UPDATE users " +
								   "SET U_Pts = U_Pts + " + pts + " " +
							       "WHERE U_Num = " +  + " ";

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
		}
		else {
			JTextArea txtrVerdictArea = new JTextArea();
			txtrVerdictArea.setText(test.getIncorrect());
			txtrVerdictArea.setLineWrap(true);
			txtrVerdictArea.setWrapStyleWord(true);
			txtrVerdictArea.setEditable(false);
			scrollPane_1.setViewportView(txtrVerdictArea);
		}
		
	}
}
