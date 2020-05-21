import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LockerTest {

  @Test
  public void should_give_user_a_ticket_when_users_check_in_packages_given_locker_has_available_boxes()
      throws ErrorMessageException {
    //given
    Locker locker = new Locker("A", 5);
    Package aPackage = new Package();

    Ticket ticket = locker.savePackage(aPackage);

    assertNotNull(ticket);
  }

  @Test
  public void should_not_give_user_a_ticket_when_users_check_in_packages_given_locker_has_available_boxes()
      throws ErrorMessageException {
    //given
    Locker locker = new Locker("A", 0);
    Package aPackage = new Package();
    //when,then
    assertThrows(ErrorMessageException.class, () -> locker.savePackage(aPackage));
  }

  @Test
  public void should_give_package_back_when_user_use_ticket_given_user_has_a_valid_ticket()
      throws ErrorMessageException {
    //given
    Locker locker = new Locker("A", 1);
    Package aPackage = new Package();
    Ticket ticket = locker.savePackage(aPackage);

    //when
    Package returnedPackage = locker.getPackage(ticket);

    //then
    assertEquals(aPackage, returnedPackage);
  }
}
