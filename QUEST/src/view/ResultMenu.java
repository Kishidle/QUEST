package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class ResultMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultMenu window = new ResultMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResultMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 389);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(10, 11, 64, 14);
		frame.getContentPane().add(lblDescription);
		
		JLabel lblVerdict = new JLabel("Verdict");
		lblVerdict.setBounds(10, 270, 46, 14);
		frame.getContentPane().add(lblVerdict);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(335, 317, 89, 23);
		frame.getContentPane().add(btnConfirm);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 89, 414, 157);
		frame.getContentPane().add(scrollPane);
		
		JTextArea txtrCodeArea = new JTextArea();
		txtrCodeArea.setText("code area");
		scrollPane.setViewportView(txtrCodeArea);
	}
}
