package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controlador.LoginControlador;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Client;
import modelo.Worker;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class VentanaLogingWorker extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField WorkerIDtextField;
	private JLabel WelcomeLabel;
	private JLabel WorkerPasswordLabel;
	private JButton LoginButton;
	private LoginControlador cont; 
	private JPasswordField passwordField;
	private JLabel workersIDlabel;
	
	public VentanaLogingWorker(LoginControlador cont) {
		this.cont=cont;
		setTitle("Worker's login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		WelcomeLabel = new JLabel("Welcome to the workers Login");
		WelcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		WelcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		WelcomeLabel.setBounds(59, 26, 387, 57);
		contentPane.add(WelcomeLabel);
		
		workersIDlabel = new JLabel("Introduce your worker's ID");
		workersIDlabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		workersIDlabel.setHorizontalAlignment(SwingConstants.CENTER);
		workersIDlabel.setBounds(139, 108, 198, 40);
		contentPane.add(workersIDlabel);
		
		WorkerIDtextField = new JTextField();
		WorkerIDtextField.setBounds(139, 169, 198, 28);
		contentPane.add(WorkerIDtextField);
		WorkerIDtextField.setColumns(10);
		
		WorkerPasswordLabel = new JLabel("Introduce your password");
		WorkerPasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		WorkerPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		WorkerPasswordLabel.setBounds(139, 219, 190, 40);
		contentPane.add(WorkerPasswordLabel);
		
		LoginButton = new JButton("Log in");
		LoginButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		LoginButton.setBounds(155, 354, 171, 28);
		contentPane.add(LoginButton);
		LoginButton.addActionListener(this);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(139, 279, 198, 28);
		contentPane.add(passwordField);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("ENTRO");
		if(e.getSource()==LoginButton) {
			System.out.println("AAAAAAAAA");
			if(cont.comprobarTrabajador(new Worker (new String(passwordField.getPassword()), WorkerIDtextField.getText()))){
				System.out.println("bbbbbbbb");
				OpcionesTrabajador v= new OpcionesTrabajador(cont);
				v.setVisible(true);
				dispose();
			}
		}
	}
}