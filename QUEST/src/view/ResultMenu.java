package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import model.Answer;
import model.Test;
import model.User;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class ResultMenu {

	private JFrame frame;

	
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
	public ResultMenu(User user, Test test, Answer answer) {
		initialize(user, test, answer);
	}


	@SuppressWarnings("null")
	public void initialize(User user, Test test, Answer answer) {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 554);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle(test.getTitle());
		frame.setVisible(true);

		JLabel lblDescription = new JLabel("Description: ");
		lblDescription.setBounds(10, 11, 126, 14);
		frame.getContentPane().add(lblDescription);

		JLabel lblVerdict = new JLabel("Verdict");
		lblVerdict.setBounds(10, 309, 46, 14);
		frame.getContentPane().add(lblVerdict);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							//moving windows
							MainMenu mm = new MainMenu(user);
							mm.initialize(user);
							frame.dispose();
						} 
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnConfirm.setBounds(335, 481, 89, 23);
		frame.getContentPane().add(btnConfirm);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 141, 414, 157);
		frame.getContentPane().add(scrollPane);

		JTextArea txtrCodeArea = new JTextArea();
		txtrCodeArea.setText(test.getFullAnswer());
		scrollPane.setViewportView(txtrCodeArea);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 334, 414, 120);
		frame.getContentPane().add(scrollPane_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 36, 414, 94);
		frame.getContentPane().add(scrollPane_2);
		
		JTextArea txtrDescriptionArea = new JTextArea();
		txtrDescriptionArea.setText("description area");
		scrollPane_2.setViewportView(txtrDescriptionArea);

		if (answer.getAnswer() == test.getAnswer()) {
			JTextArea txtrVerdictArea = new JTextArea();
			txtrVerdictArea.setText(test.getCorrect());
			scrollPane_1.setViewportView(txtrVerdictArea);
		}
		else {
			JTextArea txtrVerdictArea = new JTextArea();
			txtrVerdictArea.setText(test.getIncorrect());
			scrollPane_1.setViewportView(txtrVerdictArea);
		}
	}
}
