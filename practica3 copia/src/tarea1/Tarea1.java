package tarea1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tarea1 {
	public static void leerFichero() {
		//Se pasa la ruta del fichero
		String rutaFichero = "/Users/catherine/Downloads/texto.txt";
		File fichero = new File(rutaFichero);//se crea el file
		int numLineas = 0;
		int numCaracteres = 0;
		try {
			//se crea un scanner para leer el fichero
			Scanner f = new Scanner(fichero);
			while(f.hasNextLine()) {
				String linea = f.nextLine().replace(",", "").replace(".", "").replace(";", "").
						replace(":", "").replace("\\.", "").replace("()", "").toLowerCase().trim();
				////se crea un scanner para cada linea
				Scanner fLinea = new Scanner(linea);
				int longitudLinea = linea.length();
				while(fLinea.hasNext()) {
					String palabra = fLinea.next();
					//se crean condiciones para cada articulo
					if(palabra.equalsIgnoreCase("el")) {
						String siguientePalabra = fLinea.next();
						if (siguientePalabra.substring(siguientePalabra.length()-1).equals("s")) {
							System.out.println(palabra + " " +siguientePalabra + " ERROR");
						} else {
							System.out.println(palabra + " " +siguientePalabra + " ACIERTO");
						}
					} else if(palabra.equalsIgnoreCase("un")) {
						String siguientePalabra = fLinea.next();
						if (siguientePalabra.substring(siguientePalabra.length()-1).equals("s")) {
							System.out.println(palabra + " " +siguientePalabra + " ERROR");
						} else {
							System.out.println(palabra + " " +siguientePalabra + " ACIERTO");
						}
					} else if(palabra.equalsIgnoreCase("la")) {
						String siguientePalabra = fLinea.next();
						if (siguientePalabra.substring(siguientePalabra.length()-1).equals("s")) {
							System.out.println(palabra + " " +siguientePalabra + " ERROR");
						} else {
							System.out.println(palabra + " " +siguientePalabra + " ACIERTO");
						}
					} else if(palabra.equalsIgnoreCase("una")) {
						String siguientePalabra = fLinea.next();
						if (siguientePalabra.substring(siguientePalabra.length()-1).equals("s")) {
							System.out.println(palabra + " " +siguientePalabra + " ERROR");
						} else {
							System.out.println(palabra + " " +siguientePalabra + " ACIERTO");
						}
					} else if(palabra.equalsIgnoreCase("los")) {
						String siguientePalabra = fLinea.next();
						if (siguientePalabra.substring(siguientePalabra.length()-1).equals("s")) {
							System.out.println(palabra + " " +siguientePalabra + " ACIERTO");
						} else {
							System.out.println(palabra + " " +siguientePalabra + " ERROR");
						}
					} else if(palabra.equalsIgnoreCase("las")) {
						String siguientePalabra = fLinea.next();
						if (siguientePalabra.substring(siguientePalabra.length()-1).equals("s")) {
							System.out.println(palabra + " " +siguientePalabra + " ACIERTO");
						} else {
							System.out.println(palabra + " " +siguientePalabra + " ERROR");
						}
					} else if(palabra.equalsIgnoreCase("unos")) {
						String siguientePalabra = fLinea.next();
						if (siguientePalabra.substring(siguientePalabra.length()-1).equals("s")) {
							System.out.println(palabra + " " +siguientePalabra + " ACIERTO");
						} else {
							System.out.println(palabra + " " +siguientePalabra + " ERROR");
						}
					} else if(palabra.equalsIgnoreCase("unas")) {
						String siguientePalabra = fLinea.next();
						if (siguientePalabra.substring(siguientePalabra.length()-1).equals("s")) {
							System.out.println(palabra + " " +siguientePalabra + " ACIERTO");
						} else {
							System.out.println(palabra + " " +siguientePalabra + " ERROR");
						}
					}
				}
				//se cuentan los caracteres
				numCaracteres = numCaracteres + longitudLinea;
				numLineas++;//se cuentan las lineas
			}
			//se muestra por pantalla el numero de lineas y de caracteres
			System.out.println("Numero de lineas: "+numLineas);
			System.out.println("Numero de caracteres: "+numCaracteres);
			f.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No se ha podido leer el fichero");
		}

	}
	public static void leerFichero2() {
		//se crea un arrayList de las ocurrencias de cada numero de caracteres
		ArrayList<Ocurrencia> listaOcurrencias = new ArrayList<Ocurrencia>();
		String rutaFichero = "/Users/catherine/Downloads/texto.txt";
		//se crea un scanner para leer el fichero
		File fichero = new File(rutaFichero);
		int numCaracteres = 0;
		int caracteresPalabras = 0;
		int longitudLista = 0;
		try {
			Scanner f = new Scanner(fichero);
			while(f.hasNextLine()) {
				String linea = f.nextLine().replace(",", "").replace(".", "").replace(";", "").
						replace(":", "").replace("\\.", "").replace("()", "").toLowerCase().trim();
				Scanner fLinea = new Scanner(linea);
				while(fLinea.hasNext()) {
					String palabra = fLinea.next();
					//se cuentan los caracteres de cada palabra
					caracteresPalabras = palabra.length();
					boolean seHaAgregado = false;
					if (listaOcurrencias.size() == 0) {
						//se crea y se añade la primera ocurrencia a la lista
						Ocurrencia primeraOcurrencia = new Ocurrencia(1, caracteresPalabras);
						listaOcurrencias.add(primeraOcurrencia);
					} else {
						for(int i = 0; i < listaOcurrencias.size(); i++) {
							//se comprueba si en la lista hay mas palabras con el mismo num de caracteres y si hay se suma una ocurrencia
							if(caracteresPalabras == listaOcurrencias.get(i).getNumCaracteres()) {
								listaOcurrencias.get(i).setNumOcurrencias(listaOcurrencias.get(i).getNumOcurrencias()+1);
								seHaAgregado = true;
							} 
						}
						//si no se ha agregado nada al recorrer la lista se añade una ocurrencia con el 
						//num de caracteres de la palabra
						if(seHaAgregado == false) {
							Ocurrencia nuevaOcurrencia = new Ocurrencia(1, caracteresPalabras);
							listaOcurrencias.add(nuevaOcurrencia);
						}
						
					}
					//se cuentan los caracteres
					numCaracteres = numCaracteres + caracteresPalabras;
				}
			}
			//se ordena la lista por el numero de ocurrencias que hay
			for(int i = 0; i < (listaOcurrencias.size()-1); i++){
				for(int j = i+1; j < listaOcurrencias.size(); j++){
					if(listaOcurrencias.get(i).getNumOcurrencias() > (listaOcurrencias.get(j).getNumOcurrencias())){
						Ocurrencia aux=listaOcurrencias.get(i);
						listaOcurrencias.set(i, listaOcurrencias.get(j));
						listaOcurrencias.set(j, aux);
				     }
				}
			}
			//se muestra por pantalla
			for(int i = 0; i<listaOcurrencias.size(); i++) {
				System.out.println("Palabras con " +listaOcurrencias.get(i).getNumCaracteres()+ " caracteres: "+
						listaOcurrencias.get(i).getNumOcurrencias());
			}
			System.out.println("Numero total de caracteres: " +numCaracteres);
			f.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No se ha podido leer el fichero");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		leerFichero2();
		System.out.println("--------------------");
		System.out.println("Errores gramaticales");
		leerFichero();
	}

}
