package tarea2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Tarea 2
 * Programa que dado el fichero alumnos.csv y notas.csv, 
 * lea la  información de ambos ficheros y la almacene correctamente 
 * en una Base de Datos  gestionada por MySQL
 * 
 * A TENER EN CUENTA: Hay un SQL para crear la estructura en la misma carpeta
 *  
 * @author Manuel Prieto - Catherine Ballester
 */
public class Main {
	
	static MySQLAccess tareas = new MySQLAccess();
	
	/**
	 * Lee el archivo CSV de notas y los añade a la base de datos
	 * @throws Exception
	 */
	public static void leerNotas() throws Exception {
		String rutaFichero = "C:\\Users\\Zukhulento\\Google Drive\\Desarrollo Aplicaciones Multiplataforma\\Programación\\practica3\\practica3 copia\\src\\tarea2\\notas.csv";
		
		//Se crea el objeto File
		File fichero = new File(rutaFichero);
		try {
			Scanner f = new Scanner (fichero);//Llamamos al Scanner
			f.nextLine();
			while(f.hasNextLine()) {
				String linea = f.nextLine().trim();
				String[] lineaSeparada = linea.split(",");
				if(lineaSeparada[0].length() > 0) {
					int idNota = Integer.parseInt(lineaSeparada[0].trim());
					int idAlumno = Integer.parseInt(lineaSeparada[1].trim());
					String nombreAsignatura = lineaSeparada[2].trim();
					int nota = Integer.parseInt(lineaSeparada[3].trim());
					MySQLAccess.insertNota(idNota, idAlumno, nombreAsignatura, nota);
				}
			}
			
			System.out.println("Se han insertado los datos de notas correctamente");
			
			f.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Ha habido un error al intentar acceder al archivo para insertar datos de notas...");
		}
	}
	
	/**
	 * Lee el archivo CSV de alumnos y los añade a la base de datos
	 * @throws Exception
	 */
	public static void leerAlumnos() throws Exception {
		String rutaFichero = "C:\\Users\\Zukhulento\\Google Drive\\Desarrollo Aplicaciones Multiplataforma\\Programación\\practica3\\practica3 copia\\src\\tarea2\\alumnos.csv";
		
		// Se crea el objeto File
		File fichero = new File(rutaFichero);
		
		try {
			// Leemos los datos del fichero
			Scanner f = new Scanner (fichero);
			f.nextLine();
			
			while(f.hasNextLine()) {
				String linea = f.nextLine().trim();
				String[] lineaSeparada = linea.split(",");
				
				if(lineaSeparada[0].length() > 0) {
					int idAlumno = Integer.parseInt(lineaSeparada[0].trim());
					String nombre = lineaSeparada[1].trim();
					String apellidos = lineaSeparada[2].trim();
					String dni = lineaSeparada[3].trim();
					int edad = Integer.parseInt(lineaSeparada[4].trim());
					MySQLAccess.insertAlumno(idAlumno, nombre, apellidos, dni, edad);
				}
			}

			System.out.println("Se han insertado los datos de alumnos correctamente");
			
			f.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Ha habido un error al intentar acceder al archivo para insertar datos de alumnos...");
		}
	}

	/**
     * Método main que ejecuta el programa
     * @param args
     */
	public static void main(String[] args) throws Exception {
		
		// Seteamos la base de datos que vamos a utilizar
		// A TENER EN CUENTA: Hay un SQL para crear la estructura en la misma carpeta
		tareas.setDatabase("tarea2");
		
		leerAlumnos();
		leerNotas();
	}

}
 