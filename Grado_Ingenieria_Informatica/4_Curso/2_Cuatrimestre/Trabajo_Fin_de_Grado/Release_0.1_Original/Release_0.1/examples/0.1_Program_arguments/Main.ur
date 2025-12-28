
import urium.Console as Console;
import urium.Program as Program;

/**
 * Application using external arguments
 */
library Main {

  /**
   * Application start procedure
   */
  public proc main() {
    int argc;
    Program.getArgCount(out argc);

    printArgc(argc);

    int a = 0;
    while(a < argc)
    {
      printArgv(a);
      a = a+1;
    }

    a = 0;
    while(a < argc)
    {
      printArgLength(a);
      a = a+1;
    }
    Program.exit(5);
  }

  /**
   * Writes the argument count
   */
  private proc printArgc(int argc)
  {
    Console.print('a');
    Console.print('r');
    Console.print('g');
    Console.print('c');
    Console.print(' ');
    Console.print('=');
    Console.print(argc);
    Console.print('\n');
  }

  /**
   * Writes an argument
   */
  private proc printArgv(int a)
  {
    Console.print('a');
    Console.print('r');
    Console.print('g');
    Console.print('v');
    Console.print('[');
    Console.print(a);
    Console.print(']');
    Console.print(' ');
    Console.print('=');

    char c;
    int i=0;
    Program.getCharArg(a,i,out c);
    while(c != '\0')
    {
      Console.print(c);
      i = i+1;
      Program.getCharArg(a,i,out c);
    }

    Console.print('\n');
  }

  /**
   * Writes an argument length
   */
  private proc printArgLength(int a)
  {
    int l;
    Program.getArgLength(a,out l);

    Console.print('a');
    Console.print('r');
    Console.print('g');
    Console.print('v');
    Console.print('[');
    Console.print(a);
    Console.print(']');
    Console.print('.');
    Console.print('l');
    Console.print('e');
    Console.print('n');
    Console.print('g');
    Console.print('t');
    Console.print('h');
    Console.print('=');
    Console.print(l);
    Console.print('\n');
  }
}
