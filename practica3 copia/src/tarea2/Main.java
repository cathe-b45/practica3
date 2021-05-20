package tarea2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
	static MySQLAccess tarea2 = new MySQLAccess();
	public static void leerNotas() throws Exception {
		String rutaFichero = "/Users/catherine/Downloads/notas.csv";
		File fichero = new File(rutaFichero);//Se crea el File
		try {
			Scanner f = new Scanner (fichero);//Llamamos al Scanner
			f.nextLine();
			while(f.hasNextLine()) {
				String linea = f.nextLine().trim();
				String[] lineaSeparada = linea.split(",");
				int idNota = Integer.parseInt(lineaSeparada[0].trim());
				int idAlumno = Integer.parseInt(lineaSeparada[1].trim());
				String nombreAsignatura = lineaSeparada[2].trim();
				int nota = Integer.parseInt(lineaSeparada[3].trim());
				MySQLAccess.insertNota(idNota, idAlumno, nombreAsignatura, nota);
			}
			f.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Se han insertado los datos correctamente");
		}
	}
	
	public static void leerAlumnos() throws Exception {
		String rutaFichero = "/Users/catherine/Downloads/alumnos-2.csv";
		File fichero = new File(rutaFichero);//Se crea el File
		try {
			Scanner f = new Scanner (fichero);//Llamamos al Scanner
			f.nextLine();
			while(f.hasNextLine()) {
				String linea = f.nextLine().trim();
				String[] lineaSeparada = linea.split(",");
				int idAlumno = Integer.parseInt(lineaSeparada[0].trim());
				String nombre = lineaSeparada[1].trim();
				String apellidos = lineaSeparada[2].trim();
				String dni = lineaSeparada[3].trim();
				int edad = Integer.parseInt(lineaSeparada[4].trim());
				MySQLAccess.insertAlumno(idAlumno, nombre, apellidos, dni, edad);
			}
			f.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		tarea2.setDatabase("tarea2");
		leerAlumnos();
		leerNotas();
		System.out.println("Se han insertado los datos correctamente");
	}

}
 