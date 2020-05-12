import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class LockerTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @After
  public void restoreStreams() {
    System.setOut(originalOut);
  }

  @Test
  public void should_give_ticket_when_deal_user_request_given_available_boxes() {
    Locker locker = new Locker(1, "A");

    Ticket ticket = locker.savePackage();

    assertNotNull(ticket);
    assertEquals(1, ticket.getLabel());
  }

  @Test
  public void should_print_success_message_and_empty_box_when_box_on_ticket_is_found() {
    Locker locker = new Locker(5, "A");
    locker.savePackage();
    Ticket ticket = locker.savePackage();
    Box box = locker.getBoxes().get(1);
    locker.getPackage(ticket);
    assertEquals("Success! Take your bag in box 2.\n", outContent.toString());
    assertNull(box.getTimestamp());
    assertTrue(box.isAvailable());
  }

  @Test
  public void should_pring_error_message_when_timestamp_is_not_same() {
    Locker locker = new Locker(5, "A");
    locker.savePackage();
    Ticket ticket = new Ticket(1, "Sat Jan 01 12:00:00 CST 2020");
    locker.getPackage(ticket);
    assertEquals("Error, the ticket is not valid\n", outContent.toString());
  }

}
