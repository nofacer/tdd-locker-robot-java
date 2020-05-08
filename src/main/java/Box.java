import lombok.Data;

@Data
public class Box {

  private int label;

  public Box(int label) {
    this.label = label;
  }
}
