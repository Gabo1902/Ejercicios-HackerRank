package Pruebas;
import java.util.Scanner;
import java.lang.Character;
/**
 * Prueba del método isAlphabetic(int codePoint) de la clase Character
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PbaIsAlphabetic
{
    public static void main(String [] args ) {
        PbaIsAlphabetic prueba = new PbaIsAlphabetic();
        prueba.run();    
    }
    
    //public static Boolean isAlphabetic(int codePoint)  
    public void run() {
        System.out.println("Escriba un entero positivo: ");
        Scanner entrada = new Scanner(System.in);
        
        while(entrada.hasNext()) {
            int entero = entrada.nextInt();
            char caracter = (char) entero;
            boolean resultado = Character.isAlphabetic(entero);
            
            System.out.println(caracter);
            System.out.println(resultado + "\n");    
        }

        entrada.close();
    }
    
    
}
