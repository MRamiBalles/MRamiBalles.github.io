
import urium.Console as Console;

/**
 * Application that shows an integer in decimal, binary and hexadecimal formats
 */
library Main {

  /**
   * Application start procedure
   */
  public proc main() {
    int n;

    Console.print('N');
    Console.print('u');
    Console.print('m');
    Console.print('b');
    Console.print('e');
    Console.print('r');
    Console.print('?');
    Console.print(' ');

    Console.readInt(out n);

    Console.print('d');
    Console.print('e');
    Console.print('c');
    Console.print(' ');
    Console.print('=');
    Console.print(' ');
    Console.print(n);
    Console.print('\n');

    Console.print('b');
    Console.print('i');
    Console.print('n');
    Console.print(' ');
    Console.print('=');
    Console.print(' ');
    Console.printBits(n);
    Console.print('\n');

    Console.print('h');
    Console.print('e');
    Console.print('x');
    Console.print(' ');
    Console.print('=');
    Console.print(' ');
    Console.print('0');
    Console.print('x');
    Console.printHex(n);
    Console.print('\n');
  }

}
