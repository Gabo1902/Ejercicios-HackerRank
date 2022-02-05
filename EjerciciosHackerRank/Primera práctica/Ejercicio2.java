import java.util.Scanner;

/**
 * Encloses lines from standard input within [ brackets ]
 * in order to make whitespace visible
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
    public static void main(String args[])
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
        
        // Modify this code to solve the problem
            
            while ( input.hasNext() ){
                String entrada = input.nextLine();
                System.out.printf( "[%s] %n", entrada );
            }   
        // Close the standard input
        this.input.close();
    }
}