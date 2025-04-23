package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Worker;

class TestWorker {
	
	private Worker worker;
	
	@BeforeEach
	void setUp() throws Exception {
		worker = new Worker("Hugo", "123", "EMP001");
	}

	

	@Test
	public void testGetWorkerName() {
		assertEquals("Hugo", worker.getworker_name());
	}
	
	@Test
	public void testSetWorkerName() {
		worker.setworker_name("Galder");
		assertEquals("Galder", worker.getworker_name());
	}

	
	@Test
	public void testGetWorkerPassword() {
		assertEquals("123", worker.getworker_password());
	}
	
	@Test
	public void testSetWorkerPassword() {
		worker.setworker_password("321");
		assertEquals("321", worker.getworker_password());

	}
	
	
	@Test
	
	public void testGetWorkerID() {
		assertEquals("EMP001", worker.getId_trabajador());
	}
	
	@Test
	public void testSetWorkerID() {
		worker.setId_trabajador("EMP100");
		assertEquals("EMP100", worker.getId_trabajador());
	}
	
	
	@Test
	public void testConstructorWithParameters() {
		assertEquals("Hugo", worker.getworker_name());
		assertEquals("123", worker.getworker_password());
		assertEquals("EMP001", worker.getId_trabajador());
	}
	
	@Test
	public void testConstructorForWorkerLogin() {
		assertEquals("123", worker.getworker_password());
		assertEquals("EMP001", worker.getId_trabajador());
	}
	
	
	
	@AfterEach
	void tearDown() throws Exception {
		
		worker=null;
	}
	
	
}
