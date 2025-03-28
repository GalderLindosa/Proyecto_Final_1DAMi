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

public class VentanaCompras extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox <String>  compras;
	private JLabel lblNewLabel;
	private Map<String, ShowBuys> mapa;
	private LoginControlador cont;
	private JButton btnClose;


	public VentanaCompras(OpcionesCliente opcionesCliente, LoginControlador cont, int id) {
		setUndecorated(true);
		this.cont =cont;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		compras = new JComboBox <String>();
		compras.setBounds(152, 79, 288, 34);
		contentPanel.add(compras);


		lblNewLabel = new JLabel("Aqui estan sus compras: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 78, 141, 34);
		contentPanel.add(lblNewLabel);

		btnClose = new JButton("X");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClose.setBounds(409, 0, 41, 27);
		contentPanel.add(btnClose);
		btnClose.addActionListener(this);

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


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==btnClose) {
			dispose();
		}
		
	}
}
