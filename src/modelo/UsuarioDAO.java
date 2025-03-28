package modelo;

import java.util.Map;

public interface UsuarioDAO {
	public boolean comprobarCliente(Client client);
	public boolean comprobarTrabajador(Worker worker);
	public boolean insertClient(Client client);
	public boolean borrarProducto(Product producto);
	public Map<String,ShowBuys> mostrarCompras();
	public Map<String, Product> MostrarProducto();
}
