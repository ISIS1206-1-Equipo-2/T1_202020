package test.logic;

import static org.junit.Assert.*;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {
	
	private Modelo modelo;
	private static int CAPACIDAD=100;
	
	@Before
	public void setUp1() {
		modelo= new Modelo(CAPACIDAD);
	}

	public void setUp2() {
		for(int i =0; i< CAPACIDAD;i++){
			modelo.agregar(i);
		}
	}

	@Test
	public void testModelo() {
		assertTrue(modelo!=null);
		assertEquals(0, modelo.darTamano());  // Modelo con 0 elementos presentes.
	}

	@Test
	public void testDarTamano() {
		setUp2();
		// TODO
		int tamanio = modelo.darTamano();
		assertEquals( tamanio, CAPACIDAD);
	}

	@Test
	public void testAgregar() {
		// TODO Completar la prueba
		for( int i = 0; i<modelo.darTamano(); i++)
		{
			int num = modelo.buscar(i);
			assertEquals( i, num);
		}

	}

	@Test
	public void testBuscar() {
		setUp2();
		// TODO Completar la prueba
		for( int i = 0; i<CAPACIDAD; i++)
		{
			int elem = modelo.buscar(i);
			assertEquals(i, elem);
		}
	}

	@Test
	public void testEliminar() {
		setUp2();
		// TODO Completar la prueba
		for( int i = 0; i<CAPACIDAD; i++)
		{
			int eliminado = modelo.eliminar(i);
			assertNull(modelo.buscar(i));
			assertEquals(i, eliminado);
		}
		
	}

}
