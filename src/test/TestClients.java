package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Client;

class Testclient {
	
	private Client client;

	@BeforeEach
	void setUp() throws Exception {
		client = new Client("Leire", "1234");
	}
	
	@Test
	public void testGetClientName() {
		assertEquals("Leire", client.getclient_name());
	}
	
	@Test
	public void testSetClientName() {
		client.setclient_name("Jon");
		assertEquals("Jon", client.getclient_name());
	}
	
	@Test
	public void testGetClientPassword() {
		assertEquals("1234", client.getclient_password());
	}
	
	@Test
	public void testSetClientPassword() {
		client.setclient_password("4321");
		assertEquals("4321", client.getclient_password());
	}
	
	@Test
    public void testGetAge() {
        assertEquals(1, client.getclient_id());
    }

    @Test
    public void testSetAge() {
        client.setclient_id(2);
        assertEquals(2, client.getclient_id());
    }
	
    @Test
    public void testParameterizedConstructor1() {
        assertEquals("Leire", client.getclient_name());
        assertEquals("1234", client.getclient_password());
    }
    
    public void testParameterizedConstructor2() {
        assertEquals(1, client.getclient_id());
        assertEquals("1234", client.getclient_password());
    }
    
    public void testDefaultConstructor() {
        Client defaultClient = new Client();
        assertNull(defaultClient.getclient_name());
        assertNull(defaultClient.getclient_id());
        assertNull(defaultClient.getclient_password());
    }
    
    
	@AfterEach
	public void close() {
		client=null;
	}
	
}
