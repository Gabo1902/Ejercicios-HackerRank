import java.util.Scanner;

/**
 * Implementación del ejercicio del laberinto encantado
 */
class Ejercicio2 {

  /**
   * Atributos de la clase
   */
  private Scanner reader = null;
  private Laberinto laberinto = null;

  //Métodos de la clase

  /**
   * Método main que ejecuta el programa.
   * 
   * @param args
   */
  public static void main(String[] args) {

    Ejercicio2 solution = new Ejercicio2();
    solution.run();
  }

  /**
   * Método run que lleva la logística de la ejecución del
   * programa.
   */
  public void run() {

    this.laberinto = new Laberinto();
    this.reader = new Scanner(System.in);

    laberinto.leer(this.reader);

    if (laberinto.encontrarCamino()) {
      laberinto.imprimir();
    } else {
      System.out.print("No solution path");
    }
  }

}

/**
 * Clase donde están los laberintos, sus atributos y sus
 * métodos.
 */
class Laberinto {

  /**
   * Atributos de la clase
   */
  private char[][] laberinto;

  //A
  private int filaInicial;
  private int columnaInicial;

  // Métodos de la clase

  /**
   * Método que lee la matriz correspondiente al laberinto.
   * 
   * @param reader
   */
  public void leer(Scanner reader) {

    int filas = reader.nextInt();
    int columnas = reader.nextInt();

    this.laberinto = new char[filas][columnas];
    
    reader.nextLine();
    reader.nextLine();

    reader.useDelimiter("");

    //Lea la matriz y encuentre la casilla inicial
    for (int i = 0; i < laberinto.length; i++) {
      for (int j = 0; j < laberinto[i].length; j++) {
        laberinto[i][j] = reader.next().charAt(0);
        if (laberinto[i][j] == 'A') {
          //El this habla únicamente 
          this.filaInicial = i;
          this.columnaInicial = j;
        }
      }

      if (reader.hasNextLine()) reader.nextLine();
    }
  }

  /**
   * Método que imprime el laberinto.
   */
  public void imprimir() {

    for (int i = 0; i < laberinto.length; i++) {
      for (int j = 0; j < laberinto[0].length; j++) {
        System.out.print(laberinto[i][j]);
      }
      System.out.println();
    }
  }

  /**
   * Método que determina si el laberinto tiene un camino o
   * no.
   * 
   * @return
   */
  public boolean encontrarCamino() {
    return avanzar(this.filaInicial, this.columnaInicial);
  }

  /**
   * Método recursivo que verifica las celdas adyacentes.
   * Primero coloca el '.'.
   * 
   * @param fila
   * @param columna
   */
  public boolean avanzar(int fila, int columna) {

    //Si hay una casilla vacía, coloque una migaja de pan
    if (laberinto[fila][columna] == ' ') {
      laberinto[fila][columna] = '.';
    }

    //Norte
    if (verifiqueCasilla(fila - 1, columna)) {
      return true;
    }

    //Sur
    if (verifiqueCasilla(fila + 1, columna)) {
      return true;
    }

    //Este
    if (verifiqueCasilla(fila, columna + 1)) {
      return true;
    }

    //Oeste
    if (verifiqueCasilla(fila, columna - 1)) {
      return true;
    }

    //Default
    this.laberinto[fila][columna] = ' ';
    return false;

  }

  /**
   * Verifica la casilla para saber si está en 'B', si se
   * avanza o se para.
   * 
   * @param fila
   * @param columna
   */
  public boolean verifiqueCasilla(int fila, int columna) {

    switch (darValor(fila, columna)) {
      case 'B': return true;
      case '-': return false;
      case '|': return false;
      case '.': return false;
      case 'A': return false;
      case ' ': return avanzar(fila, columna); //Aquí está el backtracking
      default: return false;
    }

  }

  /**
   * Método que indica si una casilla está dentro o fuera 
   * de la matriz.
   * 
   * @param fila
   * @param columna
   * @return
   */
  public char darValor(int fila, int columna) {

    //Si el valor está dentro de una matriz
    if (fila >= 0 && fila < laberinto.length) {
      if (columna >= 0 && columna < laberinto[fila].length) {
        //Retorne dicho valor
        return this.laberinto[fila][columna];
      }
    }
    //Default (si se encuentra fuera de la matriz)
    return '-';
  }

}