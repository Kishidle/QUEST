package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import api.component.PCompiler;
import controller.ErrorPolling;
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
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	private String fp = "";
	
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
		setBounds(100, 100, 705, 760);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JButton bRandomTest = new JButton("");
		bRandomTest.setIcon(new ImageIcon(MainMenu.class.getResource("/boss-transparent-small.png")));
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
				try {
					//moving windows
					fp = JOptionPane.showInputDialog("Please input the source code location");
					if ((fp == null) || (fp.length() < 0) || !(new File(fp).exists())) {
						JOptionPane.showMessageDialog(null, "The source code does not exist!");
					}
					else {
						QuestMenu Qframe = new QuestMenu(user, fp);
						//tframe.initialize(user);
						dispose();
					}
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		bQuests.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton bLeaderboards = new JButton("");
		bLeaderboards.setIcon(new ImageIcon(MainMenu.class.getResource("/rank-transparent-small.png")));
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
		
		JButton bBadge = new JButton("");
		bBadge.setIcon(new ImageIcon(MainMenu.class.getResource("/badges-transparent-small.png")));
		bBadge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					BadgesMenuAgain badgeFrame = new BadgesMenuAgain(user);
					dispose();
					
				}
				catch(Exception x){
					x.printStackTrace();
				}
			}
		});
		bBadge.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(MainMenu.class.getResource("/compile-transparent-small.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					PCompiler cmp = new PCompiler();
					fp = JOptionPane.showInputDialog("Please input the source code location");
					if ((fp == null) || (fp.length() < 0) || !(new File(fp).exists())) {
						JOptionPane.showMessageDialog(null, "The source code does not exist!");
					}
					else {
						Path filePath = Paths.get(fp);
						String log = cmp.compileRun(filePath);
						ErrorPolling ep = new ErrorPolling(log, user, fp);
						//System.out.println(log);
					}
					
				}
				catch(Exception x){
					x.printStackTrace();
				}
			}
		});
		
		JLabel titleLabel = new JLabel("");
		titleLabel.setIcon(new ImageIcon(MainMenu.class.getResource("/title-transparent-small.png")));
		
		String userName = user.getUsername();
		JLabel lblName = new JLabel("Name: " + user.getUsername());
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		String userLvl = Integer.toString(user.getPoints() / 100);
		JLabel lblLevel = new JLabel("Level: " + (user.getPoints() / 100) + 1);
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		String userPts = Integer.toString(user.getPoints());
		JLabel lblPts = new JLabel("Pts: " + user.getPoints()%100 + " / 100");
		lblPts.setFont(new Font("Tahoma", Font.PLAIN, 26));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblName)
								.addComponent(lblLevel)
								.addComponent(lblPts)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(218)
							.addComponent(titleLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(bQuests, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(bBadge, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(bLeaderboards, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(bRandomTest, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)))
					.addGap(18))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(203)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
					.addGap(209))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(titleLabel)
					.addGap(18)
					.addComponent(lblName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblLevel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPts)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(bRandomTest, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
						.addComponent(bQuests, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(bLeaderboards, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
						.addComponent(bBadge, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
					.addGap(37))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
