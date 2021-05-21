package tarea3;

/**
 * Tarea 3
 * Clase Main que ejecuta el programa para sacar los promedios a trav�s de una lista
 * * enlazada simple seg�n los nodos que vayamos a�adiendo.
 * @author Manuel Prieto - Catherine Ballester
 */
public class Main {

	/**
     * M�todo main que ejecuta el programa
     * @param args
     */
	public static void main(String[] args) {
		
		// Creamos la lista enlazada simple
		ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
		
		// Insertamos los datos que deseemos para sacar el promedio
		lista.insert(2);
		lista.insert(3);
		lista.insert(2);
		lista.insert(3);
		
		// Sacamos el promedio
		System.out.println(lista.promedio());
	}

}
