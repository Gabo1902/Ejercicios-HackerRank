package QuintaPráctica.proofs;


import java.util.*;

public class Pba {
    private Scanner input = null;
    public static void main(String[] args) {
        Pba prueba = new Pba();
        prueba.run();
    }

    void run() {
        this.input = new Scanner("5: Palaos | Australia | Fiyi | Nueva Zelanda | Micronesia");
        
        this.input.useDelimiter("(([:][\\s])|([\\s][|][\\s]))+");
        int numero = this.input.nextInt();
        while(this.input.hasNextLine()) {
            String entrada = this.input.next();
            System.out.println(entrada);
        }
    }
}