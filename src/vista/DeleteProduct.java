package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.LoginControlador;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

public class DeleteProduct extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private LoginControlador cont;
	private JTextField DeleteProductIDLabel;
	private JLabel DeleteProductLable;
	private JLabel DeletedProductLabel;
	private JButton DeleteButton;
	
	public DeleteProduct(LoginControlador cont) {
		setModal(rootPaneCheckingEnabled);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\1dami\\Downloads\\media-markt-1.png"));
		setTitle("Delete product");
		this.cont=cont;
		setBounds(100, 100, 447, 234);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			DeleteProductLable = new JLabel("Introduce the ID of the product you want to delete");
			DeleteProductLable.setFont(new Font("Tahoma", Font.PLAIN, 15));
			DeleteProductLable.setHorizontalAlignment(SwingConstants.CENTER);
			DeleteProductLable.setBounds(5, 30, 431, 26);
			contentPanel.add(DeleteProductLable);
		}
		{
			DeleteProductIDLabel = new JTextField();
			DeleteProductIDLabel.setBounds(143, 77, 159, 26);
			contentPanel.add(DeleteProductIDLabel);
			DeleteProductIDLabel.setColumns(10);
		}
		{
			DeletedProductLabel = new JLabel("");
			DeletedProductLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			DeletedProductLabel.setHorizontalAlignment(SwingConstants.CENTER);
			DeletedProductLabel.setBounds(25, 161, 385, 26);
			contentPanel.add(DeletedProductLabel);
		}
		
		DeleteButton = new JButton("DELETE");
		DeleteButton.setBounds(141, 126, 161, 26);
		contentPanel.add(DeleteButton);
		DeleteButton.addActionListener(this);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==DeleteButton) {
			if (cont.deleteProduct(DeleteProductIDLabel.getText())) {
				DeletedProductLabel.setText("Producto eliminado");
			}else {
				DeletedProductLabel.setText("ERROR, NO SE PUDO ELIMINAR EL PRODUCTO DE LA BASE DE DATOS");
				
			}
		}
	}
}
