package metodos;

import java.util.Scanner;

public class Konrad {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    float value = 0.0f, result = 0.0f;
    System.out.println("Enter a value to x ");
    value = sc.nextFloat();
    result = konrad(value);
    System.out.println("The calculus of konrad  " + result);
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
    if (exponent <= 0) {
      return 1;
    }
    return value * pow(value, exponent - 1);
  }

  static int factorial(int number) {
    if (number <= 0) {
      return 1;
    }

    int res = 1;
    for (int i = 1; i <= a; i++) {
      res = res * i;
    }
    return res;
  }

}