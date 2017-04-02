package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * The Login Screen of the program.
 * @author Darren Garcia
 */
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField fNum;
	private JTextField fPassword;
	private JLabel lLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lNum = new JLabel("ID Number");

		fNum = new JTextField();
		fNum.setToolTipText("Input your ID here!");
		fNum.setColumns(10);

		JLabel lPassword = new JLabel("Password");

		fPassword = new JTextField();
		fPassword.setColumns(10);

		lLogin = new JLabel("QUEST - Login");
		lLogin.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JButton btnConfirm = new JButton("Confirm");
		
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								String username = fNum.getText();
								String password = fPassword.getText();

								Connection conn = null;
								Statement stmt = null;

								try {
									Class.forName("com.mysql.jdbc.Driver");	        

									conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/quest", "root", "");	
									stmt = (Statement) conn.createStatement();

									String query = "SELECT * FROM users " +
											"WHERE U_Usn ='" + username + "' AND U_Pas ='" + password + "'";

									ResultSet rs = stmt.executeQuery(query);

									if (rs.next()) {
										int rows = rs.getInt(1); 
										String u = rs.getString("U_Usn");
										String p = rs.getString("U_Pas");
										int ac = rs.getInt("U_Ach");
										int pt = rs.getInt("U_Pts");

										/** set setters
										User.setUsername(u);
										User.setPassword(p);
										User.setAchievements(ac);
										User.setPoints(pt);
										**/
										
										//moving windows
										Login lframe = new Login();
										lframe.setVisible(false);
										MainMenu frame = new MainMenu();
										frame.setVisible(true);
									} 
									else {
										JOptionPane.showMessageDialog(null, "Incorrect Username and/or Password!");
									}
								} 
								catch(Exception a) {
									System.out.println(a.getMessage());	    	
									JOptionPane.showMessageDialog(null, "A login error has occured.");
								}		
								
							} 
							catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
						.addContainerGap(76, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lNum)
												.addComponent(lPassword))
										.addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(fPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(fNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(17)
										.addComponent(lLogin))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(55)
										.addComponent(btnConfirm)))
						.addGap(73))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(22)
						.addComponent(lLogin)
						.addGap(34)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lNum)
								.addComponent(fNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lPassword)
								.addComponent(fPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(40)
						.addComponent(btnConfirm)
						.addContainerGap(23, Short.MAX_VALUE))
				);
		contentPane.setLayout(gl_contentPane);
	}

	class ButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();  
			if(command.equals("Confirm")) {
				JOptionPane.showMessageDialog(null, "hi");
						
			}
		}	
	}

}
