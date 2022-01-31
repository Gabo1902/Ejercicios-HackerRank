package EjerciciosHackerRank.TerceraPráctica;

import java.util.Scanner;

/**
 * Solution for rock papers scissors problem
 */
class Ejercicio3
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
		Ejercicio3 solution = new Ejercicio3();
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
        double ganaJug1 = 0;
        double ganaJug2 = 0;
        double empates = 0;
        double intentos = 0;
        
        double empatesPorcentaje = 0;
        double ganaJug1Porcentaje = 0;
        double ganaJug2Porcentaje = 0;
        double totalPorcentaje =  0;

        while ( this.input.hasNext() )
        {
            String jug1 = "";
            String jug2 = "";
            
            if(this.input.hasNext("[^RPSrps]")) {
                jug1 = this.input.next();
                this.input.next(); //lea la segunda entrada, pero no haga nada con ella, pues ya el intento no se cuenta
                System.out.printf("invalid shape: %s%n", jug1);
                continue;
            } else {
                jug1 = this.input.next();
            }

            if(this.input.hasNext("[^RPSrps]")){
                jug2 = this.input.next();
                System.out.printf("invalid shape: %s%n", jug2);
                continue;
            }
            else {
                jug2 = this.input.next();
            }
            
            if( jug1.equalsIgnoreCase(jug2) ) {
                empates++;
            } else if( (jug1.equalsIgnoreCase("P") && jug2.equalsIgnoreCase("R")) || (jug1.equalsIgnoreCase("R") && jug2.equalsIgnoreCase("S")) || (jug1.equalsIgnoreCase("S") && jug2.equalsIgnoreCase("P")) ) {
                ganaJug1++;
            } else {
                ganaJug2++;
            }
            intentos++;
        }
        
        if(intentos != 0){
            //calcula los porcentajes 
            empatesPorcentaje = (empates/intentos)*100.0;
            ganaJug1Porcentaje = (ganaJug1/intentos)*100.0;
            ganaJug2Porcentaje = (ganaJug2/intentos)*100.0;
            totalPorcentaje =  empatesPorcentaje+ganaJug1Porcentaje+ganaJug2Porcentaje;    
        }
        
        //Imprime los resultados
        System.out.printf("%8s %3.0f %3.0f%%%n", "Player1:", ganaJug1, ganaJug1Porcentaje);
        System.out.printf("%8s %3.0f %3.0f%%%n", "Player2:", ganaJug2, ganaJug2Porcentaje);
        System.out.printf("%8s %3.0f %3.0f%%%n", "Draws:", empates, empatesPorcentaje);
        System.out.printf("%8s %3.0f %3.0f%%%n", "Total:", intentos, totalPorcentaje);
        System.out.println();

        if(ganaJug1==ganaJug2){
            System.out.printf("%8s", "Draw!");
        } else if(ganaJug1>ganaJug2) {
            System.out.printf("%8s Player1", " Winner:");
        } else {
            System.out.printf("%8s Player2", " Winner:");
        }

        // Close the standard input
        this.input.close();
    }
}