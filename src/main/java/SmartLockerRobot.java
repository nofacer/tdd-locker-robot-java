import exceptions.ErrorMessageException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class SmartLockerRobot implements LockerRobot {
  private List<Locker> lockers;
  private Map<Integer, Locker> ticketLockerMap = new HashMap<>();

  public SmartLockerRobot(List<Locker> lockers) {
      this.lockers = lockers;
  }

  @Override
  public Ticket savePackage(Package aPackage) throws exceptions.ErrorMessageException {
    Locker locker = getAvailableLocker(this.getLockers());
    Ticket ticket = locker.savePackage(aPackage);
    bindTicketWithLabel(ticket, locker);
    return ticket;
  }

  @Override
  public Package getPackage(Ticket ticket) throws ErrorMessageException {
    Package aPackage = null;
    Locker locker = this.ticketLockerMap.get(System.identityHashCode(ticket));
    if (locker == null) {
      throw new ErrorMessageException("The ticket is invalid");
    } else {
      aPackage = locker.getPackage(ticket);
      unbindTicketWithLabel(ticket);
    }
    return aPackage;
  }

  private Locker getAvailableLocker(List<Locker> lockers) throws ErrorMessageException {
    int tempCapacity = 0;
    Locker tempLocker = null;
    int idx = 0;
    for (Locker locker : lockers) {
      if (locker.getCapacity() > tempCapacity) {
        tempCapacity = locker.getCapacity();
        tempLocker = locker;
        idx++;
      }
    }
    if (tempLocker == null) {
      throw new ErrorMessageException("All lockers are full");
    }
    return tempLocker;
  }

  public Locker getLockerByTicket(Ticket ticket) {
    return this.ticketLockerMap.get(System.identityHashCode(ticket));
  }

  private void bindTicketWithLabel(Ticket ticket, Locker locker) {
    this.getTicketLockerMap().put(System.identityHashCode(ticket), locker);
  }

  private void unbindTicketWithLabel(Ticket ticket) {
    this.getTicketLockerMap().remove(System.identityHashCode(ticket));
  }

}
