package SeptimaPractica;

/**
 * No se realizó este ejercicio.
 */

import java.util.Scanner;
import java.util.HashMap;

/**
 * solution for table of contents v1 problem
 */
public class Ejercicio1
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

		// Create the object to read and format the table of contents
		final TableOfContents tableOfContents = new TableOfContents();
		tableOfContents.readAndFormat(this.input);

		// Close the standard input
		this.input.close();
	}
}


// Write your classes here
class TableOfContents {

  /**
   * Atributos.
   */
  private int anchoDePag;
  private int anchoNumPag;
  private HashMap<String, Integer> tableOfContents;

  public void readAndFormat(Scanner entrada) {

    this.anchoDePag = entrada.nextInt();
    this.anchoNumPag = entrada.nextInt();




  }

  public void read(Scanner entrada) {

    this.anchoDePag = entrada.nextInt();
    this.anchoNumPag = entrada.nextInt();

    entrada.nextLine();
    entrada.nextLine();

    while (entrada.hasNextLine()) {

      entrada.useDelimiter("[\\t]+");

      String title = entrada.next();

      Integer numPag = entrada.nextInt();

      tableOfContents.put(title, numPag);

    }

  }

}