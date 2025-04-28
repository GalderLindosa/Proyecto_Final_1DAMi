package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controlador.LoginControlador;
import modelo.Product;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;

public class WorkerOptions extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JLabel WelcomeLabel;
	private Map<String, Product> mapa;
	private LoginControlador cont;
	private JButton DELETE_PRODUCT;
	private JButton UPDATE_PRODUCT;
	private JButton IMPORT_PRODUCT;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	
	public WorkerOptions(LoginControlador cont) {
		setModal(rootPaneCheckingEnabled);
		setIconImage(Toolkit.getDefaultToolkit().getImage(WorkerOptions.class.getResource("/images/media-markt-1.png")));
		setTitle("Worker's options");
		this.cont=cont;
		setBounds(100, 100, 450, 245);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setBorder(new LineBorder(new Color(189, 0, 0), 15));


		WelcomeLabel = new JLabel("WELCOME TO THE WORKERS PAGE!!!!");
		WelcomeLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
		WelcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		WelcomeLabel.setBounds(70, 13, 303, 48);
		contentPanel.add(WelcomeLabel);


		DELETE_PRODUCT = new JButton("DELETE PRODUCT");
		DELETE_PRODUCT.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		DELETE_PRODUCT.setBounds(131, 113, 153, 33);
		contentPanel.add(DELETE_PRODUCT);
		DELETE_PRODUCT.addActionListener(this);

		UPDATE_PRODUCT = new JButton("UPDATE PRODUCT PRICE");
		UPDATE_PRODUCT.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		UPDATE_PRODUCT.setBounds(110, 71, 200, 33);
		contentPanel.add(UPDATE_PRODUCT);
		UPDATE_PRODUCT.addActionListener(this);

		IMPORT_PRODUCT = new JButton("IMPORT PRODUCT");
		IMPORT_PRODUCT.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		IMPORT_PRODUCT.setBounds(131, 156, 153, 33);
		contentPanel.add(IMPORT_PRODUCT);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(WorkerOptions.class.getResource("/images/Delete.png")));
		lblNewLabel.setBounds(294, 113, 30, 22);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(WorkerOptions.class.getResource("/images/Update2.png")));
		lblNewLabel_1.setBounds(64, 71, 58, 33);
		contentPanel.add(lblNewLabel_1);
		IMPORT_PRODUCT.addActionListener(this);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==DELETE_PRODUCT) {
			DeleteProduct v= new DeleteProduct(cont);
			v.setVisible(true);
		}
		if(e.getSource()==UPDATE_PRODUCT) {
			UpdateProductPrice v= new UpdateProductPrice(cont);
			v.setVisible(true);
		}
		if(e.getSource()==IMPORT_PRODUCT) {
			ImportProduct v= new ImportProduct(cont);
			v.setVisible(true);
		}

	}
	
	
	
}