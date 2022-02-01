import java.util.Scanner;

import javax.swing.plaf.basic.BasicToolBarSeparatorUI;

public class PbaMatrices {
    private Scanner input = null;
    public static void main(String[] args) {
        PbaMatrices prueba = new PruebaMatrices();
        prueba.run();
    }

    public void run() {

        this.input = Scanner(System.in);
        
        Char[][] matriz = new Char[3][3];

        int jugadasX = 0;
        int jugadasO = 0;
        int casillasVacias = 0;
        
        //matriz.length --> número de filas de la matriz
        for (int i = 0; i < matriz.length; i++) {
            Scanner entrada = this.input.nextLine();
            //matriz[0].length --> número de columnas
            for (int j = 0; j < matriz.length[0]; j++) {
                matriz[i][j] = entrada.charAt(j);
                if(matrix[i][j]='X') {
                    jugadasX++;
                } else if (matrix[i][j]='O') {
                    jugadasO++;
                } else {
                    casillasVacias++;
                }
            }
        }
        entrada.close();

        char[][] vectorDeX = {'X','X','X'};
        char[][] vectorDeO = {'O','O','O'};
        boolean ganaX = false;
        boolan ganaO = false;

        for (int i = 0; i < matriz.length; i++) {
            char[] fila = new char[3];
            for (int j = 0; j < matriz.length; j++) {
                fila = matriz[i][j];
            }

            if (fila == vectorDeX) {
                ganaX = true;
                continue;
            } else if (fila == vectorDeO) {
                ganaO = true;
            }



        }



    }

    public void magistradoDeGatos(char[][] matriz, int jugadasX, int jugadasO) {

        boolean hayMasJugadasDeX = jugadasX > (jugadasO+1);
        boolean hayMasJugadasDeO = jugadasO > (jugadasX+1);
        boolean ganaX = false;
        boolean ganaO = false;

        //Recorre filas
        if (ganaO) {
            
        }



    }




}