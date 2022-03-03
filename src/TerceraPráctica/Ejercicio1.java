package TerceraPráctica;

import java.util.Scanner;

/**
 * Prints electric stairs which size is indicated by standard input
 */
class Solution
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
        int sizeEscalera = this.input.nextInt();
        String strSizeEscalera = String.valueOf(sizeEscalera);
        
        if(sizeEscalera<=0){
            //No hace nada
        } else {
            
            for(int i = 1; i <= sizeEscalera; i++){
                
                String reglon = "";
                
                //Agrega los numerales de cada reglón
                for(int j = 1; j <= i; j++){
                    
                    reglon = reglon + "#";
                    
                    //No permite imprimir el reglón hasta que los numerales correspondientes estén unidos
                    if( j<i ){
                        continue;
                    } else {
                        System.out.printf("%"+strSizeEscalera+"s", reglon);
                    }   
                }
                //Salto de linea. Por defecto, los reglones se justifican hacia la derecha, como se quiere
                System.out.println();
            }
        }
        // Close the standard input
        this.input.close();
    }
}