package tarea3;

/**
 * Clase ListaEnlazadaSimple que crea un objeto de tipo lista enlazada simple
 * 
 * @author Manuel Prieto - Catherine Ballester
 */
public class ListaEnlazadaSimple {
	protected Nodo primerNodo;
	protected int tamano;

	/**
	 * Se crea una lista vacia
	 */
	public ListaEnlazadaSimple() {
		primerNodo = null;
		tamano = 0;
	}	

	/**
	 * Inserta un nuevo nodo
	 * @param contenido
	 */
	public void insert(int contenido) {
		Nodo nodo = new Nodo(contenido, null);
	    nodo.setSiguiente(primerNodo);
	    primerNodo = nodo;
	    tamano++;
	}
	
	/**
	 * Elimina el primer nodo obteniendo el contenido
	 * @return
	 */
	public Object extract() {
		Object salida = null;
	    if (!isEmpty()) {
	    	salida = primerNodo.getContenido();
	    	primerNodo = primerNodo.getSiguiente();
	    }
	    return salida;
	}
	
	/**
	 * Imprime un nodo a través de su indice
	 * @param n
	 */
	public void print(int indice) {
		int contador = 0;
        
        // Empezamos desde el primer nodo la iteración
        Nodo nodoTemporal = primerNodo;
        
        while(contador < indice){
            
            // Obtenemos el siguiente nodo
            nodoTemporal = nodoTemporal.getSiguiente();
            contador++;
        }
        
        String contenido = nodoTemporal.getContenido().toString();
        System.out.println(contenido);
	}

	/**
	 * Imprime todos los nodos enlazando uno detrás del otro
	 */
	public void print() {
		if (!isEmpty()) {
			Nodo nodo = primerNodo;
			while (nodo != null) {
				System.out.println(nodo.getContenido() + " => ");
		        nodo = nodo.getSiguiente();
		    }
		}
	}
	
	/*
	 * Calcula el promedio
	 */
	public double promedio() {
		double sumaTotal = 0;
		Nodo nodo = primerNodo;
		for(int i = 0; i < tamano; i++) {
			sumaTotal = sumaTotal + ((Number) nodo.getContenido()).doubleValue();
			nodo = nodo.getSiguiente();
		}
		double promedio = sumaTotal/tamano;
		return promedio;
	}
	
	/**
	 * Comprueba si la lista esta vacia
	 * @return
	 */
	public boolean isEmpty() {
		return (primerNodo == null) ? true : false ;
	}
}
