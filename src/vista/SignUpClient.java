package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controlador.LoginControlador;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Client;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;

public class SignUpClient extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField introduceNameTextField;
	private JPasswordField IntroducePasswordTextField;
	private JLabel SignUpWelcome;
	private JLabel NameLabel;
	private JLabel PasswordLabel;
	private JButton CompleteSIgnUpButton;
	private LoginControlador cont;
	private JLabel CreatedUserLabel;
	private JLabel lblNewLabel;

	public SignUpClient(LoginControlador cont) {
		setTitle("Client Sign Up");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignUpClient.class.getResource("/images/media-markt-1.png")));
		
		this.cont=cont;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBorder(new LineBorder(new Color(189, 0, 0), 15));


		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		SignUpWelcome = new JLabel("Welcome to the sign up window");
		SignUpWelcome.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
		SignUpWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		SignUpWelcome.setBounds(51, 24, 264, 34);
		contentPane.add(SignUpWelcome);
		
		NameLabel = new JLabel("Introduce your name");
		NameLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
		NameLabel.setBounds(110, 68, 153, 19);
		contentPane.add(NameLabel);
		
		introduceNameTextField = new JTextField();
		introduceNameTextField.setBounds(110, 97, 153, 21);
		contentPane.add(introduceNameTextField);
		introduceNameTextField.setColumns(10);
		
		PasswordLabel = new JLabel("Introduce your passoword");
		PasswordLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
		PasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PasswordLabel.setBounds(101, 128, 185, 34);
		contentPane.add(PasswordLabel);
		
		IntroducePasswordTextField = new JPasswordField();
		IntroducePasswordTextField.setBounds(110, 167, 158, 21);
		contentPane.add(IntroducePasswordTextField);
		
		CompleteSIgnUpButton = new JButton("Complete");
		CompleteSIgnUpButton.setBackground(new Color(255, 0, 0));
		CompleteSIgnUpButton.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
		CompleteSIgnUpButton.setBounds(110, 213, 158, 21);
		contentPane.add(CompleteSIgnUpButton);
		CompleteSIgnUpButton.addActionListener(this);
		
		CreatedUserLabel = new JLabel("");
		CreatedUserLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 13));
		CreatedUserLabel.setHorizontalAlignment(SwingConstants.CENTER);
		CreatedUserLabel.setBounds(10, 270, 354, 34);
		contentPane.add(CreatedUserLabel);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SignUpClient.class.getResource("/images/Cliente1.png")));
		lblNewLabel.setBounds(10, 185, 131, 107);
		contentPane.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==CompleteSIgnUpButton) {
			if(cont.insertClient(new Client(introduceNameTextField.getText(), new String(IntroducePasswordTextField.getPassword())))) {
				ClientOptions v= new ClientOptions(cont);
				v.setVisible(true);
			}
			else {
				CreatedUserLabel.setText("ERROR, NO SE HA PODIDO CREAR EL USUARIO");
			}
		}
	}
}
