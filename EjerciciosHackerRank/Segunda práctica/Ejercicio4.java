import java.util.*;

public class Ejercicio4 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        
        Scanner entrada = new Scanner(System.in);  
       
        while(entrada.hasNextDouble()) {
            
            Double nota = entrada.nextDouble();
            
            Double notaFinal = Math.round(nota/(10*0.5))*0.5;
            String condicion = "";
            String formato = "%4.1f";
            
            if(notaFinal<0 || notaFinal >10){
                condicion = "ERR";
                notaFinal = nota;
                formato = "%2.2f";
            } else if(notaFinal<6) {
                condicion = "PE";
            } else if(notaFinal<7) {
                condicion = "AMP";
            } else {
                condicion = "AP";
            }
                
            System.out.printf(formato + " %s %n", notaFinal, condicion);

            entrada.close();
            
        }       
    }
}