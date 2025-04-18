package modelo;

import java.time.LocalDate;

public class Buys {
	private LocalDate buying_date;
	private int amount;
	private String product_ID;
	private int client_id;
	
	public Buys(LocalDate fecha, int amount, String prod, int client) {
		this.buying_date=fecha;
		this.amount=amount;
		this.client_id=client;
		this.product_ID=prod;
	}

	public String getProduct_ID() {
		return product_ID;
	}

	public void setProduct_ID(String product_ID) {
		this.product_ID = product_ID;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public LocalDate getBuying_date() {
		return buying_date;
	}

	public void setBuying_date(LocalDate buying_date) {
		this.buying_date = buying_date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Buys [buying_date=" + buying_date + ", amount=" + amount + "]";
	}


	
	
}
