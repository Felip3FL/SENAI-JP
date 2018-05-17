package br.exemplo.teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.exemplo.refinado.Recursividade;

public class RecursividadeTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testSoma() {
		//fail("Not yet implemented");
		assertEquals(55, Recursividade.soma(50));
	}

	@Test
	public void testPotencia() {
		//fail("Not yet implemented");
		assertEquals(55, Recursividade.potencia(3, 4));		
	}

}
