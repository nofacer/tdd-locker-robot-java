import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;
import org.junit.Test;

public class LockerTest {

  @Test
  public void should_has_n_boxes_when_get_number_of_boxes_given_locker_capacity_is_n() {
    Locker locker = new Locker(100, "A");

    List<Box> boxes = locker.getBoxes();

    assertEquals(100, boxes.size());
  }

  @Test
  public void should_be_from_1_to_n_when_get_the_label_of_box_given_a_locker_with_capacity_n() {
    Locker locker = new Locker(10, "A");

    List<Box> boxes = locker.getBoxes();
    Box firstBox = boxes.get(0);
    Box lastBox = boxes.get(9);

    assertEquals(1, firstBox.getLabel());
    assertEquals(10, lastBox.getLabel());
  }

  @Test
  public void should_has_a_unique_name() {
    Locker locker = new Locker(10, "Locker_A");

    String name = locker.getName();

    assertEquals("Locker_A", name);
  }

  @Test
  public void should_be_false_when_check_box_status_given_that_box_is_being_used() {
    Locker locker = new Locker(10, "Locker_A");

    Box box = locker.getBoxes().get(4);
    locker.deliver(box);

    assertFalse(box.isAvailable());
  }
}
