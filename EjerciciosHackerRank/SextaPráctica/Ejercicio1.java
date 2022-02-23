import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Calculates the greatest common divisor of two integers recursively
 * and prints the number of function calls required to calculate them
 */
public class Ejercicio1
{
  /**
   * Gets data from standard input
   */
  private Scanner input = null;

  /**
   * Number of function calls requierd to calculate the gcd
   */
  private long callCount = 0;

  /**
   * Start the execution of the solution
   * @param args Command line arguments
   */
  public static void main(String[] args)
  {
    Ejercicio1 solution = new Ejercicio1();
    solution.run();
  }

  /**
   * Run the solution. This method is called from main()
   */
  public void run()
  {
    // Create object to read data from standard input
    this.input = new Scanner(System.in);

    while (this.input.hasNextLong()) {

      long num1 = this.input.nextLong();
      long num2 = this.input.nextLong();

      long a = valorAbsoluto(num1);
      long b = valorAbsoluto(num2);
      
      long mcd = calcularMCD(a, b);

      DecimalFormat formato = new DecimalFormat("###,###.##");

      String formattedNum1 = formato.format(num1);
      String formattedNum2 = formato.format(num2);

      System.out.printf("%s %s: %d (%d)%n", formattedNum1, formattedNum2, mcd , callCount);
      callCount = 0;
    }

    // Close the standard input
    this.input.close();
  }

  public long calcularMCD(long a, long b) {
    callCount++;
    if (a == 0 && b == 0) {
      return 0;
    } else if (a == 0) {
      return calcularMCD(b, a);
    } else if (b == 0) {
      return a;
    } else if (a >= b) {
      return calcularMCD(b, a % b);
    } else {
      return calcularMCD(b,a);
    }

  }

  public long valorAbsoluto(final long num) {
    return (num >= 0)?(num):(-1*num);
  }

}
