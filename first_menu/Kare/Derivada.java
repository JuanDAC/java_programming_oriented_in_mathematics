package Kare;

import java.util.Scanner;

public class Derivada {
  public static void main(String[] args) {
    int[] coeficientes = new int[9];
    int[] coeficientesDeDerivada = new int[8];
    Scanner sc = new Scanner(System.in);
    int opcion = 0;
    int x = 0;
    double suma = 0;

    while (opcion != 6) {
      do {
        System.out.println("1. cargar terminos");
        System.out.println("2. mostrar funcion");
        System.out.println("3. evaluar funcion");
        System.out.println("4. calcular y derivar");
        System.out.println("5. evaluar derivada");
        System.out.println("6. salir");
        System.out.println("ingrese numero de la opcion del menu");
        opcion = sc.nextInt();
      } while (opcion < 0 && opcion > 6);

      switch (opcion) {
        case 1:
          // cargar terminos//
          for (int i = 0; i < coeficientes.length; i++) {
            // leer del usuario los coeficientes y los guardamos en el array //
            System.out.print("Ingrese el coeficiente del exponente " + i + ": ");
            coeficientes[i] = sc.nextInt();
          }
          break;
        case 2:
          // mostrar funcion//
          for (int i = 0; i < coeficientes.length; i++) {
            System.out.print(" + " + coeficientes[i] + "x^" + i);
          }
          System.out.println("");
          break;
        case 3:
          // evaluar funcion//
          System.out.println("ingrese un valor para x");
          x = sc.nextInt();
          suma = 0;
          for (int i = 0; i < coeficientes.length; i++) {
            suma = suma + coeficientes[i] * Math.pow(x, i);
          }
          System.out.println("el resultado de la funcion es " + suma);

          break;
        case 4:
          // calcular y derivar//
          for (int i = 1; i < coeficientes.length; i++) {
            coeficientesDeDerivada[i - 1] = coeficientes[i] * i;

          }
          for (int i = 0; i < coeficientesDeDerivada.length; i++) {
            System.out.print(" + " + coeficientesDeDerivada[i] + "x^" + i);
          }
          System.out.println("");
          break;
        case 5:
          // evaluar derivada//
          System.out.println("ingrese un valor para x");
          x = sc.nextInt();
          suma = 0;
          for (int i = 0; i < coeficientesDeDerivada.length; i++) {
            suma = suma + coeficientesDeDerivada[i] * Math.pow(x, i);
          }
          System.out.println("el resultado de la funcion es " + suma);
          break;
      }
    }
  }
}
