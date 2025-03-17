package clases;

public class Cliente {
	private String nombre_cliente;
	private String contraseña;
	private String id_cliente;
	
	public Cliente(String cliente, String passwd, String id) {
		this.nombre_cliente=cliente;
		this.contraseña=passwd;
		this.id_cliente=id;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}

	@Override
	public String toString() {
		return "Cliente [nombre_cliente=" + nombre_cliente + ", contraseña=" + contraseña + ", id_cliente=" + id_cliente
				+ "]";
	}
	
}
