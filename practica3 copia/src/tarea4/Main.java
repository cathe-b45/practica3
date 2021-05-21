package tarea4;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Una palabra se considera elfish si contiene las letras : e, l y f en ella, en cualquier orden.
 * El programa implementa un método recursivo elfish() que, dada una palabra, devuelve 
 * true sí y solo sí esta es elfish.
 * @author Manuel Prieto - Catherine Ballester
 *
 */
public class Main {

	// Variable que usaremos para buscar
	public static String buscar = "elf";

	/**
	 * Primera llamada al método elfish que enviará por parámetro la palabra a buscar
	 * y recursivamente irá verificando letra por letra a través de un indice si las letras
	 * coinciden
	 * @param palabra
	 * @return
	 */
    public static boolean isElfish(String palabra) {
        return isElfish(palabra,buscar,0);
    }

    /**
     * Método recursivo que irá comprobando letra por letra si la variable "palabra" 
     * contiene las letras de la variable "buscar"
     * cadena
     * @param cadena
     * @param letras
     * @param i
     * @return
     */
    public static boolean isElfish(String palabra, String letras, int i) {
         if (i >= letras.length()) {
             return true;
         }
         
         // Para hacer la comparación de la cadena hay que convertirla 
         // a String con la función Character.toString
         String letra = Character.toString(letras.charAt(i));         
         
         // Si de la variable "buscar" existe una letra en la variable "cadena" devolverá true
         // y sumará uno a la iteración para buscar la siguiente letra
         if (palabra.contains(letra)) {
             return isElfish(palabra, letras, i + 1);
         } else {
        	 // Si no contiene ningúna letra directamente devuelve un false
             return false;
         } 
    }

    /**
     * Método main que ejecuta el programa
     * @param args
     */
    public static void main(String[] args) {
    	java.util.Scanner input = new Scanner(System.in);
    	
    	System.out.println("Una palabra se considera elfish si contiene las letras : e, l y f en ella.");
    	System.out.println("Introduce una palabra para verificar que es elfish");
    	String palabra = input.next();
    	
    	// Pedimos una palabra hasta que se cumpla el criterio
    	while (palabra.length() < 3) {
            System.out.println("La palabra no puede tener menos de 3 caracteres");
            palabra = input.next();
        }
    	
    	// Verificamos la cadena
    	if(isElfish(palabra)) {
    		System.out.println("La palabra es elfish");
    	} else {
    		System.out.println("La palabra no es elfish");
    	}
    }

}
