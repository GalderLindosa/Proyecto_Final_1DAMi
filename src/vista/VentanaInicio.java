package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.LoginControlador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class VentanaInicio extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel TextLabel1;
	private JButton BotonLoginWorker;
	private JButton BotonLoginClient;
	private LoginControlador cont;
	private JButton InfoButtonWorker;
	private JButton InfoButtonClient;
	

	public VentanaInicio(LoginControlador cont) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaInicio.class.getResource("/images/media-markt-1.png")));
		this.cont=cont;
		setTitle("Opening page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextLabel1 = new JLabel("Choose the type of user you will log with");
		TextLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		TextLabel1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		TextLabel1.setBounds(56, 41, 390, 45);
		contentPane.add(TextLabel1);
		
		BotonLoginWorker = new JButton("WORKER");
		BotonLoginWorker.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BotonLoginWorker.setBounds(115, 151, 258, 78);
		contentPane.add(BotonLoginWorker);
		BotonLoginWorker.addActionListener(this);
		
		BotonLoginClient = new JButton("CLIENT");
		BotonLoginClient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BotonLoginClient.setBounds(115, 282, 258, 78);
		contentPane.add(BotonLoginClient);
		BotonLoginClient.addActionListener(this);

		InfoButtonWorker = new JButton("");
		InfoButtonWorker.setIcon(new ImageIcon(VentanaInicio.class.getResource("/images/info.png")));
		InfoButtonWorker.setBounds(380, 110, 40, 40);
		contentPane.add(InfoButtonWorker);
		InfoButtonWorker.addActionListener(this);

		InfoButtonClient = new JButton("");
		InfoButtonClient.setIcon(new ImageIcon("C:\\Users\\1dami\\Downloads\\info.png"));
		InfoButtonClient.setBounds(380, 247, 40, 40);
		contentPane.add(InfoButtonClient);
		InfoButtonClient.addActionListener(this);
		
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
		if(e.getSource()==InfoButtonWorker) {
			JOptionPane.showMessageDialog(this,(String)"This option takes you to the workers Login window","Info",JOptionPane.INFORMATION_MESSAGE,null);
		}
		if(e.getSource()==InfoButtonClient) {
			JOptionPane.showMessageDialog(this,(String)"This option takes you to the client Login or Sign in window","Info",JOptionPane.INFORMATION_MESSAGE,null);
		}
	}
}
