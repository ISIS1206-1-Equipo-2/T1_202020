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
	 * Agrega un elemento en una posici�n v�lida.
	 * @param element Elemento a agregar.
	 * @param pos Posici�n en donde se va a agregar el elemento.
	 */
	public void insertElement(T element, int pos);
	
	/**
	 * Elimina el primer elemento en el arreglo.
	 * @return res Elemento eliminado.
	 */
	T removefirst( );
	
	/**
	 * Elimina el �ltimo elemento en el arreglo.
	 * @return res Elemento eliminado.
	 */
	 T removeLast( );
	 
	/**
	 * Elimina el elemento de una posici�n v�lida.
	 * @return res Elemento eliminado.
	 */
	 T deleteElement(int pos);
	 
	/**
	 * Retorna el primer elemento del arreglo.
	 * @return Primer elemento del arreglo.
	 */
     T firstElement( );
     
    /**
 	 * Retorna el �ltimo elemento del arreglo.
 	 * @return �ltimo elemento del arreglo.
 	 */
 	 T lastElement( );
 	 
 	/**
 	 * Retorna el elemento que se encuentra en la posici�n dada
 	 * @return Elemento en la posici�n dada.
 	 */
 	 T getElemento(int i);
 	
 	/**
	 * Busca un elemento en el arreglo.
	 * @return Elemento encontrado. En caso tal que no se encuentr�, retorna null.
	 */
	 T findElement(T dato);
	
	/**
	 * Retorna el tama�o del arreglo.
	 * @return Tama�o del arreglo.
	 */
	 int size( );
	
	/**
	 * Verifica si el arreglo est� vac�o.
	 * @return true si el arreglo se encuentra vac�o, de lo contrario false.
	 */
	 boolean isEmpty( );
	 
	/**
	 * Busca un elemento y retorna su posici�n.
	 * @return res Posici�n del elemento buscado. Si no se encuentra retorna -1.
	 */
	 int isPresent( T element);
	 
	 /**
	  * Intercambia dos elementos del arreglo.
	  */
	 public void exchange( int pos1, int pos2);
	 
	 /**
	  * Cambia un elemento dada una posici�n valida en el arreglo.
	  */
	 public void changeInfo( int pos, T elem);	 
}
