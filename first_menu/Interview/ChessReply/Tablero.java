package Interview.ChessReply;

import java.util.Scanner;

public class Tablero {
  Tablero() {
    Scanner sc = new Scanner(System.in);
    int tablero[][] = new int[8][8];
    int movimiento[][] = new int[3][65];
    int jugada = 0, fila = 0, columna = 0, i = 0, j = 0, op = 0;
    final int row = 0, column = 1, move = 2;
    boolean estaDentroDelTablero = false;
    boolean laPosicionEstaLibre = false;
    boolean seAsignoPosicion = false;

    /************************
     * Move cases
     *************************/
    int casosDeMovimientos[][] = {
        { -2, 1 },
        /************************
         * ++++++++
         * ++++++++
         * ++++C+++
         * ++S+++++
         * ++++++++
         *************************/
        { -1, 2 },
        /************************
         * ++++++++
         * ++++++++
         * ++++C+++
         * ++++++++
         * +++S++++
         *************************/
        { 1, 2 },
        /************************
         * ++++++++
         * ++++++++
         * ++++C+++
         * ++++++++
         * +++++S++
         *************************/
        { 2, 1 },
        /************************
         * ++++++++
         * ++++++++
         * ++++C+++
         * ++++++S+
         * ++++++++
         *************************/
        { 2, -1 },
        /************************
         * ++++++++
         * ++++++S+
         * ++++C+++
         * ++++++++
         * ++++++++
         *************************/
        { 1, -2 },
        /************************
         * +++++S++
         * ++++++++
         * ++++C+++
         * ++++++++
         * ++++++++
         *************************/
        { -1, -2 },
        /************************
         * +++S++++
         * ++++++++
         * ++++C+++
         * ++++++++
         * ++++++++
         *************************/
        { -2, -1 },
        /************************
         * ++++++++
         * ++S+++++
         * ++++C+++
         * ++++++++
         * ++++++++
         *************************/
    };

    /************************
     * Enter data from user
     *************************/
    System.out.println("Ingrese la posición del caballo");
    System.out.print("Fila: ");
    fila = sc.nextInt();
    System.out.print("Columna: ");
    columna = sc.nextInt();

    /************************
     * Initialiation of position of horse
     *************************/
    tablero[fila][columna] = 1;
    movimiento[row][jugada] = fila;
    movimiento[column][jugada] = columna;
    movimiento[move][jugada] = -1;
    jugada = 1;

    /*****
     * DRY
     *****/

    while (jugada < 64) {
      seAsignoPosicion = false;
      for (; op < casosDeMovimientos.length; op++) {

        i = fila + casosDeMovimientos[op][0];
        j = columna + casosDeMovimientos[op][1];
        estaDentroDelTablero = i >= 0 && i < 8 && j >= 0 && j < 8;
        laPosicionEstaLibre = estaDentroDelTablero && tablero[i][j] == 0;

        if (estaDentroDelTablero && laPosicionEstaLibre) {
          fila = i;
          columna = j;
          movimiento[row][jugada] = fila;
          movimiento[column][jugada] = columna;
          movimiento[move][jugada] = op;
          tablero[fila][columna] = (jugada + 1);
          seAsignoPosicion = true;
          jugada++;
          break;
        }
      } // fin for
      if (!seAsignoPosicion /* ~false == true */) {
        jugada--;
        op = movimiento[move][jugada] + 1;
        fila = movimiento[row][jugada];
        columna = movimiento[column][jugada];
        tablero[fila][columna] = 0;
        /*
         * System.out.println("____________");
         * System.out.println("siguiente jugada:  " + jugada);
         * System.out.println("from op: " + op);
         * System.out.println("____________");
         */
      }
      if (seAsignoPosicion /* true == true */) {
        op = 0;
      }
    } // while
    for (int k = 0; k < 8; k++) {
      for (int l = 0; l < 8; l++)
        System.out.print("\t" + tablero[k][l]);
      System.out.println(" ");
      System.out.println(" ");
    }

    /**
     * for(int k=0;k<3;k++)
     * {
     * for(int l=0;l<65;l++)
     * System.out.print("\t\t"+movimiento[k][l]);
     * System.out.println(" ");
     * System.out.println(" ");
     * }
     */
  }
}