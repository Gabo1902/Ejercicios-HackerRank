import java.util.Scanner;

/**
 * Validates a treasure map and prints the path from a starting
 * point to the position where the trasure is
 */
public class Solution
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
		Solution solution = new Solution();
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
		while ( this.input.hasNextLine() )
		{
			System.out.println( this.input.nextLine() );
		}

		// Close the standard input
		this.input.close();
	}
}