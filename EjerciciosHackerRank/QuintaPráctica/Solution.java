import java.io.*;
import java.util.*;

public class Solution {

    private Scanner input = null;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Solution solution = new Solution();
        solution.run();
        
    }

    /**
     * Método que lleva a cabo la coordinación de las funciones del programa
     */
    public void run(){

        this.input = new Scanner(System.in);
        this.input.useDelimiter("([:][\\s])|([\\s][|][\\s])|(\\n)");

        int elementosSolicitados = this.input.nextInt();
        String[] tareaDePrueba = new String[elementosSolicitados];
        
        for (int i = 0; i < tareaDePrueba.length; i++) {

            tareaDePrueba[i] = this.input.next();
        }
        
        /*
        System.out.println(Arrays.toString(tareaDePrueba));
        System.out.println(tareaDePrueba[4]);
        */
        
        this.input.nextLine();
        while (this.input.hasNext()) {

            int estudiante = this.input.nextInt();
            String[] tareaSospechosa = new String[elementosSolicitados];
            
            //Lee las tareas sospechosas
            for (int j = 0; j < tareaSospechosa.length; j++) {
                tareaSospechosa[j] = this.input.next();
            }
            inspeccionar(estudiante, elementosSolicitados, tareaDePrueba, tareaSospechosa);
        }
    }

    //El problema está aquí
    /**
     * Método que identifica el grado de similitud entre los valores de dos arreglos. Si hay un 100% de similitud, imprime que hay plagio, de lo contrario imprime el porcentaje de coincidencias.
     * 
     * @param caso Número del caso a inspeccionar
     * @param longitudArreglos Para que este método funcione, ambos arreglos deben tener la misma longitud
     * @param arreglo1 Primer arreglo a inspeccionar
     * @param arreglo2 Segundo arreglo a inspeccionar
     */
    public void inspeccionar(int caso, int longitudArreglos, String[] arreglo1, String[] arreglo2) {

        double k = (double) longitudArreglos;
        double coincidencias = 0.0;
        double diferencias = 0.0;

        //Identifica si hay coincidencias o no
        for (int i = 0; i < longitudArreglos; i++) {
            for (int j = 0; j < longitudArreglos; j++) {
                String cadena = arreglo1[i];
                if (cadena.equals(arreglo2[j])) {
                    coincidencias++;
                }
            }
        }

        //Juzga si hay plagio o no
        if (coincidencias >= longitudArreglos) {
            System.out.println(caso + ": plagiarism");
        } else {
            double porCoincidencias = (coincidencias/longitudArreglos)*100;
            if (porCoincidencias == 0) {
                System.out.printf("%d: original%n", caso);
            } else {
                System.out.printf("%d: %.0f%%%n", caso, porCoincidencias);
            }
        }
    }
}