package clases;

public class Producto {
	private String nombre;
	private double precio;
	private int stock;
	private Tipo_Producto tipo;
	
	public Producto(String name, double price, int stock, Tipo_Producto type) {
		this.nombre=name;
		this.precio=price;
		this.stock=stock;
		this.tipo=type;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Tipo_Producto getTipo() {
		return tipo;
	}

	public void setTipo(Tipo_Producto tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + ", tipo=" + tipo + "]";
	}
	
}
