import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import exceptions.ErrorMessageException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class SmartLockerRobotTest {

  @Test
  void should_save_to_first_locker_and_give_a_ticket_when_user_save_package_given_first_locker_capacity_larger_than_second()
      throws ErrorMessageException {
    //given
    List<Locker> lockers = new ArrayList<>();
    Locker locker1 = new Locker(5);
    Locker locker2 = new Locker(3);
    lockers.add(locker1);
    lockers.add(locker2);
    SmartLockerRobot smartLockerRobot = new SmartLockerRobot(lockers);
    Package aPackage = new Package();

    //when
    Ticket ticket = smartLockerRobot.savePackage(aPackage);

    //then
    assertNotNull(ticket);
    int lockerLabel = smartLockerRobot.getLockerLabelByTicket(ticket);
    assertEquals(0, lockerLabel);
  }

  @Test
  void should_save_to_second_locker_and_give_a_ticket_when_user_save_package_given_first_locker_capacity_less_than_second()
      throws ErrorMessageException {
    //given
    List<Locker> lockers = new ArrayList<>();
    Locker locker1 = new Locker(3);
    Locker locker2 = new Locker(5);
    lockers.add(locker1);
    lockers.add(locker2);
    SmartLockerRobot smartLockerRobot = new SmartLockerRobot(lockers);
    Package aPackage = new Package();

    //when
    Ticket ticket = smartLockerRobot.savePackage(aPackage);

    //then
    assertNotNull(ticket);
    int lockerLabel = smartLockerRobot.getLockerLabelByTicket(ticket);
    assertEquals(1, lockerLabel);
  }
}
