package tarea3;

public class Main {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
		lista.insert(4);
		lista.insert(2);
		lista.insert(2);
		System.out.println(lista.promedio());
	}

}
