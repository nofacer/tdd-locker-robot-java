import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import exceptions.ErrorMessageException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class SmartLockerRobotTest {

  @Test
  void should_save_to_first_locker_and_give_a_ticket_when_user_save_package_given_first_locker_last_capacity_larger_than_second()
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
    Locker locker = smartLockerRobot.getLockerByTicket(ticket);
    assertEquals(System.identityHashCode(locker1), System.identityHashCode(locker));
  }

  @Test
  void should_save_to_second_locker_and_give_a_ticket_when_user_save_package_given_first_locker_last_capacity_less_than_second()
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
    Locker locker = smartLockerRobot.getLockerByTicket(ticket);
    assertEquals(System.identityHashCode(locker2), System.identityHashCode(locker));
  }

  @Test
  void should_give_a_ticket_when_user_save_package_given_first_locker_last_capacity_equal_to_second()
      throws ErrorMessageException {
    //given
    List<Locker> lockers = new ArrayList<>();
    Locker locker1 = new Locker(3);
    Locker locker2 = new Locker(3);
    lockers.add(locker1);
    lockers.add(locker2);
    SmartLockerRobot smartLockerRobot = new SmartLockerRobot(lockers);
    Package aPackage = new Package();

    //when
    Ticket ticket = smartLockerRobot.savePackage(aPackage);

    //then
    assertNotNull(ticket);
  }

  @Test
  void should_throw_error_when_save_pacakge_given_all_lockers_are_full() {
    //given
    List<Locker> lockers = new ArrayList<>();
    Locker locker1 = new Locker(0);
    Locker locker2 = new Locker(0);
    lockers.add(locker1);
    lockers.add(locker2);
    SmartLockerRobot smartLockerRobot = new SmartLockerRobot(lockers);
    Package aPackage = new Package();

    //when,then
    assertThrows(ErrorMessageException.class, () -> smartLockerRobot.savePackage(aPackage));
  }

  @Test
  public void should_give_package_back_when_user_use_ticket_given_user_has_a_valid_ticket()
      throws ErrorMessageException {
    //given
    List<Locker> lockers = new ArrayList<>();
    Locker locker1 = new Locker(5);
    Locker locker2 = new Locker(3);
    lockers.add(locker1);
    lockers.add(locker2);
    SmartLockerRobot robot = new SmartLockerRobot(lockers);
    Package aPackage = new Package();
    Ticket ticket = robot.savePackage(aPackage);

    //when
    Package returnedPackage = robot.getPackage(ticket);

    //then
    assertEquals(System.identityHashCode(aPackage), System.identityHashCode(returnedPackage));
  }

  @Test
  public void should_throw_error_when_user_use_ticket_given_user_has_an_invalid_ticket()
      throws ErrorMessageException {
    //given
    List<Locker> lockers = new ArrayList<>();
    Locker locker1 = new Locker(5);
    Locker locker2 = new Locker(3);
    lockers.add(locker1);
    lockers.add(locker2);
    SmartLockerRobot robot = new SmartLockerRobot(lockers);
    Package aPackage = new Package();
    Ticket ticket = robot.savePackage(aPackage);
    Ticket fakeTicket = new Ticket();

    //when,then
    assertThrows(ErrorMessageException.class, () -> robot.getPackage(fakeTicket));
  }
}
