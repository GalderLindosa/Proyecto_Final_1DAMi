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

		setContentPane(contentPane);
		contentPane.setLayout(null);

		IntroLabel = new JLabel("Choose the type of user you will log with");
		IntroLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IntroLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		IntroLabel.setBounds(61, 52, 390, 45);
		contentPane.add(IntroLabel);

		BotonLoginWorker = new JButton("WORKER");
		BotonLoginWorker.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BotonLoginWorker.setBounds(110, 166, 258, 78);
		contentPane.add(BotonLoginWorker);
		BotonLoginWorker.addActionListener(this);

		BotonLoginClient = new JButton("CLIENT");
		BotonLoginClient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BotonLoginClient.setBounds(110, 286, 258, 78);
		contentPane.add(BotonLoginClient);
		BotonLoginClient.addActionListener(this);

		InfoButtonWorker = new JButton("");
		InfoButtonWorker.setIcon(new ImageIcon(StartWindow.class.getResource("/images/info.png")));
		InfoButtonWorker.setBounds(378, 132, 40, 40);
		contentPane.add(InfoButtonWorker);
		InfoButtonWorker.addActionListener(this);

		InfoButtonClient = new JButton("");
		InfoButtonClient.setIcon(new ImageIcon(StartWindow.class.getResource("/images/info.png")));
		InfoButtonClient.setBounds(375, 250, 40, 40);
		contentPane.add(InfoButtonClient);
		InfoButtonClient.addActionListener(this);





		
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
