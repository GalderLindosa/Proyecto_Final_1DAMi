package modelo;

import java.util.ArrayList;

public class Client {
	private String client_name;
	private String client_password;
	private int client_id;
	private ArrayList <Buys> compras;

	
	public Client(String cliente, String passwd) {
		this.client_name=cliente;
		this.client_password=passwd;
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
		return "Cliente [client_name=" + client_name + ", client_password=" + client_password + ", client_id=" + client_id
				+ "]";
	}

	public ArrayList <Buys> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList <Buys> compras) {
		this.compras = compras;
	}
	
}
