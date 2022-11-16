package metodos;

import java.util.Scanner;

public class SerieKonrad {

  public static void main(String[] args) {
    int x = 0;
    float serieDeKonrand = 0;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese un numero para x ");
    x = sc.nextInt();
    serieDeKonrand = Konrad(x);
    System.out.println("El valor calculado por la serie de konrad es " + serieDeKonrand);

  }

  static float Konrad(float x) {
    float sumatoria = 0;
    for (int n = 3; n <= 8; n++) {
      sumatoria = sumatoria + (potencia(2, n) * factorial(n - 2)) / potencia(x, n);
    }
    return sumatoria;
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