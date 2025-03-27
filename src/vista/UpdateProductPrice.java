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

public class UpdateProductPrice extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField Update_Textfield;
	private JLabel Update_lable;
	private JButton Update_button;
	LoginControlador cont;
	private JLabel PriceUpdatedLabel;
	private JTextField ProductIDTextFIeld;
	private JLabel ProductIDLabel;
	
	public UpdateProductPrice(LoginControlador cont) {
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
		Update_lable.setBounds(156, 141, 285, 35);
		contentPanel.add(Update_lable);
		
		Update_Textfield = new JTextField();
		Update_Textfield.setBounds(183, 205, 206, 27);
		contentPanel.add(Update_Textfield);
		Update_Textfield.setColumns(10);
		
		Update_button = new JButton("UPDATE");
		Update_button.setBounds(226, 267, 140, 35);
		contentPanel.add(Update_button);
		Update_button.addActionListener(this);
		PriceUpdatedLabel = new JLabel("");
		PriceUpdatedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PriceUpdatedLabel.setBounds(144, 312, 312, 27);
		contentPanel.add(PriceUpdatedLabel);
		
		ProductIDLabel = new JLabel("Enter the product ID");
		ProductIDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ProductIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ProductIDLabel.setBounds(144, 25, 297, 35);
		contentPanel.add(ProductIDLabel);
		
		ProductIDTextFIeld = new JTextField();
		ProductIDTextFIeld.setBounds(144, 82, 297, 36);
		contentPanel.add(ProductIDTextFIeld);
		ProductIDTextFIeld.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==Update_button) {
			if (cont.modificarPrecio(new Product(Integer.parseInt( Update_Textfield.getText()),ProductIDTextFIeld.getText()))) {
				PriceUpdatedLabel.setText("Precio Modificado");

			}
			else {
				PriceUpdatedLabel.setText("ERROR, Precio no modificado");
			}
		}
	}
}
