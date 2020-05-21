import lombok.Data;

@Data
public class Box {

  private int label;
  private boolean available;

  public Box(int label) {
    this.label = label;
    this.available = true;
  }

  public void reset() {
    this.available = true;
  }
}
