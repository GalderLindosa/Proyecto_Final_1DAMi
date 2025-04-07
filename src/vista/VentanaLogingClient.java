package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controlador.LoginControlador;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class VentanaLogingClient extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel QuestionLabel;
	private JButton SignUpButton;
	private JButton SignInButton;
	private LoginControlador cont;
	private JLabel lblNewLabel;
	
	public VentanaLogingClient(LoginControlador cont) {
		this.cont=cont;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBorder(new LineBorder(new Color(189, 0, 0), 15));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		QuestionLabel = new JLabel("What do you want to do?");
		QuestionLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		QuestionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		QuestionLabel.setBounds(130, 88, 261, 29);
		contentPane.add(QuestionLabel);
		
		SignUpButton = new JButton("SIGN UP");
		SignUpButton.setForeground(new Color(0, 0, 0));
		SignUpButton.setBackground(new Color(255, 0, 0));
		SignUpButton.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
		SignUpButton.setBounds(175, 214, 166, 45);
		contentPane.add(SignUpButton);
		SignUpButton.addActionListener(this);
		
		SignInButton = new JButton("SIGN IN\r\n");
		SignInButton.setForeground(new Color(0, 0, 0));
		SignInButton.setBackground(new Color(255, 0, 0));
		SignInButton.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
		SignInButton.setBounds(175, 127, 166, 45);
		contentPane.add(SignInButton);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaLogingClient.class.getResource("/Imagenes/logotipo-mediamarkt.png")));
		lblNewLabel.setBounds(191, 27, 347, 37);
		contentPane.add(lblNewLabel);
		SignInButton.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==SignUpButton) {
			SignUpClient v= new SignUpClient(cont);
			v.setVisible(true);
			dispose();
		}
		if(e.getSource()==SignInButton) {
			SignInClient v= new SignInClient(cont);
			v.setVisible(true);
			dispose();
		}
	}
}