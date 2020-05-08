import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;

public class LockerTest {

  @Test
  public void should_has_boxes_same_amount_with_capacity_when_init_locker_given_certain_capacity() {
    Locker locker = new Locker(100);

    List<Box> boxes = locker.getBoxes();

    assertEquals(100, boxes.size());
  }
}
