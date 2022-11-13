package AstuciaNaval;

import java.util.Scanner;

public class AstuciaNaval {
  static int POSICION = 0, X = 1, Y = 2, ORIENTACION = 3;
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int[][] tablero = new int[6][6];
    int[][] barcos = {
        /*
         * P = posiciones, X = ubicacion en x, Y = ubicacion y, Orientacion = Vertical
         */
        /* {P, X, Y, O} */
        { 2, -1, -1, -1 },
        { 3, -1, -1, -1 },
        { 3, -1, -1, -1 },
        { 4, -1, -1, -1 },
    };

    mostrarTablero(tablero);

    tablero = ubicarBarcos(tablero, barcos);

    mostrarTablero(tablero);

  }

  static void mostrarTablero(int[][] tablero) {
    for (int x = 0; x < tablero.length; x++) {
      for (int y = 0; y < tablero[x].length; y++) {
        System.out.print(" " + tablero[x][y]);
      }
      System.out.println("");
    }
    System.out.println("");
  }

  static void menuPrincipal() {
    Scanner sc = new Scanner(System.in);
    String[] opcionesPrincipales = {
        "Reiniciar juego",
        "Atacar barco",
        "Cambiar barco",
        "Ver tablero original",
        "Salir"
    };
    int seleccion = crearMenu(opcionesPrincipales);
    System.out.println("Se Selecciono " + opcionesPrincipales[seleccion]);

  }

  /**
   * Este metodo crea el menu y retorna una opcion seleccionada.
   * 
   * @param opciones Este Arreglo tiene las opciones del menu
   * @param sc       La coneccion con la terinal para recibir
   *                 la opcion.
   * @return int El indice de la opcion seleccoinada
   *         por el usuario en el menu.
   */
  static int crearMenu(String[] opciones) {
    int seleccion = 0;

    do {
      for (int i = 0; i < opciones.length; i++) {
        System.out.println((i + 1) + ".  " + opciones[i]);
      }
      System.out.println("seleccione una opcion del menu");
      seleccion = sc.nextInt() - 1;
    } while (seleccion < 0 || seleccion >= opciones.length);

    return seleccion;
  }

  static int[] leerCoordenadas() {
    int[] posiciones = { -1, -1 };
    String entrada = sc.nextLine();
    String[] datos = entrada.split("&");
    posiciones[0] = Integer.parseInt(datos[0]);
    posiciones[0] = Integer.parseInt(datos[1]);
    return posiciones;
  }

  /**
   * este metodo ubica los barco dentro del tablero.
   * 
   * @param tablero Es la matriz que representa el tablero
   *                en donde se ubicaran los barcos.
   * @param sc      la conexion de la terminal para recibir la ubicacion.
   * @param barcos  Es un array que representa la informacionde los barcos.
   * @return int[][] tablero con los barcos ubicados.
   */
  static int[][] ubicarBarcos(int[][] tablero, int[][] barcos) {

    return tablero;
  }
}
