//Pasa 5/25 casos
import java.util.Scanner;

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
    
    reverlarMapa(mapaOculto, filaDeInicio, columnaDeInicio);
    
		// Close the standard input
		this.input.close();
	}
  
  public void reverlarMapa(int[][] mapaOculto, int filaInicial, int columnaInicial) {
    char[][] mapaRevelado = new char[mapaOculto.length][mapaOculto[0].length];
    
    //Agregar el mar al mapa revelado
    for (int i = 0; i < mapaOculto.length; i++) {
      for (int j = 0; j < mapaOculto[0].length; j++) {
        if(mapaOculto[i][j] < 0) {
         mapaRevelado[i][j] = '~'; 
        }
      }
    }  
    
    //Revela el camino
    //Coordenadas de la casilla de turno
    int fila = filaInicial-1;
    int columna = columnaInicial-1;
    boolean haTerminadoCiclo = false;
    
    int producto = 1;
    while(!haTerminadoCiclo) {
      
      int casillaDePaso = mapaOculto[fila][columna];
      
      //coordenadas de la casilla siguiente
      int primerDigito = casillaDePaso/10;
      int segundoDigito = casillaDePaso%10;
      
      
      if(casillaDePaso<0) {
        System.out.println("sea");
        haTerminadoCiclo = true;
      } else if(primerDigito==0||primerDigito>mapaOculto.length||segundoDigito>mapaOculto[0].length) {
        System.out.println("error");
        haTerminadoCiclo = true;
      } else {
        
        int casillaSiguiente = mapaOculto[primerDigito-1][segundoDigito-1];
        
        if(casillaSiguiente == casillaDePaso) {
          System.out.println("treasure");
          mapaRevelado[fila][columna] = '.';
          mapaRevelado[primerDigito-1][segundoDigito-1] = 'X';
          haTerminadoCiclo = true;
        } else if(producto%casillaSiguiente==0) {
          mapaRevelado[fila][columna] = '.';
          mapaRevelado[primerDigito-1][segundoDigito-1] = '.';
          System.out.println("loop");
          haTerminadoCiclo = true;
        } else {
          mapaRevelado[fila][columna] = '.';
          producto *= casillaDePaso;
          fila = primerDigito-1;
          columna = segundoDigito-1;
        }
      }
    }
    
    //revisar los explosivos
    //Revisar si hay explosivos
    for (int i = 0; i < mapaRevelado.length; i++) {
      for (int j = 0; j < mapaRevelado[0].length; j++) {
        int casillaDePaso = mapaOculto[i][j];
        
        //obtener las coordenadas de la casilla siguiente
        int primerDigito = casillaDePaso / 10;
        int segundoDigito = casillaDePaso % 10;
        
        //System.out.println((primerDigito-1)+" "+(segundoDigito-1));
        
        
        if((primerDigito-1)<0||(primerDigito-1)>mapaOculto.length||(segundoDigito-1)>mapaOculto[0].length||mapaRevelado[i][j]=='.'||mapaRevelado[i][j]=='X') {
          continue;
        }
        int casillaSiguiente = mapaOculto[primerDigito-1][segundoDigito-1];
        if(casillaSiguiente == casillaDePaso) {
          mapaRevelado[primerDigito-1][segundoDigito-1] = '!';
        }
      }
    }
    
    //Aquí ya está montada la matriz revelada
    System.out.println();
    
    //Imprimir mapa revelado
    for (int i = 0; i < mapaRevelado.length; i++) {
      for (int j = 0; j < mapaRevelado[0].length; j++) {
        if(j != (mapaRevelado[0].length-1)) {
          System.out.printf("%s ", mapaRevelado[i][j]);
        } else {
          System.out.printf("%s", mapaRevelado[i][j]);
        } 
      }
      System.out.println();
    } 
  }
}