
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

    int index = 0;
    int arg;
    int count = 0;
    int min = -1;
    int max = -1;
    int acc = 0;
    while(index < argc)
    {
      Program.getIntArg(index,out arg);
      if(arg >= 0)
      {
        count = count + 1;
        if(arg < min || min < 0) min = arg;
        if(arg > max) max = arg;
        acc = acc + arg;
      }
      index = index +1;
    }

    printCount(count);
    printMin(min);
    printMax(max);
    printMean(acc/count);
  }

  /**
   * Writes the argument count
   */
  private proc printCount(int count)
  {
    Console.print('c');
    Console.print('o');
    Console.print('u');
    Console.print('n');
    Console.print('t');
    Console.print('=');
    Console.print(count);
    Console.print('\n');
  }

  /**
   * Writes the argument minimum
   */
  private proc printMin(int min)
  {
    Console.print('m');
    Console.print('i');
    Console.print('n');
    Console.print('=');
    Console.print(min);
    Console.print('\n');
  }

  /**
   * Writes the argument maximum
   */
  private proc printMax(int max)
  {
    Console.print('m');
    Console.print('a');
    Console.print('x');
    Console.print('=');
    Console.print(max);
    Console.print('\n');
  }

  /**
   * Writes the argument mean
   */
  private proc printMean(int mean)
  {
    Console.print('m');
    Console.print('e');
    Console.print('a');
    Console.print('n');
    Console.print('=');
    Console.print(mean);
    Console.print('\n');
  }
}
