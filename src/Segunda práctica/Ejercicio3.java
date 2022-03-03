import java.util.Scanner;

/**
 * Calculates the next player after the music stops in the hot potato game
 */
public class Ejercicio3
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


        // Write your solution code here
        
        if( this.input.hasNextLong()) {
            Long numJugadores = this.input.nextLong();
            if( this.input.hasNextLong()) {
                Long jugadorInicial = this.input.nextLong();
                if(this.input.hasNextLong()){
                    Long segundos = this.input.nextLong();
                    
                    //Aquí va el código
                    
                    if(numJugadores<1 || jugadorInicial<1 || segundos<1 || jugadorInicial > numJugadores) {
                        System.out.println("invalid data");
                    } else {
                        long traslado = jugadorInicial + segundos - 1;
                        long ultimoPase = traslado % numJugadores;
                        long jugadorFinal = 0;
                    
                    if(ultimoPase == 0) {
                        jugadorFinal = numJugadores;
                    } else {
                        jugadorFinal = ultimoPase;
                    }
                    
                    System.out.println(jugadorFinal);
                    
                }   //fin if else de juego
                    
                } else {
                    System.out.println("invalid data");    
                }
            } else {
                System.out.println("invalid data");
            }
        } else {
            System.out.println("invalid data");
        } //fin if else de validación
        

		// Close the standard input
		this.input.close();
	}
}