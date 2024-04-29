/**
 * QuickCalculator processes arithmetic expressions provided as command-line arguments.
 * It supports basic operations and register storage with BigFraction objects.
 * 
 * @author Rommin Adl
 */
public class QuickCalculator {
    private static BFCalculator calculator = new BFCalculator();
    private static Registers registers = new Registers();
  
    public static void main(String[] args) {
      // Check if there are command-line arguments provided
      if (args.length == 0) {
        System.out.println("No expressions provided.");
        return;
      }
  
      // Process each command-line argument as an expression
      for (String arg : args) {
        processExpression(arg);
      }
    }
  
    private static void processExpression(String expression) {
      // Split the expression into parts by spaces
      String[] parts = expression.split(" ");
  
      // Check for store command
      if (parts[0].equalsIgnoreCase("STORE") && parts.length == 2) {
        char register = parts[1].charAt(0);
        // Assuming getLastComputedValue() retrieves the last computed value from calculator
        BigFraction value = calculator.getLastComputedValue();
        registers.store(register, value);
        System.out.println("Stored " + value + " in register " + register);
      } else {
        // Adjusted to reflect a generic method call structure
        try {
          // Assuming calculate method exists that can parse and evaluate expressions directly
          BigFraction result = calculate(expression);
          System.out.println(expression + " = " + result);
        } catch (Exception e) {
          System.err.println("Error processing expression: " + expression);
        }
      }
    }
  
    // Assuming a static method calculate that takes a String expression and processes it
    private static BigFraction calculate(String expression) {
      // Implementation details depend on how BFCalculator and Registers are set up
      // This is a placeholder for actual calculation logic
      return new BigFraction("1/1"); // Placeholder return
    }
  
    private static BigFraction parseFraction(String input) {
      // This method parses a fraction or a register value from a string
      if (Character.isLetter(input.charAt(0))) {
        // Retrieve value from register
        return registers.get(input.charAt(0));
      } else {
        // Parse as a fraction
        return new BigFraction(input);
      }
    }
  }
  