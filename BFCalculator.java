import java.math.BigInteger;

/**
 * This is a calculator that uses BigFraction objects for calculations. It has pretty basic arithmetic ops
 * and integrates with a set of registers for storing and retrieving calculation results.
 * 
 * @author Rommin Adl
 */
public class BFCalculator {
  private BigFraction lastValue;
  private Registers registers;

  /**
   * Initializes the calculator with a 0 value and initializes registers.
   */
  public BFCalculator() {
    this.lastValue = new BigFraction(0, 1); 
    this.registers = new Registers();
  }

  /**
   * Returns the last computed BigFraction value.
   * 
   * @return The last computed value.
   */
  public BigFraction get() {
    return this.lastValue;
  }

  /**
   * Adds a given BigFraction to the last computed value.
   * 
   * @param val The BigFraction to add.
   */
  public void add(BigFraction val) {
    this.lastValue = this.lastValue.add(val);
  }

  /**
   * Subtracts a given BigFraction from the last computed value.
   * 
   * @param val The BigFraction to subtract.
   */
  public void subtract(BigFraction val) {
    this.lastValue = this.lastValue.subtract(val);
  }

  /**
   * Multiplies the last computed value by a given BigFraction.
   * 
   * @param val The BigFraction to multiply by.
   */
  public void multiply(BigFraction val) {
    this.lastValue = this.lastValue.multiply(val);
  }

  /**
   * Divides the last computed value by a given BigFraction.
   * 
   * @param val The BigFraction to divide by.
   */
  public void divide(BigFraction val) {
    this.lastValue = this.lastValue.divide(val);
  }

  /**
   * Resets the last computed value to zero.
   */
  public void clear() {
    this.lastValue = new BigFraction(0, 1);
  }

  /**
   * Stores the current lastValue in the specified register.
   * 
   * @param register The register (a-z) where the lastValue should be stored.
   */
  public void storeInRegister(char register) {
    this.registers.store(register, this.lastValue);
  }

  /**
   * Loads a BigFraction value from the specified register and sets it as the last computed value.
   * 
   * @param register The register (a-z) from which to load the value.
   */
  public void loadFromRegister(char register) {
    this.lastValue = this.registers.get(register);
  }

  /**
   * Gets the last computed BigFraction value.
   * 
   * @return The last computed BigFraction value.
   */
  public BigFraction getLastComputedValue() {
    return this.lastValue;
  }
}
