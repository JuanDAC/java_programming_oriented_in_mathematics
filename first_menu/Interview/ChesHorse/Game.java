package Interview.ChesHorse;

public class Game {
  public Input input = new Input();

  static public void banner() {

    final String title = ConsoleColors.WHITE +
        ",--.  ,--.                            ,--.            ,--.                                 ,--. \n" +
        "|  '--'  | ,---. ,--.--. ,---.  ,---. |  |,---.     ,-'  '-.,--.--. ,--,--.,--.  ,--.,---. |  | \n" +
        "|  .--.  || .-. ||  .--'(  .-' | .-. :`-'(  .-'     '-.  .-'|  .--'' ,-.  | \\  `'  /| .-. :|  | \n" +
        "|  |  |  |' '-' '|  |   .-'  `)\\   --.   .-'  `)      |  |  |  |   \\ '-'  |  \\    / \\   --.|  | \n" +
        "`--'  `--' `---' `--'   `----'  `----'   `----'       `--'  `--'    `--`--'   `--'   `----'`--' \n" +
        ConsoleColors.RESET;
    System.out.println(title);
  }

  Game() {
    banner();
    Size size = input.getSizeOfBoard();
    Position position = input.getPositionHorse();
    ChessBoard chessBoard = new ChessBoard(size);
    Horse horse = new Horse();
    chessBoard.push(horse, position);
    int index = 0;

    while (horse.movements.size() < chessBoard.maxMovements()) {
      chessBoard.startMoves(index);
      position = chessBoard.nextMove();
      if (chessBoard.invalidMoves()) {
        index = horse.removeLast().movement;
      }
      if (!chessBoard.invalidMoves()) {
        horse.movements.add(position);
        index = ChessBoard.restartMoves;
      }
      chessBoard.update();
    }
    chessBoard.show();
  }
}
