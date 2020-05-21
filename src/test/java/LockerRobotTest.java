
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import exceptions.ErrorMessageException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;


public class LockerRobotTest {

  @Test
  void should_save_to_first_locker_and_give_a_ticket_when_user_save_package_given_first_and_second_locker_is_not_full()
      throws ErrorMessageException {
    //given
    List<Locker> lockers = new ArrayList<>();
    Locker locker1 = new Locker(5);
    Locker locker2 = new Locker(3);
    lockers.add(locker1);
    lockers.add(locker2);
    LockerRobot lockerRobot = new LockerRobot(lockers);
    Package aPackage = new Package();
    //when
    Ticket ticket = lockerRobot.savePackageInOrder(aPackage);
    //then
    assertNotNull(ticket);
    int lockerLabel = lockerRobot.getTicketLockerMap().get(System.identityHashCode(ticket));
    assertEquals(0, lockerLabel);
  }

  @Test
  void should_save_to_second_locker_and_give_a_ticket_when_user_save_package_given_first_locker_is_full_and_second_locker_is_not_full()
      throws ErrorMessageException {
    //given
    List<Locker> lockers = new ArrayList<>();
    Locker locker1 = new Locker(0);
    Locker locker2 = new Locker(3);
    lockers.add(locker1);
    lockers.add(locker2);
    LockerRobot lockerRobot = new LockerRobot(lockers);
    Package aPackage = new Package();
    //when
    Ticket ticket = lockerRobot.savePackageInOrder(aPackage);
    //then
    assertNotNull(ticket);
    int lockerLabel = lockerRobot.getTicketLockerMap().get(System.identityHashCode(ticket));
    assertEquals(1, lockerLabel);
  }

  @Test
  void should_throw_error_when_save_pacakge_given_all_lockers_are_full()
      throws ErrorMessageException {
    //given
    List<Locker> lockers = new ArrayList<>();
    Locker locker1 = new Locker(0);
    Locker locker2 = new Locker(0);
    lockers.add(locker1);
    lockers.add(locker2);
    LockerRobot lockerRobot = new LockerRobot(lockers);
    Package aPackage = new Package();
    //when,then
    assertThrows(ErrorMessageException.class, () -> lockerRobot.savePackageInOrder(aPackage));
  }
//  @Test
//  public void should_not_give_user_a_ticket_when_users_check_in_packages_given_lockerRobot_cannot_find_available_boxes()
//      throws exceptions.ErrorMessageException {
//    LockerRobot robot = new LockerRobot(lockers);
//
//    robot.savePackageInOrder();
//    robot.savePackageInOrder();
//    robot.savePackageInOrder();
//    Ticket ticket = robot.savePackageInOrder();
//
//    assertNull(ticket);
//
//  }
//
//  @Test
//  public void should_open_related_box_when_user_get_package_given_a_user_has_a_valid_ticket()
//      throws exceptions.ErrorMessageException {
//    LockerRobot robot = new LockerRobot(lockers);
//    Ticket ticket = robot.savePackageInOrder();
//
//    boolean canGetBag = robot.getPackage(ticket);
//
//    assertTrue(canGetBag);
//  }
//
//  @Test
//  public void should_not_open_box_when_user_get_a_package_given_a_user_has_an_invalid_ticket() {
//    LockerRobot robot = new LockerRobot(lockers);
//    Ticket ticket = new Ticket("C", 2);
//
//    boolean canGetBag = robot.getPackage(ticket);
//
//    assertFalse(canGetBag);
//  }

}


