package AstuciaNaval;

import java.util.Scanner;

public class AstuciaNaval {

  /**
   * Constantes
   */
  static int X = 0, Y = 1, ORIENTACION = 2, LOGITUD = 3;
  static int VERTICAL = 0, HORIZONTAL = 1;
  static int MOVIMIENTOS = 0, FALLOS = 1;
  static int[] puntaje = { 0, 0 };
  /**
   * Variables
   */
  static Scanner sc = new Scanner(System.in);
  static int[][] tablero = new int[6][6];
  /*
   * X = ubicacion en x
   * Y = ubicacion y
   * O = ORIENTACION = Vertical | horizontal
   * L = longitud
   */
  static int[][] barcos = {
      /* {X, Y, O, L} */
      { -1, -1, -1, 2, },
      { -1, -1, -1, 3, },
      { -1, -1, -1, 3, },
      { -1, -1, -1, 4, },
  };

  public static void main(String[] args) {
    reiniciarJuego("iniciado");
    menuPrincipal();
  }

  /**
   * Reiniciar el juego
   * 
   * @param tablero
   * @return
   */
  static void reiniciarJuego(String titulo) {
    barcos = limpiarBarcos();
    puntaje = limpiarPuntaje();
    tablero = limpiarTablero();
    System.out.println("El juego ha sido " + titulo + ".");
    mostrarTablero(tablero);
    barcos = leerPropiedadesDeBarcos(barcos);
  }

  static int[][] limpiarBarcos() {
    for (int i = 0; i < barcos.length; i++) {
      barcos[i][X] = -1;
      barcos[i][Y] = -1;
      barcos[i][ORIENTACION] = -1;
    }
    return barcos;
  }

  static int[] limpiarPuntaje() {
    puntaje[MOVIMIENTOS] = 0;
    puntaje[FALLOS] = 0;
    return puntaje;
  }

  /**
   * Methodo que limpia el tablero, asignar el numero 0 a todas las posiciones
   * 
   * @param tablero Matrix que representa el tablero
   * @return int[][] tablero Actualizado con todas las posiciones en 0
   */
  static int[][] limpiarTablero() {
    for (int y = 0; y < tablero.length; y++) {
      for (int x = 0; x < tablero[y].length; x++) {
        tablero[y][x] = 0;
      }
    }

    return tablero;
  }

  /**
   * Methodo que imprime el tablero en la terminal
   * 
   * @param tablero Matrix que representa el tablero
   */
  static void mostrarTablero(int[][] tablero) {
    for (int y = 0; y < tablero.length; y++) {
      for (int x = 0; x < tablero[y].length; x++) {
        System.out.print(tablero[y][x] + "\t");
      }
      System.out.println("");
    }
    System.out.println("");
  }

  static void menuPrincipal() {
    String[] opcionesPrincipales = {
        "Reiniciar juego",
        "Atacar barco",
        "Cambiar barco",
        "Ver tablero original",
        "Salir"
    };
    int seleccion = 0;

    do {
      seleccion = crearMenu(opcionesPrincipales);
      System.out.println("Opción " + (seleccion + 1) + ": " + opcionesPrincipales[seleccion]);
      seccion(opcionesPrincipales[seleccion]);
    } while (opcionesPrincipales[seleccion] != "Salir");
  }

  static boolean barcoSobreBarco(int[][] tableroIpotetico) {
    for (int y = 0; y < tableroIpotetico.length; y++) {
      for (int x = 0; x < tableroIpotetico[y].length; x++) {
        if (tableroIpotetico[y][x] > 1) {
          return true;
        }
      }
    }
    return false;
  }

  static void seccion(String option) {
    int[][] tableroConBarcos;

    switch (option) {
      case "Reiniciar juego":
        reiniciarJuego("reiniciado");
        break;
      case "Atacar barco":
        break;
      case "Cambiar barco":
        break;
      case "Ver tablero original":
        tableroConBarcos = ubicarBarcos();
        mostrarTablero(tableroConBarcos);
        break;
      case "Salir":
        System.out.println("Gracias por participar en el juego de Astucia Naval.");
        break;
      default:
        break;
    }

  }

  /**
   * Metodo que crea el menu y retorna una opcion seleccionada.
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
      System.out.println("Seleccione una opcion del menu.");
      seleccion = sc.nextInt() - 1;
    } while (seleccion < 0 || seleccion >= opciones.length);

    return seleccion;
  }

  /**
   * Metodo que optiene las cordenadas del usuario
   * 
   * @return int[] [X, Y] Array de dos posiciones que repesenta las
   *         coordenadas ingresadas por el usuario
   */
  static int[] leerCoordenadas() {
    /* posiciones = { X, Y } */
    int[] posiciones = { -1, -1 };
    String entrada = "";
    do {
      entrada = sc.nextLine();
      if (entrada.length() > 0 && (!entrada.contains("&") || entrada.contains("-"))) {
        System.out.println("Error: Formato no valido, intenta de nuevo.");
      }
    } while (!entrada.contains("&") || entrada.contains("-"));
    String[] datos = entrada.split("&");
    posiciones[X] = Integer.parseInt(datos[X]);
    posiciones[Y] = Integer.parseInt(datos[Y]);

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
  static int[][] leerPropiedadesDeBarcos(int[][] barcos) {
    String[] opcionesDeOrientacion = { "Vertical", "Horizontal" };
    int orientacion = 0;
    int longitud = 0;
    int[][] tableroIpotetico = new int[6][6];

    for (int i = 0; i < barcos.length; i++) {
      do {
        System.out.println("Ingresar posición inicial del barco de longitud " + barcos[i][LOGITUD] + ":");
        int[] coordenadas = leerCoordenadas();

        barcos[i][X] = coordenadas[X];
        barcos[i][Y] = coordenadas[Y];

        if (barcos[i][X] < 0
            || barcos[i][Y] < 0
            || barcos[i][X] >= tablero[0].length
            || barcos[i][Y] >= tablero.length) {
          System.out.println("Error: Barco fuera de los limites, intenta de nuevo.");
          continue;
        }

        System.out.println("Ingresar la orientacion del barco:");
        orientacion = crearMenu(opcionesDeOrientacion);
        barcos[i][ORIENTACION] = orientacion;
        longitud = barcos[i][LOGITUD];

        if ((orientacion == VERTICAL && barcos[i][Y] + longitud >= tablero.length)
            || (orientacion == HORIZONTAL && barcos[i][X] + longitud >= tablero[0].length)) {
          System.out.println("Error: barco fuera de los limites, intenta de nuevo.");
          continue;
        }

        tableroIpotetico = ubicarBarcos();
        mostrarTablero(tableroIpotetico);

        if (barcoSobreBarco(tableroIpotetico)) {
          System.out.println("Error: Barco sobre barco, intenta de nuevo.");
          continue;
        }

        break;
      } while (true);
    }
    return barcos;
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
  static int[][] ubicarBarcos() {
    int[][] tableroConBarcos = new int[6][6];
    int x = 0, y = 0, longitud = 0, orientacion = 0;
    for (int i = 0; i < barcos.length; i++) {
      x = barcos[i][X];
      y = barcos[i][Y];
      longitud = barcos[i][LOGITUD];
      orientacion = barcos[i][ORIENTACION];

      if (orientacion == VERTICAL) {
        for (int celda = 0; celda < longitud; celda++) {
          tableroConBarcos[y + celda][x] += 1;
        }
      }
      if (orientacion == HORIZONTAL) {
        for (int celda = 0; celda < longitud; celda++) {
          tableroConBarcos[y][x + celda] += 1;
        }
      }
    }

    return tableroConBarcos;
  }

}
