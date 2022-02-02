import java.util.Scanner;

/**
 * Automatic judge that calculates the result of a tic tac toe game
 */
public class Solution4
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
		Solution4 solution = new Solution4();
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
        int n = 3;
		int[][] matriz = new Int[3][3];

        int jugadasX = 0;
        int jugadasO = 0;
        int casillasVacias = 0;

        int productoTotal = 1;

        for (int i = 0; i < matriz.length; i++) {
            String entrada = this.input.nextLine();
            for (int j = 0; j < matriz.length; j++) {
                char caracter = entrada.charAt(j);
                if (caracter == 'X') {
                    matriz[i][j] = 5;
                    jugadasX++;
                } else if (caracter == 'O') {
                    matriz[i][j] = 7;
                    jugadasO++;
                } else {
                    matriz[i][j] = 0;
                    casillasVacias++;
                }
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            int sumaFila = 0;
            for (int j = 0; j < matriz.length; j++) {
                sumaFila += matriz[i][j];
            }
            productoTotal *= sumaFila;
        }

        for (int j = 0; j < matriz.length; j++) {
            int sumaColumna = 0;
            for (int i = 0; i < matriz.length; i++) {
                sumaColumna += matriz[i][j];
            }
            productoTotal *= sumaColumna;
        }

        int sumaDiagonalDes = 0;
        int sumaDiagonalAsc = 0;
        for (int k = 0; k < matriz.length; k++) {
            sumaDiagonalDes += matriz[k][k];
            sumaDiagonalAsc += matriz[n-1-k][k];
        }

        productoTotal *= sumaDiagonalDes*sumaDiagonalAsc;
        boolean esMultiploDe5n = productoTotal % (5*n) == 0;
        boolean esMultiploDe7n = productoTotal % (7*n) == 0;

        if (esMultiploDe5n && esMultiploDe7n) {
            System.out.println("E");
        } else if (esMultiploDe5n) {
            System.out.println("X");
        } else if (esMultiploDe7n) {
            System.out.println("O");
        } else if (casillasVacias != 0) {
            System.out.println("-");
        } else {
            System.out.println("=");
        }

		// Close the standard input
		this.input.close();
	}
}