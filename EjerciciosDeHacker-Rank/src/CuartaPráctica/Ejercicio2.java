package CuartaPráctica;

import java.util.Scanner;

/**
 * Read user's old and new pins and indicates if the pins
 * are the same inverting their digits
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

		// First value in stdin indicates the number of digits of each pin
		final int digits = this.input.nextInt();

		// For statistics
		long invertedCount = 0, pin_count = 0;

		// Each line in stdin has a pin change made by a user
		while ( this.input.hasNextLong() )
		{
			// A change is a pair: oldPin newPin
			final long oldPin = this.input.nextLong();
			final long newPin = this.input.nextLong();

			// Determine if user inverted pin digits
			final boolean isInverted = isInverted(oldPin, newPin, digits);

			// Print old and new pins using leading zeros
			// according to number of digits
			printResult(oldPin, newPin, isInverted, digits);

			// For statistics
			++pin_count;
			if ( isInverted )
			{
				++invertedCount;
			}
		}

		// Print the number of inverted pins found, the total number
		// of pins processed, and the percent of inverted pins found
		printStatistics(invertedCount, pin_count);

		// Close the standard input
		this.input.close();
	}

	/**
	 * Returns true if newPin is an inversion of oldPin
	 * @param digits The number of digits that pin numbers should have
	 * @return true if newPin is equals to the inverted digits of oldPin
	 */
	private boolean isInverted(final long oldPin, final long newPin, final int digits)
	{
		return newPin == invertDigits(oldPin, digits);
	}


    // Write missing methods here
    
    public long invertDigits(long num, int digits) {
        
        long digit = 0;
        long reversed = 0;
        
        for (int i = 1; i <= digits; i++) {
            
            //Obtiene el último dígito
            digit = num % 10;
            //Agrega ese último dígito después del anterior
            reversed = reversed * 10 + digit;
            
            //Le quita el último dígito al número
            num /= 10;
        }
        return reversed;
    }
    
    public void printResult(long oldPin, long newPin, boolean isInverted, int digits) {
        
        int isInvertedBin = 0;
        
        if (isInverted) {
            isInvertedBin = 1;
        } else {
            isInvertedBin = 0;
        }
        
        String strDigits = String.valueOf(digits);
        
        System.out.printf("%0"+strDigits+"d: %0"+strDigits+"d %d%n", oldPin, newPin, isInvertedBin);
    }
    
    public void printStatistics(long invertedCount, long pin_count) {
        
        double doubleInvertedCount = (double)(invertedCount);
        double doublePin_Count = (double)(pin_count);
        double div = (doubleInvertedCount/doublePin_Count);
        
        long percentage = (long)(div*100);
        
        System.out.printf("%n%d / %d = %d%%", invertedCount, pin_count, percentage);
    }
}