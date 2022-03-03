package QuintaPráctica;

import java.util.Scanner;

/**
 * Solution for histogram problem
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

	/**
	 * Lee los valores y los almacena dentro del arreglo.
	 * 
	 * @param arreglo Lugar donde se van a almacenar los valores obtenidos de la entrada.
	 */
	public void readValues(double arreglo[]) {
		for (int i = 0; i < arreglo.length; i++) {
			arreglo[i] = this.input.nextDouble();
		}
    }

	//Calcula en cuál clase se encuentra determinado valor
	/**
	 * Método que determina en cual intervalo o clase se encuentra un determinado valor.
	 * 
	 * @param valor Valor que se debe encontrar dentro del arreglo
	 * @param min Valor mínimo del arreglo
	 * @param incremento Incremento de los valores, que da lugar al supremo y al infimo de cada intervalo
	 * @return Valor del tipo {@code int} que indica en cuál intervalo se encuentra dicho valor
	 */
	public int encontrarClase(double valor, double min, double incremento) {
		int clase = (int)((valor - min)/incremento);
		return clase;
	}

	/**
     * Método que imprime el histrograma requerido, a partir de los datos preliminares obtenidos y utilizando los métodos anteriores.
     * 
     * @param values Arreglo donde se encuentran cada uno de los valores recopilados
     * @param classes Número de intervalos a desplegar
     * @param integerDigits Cantidad de dígitos enteros que van a poseer los extremos de cada intervalo
     * @param decimalDigits Cantidad de dígitos decimales que van a poseer los extremos de cada intervalo
     */
    public void printHistogram(double[] values, int classes, int integerDigits, int decimalDigits) {
        
        double min, max;

        min = max = values[0];
        for (int i = 0; i < values.length; i++) {
            if (values[i]<min) min = values[i];
            if (values[i]>max) max = values[i];
        }

        double incrementoW = (max - min) / classes;
        
        //Aquí va lo bonito
        String formatoNumerico = String.valueOf(integerDigits)+"."+String.valueOf(decimalDigits);
        
        for (int i = 1; i <= classes; i++) {
            if (i == classes) {
                System.out.printf("[%"+formatoNumerico+"f, %"+formatoNumerico+"f] | ", min + (i-1)*incrementoW, min + i*incrementoW);
            } else {
                System.out.printf("[%"+formatoNumerico+"f, %"+formatoNumerico+"f[ | ", min + (i-1)*incrementoW, min + i*incrementoW);
            }
            
            // Pone los asteriscos
            for (int j = 0; j < values.length; j++) {
                
                int intervaloDePertenencia = 0;
                
                if (encontrarClase(values[j], min, incrementoW) == classes) {
                    intervaloDePertenencia = encontrarClase(values[j], min, incrementoW) - 1;
                } else {
                    intervaloDePertenencia = encontrarClase(values[j], min, incrementoW);
                }
                if (intervaloDePertenencia == i-1 ) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}