package Kare;

import java.util.Scanner;

public class Matrix {
  public static void main(String[] args) {
    int[][] matriz = new int[4][4];
    Scanner sc = new Scanner(System.in);

    for (int i = 0; i < matriz.length; i++) {
      for (int j = 0; j < matriz[i].length; j++) {
        System.out.println("porfavor ingrese un valor para la posicion " + i + " " + j + ": ");
        matriz[i][j] = sc.nextInt();
      }
    }

    for (int i = 0; i < matriz.length; i++) {
      for (int j = 0; j < matriz[i].length; j++) {
        System.out.print(" " + matriz[i][j]);
      }
      System.out.println("");
    }

    System.out.println("que numero deseas buscar");
    int aBuscar = sc.nextInt();

    for (int i = 0; i < matriz.length; i++) {
      for (int j = 0; j < matriz[i].length; j++) {
        if (aBuscar == matriz[i][j]) {
          System.out.println("se encontro el numero en la posicion " + i + " " + j + ": " + aBuscar);
        }
      }
    }

    int suma = 0;
    for (int i = 0; i < matriz.length; i++) {
      for (int j = 0; j < matriz[i].length; j++) {
        suma = suma + matriz[i][j];
      }
    }
    float promedio = (float) suma / (float) (matriz.length * matriz.length);

    System.out.println("el promedio de la matriz es:" + promedio);

  }

}
