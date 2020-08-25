package test.data_structures;

import model.data_structures.ArregloDinamico;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestArregloDinamico {

	private ArregloDinamico arreglo;
	private static int TAMANO=100;
	
	@Before
	public void setUp1() {
		arreglo= new ArregloDinamico(TAMANO);
	}

	public void setUp2() {
		for(int i =0; i< TAMANO*2; i++){
			arreglo.addLast(""+i);
		}
	}

	@Test
	public void testArregloDinamico() {
		assertTrue(arreglo!=null);
		assertEquals(0, arreglo.size());
		
	}

	@Test
	public void addFirst() {
		setUp2();
		for(int i = 200; i<299; i++)
		{
			String first = ""+i;
			arreglo.addFirst(first);
			assertEquals("El elemento es incorrecto",1, arreglo.isPresent(first));
		}
	}
	
	@Test
	public void addLast() {
		setUp2();
		for(int i = 200; i<299; i++)
		{
			String last = ""+i;
			arreglo.addLast(last);
			assertEquals("El elemento es incorrecto", arreglo.size(), arreglo.isPresent(last));
		}
	}
	
	@Test
	public void insertElement() {
		setUp2();
		arreglo.insertElement("200", 1);
		assertEquals("El elemento encontrado no coincide", 1, arreglo.isPresent("200"));
		assertEquals("La lista fallo al correr la posición", 2, arreglo.isPresent("0"));

		arreglo.insertElement("201", 4);
		assertEquals("La lista fallo al correr la posición", 3, arreglo.isPresent("1"));
		assertEquals("El elemento encontrado no coincide", 4, arreglo.isPresent("201"));
		assertEquals("La lista fallo al correr la posición", 5, arreglo.isPresent("2"));
	}
	
	@Test
	public void removefirst() {
		setUp2();
		String e = (String) arreglo.removefirst();
		assertEquals("El elemento se elimino incorrectamente",-1, arreglo.isPresent(e));
		assertEquals("Las posiciones están corridas incorrectamente", arreglo.isPresent("1"), 1);
	}
	
	@Test
	public void removeLast() {
		setUp2();
		String e = (String) arreglo.removefirst();
		assertEquals("El último elemento se eliminó incorrectamente",-1, arreglo.isPresent(e));
	}
	
	@Test
	public void firstElement() {
		setUp2();
		assertEquals("No retornó el primer elemento", "0", arreglo.firstElement());
	}
	
	@Test
	public void getElemento() {
		setUp2();
		for( int i = 1; i<50; i++)
		{
			int indice = i-1;
			assertEquals("El elemento no coincide",arreglo.getElemento(i),""+indice);
		}
	}
	
	@Test
	public void findElement() {
		setUp2();
		for( int i = 0; i<50; i++)
		{
			assertEquals("El elemento no coincide",arreglo.findElement(""+Integer.toString(i)),""+i);
		}
	}
	
	@Test
	public void size() {
		setUp2();
		assertEquals("El tamaño no coincide",200, arreglo.size() );
	}
	
	@Test
	public void isEmpty() {
		assertTrue("El arreglo se encuentra vacío", arreglo.isEmpty());
		setUp2();
		assertFalse("El arreglo no se encuentra vacío", arreglo.isEmpty());
	}
	
	@Test
	public void isPresent() {
		for(int i = 0; i < arreglo.size(); i++){
			assertEquals("La posición no coincide", i, Integer.toString(arreglo.isPresent(i)));
		}
	}
	
	@Test
	public void exchange() {
		setUp2();
		String elem1 = (String)arreglo.getElemento(1);
		String elem2 =(String) arreglo.getElemento(3);
		arreglo.exchange(1, 3);
		System.out.println(arreglo.getElemento(60));
		assertEquals("El intercambio no se ejecutó correctamente",elem1, arreglo.getElemento(3));
		assertEquals("El intercambio no se ejecutó correctamente", elem2, arreglo.getElemento(1));
	}
	
	@Test
	public void changeInfo() {
		arreglo.changeInfo(4,""+3);
		assertEquals("El cambio del elemento falló", arreglo.getElemento(4),""+3);
	}



}
