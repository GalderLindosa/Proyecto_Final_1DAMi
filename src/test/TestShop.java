package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Shop;

class TestShop {

	private Shop shop;
	
	@BeforeEach
	void setUp() throws Exception {
		shop = new Shop("08:00", "20:00", "Barcelona");
	}

	@Test
	public void testGetOpeningHours() {
		assertEquals("08:00", shop.getopening_hours());
	}

	@Test
	public void testSetOpeningHours() {
		shop.setopening_hours("10:00");
		assertEquals("10:00", shop.getopening_hours());
	}
	
	@Test
	public void testGetClosingHours() {
		assertEquals("20:00", shop.getclosing_hours());
	}
	
	@Test
	public void testSetClosingHours() {
		shop.setclosing_hours("22:00");
		assertEquals("22:00", shop.getclosing_hours());
	}
	
	

	@Test
	public void testGetLocation() {
		assertEquals("Barcelona", shop.getUbicacion());
	}
	
	@Test
	public void testSetLocation() {
		shop.setUbicacion("Madrid");
		assertEquals("Madrid", shop.getUbicacion());
	}
	
	@Test
	public void testConstructorWithParameters() {
		assertEquals("08:00", shop.getopening_hours());
		assertEquals("20:00", shop.getclosing_hours());
		assertEquals("Barcelona", shop.getUbicacion());
	}
	
	
	@AfterEach
	void tearDown() throws Exception {
		shop = null;
	}
	
}
