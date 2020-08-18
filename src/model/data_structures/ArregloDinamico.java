package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico<T extends Comparable<T>> implements IArregloDinamico<T> {
		/**
		 * Capacidad maxima del arreglo
		 */
        private int tamanoMax;
		/**
		 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
		 */
        private int tamanoAct;
        /**
         * Arreglo de elementos de tamaNo maximo
         */
        private Object[] elementos;

        /**
         * Construir un arreglo con la capacidad maxima inicial.
         * @param max Capacidad maxima inicial
         */
		public ArregloDinamico( int max )
        {
               elementos = new Object[max];
               tamanoMax = max;
               tamanoAct = 0; 
        }
        
		public void agregar( T dato )
        {
               if ( tamanoAct == tamanoMax )
               {  // caso de arreglo lleno (aumentar tamaNo)
                    tamanoMax = 2 * tamanoMax;
                    Object[] copia = elementos;
                    elementos = new Object[tamanoMax];
                    for ( int i = 0; i < tamanoAct; i++)
                    {
                     	 elementos[i] = copia[i];
                    } 
            	    System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
               }	
               elementos[tamanoAct] = dato;
               tamanoAct++;
       }

		public int darCapacidad() {
			return tamanoMax;
		}

		public int darTamano() {
			return tamanoAct;
		}

		public T darElemento(int i) {
			// TODO implementar
			T res = null;
			for(int pos = 0; pos < elementos.length; pos++)
			{
				if( pos == i)
				{
					res = (T) elementos[pos];
				}
			}
			return res;
		}

		public T buscar(T dato) {
			// TODO implementar
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			T res = null;
			boolean centinela = false; 
			for (int i = 0; i<elementos.length && !centinela; i++)
			{
				if( elementos[i] == dato)
				{
					res = dato;
					centinela = true; 
				}
			}
			return res; 
		}

		public T eliminar(T dato) {
			// TODO implementar
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			T res = null;
			boolean centinela = false;
			for (int i = 0; i < elementos.length && !centinela ; i++) {
	            if (elementos[i] == dato) {
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

}
