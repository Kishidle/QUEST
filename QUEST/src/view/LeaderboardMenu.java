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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import model.User;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LeaderboardMenu {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//LeaderboardMenu window = new LeaderboardMenu();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public LeaderboardMenu(User user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User user) {
		int bottom = 0;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblLeaderboards = new JLabel(new ImageIcon(getClass().getResource("/img/leaderboardstitle.png")));
		lblLeaderboards.setBounds(30, 15, 394, 35);
		panel.add(lblLeaderboards);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, '1'},
				{null, '2'},
				{null, '3'},
				{null, '4'},
				{null, '5'},
			},
			new String[] {
				"Name", "Ranking"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.setBounds(10, 61, 414, 100);
		table.setRowHeight(20);
		try {
			Connection conn = null;
			Statement stmt = null;

			try {
				Class.forName("com.mysql.jdbc.Driver");	        

				conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/quest", "user", "");	
				stmt = (Statement) conn.createStatement();

				String query = "SELECT * FROM users " +
						"WHERE U_Pts <= (SELECT U_Pts FROM users WHERE U_Usn ='" + user.getUsername() + "') AND U_Usn != '" + user.getUsername() + "' " +
						"ORDER BY U_Pts ASC " +
						"LIMIT 2";

				ResultSet rs = stmt.executeQuery(query);
				
				if (rs.next()) {
					int rows = rs.getInt(1); 
					String u1 = rs.getString("U_Usn");
					table.getModel().setValueAt(u1, 3, 0);
					bottom++;
					if (rs.next()) {
						String u2 = rs.getString("U_Usn");
						table.getModel().setValueAt(u2, 4, 0);
						bottom++;
					}
				} 
			} 
			catch(Exception a) {
				System.out.println(a.getMessage());	    	
				JOptionPane.showMessageDialog(null, "A database error has occured.");
			}
			if (bottom == 2) {
				table.getModel().setValueAt(user.getUsername(), 2, 0);
			}
			else if (bottom == 1) {
				table.getModel().setValueAt(user.getUsername(), 3, 0);
			}
			else {
				table.getModel().setValueAt(user.getUsername(), 4, 0);
			}
			try {
				Class.forName("com.mysql.jdbc.Driver");	        

				conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/quest", "user", "");	
				stmt = (Statement) conn.createStatement();
				
				String query;
				
				if (bottom == 2) {
					query = "SELECT * FROM users " +
							"WHERE U_Pts >= (SELECT U_Pts FROM users WHERE U_Usn ='" + user.getUsername() + "') AND U_Usn != '" + user.getUsername() + "' " +
							"ORDER BY U_Pts ASC " +
							"LIMIT 2";
				}
				else if (bottom == 1) {
					query = "SELECT * FROM users " +
							"WHERE U_Pts >= (SELECT U_Pts FROM users WHERE U_Usn ='" + user.getUsername() + "') AND U_Usn != '" + user.getUsername() + "' " +
							"ORDER BY U_Pts ASC " +
							"LIMIT 3";
				}
				else {
					query = "SELECT * FROM users " +
							"WHERE U_Pts >= (SELECT U_Pts FROM users WHERE U_Usn ='" + user.getUsername() + "') AND U_Usn != '" + user.getUsername() + "' " +
							"ORDER BY U_Pts ASC " +
							"LIMIT 4";
				}
				ResultSet rs = stmt.executeQuery(query);
				
				if (rs.next()) {
					if (bottom == 2) {
						int rows = rs.getInt(1); 
						String u3 = rs.getString("U_Usn");
						table.getModel().setValueAt(u3, 1, 0);
						if (rs.next()) {
							String u4 = rs.getString("U_Usn");
							table.getModel().setValueAt(u4, 0, 0);
						}
					}
					else if (bottom == 1) {
						int rows = rs.getInt(1); 
						String u3 = rs.getString("U_Usn");
						table.getModel().setValueAt(u3, 2, 0);
						if (rs.next()) {
							String u4 = rs.getString("U_Usn");
							table.getModel().setValueAt(u4, 1, 0);
							if (rs.next()) {
								String u5 = rs.getString("U_Usn");
								table.getModel().setValueAt(u5, 0, 0);
							}
						}
					}
					else {
						int rows = rs.getInt(1); 
						String u3 = rs.getString("U_Usn");
						table.getModel().setValueAt(u3, 3, 0);
						if (rs.next()) {
							String u4 = rs.getString("U_Usn");
							table.getModel().setValueAt(u4, 2, 0);
							if (rs.next()) {
								String u5 = rs.getString("U_Usn");
								table.getModel().setValueAt(u5, 1, 0);
								if (rs.next()) {
									String u6 = rs.getString("U_Usn");
									table.getModel().setValueAt(u6, 0, 0);
								}
							}
						}
					}
				} 
			} 
			catch(Exception a) {
				System.out.println(a.getMessage());	    	
				JOptionPane.showMessageDialog(null, "A database error has occured.");
			}	
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		panel.add(table);
		
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
		btnConfirm.setBounds(335, 227, 89, 23);
		panel.add(btnConfirm);
	}
}
