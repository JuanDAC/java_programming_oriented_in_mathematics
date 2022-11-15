package metodos;

import java.util.Scanner;

public class Konrad {

  public static void main(String[] args) {
    int x = 0;
    float serieDeKonrand = 0;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese un numero para x ");
    x = sc.nextInt();
    serieDeKonrand = konrad(x);
    System.out.println("El valor calculado por la serie de konrad es " + serieDeKonrand);

  }

  static float konrad(float x, int n) {
    if (n > 8)
      return 0;

    return (potencia(2, n) * factorial(n - 2)) / potencia(x, n) + konrad(x, n + 1);
  }

  static float konrad(float x) {
    return konrad(x, 3);
  }

  static float potencia(float b, int e) {
    float res = 1;
    for (int i = 1; i <= e; i++) {
      res = res * b;
    }
    return res;
  }

  static int factorial(int a) {
    int res = 1;
    for (int i = 1; i <= a; i++) {
      res = res * i;
    }
    return res;
  }

}