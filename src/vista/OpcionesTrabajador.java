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
import java.awt.Toolkit;
import java.awt.Font;

public class OpcionesTrabajador extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JLabel WelcomeLabel;
	private Map<String, Product> mapa;
	private LoginControlador cont;
	private JButton DELETE_BUTTON;
	private JButton UPDATE_PRODUCT;
	private JButton btnNewButton;

	public OpcionesTrabajador(LoginControlador cont) {
		setModal(rootPaneCheckingEnabled);
		setIconImage(Toolkit.getDefaultToolkit().getImage(OpcionesTrabajador.class.getResource("/images/media-markt-1.png")));
		setTitle("Worker's options");
		this.cont=cont;
		setBounds(100, 100, 450, 245);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		WelcomeLabel = new JLabel("WELCOME TO THE WORKERS PAGE!!!!");
		WelcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		WelcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		WelcomeLabel.setBounds(70, 13, 303, 48);
		contentPanel.add(WelcomeLabel);


		DELETE_BUTTON = new JButton("DELETE PRODUCT");
		DELETE_BUTTON.setFont(new Font("Tahoma", Font.PLAIN, 12));
		DELETE_BUTTON.setBounds(142, 113, 153, 33);
		contentPanel.add(DELETE_BUTTON);
		DELETE_BUTTON.addActionListener(this);

		UPDATE_PRODUCT = new JButton("UPDATE PRODUCT PRICE");
		UPDATE_PRODUCT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		UPDATE_PRODUCT.setBounds(110, 71, 200, 33);
		contentPanel.add(UPDATE_PRODUCT);
		
		btnNewButton = new JButton("IMPORT PRODUCT");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(142, 156, 153, 33);
		contentPanel.add(btnNewButton);
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

	
}