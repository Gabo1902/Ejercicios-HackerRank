import java.util.Scanner;

/**
 * Format dates prepending leading zeros to years, months and days
 */
class Solution
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
        
        this.input.useDelimiter("[/\\s]+");
       
        int year = this.input.nextInt();
        int month = this.input.nextInt();
        int day = this.input.nextInt();
        
        System.out.printf("%04d/%02d/%02d", year, month, day);

		// Close the standard input
		this.input.close();
	}
}