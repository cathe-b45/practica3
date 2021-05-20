package tarea3;


public class ListaEnlazadaSimple {
	protected Nodo primerNodo;
	protected int tamano;

	// se crea una lista vacía
	public ListaEnlazadaSimple() {
		primerNodo = null;
		tamano = 0;
	}
	
	//añadir un nodo
	public void insert(int contenido) {
		Nodo nodo = new Nodo(contenido, null);
	    nodo.setSiguiente(primerNodo);
	    primerNodo = nodo;
	    tamano++;
	}
	
	//eliminar un nodo
	public Object extract() {
		Object salida = null;
	    if (!isEmpty()) {
	    	salida = primerNodo.getContenido();
	    	primerNodo = primerNodo.getSiguiente();
	    }
	    return salida;
	}
	
	public void print(int n) {
		if (!isEmpty()) {
			Nodo nodo = primerNodo;
			for (int i = 0; i < n; i++) {
				nodo = nodo.getSiguiente();
				if (nodo == null) {
					return;
				}
	      }
	      System.out.println(nodo.getContenido());
	    }
	}

	public void print() {
		if (!isEmpty()) {
			Nodo nodo = primerNodo;
			while (nodo != null) {
				System.out.println(nodo.getContenido());
		        nodo = nodo.getSiguiente();
		    }
		}
	}
	
	//calcula el promedio
	public double promedio() {
		double sumaTotal = 0;
		Nodo nodo = primerNodo;
		for(int i = 0; i < tamano; i++) {
			sumaTotal = sumaTotal + nodo.getContenido();
			nodo = nodo.getSiguiente();
		}
		double promedio = sumaTotal/tamano;
		return promedio;
	}
	//comprueba si la lista esta vacia
	public boolean isEmpty() {
		if (primerNodo == null) {
			return true;
		} else {
	    	return false;
	    }
	}
}
