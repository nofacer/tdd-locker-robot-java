import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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

  @Test
  public void should_be_true_when_check_box_status_given_that_box_is_not_being_used() {
    Locker locker = new Locker(10, "Locker_A");

    Box box = locker.getBoxes().get(4);

    assertTrue(box.isAvailable());
  }

  @Test
  public void should_find_minimal_label_when_request_box_given_there_are_available_boxes() {
    Locker locker = new Locker(4, "A");
    Box box1 = locker.getBoxes().get(0);
    Box box4 = locker.getBoxes().get(3);
    locker.deliver(box1);
    locker.deliver(box4);

    Box availableBox = locker.findAvailableBox();

    assertEquals(2, availableBox.getLabel());
  }

  @Test
  public void should_find_null_when_request_box_given_there_are_not_available_boxes() {
    Locker locker = new Locker(4, "A");
    Box box1 = locker.getBoxes().get(0);
    Box box2 = locker.getBoxes().get(1);
    Box box3 = locker.getBoxes().get(2);
    Box box4 = locker.getBoxes().get(3);
    locker.deliver(box1);
    locker.deliver(box2);
    locker.deliver(box3);
    locker.deliver(box4);

    Box availableBox = locker.findAvailableBox();

    assertNull(availableBox);
  }

  @Test
  public void should_get_ticket_with_a_label_and_timestamp_when_deliver_a_box_to_user() {
    Locker locker = new Locker(4, "A");
    Box box = locker.getBoxes().get(3);

    Ticket ticket = locker.deliver(box);

    assertEquals(4, ticket.getLabel());
  }

  @Test
  public void should_has_timestamp_when_generate_a_ticket() {
    Locker locker = new Locker(4, "A");
    Box box = locker.getBoxes().get(3);

    Ticket ticket = locker.deliver(box);

    System.out.println(ticket.getTimestamp());
    assertNotNull(ticket.getTimestamp());
  }
}
