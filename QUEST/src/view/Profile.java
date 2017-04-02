package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Profile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile();
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
	public Profile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTest = new JLabel("");
		lblTest.setOpaque(true);
		lblTest.setForeground(Color.BLACK);
		lblTest.setBackground(Color.WHITE);
		lblTest.setBounds(10, 22, 114, 99);
		contentPane.add(lblTest);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(153, 22, 66, 14);
		contentPane.add(lblUsername);
		
		JTextPane userNameTextPane = new JTextPane();
		userNameTextPane.setBounds(218, 22, 149, 14);
		contentPane.add(userNameTextPane);
		
		JLabel lblBadgesCollected = new JLabel("Badges Collected:");
		lblBadgesCollected.setBounds(153, 47, 95, 14);
		contentPane.add(lblBadgesCollected);
		
		JTextPane badgesCollectedTextPane = new JTextPane();
		badgesCollectedTextPane.setBounds(249, 47, 58, 14);
		contentPane.add(badgesCollectedTextPane);
		
		JLabel levelLabel = new JLabel("Level:");
		levelLabel.setBounds(153, 72, 46, 14);
		contentPane.add(levelLabel);
		
		JLabel levelNumberLabel = new JLabel("");
		levelNumberLabel.setBounds(187, 72, 46, 14);
		contentPane.add(levelNumberLabel);
		
		JLabel lblExpTillNext = new JLabel("EXP till next level:");
		lblExpTillNext.setBounds(153, 97, 107, 14);
		contentPane.add(lblExpTillNext);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(249, 97, 58, 14);
		contentPane.add(textPane);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(284, 188, 89, 23);
		contentPane.add(btnBack);
	}
}
