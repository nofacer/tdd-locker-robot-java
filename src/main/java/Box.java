import lombok.Data;

@Data
public class Box {

  private int label;
  private boolean available;
  private String timestamp;

  public Box(int label) {
    this.label = label;
    this.available = true;
  }
}
