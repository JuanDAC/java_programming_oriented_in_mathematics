package pro;

import java.util.Scanner;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class Pro {
    public static void main(String[] args) {
        menu();
    }

    static int[][] matriz = new int[7][6];
    static int[] selecion = new int[2];

    public static void menu() {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println(
                    "¡Bienvenido al juego de Adivina el número!\n Por favor eliga una de las siguientes opciones. ");
            System.out.println("1.Reiniciar juego.");
            System.out.println("2.Adivinar número.");
            System.out.println("3.Mostrar número a adivinar.");
            System.out.println("4.Cambiar número a adivinar.");
            System.out.println("5.Salir.");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Usted ha seleccionado la opción número 1.");
                    System.out.println("El juego ha sido reiniciado");
                    matriz();
                    mostrarMatriz();
                    menu();
                    break;

                case 2:
                    System.out.println("Usted ha seleccionado la opción número 2.");
                    mostrarMatriz();
                    System.out.println("Ingrese un número entre 0 a 99");
                    adivinarnumero();
                    break;
                case 3:
                    System.out.println("Usted ha seleccionado la opción número 3.");
                    System.out.println("El número a adivinar es ");
                    break;
                case 4:
                    System.out.println("Usted ha seleccionado la opción número 4.");
                    System.out.println("El número actual es:");
                    System.out.println("Por favor ingrese el nuevo número:");
                    mostrarMatriz();
                    eligeElNumero();
                    break;
                case 5:
                    System.out.println("Usted ha seleccionado la opción número 5.");
                    System.out.println("Gracias por participar en el juego de Adivina el número.");
                    break;
                default:
                    System.out.println("Seleccione una opción del menu.");
            }
        } while (opcion != 5);
    }

    public static void eligeElNumero() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la ubicacion del numero a adivinar.");
        System.out.println("en x.");
        selecion[1] = scanner.nextInt();
        System.out.println("en y.");
        selecion[0] = scanner.nextInt();
        System.out.println("el numero que ustede seleciono para adivinar es: " + matriz[selecion[0]][selecion[1]]);
    }

    public static void adivinarnumero() {

        Scanner scanner = new Scanner(System.in);
        int numerojugador;
        int num = matriz[selecion[0]][selecion[1]];
        int contador = 10;
        int adivinanumero;
        // Obtención de número aleatorio

        System.out.println("Intenta adivinar un número de los que se mustran en la matriz. " + "Tienes 10 intentos.");
        // Realización del ciclo do-while
        do {
            System.out.println("Número contador: " + contador);
            System.out.print("Introduce el número que creas posible: ");
            numerojugador = scanner.nextInt();
            if (numerojugador > num) {
                System.out.println("El número que buscas es menor, te quedan " + (contador - 1) + " intentos: ");
            } else if (numerojugador < num) {
                System.out.println("El número que buscas es mayor, te quedan " + (contador - 1) + " intentos: ");
            } else {
                System.out.print("¡CORRECTO! " + num + " era el número que estabas " + "buscando, has necesitado "
                        + (10 - (contador - 1)) + " intentos.");
            }
            contador--;
        } while (numerojugador != num && contador > 0);
        if (contador == 0) {
            System.out.println("Has perdido El numero secreto era " + num);
        }
    }

    public static void matrizaleatoria() {
        Random aleatorio = new Random();
        int n;
        int[][] matriz = new int[7][6];
        // --Asignamos los numeros aleatorios
        Set<Integer> generados = new HashSet<>();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                int Numeroaleatorio;
                boolean generado = false;
                while (!generado) {
                    int numeroprovicional = aleatorio.nextInt(99 - 0) + 0;
                    if (!generados.contains(numeroprovicional)) {
                        generados.add(numeroprovicional);
                        Numeroaleatorio = numeroprovicional;
                        generado = true;
                        matriz[i][j] = Numeroaleatorio;
                    }
                }
            }
        }
        System.out.println("Matriz de numeros aleatorios \n");
        String imprimir = "";
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                imprimir = imprimir + "| " + matriz[i][j];
            }
            imprimir = imprimir + "|\n";
        }
        System.out.println(imprimir);
        System.out.println("Seleccione un numero que aparezca en la matriz");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < 7; i++)
            for (int j = 0; j < 6; j++)
                if (matriz[i][j] == n)
                    System.out.println("Dato encontrado en la posision  " + i + "  " + j);
        System.out.println("numero: " + n);
    }

    public static void matriz() {
        Random aleatorio = new Random();
        int n;
        // --Asignamos los numeros aleatorios
        Set<Integer> generados = new HashSet<>();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                int Numeroaleatorio;
                boolean generado = false;
                while (!generado) {
                    int numeroprovicional = aleatorio.nextInt(99 - 0) + 0;
                    if (!generados.contains(numeroprovicional)) {
                        generados.add(numeroprovicional);
                        Numeroaleatorio = numeroprovicional;
                        generado = true;
                        matriz[i][j] = Numeroaleatorio;

                    }

                }
            }
        }
    }

    static void mostrarMatriz() {
        String imprimir = "";
        System.out.println("Matriz de numeros aleatorios \n");
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                imprimir = imprimir + "| " + matriz[i][j];
            }
            imprimir = imprimir + "|\n";
        }
        System.out.println(imprimir);
    }
}
