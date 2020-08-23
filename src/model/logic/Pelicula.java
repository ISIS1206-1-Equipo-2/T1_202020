package model.logic;

import java.util.ArrayList;
import java.util.Date;

public class Pelicula implements Comparable<Pelicula>{
	
	 private int id;
	 private int valoracion;
	 private String title;
	 private String genero; 
	 private Date release;
	 private String[] actores;
	 private String director;
	 private boolean buena;
	 
	 public Pelicula( int pid,String ptitle,String pgenero,Date prelease,ArrayList<String> pactores,String pdirector, int pvaloracion)
	 {
		 id= pid;
		 valoracion= pvaloracion;
		 title=ptitle;
		 genero=pgenero; 
		 release=prelease;
		 for(int i = 0; i<pactores.size();i++)
		 {
			 actores[i]=pactores.get(i);
		 }
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
		 respuesta += "actores: " + actores[0] + '\n';
		 for(int i=1; i<actores.length-1; i++)
		 {
			 respuesta+="         " + actores[i]+ '\n';
		 }
		 
		 return (respuesta +'\n');
	 }

	@Override
	public int compareTo(Pelicula o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
