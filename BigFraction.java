import java.math.BigInteger;

/**
 * Extends basic Fraction functionality with additional arithmetic operations.
 * Ensures fractions are always in their simplest form.
 * Supports operations with both BigFraction instances and string representations.
 * @author Rommin Adl
 */
public class BigFraction {
  private BigInteger numerator;
  private BigInteger denominator;

  // Constructor with BigInteger parameters
  public BigFraction(BigInteger numerator, BigInteger denominator) {
    if (denominator.equals(BigInteger.ZERO)) {
      throw new IllegalArgumentException("Denominator cannot be zero.");
    }
    // Ensure the denominator is positive
    if (denominator.compareTo(BigInteger.ZERO) < 0) {
      numerator = numerator.negate();
      denominator = denominator.negate();
    }
    BigInteger gcd = numerator.gcd(denominator);
    this.numerator = numerator.divide(gcd);
    this.denominator = denominator.divide(gcd);
  } // BigFraction(BigInteger, BigInteger)

  // Constructor with int parameters
  public BigFraction(int numerator, int denominator) {
    this(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
  } // BigFraction(int, int)

  // Constructor for parsing from a String
  public BigFraction(String fraction) {
    int slashIndex = fraction.indexOf('/');
    if (slashIndex == -1) { // Whole number support
      this.numerator = new BigInteger(fraction);
      this.denominator = BigInteger.ONE;
    } else {
      BigInteger num = new BigInteger(fraction.substring(0, slashIndex));
      BigInteger denom = new BigInteger(fraction.substring(slashIndex + 1));
      BigInteger gcd = num.gcd(denom);
      this.numerator = num.divide(gcd);
      this.denominator = denom.divide(gcd);
    }
  } // BigFraction(String)

  // Add a BigFraction to this one
  public BigFraction add(BigFraction other) {
    BigInteger newNumerator = this.numerator.multiply(other.denominator)
                            .add(other.numerator.multiply(this.denominator));
    BigInteger newDenominator = this.denominator.multiply(other.denominator);
    return new BigFraction(newNumerator, newDenominator);
  } // add(BigFraction)

  // Subtract another BigFraction from this one
  public BigFraction subtract(BigFraction other) {
    BigInteger newNumerator = this.numerator.multiply(other.denominator)
                            .subtract(other.numerator.multiply(this.denominator));
    BigInteger newDenominator = this.denominator.multiply(other.denominator);
    return new BigFraction(newNumerator, newDenominator);
  } // subtract(BigFraction)

  // Multiply this BigFraction by another
  public BigFraction multiply(BigFraction other) {
    return new BigFraction(this.numerator.multiply(other.numerator),
                           this.denominator.multiply(other.denominator));
  } // multiply(BigFraction)

  // Divide this BigFraction by another
  public BigFraction divide(BigFraction other) {
    return new BigFraction(this.numerator.multiply(other.denominator),
                           this.denominator.multiply(other.numerator));
  } // divide(BigFraction)

  @Override
  public String toString() {
    if (this.denominator.equals(BigInteger.ONE)) {
      return this.numerator.toString();
    } // if
    return this.numerator + "/" + this.denominator;
  } // toString()

  // Getters for numerator and denominator
  public BigInteger getNumerator() {
    return numerator;
  } // getNumerator()

  public BigInteger getDenominator() {
    return denominator;
  } // getDenominator()
} // class BigFraction
