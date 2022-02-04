import java.util.*;

public class Pba {
    private Scanner input = null;
    public static void main(String[] args) {
        Pba prueba = new Pba();
        prueba.run();
    }

    void run() {
        int[] arreglo1 = {1,2,3,4,5};
        int[] arreglo2 = {5,4,3,1,0};

        boolean isPlagiarism = haveEnoughCoincidences(arreglo1, arreglo2);
        System.out.println(isPlagiarism);
    }

    boolean haveEnoughCoincidences(int[] array1, int[] array2) {
        
        boolean haveSameValues = false;

        //We know both arrays have the same number of elements
        int contador = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) contador++;
                continue;
            }
        }

        if (contador >= array1.length) {
            haveSameValues = true;
        }


        return null;
    }

}