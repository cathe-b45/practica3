package tarea4;

public class Main {

	 /*
     * Pre:...
     * Post: Implementa un método recursivo elfish() que, dada 
     * una palabra, devuelve true sí y solo sí esta es elfish.
     */

    public static boolean elfish(String cadena) {
        String letras = "elf";
        if (cadena == null|| cadena.length() == 0) {
            return false;
        }
        return elfish(cadena, letras ,0);
    }

    public static boolean elfish(String cadena, String letras, int i) {
         if (i >= letras.length()) {
             return true;
         }
         char letter = letras.charAt(i);
         // Si la cadena contiene la letras especificas que pedeimos devolvera true
         if (cadena.contains(String.valueOf(letter))) {
             return elfish(cadena, letras, i + 1);
         } else { // Si no devuelve false
             return false;
         } 
    }

    public static void main(String[] args) {
        System.out.println(elfish("waffles"));
    }

}
