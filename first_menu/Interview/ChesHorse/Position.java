package Interview.ChesHorse;

public class Position {
  public int row = 0;
  public int column = 0;
  public int movement = 0;

  Position move(Position operation) {
    return new Position(operation.row + row, operation.column + column, operation.movement);
  }

  Position(int[] both) {
    if (both.length == 2) {
      this.row = both[0];
      this.column = both[1];
    }
    if (both.length != 2) {
      this.column = 0;
      this.row = 0;
    }
    this.movement = 0;
  }

  Position(int[] both, int movement) {
    if (both.length == 2) {
      this.row = both[0];
      this.column = both[1];
    }
    if (both.length != 2) {
      this.column = 0;
      this.row = 0;
    }
    this.movement = movement;
  }

  Position(int both) {
    this.column = both;
    this.row = both;
    this.movement = 0;
  }

  Position(int row, int column) {
    this.row = row;
    this.column = column;
    this.movement = 0;
  }

  Position(int row, int column, int movement) {
    this.row = row;
    this.column = column;
    this.movement = movement;
  }

  Position() {
    this.column = 0;
    this.row = 0;
    this.movement = 0;
  }

}
