package controlador;

import modelo.Client;
import modelo.ImplementacionBD;
import modelo.UsuarioDAO;
import modelo.Worker;
import vista.VentanaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class LoginControlador {
	UsuarioDAO dao = new ImplementacionBD();
	
	public void visualizarPantalla() {
		VentanaLogin ven = new VentanaLogin(this);
		ven.setVisible(true);	
	}
	public boolean comprobarCliente(Client cliente){
		return dao.comprobarCliente(cliente);	
	}
	public boolean comprobarTrabajador(Worker worker){
		return dao.comprobarTrabajador(worker);
	}
	public Map<String, Usuario> consultaUsuarios() {
		// TODO Auto-generated method stub
		return dao.consultaUsuarios();
	}
	public boolean borrarUsuario(String usuario) {
		return dao.borrarUsuario(usuario);
	}
	


}