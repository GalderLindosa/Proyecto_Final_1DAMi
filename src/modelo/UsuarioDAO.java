package modelo;

import java.util.Map;

import modelo.Product;

public interface UsuarioDAO {
	public boolean comprobarCliente(Client client);
	public boolean comprobarTrabajador(Worker worker);
	public boolean insertClient(Client client);
	public Map<String, Product> MostrarProducto();
	public boolean modificarPrecio(Product producto);

}
