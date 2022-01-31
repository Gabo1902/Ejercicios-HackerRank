package EjerciciosHackerRank.TerceraPráctica;

import java.util.Scanner;

/**
 * Read integer numbers from standard input and calculates
 * the Collatz 3n+1 orbits for each integer
 */
public class Ejercicio2
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
		Ejercicio2 solution = new Ejercicio2();
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
        
        while ( this.input.hasNextLong() )
        {
            long numero = this.input.nextLong();
            
            if(numero <= 0) {
                break;
            } else {
                long pasosDelNumero = pasosCollatz(numero);
                System.out.printf("%d: %d %n", numero, pasosDelNumero);
            }
        }
        // Close the standard input
        this.input.close();
    }
    
    public long pasosCollatz(long numero) {
        
        long contador = 0;
        long numeroAIterar = numero;
        
        while (numeroAIterar != 1) {
            if( numeroAIterar % 2 == 0 ) {
                numeroAIterar = numeroAIterar / 2;
            } else {
                numeroAIterar = 3*numeroAIterar+1;
            }
            contador++;
        }
        
        return contador;   
    }
}