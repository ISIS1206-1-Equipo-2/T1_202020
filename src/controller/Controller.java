package controller;

import java.util.Scanner;

import com.opencsv.exceptions.CsvValidationException;

import model.logic.Cine;
import model.logic.Pelicula;
import view.View;

public class Controller {

	/* Instancia del Cine*/
	private Cine cine;
	
	/* Instancia de la Vista*/
	private View view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		cine = new Cine();
	}
		
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato;
		int respuesta;

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
				case 1:
					view.printMessage("--------- \nCrear Arreglo \nDar capacidad inicial del arreglo: ");
				    int capacidad = lector.nextInt();
				    cine = new Cine(capacidad); 
				    view.printMessage("Arreglo Dinamico creado");
				    view.printMessage("Numero actual de elementos " + cine.darTamano() + "\n---------");						
					break;

				//case 2:
					//view.printMessage("--------- \nDar cadena (simple) a ingresar: ");
					//dato = lector.next();
					//cine.agregar(dato);
					//view.printMessage("Dato agregado");
					//view.printMessage("Numero actual de elementos " + cine.darTamano() + "\n---------");						
					//break;

				case 3:
					view.printMessage("--------- \nDar posición a buscar: ");
					int pos = lector.nextInt();
					Pelicula act =  cine.buscar(pos);
					if ( act==null)
					{
						view.printMessage("Dato encontrado: "+ act.darTitulo());
					}
					else
					{
						view.printMessage("Dato NO encontrado");
					}
					view.printMessage("Numero actual de elementos " + cine.darTamano() + "\n---------");						
					break;

				case 4:
					view.printMessage("--------- \nDar posición a eliminar: ");
					pos = lector.nextInt();
					act =  cine.buscar(pos);
					if ( act==null)
					{
						view.printMessage("Dato eliminado "+ act.darTitulo());
					}
					else
					{
						view.printMessage("Dato NO eliminado");							
					}
					view.printMessage("Numero actual de elementos " + cine.darTamano() + "\n---------");						
					break;

				case 5: 
					view.printMessage("--------- \nContenido del Arreglo: ");
					view.printModelo(cine);
					view.printMessage("Numero actual de elementos " + cine.darTamano() + "\n---------");						
					break;	
					
				case 6: 
					view.printMessage("--------- \nCargando datos...");
				try {
					cine.cargarDatos();
				} catch (CsvValidationException e) {
					view.printMessage(e.getMessage());
				}
					view.printMessage("Datos cargados.");
					break;	
				
				case 7: 
					view.printMessage("--------- \nNombre de director:");
					dato = lector.next();
					String rta = cine.darMejoresPelículas(dato);
					view.printMessage(rta);
					break;	
					
				case 8: 
					view.printMessage("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					break;	

				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
