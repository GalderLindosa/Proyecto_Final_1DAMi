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

import javax.swing.JButton;

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
		setBounds(100, 100, 517, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextLabel1 = new JLabel("Choose the type of user you will log with");
		TextLabel1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		TextLabel1.setBounds(88, 29, 306, 45);
		contentPane.add(TextLabel1);
		
		BotonLoginWorker = new JButton("WORKER");
		BotonLoginWorker.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BotonLoginWorker.setBounds(113, 116, 258, 78);
		contentPane.add(BotonLoginWorker);
		BotonLoginWorker.addActionListener(this);
		
		BotonLoginClient = new JButton("CLIENT");
		BotonLoginClient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BotonLoginClient.setBounds(113, 245, 258, 78);
		contentPane.add(BotonLoginClient);
		BotonLoginClient.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==BotonLoginWorker) {
			VentanaLogingWorker v= new VentanaLogingWorker(cont);
			v.setVisible(true);
			dispose();
		}
		if(e.getSource()==BotonLoginClient) {
			VentanaLogingClient v= new VentanaLogingClient(cont);
			v.setVisible(true);
			dispose();
		}
	}
}