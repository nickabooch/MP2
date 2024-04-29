/**
 * An interactive calculator that uses BigFraction objects for calculations. It includes basic arithmetic operations
 * and maintains the last computed value. Additionally, it integrates with a set of registers for storing
 * and retrieving calculation results. The calculator provides an interactive command-line interface for users to
 * perform calculations and manage registers.
 * 
 * @author Rommin Adl
 */

import java.util.Scanner;

public class InteractiveCalculator {
  private BFCalculator calculator;
  private Registers registers;

  public InteractiveCalculator() {
    this.calculator = new BFCalculator();
    this.registers = new Registers();
    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to the Interactive Fraction Calculator");
    System.out.println("Type 'QUIT' to exit.");
    System.out.println("Use 'STORE <register>' to store the last computed value into a register (a-z).");
    System.out.println("Use '+', '-', '*', '/' for operations. Examples: '1/2 + 1/3', 'a + 1/4', 'STORE a'");

    while (true) {
      System.out.print("> ");
      String inputLine = scanner.nextLine().trim();

      // Check for quit command
      if ("QUIT".equalsIgnoreCase(inputLine)) {
        System.out.println("Calculator exiting...");
        break;
      }

      // Process input
      processInput(inputLine);
    }

    scanner.close();
  }

  private void processInput(String inputLine) {
    try {
      if (inputLine.startsWith("STORE")) {
        // Extract register name and store the last value
        char register = Character.toLowerCase(inputLine.split(" ")[1].charAt(0));
        registers.store(register, calculator.get());
        System.out.println("Stored in register " + register);
      } else {
        // Perform calculation
        String[] tokens = inputLine.split(" ");
        BigFraction result = null;
        char operator = '\0';

        for (String token : tokens) {
          if (token.matches("[+\\-*/]")) {
            operator = token.charAt(0);
          } else if (Character.isLetter(token.charAt(0))) {
            char firstToken = Character.toLowerCase(token.charAt(0));
            BigFraction operand = registers.get(firstToken);
            if (result == null) {
              result = operand;
            } else {
              switch (operator) {
                case '+':
                  result = result.add(operand);
                  break;
                case '-':
                  result = result.subtract(operand);
                  break;
                case '*':
                  result = result.multiply(operand);
                  break;
                case '/':
                  result = result.divide(operand);
                  break;
                default:
                  System.err.println("Unsupported operation.");
                  return;
              }
            }
          } else {
            BigFraction operand = new BigFraction(token);
            if (result == null) {
              result = operand;
            } else {
              switch (operator) {
                case '+':
                  result = result.add(operand);
                  break;
                case '-':
                  result = result.subtract(operand);
                  break;
                case '*':
                  result = result.multiply(operand);
                  break;
                case '/':
                  result = result.divide(operand);
                  break;
                default:
                  System.err.println("Unsupported operation.");
                  return;
              }
            }
          }
        }

        calculator.clear(); // Resetting calculator's last value for the new result
        calculator.add(result); // Setting new result as the last value
        System.out.println("Result: " + result);
      }
    } catch (Exception e) {
      System.err.println("Error processing command: " + e.getMessage());
    }
  }

  public static void main(String[] args) {
    new InteractiveCalculator();
  }
}
