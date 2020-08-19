package model.logic;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private IArregloDinamico<Integer> datos;
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		datos = new ArregloDinamico<Integer>(7);
	}
	
	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public Modelo(int capacidad)
	{
		datos = new ArregloDinamico<Integer>(capacidad);
	}
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.darTamano();
	}
	
	/**
	 * Requerimiento de dar elemento en una posición especifica
	 * @param Posición de dato a buscar
	 * @return Elemento en la posición dada
	 */
	public Integer darElemento(int pos)
	{
		return datos.darElemento( pos );
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public <T> void agregar(Integer dato)
	{	
		datos.agregar(dato);
	}
	
	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public Integer buscar(Integer dato)
	{
		return datos.buscar(dato);
	}
	
	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public Integer eliminar(Integer dato)
	{
		return datos.eliminar(dato);
	}


}
