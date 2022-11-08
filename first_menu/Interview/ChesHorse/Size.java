package Interview.ChesHorse;

public class Size {
  public int width = 0;
  public int height = 0;

  Size(int[] both) {
    if (both.length == 2) {
      this.width = both[0];
      this.height = both[1];
    }
    if (both.length != 2) {
      this.height = 0;
      this.width = 0;
    }
  }

  Size(int both) {
    this.height = both;
    this.width = both;
  }

  Size(int width, int height) {
    this.width = width;
    this.height = height;
  }

  Size() {
    this.height = 0;
    this.width = 0;
  }

}
