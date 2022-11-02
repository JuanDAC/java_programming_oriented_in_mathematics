package Math.Derivate;

import java.util.Scanner;

public class Derivate {
  final static Scanner terminalConection = new Scanner(System.in);
  final static int[] coefficient = new int[9];
  final static int[] derivativeCoefficient = new int[8];

  public static void main(String[] args) {
    int selection = 0;
    boolean isExit = false;
    System.out.println("By JuanDAC, Thanks for use my menu (^-^)/");
    System.out.println("Wellcome to my menu!");

    while (isExit == false) {

      // TODO: Integates, Plot
      String[] options = {
          "Load terms",
          "Show function",
          "Evaluate function",
          "Calculate and Show derivative",
          "Evaluate derivative",
          "Exit"
      };
      selection = createMenu(options);

      /*--------------------------------------------------------------- */
      /* Print the Selection option */
      /*--------------------------------------------------------------- */
      System.out.println("Your selection is " + options[selection] + "!!!");
      System.out.println("\n");

      if (options[selection] == "Load terms")
        loadData();

      if (options[selection] == "Show function")
        showEquation("function", coefficient);

      if (options[selection] == "Evaluate function")
        evaluateFunction();

      if (options[selection] == "Calculate and Show derivative")
        calculateAndShowDerivate();

      if (options[selection] == "Evaluate derivative")
        evaluateDerivative();

      isExit = options[selection] == "Exit";

      System.out.println("\nType Enter to continue");
      terminalConection.nextLine();
      terminalConection.nextLine();
      System.out.println("\n");
    }
    terminalConection.close();
  }

  public static void calculateAndShowDerivate() {

    showEquation("function", coefficient);
    System.out.println("");
    for (int n = 1; n < coefficient.length; n++) {
      derivativeCoefficient[n - 1] = n * coefficient[n];
    }
    showEquation("derivative", derivativeCoefficient);
  }

  public static int createMenu(String[] options) {
    int selection = 0;

    do {
      System.out.println("Here you could select bellow options");
      for (int i = 0; i < options.length; i++) {
        System.out.println(" " + (i + 1) + ": " + options[i]);
      }
      System.out.print("Please select any option with the number: ");
      selection = terminalConection.nextInt() - 1;
    } while (selection < 0 || selection >= options.length);
    System.out.println("\n");

    return selection;
  }

  public static void clearCoefficient() {
    for (int i = 0; i < coefficient.length; i++) {
      coefficient[i] = 0;
    }
  }

  public static int ABS(int value) {
    return value < 0 ? -1 * value : value;
  }

  public static void loadData() {
    int selection = 0;
    String[] options = {
        "Enter exponent by exponent",
        "Enter a linear",
        "Enter a quadratic",
        "Enter a cubic"
    };
    String[] optionsContinue = {
        "Enter the function again",
        "Continue",
    };
    boolean isExit = false;
    while (isExit == false) {
      clearCoefficient();
      selection = createMenu(options);
      if (options[selection] != "Enter exponent by exponent" && options[selection] != "Exit") {
        for (int i = 1; i <= selection; i++) {
          System.out.print("Type your coefficient for the exponent " + i + " number here: ");
          coefficient[i] = terminalConection.nextInt();
        }
        System.out.print("Type the independent term here: ");
        coefficient[0] = terminalConection.nextInt();
      }
      if (options[selection] == "Enter exponent by exponent") {
        for (int i = 0; i < coefficient.length; i++) {
          System.out.print("Type your coefficient for the exponent " + i + " number here: ");
          coefficient[i] = terminalConection.nextInt();
        }
      }

      System.out.print("\n");
      showEquation("enter function", coefficient);
      System.out.print("");
      selection = createMenu(optionsContinue);
      isExit = optionsContinue[selection] != "Enter the function again";
    }
  }

  public static void showEquation(String message, int[] coefficient) {
    boolean firstPrint = false;

    firstPrint = false;
    System.out.print("The " + message + " is:");
    for (int i = 1; i < coefficient.length; i++) {
      if (i == 1 && coefficient[i] != 0) {
        if (firstPrint)
          System.out.print((coefficient[i] < 0) ? "-" : "+");
        System.out.print(" " + ABS(coefficient[i]) + "x ");
        firstPrint = true;
      }
      if (i != 1 && i != 0 && coefficient[i] != 0) {
        if (firstPrint)
          System.out.print((coefficient[i] < 0) ? "-" : "+");
        System.out.print(" " + ABS(coefficient[i]) + "x^" + i + " ");
        firstPrint = true;
      }
    }
    if (coefficient[0] != 0) {
      if (firstPrint)
        System.out.print((coefficient[0] < 0) ? "-" : "+");
      System.out.print(" " + ABS(coefficient[0]));
      firstPrint = true;
    }
    System.out.println("");
  }

  public static int calculateFunction(int x, int[] coefficient) {
    int value = 0;
    for (int i = 0; i < coefficient.length; i++) {
      value += coefficient[i] * Math.pow(x, i);
    }
    return value;
  }

  public static void evaluateFunction() {
    int x = 0, value = 0;
    System.out.print("Input value for x to evaluate: ");
    x = terminalConection.nextInt();
    value = calculateFunction(x, coefficient);
    showEquation("function", coefficient);
    System.out.print("When x is " + x + " the value of the function is: " + value);
  }

  public static void evaluateDerivative() {
    int x = 0, value = 0;
    System.out.print("Input value for x to evaluate: ");
    x = terminalConection.nextInt();
    value = calculateFunction(x, derivativeCoefficient);
    showEquation("derivative", derivativeCoefficient);
    System.out.print("When x is " + x + " the value of the derivative is: " + value);
  }

}
