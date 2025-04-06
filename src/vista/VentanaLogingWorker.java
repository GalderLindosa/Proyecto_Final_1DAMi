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
<<<<<<< HEAD
import java.awt.Toolkit;
=======
>>>>>>> 522970e38f6e9225cf86e865c7be58833bf82481

public class VentanaLogingWorker extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField WorkerIDtextField;
	private JLabel WelcomeLabel;
	private JLabel WorkerPasswordLabel;
	private JButton LoginButton;
	private LoginControlador cont; 
	private JPasswordField passwordField;
	private JLabel workersIDlabel;
<<<<<<< HEAD
	private JLabel LoginErrorLabel;
	
	public VentanaLogingWorker(LoginControlador cont) {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaLogingWorker.class.getResource("/images/media-markt-1.png")));
		this.cont=cont;
		setTitle("Worker's login page");
=======
	
	public VentanaLogingWorker(LoginControlador cont) {
		this.cont=cont;
		setTitle("Worker's login");
>>>>>>> 522970e38f6e9225cf86e865c7be58833bf82481
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
		workersIDlabel.setBounds(139, 93, 198, 40);
		contentPane.add(workersIDlabel);
		
		WorkerIDtextField = new JTextField();
		WorkerIDtextField.setBounds(139, 143, 198, 28);
		contentPane.add(WorkerIDtextField);
		WorkerIDtextField.setColumns(10);
		
		WorkerPasswordLabel = new JLabel("Introduce your password");
		WorkerPasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		WorkerPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		WorkerPasswordLabel.setBounds(147, 192, 190, 40);
		contentPane.add(WorkerPasswordLabel);
		
		LoginButton = new JButton("Log in");
		LoginButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		LoginButton.setBounds(154, 298, 171, 28);
		contentPane.add(LoginButton);
		LoginButton.addActionListener(this);
		
		passwordField = new JPasswordField();
<<<<<<< HEAD
		passwordField.setBounds(139, 242, 198, 28);
		contentPane.add(passwordField);
		
		LoginErrorLabel = new JLabel("");
		LoginErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LoginErrorLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LoginErrorLabel.setBounds(65, 348, 400, 34);
		contentPane.add(LoginErrorLabel);
=======
		passwordField.setBounds(139, 279, 198, 28);
		contentPane.add(passwordField);
>>>>>>> 522970e38f6e9225cf86e865c7be58833bf82481
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		if(e.getSource()==LoginButton) {
			if(cont.comprobarTrabajador(new Worker (new String(passwordField.getPassword()), WorkerIDtextField.getText()))){
				WorkerOptions v= new WorkerOptions(cont);
				v.setVisible(true);
				dispose();
			}
			else {
				LoginErrorLabel.setText("ERROR! Asegurese de que las credenciales son correctas");
			}
=======
		System.out.println("ENTRO");
		if(e.getSource()==LoginButton) {
			System.out.println("AAAAAAAAA");
			if(cont.comprobarTrabajador(new Worker (new String(passwordField.getPassword()), WorkerIDtextField.getText()))){
				System.out.println("bbbbbbbb");
				OpcionesTrabajador v= new OpcionesTrabajador(cont);
				v.setVisible(true);
				dispose();
			}
>>>>>>> 522970e38f6e9225cf86e865c7be58833bf82481
		}
	}
}