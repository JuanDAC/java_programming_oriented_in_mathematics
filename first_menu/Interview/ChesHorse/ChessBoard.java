package Interview.ChesHorse;

import java.util.ArrayList;

public class ChessBoard extends ArrayList<ArrayList<Number>> {
  Horse horse;
  Size size;
  int index = 0;
  static public final int restartMoves = 0;

  int maxMovements() {
    return (size.height * size.width) - 1;
  }

  public void startMoves(int index) {
    this.index = index;
  }

  public Position nextMove() {
    Position move;
    do {
      move = horse.posibleMove(index++);
    } while (index < Horse.MOVEMENTS.length && !cellIsEnabled(move));
    return move;
  }

  public boolean cellIsEnabled(Position move) {
    return (true &&
        move.row >= 0 &&
        move.column >= 0 &&
        move.row < size.width &&
        move.column < size.height &&
        (int) get(move.row).get(move.column) == 0);

  }

  public boolean invalidMoves() {
    return index >= Horse.MOVEMENTS.length;
  }

  public void reset() {
    clear();
    for (int row = 0; row < size.width; row++) {
      add(new ArrayList<Number>());
      for (int column = 0; column < size.height; column++)
        get(row).add(0);
    }
  }

  public ChessBoard(Size size) {
    super();
    this.size = size;
    reset();
  }

  public void push(Horse horse, Position initial) {
    horse.movements.add(initial);
    this.horse = horse;
    update();
  }

  public void update() {
    reset();
    int i = 1;
    for (Position movement : this.horse.movements) {
      get(movement.row).set(movement.column, i);
      i++;
    }
  }

  private String tile(int value, int position, int height, int floor) {
    String wasIn = "  ";
    if (height > 1 && height % 2 == 0) {
      throw new Error("Height should odd");
    }
    if (height == 1 || (height > 1 && floor == (int) ((height - 1) / 2))) {
      wasIn = value < 10 ? " " + value : "" + value;
    }
    /*
     * if (this.horse.inTile(position))
     * return ConsoleColors.PURPLE_BOLD + "[$]" + ConsoleColors.RESET;
     */
    if (position % 2 == 0)
      return ConsoleColors.BLACK_BACKGROUND + "  " + wasIn + "  " + ConsoleColors.RESET;
    return ConsoleColors.WHITE_BACKGROUND + "  " + wasIn + "  " + ConsoleColors.RESET;
  }

  public void show() {
    int size = this.size();
    int height = 3;
    for (int i = 0; i < size; i++) {
      for (int floor = 0; floor < height; floor++) {
        for (int j = 0; j < size; j++) {
          int value = (int) get(i).get(j);
          System.out.print(tile(value, i + j, height, floor));
        }
        System.out.print("\n");
      }
    }
  }

}
