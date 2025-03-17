package clases;

public class Trabajador {
	private String id_trabajador;
	private String contraseña;
	private String nombre;
	
	public Trabajador (String nom, String cont, String id) {
		this.nombre=nom;
		this.contraseña=cont;
		this.id_trabajador=id;
	}

	public String getId_trabajador() {
		return id_trabajador;
	}

	public void setId_trabajador(String id_trabajador) {
		this.id_trabajador = id_trabajador;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Trabajador [id_trabajador=" + id_trabajador + ", contraseña=" + contraseña + ", nombre=" + nombre + "]";
	}
	
	
}
