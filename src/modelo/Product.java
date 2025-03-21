package modelo;

public class Product {
	private String product_name;
	private double price;
	private int stock;
	private Product_Category category;
	private String product_id;
	
	public Product(String name, String id, double price, int stock, Product_Category type) {
		this.product_name=name;
		this.product_id=id;
		this.price=price;
		this.stock=stock;
		this.category=type;
	}

	public Product() {
		this.product_name="";
		this.product_id="";
		this.price=0;
		this.stock=0;
		this.category=category;
	}

	public String getproduct_name() {
		return product_name;
	}



	public void setproduct_name(String product_name) {
		this.product_name = product_name;
	}



	public String getproduct_id() {
		return product_id;
	}



	public void setproduct_id(String product_id) {
		this.product_id = product_id;
	}



	public double getprice() {
		return price;
	}

	public void setprice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Product_Category getcategory() {
		return category;
	}

	public void setcategory(Product_Category category) {
		this.category = category;
	}



	@Override
	public String toString() {
		return  " price: " + price + ", stock: " + stock + ", category : " + category + "id : " + product_id + "]";
	}


	
}
