package clases;

public class Client {
	private String client_name;
	private String client_password;
	private String client_id;
	
	public Client(String cliente, String passwd, String id) {
		this.client_name=cliente;
		this.client_password=passwd;
		this.client_id=id;
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

	public String getclient_id() {
		return client_id;
	}

	public void setclient_id(String client_id) {
		this.client_id = client_id;
	}

	@Override
	public String toString() {
		return "Cliente [client_name=" + client_name + ", client_password=" + client_password + ", client_id=" + client_id
				+ "]";
	}
	
}
