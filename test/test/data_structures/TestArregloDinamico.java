package test.data_structures;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestArregloDinamico {

	private ArregloDinamico<Integer> arreglo;
	private static int TAMANO=100;
	
	@Before
	public void setUp1() {
		arreglo = new ArregloDinamico<Integer>(TAMANO);
	}

	public void setUp2() {
		for(int i =0; i< TAMANO*2; i++){
			arreglo.agregar(i);
		}
	}

	@Test
	public void testArregloDinamico() {
		// TODO
		assertTrue(arreglo!=null);
		assertEquals(0, arreglo.darTamano());  // Modelo con 0 elementos presentes.
	}

	@Test
	public void testDarElemento() {
		setUp2();
		// TODO
		for(int i = 0; i<TAMANO*2; i++)
		{
			int elemento = arreglo.darElemento(i);
			assertEquals(elemento, i);
		}
	}
}
