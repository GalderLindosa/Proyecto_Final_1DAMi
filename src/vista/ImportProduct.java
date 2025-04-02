package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.LoginControlador;
import modelo.Product;
import modelo.Product_Category;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;

public class ImportProduct extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField ProductID;
	private JTextField ProductName;
	private JLabel NameLabel;
	private JLabel IDLabel;
	private JLabel PriceLabel;
	private JLabel StockLabel;
	private JSpinner PriceSpinner;
	private JSpinner StockSpinner;
	private JComboBox ProductCategory;
	private LoginControlador cont;
	private JButton AddButton;
	private JLabel CategoryLabel;
	private JLabel WelcomeLabel;
	private Product_Category categoria;
	private Map<String, Product> mapa;
	private JLabel Importedlabel;

	public ImportProduct(LoginControlador cont) {
		setModal(rootPaneCheckingEnabled);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ImportProduct.class.getResource("/images/media-markt-1.png")));
		this.cont=cont;
		setModal(rootPaneCheckingEnabled);
		setBounds(100, 100, 450, 522);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			NameLabel = new JLabel("Name");
			NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
			NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			NameLabel.setBounds(39, 139, 136, 28);
			contentPanel.add(NameLabel);
		}
		{
			IDLabel = new JLabel("ID");
			IDLabel.setHorizontalAlignment(SwingConstants.CENTER);
			IDLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			IDLabel.setBounds(39, 71, 136, 28);
			contentPanel.add(IDLabel);
		}
		{
			PriceLabel = new JLabel("Price");
			PriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
			PriceLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			PriceLabel.setBounds(39, 202, 136, 28);
			contentPanel.add(PriceLabel);
		}
		{
			StockLabel = new JLabel("Stock");
			StockLabel.setHorizontalAlignment(SwingConstants.CENTER);
			StockLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			StockLabel.setBounds(39, 280, 136, 28);
			contentPanel.add(StockLabel);
		}
		{
			CategoryLabel = new JLabel("Category");
			CategoryLabel.setHorizontalAlignment(SwingConstants.CENTER);
			CategoryLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			CategoryLabel.setBounds(39, 344, 136, 28);
			contentPanel.add(CategoryLabel);
		}
		{
			WelcomeLabel = new JLabel("Introduce the product info");
			WelcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
			WelcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			WelcomeLabel.setBounds(63, 22, 296, 28);
			contentPanel.add(WelcomeLabel);
		}

		ProductID = new JTextField();
		ProductID.setBounds(210, 71, 136, 28);
		contentPanel.add(ProductID);
		ProductID.setColumns(10);

		ProductName = new JTextField();
		ProductName.setColumns(10);
		ProductName.setBounds(210, 146, 136, 28);
		contentPanel.add(ProductName);

		PriceSpinner = new JSpinner();
		PriceSpinner.setModel(new SpinnerNumberModel(Double.valueOf(0), Double.valueOf(0), null, Double.valueOf(5)));
		PriceSpinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PriceSpinner.setBounds(234, 203, 65, 28);
		contentPanel.add(PriceSpinner);

		StockSpinner = new JSpinner();
		StockSpinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
		StockSpinner.setBounds(234, 281, 65, 28);
		contentPanel.add(StockSpinner);

		ProductCategory = new JComboBox();
		ProductCategory.setModel(new DefaultComboBoxModel(Product_Category.values()));
		ProductCategory.setToolTipText("");
		ProductCategory.setBounds(210, 346, 200, 28);
		contentPanel.add(ProductCategory);

		AddButton = new JButton("Add product");
		AddButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		AddButton.setBounds(129, 401, 162, 28);
		contentPanel.add(AddButton);
		
		Importedlabel = new JLabel("");
		Importedlabel.setHorizontalAlignment(SwingConstants.CENTER);
		Importedlabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Importedlabel.setBounds(25, 439, 368, 36);
		contentPanel.add(Importedlabel);
		AddButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==AddButton) {
			categoria=SetEnum();
			if(cont.insertProduct(new Product(ProductID.getText(), ProductName.getText(), (double) PriceSpinner.getValue(), (int) StockSpinner.getValue(), categoria ))) {
				Importedlabel.setText("SE HA IMPORTADO EL ERROR CORRECTAMENTE");
			}
			else {
				Importedlabel.setText("ERROR, NO SE HA PODIDDO IMPORTAR EL OBJETO A LA TIENDA");
			}
		}
	}

	public Product_Category SetEnum() {

		if(ProductCategory.getSelectedItem().toString()=="HOMEAPPLIANCES") {
			categoria= Product_Category.HOMEAPPLIANCES;
		}
		if(ProductCategory.getSelectedItem().toString().equalsIgnoreCase("COMPUTING")) {
			categoria= Product_Category.COMPUTING;
		}
		if(ProductCategory.getSelectedItem().toString().equalsIgnoreCase("HOME")) {
			categoria = Product_Category.HOME;
		}
		return categoria;
	}
}
