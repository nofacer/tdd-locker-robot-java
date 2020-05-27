import exceptions.ErrorMessageException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SuperLockerRobotTest {
  @Test
  void should_save_to_first_locker_and_give_a_ticket_when_user_save_package_given_first_locker_has_larger_vacancy_ratio_than_second()
          throws ErrorMessageException {
    //given
    List<Locker> lockers = new ArrayList<>();
    Locker locker1 = new Locker(2);
    locker1.savePackage(new Package());
    Locker locker2 = new Locker(3);
    locker2.savePackage(new Package());
    locker2.savePackage(new Package());
    lockers.add(locker1);
    lockers.add(locker2);

    SuperLockerRobot superLockerRobot = new SuperLockerRobot(lockers);
    Package aPackage = new Package();

    //when
    Ticket ticket = superLockerRobot.savePackage(aPackage);

    //then
    assertNotNull(ticket);
    Locker locker = superLockerRobot.getLockerByTicket(ticket);
    assertEquals(System.identityHashCode(locker1), System.identityHashCode(locker));
  }
}
