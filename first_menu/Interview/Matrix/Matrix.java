package Interview.Matrix;

import java.util.Scanner;

interface MatrixHanlderMap {
  int run(int value, int i, int j);
}

interface MatrixHanlderEach {
  void run(int value, int i, int j);
}

interface MatrixHanlderFilter {
  boolean run(int value, int i, int j);
}

public class Matrix {

  public static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    int[][] matrix = new int[4][4];
    System.out.println("Ingresa los datos de la matrix:");
    matrix = map(
        matrix,
        (value, i, j) -> input.nextInt(),
        (value, i, j) -> System.out.print("Enter the number for the position [" + i + "][" + j + "]: "));

    System.out.println("La informacion es:");
    each(matrix,
        (value, i, j) -> System.out.print(value + ((j == 3) ? "\n" : " ")));

    System.out.print("Ingresa el numero a buscar: ");
    final int toseach = input.nextInt();
    where(matrix, (value, i, j) -> value == toseach,
        (value, i, j) -> System.out.println("The value " + value + " was found it at position [" + i + "][" + j + "]"));

  }

  public static void showMatrix(int[][] matrix) {
  }

  public static int[][] map(int[][] matrix, MatrixHanlderMap handler) {
    for (int i = 0; i < matrix.length; i++)
      for (int j = 0; j < matrix.length; j++)
        matrix[i][j] = handler.run(matrix[i][j], i, j);
    return matrix;
  }

  public static int[][] map(int[][] matrix, MatrixHanlderMap handler, MatrixHanlderEach action) {
    for (int i = 0; i < matrix.length; i++)
      for (int j = 0; j < matrix.length; j++) {
        action.run(matrix[i][j], i, j);
        matrix[i][j] = handler.run(matrix[i][j], i, j);
      }
    return matrix;
  }

  public static void each(int[][] matrix, MatrixHanlderEach handler) {
    for (int i = 0; i < matrix.length; i++)
      for (int j = 0; j < matrix.length; j++)
        handler.run(matrix[i][j], i, j);
  }

  public static void where(int[][] matrix, MatrixHanlderFilter premise, MatrixHanlderEach action) {
    for (int i = 0; i < matrix.length; i++)
      for (int j = 0; j < matrix.length; j++)
        if (premise.run(matrix[i][j], i, j))
          action.run(matrix[i][j], i, j);
  }

}
