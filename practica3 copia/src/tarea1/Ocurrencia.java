package tarea1;

public class Ocurrencia {
	private int numOcurrencias;
	private int numCaracteres;
	public Ocurrencia(int numOcurrencias, int numCaracteres) {
		this.numOcurrencias = numOcurrencias;
		this.numCaracteres = numCaracteres;
	}
	public int getNumOcurrencias() {
		return numOcurrencias;
	}
	public void setNumOcurrencias(int numOcurrencias) {
		this.numOcurrencias = numOcurrencias;
	}
	public int getNumCaracteres() {
		return numCaracteres;
	}
	public void setNumCaracteres(int numCaracteres) {
		this.numCaracteres = numCaracteres;
	}
}
