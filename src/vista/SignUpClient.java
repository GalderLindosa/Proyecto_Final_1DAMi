package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Toolkit;

public class SignUpClient extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField introduceNameTextField;
	private JPasswordField IntroducePasswordTextField;
	private JLabel SignUpWelcome;
	private JLabel NameLabel;
	private JLabel PasswordLabel;
	private JButton CompleteSIgnUpButton;

	public SignUpClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		SignUpWelcome = new JLabel("Welcome to the sign up window");
		SignUpWelcome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SignUpWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		SignUpWelcome.setBounds(141, 29, 264, 31);
		contentPane.add(SignUpWelcome);
		
		NameLabel = new JLabel("Introduce your name");
		NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		NameLabel.setBounds(212, 90, 153, 19);
		contentPane.add(NameLabel);
		
		introduceNameTextField = new JTextField();
		introduceNameTextField.setBounds(198, 137, 153, 21);
		contentPane.add(introduceNameTextField);
		introduceNameTextField.setColumns(10);
		
		PasswordLabel = new JLabel("Introduce your passoword");
		PasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PasswordLabel.setBounds(193, 177, 185, 50);
		contentPane.add(PasswordLabel);
		
		IntroducePasswordTextField = new JPasswordField();
		IntroducePasswordTextField.setBounds(193, 249, 185, 31);
		contentPane.add(IntroducePasswordTextField);
		
		CompleteSIgnUpButton = new JButton("Complete");
		CompleteSIgnUpButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CompleteSIgnUpButton.setBounds(209, 331, 156, 21);
		contentPane.add(CompleteSIgnUpButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
