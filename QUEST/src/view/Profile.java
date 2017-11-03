package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import model.User;
import view.Login;
import view.MainMenu;

public class Profile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Profile frame = new Profile();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Profile(User user) {
		initialize(user);
	}

	public void initialize(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTest = new JLabel("");
		lblTest.setOpaque(true);
		lblTest.setForeground(Color.BLACK);
		lblTest.setBackground(Color.WHITE);
		lblTest.setBounds(10, 110, 114, 99);
		contentPane.add(lblTest);

		JLabel lblUsername = new JLabel("Username: " + user.getUsername());
		lblUsername.setBounds(153, 120, 200, 14);
		contentPane.add(lblUsername);

		//		JTextPane userNameTextPane = new JTextPane();
		//		userNameTextPane.setBounds(218, 22, 149, 14);
		//		contentPane.add(userNameTextPane);

		JLabel lblBadgesCollected = new JLabel("Badges Collected: " + user.getAchievements());
		lblBadgesCollected.setBounds(153, 145, 200, 14);
		contentPane.add(lblBadgesCollected);

		//		JTextPane badgesCollectedTextPane = new JTextPane();
		//		badgesCollectedTextPane.setBounds(249, 47, 58, 14);
		//		contentPane.add(badgesCollectedTextPane);

		JLabel levelLabel = new JLabel("Level: " + (user.getPoints()/100));
		levelLabel.setBounds(153, 170, 200, 14);
		contentPane.add(levelLabel);

		//		JLabel levelNumberLabel = new JLabel("");
		//		levelNumberLabel.setBounds(187, 72, 46, 14);
		//		contentPane.add(levelNumberLabel);

		JLabel lblExpTillNext = new JLabel("EXP till next level: " + (user.getPoints()%100));
		lblExpTillNext.setBounds(153, 195, 200, 14);
		contentPane.add(lblExpTillNext);

		//		JTextPane textPane = new JTextPane();
		//		textPane.setBounds(249, 97, 58, 14);
		//		contentPane.add(textPane);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							//moving windows
							MainMenu mframe = new MainMenu(user);
							mframe.setVisible(true);
							dispose();
						} 
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		btnBack.setBounds(284, 288, 89, 23);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel(new ImageIcon(getClass().getResource("/img/profiletitle.png")));
		label.setBounds(10, 43, 46, 14);
		contentPane.add(label);

	}
}
