package Interview.Chess.KnightTour;

import java.util.ArrayList;

public class Horse extends ArrayList<ArrayList<Number>> {

  Horse() {
    super();
  }

  public void move(int i, int j) {
    final ArrayList<Number> move = new ArrayList<Number>();
    move.add(i);
    move.add(j);
    this.add(move);
  }

  public boolean inTile(int position) {
    ArrayList<Number> last = this.get(this.size() - 1);
    int current = (int) last.get(0) + (int) last.get(1);
    return current == position;
  }

}
