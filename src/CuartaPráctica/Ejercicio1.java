package CuartaPráctica;

import java.util.Scanner;

/**
 * Print the minimum number of page turns from front or back
 * of a book to a desired page number
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

		// Read all pair of numbers from standard input
		while ( this.input.hasNextLong() )
		{
			// Each line contains the book's pages and target page
			final long pages = input.nextLong();
			final long targetPage = input.nextLong();

			// Print the minimum amount of turns to the target page
			printMinPageTurns(pages, targetPage);
		}

		// Close the standard input
		this.input.close();
	}


    // Write your methods here

	/**
     * Método que imprime la menor cantidad de páginas desde el inicio
     * o el final del libro hacia la página de destino.
     * 
     * @param pages Número de páginas del libro (puede entenderse también como la página final del libro)
     * @param targetPage Página de destino
     * @return salida El número de páginas
     */
	void printMinPageTurns(long pages, long targetPage) {
		
		long n = pages;
		long i = targetPage;

		long pageTurnsFromFront = 0; //funcion f
		long pageTurnsFromBack = 0;  //funcion g
		long output = 0;

		//Validación
		if (n<=0 || i<=0 || n<i) {
			System.out.printf("%d %d: invalid data%n", n, i);
		} else {

			//Definición de la función f
			if (i % 2 == 0) {
				pageTurnsFromBack = i / 2;
			} else {
				pageTurnsFromBack = (i-1) / 2;
			}

			//Definición de la función g
			if ((n-i) % 2 == 0) {
				pageTurnsFromFront = (n-i) / 2;
			} else {
				if ((n%2 != 0) && (i%2 == 0)) {
					pageTurnsFromFront = (n-i-1) / 2;
				} else {
					pageTurnsFromFront = (n-i+1) / 2;
				}
			}
			
			//Comparación
			if (pageTurnsFromBack <= pageTurnsFromFront) {
                output = pageTurnsFromBack;
            } else {
                output = (-1)*pageTurnsFromFront;
            }

            System.out.printf("%d %d: %d%n", n, i, output);
		}
	}
}

/*

	Metodo que hace lo mismo que el anterior, pero de una manera poco eficiente.

    public void printMinPageTurns(long pages, long targetPage) {
        
        long salida = 0;
        long hojasDesdeInicio = 0;
        long hojasDesdeFinal = 0;

        if ( pages <= 0 || targetPage <= 0 || pages < targetPage ) {
            System.out.printf("%d %d: invalid data%n", pages, targetPage);
        } else {

            for ( long i = 1; i < targetPage; i++) {
                if ((i % 2 != 0) && ((i+1) % 2 == 0)) {
                    hojasDesdeInicio++;
                } else {
                    continue;
                }
            }
            
            for ( long j = pages; j > targetPage; j--) {
                if ((j % 2 == 0) && ((j-1) % 2 != 0)) {
                    hojasDesdeFinal--;
                } else {
                    continue;
                }
            }

            if ( hojasDesdeInicio <= (-1*hojasDesdeFinal) ) {
                salida = hojasDesdeInicio;
            } else {
                salida = hojasDesdeFinal;
            }

            System.out.printf("%d %d: %d%n", pages, targetPage, salida);

        }
    }
*/











