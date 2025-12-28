
import urium.Console as Console;

/**
 * Application that shows the factorial of a number
 */
library Main {

  /**
   * Application start procedure
   */
  public proc main() {
    int a=5;
    int f;
    factorial(a, out f);

    Console.print(a);
    Console.print('!');
    Console.print('=');
    Console.print(' ');
    Console.print(f);
  }

  /**
   * Computes the factorial of a number
   */
  private proc factorial(int a, out int fact) {
    if(a == 1)
    {
      fact = 1;
    }
    else
    {
      int c;
      factorial(a-1, out c);
      fact = a*c;
    }
  }
}
