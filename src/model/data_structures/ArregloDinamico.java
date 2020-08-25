package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico <T extends Comparable<T>> implements IArregloDinamico<T> {
	/**
	 * Capacidad maxima del arreglo.
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0).
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo.
	 */
	private T elementos[];

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial.
	 */
	public ArregloDinamico( int max )
	{
		elementos = (T[]) new Comparable[max];
		tamanoMax = max;
		tamanoAct = 0;
	}

	/**
	 * Agrega un elemento al principio del arreglo.
	 * @param element Elemento a agregar.
	 */
	public void addFirst( T element )
	{			
		T[] copia = (T[]) elementos;
		if ( tamanoAct == tamanoMax )
		{  	maxTamanio( ); }
		for ( int i = 1; i < tamanoAct; i++)
		{
			elementos[i] = (T) copia[i-1];
		} 
		elementos[0] = element;
		tamanoAct++;
	}

	/**
	 * Agrega un elemento al final del arreglo.
	 * @param element Elemento a agregar.
	 */
	public void addLast( T element )
	{
		T[] copia = (T[]) elementos;
		if ( tamanoAct == tamanoMax )
		{  	maxTamanio( ); 
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = (T) copia[i];
			} 
		}	
		elementos[tamanoAct] = element;
		tamanoAct++;
	}

	/**
	 * Agrega un elemento en una posici�n v�lida.
	 * @param element Elemento a agregar.
	 * @param pos Posici�n en donde se va a agregar el elemento.
	 */
	public void insertElement(T element, int pos) {
		T[] copia = (T[]) elementos;
		elementos = (T[]) new Comparable[copia.length];
		if ( tamanoAct == tamanoMax ) { maxTamanio( );}		
		for ( int i = 1, j=1; i <= tamanoAct+1; i++){
			if( i == pos){
				elementos[i-1] = element;
				j++;
			}
			else{
				elementos[i-1] = (T) copia[i-j]; 
			}
		} 
		tamanoAct++;
	}

	/**
	 * Elimina el primer elemento en el arreglo.
	 * @return res Elemento eliminado.
	 */
	public T removefirst( )
	{
		T res;
		if(elementos.length == 0){ res = null; }
		else{
			res = elementos[0];
			for( int i = 0; i < elementos.length-1; i++)
			{
				elementos[i] = elementos[i+1];
			}
			elementos[elementos.length-1] = null;
			tamanoAct--;
		}
		return res;
	}

	/**
	 * Elimina el �ltimo elemento en el arreglo.
	 * @return res Elemento eliminado.
	 */
	public T removeLast( )
	{
		T res = elementos[elementos.length-1];
		elementos[elementos.length-1] = null;
		tamanoAct--;
		return res;
	}

	/**
	 * Elimina el elemento de una posici�n v�lida.
	 * @return res Elemento eliminado.
	 */
	public T deleteElement(int pos) {
		T res = null;
		boolean centinela = false;
		for (int i = 0; i < elementos.length && !centinela ; i++) {
			if (i+1 == pos) {
				res = (T) elementos[i];
				centinela = true; 
				for (int j = i; j < elementos.length - 1; j++) {
					elementos[j] = elementos[j+1];
				}
				elementos[elementos.length - 1] = null;
				tamanoAct--;
			}
		}
		return res; 
	}
	
	/**
	 * Retorna el primer elemento del arreglo.
	 * @return Primer elemento del arreglo.
	 */
	public T firstElement( )
	{
		return elementos[0];
	}

	/**
	 * Retorna el �ltimo elemento del arreglo.
	 * @return �ltimo elemento del arreglo.
	 */
	public T lastElement( )
	{
		return elementos[tamanoAct];
	}
	
	/**
	 * Retorna el elemento que se encuentra en la posici�n dada
	 * @return Elemento en la posici�n dada.
	 */
	public T getElemento(int i) {
		// TODO implementar
		return (i>0 && i<=elementos.length)?elementos[i-1]:null;
	}

	/**
	 * Busca un elemento en el arreglo.
	 * @return Elemento encontrado. En caso tal que no se encuentr�, retorna null.
	 */
	public T findElement(T dato) {
		T rta = null;
		for(int i=0;i<tamanoAct-1 && rta == null;i++)
		{
			T elemento =elementos[i];
			if(dato.compareTo(elemento)==0)
			{
				rta=elemento;
			}
		}
		return rta;
	}
	
	/**
	 * Retorna el tama�o del arreglo.
	 * @return Tama�o del arreglo.
	 */
	public int size( )
	{
		return tamanoAct;
	}
	
	/**
	 * Verifica si el arreglo est� vac�o.
	 * @return true si el arreglo se encuentra vac�o, de lo contrario false.
	 */
	public boolean isEmpty( )
	{
		return (size()==0)?true:false;
	}
	
	/**
	 * Busca un elemento y retorna su posici�n.
	 * @return res Posici�n del elemento buscado. Si no se encuentra retorna -1.
	 */
	public int isPresent( T element)
	{
		int res = -1;
		boolean cent = false; 
		for(int i = 0; i<elementos.length && !cent; i++)
		{
			if(elementos[i] !=null)	
			{
				if(elementos[i].compareTo(element) == 0)
				{
					res = i+1;
					cent = true;
				}
			}
		}
		return res; 
	}
	
	/**
	 * Intercambia dos elementos del arreglo.
	 */
	public void exchange( int pos1, int pos2)
	{
		T one = null;
		T two = null;
		boolean cent = false; 
		int cont = 0;
		
		for( int i = 1; i<elementos.length && !cent; i++)
		{
			if(i==pos1) {one = elementos[i-1]; cont++;}
			else if(i==pos2) {two = elementos[i-1]; cont++;}
			else if( cont == 2){ 
				cent = true;
				elementos[pos1-1] = two;
				elementos[pos2-1] = one;
			}
		}
	}
	
	/**
	 * Cambia un elemento dada una posici�n valida en el arreglo.
	 */
	public void changeInfo( int pos, T elem)
	{
		if(pos>0 && pos<=elementos.length)
		{
			elementos[pos-1] = elem;
		}
	}
	
	/**
	 * Aumenta el arreglo cuando se encuentra lleno.
	 */
	private void maxTamanio( )
	{
		tamanoMax = 2 * tamanoMax;
		elementos = (T[]) new Comparable[tamanoMax];
		System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
	}
}
