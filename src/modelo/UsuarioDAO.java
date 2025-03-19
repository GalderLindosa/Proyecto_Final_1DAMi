package modelo;

import java.util.Map;

public interface UsuarioDAO {
	public boolean comprobarCliente(Client client);
	public boolean comprobarTrabajador(Worker worker);
	
}
