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

	// Read the values and store them into the array
	public void readValues(double arreglo[]) {
		for (int i = 0; i < arreglo.length; i++) {
			arreglo[i] = this.input.nextDouble();
		}
    }

	//Calcula en cuál clase se encuentra determinado valor
	public int encontrarClase(double valor, double min, double incremento) {
		
		int clase = (int)((valor - min)/incremento);
		
		return clase;
	}

	// Print a histogram for the data
	public void printHistogram(double[] values, int classes, int integerDigits, int decimalDigits) {
		
		//Primero, se ordenan los valores del arreglo
		double min, max;
		
		min = max = values[0];
		for (int i = 0; i < values.length; i++) {
			if (values[i]<min) min = values[i];
			if (values[i]>max) max = values[i];
		}

		double incrementoW = (max - min) / classes;
		double minIntervalo = min;

		//Aquí va lo bonito
		String formatoNumerico = toString(integerDigits)+"."+toString(decimalDigits);
		for (int i = 1; i <= classes; i++) {
			if (i == classes) {
				System.out.printf("[%"+formatoNumerico+"f, %"+formatoNumerico+"f ] | ", (i-1)*incrementoW, i*incrementoW);
			} else {
				System.out.printf("[%"+formatoNumerico+"f, %"+formatoNumerico+"f [ | ", (i-1)*incrementoW, i*incrementoW);
			}
			for (int j = 0; j < values.length; j++) {
				if (encontrarClase(values[j], min, incrementoW) == i ) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}