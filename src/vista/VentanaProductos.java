package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.LoginControlador;
import modelo.Client;
import modelo.Product;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class VentanaProductos extends JDialog  {

	private final JPanel contentPanel = new JPanel();
	private JComboBox <String> comboBox;
	private JLabel lblNewLabel;
	private Map<String, Product> mapa;
	private LoginControlador cont;
	int id;

	public VentanaProductos(OpcionesCliente opcionesCliente, LoginControlador cont,int id) {
		this.cont=cont;
		this.id=id;
		this.mapa=cont.MostrarProducto();

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		comboBox = new JComboBox <String> ();
		comboBox.setBounds(120, 72, 170, 21);
		contentPanel.add(comboBox);
		cargarProd();

		lblNewLabel = new JLabel();
		lblNewLabel.setText("Aqui tiene todos los productos disponibles");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(35, 10, 376, 52);
		contentPanel.add(lblNewLabel);

	}


	public void cargarProd() {
		mapa=cont.MostrarProducto();
		if(!mapa.isEmpty()) {
			comboBox.setSelectedIndex(-1);
			for(Product a : mapa.values()) {
				comboBox.addItem(a.getproduct_name());
			}
		}
		comboBox.setSelectedIndex(-1);
	}
}
