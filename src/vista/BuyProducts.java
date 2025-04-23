package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.LoginControlador;
import modelo.Buys;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

public class BuyProducts extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private LoginControlador cont;
	private JTextField productTextField;
	private JTextField ClientTextField;
	private JLabel Welcome;
	private JLabel ProductLabel;
	private JLabel ClientLabel;
	private JButton buyingbutton;
	private JLabel message;
	
	
	public BuyProducts(LoginControlador cont) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(BuyProducts.class.getResource("/images/media-markt-1.png")));
		setTitle("Buy Products");
		setBounds(100, 100, 450, 300);
		this.cont=cont;
		this.setModal(rootPaneCheckingEnabled);	
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		Welcome = new JLabel("Introduce your client ID and the product ID");
		Welcome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Welcome.setBackground(new Color(240, 240, 240));
		Welcome.setHorizontalAlignment(SwingConstants.CENTER);
		Welcome.setBounds(10, 10, 416, 33);
		contentPanel.add(Welcome);
		
		productTextField = new JTextField();
		productTextField.setBounds(235, 82, 96, 19);
		contentPanel.add(productTextField);
		productTextField.setColumns(10);
		
		ProductLabel = new JLabel("Write the product ID:");
		ProductLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		ProductLabel.setBounds(10, 81, 175, 21);
		contentPanel.add(ProductLabel);
		
		ClientLabel = new JLabel("Write your ID:");
		ClientLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		ClientLabel.setBounds(89, 139, 96, 19);
		contentPanel.add(ClientLabel);
		
		ClientTextField = new JTextField();
		ClientTextField.setColumns(10);
		ClientTextField.setBounds(235, 142, 96, 19);
		contentPanel.add(ClientTextField);
		
		buyingbutton = new JButton("Buy product");
		buyingbutton.setBounds(152, 190, 132, 21);
		contentPanel.add(buyingbutton);
		buyingbutton.addActionListener(this);
		
		message = new JLabel();
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setBounds(74, 220, 269, 33);
		contentPanel.add(message);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==buyingbutton) {
			if(cont.buyProduct(new Buys(LocalDate.now(), 1, productTextField.getText(), Integer.parseInt((ClientTextField.getText())) ))) {
				message.setText("Thanks for buying in our store!");
			}
			else {
				message.setText("Something went wrong with the purchase");
			}
		}
	}
}