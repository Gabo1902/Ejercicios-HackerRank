import java.util.Scanner;

/**
 * Add line numbers to the input.
 */

public class Ejercicio1 {

	private Scanner input = null;

	/**
	 * Start the execution of the solution.
	 * @param args Command line arguments
	 */
	public static void main(String final args[])
	{
		Ejercicio1 solution = new Ejercicio1();
		solution.run();
	}

	/**
	 * Run the solution. This method is called from main()
	 */
	public void run()
	{
		// Create object to read data from standard input
		this.input = new Scanner(System.in);

		// Modify this code to solve the problem
        int ancho = this.input.nextInt();
        int hayCeroALaIzq = this.input.nextInt();
        int contador = 1;
        if (hayCeroALaIzq == 0) {

            while (input.hasNextLine()) {
                String entrada = this.input.nextLine();
                System.out.printf("%0*d %s %n", ancho, contador, entrada);
                contador++;
            }
        } else if (hayCeroALaIzq == -1) {

            while (input.hasNextLine()) {
                String entrada = this.input.nextLine();
                System.out.printf("%*d %s %n", ancho, contador, entrada);
                contador++;
            }
        } //end if
        //Close the standard input
        this.input.close();

        // Modify this code to solve the problem
        while (input.hasNextLine()) {
            // Write your code here to solve the problem
            System.out.println(input.nextLine());
        }
	}
}


