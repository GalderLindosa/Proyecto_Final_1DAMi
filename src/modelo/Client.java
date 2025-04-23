package modelo;

public class Client {
	private String client_name;
	private String client_password;
	private int client_id;
	
	public Client(String cliente, String passwd) {
		this.client_name=cliente;
		this.client_password=passwd;
	}

	public Client (String passwd, int id) {
		this.client_password=passwd;
		this.client_id=id;
	}

	public Client () {
		this.client_name="";
		this.client_password="";
		this.client_id=0;
	}
	
	public String getclient_name() {
		return client_name;
	}

	public void setclient_name(String client_name) {
		this.client_name = client_name;
	}

	public String getclient_password() {
		return client_password;
	}

	public void setclient_password(String client_password) {
		this.client_password = client_password;
	}

	public int getclient_id() {
		return client_id;
	}

	public void setclient_id(int client_id) {
		this.client_id = client_id;
	}

	@Override
	public String toString() {
		return "Bienvenido " + client_name;
	}
	
}
