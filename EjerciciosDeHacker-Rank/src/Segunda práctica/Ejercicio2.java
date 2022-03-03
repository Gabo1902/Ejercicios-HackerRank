import java.util.Scanner;

/**
 * Normalizes hours, minutes and seconds to the range {00, 59}
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
        this.input.useDelimiter("[:\\s]+");
        
		while ( input.hasNext() )
		{   
			Long horas = this.input.nextLong();
            Long minutos = this.input.nextLong();
            Long segundos = this.input.nextLong();
            
            Long segundosConvertidos = segundos % 60;
            Long minutosNoConvertidos = minutos + (Long)(segundos / 60);
            Long minutosConvertidos = minutosNoConvertidos % 60;
            Long horasConvertidas = horas + (Long)(minutosNoConvertidos / 60);
            
            /**
             * En el caso de las horas, lo que hace el %02d es que establece un MÍNIMO de 2 espacios, si hay más de 2 caracteres, no los restringe
             */
            System.out.printf("%02d:%02d:%02d%n", horasConvertidas, minutosConvertidos, segundosConvertidos);  
            
		}

		// Close the standard input
		this.input.close();
	}

}

/*
        //Me sirvió, pero había una manera mucho más sencilla de hacerlo (java code)

            String strHorasConvertidas = String.valueOf(horasConvertidas);
            
            if(horasConvertidas < 9){
                int anchoDeHoras = strHorasConvertidas.length() + 1;
                String formatoDeHoras = "%0" + anchoDeHoras + "d";  
                System.out.printf(formatoDeHoras + ":%02d:%02d%n", horasConvertidas, minutosConvertidos, segundosConvertidos);  
                
            } else {
                int anchoDeHoras = strHorasConvertidas.length();
                String formatoDeHoras = "%" + anchoDeHoras + "d";  
                System.out.printf(formatoDeHoras + ":%02d:%02d%n", horasConvertidas, minutosConvertidos, segundosConvertidos);
            }
*/

