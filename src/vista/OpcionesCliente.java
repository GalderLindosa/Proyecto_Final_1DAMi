package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.LoginControlador;
import modelo.Buys;
import modelo.Client;
import modelo.Product;
import modelo.ShowBuys;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class OpcionesCliente extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private Map<String, Product> mapa;
	private LoginControlador cont;
	int id;
	private JButton btnShowPurchase;
	private JButton btnShowProducts;
	private JLabel lblDecideQueQuieres;
	
	public OpcionesCliente(LoginControlador cont, int id) {
		this.cont=cont;
		this.id=id;
		this.mapa=cont.MostrarProducto();

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		

		lblNewLabel = new JLabel();
		lblNewLabel.setText("BIENVENIDO/A!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(30, 10, 376, 52);
		contentPanel.add(lblNewLabel);

		lblDecideQueQuieres = new JLabel();
		lblDecideQueQuieres.setText("Decide que quieres hacer\r\n");
		lblDecideQueQuieres.setHorizontalAlignment(SwingConstants.CENTER);
		lblDecideQueQuieres.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDecideQueQuieres.setBounds(30, 32, 376, 52);
		contentPanel.add(lblDecideQueQuieres);

		btnShowPurchase = new JButton("Show Purchases\r\n");
		btnShowPurchase.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnShowPurchase.setBounds(130, 94, 178, 41);
		contentPanel.add(btnShowPurchase);
		btnShowPurchase.addActionListener(this);
		
	    btnShowProducts = new JButton("Show products");
		btnShowProducts.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnShowProducts.setBounds(130, 165, 178, 41);
		contentPanel.add(btnShowProducts);
		btnShowProducts.addActionListener(this);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==btnShowPurchase) {
			VentanaCompras v=new  VentanaCompras(this,cont,id);
			v.setVisible(true);
		}
		if (e.getSource()==btnShowProducts) {
			VentanaProductos v=new  VentanaProductos(this,cont, id);
			v.setVisible(true);
		}
	}		
}
