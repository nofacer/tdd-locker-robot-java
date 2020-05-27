import exceptions.ErrorMessageException;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class SuperLockerRobot  implements LockerRobot{
  private List<Locker> lockers;
  private Map<Integer, Locker> ticketLockerMap = new HashMap<>();

  public SuperLockerRobot(List<Locker> lockers) {
    this.lockers = lockers;
  }

  @Override
  public Ticket savePackage(Package aPackage) throws ErrorMessageException {
    Locker locker = getAvailableLocker(this.getLockers());
    Ticket ticket = locker.savePackage(aPackage);
    bindTicketWithLabel(ticket, locker);
    return ticket;
  }

  @Override
  public Package getPackage(Ticket ticket) throws ErrorMessageException {
    return null;
  }

  private Locker getAvailableLocker(List<Locker> lockers) throws ErrorMessageException {
    double tempVacancyRatio = 0;
    Locker tempLocker = null;
    for (Locker locker : lockers) {
      if (Double.compare(locker.getVacancyRatio(), tempVacancyRatio) > 0) {
        tempVacancyRatio = locker.getVacancyRatio();
        tempLocker = locker;
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

}
