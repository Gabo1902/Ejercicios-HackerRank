package QuintaPráctica.proofs;
import java.util.Scanner;

/**
 * Validates a treasure map and prints the path from a starting
 * point to the position where the trasure is
 */
public class Solution2
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
    Solution2 solution = new Solution2();
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
    char[][] mapaRevelado = new char[numFilas][numColumnas];

    agregarMar(mapaOculto, mapaRevelado);
    revelarCamino(mapaOculto, mapaRevelado, filaDeInicio, columnaDeInicio);
    colocarExplosivos(mapaOculto, mapaRevelado);
    agregaEspacios(mapaRevelado);
    System.out.println();
    imprimirMapa(mapaRevelado);

    // Close the standard input
    this.input.close();
  } //fin run

  public void agregarMar(int[][] mapaOculto, char mapaRevelado[][]){
    for (int i = 0; i < mapaOculto.length; i++) {
      for (int j = 0; j < mapaOculto[0].length; j++) {
        if(mapaOculto[i][j] < 0) {
         mapaRevelado[i][j] = '~'; 
        }
      }
    } 
  }
  
    /**
   * Revela el camino. Da {@code error} si se sale de las dimensiones del mapa. Da {@code sea} si lleva al mar. 
   * Imprime {@code loop} si el camino tiene un ciclo, e imprime {@code treasure} si logra dar con el tesoro.
   * 
   * @param mapaOculto el mapa de números oculto
   * @param mapaRevelado el mapa de caracteres revelados que muestra el camino, si lo hubiere
   * @param filaInicial fila de la casilla donde inicia el camino
   * @param columnaInicial columna de la casilla donde inicia el camino
   */
  public void revelarCamino(int[][] mapaOculto, char[][] mapaRevelado, int filaInicial, int columnaInicial) {
    
    //Revela el camino
    //Coordenadas de la casilla de turno
    int fila = filaInicial-1;
    int columna = columnaInicial-1;
    boolean haTerminadoCiclo = false;
    long producto = 1;
    
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
        mapaRevelado[fila][columna] = '.';
        haTerminadoCiclo = true;
      } else {
        
        int casillaSiguiente = mapaOculto[primerDigito-1][segundoDigito-1];
        
        if(casillaSiguiente == casillaDePaso) {
          System.out.println("treasure");
          mapaRevelado[fila][columna] = '.';
          mapaRevelado[primerDigito-1][segundoDigito-1] = 'X';
          haTerminadoCiclo = true;
        } else if((producto % casillaSiguiente) == 0) {
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
  }
  
  /**
   * Coloca los respectivos explosivos en el mapa, si los hubiere.
   * 
   * @param mapaOculto el mapa de números oculto
   * @param mapaRevelado el mapa de caracteres revelados con los explosivos
   */
  public void colocarExplosivos(int[][] mapaOculto, char[][] mapaRevelado) {
    //revisar los explosivos
    //Revisar si hay explosivos
    for (int i = 0; i < mapaRevelado.length; i++) {
      for (int j = 0; j < mapaRevelado[0].length; j++) {
        
        int casillaDePaso = mapaOculto[i][j];
        
        //Obtener las coordenadas de la casilla siguiente
        int primerDigito = casillaDePaso / 10;
        int segundoDigito = casillaDePaso % 10;
        
        //Valida la casilla que sigue
        if((primerDigito-1)<0||(primerDigito-1)>mapaOculto.length||(segundoDigito-1)>mapaOculto[0].length||mapaRevelado[i][j]=='.'||mapaRevelado[i][j]=='X'||mapaRevelado[primerDigito-1][segundoDigito-1] == '.'||mapaRevelado[primerDigito-1][segundoDigito-1] == 'X') {
          continue;
        }
        
        int casillaSiguiente = mapaOculto[primerDigito-1][segundoDigito-1];
        
        if(casillaSiguiente == casillaDePaso) {
          mapaRevelado[primerDigito-1][segundoDigito-1] = '!';
        }
      }
    }
  }
  
  /**
   * Agrega espacios a las casillas que no forman parte de ninguno de los casos particulares del ejercicio.
   * 
   * @param mapaRevelado mapa revelado con carácteres
   */
  public void agregaEspacios(char[][] mapaRevelado) {
    for (int i = 0; i < mapaRevelado.length; i++) {
      for (int j = 0; j < mapaRevelado[0].length; j++) {
        
        if (mapaRevelado[i][j] != '.' && mapaRevelado[i][j] != '!' && mapaRevelado[i][j] != '~' && mapaRevelado[i][j] != 'X') {
          mapaRevelado[i][j] = ' ';
        }
      }
    }
  }
  
  /**
   * Imprime el mapa con los todos los caracteres revelados.
   * 
   * @param mapaRevelado el mapa de caracteres revelado
   */
  public void imprimirMapa(char[][] mapaRevelado) {
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