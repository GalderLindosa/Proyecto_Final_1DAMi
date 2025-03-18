package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class SignInClient extends JFrame {

	private JPanel contentPane;
	private JTextField IDField;
	private JTextField PasswordField;


	public SignInClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel SignInLabel = new JLabel("Sign In");
		SignInLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SignInLabel.setBounds(132, 22, 163, 28);
		contentPane.add(SignInLabel);
		
		JLabel WriteIDLabel = new JLabel("Introduce your client ID");
		WriteIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		WriteIDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		WriteIDLabel.setBounds(132, 60, 176, 32);
		contentPane.add(WriteIDLabel);
		
		JLabel WritePasswordLabel = new JLabel("Introduce your password");
		WritePasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		WritePasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		WritePasswordLabel.setBounds(113, 142, 217, 32);
		contentPane.add(WritePasswordLabel);
		
		IDField = new JTextField();
		IDField.setBounds(162, 112, 96, 19);
		contentPane.add(IDField);
		IDField.setColumns(10);
		
		PasswordField = new JTextField();
		PasswordField.setBounds(162, 184, 96, 19);
		contentPane.add(PasswordField);
		PasswordField.setColumns(10);
		
		JButton SignInClient = new JButton("Sign In");
		SignInClient.setBounds(172, 232, 85, 21);
		contentPane.add(SignInClient);
	}

}
