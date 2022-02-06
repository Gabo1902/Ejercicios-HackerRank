import java.util.Scanner;
import java.util.Arrays;

/**
 * Automatic judge that calculates the result of a tic tac toe game
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
        int n = 3;
        String[][] matriz = new String[n][n];

        int jugadasJO = 0;
        int jugadasJX = 0;
        int casillasVacias = 0;

        //Crea la matriz y cuenta las jugadas
		for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                String cadena = this.input.next(); 
                matriz[i][j] = cadena;
                if (cadena.equals("X")) jugadasJX++;
                else if (cadena.equals("O")) jugadasJO++;
                else if (cadena.equals("-")) casillasVacias++;
            }
        }
        juezGato(matriz, jugadasJX, jugadasJO, casillasVacias);
		// Close the standard input
		this.input.close();
	}

    public void juezGato(String[][] matriz, int jugadasJX, int jugadasJO, int casillasVacias) {

        String[] vectorDeX = {"X","X","X"};
        String[] vectorDeO = {"O","O","O"};

        boolean ganaX = false;
        boolean ganaO = false;

        //Recorre filas
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                fila[j] = matriz[i][j];
            }
            if (fila.equals(vectorDeX)) ganaX = true;
            else if (fila.equals(vectorDeO)) ganaO = true;
        }

        //Recorre columnas
        for (int j = 0; j < matriz.length; j++) {
            String[] columna = new String[matriz.length];
            for (int i = 0; i < matriz.length; i++) {
                columna[i] = matriz[i][j];
            }
            if (columna.equals(vectorDeX)) ganaX = true;
            else if (columna.equals(vectorDeO)) ganaO = true;
        }

        //Recorre diagonales
        String[] diagonal1 = new String[matriz.length];
        String[] diagonal2 = new String[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            diagonal1[i] = matriz[i][i];
            diagonal2[i] = matriz[matriz.length-1-i][i];
            if (diagona1[i].equals(vectorDeX) || diagonal2[i].equals(vectorDeX)) {
                ganaX = true;
            } else if (diagona1[i].equals(vectorDeO) || diagonal2[i].equals(vectorDeO)) {
                ganaO = true;
            } 
        }

        boolean gananAmbos = ganaX && ganaO;
        boolean hayMasJugadasDeX = (jugadasJO+2 <= jugadasJX);
        boolean hayMasJugadasDeO = (jugadasJX+2 <= jugadasJO);

        if (gananAmbos || hayMasJugadasDeX || hayMasJugadasDeO) {
            System.out.print("E");
        } else if (ganaX) {
            System.out.print("X");
        } else if (ganaO) {
            System.out.print("O");
        } else {
            System.out.print("-");
        }
    }
}