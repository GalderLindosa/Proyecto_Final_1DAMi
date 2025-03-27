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

public class OpcionesTrabajador extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JLabel WelcomeLabel;
	private JComboBox <String> ProductBox;
	private Map<String, Product> mapa;
	private LoginControlador cont;
	private JButton DELETE_BUTTON;
	private JButton UPDATE_PRODUCT;

	public OpcionesTrabajador(LoginControlador cont) {
		this.cont=cont;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		WelcomeLabel = new JLabel("WELCOME TO THE ADMIN PAGE!!!!");
		WelcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		WelcomeLabel.setBounds(110, 27, 200, 48);
		contentPanel.add(WelcomeLabel);

		ProductBox = new JComboBox<String>();
		ProductBox.setBounds(45, 99, 339, 21);
		contentPanel.add(ProductBox);
		LoadProduct();


		DELETE_BUTTON = new JButton("DELETE PRODUCT");
		DELETE_BUTTON.setBounds(248, 153, 153, 33);
		contentPanel.add(DELETE_BUTTON);
		DELETE_BUTTON.addActionListener(this);

		UPDATE_PRODUCT = new JButton("UPDATE PRODUCT PRICE");
		UPDATE_PRODUCT.setBounds(10, 153, 233, 33);
		contentPanel.add(UPDATE_PRODUCT);
		UPDATE_PRODUCT.addActionListener(this);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==DELETE_BUTTON) {
			DeleteProduct v= new DeleteProduct(cont);
			v.setVisible(true);
		}
		if(e.getSource()==UPDATE_PRODUCT) {
			UpdateProductPrice v= new UpdateProductPrice(cont);
			v.setVisible(true);
		}

	}

	public void LoadProduct() {
		mapa=cont.MostrarProducto();
		if(!mapa.isEmpty()) {
			ProductBox.setSelectedIndex(-1);
			for(Product a : mapa.values()) {
				ProductBox.addItem(a.toString());
			}
		}
		ProductBox.setSelectedIndex(-1);
	}
}
