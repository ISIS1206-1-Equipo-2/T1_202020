package model.logic;

import java.util.ArrayList;
import java.util.Date;

public class Pelicula implements Comparable<Pelicula>{
	
	 private int id;
	 private Double valoracion;
	 private String title;
	 private String genero; 
	 private String release;
	 private ArrayList<String> actores =new ArrayList<String>();
	 private String director;
	 private boolean buena;
	 
	 public Pelicula( int pid,String ptitle,String pgenero,String date,ArrayList<String> pactores,String pdirector, double pvaloracion)
	 {
		 id= pid;
		 valoracion= pvaloracion;
		 title=ptitle;
		 genero=pgenero; 
		 release=date;
		 actores=pactores;
		 director=pdirector;
		 buena=(valoracion>=6);
	 }
	 
	 public String darDirector()
	 {
		 return director;
	 }
	 
	 public boolean esBuena()
	 {
		 return buena;
	 }
	 
	 public String toString()
	 {
		 String respuesta;
		 respuesta = "id: " + id + '\n';
		 respuesta += "titulo: " + title + '\n';
		 respuesta += "genero: " + genero + '\n';
		 respuesta += "release date: " + release + '\n';
		 respuesta += "actores: " + actores.get(0) + '\n';
		 for(int i=1; i<actores.size()-1; i++)
		 {
			 respuesta+="         " + actores.get(i)+ '\n';
		 }
		 
		 return (respuesta +'\n');
	 }
	 
	 public double darValoracion()
	 {
		 return valoracion;
	 }

	@Override
	public int compareTo(Pelicula o) {
		return (title.equals(o.title))?0:1;
	}

	public String darTitulo() {
		return title;
	}
}
