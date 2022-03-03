package TerceraPráctica; //Obtuve 20/20

import java.util.Scanner;
//import java.lang.Character; Nunca llegué a utilizar esta shit.

/**
 * Encrypts or decrypts texts using the Caesar algorithm
 */
public class Ejercicio5
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
		Ejercicio5 solution = new Ejercicio5();
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
        long key = this.input.nextLong();
        int instruction = this.input.nextInt();

        this.input.nextLine(); //se traga una linea
        while (this.input.hasNextLine())
            {
                String cadena = this.input.nextLine();
                String cadenaTransformada = "";
                
                if (key < 0) {
                    System.out.println("invalid key");
                } else if (instruction != 0 && instruction !=1) {
                    System.out.println("invalid instruction");
                } else {
                    //Aquí va lo bonito.
                    for (int i = 0; i < cadena.length(); i++) {
                        
                        char caracter = cadena.charAt(i);
                        int asciiCaracter = (int) caracter;
                        int position = 0;
                        long newPosition = 0;
                        
                        boolean isLowerCase =  (caracter >= 'a' && caracter <= 'z');
                        boolean isUpperCase = (caracter >= 'A' && caracter <= 'Z');
                        boolean isAlphabetic = isLowerCase || isUpperCase;
                        
                        //Es un caracter del abecedario inglés o no
                        if (!isAlphabetic) {
                            cadenaTransformada += caracter;
                            continue;
                        } else {
                            
                            //Es mayúscula o no
                            if (isUpperCase) {
                                //Posición del caracter del 1 al 26
                                position = (asciiCaracter % 65) + 1;

                                //Cifrar o descifrar
                                if (instruction == 1) {
                                    newPosition = ((position + key) % 26 == 0)?(26):((position + key) % 26);
                                } else {
                                    newPosition = position - key;
                                    while (newPosition <= 0) {
                                        newPosition += 26;
                                    }
                                }
                                cadenaTransformada += (char)(64 + newPosition);
                                
                            } else {
                                //Posición del caracter del 1 al 26
                                position = (asciiCaracter % 97) + 1;

                                //Cifrar o descifrar
                                if (instruction == 1) {
                                    newPosition = ((position + key) % 26 == 0)?(26):((position + key) % 26);
                                } else {
                                    newPosition = position - key;
                                    while (newPosition <= 0) {
                                        newPosition += 26;
                                    }
                                }
                                cadenaTransformada += (char)(96 + newPosition);
                            }
                        }
                    } // fin for
                    System.out.printf("%s%n", cadenaTransformada);
                } //fin validación
            }
        
            // Close the standard input
            this.input.close();
        }
}