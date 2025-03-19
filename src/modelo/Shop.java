package modelo;

public class Shop {
	private String opening_hours;
	private String ubicacion;
	private String closing_hours;
	
	public Shop(String apertura, String cierre, String localizacion) {
		this.opening_hours=apertura;
		this.closing_hours=cierre;
		this.ubicacion=localizacion;
	}

	public String getopening_hours() {
		return opening_hours;
	}

	public void setopening_hours(String opening_hours) {
		this.opening_hours = opening_hours;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getclosing_hours() {
		return closing_hours;
	}

	public void setclosing_hours(String closing_hours) {
		this.closing_hours = closing_hours;
	}

	@Override
	public String toString() {
		return "Tienda [opening_hours=" + opening_hours + ", ubicacion=" + ubicacion + ", closing_hours=" + closing_hours
				+ "]";
	}
	
	
}
