import java.util.Scanner;
import java.util.Arrays;

/**
 * Validates a treasure map and prints the path from a starting
 * point to the position where the trasure is
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
		int numFilas = this.input.nextInt();
    int numColumnas = this.input.nextInt();
    int filaDeInicio = this.input.nextInt();
    int columnaDeInicio = this.input.nextInt();
    
    int[][] mapaOculto = new int[numFilas][numColumnas];

    //Lee la matriz oculta (lo hace bien)
    for (int i = 0; i < numFilas; i++) {
      for (int j = 0; j < numColumnas; j++) {
        mapaOculto[i][j] = this.input.nextInt();
      }
    }

		// Close the standard input
		this.input.close();
	}
}

/*

for(int i = 0; i < numFilas; i++) {
      for (int j = 0; j < numColumnas; j++) {
        if(j != numColumnas-1) {
          System.out.printf("%3d ", mapaOculto[i][j]);
        } else {
          System.out.printf("%3d", mapaOculto[i][j]);
        }
      }
      System.out.println();
    }

*/