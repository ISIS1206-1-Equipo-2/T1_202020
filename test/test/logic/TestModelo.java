package test.logic;

import static org.junit.Assert.*;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {
	
	private Modelo<Integer> modelo;
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
		// TODO
		setUp2();
		assertEquals(CAPACIDAD, modelo.darTamano());
	}

	@Test
	public void testAgregar() {
		// TODO Completar la prueba
		setUp2();
		assertEquals("el elemento es incorrecto", "89", Integer.toString(modelo.buscar(89)));
		assertEquals("el elemento es incorrecto", "30", Integer.toString(modelo.buscar(30)));
		assertEquals("el elemento es incorrecto", "11", Integer.toString(modelo.buscar(11)));	
	}

	@Test
	public void testBuscar() {
		setUp2();
		// TODO Completar la prueba
		assertEquals("el elemento es incorrecto", "89", Integer.toString(modelo.buscar(89)));
		assertEquals("el elemento es incorrecto", "30", Integer.toString(modelo.buscar(30)));
		assertEquals("el elemento es incorrecto", "11", Integer.toString(modelo.buscar(11)));
	}

	@Test
	public void testEliminar() {
		setUp2();
		// TODO Completar la prueba
		assertEquals("el elemento no es eliminado", "89", Integer.toString(modelo.eliminar(89)));
		assertEquals(null, modelo.buscar(89));
	}

}
