package TerceraPráctica;

import java.util.Scanner;

//Obtuve todos los casos aprobados
/**
 * Calculates the subsidy given by the government to families in social risk
 */
class Ejercicio4
{
	/**
	 * Gets data from standard input
	 */
	private Scanner input = null;

	/**
	 * Start the execution of the solution
	 * @param args Command line arguments
	 */
	public static void main(String[] args)
	{
		Ejercicio4 solution = new Ejercicio4();
		solution.run();
	}

    /**
     * Run the solution. This method is called from main()
     */
    public void run()
    {
        // Create object to read data from standard input
        this.input = new Scanner(System.in);

        // This code replicates the input to the standard output
        // Modify this code to solve the problem
        double montoBase = this.input.nextDouble();
        double total = 0.0;
        
        while(this.input.hasNextDouble())
        {
            double suma = 0.0; 
            double estadoCivil = this.input.nextDouble();
            double numHijos = this.input.nextDouble();
            
            for(int i=1; i<=numHijos; i++) {
                double edad = this.input.nextDouble();
                if(edad>=18.0) {
                    continue;
                } else if( edad>=6.0 && edad<=12.0 ) {
                    double ayuda = (montoBase/Math.pow(2, i-1));
                    suma = suma + ayuda*(1+0.5); //aplica regla 2
                } else {
                    suma = suma + (montoBase/Math.pow(2, i-1));
                }
            } 
            
            //Aplica regla 3
            if( estadoCivil==1 || estadoCivil==5 ) {
                suma = suma*(1+0.25); //aumento del 25%
            }
            
            total = total + suma;
            System.out.printf("%.2f%n", suma);
        }
        System.out.println();
        System.out.printf("%.2f",total);
        
        // Close the standard input
        this.input.close();
    }
}