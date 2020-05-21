import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Locker {

  private String name;
  private int capacity;
  private List<Box> boxes;

  public Locker(String name, int capacity) {
    this.name = name;
    this.capacity = capacity;
    boxes = new ArrayList<>();
    for (int i = 0; i < capacity; i++) {
      this.boxes.add(new Box(i + 1));
    }
  }

  public Ticket savePackage(Package aPackage) throws ErrorMessageException {
    Box box = findAvailableBox();
    if (box == null) {
      throw new ErrorMessageException("The locker is full");
    }
    return deliver(box, aPackage);
  }

  public boolean getPackage(Ticket ticket) {
    int boxIndex = ticket.getLabel() - 1;
    Box requestBox = this.boxes.get(boxIndex);
    requestBox.reset();
    return true;
  }

  private Ticket deliver(Box box, Package aPackage) {
    box.setAPackage(aPackage);
    return new Ticket(this.name, box.getLabel());
  }

  private Box findAvailableBox() {
    for (int i = 0; i < capacity; i++) {
      if (this.boxes.get(i).isAvailable()) {
        return this.boxes.get(i);
      }
    }
    return null;
  }
}
