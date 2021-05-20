package tarea3;

public class Nodo {
	private int contenido;
	private Nodo siguiente;

	public Nodo() {
		contenido = 0;
	    siguiente = null;
	}

	public Nodo(int contenido, Nodo siguiente) {
		setContenido(contenido);
	    setSiguiente(siguiente);
	}

	public void setContenido(int o) {
		contenido = o;
	}

	public void setSiguiente(Nodo n) {
	    siguiente = n;
	}

	public int getContenido() {
		return contenido;
	}

	public Nodo getSiguiente() {
	    return siguiente;
	}
}