package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.LoginControlador;
import modelo.Product;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Font;

public class OpcionesTrabajador extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JLabel WelcomeLabel;
	private JComboBox <String> ProductBox;
	private Map<String, Product> mapa;
	private LoginControlador cont;
	private JButton btnClose;

	public OpcionesTrabajador(LoginControlador cont) {
		setUndecorated(true);
		setTitle("AAAAAAAA");
		this.cont=cont;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		WelcomeLabel = new JLabel("WELCOME TO THE ADMIN PAGE");
		WelcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		WelcomeLabel.setBounds(110, 27, 200, 48);
		contentPanel.add(WelcomeLabel);


		ProductBox = new JComboBox<String>();
		ProductBox.setBounds(122, 99, 200, 21);
		contentPanel.add(ProductBox);

		btnClose = new JButton("X");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClose.setBounds(468, 0, 49, 31);
		contentPanel.add(btnClose);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==btnClose) {
			dispose();
		}
	}



}