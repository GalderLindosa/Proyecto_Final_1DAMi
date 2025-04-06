package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.LoginControlador;

import java.awt.Toolkit;
import java.awt.Font;

public class ClientOptions extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton BuyProducts;
	private JButton ShowPurchase;
	private LoginControlador cont;
	
	public ClientOptions() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClientOptions.class.getResource("/images/media-markt-1.png")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		BuyProducts = new JButton("BuyProducts\r\n");
		BuyProducts.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BuyProducts.setBounds(145, 139, 145, 58);
		contentPanel.add(BuyProducts);
		BuyProducts.addActionListener(this);
		
		ShowPurchase= new JButton("ShowPurchase\r\n");
		ShowPurchase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ShowPurchase.setBounds(145, 42, 145, 58);
		contentPanel.add(ShowPurchase);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==BuyProducts) {
			BuyProducts v= new BuyProducts();
			v.setVisible(true);
		}
		if(e.getSource()==ShowPurchase) {
			ShowProducts v= new ShowProducts(cont);
			v.setVisible(true);
		}
	}
}
