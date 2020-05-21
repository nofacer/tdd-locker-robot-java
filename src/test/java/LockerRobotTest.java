
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import exceptions.ErrorMessageException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;


public class LockerRobotTest {

  private static List<Locker> lockers;
//* Given the first locker is not full, when user saves package, then the locker-robot should give user a ticket.


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

//  @Test
//  public void should_give_user_a_ticket_in_ordered_locker_when_users_check_in_packages_given_lockerRobot_finds_available_boxes()
//      throws exceptions.ErrorMessageException {
//    LockerRobot robot = new LockerRobot(lockers);
//
//    Ticket ticket = robot.savePackageInOrder();
//    Ticket ticket2 = robot.savePackageInOrder();
//
//    assertEquals("A", ticket.getLockerName());
//    assertEquals(1, ticket.getLabel());
//    //保证case独立，只test状态。不要连续操作，相互依赖
//    assertEquals("B", ticket2.getLockerName());
//    assertEquals(1, ticket2.getLabel());
//  }
//
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


