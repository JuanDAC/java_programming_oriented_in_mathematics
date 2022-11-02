package Interview.Chess.KnightTour;

import java.util.ArrayList;

public class Chessboard extends ArrayList<ArrayList<Boolean>> {
  private Horse horse;

  public Chessboard(int size, Horse horse) {
    super();
    initializeChessboard(size);
    this.horse = horse;
  }

  private void initializeChessboard(int size) {
    for (int i = 0; i < size; i++) {
      this.add(new ArrayList<Boolean>());
      for (int j = 0; j < size; j++) {
        this.get(i).add(false);
      }
    }
  }

  public void setPosition(ArrayList<Number> move) {
    int i = (int) move.get(0), j = (int) move.get(1);
    this.get(i).set(j, true);
  }

  /*
   * TODO: traer el ultimo definido en el horse;
   * public void move(i, j) {
   * this.get(i)
   * }
   */

  private String tile(boolean value, int position) {
    String wasIn = value ? "+" : " ";
    if (this.horse.inTile(position))
      return ConsoleColors.PURPLE_BOLD + "[$]" + ConsoleColors.RESET;
    if (position % 2 == 0)
      return ConsoleColors.BLACK + "[" + wasIn + "]" + ConsoleColors.RESET;
    return ConsoleColors.WHITE + "[" + wasIn + "]" + ConsoleColors.RESET;
  }

  public void show() {
    int size = this.size();
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        boolean value = this.get(i).get(j);
        System.out.print(tile(value, i + j));
      }
      System.out.print("\n");
    }

  }

}
