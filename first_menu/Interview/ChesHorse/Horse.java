package Interview.ChesHorse;

import java.util.ArrayList;

public class Horse {

  final static Position[] MOVEMENTS = {
      new Position(-2, 1, 0),
      /************************
       * ++++++++
       * ++++++++
       * ++++C+++
       * ++S+++++
       * ++++++++
       *************************/
      new Position(-1, 2, 1),
      /************************
       * ++++++++
       * ++++++++
       * ++++C+++
       * ++++++++
       * +++S++++
       *************************/
      new Position(1, 2, 2),
      /************************
       * ++++++++
       * ++++++++
       * ++++C+++
       * ++++++++
       * +++++S++
       *************************/
      new Position(2, 1, 3),
      /************************
       * ++++++++
       * ++++++++
       * ++++C+++
       * ++++++S+
       * ++++++++
       *************************/
      new Position(2, -1, 4),
      /************************
       * ++++++++
       * ++++++S+
       * ++++C+++
       * ++++++++
       * ++++++++
       *************************/
      new Position(1, -2, 5),
      /************************
       * +++++S++
       * ++++++++
       * ++++C+++
       * ++++++++
       * ++++++++
       *************************/
      new Position(-1, -2, 6),
      /************************
       * +++S++++
       * ++++++++
       * ++++C+++
       * ++++++++
       * ++++++++
       *************************/
      new Position(-2, -1, 7),
      /************************
       * ++++++++
       * ++S+++++
       * ++++C+++
       * ++++++++
       * ++++++++
       *************************/
  };

  public ArrayList<Position> movements = new ArrayList<Position>();

  public Position posibleMove(int index) {
    return movements.get(movements.size() - 1).move(MOVEMENTS[index]);
  }

  public Position removeLast () {
    movements.remove(movements.size() - 1);
    return movements.get(movements.size() - 1);
  }

  public Horse() {
    super();
  }

}
