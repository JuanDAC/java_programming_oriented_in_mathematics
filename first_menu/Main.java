import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scannerConnection = new Scanner(System.in);
    String[] options = { "Load data", "Show data", "Addition and average", "Greater and minor", "Exit" };
    int selection = 0, addition = 0, greater = 0, minor = 0;
    float avarage = 0.0f;
    boolean isExit = false;
    int[] data = new int[5];

    System.out.println("By JuanDAC, Thanks for use my menu (^-^)/");
    System.out.println("Wellcome to my menu!");

    while (isExit == false) {

      /*--------------------------------------------------------------- */
      /* MENU and SELECT OPTION */
      /*--------------------------------------------------------------- */
      do {
        System.out.println("Here you could select bellow options");
        for (int i = 0; i < options.length; i++) {
          System.out.println(" " + (i + 1) + ": " + options[i]);
        }
        System.out.print("Please select any option with the number: ");
        selection = scannerConnection.nextInt() - 1;
      } while (selection < 0 || selection >= options.length);
      System.out.println("\n");
      /*--------------------------------------------------------------- */

      /*--------------------------------------------------------------- */
      /* Print the Selection option */
      /*--------------------------------------------------------------- */
      System.out.println("Your selection is " + options[selection] + "!!!");
      System.out.println("\n");
      /*--------------------------------------------------------------- */
      /* Load Data */
      /*--------------------------------------------------------------- */
      if (options[selection] == "Load data") {
        System.out.println("Please Enter bellow " + data.length + " numbers for storage. ^w^");
        for (int i = 0; i < data.length; i++) {
          System.out.print("Type your " + (i + 1) + " number here: ");
          data[i] = scannerConnection.nextInt();
        }
      }
      /*--------------------------------------------------------------- */
      /* Show data */
      /*--------------------------------------------------------------- */
      if (options[selection] == "Show data") {
        System.out.print("The data is: [");
        for (int i = 0; i < data.length; i++) {
          System.out.print(" " + data[i] + " ");
        }
        System.out.println("]");
      }
      /*--------------------------------------------------------------- */
      /* Addition and average */
      /*--------------------------------------------------------------- */
      if (options[selection] == "Addition and average") {
        for (int i = 0; i < data.length; i++) {
          addition += data[i];
        }
        avarage = addition / data.length;
        System.out.println("The addition is: " + addition);
        System.out.println("The avarage is: " + avarage);
      }
      /*--------------------------------------------------------------- */
      /* Greater and minor */
      /*--------------------------------------------------------------- */
      if (options[selection] == "Greater and minor") {
        greater = minor = data[0];
        for (int i = 0; i < data.length; i++) {
          if (data[i] > greater) {
            greater = data[i];
          }
          if (data[i] < minor) {
            minor = data[i];
          }
        }
        System.out.println("The minor is: " + minor);
        System.out.println("The greater is: " + greater);
      }

      /*--------------------------------------------------------------- */
      /* Exit */
      /*--------------------------------------------------------------- */
      isExit = options[selection] == "Exit";

      System.out.println("\nType Enter to continue");
      scannerConnection.nextLine();
      scannerConnection.nextLine();
      System.out.println("\n");
    }
    scannerConnection.close();
  }

}
