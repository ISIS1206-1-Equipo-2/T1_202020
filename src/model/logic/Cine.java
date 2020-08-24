package model.logic;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;

public class Cine 
{
	private IArregloDinamico peliculas;
	private int tamañoMax=1000;
	
	public Cine()
	{
		peliculas = new ArregloDinamico<Pelicula>(tamañoMax);
	}
	
	public Cine(int tamano)
	{
		peliculas = new ArregloDinamico<Pelicula>(tamano);

	}
	
	public void cargarDatos() throws CsvValidationException
	{
		try {
		    // create a reader
		    //Reader reader = Files.newBufferedReader(Paths.get("data/MoviesCastingRaw-small.csv"));

		    // create csv reader
			 Reader reader = Files.newBufferedReader(Paths.get("data/MoviesCastingRaw-small.csv"));
			 CSVParser parser = new CSVParserBuilder()
				        .withSeparator(';')
				        .build();

				CSVReader csvReader = new CSVReaderBuilder(reader)
				        .withSkipLines(1)
				        .withCSVParser(parser)
				        .build();
		            
		    // create csv reader
				Reader reader2 = Files.newBufferedReader(Paths.get("data/SmallMoviesDetailsCleaned.csv"));
				 CSVParser parser2 = new CSVParserBuilder()
					        .withSeparator(';')
					        .build();

					CSVReader csvReader2 = new CSVReaderBuilder(reader2)
					        .withSkipLines(1)
					        .withCSVParser(parser2)
					        .build();
		    
		    // read one record at a time
		    String[] line = csvReader.readNext();
		    String[] line2 = csvReader2.readNext();
		    
		    while ( line != null) {
		    	ArrayList<String>actores=new ArrayList<String>();
		    	for(int x=1; x<line.length-1; x+=2)
		    	{
		    		
		    		if(!line[x].equals("none"))
		    		{
		    			actores.add(line[x]);
		    		}
		    	}
		        Pelicula actual = new Pelicula (Integer.parseInt(line[0]),line2[5],line2[2],line2[10],actores,line[12],Double.parseDouble(line2[17]));
		        peliculas.addLast(actual);
		        line = csvReader.readNext();
			    line2 = csvReader2.readNext();

		    }

		    // close readers
		    csvReader.close();
		    csvReader2.close();

		} catch (IOException ex) {
		    ex.printStackTrace();
		}
	}
	
	public String darMejoresPelículas(String director)
	{
		double val_prom= 0;
		int cantidad= 0;
		String respuesta="";
		for(int i=0;i<peliculas.size();i++)
		{
			Pelicula act= (Pelicula) peliculas.getElemento(i+1);
			if(act.darDirector().contains(director))
			{
				if(act.esBuena())
				{
					cantidad++;
					val_prom+=act.darValoracion();
					respuesta+= act.toString();
				}
			}
		}
		if(val_prom!=0 && cantidad!=0)
			val_prom=val_prom/cantidad;
		
		return (respuesta + '\n' + "cantidad: " + cantidad + '\n' +"valoración promedio: " + val_prom + '\n');
	}

	public int darTamano() {
		return peliculas.size();
	}

	public void agregar(int dato) {
		
	}

	public Pelicula buscar(int pos) {
		return (Pelicula) peliculas.getElemento(pos);
	}
}
