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
import java.awt.Toolkit;

public class SignInClient extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField IDField;
	private JButton SignInClient;
	private LoginControlador cont;
	private JLabel SignInLabel;
	private JLabel WriteIDLabel;
	private JLabel WritePasswordLabel;
	private JPasswordField ClientPasswordField;
	private JLabel LoginErrorLabel;
	int id;

	public SignInClient(LoginControlador cont) {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignInClient.class.getResource("/images/media-markt-1.png")));
		setTitle("Client Sign In");
		this.cont=cont;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		SignInLabel = new JLabel("Sign In");
		SignInLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SignInLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SignInLabel.setBounds(132, 22, 163, 28);
		contentPane.add(SignInLabel);

		WriteIDLabel = new JLabel("Introduce your client ID");
		WriteIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		WriteIDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		WriteIDLabel.setBounds(30, 60, 176, 32);
		contentPane.add(WriteIDLabel);

		WritePasswordLabel = new JLabel("Introduce your password");
		WritePasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		WritePasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		WritePasswordLabel.setBounds(21, 114, 201, 32);
		contentPane.add(WritePasswordLabel);

		IDField = new JTextField();
		IDField.setBounds(266, 69, 96, 19);
		contentPane.add(IDField);
		IDField.setColumns(10);

		SignInClient = new JButton("Sign In");
		SignInClient.setFont(new Font("Tahoma", Font.PLAIN, 13));
		SignInClient.setBounds(146, 169, 136, 32);
		contentPane.add(SignInClient);
		SignInClient.addActionListener(this);

		ClientPasswordField = new JPasswordField();
		ClientPasswordField.setBounds(266, 123, 96, 19);
		contentPane.add(ClientPasswordField);
		
		LoginErrorLabel = new JLabel("");
		LoginErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LoginErrorLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LoginErrorLabel.setBounds(101, 211, 220, 28);
		contentPane.add(LoginErrorLabel);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==SignInClient) {
			if(cont.comprobarCliente(new Client (new String(ClientPasswordField.getPassword()), Integer.parseInt(IDField.getText())))){
				id=Integer.parseInt(IDField.getText());
				ClientOptions v= new ClientOptions();
				v.setVisible(true);
			}
			else {
				LoginErrorLabel.setText("ERROR AL INICIAR SESION");
			}
		}
	}
}
