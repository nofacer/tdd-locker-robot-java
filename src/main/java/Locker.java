import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Locker {

  private int capacity;
  private List<Box> boxes;

  public Locker(int capacity) {
    boxes = new ArrayList<Box>();
    for (int i = 0; i < capacity; i++) {
      this.boxes.add(new Box());
    }
  }
}
