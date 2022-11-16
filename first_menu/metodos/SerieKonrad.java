
import java.util.Scanner;

public class Parcial {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int evaluar = sc.nextInt();
    System.out.println(Konrad(evaluar));
  }

  static float Konrad(float entrada) {
    float konrad = 0;
    
    for (int i = 3; i <= 8; i++) {
      konrad += (pot(2, i) * factorial(i - 2)) / pot(entrada, i);
    }

    return konrad;
  }

  static float pot(float valor, int e) {
    float resultado = 1;
    for (int i = 1; i <= e; i++) {
      resultado = resultado * valor;
    }
    return resultado;
  }

  static int factorial(int a) {
    int resultado = 1;
    for (int i = 1; i <= a; i++) {
      resultado = resultado * i;
    }
    return resultado;
  }

}
