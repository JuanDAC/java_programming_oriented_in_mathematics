package metodos;

import java.util.Scanner;

public class Konra {

  public static void main(String[] args) {
    final Scanner conectionTerminal = new Scanner(System.in);
    System.out.print("Enter a value to x: ");
    System.out.println("The calculus of konrad: " + konrad(conectionTerminal.nextFloat()));
  }

  static float konrad(float x, int n) {
    if (n > 8)
      return 0;

    return (pow(2, n) * factorial(n - 2)) / pow(x, n) + konrad(x, n + 1);
  }

  static float konrad(float x) {
    return konrad(x, 3);
  }

  static float pow(float value, int exponent) {
    if (exponent <= 0)
      return 1;
    return value * pow(value, exponent - 1);
  }

  static int factorial(int number) {
    if (number <= 0)
      return 1;
    return number * factorial(number - 1);
  }

}

