import java.util.Scanner;

/**
 * Read double precision numbers from standard input and print them
 * to standard output rounded to 2 decimals in fixed notation
 */
public class Ejercicio6
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

		while ( this.input.hasNextDouble() )
		{
    		// Write code here to solve the problem
            System.out.printf("%.2f%n", this.input.nextDouble());
		}

		// Close the standard input
		this.input.close();
	}
}