
import urium.Console as Console;

/**
 * Application that shows the result of a sum
 */
library Main {

  /**
   * Application start procedure
   */
  public proc main() {
    int a=3;
    int b=2;
    int c= a+b;

    Console.print(a);
    Console.print(' ');
    Console.print('+');
    Console.print(' ');
    Console.print(b);
    Console.print(' ');
    Console.print('=');
    Console.print(' ');
    Console.print(c);
  }
}
