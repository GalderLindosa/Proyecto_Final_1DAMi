package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.LoginControlador;
import modelo.Product;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Toolkit;

public class UpdateProductPrice extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JLabel Update_lable;
	private JButton Update_button;
	LoginControlador cont;
	private JLabel PriceUpdatedLabel;
	private JTextField ProductIDTextFIeld;
	private JLabel ProductIDLabel;
	private JSpinner UpdateSpinner;
	private JLabel ProductUpdateWindow;
	
	
	
	
	public UpdateProductPrice(LoginControlador cont) {
		setModal(rootPaneCheckingEnabled);
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateProductPrice.class.getResource("/images/media-markt-1.png")));
		setTitle("Product update");
		this.cont=cont;
		setModal(rootPaneCheckingEnabled);
		setBounds(100, 100, 575, 386);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		Update_lable = new JLabel("Enter the new product price");
		Update_lable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Update_lable.setHorizontalAlignment(SwingConstants.CENTER);
		Update_lable.setBounds(10, 195, 230, 35);
		contentPanel.add(Update_lable);
		
		Update_button = new JButton("UPDATE");
		Update_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Update_button.setBounds(183, 264, 196, 43);
		contentPanel.add(Update_button);
		Update_button.addActionListener(this);
		PriceUpdatedLabel = new JLabel("");
		PriceUpdatedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PriceUpdatedLabel.setBounds(144, 312, 312, 27);
		contentPanel.add(PriceUpdatedLabel);
		
		ProductIDLabel = new JLabel("Enter the product ID");
		ProductIDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ProductIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ProductIDLabel.setBounds(10, 120, 217, 35);
		contentPanel.add(ProductIDLabel);
		
		ProductIDTextFIeld = new JTextField();
		ProductIDTextFIeld.setBounds(240, 122, 297, 36);
		contentPanel.add(ProductIDTextFIeld);
		ProductIDTextFIeld.setColumns(10);
		
		UpdateSpinner = new JSpinner();
		UpdateSpinner.setModel(new SpinnerNumberModel(0.0, 0.0, 100000.0, 10.0));
		UpdateSpinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
		UpdateSpinner.setBounds(240, 199, 77, 27);
		contentPanel.add(UpdateSpinner);
		
		ProductUpdateWindow = new JLabel("Welcome to the product price update");
		ProductUpdateWindow.setHorizontalAlignment(SwingConstants.CENTER);
		ProductUpdateWindow.setFont(new Font("Tahoma", Font.PLAIN, 25));
		ProductUpdateWindow.setBounds(46, 23, 477, 43);
		contentPanel.add(ProductUpdateWindow);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==Update_button) {
			if (cont.modificarPrecio(new Product( (double) UpdateSpinner.getValue() ,ProductIDTextFIeld.getText()))) {
				PriceUpdatedLabel.setText("Precio Modificado");

			}
			else {
				PriceUpdatedLabel.setText("ERROR, Precio no modificado");
			}
		}
	}
}