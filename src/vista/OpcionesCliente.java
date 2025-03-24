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
	private JComboBox <String> comboBox;
	private JLabel lblNewLabel;
	private Map<String, ShowBuys> mapa;
	private LoginControlador cont;
	private JButton ShowProductsInfo;
	int id;
	
	public OpcionesCliente(LoginControlador cont, int id) {
		this.cont=cont;
		this.id=id;
		this.mapa=cont.mostrarCompras();

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		comboBox = new JComboBox <String> ();
		comboBox.setBounds(122, 100, 170, 21);
		contentPanel.add(comboBox);
		cargarProd();
		
		lblNewLabel = new JLabel();
		lblNewLabel.setText("BIENVENIDO/A!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(35, 10, 376, 52);
		contentPanel.add(lblNewLabel);
		
		ShowProductsInfo = new JButton("Mostrar informacion del producto");
		ShowProductsInfo.setBounds(10, 167, 184, 37);
		contentPanel.add(ShowProductsInfo);
		ShowProductsInfo.addActionListener(this);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==ShowProductsInfo) {
			JOptionPane.showMessageDialog(this,(String) id.g ,"Informacion del producto",JOptionPane.INFORMATION_MESSAGE,null);
		}
	}
	
	
	public void cargarProd() {
		mapa=cont.mostrarCompras();
		if(!mapa.isEmpty()) {
			comboBox.setSelectedIndex(-1);
			for(ShowBuys a : mapa.values()) {
				comboBox.addItem(a.getproduct_name());
			}
		}
		comboBox.setSelectedIndex(-1);
	}
}