package Interview.Samuel;

/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
*/

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = 0;
    int mat[][] = new int[3][4];
    float af = 0, ac = 0, am = 0;

    /****************************
     * ingresas datos de usuario
     ****************************/
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 4; j++) {
        System.out.print("Ingrese datos de la pos " + i + ", " + j + ": ");
        mat[i][j] = sc.nextInt();
      }
    }

    /****************************
     * Imprime la matrix
     ****************************/
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 4; j++) {
        System.out.print(" " + mat[i][j]);
      }
      System.out.println(" ");
    }

    /****************************
     * Pide dato a buscar y busca
     ****************************/
    System.out.println("Ingrese dato que quiere buscar");
    n = sc.nextInt();
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 4; j++)
        if (mat[i][j] == n)
          System.out.println("Dato encontrado en la posision  " + i + "  " + j);

    /****************************
     * 
     ****************************/

    af = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 4; j++) {
        af = af + mat[i][j];
      }
    }
    System.out.println("El promedio de ls matriz es: " + (af / 12));
  }

}
