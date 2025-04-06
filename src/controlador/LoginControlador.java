package controlador;

import modelo.ImplementacionBD;
import modelo.Product;
import modelo.ShowBuys;
import modelo.UserDAO;
import modelo.Worker;
import vista.VentanaInicio;
import vista.VentanaLogingClient;
import vista.VentanaLogingWorker;
import modelo.Buys;
import modelo.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class LoginControlador {
	UserDAO dao = new ImplementacionBD();

	public void visualizarPantalla() {
		VentanaInicio ven = new VentanaInicio(this);
		ven.setVisible(true);	
	}

	public boolean insertClient(Client client) {
		return dao.insertClient(client);
	}

	public boolean comprobarTrabajador(Worker worker) {
		return dao.comprobarTrabajador(worker);
	}

	public boolean comprobarCliente(Client client) {
		return dao.comprobarCliente(client);
	}
	
	public Map<String, Product> MostrarProducto(){
		return dao.MostrarProducto();
	}
	
	public boolean modificarPrecio (Product producto) {
		return dao.modificarPrecio(producto);
	}
	
	public boolean deleteProduct (String string) {
		return dao.deleteProduct(string);
	}
	
	public boolean insertProduct(Product producto) {
		return dao.insertProduct(producto);
	}

	public boolean borrarProducto(Product producto) {
		return dao.borrarProducto(producto);
	}

	public Map<String,ShowBuys> mostrarCompras() {
		return dao.mostrarCompras(); 
	}

}

