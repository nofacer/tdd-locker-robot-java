import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Locker {

  private int capacity;
  private List<Box> boxes;
  private String name;

  public Locker(int capacity, String name) {
    this.name = name;
    boxes = new ArrayList<>();
    for (int i = 0; i < capacity; i++) {
      this.boxes.add(new Box(i + 1));
    }
  }
}
