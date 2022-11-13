package Kare;

import java.util.Scanner;

public class MenorProcentaje {
  public static void main(String[] args) {
    int[] numeros = new int[6];
    Scanner sc = new Scanner(System.in);

    for (int i = 0; i < numeros.length; i++) {
      System.out.println("ingrese un numero");
      numeros[i] = sc.nextInt();
    }

    int suma = 0;
    for (int i = 0; i < numeros.length; i++) {
      suma = suma + numeros[i];
    }
    System.out.println("la suma del array es " + suma);
    System.out.println("y el promedio del array es " + suma / 6);

    int menor = numeros[0];

    for (int i = 0; i < numeros.length; i++) {
      if (numeros[0] < menor) {
        menor = numeros[0];
      }
    }
    System.out.println("el numero menor del array es: " + menor);
  }

}
