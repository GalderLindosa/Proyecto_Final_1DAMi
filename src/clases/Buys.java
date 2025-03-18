package clases;

import java.time.LocalDate;

public class Buys {
	private LocalDate buying_date;
	private int amount;
	
	public Buys(LocalDate fecha, int amount) {
		this.buying_date=fecha;
		this.amount=amount;
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
