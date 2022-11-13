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

    while (horse.number() < 45) {
      chessBoard.startMoves(index);
      position = chessBoard.nextMove();
      if (chessBoard.invalidMoves()) {
        chessBoard.removeLast();
        index = horse.last().movement + 1;
      }
      if (!chessBoard.invalidMoves()) {
        index = ChessBoard.restartMoves;
        chessBoard.push(position);
      }
    }
    chessBoard.show();
  }
}
