import lombok.Data;

@Data
public class Box {

  private int label;
  private boolean available;
  private Package aPackage;

  public Box(int label) {
    this.label = label;
    this.available = true;
  }

  public void reset() {
    this.available = true;
    this.aPackage = null;
  }
}

