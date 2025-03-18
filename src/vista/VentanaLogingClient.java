package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaLogingClient extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel QuestionLabel;
	private JButton SignUpButton;
	private JButton SignInButton;
	
	public VentanaLogingClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		QuestionLabel = new JLabel("What do you want to do?");
		QuestionLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		QuestionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		QuestionLabel.setBounds(95, 50, 261, 29);
		contentPane.add(QuestionLabel);
		
		SignUpButton = new JButton("Sign up");
		SignUpButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SignUpButton.setBounds(141, 106, 141, 29);
		contentPane.add(SignUpButton);
		SignUpButton.addActionListener(this);
		
		SignInButton = new JButton("Sign in");
		SignInButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SignInButton.setBounds(141, 174, 141, 29);
		contentPane.add(SignInButton);
		SignInButton.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==SignUpButton) {
			SignUpClient v= new SignUpClient();
			v.setVisible(true);
			dispose();
		}
		if(e.getSource()==SignInButton) {
			SignInClient v= new SignInClient();
			v.setVisible(true);
			dispose();
		}
	}

}
