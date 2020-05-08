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

  @Test
  public void should_be_from_1_to_n_when_get_the_label_of_box_given_a_locker_with_capacity_n() {
    Locker locker = new Locker(10);

    List<Box> boxes = locker.getBoxes();
    Box firstBox = boxes.get(0);
    Box lastBox = boxes.get(9);

    assertEquals(1, firstBox.getLabel());
    assertEquals(10, lastBox.getLabel());
  }
}
