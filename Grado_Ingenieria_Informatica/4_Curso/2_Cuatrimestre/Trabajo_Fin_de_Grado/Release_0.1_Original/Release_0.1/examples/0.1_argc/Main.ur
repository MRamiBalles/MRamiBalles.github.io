
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

    int length;
    int arg = 0;
    while(arg<argc) 
    {
      Program.getArgLength(arg, out length);
      printLength(arg, length);
      arg = arg+1;
    }   
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


  private proc printLength(int arg, int l)
  {
    Console.print('l');
    Console.print('e');
    Console.print('n');
    Console.print('g');
    Console.print('t');
    Console.print('h');
    Console.print('[');
    Console.print(arg);
    Console.print(']');
    Console.print(' ');
    Console.print('=');
    Console.print(l);
    Console.print('\n');
  }

}
