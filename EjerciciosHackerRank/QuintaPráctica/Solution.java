import java.util.Scanner;

/**
 * Solution for histogram problem
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
	public static void main(String[] args)
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

		// Read the parameters in the first line
		final int size = this.input.nextInt();
		final int classes = this.input.nextInt();
		final int integerDigits = this.input.nextInt();
		final int decimalDigits = this.input.nextInt();

		// Check the size of data is valid
		if ( size > 0 && classes > 0 )
		{
			// Create an array to store the values
			final double[] values = new double[size];

			// Read the values and store them into the array
			readValues(values);

			// Print a histogram for the data
			printHistogram(values, classes, integerDigits, decimalDigits);
		}

		// Close the standard input
		this.input.close();
	}

    // Implement missing and required methods here

    void readValues() {

    }
    

}