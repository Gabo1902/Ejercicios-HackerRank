import java.util.Scanner;

public class Ejercicio7 {
 
    private Scanner input = null;

    public static void main( String args [] ) {
        
    }

    public void run(){
        // Create object to read data from standard input
        this.input = new Scanner(System.in);
        
        double impuesto = this.input.nextDouble();
        double tipoDeCambio = this.input.nextDouble();
        
        double costoTotalSinImpuesto = 0;
        double costoTotalConImpuesto = 0;
        double costoTotalMonedaExtranjeraConImpuesto = 0;
        
        while ( this.input.hasNext() ) {
            
            String signo = this.input.next();
            double costoItem = this.input.nextDouble();
            double costoItemConImpuesto = 0;
            double costoItemMonedaExtranjera = 0;
            
            if (signo.equals("+")){    
                
                costoItemConImpuesto = costoItem + (costoItem * impuesto / 100);
                costoItemMonedaExtranjera = costoItemConImpuesto * tipoDeCambio;
            } else if (signo.equals("-")) { //else if primerPos(strCostItem) == '-' do
                
                costoItemConImpuesto = costoItem;
                costoItemMonedaExtranjera  = costoItemConImpuesto * tipoDeCambio;
            }//end if
            
            costoTotalSinImpuesto = costoTotalSinImpuesto + costoItem;
            costoTotalConImpuesto = costoTotalConImpuesto + costoItemConImpuesto;
            costoTotalMonedaExtranjeraConImpuesto = costoTotalConImpuesto * tipoDeCambio;
            
            System.out.printf("%12.2f %12.2f%n", costoItemConImpuesto, costoItemMonedaExtranjera);
        }
        
        System.out.printf("------------ ------------%n");
        System.out.printf("%12.2f %12.2f%n", costoTotalConImpuesto, costoTotalMonedaExtranjeraConImpuesto);
        System.out.printf("------------ ------------%n");
        
        for (int indice = 1; indice <= 4; indice++) {
            double propina = costoTotalSinImpuesto*(indice * 0.05);
            double propinaMonedaLocal = propina * tipoDeCambio;
            
            int porcentaje = indice * 5;
            
            System.out.printf("%12.2f %12.2f %2d%%\n", propina, propinaMonedaLocal, porcentaje);
        }//end for
        
        System.out.printf("============ ============%n");
        
        for (int indice = 1; indice <= 4; indice++) {
            
            double totalConPropina = costoTotalConImpuesto + (costoTotalSinImpuesto * indice * 0.05);
            double totalConPropinaMonedaLocal = totalConPropina * tipoDeCambio;
            
            int porcentaje = indice * 5;
            
            System.out.printf("%12.2f %12.2f %2d%%\n", totalConPropina, totalConPropinaMonedaLocal, porcentaje);
        }//end for
        
        // Close the standard input
        this.input.close();
    }




}