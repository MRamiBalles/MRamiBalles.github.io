
/**
 * Library of procedures for accessing the console
 */
native urium.Console {
  
  /**
   * Writes a character to the console
   */
  public proc print(char c);

  /**
   * Writes an integer to the console
   */
  public proc print(int i);

  /**
   * Writes an integer to the console in binary format
   */
  public proc printBits(int i);

  /**
   * Writes an integer to the console in hexadecimal format
   */
  public proc printHex(int i);

  /**
   * Reads an integer from the console
   */  
  public proc readInt(out int i);

  /**
   * Read a character from the console
   */
  public proc readChar(out char c);
 
}