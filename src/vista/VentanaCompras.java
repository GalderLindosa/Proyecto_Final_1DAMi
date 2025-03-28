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
import modelo.ShowBuys;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;

public class VentanaCompras extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox <String>  compras;
	private JLabel lblNewLabel;
	private Map<String, ShowBuys> mapa;
	private LoginControlador cont;


	public VentanaCompras(OpcionesCliente opcionesCliente, LoginControlador cont, int id) {
		this.cont =cont;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		compras = new JComboBox <String>();
		compras.setBounds(172, 79, 239, 34);
		contentPanel.add(compras);
		

		lblNewLabel = new JLabel("Aqui estan sus compras: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 77, 239, 34);
		contentPanel.add(lblNewLabel);
		
		 cargarCompras();
	}


	public void cargarCompras() {
		mapa=cont.mostrarCompras();
		if(!mapa.isEmpty()) {
			compras.setSelectedIndex(-1);
			for(ShowBuys a : mapa.values()) {
				compras.addItem(a.toString());
			}
		}
		compras.setSelectedIndex(-1);

	}
}
