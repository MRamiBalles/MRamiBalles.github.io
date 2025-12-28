
import urium.Console as Console;

/**
 * Example of using out type variables. 
 * Exchanging values between variables.
 */
library Main {

  /**
   * Application start procedure
   */
  public proc main() {
    int a = 5;
    int b = 6;
    print(a,b);
    exchange(out a, out b);
    print(a,b);
  }

  /**
   * Procedure to exchange values
   */
  private proc exchange(out int a, out int b)
  {
    int aux = a;
    a = b;
    b = aux;
  }

  /**
   * Displays values in console
   */
  private proc print(int a, int b)
  {
    Console.print('a');
    Console.print(' ');
    Console.print('=');
    Console.print(' ');
    Console.print(a);
    Console.print(';');
    Console.print('\t');
    Console.print('b');
    Console.print(' ');
    Console.print('=');
    Console.print(' ');
    Console.print(b);
    Console.print('\n');
  }
}
