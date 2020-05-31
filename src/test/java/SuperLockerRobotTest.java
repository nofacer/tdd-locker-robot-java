import exceptions.ErrorMessageException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SuperLockerRobotTest {
  @Test
  void should_save_to_first_locker_and_give_a_ticket_when_user_save_package_given_first_locker_has_larger_vacancy_ratio_than_second()
          throws ErrorMessageException {
    //given
    List<Locker> lockers = new ArrayList<>();
    Locker locker1 = new Locker(2);
    locker1.setVacancyRatio(0.5);
    Locker locker2 = new Locker(3);
    locker2.setVacancyRatio(0.33);
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

  @Test
  void should_save_to_second_locker_and_give_a_ticket_when_user_save_package_given_first_locker_has_lower_vacancy_ratio_than_second()
          throws ErrorMessageException {
    //given
    List<Locker> lockers = new ArrayList<>();
    Locker locker1 = new Locker(4);
    locker1.setVacancyRatio(0.25);
    Locker locker2 = new Locker(3);
    locker2.setVacancyRatio(0.33);
    lockers.add(locker1);
    lockers.add(locker2);
    Package aPackage = new Package();

    SuperLockerRobot superLockerRobot = new SuperLockerRobot(lockers);

    //when
    Ticket ticket = superLockerRobot.savePackage(aPackage);

    //then
    assertNotNull(ticket);
    Locker locker = superLockerRobot.getLockerByTicket(ticket);
    assertEquals(System.identityHashCode(locker2), System.identityHashCode(locker));
  }

  @Test
  void should_give_a_ticket_when_user_save_package_given_two_lockers_have_same_vacancy_ratio()
          throws ErrorMessageException {
    //given
    List<Locker> lockers = new ArrayList<>();
    Locker locker1 = new Locker(2);
    locker1.setVacancyRatio(0.25);
    Locker locker2 = new Locker(4);
    locker2.setVacancyRatio(0.5);
    lockers.add(locker1);
    lockers.add(locker2);

    SuperLockerRobot superLockerRobot = new SuperLockerRobot(lockers);
    Package aPackage = new Package();

    //when
    Ticket ticket = superLockerRobot.savePackage(aPackage);

    //then
    assertNotNull(ticket);
  }

  @Test
  void should_throw_error_when_save_pacakge_given_all_lockers_are_full() throws ErrorMessageException {
    //given
    List<Locker> lockers = new ArrayList<>();
    Locker locker1 = new Locker(1);
    locker1.setVacancyRatio(0);
    Locker locker2 = new Locker(1);
    locker2.setVacancyRatio(0);
    lockers.add(locker1);
    lockers.add(locker2);
    SuperLockerRobot superLockerRobot = new SuperLockerRobot(lockers);
    Package aPackage = new Package();

    //when,then
    assertThrows(ErrorMessageException.class, () -> superLockerRobot.savePackage(aPackage));
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
    SuperLockerRobot robot = new SuperLockerRobot(lockers);
    Package aPackage = new Package();
    Ticket ticket = robot.savePackage(aPackage);

    //when
    Package returnedPackage = robot.getPackage(ticket);

    //then
    assertEquals(System.identityHashCode(aPackage), System.identityHashCode(returnedPackage));
  }

  @Test
  public void should_throw_error_when_user_use_ticket_given_user_has_a_fake_ticket()
          throws ErrorMessageException {
    //given
    List<Locker> lockers = new ArrayList<>();
    Locker locker1 = new Locker(5);
    Locker locker2 = new Locker(3);
    lockers.add(locker1);
    lockers.add(locker2);
    SuperLockerRobot robot = new SuperLockerRobot(lockers);
    Package aPackage = new Package();
    Ticket ticket = robot.savePackage(aPackage);
    Ticket fakeTicket = new Ticket();

    //when,then
    assertThrows(ErrorMessageException.class, () -> robot.getPackage(fakeTicket));
  }

  @Test
  public void should_throw_error_when_user_use_ticket_given_the_ticket_was_used_before()
          throws ErrorMessageException {
    //given
    List<Locker> lockers = new ArrayList<>();
    Locker locker1 = new Locker(5);
    Locker locker2 = new Locker(3);
    lockers.add(locker1);
    lockers.add(locker2);
    SuperLockerRobot robot = new SuperLockerRobot(lockers);
    Package aPackage = new Package();
    Ticket ticket = robot.savePackage(aPackage);
    robot.getPackage(ticket);

    //when,then
    assertThrows(ErrorMessageException.class, () -> robot.getPackage(ticket));
  }

}
