/**
 * The Registers class simulates a set of registers (a-z) to store BigFraction objects.
 * It provides methods to store and retrieve BigFraction values in these registers.
 * 
 * @author Rommin Adl
 */

// Implement a class that simulates registers (a-z) to store BigFraction objects.
public class Registers {
  private final BigFraction[] registers;

  /**
   * Constructs a new set of registers.
   * Initializes all registers to store the fraction 0/1.
   */
  public Registers() {
      this.registers = new BigFraction[26];
      for (int i = 0; i < this.registers.length; i++) {
          this.registers[i] = new BigFraction(0, 1); // Initialize registers with 0/1
      }
  }

  /**
   * Stores a BigFraction value in the specified register.
   *
   * @param register The register to store the value in (a-z).
   * @param val      The BigFraction value to store.
   */
  public void store(char register, BigFraction val) {
      int index = Character.toLowerCase(register) - 'a'; // Convert char to index (a=0, b=1, ..., z=25)
      if (index >= 0 && index < this.registers.length) {
          this.registers[index] = val;
      } else {
          throw new IllegalArgumentException("Register must be between a and z.");
      }
  }

  /**
   * Retrieves the BigFraction value from the specified register.
   *
   * @param register The register to retrieve the value from (a-z).
   * @return The BigFraction value stored in the register.
   */
  public BigFraction get(char register) {
      int index = Character.toLowerCase(register) - 'a'; // Convert char to index
      if (index >= 0 && index < this.registers.length) {
          return this.registers[index];
      } else {
          throw new IllegalArgumentException("Register must be between a and z.");
      }
  }
}
