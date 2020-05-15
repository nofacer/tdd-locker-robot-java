import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class LockerTest {

  @Test
  public void should_give_user_a_ticket_when_users_check_in_packages_given_locker_has_available_boxes() {
    Locker locker = new Locker("A", 5);

    Ticket ticket = locker.savePackage();

    assertNotNull(ticket);
  }

  @Test
  public void should_not_give_user_a_ticket_when_users_check_in_packages_given_locker_has_available_boxes() {
    Locker locker = new Locker("A",0);

    Ticket ticket = locker.savePackage();
    System.out.println(ticket);
    assertNull(ticket);
  }

  @Test
  public void should_open_related_box_when_user_user_a_ticket_given_a_user_has_a_ticket() {
    Locker locker = new Locker("A",5);
    Ticket ticket = locker.savePackage();

    boolean getBagSuccess= locker.getPackage(ticket);

    assertTrue(getBagSuccess);
  }
}
