import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import exceptions.ErrorMessageException;
import org.junit.jupiter.api.Test;

public class LockerTest {

  @Test
  public void should_give_user_a_ticket_when_users_check_in_packages_given_locker_has_available_boxes()
      throws ErrorMessageException {
    //given
    Locker locker = new Locker(5);
    Package aPackage = new Package();

    //when
    Ticket ticket = locker.savePackage(aPackage);

    //then
    assertNotNull(ticket);
  }

  @Test
  public void should_not_give_user_a_ticket_when_users_check_in_packages_given_locker_has_available_boxes()
      throws ErrorMessageException {
    //given
    Locker locker = new Locker(0);
    Package aPackage = new Package();
    //when,then
    assertThrows(ErrorMessageException.class, () -> locker.savePackage(aPackage));
  }

  @Test
  public void should_give_package_back_when_user_use_ticket_given_user_has_a_valid_ticket()
      throws ErrorMessageException {
    //given
    Locker locker = new Locker(1);
    Package aPackage = new Package();
    Ticket ticket = locker.savePackage(aPackage);

    //when
    Package returnedPackage = locker.getPackage(ticket);

    //then
    assertEquals(System.identityHashCode(aPackage), System.identityHashCode(returnedPackage));
  }

  @Test
  public void should_throw_error_when_user_use_ticket_given_user_has_an_invalid_ticket()
      throws ErrorMessageException {
    //given
    Locker locker = new Locker(1);
    Package aPackage = new Package();
    Ticket realTicket = locker.savePackage(aPackage);
    Ticket fakeTicket = new Ticket();
    assertNotEquals(System.identityHashCode(fakeTicket), System.identityHashCode(realTicket));

    //when,then
    assertThrows(ErrorMessageException.class, () -> locker.getPackage(fakeTicket));
  }
}
