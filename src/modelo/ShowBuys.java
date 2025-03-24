package modelo;

import java.sql.Date;

public class ShowBuys {
	private Date Buying_Date;
	private int product_amount;
	private String name_c;
	
	public ShowBuys(Date buying_Date, int product_amount, String name_c) {
		Buying_Date = buying_Date;
		this.product_amount = product_amount;
		this.name_c = name_c;
	}

	
	
	public ShowBuys() {
		//constructor vacio 
	}



	public Date getBuying_Date() {
		return Buying_Date;
	}

	public void setBuying_Date(Date buying_Date) {
		Buying_Date = buying_Date;
	}

	public int getProduct_amount() {
		return product_amount;
	}

	public void setProduct_amount(int product_amount) {
		this.product_amount = product_amount;
	}

	public String getName_c() {
		return name_c;
	}

	public void setName_c(String name_c) {
		this.name_c = name_c;
	}

	@Override
	public String toString() {
		return "ShowBuys [Buying_Date=" + Buying_Date + ", product_amount=" + product_amount + ", name_c=" + name_c
				+ "]";
	}

	
	
	
}
