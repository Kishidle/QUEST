package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.User;

import java.awt.Window.Type;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//MainMenu frame = new MainMenu(User user);
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
	public MainMenu(User user) {
		initialize(user);
	}
	
	public void initialize(User user) {
		setTitle("Main Menu");
		
		//JOptionPane.showMessageDialog(null, u + " " + p + " " + ac + " " + pt);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 705);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JButton bRandomTest = new JButton("Test");
		bRandomTest.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bRandomTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//moving windows
					TestMenu tframe = new TestMenu(user);
					//tframe.initialize(user);
					dispose();
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		JButton bQuests = new JButton("");
		bQuests.setIcon(new ImageIcon(MainMenu.class.getResource("/quest-transparent-small.png")));
		bQuests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		bQuests.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton bLeaderboards = new JButton("Rank");
		bLeaderboards.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bLeaderboards.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//moving windows
					LeaderboardMenu Lframe = new LeaderboardMenu(user);
					//tframe.initialize(user);
					dispose();
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		JLabel lMessage = new JLabel("What is your quest for today?");
		lMessage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton bBadge = new JButton("Badges");
		bBadge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					BadgeMenuTest badgeFrame = new BadgeMenuTest(user);
					dispose();
				}
				catch(Exception x){
					x.printStackTrace();
				}
			}
		});
		bBadge.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(bQuests, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
										.addGap(126))
									.addComponent(lMessage, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))
								.addContainerGap())
							.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addComponent(bLeaderboards, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addGap(28)
								.addComponent(bBadge, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addGap(35)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(bRandomTest, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addGap(48))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addComponent(lMessage)
					.addGap(26)
					.addComponent(bQuests, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(237)
							.addComponent(bLeaderboards, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addGap(103))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(bRandomTest, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(bBadge, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addGap(134))))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
