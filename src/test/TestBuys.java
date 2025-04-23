package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Buys;

class TestBuys {

	private Buys buys;
	
	@BeforeEach
	void setUp() throws Exception {
		buys = new Buys(LocalDate.now(),1,"PROD001",1);
	}


	@Test
	public void testGetProduct_ID() {
		assertEquals("PROD001", buys.getProduct_ID());
	}
	
	@Test
	public void testSetProduct_ID() {
		buys.setProduct_ID("PROD002");
		assertEquals("PROD002", buys.getProduct_ID());
	}

	@Test
	public void testGetClientID() {
		assertEquals(1, buys.getClient_id());
	}
	
	@Test
	public void testSetClientID() {
		buys.setClient_id(2);
		assertEquals(2, buys.getClient_id());
	}

	@Test
	public void testGetAmount() {
		assertEquals(1, buys.getAmount());
	}
	
	@Test
	public void testSetAmount() {
		buys.setAmount(1);
		assertEquals(1, buys.getAmount());
	}
	
	
    @Test
    public void testParameterizedConstructor() {
        assertEquals("PROD001", buys.getProduct_ID());
        assertEquals(1, buys.getClient_id());
        assertEquals(1, buys.getAmount());
        assertEquals(LocalDate.now(), buys.getBuying_date());
    }
	
	
	
	@AfterEach
	public void close() {
		buys=null;
	}
	
}
