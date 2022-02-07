import java.util.Scanner;
import java.util.Arrays;

public class Ejercicio5 {
    /**
	 * Gets data from standard input
	 */
    Scanner input;
    
    /**
	 * Start the execution of the solution
	 * @param args Command line arguments
	 */
    public static void main(String[] args) {
        Ejercicio5 solution = new Ejercicio5();
        solution.run();
    }
    
    /**
	 * Run the solution. This method is called from main()
	 */
    public void run () {
        
        // Create object to read data from standard input
        this.input = new Scanner(System.in);
        int n = this.input.nextInt();
        char[][] matriz = new char[n][n];

        int jugadasJO = 0;
        int jugadasJX = 0;
        boolean hayCasillasVacias = false;
        boolean hayEntradaErronea = false;
        
        this.input.nextLine();
        this.input.nextLine();
        
        //Crea la matriz y cuenta las jugadas
        for (int i = 0; i < matriz.length; i++) {
            String cadena = this.input.nextLine();
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = cadena.charAt(j);
                if (matriz[i][j] == 'X') jugadasJX++;
                else if (matriz[i][j] == 'O') jugadasJO++;
                else if (matriz[i][j] == '-') hayCasillasVacias = true;
                else hayEntradaErronea = true;
            }
        }
        //Valida si hay entrada errónea
        if (hayEntradaErronea) {
            System.out.print("E");
        } else {
            juezGato(matriz, jugadasJX, jugadasJO, hayCasillasVacias);    
        }
        // Close the standard input
        this.input.close();
   }
   
   /**
     * Determina si hay ganador, empate o juego inválido en un juego de gato
     * generalizado, mediante la impresión por salida estándar.
     * 
     * @param matriz el gato ya validado de no tener una entrada errónea
     * @param jugadasJX intentos del jugador X
     * @param jugadasJO intentos del jugador O
     * @param hayCasillasVacias indica si el gato posee casillas sin rellenar
     */
    public void juezGato(char[][] matriz, int jugadasJX, int jugadasJO, boolean hayCasillasVacias) {
        
        //vectorDeX = ['X', 'X', ... , 'X']
        //vectorDeO = ['O', 'O', ... , 'O']
        char[] vectorDeX = new char[matriz.length];
        char[] vectorDeO = new char[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            vectorDeX[i] = 'X';
            vectorDeO[i] = 'O';
        }
        
        boolean ganaX = false;
        boolean ganaO = false;

        //Recorre filas
        for (int i = 0; i < matriz.length; i++) {
            char[] fila = new char[matriz.length];
            for (int j = 0; j < matriz.length; j++) {
                fila[j] = matriz[i][j];
            }
            if (Arrays.equals(fila, vectorDeX)) ganaX = true;
            else if (Arrays.equals(fila, vectorDeO)) ganaO = true;
        }

        //Recorre columnas
        for (int j = 0; j < matriz.length; j++) {
            char[] columna = new char[matriz.length];
            for (int i = 0; i < matriz.length; i++) {
                columna[i] = matriz[i][j];
            }
            if (Arrays.equals(columna, vectorDeX)) ganaX = true;
            else if (Arrays.equals(columna, vectorDeO)) ganaO = true;
        }

        //Recorre diagonales
        char[] diagonal1 = new char[matriz.length];
        char[] diagonal2 = new char[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            diagonal1[i] = matriz[i][i];
            diagonal2[i] = matriz[matriz.length-1-i][i];
            if (Arrays.equals(diagonal1, vectorDeX) || Arrays.equals(diagonal2, vectorDeX)) {
                ganaX = true;
            } else if (Arrays.equals(diagonal1, vectorDeO) || Arrays.equals(diagonal2, vectorDeO)) {
                ganaO = true;
            } 
        }
        
        boolean gananAmbos = ganaX && ganaO;
        boolean hayMasJugadasDeX = (jugadasJO+2 <= jugadasJX);
        boolean hayMasJugadasDeO = (jugadasJX+2 <= jugadasJO);
        
        if (gananAmbos || hayMasJugadasDeX || hayMasJugadasDeO) {
            System.out.print("E");
        } else if (ganaX) {
            System.out.print("X");
        } else if (ganaO) {
            System.out.print("O");
        } else if (!hayCasillasVacias) {
            System.out.print("=");
        } else {
            System.out.print("-");
        }
    }
}