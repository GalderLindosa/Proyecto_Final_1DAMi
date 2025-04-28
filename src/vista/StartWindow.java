package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

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

public class StartWindow extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel IntroLabel;
	private JButton BotonLoginWorker;
	private JButton BotonLoginClient;
	private LoginControlador cont;
	private JButton InfoButtonWorker;
	private JButton InfoButtonClient;


	public StartWindow(LoginControlador cont) {

		setIconImage(Toolkit.getDefaultToolkit().getImage(StartWindow.class.getResource("/images/media-markt-1.png")));
		this.cont=cont;
		setTitle("Opening page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBorder(new LineBorder(new Color(189, 0, 0), 15));


		setContentPane(contentPane);
		contentPane.setLayout(null);

		IntroLabel = new JLabel("<html>Choose the type of user you will <br><div style=\"text-align: center;\"> log with!!</div></html>");
		IntroLabel.setForeground(new Color(0, 0, 0));
		IntroLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IntroLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 24));
		IntroLabel.setBounds(51, 21, 401, 75);
		contentPane.add(IntroLabel);

		BotonLoginWorker = new JButton("WORKER");
		BotonLoginWorker.setForeground(new Color(0, 0, 0));
		BotonLoginWorker.setBackground(new Color(255, 0, 0));
		BotonLoginWorker.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		BotonLoginWorker.setBounds(115, 93, 270, 89 );
		contentPane.add(BotonLoginWorker);
		BotonLoginWorker.addActionListener(this);

		BotonLoginClient = new JButton("CLIENT");
		BotonLoginClient.setBackground(new Color(255, 0, 0));
		BotonLoginClient.setForeground(new Color(0, 0, 0));
		BotonLoginClient.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		BotonLoginClient.setBounds(115, 192, 270, 89);
		contentPane.add(BotonLoginClient);

		InfoButtonWorker = new JButton("");
		InfoButtonWorker.setIcon(new ImageIcon(StartWindow.class.getResource("/images/info.png")));
		InfoButtonWorker.setBounds(412, 84, 40, 40);
		contentPane.add(InfoButtonWorker);
		InfoButtonWorker.addActionListener(this);

		InfoButtonClient = new JButton("");
		InfoButtonClient.setIcon(new ImageIcon(StartWindow.class.getResource("/images/info.png")));
		InfoButtonClient.setBounds(412, 192, 40, 40);
		contentPane.add(InfoButtonClient);
		InfoButtonClient.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(StartWindow.class.getResource("/images/FotoLogo.png")));
		lblNewLabel.setBounds(-30, 260, 281, 166);
		contentPane.add(lblNewLabel);
		BotonLoginClient.addActionListener(this);




		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==BotonLoginWorker) {
			WorkerLoginWindow v= new WorkerLoginWindow(cont);
			v.setVisible(true);
			dispose();
		}
		if(e.getSource()==BotonLoginClient) {
			ClientLoginWindow v= new ClientLoginWindow(cont);
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
