import java.util.Scanner;

/**
 * Calculates the coins to give as exchange for some price.
 */
public class Ejercicio4 {
	/**
	 * Gets data from standard input.
	 */
	private Scanner input = null;

	/**
	 * Start the execution of the solution
	 *
	 * @param args Command line arguments
	 */
	public static void main(final String[] args)
	{
		Ejercicio4 solution = new Ejercicio4();
		solution.run();
	}

	/**
	 * Run the solution. This method is called from main()
	 */
	public void run()
	{
		// Create object to read data from standard input
		this.input = new Scanner(System.in);

		// Read the fare required to travel in this bus line
		final long fare = this.input.nextLong();

		// Print a table header to show payments and their exchanges
		printHeader(fare);

		// Read each payment

      while (this.input.hasNextLong()) {
			// Process the payment and print its row in the table
			printPayment(this.input.nextLong(), fare);
		}

		// Close the standard input
		this.input.close();
	}


    /**
		 * Print header.
		 * @param fare parametro
		 */
    void printHeader(final long fare) {
        if (fare <= 0) {
            System.out.printf("%5d %5s", fare, "error");
        } else {
            System.out.printf("%5d%n", fare);
            System.out.printf("%5s %5s %3s %3s %3s %3s %3s %3s%n", "PAGO",
"VUELT", "500", "100", "50", "25", "10", "5");

            System.out.printf("%5s %5s %3s %3s %3s %3s %3s %3s%n", "-----",
"-----", "---", "---", "---", "---", "---", "---");
        }
    }

	
	/**
	* Método.
	* @param payment etiqueta
	* @param fare etiqueta
	*/
  void printPayment(final long payment, final long fare) {

		if (fare <= 0) {
			//nada
    } else {

            long vuelto = payment - fare;
            String strVuelto = "";

            if (payment <= 0) {
                System.out.printf("%5d ", payment);
                System.out.printf("%5s%n", "error");
            } else {

                if (vuelto >= 0) {
                    strVuelto = String.valueOf(vuelto);
                } else {
                    strVuelto = "insuf ";
                }

                System.out.printf("%5d ", payment);
                System.out.printf("%5s", strVuelto);
                long sobrante1 = printExchangeCoin(vuelto, 500);
                long sobrante2 = printExchangeCoin(sobrante1, 100);
                long sobrante3 = printExchangeCoin(sobrante2, 50);
                long sobrante4 = printExchangeCoin(sobrante3, 25);
                long sobrante5 = printExchangeCoin(sobrante4, 10);
                printExchangeCoin(sobrante5, 5);
                System.out.println();
							}
					}

    }

	/**
	 * Print the number of required coins of the given denomination. If no coins
	 * of this denomination are required, an empty field is printed instead.
	 *
	 * @param change The amount of money to give as exchange
	 * @param denomination The coin denomination, e.g: 500 or 25
	 *
	 * @return The exchange after subtract the coins for this denomiation
	 * @example printExchangeCoin(1700, 500) will print `   3` because 3 coins
	 * of 500 colones are required to give 3x500=1500, and it will return 200
	 * because 200 colones are left to be exchanged with other denominations.
	 */
	long printExchangeCoin(long exchange, long denomination)
	{
		// Calculate the number of required coins for this denomination
		final long coins = exchange / denomination;

		// If there are to give coins, print them, otherwise print an empy field
		if (coins > 0) {
			System.out.printf(" %3d", coins);
		} else {
			System.out.printf("    ");
		}

		// Return the remaining money to exchange with other denominations
		return exchange % denomination;
	}
}