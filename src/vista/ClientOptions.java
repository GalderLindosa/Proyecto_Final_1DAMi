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
import java.awt.Toolkit;

public class ClientOptions extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JComboBox <String> ProductComboBox;
	private JLabel ClientWelcomeLabel;
	private Map<String, Product> mapa;
	private LoginControlador cont;
	int id;

	public ClientOptions(LoginControlador cont) {
		setModal(rootPaneCheckingEnabled);
		this.setModal(rootPaneCheckingEnabled);	
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClientOptions.class.getResource("/images/media-markt-1.png")));
		setTitle("Clients options");
		this.cont=cont;
		this.id=id;
		this.mapa=cont.MostrarProducto();

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		ProductComboBox = new JComboBox <String> ();
		ProductComboBox.setBounds(10, 100, 416, 21);
		contentPanel.add(ProductComboBox);
		cargarProd();

		ClientWelcomeLabel = new JLabel();
		ClientWelcomeLabel.setText("BIENVENIDO/A!");
		ClientWelcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ClientWelcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ClientWelcomeLabel.setBounds(35, 10, 376, 52);
		contentPanel.add(ClientWelcomeLabel);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
	}

	public void cargarProd() {
		mapa=cont.MostrarProducto();
		if(!mapa.isEmpty()) {
			ProductComboBox.setSelectedIndex(-1);
			for(Product a : mapa.values()) {
				ProductComboBox.addItem(a.toString());
			}
		}
		ProductComboBox.setSelectedIndex(-1);
	}
}
