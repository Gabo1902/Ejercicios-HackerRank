import java.util.Scanner;

/**
 * Prints the n-th line of Pascal's triangle for (a-b)^n
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

		// This code replicates the input to the standard output
		// Modify this code to solve the problem
		while ( this.input.hasNextLine() )
		{
			int grado = this.input.nextInt();

            if (grado < 0) {
                System.out.printf("%d: invalid data", grado);
            } else {
                grado = n;

                System.out.printf("%d: ", n);
                //Ciclo que imprime polinomio
                for (int i = 0; i < n; i++) {
                    imprimirTermino(i, n);
                }
            }
		}
		// Close the standard input
		this.input.close();
	}

    /**
     * Calcula el factorial de un número.
     * 
     * @param natural Un entero mayor o igual a 0
     * @return factorial Producto de todos los enteros positivos hasta
     *         el número
     */
    public int factorial (int natural) {
        if (natural == 0) {
            return 1;
        } else {
            int j = 1;
            int factorial = 1;
            while (j <= natural) {
                factorial *= j;
                j++;
            }
            return factorial;
        }
    }

    /**
     * Crea un arreglo con cada uno de los coeficientes de la 
     * expasión de (a+b)^n. Es lo mismo que crear la n-ésima fila de 
     * arriba a abajo, del triángulo de Pascal.
     * 
     * @param n Un número natural
     * @return filaPascal Un arreglo con los términos de la n-ésima 
     *         fila del triángulo de Pascal
     */
    public int[] filaPascal(int n) {
        int[] filaPascal = new int[n+1];
        for (int j = 0; j <= n; j++) {
            filaPascal[j] = factorial(n)/(factorial(j)*factorial(n-j));
        }
        return filaPascal;
    }

    /**
     * Método que imprime el i-ésimo término de una expansión binomial
     * (a+b)^n. Cumple con las convenciones matemáticas de notación.
     * 
     * @param i Indexa el término correspondiente en la expansión bi-
     *          nomial
     * @param n Grado de la expansión binomial
     */
    public void imprimirTermino(int i, int n) {
        
        int[] coefVector = filaPascal(n);
        int coeficiente = coefVector[i];

        if (i == 0) {
            if (n == 0) {
                System.out.println("1");
            } else if (n == 1) {
                System.out.print("a");
            } else {
                System.out.printf("a^%d", n);
            }
        } else if (i == n) {
            if (n == 1) {
                System.out.println(" - b");
            } else {
                System.out.printf(" - b^%d%n", n);
            }
        } else {
            String signo = (i%2==0)?"+":"-";
            if ((n-i)==1 && i==1) {
                System.out.printf(" %s %dab", signo, coeficiente);
            } else if ((n-i) == 1) {
                System.out.printf(" %s %dab^%d", signo, coeficiente, i);
            } else if (i == 1) {
                System.out.printf(" %s %da^%db", signo, coeficiente, n-i);
            } else {
                System.out.printf(" %s %da^%db^%d", signo, coeficiente, n-i, i);
            }
        }
    }
}