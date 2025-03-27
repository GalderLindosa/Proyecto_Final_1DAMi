package controlador;

import modelo.ImplementacionBD;
import modelo.Product;
import modelo.UsuarioDAO;
import modelo.Worker;
import vista.VentanaInicio;
import vista.VentanaLogingClient;
import vista.VentanaLogingWorker;
import modelo.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class LoginControlador {
	UsuarioDAO dao = new ImplementacionBD();
	
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
	public boolean modificarPrecio(Product producto) {
		return dao.modificarPrecio(producto);
	}


}