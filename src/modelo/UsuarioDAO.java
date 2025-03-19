package modelo;

import java.util.Map;

public interface UsuarioDAO {
	public boolean comprobarCliente(Client client);
	public boolean comprobarTrabajador(Worker worker);
	public boolean insertarUsuario(Usuario usuario);
	public Map<String, Usuario> consultaUsuarios(); 
	public boolean borrarUsuario(String usuario) ;
	
}
