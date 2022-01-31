package EjerciciosHackerRank.TerceraPráctica;

import java.util.Scanner;

public class Prueba {
    
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Inserte un String: ");
        String pba1 = entrada.next();

        System.out.print("Inserte otro String: ");
        String pba2 = entrada.next();
        
        /*
        if(!pba1.equals("R") && !pba2.equals("S")) {
            System.out.println("No es lo que esperaba.");
        } else {
            System.out.println("Es lo que esperaba.");
        }
        */

        if(pba1 != "R" && pba2 != "S") {
            System.out.println("No es lo que esperaba.");
        } else {
            System.out.println("Es lo que esperaba.");
        }

        entrada.close();
    }
}


/*


public void run()
    {
        // Create object to read data from standard input
        this.input = new Scanner(System.in);

        // This code replicates the input to the standard output
        // Modify this code to solve the problem
        double ganaJug1 = 0;
        double ganaJug2 = 0;
        double empates = 0;
        double intentos = 0;

        while ( this.input.hasNext() )
        {
            String jug1 = "";
            String jug2 = "";
            
            if(this.input.hasNext("[^RPS]")) {
                jug1 = this.input.next();
                System.out.printf("invalid shape: %s", jug1);
                continue;
            } else {
                jug1 = this.input.next();
            }

            if(this.input.hasNext("[^RPS]")){
                jug2 = this.input.next();
                System.out.printf("invalid shape: %s", jug2);
                continue;
            }
            else {
                jug2 = this.input.next();
            }
            
            if( jug1.equals(jug2) ) {
                empates++;
            }
            
            if( jug1.equals(jug2) ) {
                empates++;
            } else if( (jug1.equals("P") && jug2.equals("R")) || (jug1.equals("R") && jug2.equals("S")) || (jug1.equals("S") && jug2.equals("P")) ) {
                ganaJug1++;
            } else {
                ganaJug2++;
            }
            
            intentos++;
        }

        imprimirResultados(ganaJug1, ganaJug2, empates, intentos);

        // Close the standard input
        this.input.close();
    }

    public void imprimirResultados(double ganaJug1, double ganaJug2, double empates, double intentos) {
        
        double player1 = ganaJug1;
        double player2 = ganaJug2;
        double draws = empates;
        double total = intentos;
        
        double player1Percentage = calcularPorcentaje(player1, total);
        double player2Percentage = calcularPorcentaje(player2, total);
        double drawsPercentage = calcularPorcentaje(draws, total);
        
        //En teoría siempre debe dar 100
        double totalPercentage = player1Percentage + player2Percentage + drawsPercentage;
        
        System.out.printf("%8s %3.0f %3.0f%%%n", "Player1:", player1, player1Percentage);
        System.out.printf("%8s %3.0f %3.0f%%%n", "Player2:", player2, player2Percentage);
        System.out.printf("%8s %3.0f %3.0f%%%n", "Draws:", draws, drawsPercentage);
        System.out.printf("%8s %3.0f %3.0f%%%n", "Total:", total, totalPercentage);
        System.out.println();
        
        if(player1==player2){
            System.out.printf("%8s", "Draw!");
        } else if(player1>player2) {
            System.out.printf("%8s Player1", " Winner:");
        } else {
            System.out.printf("%8s Player2", " Winner:");
        }
    }

    public double calcularPorcentaje( double num, double total) {
        double porcentaje = (num/total)*100;
        return porcentaje;
    }




*/