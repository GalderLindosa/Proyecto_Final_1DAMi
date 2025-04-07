package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.LoginControlador;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class VentanaInicio extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel TextLabel1;
	private JButton BotonLoginWorker;
	private JButton BotonLoginClient;
	private LoginControlador cont;


	public VentanaInicio(LoginControlador cont) {
		this.cont=cont;
		setTitle("Pagina Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 613, 495);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 111, 111));
		contentPane.setBorder(new LineBorder(new Color(189, 0, 0), 15));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		TextLabel1 = new JLabel("<html>Choose the type of user you will <br><div style=\"text-align: center;\"> log with!!</div></html>");
		TextLabel1.setForeground(new Color(0, 0, 0));
		TextLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		TextLabel1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 24));
		TextLabel1.setBounds(98, 96, 401, 75);
		contentPane.add(TextLabel1);
		
		BotonLoginWorker = new JButton("WORKER");
		BotonLoginWorker.setForeground(new Color(0, 0, 0));
		BotonLoginWorker.setBackground(new Color(255, 0, 0));
		BotonLoginWorker.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		BotonLoginWorker.setBounds(312, 188, 214, 89 );
		contentPane.add(BotonLoginWorker);
		BotonLoginWorker.addActionListener(this);
		
		BotonLoginClient = new JButton("CLIENT");
		BotonLoginClient.setBackground(new Color(255, 0, 0));
		BotonLoginClient.setForeground(new Color(0, 0, 0));
		BotonLoginClient.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		BotonLoginClient.setBounds(56, 188, 214, 89);
		contentPane.add(BotonLoginClient);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaInicio.class.getResource("/Imagenes/FotoLogo.png")));
		lblNewLabel.setBounds(167, 273, 265, 175);
		contentPane.add(lblNewLabel);
		BotonLoginClient.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==BotonLoginWorker) {
			VentanaLogingWorker v= new VentanaLogingWorker(cont);
			v.setVisible(true);
			
		}
		if(e.getSource()==BotonLoginClient) {
			VentanaLogingClient v= new VentanaLogingClient(cont);
			v.setVisible(true);
		}
	}
}