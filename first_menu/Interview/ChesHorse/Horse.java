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

  private int count = 0;

  public ArrayList<Position> movements = new ArrayList<Position>();

  public int number() {
    return count;
  }

  public void add(Position position) {
    movements.add(new Position(position));
    count += 1;
  }

  public void remove() {
    movements.remove(count - 1);
    count -= 1;
  }

  public Position last() {
    return new Position(movements.get(count - 1));
  }

  public Position posibleMove(int index) {
    return movements.get(count - 1).move(MOVEMENTS[index]);
  }

  public Position removeLast() {
    Position last = last();
    remove();
    return last;
  }

  public Horse() {
    super();
  }

}
