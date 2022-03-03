import java.util.Scanner;

/**
 * Reads prices and applies a new sales tax
 */
class Ejercicio6
{
	/**
	 * Gets data from standard input
	 */
	private Scanner input = null;

	/**
	 * Start the execution of the solution
	 * @param args Command line arguments
	 */
	public static void main(String args[])
	{
		Ejercicio6 solution = new Ejercicio6();
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
        
        while ( this.input.hasNextDouble() )
        {
            double precioSinReducir = this.input.nextDouble();
            
            if( precioSinReducir < 0 || precioSinReducir > 100000000) {
                System.out.printf("%.2f: invalid data", precioSinReducir);
                
            } else {
                double precioSinImpuesto = precioSinReducir / (1 + 0.13);
                double precioReducido = precioSinImpuesto * (1 + 0.115);
                double diferencia = precioSinReducir - precioReducido;
                
                System.out.printf("%.2f: %.2f (%.2f)", precioSinReducir, precioReducido, diferencia);
            }   //fin if else
            
        }  //fin while

		// Close the standard input
		this.input.close();
	}
}