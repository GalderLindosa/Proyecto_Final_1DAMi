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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.LoginControlador;
import modelo.Client;
import javax.swing.JPasswordField;

public class SignInClient extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField IDField;
	private JButton SignInClient;
	private LoginControlador cont;
	private JLabel SignInLabel;
	private JLabel WriteIDLabel;
	private JLabel WritePasswordLabel;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	int id;

	public SignInClient(LoginControlador cont) {
		this.cont=cont;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		SignInLabel = new JLabel("Sign In");
		SignInLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SignInLabel.setBounds(132, 22, 163, 28);
		contentPane.add(SignInLabel);

		WriteIDLabel = new JLabel("Introduce your client ID");
		WriteIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		WriteIDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		WriteIDLabel.setBounds(132, 60, 176, 32);
		contentPane.add(WriteIDLabel);

		WritePasswordLabel = new JLabel("Introduce your password");
		WritePasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		WritePasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		WritePasswordLabel.setBounds(113, 142, 217, 32);
		contentPane.add(WritePasswordLabel);

		IDField = new JTextField();
		IDField.setBounds(162, 112, 96, 19);
		contentPane.add(IDField);
		IDField.setColumns(10);

		SignInClient = new JButton("Sign In");
		SignInClient.setBounds(172, 232, 85, 21);
		contentPane.add(SignInClient);
		SignInClient.addActionListener(this);

		passwordField = new JPasswordField();
		passwordField.setBounds(162, 192, 96, 19);
		contentPane.add(passwordField);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(25, 97, 96, 28);
		contentPane.add(lblNewLabel);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==SignInClient) {
			if(cont.comprobarCliente(new Client (new String(passwordField.getPassword()), Integer.parseInt(IDField.getText())))){
				id=Integer.parseInt(IDField.getText());
				OpcionesCliente v= new OpcionesCliente(cont, id);
				v.setVisible(true);
				dispose();
			}
			else {
				lblNewLabel.setText("ERROR AL INICIAR SESION");
			}
		}
	}
}