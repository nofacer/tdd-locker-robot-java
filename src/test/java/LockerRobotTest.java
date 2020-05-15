
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LockerRobotTest {
    private static List<Locker> lockers;

    @Before
    public void initLockers() {
      lockers = new ArrayList<>();
      Locker lockerA = new Locker("A",1);
      Locker lockerB = new Locker("B",2);
      lockers.add(lockerA);
      lockers.add(lockerB);
    }


    @Test
    public void should_give_user_a_ticket_in_ordered_locker_when_users_check_in_packages_given_lockerRobot_finds_available_boxes() {
      LockerRobot robot = new LockerRobot(lockers);

      Ticket ticket = robot.savePackageInOrder();
      Ticket ticket2 = robot.savePackageInOrder();

      assertEquals("A", ticket.getLockerName());
      assertEquals(1, ticket.getLabel());
      assertEquals("B", ticket2.getLockerName());
      assertEquals(1, ticket2.getLabel());
    }

    @Test
    public void should_not_give_user_a_ticket_when_users_check_in_packages_given_lockerRobot_cannot_find_available_boxes() {
      LockerRobot robot = new LockerRobot(lockers);

      robot.savePackageInOrder();
      robot.savePackageInOrder();
      robot.savePackageInOrder();
      Ticket ticket = robot.savePackageInOrder();

      assertNull(ticket);

    }

    @Test
    public void should_open_related_box_when_user_get_package_given_a_user_has_a_valid_ticket() {
      LockerRobot robot = new LockerRobot(lockers);
      Ticket ticket = robot.savePackageInOrder();

      boolean canGetBag = robot.getPackage(ticket);

      assertTrue(canGetBag);
    }

  @Test
  public void should_not_open_box_when_user_get_a_package_given_a_user_has_an_invalid_ticket() {
    LockerRobot robot = new LockerRobot(lockers);
    Ticket ticket = new Ticket("C", 2);

    boolean canGetBag = robot.getPackage(ticket);

    assertFalse(canGetBag);
  }

  }


