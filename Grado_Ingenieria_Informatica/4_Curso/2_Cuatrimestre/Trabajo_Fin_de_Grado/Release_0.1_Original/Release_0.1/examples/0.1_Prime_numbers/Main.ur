
import urium.Console as Console;

/**
 * Application to display prime numbers between 1 
 * and a certain maximum value entered by console.
 */
library Main {

  /**
   * Application start procedure
   */
  public proc main() 
  {
    computePrimeNumbers();
    boolean again;
    continueQuestion(out again);

    while(again)
    {
      computePrimeNumbers();
      continueQuestion(out again);
    }

    Console.print('E');
    Console.print('N');
    Console.print('D');
  }

  /**
   * Computes and displays prime numbers between 1 
   * and a certain maximum value entered by console
   */
  private proc computePrimeNumbers()
  {
    int a=1;
    int max;
    boolean prime;
    maxValueQuestion(out max);
    while(a < max) 
    {
      isPrime(a, out prime);
      if( prime ) printNumber(a);
      a = a +1;
    }
  }

  /**
   * Read the maximum value
   */
  private proc maxValueQuestion(out int max)
  {
    Console.print('M');
    Console.print('a');
    Console.print('x');
    Console.print('?');
    Console.print(' ');
    Console.readInt(out max);
  }

  /**
   * Asks if the user wants to continue
   */
  private proc continueQuestion(out boolean yesno)
  {
    Console.print('C');
    Console.print('o');
    Console.print('n');
    Console.print('t');
    Console.print('i');
    Console.print('n');
    Console.print('u');
    Console.print('e');
    Console.print(' ');
    Console.print('[');
    Console.print('y');
    Console.print('/');
    Console.print('n');
    Console.print(']');
    Console.print('?');
    Console.print(' ');
    char c;
    Console.readChar(out c);
    while(c != 'y' && c != 'Y' && c != 'n' && c != 'N') Console.readChar(out c);
    yesno = (c == 'y' || c == 'Y');
    while(c != '\n') Console.readChar(out c);
    Console.print('\n');
  }

  /**
   * Writes thw number in the console
   */
  private proc printNumber(int i) 
  {
    Console.print(i);
    Console.print('\n');
  }

  /**
   * Checks if a number is prime
   */
  private proc isPrime(int i, out boolean prime) 
  {
    int j = 2;
    while(j<i) 
    {
      if(i%j == 0) { prime = false; endp;}
      j = j+1;
    }
    prime = true;
  }
}
