package modelo;

public class Worker {
	private String id_trabajador;
	private String worker_password;
	private String worker_name;
	
	public Worker (String nom, String cont, String id) {
		this.worker_name=nom;
		this.worker_password=cont;
		this.id_trabajador=id;
	}
	
	public Worker ( String cont, String id) {
		this.worker_password=cont;
		this.id_trabajador=id;
	}

	public Worker ( String cont, String id) {
		this.worker_password=cont;
		this.id_trabajador=id;
	}
	
	public String getId_trabajador() {
		return id_trabajador;
	}

	public void setId_trabajador(String id_trabajador) {
		this.id_trabajador = id_trabajador;
	}

	public String getworker_password() {
		return worker_password;
	}

	public void setworker_password(String worker_password) {
		this.worker_password = worker_password;
	}

	public String getworker_name() {
		return worker_name;
	}

	public void setworker_name(String worker_name) {
		this.worker_name = worker_name;
	}

	@Override
	public String toString() {
		return "Trabajador [id_trabajador=" + id_trabajador + ", worker_password=" + worker_password + ", worker_name=" + worker_name + "]";
	}
	
	
}
