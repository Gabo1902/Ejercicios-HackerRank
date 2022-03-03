import java.util.Scanner;

/**
 * Read floating point numbers and print them using three common
 * formats: fixed, exponential, and a suggested one automatically
 * chosed from the previous two.
 */
public class Ejercicio4
{
	/**
	 * Gets data from standard input
	 */
	private Scanner input = null;

	/**
	 * Start the execution of the solution
	 * @param args Command line arguments
	 */
	public static void main(String final args[])
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

        while (this.input.hasNextDouble()) {
            double entrada = this.input.nextDouble();

            System.out.printf("      fixed: %f %n", entrada);
            System.out.printf("exponential: %e %n", entrada);
            System.out.printf("  preferred: %g %n", entrada);
            System.out.println();
        }
		// Close the standard input
		this.input.close();
	}
}