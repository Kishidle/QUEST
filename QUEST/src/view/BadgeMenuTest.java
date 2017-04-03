package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

import model.User;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BadgeMenuTest {

	private JFrame frame;
	private User user;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//BadgeMenuTest window = new BadgeMenuTest(user);
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
	public BadgeMenuTest(User user) {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 496, 362);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblBadges = new JLabel("Badges");
		lblBadges.setBounds(10, 11, 46, 14);
		panel.add(lblBadges);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 36, 460, 244);
		panel.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnBadge = new JButton("Badge 01");
		btnBadge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnBadge = new GridBagConstraints();
		gbc_btnBadge.insets = new Insets(0, 0, 5, 5);
		gbc_btnBadge.gridx = 0;
		gbc_btnBadge.gridy = 0;
		panel_1.add(btnBadge, gbc_btnBadge);
		
		JButton btnBadge_1 = new JButton("Badge 02");
		GridBagConstraints gbc_btnBadge_1 = new GridBagConstraints();
		gbc_btnBadge_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnBadge_1.gridx = 1;
		gbc_btnBadge_1.gridy = 0;
		panel_1.add(btnBadge_1, gbc_btnBadge_1);
		
		JButton btnBadge_2 = new JButton("Badge 03");
		btnBadge_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnBadge_2 = new GridBagConstraints();
		gbc_btnBadge_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnBadge_2.gridx = 2;
		gbc_btnBadge_2.gridy = 0;
		panel_1.add(btnBadge_2, gbc_btnBadge_2);
		
		JButton btnBadge_3 = new JButton("Badge 04");
		GridBagConstraints gbc_btnBadge_3 = new GridBagConstraints();
		gbc_btnBadge_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnBadge_3.gridx = 3;
		gbc_btnBadge_3.gridy = 0;
		panel_1.add(btnBadge_3, gbc_btnBadge_3);
		
		JButton btnBadge_4 = new JButton("Badge 05");
		GridBagConstraints gbc_btnBadge_4 = new GridBagConstraints();
		gbc_btnBadge_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnBadge_4.gridx = 4;
		gbc_btnBadge_4.gridy = 0;
		panel_1.add(btnBadge_4, gbc_btnBadge_4);
		
		JButton btnBadge_5 = new JButton("Badge 06");
		GridBagConstraints gbc_btnBadge_5 = new GridBagConstraints();
		gbc_btnBadge_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnBadge_5.gridx = 0;
		gbc_btnBadge_5.gridy = 1;
		panel_1.add(btnBadge_5, gbc_btnBadge_5);
		
		JButton btnBadge_6 = new JButton("Badge 07");
		GridBagConstraints gbc_btnBadge_6 = new GridBagConstraints();
		gbc_btnBadge_6.insets = new Insets(0, 0, 5, 5);
		gbc_btnBadge_6.gridx = 1;
		gbc_btnBadge_6.gridy = 1;
		panel_1.add(btnBadge_6, gbc_btnBadge_6);
		
		JButton btnBadge_7 = new JButton("Badge 08");
		GridBagConstraints gbc_btnBadge_7 = new GridBagConstraints();
		gbc_btnBadge_7.insets = new Insets(0, 0, 5, 5);
		gbc_btnBadge_7.gridx = 2;
		gbc_btnBadge_7.gridy = 1;
		panel_1.add(btnBadge_7, gbc_btnBadge_7);
		
		JButton btnBadge_8 = new JButton("Badge 09");
		GridBagConstraints gbc_btnBadge_8 = new GridBagConstraints();
		gbc_btnBadge_8.insets = new Insets(0, 0, 5, 5);
		gbc_btnBadge_8.gridx = 3;
		gbc_btnBadge_8.gridy = 1;
		panel_1.add(btnBadge_8, gbc_btnBadge_8);
		
		JButton btnBadge_9 = new JButton("Badge 10");
		GridBagConstraints gbc_btnBadge_9 = new GridBagConstraints();
		gbc_btnBadge_9.insets = new Insets(0, 0, 5, 0);
		gbc_btnBadge_9.gridx = 4;
		gbc_btnBadge_9.gridy = 1;
		panel_1.add(btnBadge_9, gbc_btnBadge_9);
		
		JButton btnBadge_10 = new JButton("Badge 11");
		GridBagConstraints gbc_btnBadge_10 = new GridBagConstraints();
		gbc_btnBadge_10.insets = new Insets(0, 0, 5, 5);
		gbc_btnBadge_10.gridx = 0;
		gbc_btnBadge_10.gridy = 2;
		panel_1.add(btnBadge_10, gbc_btnBadge_10);
		
		JButton btnBadge_11 = new JButton("Badge 12");
		GridBagConstraints gbc_btnBadge_11 = new GridBagConstraints();
		gbc_btnBadge_11.insets = new Insets(0, 0, 5, 5);
		gbc_btnBadge_11.gridx = 1;
		gbc_btnBadge_11.gridy = 2;
		panel_1.add(btnBadge_11, gbc_btnBadge_11);
		
		JButton btnBadge_12 = new JButton("Badge 13");
		GridBagConstraints gbc_btnBadge_12 = new GridBagConstraints();
		gbc_btnBadge_12.insets = new Insets(0, 0, 5, 5);
		gbc_btnBadge_12.gridx = 2;
		gbc_btnBadge_12.gridy = 2;
		panel_1.add(btnBadge_12, gbc_btnBadge_12);
		
		JButton btnBadge_13 = new JButton("Badge 14");
		GridBagConstraints gbc_btnBadge_13 = new GridBagConstraints();
		gbc_btnBadge_13.insets = new Insets(0, 0, 5, 5);
		gbc_btnBadge_13.gridx = 3;
		gbc_btnBadge_13.gridy = 2;
		panel_1.add(btnBadge_13, gbc_btnBadge_13);
		
		JButton btnBadge_14 = new JButton("Badge 15");
		GridBagConstraints gbc_btnBadge_14 = new GridBagConstraints();
		gbc_btnBadge_14.insets = new Insets(0, 0, 5, 0);
		gbc_btnBadge_14.gridx = 4;
		gbc_btnBadge_14.gridy = 2;
		panel_1.add(btnBadge_14, gbc_btnBadge_14);
		
		JButton btnBadge_15 = new JButton("Badge 16");
		GridBagConstraints gbc_btnBadge_15 = new GridBagConstraints();
		gbc_btnBadge_15.insets = new Insets(0, 0, 5, 5);
		gbc_btnBadge_15.gridx = 0;
		gbc_btnBadge_15.gridy = 3;
		panel_1.add(btnBadge_15, gbc_btnBadge_15);
		
		JButton btnBadge_16 = new JButton("Badge 17");
		GridBagConstraints gbc_btnBadge_16 = new GridBagConstraints();
		gbc_btnBadge_16.insets = new Insets(0, 0, 5, 5);
		gbc_btnBadge_16.gridx = 1;
		gbc_btnBadge_16.gridy = 3;
		panel_1.add(btnBadge_16, gbc_btnBadge_16);
		
		JButton btnBadge_17 = new JButton("Badge 18");
		GridBagConstraints gbc_btnBadge_17 = new GridBagConstraints();
		gbc_btnBadge_17.insets = new Insets(0, 0, 5, 5);
		gbc_btnBadge_17.gridx = 2;
		gbc_btnBadge_17.gridy = 3;
		panel_1.add(btnBadge_17, gbc_btnBadge_17);
		
		JButton btnBadge_18 = new JButton("Badge 19");
		GridBagConstraints gbc_btnBadge_18 = new GridBagConstraints();
		gbc_btnBadge_18.insets = new Insets(0, 0, 5, 5);
		gbc_btnBadge_18.gridx = 3;
		gbc_btnBadge_18.gridy = 3;
		panel_1.add(btnBadge_18, gbc_btnBadge_18);
		
		JButton btnBadge_19 = new JButton("Badge 20");
		GridBagConstraints gbc_btnBadge_19 = new GridBagConstraints();
		gbc_btnBadge_19.insets = new Insets(0, 0, 5, 0);
		gbc_btnBadge_19.gridx = 4;
		gbc_btnBadge_19.gridy = 3;
		panel_1.add(btnBadge_19, gbc_btnBadge_19);
		
		JButton btnBadge_20 = new JButton("Badge 21");
		GridBagConstraints gbc_btnBadge_20 = new GridBagConstraints();
		gbc_btnBadge_20.insets = new Insets(0, 0, 5, 5);
		gbc_btnBadge_20.gridx = 0;
		gbc_btnBadge_20.gridy = 4;
		panel_1.add(btnBadge_20, gbc_btnBadge_20);
		
		JButton btnBadge_21 = new JButton("Badge 22");
		GridBagConstraints gbc_btnBadge_21 = new GridBagConstraints();
		gbc_btnBadge_21.insets = new Insets(0, 0, 5, 5);
		gbc_btnBadge_21.gridx = 1;
		gbc_btnBadge_21.gridy = 4;
		panel_1.add(btnBadge_21, gbc_btnBadge_21);
		
		JButton btnBadge_22 = new JButton("Badge 23");
		GridBagConstraints gbc_btnBadge_22 = new GridBagConstraints();
		gbc_btnBadge_22.insets = new Insets(0, 0, 5, 5);
		gbc_btnBadge_22.gridx = 2;
		gbc_btnBadge_22.gridy = 4;
		panel_1.add(btnBadge_22, gbc_btnBadge_22);
		
		JButton btnBadge_23 = new JButton("Badge 24");
		GridBagConstraints gbc_btnBadge_23 = new GridBagConstraints();
		gbc_btnBadge_23.insets = new Insets(0, 0, 5, 5);
		gbc_btnBadge_23.gridx = 3;
		gbc_btnBadge_23.gridy = 4;
		panel_1.add(btnBadge_23, gbc_btnBadge_23);
		
		JButton btnBadge_24 = new JButton("Badge 25");
		GridBagConstraints gbc_btnBadge_24 = new GridBagConstraints();
		gbc_btnBadge_24.insets = new Insets(0, 0, 5, 0);
		gbc_btnBadge_24.gridx = 4;
		gbc_btnBadge_24.gridy = 4;
		panel_1.add(btnBadge_24, gbc_btnBadge_24);
		
		JButton btnBadge_25 = new JButton("Badge 26");
		GridBagConstraints gbc_btnBadge_25 = new GridBagConstraints();
		gbc_btnBadge_25.insets = new Insets(0, 0, 0, 5);
		gbc_btnBadge_25.gridx = 2;
		gbc_btnBadge_25.gridy = 5;
		panel_1.add(btnBadge_25, gbc_btnBadge_25);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(381, 291, 89, 23);
		panel.add(btnConfirm);
	}
}
