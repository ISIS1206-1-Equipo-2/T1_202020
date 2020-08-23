package model.data_structures;

public interface IArregloDinamico <T extends Comparable<T>> {
	
	/**
	 * Agrega un elemento al principio del arreglo.
	 * @param element Elemento a agregar.
	 */
	public void addFirst( T element);
	
	/**
	 * Agrega un elemento al final del arreglo.
	 * @param element Elemento a agregar.
	 */
	public void addLast( T element );
	
	/**
	 * Agrega un elemento en una posición válida.
	 * @param element Elemento a agregar.
	 * @param pos Posición en donde se va a agregar el elemento.
	 */
	public void insertElement(T element, int pos);
	
	/**
	 * Elimina el primer elemento en el arreglo.
	 * @return res Elemento eliminado.
	 */
	T removefirst( );
	
	/**
	 * Elimina el último elemento en el arreglo.
	 * @return res Elemento eliminado.
	 */
	 T removeLast( );
	 
	/**
	 * Elimina el elemento de una posición válida.
	 * @return res Elemento eliminado.
	 */
	 T deleteElement(int pos);
	 
	/**
	 * Retorna el primer elemento del arreglo.
	 * @return Primer elemento del arreglo.
	 */
     T firstElement( );
     
    /**
 	 * Retorna el último elemento del arreglo.
 	 * @return último elemento del arreglo.
 	 */
 	 T lastElement( );
 	 
 	/**
 	 * Retorna el elemento que se encuentra en la posición dada
 	 * @return Elemento en la posición dada.
 	 */
 	 T getElemento(int i);
 	
 	/**
	 * Busca un elemento en el arreglo.
	 * @return Elemento encontrado. En caso tal que no se encuentré, retorna null.
	 */
	 T findElement(T dato);
	
	/**
	 * Retorna el tamaño del arreglo.
	 * @return Tamaño del arreglo.
	 */
	 int size( );
	
	/**
	 * Verifica si el arreglo está vacío.
	 * @return true si el arreglo se encuentra vacío, de lo contrario false.
	 */
	 boolean isEmpty( );
	 
	/**
	 * Busca un elemento y retorna su posición.
	 * @return res Posición del elemento buscado. Si no se encuentra retorna -1.
	 */
	 int isPresent( T element);
	 
	 /**
	  * Intercambia dos elementos del arreglo.
	  */
	 public void exchange( int pos1, int pos2);
	 
	 /**
	  * Cambia un elemento dada una posición valida en el arreglo.
	  */
	 public void changeInfo( int pos, T elem);	 
}
