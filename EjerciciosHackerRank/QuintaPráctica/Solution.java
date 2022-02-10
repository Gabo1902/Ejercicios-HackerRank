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
    int fila = filaInicial-1;
    int columna = columnaInicial-1;
    int casilla = mapaOculto[fila][columna];
    
    int contador = 0;
    boolean haTerminadoElCamino = false;
    
    while(!haTerminadoElCamino) {
      int primerDigito = casilla/10;
      int segundoDigito = casilla%10;
      
      if(casilla < 0) {
        System.out.println("sea"); //El camino lleva al mar
      } else if((primerDigito < 1)||(primerDigito>mapaOculto.length)||(segundoDigito < 1)||(segundoDigito > mapaOculto[0].length)) {
          System.out.println("error"); //El camino se sale del mapa
      } else if(hayLoop(casilla, contador, mapaOculto, filaInicial, columnaInicial)) {
          mapaRevelado[fila][columna] = '.';
          System.out.println("loop"); //el camino tiene un ciclo
        break;
      } else if(casilla == mapaOculto[primerDigito][segundoDigito]) {
          System.out.println("treasure");
          mapaRevelado[fila][columna] = 'X';
          haTerminadoElCamino = true;
      } else {
          mapaRevelado[fila][columna] = '.';
          contador++;
      }
      fila = primerDigito;
      columna = segundoDigito;
      casilla = mapaOculto[fila][columna];
    }
    
    
    //Revisar si hay explosivos
    /*
    for (int i = 0; i < mapaRevelado.length; i++) {
      for (int j = 0; j < mapaRevelado[0].length; j++) {
        if((mapaRevelado[i][j] == 'X') || (mapaRevelado[i][j] == '~')){
          //No haga nada
        } else if(mapaOculto[i][j] == mapaOculto[mapaOculto[i][j]/10][mapaOculto[i][j]%10]) {
            mapaRevelado[i][j] = '!';
        }
      }
    }
    */
    
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
  
  //Método que dice si hay un loop o no
  public boolean hayLoop(int valor, int contador, int[][] mapaOculto, int filaInicial, int columnaInicial) {
    if(contador == 0) {
      return false;
    } else {
      boolean hayLoop = false;
      int casillaCamino = mapaOculto[filaInicial][columnaInicial];
      for (int i = 0; i <= contador; i++) {
        if(casillaCamino == valor) {
          hayLoop = true;
          break;
        } else {
          casillaCamino = mapaOculto[casillaCamino/10][casillaCamino%10];
        }
      }
      return hayLoop;
    }
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