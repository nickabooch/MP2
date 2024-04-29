# Mini-Project 2: Fun with Fractions

## Authors
@Rommin Adl

## Purpose
This project is an assignment for CSC 207-01 (Spring 2024) at Grinnell College. The goal is to build a calculator (or perhaps many calculators) that uses fractions as its basic numeric type and includes registers. The calculator can process expressions, store commands, or quit.

The project includes the following classes:
- `BigFraction.java`: This is  extended version of the Fraction class I did in class with Shibam. It reduces fractions to the simplest form and implements operations such as     -  subtraction and division.
- `BFCalculator.java`: This class has a field that stores the last value calculated and provides methods for basic arithmetic operations.
- `Registers.java`: A set of registers corresponding to the letters a through z. This class has an array that stores 26 different BigFraction values.
- `InteractiveCalculator.java`: Provides a main method that repeatedly reads a line the user types, uses a BFCalculator to compute the result, and prints the result for the user.
- `QuickCalculator.java`: Provides a main method that takes the expressions from the command line and then prints out the results.

## Acknowledgements
https://rebelsky.cs.grinnell.edu/Courses/CSC207/2024Sp/mps/mp02.html
https://rebelsky.cs.grinnell.edu/Courses/CSC207/2024Sp/labs/unit-testing.html
https://rebelsky.cs.grinnell.edu/Courses/CSC207/2024Sp/labs/intro-classes.html
