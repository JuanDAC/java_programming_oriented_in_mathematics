package metodos;

public class Metodos {

  static float pot(float b, int e) {
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

  static float gradarad(int g) {
    float res;
    res = (float) (g * 3.1416) / (float) 180;
    return res;
  }

  static float sen(int a) {
    float res = 0, x;
    x = gradarad(a);
    for (int n = 0; n <= 4; n++)
      res += pot(-1, n) * pot(x, 2 * n + 1) / factorial(2 * n + 1);
    return res;
  }

  static float cos(int a) {
    float res = 0, x;
    x = gradarad(a);
    for (int n = 0; n <= 4; n++)
      res += pot(-1, n) * pot(x, 2 * n) / factorial(2 * n);
    return res;
  }

  static float tan(int a) {
    return sen(a) / cos(a);
  }

  public static void main(String[] args) {
            int alfag;
            float senx,cosx,tanx;
            Scanner sc=new Scanner(System.in);
            System.out.println("Ingrese un angulo en grados ");
            alfag=sc.nextInt();
            senx=sen(alfag);
            cosx=cos(alfag);
            tanx=tan(alfag);45
         System.out.println("El seno es "+senx);
         System.out.println("El coseno es "+cosx);
         System.out.println("La tamgente es "+tanx);
    }

}