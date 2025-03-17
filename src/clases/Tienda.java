package clases;

public class Tienda {
	private String hora_apertura;
	private String ubicacion;
	private String hora_cierre;
	
	public Tienda(String apertura, String cierre, String localizacion) {
		this.hora_apertura=apertura;
		this.hora_cierre=cierre;
		this.ubicacion=localizacion;
	}

	public String getHora_apertura() {
		return hora_apertura;
	}

	public void setHora_apertura(String hora_apertura) {
		this.hora_apertura = hora_apertura;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getHora_cierre() {
		return hora_cierre;
	}

	public void setHora_cierre(String hora_cierre) {
		this.hora_cierre = hora_cierre;
	}

	@Override
	public String toString() {
		return "Tienda [hora_apertura=" + hora_apertura + ", ubicacion=" + ubicacion + ", hora_cierre=" + hora_cierre
				+ "]";
	}
	
	
}
