package tarea3;

/**
 * Clase Nodo para crear objetos de tipo nodo
 * 
 * @author Manuel Prieto - Catherine Ballester
 */
public class Nodo {
	private Object contenido;
	private Nodo siguiente;

	/**
	 * Set del nodo inicial
	 */
	public Nodo() {
		this.contenido = null;
	    this.siguiente = null;
	}

	/**
	 * Set del nodo inicial con contenido 
	 * y con enlace al siguiente nodo
	 * 
	 * @param contenido
	 * @param siguiente
	 */
	public Nodo(Object contenido, Nodo siguiente) {
		setContenido(contenido);
	    setSiguiente(siguiente);
	}

	/**
	 * Set del contenido del nodo, puede ser cualquier tipo
	 * @param o
	 */
	public void setContenido(Object o) {
		contenido = o;
	}

	/**
	 * Set del nodo siguiente, que debe ser de tipo Nodo
	 * @param n
	 */
	public void setSiguiente(Nodo n) {
	    siguiente = n;
	}

	/**
	 * Obtiene el contenido del nodo
	 * @return
	 */
	public Object getContenido() {
		return contenido;
	}

	/**
	 * Devuelve el nodo siguiente
	 * @return
	 */
	public Nodo getSiguiente() {
	    return siguiente;
	}
}