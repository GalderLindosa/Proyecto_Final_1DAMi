package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Product;

class TestProduct {

	private Product product;
	@BeforeEach
	void setUp() throws Exception {
		product = new Product("PROD001","Lavadora Samsung",450.00,7,modelo.Product_Category.HOMEAPPLIANCES);
	}

	

	@Test
	public void testGetProductName() {
		assertEquals("Lavadora Samsung", product.getproduct_name());
	}

	@Test
	public void testSetProductName() {
		product.setproduct_name("Nintendo Switch");
		assertEquals("Nintendo Switch", product.getproduct_name());
	}
	
	
	@Test
	public void testGetProduct_ID() {
		assertEquals("PROD001", product.getproduct_id());
	}
	
	@Test
	public void testSetProduct_ID() {
		product.setproduct_id("PROD002");
		assertEquals("PROD002", product.getproduct_id());
	}
	
	@Test
	public void testGetPrize() {
		assertEquals(450.00, product.getprice());
	}
	
	@Test
	public void testSetPrize() {
		product.setprice(500.00);
		assertEquals(500.00, product.getprice());
	}
	
	@Test
	public void testGetStock() {
		assertEquals(7, product.getStock());
	}
	
	@Test
	public void testSetStock() {
		product.setStock(10);
		assertEquals(10, product.getStock());
	}
	
	@Test
	public void testGetCategory() {
		assertEquals("HOMEAPPLIANCES", product.getcategory());
	}
	
	@Test
	public void testSetCategory() {
		product.setcategory(modelo.Product_Category.HOME);
		assertEquals("HOME", product.getcategory());
	}
	
	

	@Test
	public void testConstructorWithParameters() {
		assertEquals("Lavadora Samsung", product.getproduct_name());
		assertEquals("PROD001", product.getproduct_id());
		assertEquals(450.00, product.getprice());
		assertEquals(7, product.getStock());
		assertEquals("HOMEAPPLIANCES", product.getcategory());
	}
	
	
	@Test
	public void testConstructorForPriceUpdate() {
		assertEquals("PROD001", product.getproduct_id());
		assertEquals(450.00, product.getprice());
	}
	
	
	
	@AfterEach
	void tearDown() throws Exception {
		product = null;
	}
	
}
