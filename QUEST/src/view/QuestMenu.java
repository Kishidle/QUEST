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

public class QuestMenu {

	private JFrame frmQuestBoard;
	private String[] questMessage = {"", "", "", "", ""};
	private String[] questTitle = {"", "", "", "", ""};
	
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
	public QuestMenu(User user, String filePath) {
		initialize(user, filePath);
	}


	@SuppressWarnings("null")
	public void initialize(User user, String filePath) {

		frmQuestBoard = new JFrame();
		frmQuestBoard.setBounds(100, 100, 451, 502);
		frmQuestBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQuestBoard.getContentPane().setLayout(null);
		frmQuestBoard.setTitle("Quest Board");
		frmQuestBoard.setVisible(true);

		/**
		 * getting the quest information from the db
		 */
		
		try {
			Connection conn = null;
			Statement stmt = null;

			try {
				Class.forName("com.mysql.jdbc.Driver");	        

				conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/quest", "root", "");	
				stmt = (Statement) conn.createStatement();

				String check = "SELECT * FROM userquests " +
							   "WHERE U_Num = " + user.getUserNumber() + " AND UQ_Pth = " + filePath + " AND UQ_Clr == 0";
			
				ResultSet res = stmt.executeQuery(check);
				
				int counter = 0;
				
				if (res.next()) {
					int rows = res.getInt(1);
					questTitle[counter] = res.getString("UQ_Qnm");
					questMessage[counter] = res.getString("UQ_Pnm");
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
		
		JLabel lblDescription = new JLabel("Description: ");
		lblDescription.setBounds(215, 13, 126, 14);
		frmQuestBoard.getContentPane().add(lblDescription);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							//moving windows
							MainMenu mm = new MainMenu(user);
							mm.setVisible(true);
							frmQuestBoard.dispose();
						} 
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnConfirm.setBounds(335, 421, 89, 23);
		frmQuestBoard.getContentPane().add(btnConfirm);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(215, 36, 209, 372);
		frmQuestBoard.getContentPane().add(scrollPane_2);
		
		JTextArea questDescriptionArea = new JTextArea();
		scrollPane_2.setViewportView(questDescriptionArea);
		questDescriptionArea.setText("No Quest Selected");
		questDescriptionArea.setLineWrap(true);
		questDescriptionArea.setWrapStyleWord(true);
		questDescriptionArea.setEditable(false);
		
		JLabel lblQuest = new JLabel("Quest:");
		lblQuest.setBounds(12, 13, 126, 14);
		frmQuestBoard.getContentPane().add(lblQuest);
		
		if (!questTitle[0].equals("")) {
			JButton quest1 = new JButton("<p>" + questTitle[0]);
			quest1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								//moving windows
								if (!questTitle[0].equals("")) {
									questDescriptionArea.setText(questMessage[0]);
								}
							} 
							catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			});
			quest1.setBounds(12, 36, 191, 64);
			frmQuestBoard.getContentPane().add(quest1);
		}
		
		if (!questTitle[1].equals("")) {
			JButton quest2 = new JButton("<p>" + questTitle[1]);
			quest2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								//moving windows
								if (!questTitle[1].equals("")) {
									questDescriptionArea.setText(questMessage[1]);
								}
							} 
							catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			});
			quest2.setBounds(12, 36, 191, 64);
			frmQuestBoard.getContentPane().add(quest2);
		}
		
		if (!questTitle[2].equals("")) {
			JButton quest3 = new JButton("<p>" + questTitle[2]);
			quest3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								//moving windows
								if (!questTitle[2].equals("")) {
									questDescriptionArea.setText(questMessage[3]);
								}
							} 
							catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			});
			quest3.setBounds(12, 36, 191, 64);
			frmQuestBoard.getContentPane().add(quest3);
		}
		
		if (!questTitle[3].equals("")) {
			JButton quest4 = new JButton("<p>" + questTitle[3]);
			quest4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								//moving windows
								if (!questTitle[3].equals("")) {
									questDescriptionArea.setText(questMessage[3]);
								}
							} 
							catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			});
			quest4.setBounds(12, 36, 191, 64);
			frmQuestBoard.getContentPane().add(quest4);
		}
		
		if (!questTitle[4].equals("")) {
			JButton quest5 = new JButton("<p>" + questTitle[4]);
			quest5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								//moving windows
								if (!questTitle[4].equals("")) {
									questDescriptionArea.setText(questMessage[4]);
								}
							} 
							catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			});
			quest5.setBounds(12, 36, 191, 64);
			frmQuestBoard.getContentPane().add(quest5);
		}
	}
}
