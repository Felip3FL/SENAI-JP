package br.exemplo.teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.exemplo.interfaces.Cubo;

public class CuboTest {

	Cubo cubo;
	
	@Before
	public void setUp() throws Exception {
		cubo = new Cubo(10);
	}

	@Test
	public void testCalculaVolume() {
		//fail("Not yet implemented");
		assertEquals(600, cubo.calculaVolume(), 0);
	}

	@Test
	public void testCalculaArea() {
		//fail("Not yet implemented");
		assertEquals(1000, cubo.calculaArea(), 0);
	}

}
