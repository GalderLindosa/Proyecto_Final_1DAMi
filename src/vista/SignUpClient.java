package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class SignUpClient extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField introduceNameTextField;
	private JPasswordField IntroducePasswordTextField;
	private JLabel SignUpWelcome;
	private JLabel NameLabel;
	private JLabel PasswordLabel;
	private JButton CompleteSIgnUpButton;
	private LoginControlador cont;
	private JLabel creado;

	public SignUpClient(LoginControlador cont) {
		
		this.cont=cont;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		SignUpWelcome = new JLabel("Welcome to the sign up window");
		SignUpWelcome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SignUpWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		SignUpWelcome.setBounds(66, 10, 264, 34);
		contentPane.add(SignUpWelcome);
		
		NameLabel = new JLabel("Introduce your name");
		NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		NameLabel.setBounds(121, 68, 153, 19);
		contentPane.add(NameLabel);
		
		introduceNameTextField = new JTextField();
		introduceNameTextField.setBounds(121, 115, 153, 21);
		contentPane.add(introduceNameTextField);
		introduceNameTextField.setColumns(10);
		
		PasswordLabel = new JLabel("Introduce your passoword");
		PasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PasswordLabel.setBounds(103, 146, 185, 34);
		contentPane.add(PasswordLabel);
		
		IntroducePasswordTextField = new JPasswordField();
		IntroducePasswordTextField.setBounds(116, 190, 158, 21);
		contentPane.add(IntroducePasswordTextField);
		
		CompleteSIgnUpButton = new JButton("Complete");
		CompleteSIgnUpButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CompleteSIgnUpButton.setBounds(116, 232, 158, 21);
		contentPane.add(CompleteSIgnUpButton);
		CompleteSIgnUpButton.addActionListener(this);
		
		creado = new JLabel("");
		creado.setFont(new Font("Tahoma", Font.PLAIN, 17));
		creado.setHorizontalAlignment(SwingConstants.CENTER);
		creado.setBounds(10, 263, 354, 34);
		contentPane.add(creado);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==CompleteSIgnUpButton) {
			if(cont.insertClient(new Client(introduceNameTextField.getText(), new String(IntroducePasswordTextField.getPassword())))) {
				OpcionesCliente v= new OpcionesCliente(cont);
				v.setVisible(true);
			}
			else {
				creado.setText("ERROR, NO SE HA PODIDO CREAR EL USUARIO");
			}
		}
	}
}
