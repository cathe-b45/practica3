package tarea1;

/**
 * Clase Ocurrencia que se va a utilizar para crear tipos de objeto
 * para contabilizar el n�mero de veces que aparecen palabras 
 * con el mismo n�mero de caracteres
 *  
 * @author Manuel Prieto - Catherine Ballester
 */
public class Ocurrencia {
	
	// N�mero de caracteres de la palabra
	private int numCaracteres;
	
	// Contador de ocurrencias de cada palabra
	private int numOcurrencias;
	
	/**
	 * Metodo constructor
	 * @param numOcurrencias
	 * @param numCaracteres
	 */
	public Ocurrencia(int numOcurrencias, int numCaracteres) {
		this.numOcurrencias = numOcurrencias;
		this.numCaracteres = numCaracteres;
	}
	
	/**
	 * Devuelve el contador de ocurrencias
	 * @return
	 */
	public int getNumOcurrencias() {
		return numOcurrencias;
	}
	
	/**
	 * Setea el contador de ocurrencias
	 * @param numOcurrencias
	 */
	public void setNumOcurrencias(int numOcurrencias) {
		this.numOcurrencias = numOcurrencias;
	}
	
	/**
	 * Devuelve el contador de caracteres de la palabra
	 * @return
	 */
	public int getNumCaracteres() {
		return numCaracteres;
	}
	
	/**
	 * Setea el contador de caracteres de la palabra
	 * @param numCaracteres
	 */
	public void setNumCaracteres(int numCaracteres) {
		this.numCaracteres = numCaracteres;
	}
}
