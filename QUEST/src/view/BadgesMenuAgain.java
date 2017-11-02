package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import model.Badges;
import model.User;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.*;
import javax.swing.LayoutStyle.ComponentPlacement;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BadgesMenuAgain {

	private JFrame frame;
	private User user;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//BadgesMenuAgain window = new BadgesMenuAgain();
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
	public BadgesMenuAgain(User user) {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMenu mainFrame = new MainMenu(user);
				mainFrame.setVisible(true);
				frame.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
						.addComponent(btnNewButton))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		
		JLabel lblBadges = new JLabel("Badges");
		lblBadges.setFont(new Font("Tahoma", Font.PLAIN, 34));
		panel.add(lblBadges);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		ArrayList<Badges> badgeList = new ArrayList<>();
		JButton[] btnArr = new JButton[24];
				
		try {
			System.out.print("test");
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quest", "root", "password");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT A_num, A_Ttl, A_Msg, A_Bdg FROM achievements where A_Num != 0 AND A_Bdg != 0");
			while(rs.next()){
				Badges bdg = new Badges();
				bdg.setBadgeNum(rs.getInt("A_num"));
				bdg.setBadgeTitle(rs.getString("A_Ttl"));
				bdg.setBadgeDisc(rs.getString("A_Msg"));
				bdg.setBadgeType(rs.getInt("A_bdg"));
				bdg.setBadgeIcon("res/no-badge.png");
				badgeList.add(bdg);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i < btnArr.length; i++){
			
			btnArr[i] = new JButton(new ImageIcon(getClass().getResource("/img/no-badge.png")));
			btnArr[i].setToolTipText(badgeList.get(i).getBadgeTitle() + ": " + badgeList.get(i).getBadgeDisc());
			panel_1.add(btnArr[i]);
		}
		
		frame.getContentPane().setLayout(groupLayout);
	}
}
