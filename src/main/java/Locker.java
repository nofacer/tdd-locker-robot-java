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
    this.capacity = capacity;
    boxes = new ArrayList<>();
    for (int i = 0; i < capacity; i++) {
      this.boxes.add(new Box(i + 1));
    }
  }

  public Ticket deliver(Box box) {
    box.setAvailable(false);
    String timestamp = Validator.generateTimeStamp();
    box.setTimestamp(timestamp);
    return new Ticket(box.getLabel(), timestamp);
  }

  public Box findAvailableBox() {
    for (int i = 0; i < capacity; i++) {
      if (this.boxes.get(i).isAvailable()) {
        return this.boxes.get(i);
      }
    }
    return null;
  }

  public Ticket dealWithRequest() {
    Box box = findAvailableBox();
    if (box == null) {
      System.out.println("Sorry, this locker is full.");
      return null;
    }
    return deliver(box);
  }
}
