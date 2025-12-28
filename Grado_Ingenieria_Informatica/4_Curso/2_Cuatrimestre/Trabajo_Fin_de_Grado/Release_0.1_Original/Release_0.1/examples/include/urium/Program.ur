
/**
 * Library of procedures for accessing application arguments
 */
native urium.Program {
  
  /**
   * Gets the number of arguments
   */
  public proc getArgCount(out int argc);

  /**
   * Gets the length of the i-th argument
   * (Returns -1 if it does not exist)
   */
  public proc getArgLength(int index, out int length);

  /**
   * Gets the i-th argument as an integer
   * (Returns -1 if it does not exist or is not a number)
   */
  public proc getIntArg(int index, out int arg);

  /**
   * Gets the j-th character of the i-th argument
   * (Returns '\0' if it does not exist)
   */  
  public proc getCharArg(int index, int pos, out char arg);

  /**
   * Ends the program execution
   */
  public proc exit(int code);
 
}