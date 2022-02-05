import java.util.Scanner;

/**
 * Read numbers from standard input, interpret them as
 * ASCII codes, and print them as characters.
 */
public class Ejercicio7
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
		Ejercicio7 solution = new Ejercicio7();
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
        
        while ( this.input.hasNextInt() )
        {
            int entrada = this.input.nextInt();
            System.out.printf( "%c", entrada );
        }

		// Close the standard input
		this.input.close();
	}
}