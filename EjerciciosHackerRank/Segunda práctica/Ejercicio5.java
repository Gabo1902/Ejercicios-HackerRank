//Todos los casos aprobados

import java.util.Scanner;

/**
 * Calculates the number of tickes for a Christmas raffle
 */
public class Ejercicio5
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
		Ejercicio5 solution = new Ejercicio5();
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
        
        double precioCupon = this.input.nextDouble();
        
        while ( this.input.hasNextDouble() )
        {
            double transaccion = this.input.nextDouble();
            
            if(transaccion > 10000000 || transaccion <= 0) {
                System.out.printf("%11.2f %5s%n", transaccion, "err");
            } else {
                int numCupones = (int)(transaccion/precioCupon);
                System.out.printf("%11.2f %5d%n", transaccion, numCupones);
            }
        }
        
		// Close the standard input
		this.input.close();
	}
}