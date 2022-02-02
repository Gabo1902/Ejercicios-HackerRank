import java.util.Scanner;

public class PbaMatrices {

    private Scanner input = null;
    public static void main(String[] args) {
        PbaMatrices prueba = new PbaMatrices();
        prueba.run();
    }

    public void run() {

        Scanner entrada = new Scanner(System.in);

        String cadena = entrada.nextLine();

        char[] arreglo = new char[3];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = cadena.charAt(i);
        }
        char[] filaDeX = {'X','X','X'};

        boolean sonIguales = (filaDeX == arreglo); //Problemático
        System.out.println(sonIguales);

        entrada.close();
    }
}